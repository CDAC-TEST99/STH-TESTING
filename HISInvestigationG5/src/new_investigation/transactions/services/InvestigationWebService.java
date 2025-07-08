package new_investigation.transactions.services;



import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.json.JSONObject;

import hisglobal.utility.HisUtil;
import new_investigation.transactions.dao.NEWOfflineResultEntryServiceDAO;



@Path("/InvestigationWebService")
public class InvestigationWebService  {
	
	
	@GET
	@Path("/test")
	@Produces({ MediaType.TEXT_PLAIN })
	public String test() {
		//System.out.println("EMMSComplaintDataWebService :: test");

		return "service is working";
	}
	
	@POST
	@Path("/getOfflineLabTestData")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response  getOfflineLabTestData(String filters ) {
	
		JSONObject objJson=new JSONObject();
		JSONObject objFilterJson=null;
		
			try {
			objFilterJson=new JSONObject(filters);
			}catch(Exception e) {
				return Response
		                .status(Response.Status.BAD_REQUEST)
		                .entity(
		                String.format("please provide valid filters for getting data!"))
		                .build();
			}
			if(objFilterJson.length()==0) {
				return Response
		                .status(Response.Status.BAD_REQUEST)
		                .entity(
		                String.format("please provide valid filters for getting data!"))
		                .build();
			}
			if(!objFilterJson.has("patCrno")) {
				return Response
		                .status(Response.Status.BAD_REQUEST)
		                .entity(
		                String.format("patCrno is required!"))
		                .build();
			}
			if(!objFilterJson.has("patEpisodeCode")) {
				return Response
		                .status(Response.Status.BAD_REQUEST)
		                .entity(
		                String.format("patEpisodeCode is required!"))
		                .build();
			}
			if(!objFilterJson.has("patEpisodeVisitNo")) {
				return Response
		                .status(Response.Status.BAD_REQUEST)
		                .entity(
		                String.format("patEpisodeVisitNo is required!"))
		                .build();
			}
			if(!objFilterJson.has("hospitalCode")) {
				return Response
		                .status(Response.Status.BAD_REQUEST)
		                .entity(
		                String.format("hospitalCode is required!"))
		                .build();
			}
			
		
		
		try {
			NEWOfflineResultEntryServiceDAO objNEWOfflineResultEntryServiceDAO= new NEWOfflineResultEntryServiceDAO();
				String str=objNEWOfflineResultEntryServiceDAO.getOfflineLabTestData(objFilterJson);
					
				return Response.ok(str).build();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return Response
	                .status(Response.Status.BAD_REQUEST)
	                .entity(
	                String.format("Problem while getting service details"))
	                .build();
		}		
        

	}
	
	
	@GET
	@Path("/getOffileResultEntryReport/{reportURL}")
	@Produces(MediaType.MULTIPART_FORM_DATA)
	//public Response investigation_report_offline(@QueryParam("reportURL") String reportURL) {
	public Response investigation_report_offline(@PathParam("reportURL") String reportURL) {
		if (reportURL.isEmpty()) {
			return Response.serverError().build();
		} else {
			
			String dataReport="";
			try {
				dataReport = downloadFileFromFTP(reportURL);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (dataReport != null)
				return Response.ok(dataReport, MediaType.MULTIPART_FORM_DATA).build();
			else
				return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	
public  String downloadFileFromFTP(  String strFileName)throws Exception  {
	String ReportData = "";
	InputStream io = null;
	 FTPClient ftp = null;
	 byte[] byteArr = null;
	try {
				
		  ftp = new FTPClient();  
		  
	 	  System.out.println("ftp connecting to "+HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL").split("@")[1]);
	 	  System.out.println("with credentials : "+HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_USERNAME")+" & "+HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_PASSWORD"));
		  
		  ftp.connect(HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL").split("@")[1]);
          ftp.login(HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_USERNAME"), HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_PASSWORD"));
          ftp.setFileType(FTP.BINARY_FILE_TYPE);
		  String filepath=HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_FILEPATH")  +strFileName; 
		  io = ftp.retrieveFileStream(filepath);
		 
	 
		
		int read = 0;
		byteArr = IOUtils.toByteArray(io);
		if (byteArr != null) {
			ReportData = byteArr.toString();
			ReportData = DatatypeConverter.printBase64Binary(byteArr);
		}
		
		

	} catch (Exception e) {
		throw e;
	} finally {

		if(io != null){
			io.close();
			io = null;
		}
		 
        
		if(ftp !=null) {
			  ftp.logout();
			  ftp = null;
		}
		
		 
	}
	return ReportData; 
}


}
