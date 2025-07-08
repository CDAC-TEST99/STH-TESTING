package new_opd.transaction.controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import redisCache.RedisPatQueueList;

 
public class SSEServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private static boolean isRedisException = false;
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2000); // Shared scheduler
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");

        AsyncContext asyncContext = request.startAsync();
        asyncContext.setTimeout(0); // 5 minutes timeout
        
     // Add an AsyncListener to handle client disconnection
        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent event) throws IOException {
                System.out.println("Client disconnected: onComplete");
                asyncContext.complete(); // End the async context to release resources
                scheduler.shutdown(); // Clean up the scheduler
            }

            @Override
            public void onTimeout(AsyncEvent event) throws IOException {
                System.out.println("Connection timed out.");
                asyncContext.complete(); // End the async context to release resources
                scheduler.shutdown(); // Clean up the scheduler
            }

            @Override
            public void onError(AsyncEvent event) throws IOException {
                System.out.println("Error occurred: " + event.getThrowable());
                asyncContext.complete(); // End the async context to release resources
                scheduler.shutdown(); // Clean up the scheduler
            }

            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {
                // No-op
            }
        });

        
          
        scheduler.scheduleAtFixedRate(() -> {
            try {
                String encdata = request.getParameter("encdata");
                if (encdata != null) {
                    try (PrintWriter out = asyncContext.getResponse().getWriter()) {
                        processRequestData(encdata, getCurrentDate(), out);
                        out.flush(); // Ensure data is pushed to the client
                    }
                }
            } catch (IOException e) {
                logError("Error in asynchronous processing", e);
                asyncContext.complete(); // End the async context to release resources
                scheduler.shutdown(); // Clean up the scheduler
            }
        }, 0, 10, TimeUnit.SECONDS); // Run every  seconds
    }


    private void processRequestData(String encdata, String currentDate, PrintWriter out) throws IOException {
        try {
            String jsonData = new String(Base64.getDecoder().decode(encdata));
            JSONArray objarrResponse = new JSONArray();
            JSONArray objarr = new JSONArray(jsonData);

            for (int i = 0; i < objarr.length(); i++) {
                JSONObject obj = objarr.getJSONObject(i);
                String key = buildRedisKey(obj, currentDate);
                String queueData = getQueueData(key);

                obj.put("queueNoJson", queueData);
                objarrResponse.put(obj);
            }

            out.write("data: " + objarrResponse + "\n\n");
            out.flush();

        } catch (Exception e) {
            logError("Error processing request data", e);
            throw new IOException(e);
        }
    }

    private String buildRedisKey(JSONObject obj, String currentDate) {
        String departmentUnitCode = obj.optString("departmentunitcode");
        String hospitalCode = obj.optString("hospitalCode");
        return "qms_" + hospitalCode + "_" + departmentUnitCode + "_" + currentDate;
    }

    private String getQueueData(String key) {
        try {
            return isRedisException ? "{}" : RedisPatQueueList.getPatientQueueList(key);
        } catch (Exception e) {
            isRedisException = true;
            logError("Redis server not working", e);
            return "{}";
        }
    }

    public static void addDataForDisplayBoard(String hospitalCode, String deptUnitCode, String queueJsonData) {
        String currentDate = getCurrentDate();
        String key = "qms_" + hospitalCode + "_" + deptUnitCode + "_" + currentDate;

        try {
            if (!isRedisException) {
                RedisPatQueueList.putPatientQueueList(key, queueJsonData);
            }
        } catch (Exception e) {
            isRedisException = true;
            logError("Redis server not working", e);
        }
    }

    public static void addDataForSMS(String hospitalCode, String deptUnitCode, String queueJsonData) {
        String currentDate = getCurrentDate();
        String key = "smsqueue_" + hospitalCode + "_" + deptUnitCode + "_" + currentDate;

        RedisPatQueueList.putPatientQueueList(key, queueJsonData);
    }

    public static String getCurrentDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT));
    }

    private static void logError(String message, Exception e) {
        System.err.println(message);
        e.printStackTrace();
    }
}