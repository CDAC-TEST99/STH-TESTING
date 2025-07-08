package thirdpartyservices.opengovdata;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import hisglobal.utility.Usefulmethods;

@Path("/ogd/v1/details")
public class OpenGovData {
	
	
	@POST
	@Path("/gettotalBenRegdiffCity")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response gettotalBenRegdiffCity(String filters) {  System.out.println("test 1");

	      JSONObject objFilterJson;
	      JSONObject responseJson = new JSONObject();
	      JSONObject objResponse = new JSONObject();
	      LocalDateTime currentDateTime = LocalDateTime.now();
	      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String currentTimestamp = currentDateTime.format(formatter);
			JSONObject result = new JSONObject();
			
	    try {
	        // Parse the incoming string to JSON (safe even if it's "{}")
	        if (filters != null && !filters.trim().isEmpty()) {
	            objFilterJson = new JSONObject(filters);
	        } else {
	            objFilterJson = new JSONObject(); // empty JSON
	        }

	        System.out.println("test api----" + objFilterJson.length());

	        if (objFilterJson.length() == 0) {
	            objFilterJson = null; // set to null so filter is not used later
	        }
	        
	        
	     // Instantiate Usefulmethods object to call the external service
	     			Usefulmethods objUsefulmethods = new Usefulmethods();
	     			String strServiceName = "service/toalbenregindiffcities";

	     			// Call the service and get the response
	     			objResponse = objUsefulmethods.callService(objFilterJson, strServiceName);
	     			
	     			
	     			if (objResponse != null) {
	     				
	     				 System.out.println("objResponse>>>>> " + objResponse);

	     			    JSONArray dataArray = objResponse.optJSONArray("data");

	     			    if (dataArray != null && dataArray.length() > 0) {

	     			        JSONArray apiDetailsList = new JSONArray(); // this is your single array

	     			        for (int i = 0; i < dataArray.length(); i++) {

	     			            JSONObject dataObject = dataArray.optJSONObject(i);

	     			            if (dataObject != null) {
	     			                JSONObject apiDetails = new JSONObject();

	     			                String CityName = dataObject.optString("cityname");
	     			                String WellnessCentreName = dataObject.optString("WC");
	     			                String CardType = dataObject.optString("Card Name");
	     			                String Count = dataObject.optString("Total");

	     			                apiDetails.put("CityName", CityName);
	     			                apiDetails.put("WellnessCentreName", WellnessCentreName);
	     			                apiDetails.put("CardType", CardType);
	     			                apiDetails.put("Count", Count);
	     			                apiDetails.put("apiVersion", "v1");
	     			                apiDetails.put("statusCode", "S");
	     			                apiDetails.put("message", "success");
	     			                apiDetails.put("timeStamp", currentTimestamp);

	     			                apiDetailsList.put(apiDetails); // add this object to array
	     			            }
	     			        }

	     			        result.put("apiDetails", apiDetailsList); // put the array in result
	     			    }
	     			}else {
	     				 JSONObject apiDetails = new JSONObject();
	     				apiDetails.put("apiVersion", "v1");
						apiDetails.put("timeStamp", currentTimestamp);
						apiDetails.put("statusCode", "F");
						apiDetails.put("message", "failed");
						result.put("result", "null");
						result.put("apiDetails", apiDetails);
						System.out.println("No valid data object found in the 'data' array.");
	     			}

	     			return Response.ok(result.toString()).build();

	    } catch (Exception e) {
	    	e.printStackTrace();

			// Return a response with an error status
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Problem in service!").build();

	    }

		
		
		
		
	}
	
	
	
	@POST
	@Path("/gettotaldiagnosticenters")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response gettotaldiagnosticenters(String filters) {  System.out.println("test 1");

    JSONObject objFilterJson;
    JSONObject responseJson = new JSONObject();
    JSONObject objResponse = new JSONObject();
    JSONObject apiDetails = new JSONObject();
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String currentTimestamp = currentDateTime.format(formatter);
		JSONObject result = new JSONObject();
  try {
      // Parse the incoming string to JSON (safe even if it's "{}")
      if (filters != null && !filters.trim().isEmpty()) {
          objFilterJson = new JSONObject(filters);
      } else {
          objFilterJson = new JSONObject(); // empty JSON
      }

      System.out.println("test api----" + objFilterJson.length());

      if (objFilterJson.length() == 0) {
          objFilterJson = null; // set to null so filter is not used later
      }
      
      
   // Instantiate Usefulmethods object to call the external service
   			Usefulmethods objUsefulmethods = new Usefulmethods();
   			String strServiceName = "service/totaldiagnosticenters";

   			// Call the service and get the response
   			objResponse = objUsefulmethods.callService(objFilterJson, strServiceName);
   			
   			
   			if (objResponse != null) {
   				System.out.println("objResponse>>>>> " + objResponse);
   				
   				JSONArray dataArray = objResponse.optJSONArray("data");
   				
   				if (dataArray != null && dataArray.length() > 0) {
   					
   					
   					for (int i = 0; i < dataArray.length(); i++) {
   						
   						JSONObject dataObject = dataArray.optJSONObject(i);
   						
   						if (dataObject != null) {
   				
   				String CityName = dataObject.optString("CityName");
					String total_beneficiaries = dataObject.optString("total_beneficiaries");
					
   				
   				apiDetails.put("CityName", CityName);
   				apiDetails.put("total_beneficiaries", total_beneficiaries);
   				apiDetails.put("apiVersion", "v1");
					apiDetails.put("timeStamp", currentTimestamp);
					apiDetails.put("statusCode", "S");
					apiDetails.put("message", "Success");
					result.put("apiDetails", apiDetails);
					
					
   						}
   					}

   				}
   			}else {
   				
   				apiDetails.put("apiVersion", "v1");
					apiDetails.put("timeStamp", currentTimestamp);
					apiDetails.put("statusCode", "F");
					apiDetails.put("message", "failed");
					result.put("result", "null");
					result.put("apiDetails", apiDetails);
					System.out.println("No valid data object found in the 'data' array.");
   			}

   			return Response.ok(result.toString()).build();

  } catch (Exception e) {
  	e.printStackTrace();

		// Return a response with an error status
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Problem in service!").build();

  }

	
	
	
	

	}

	
	
	@POST
	@Path("/gettotalplasticardprint")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response gettotalplasticardprint(String filters) {  System.out.println("test 1");

    JSONObject objFilterJson;
    JSONObject responseJson = new JSONObject();
    JSONObject objResponse = new JSONObject();
    JSONObject apiDetails = new JSONObject();
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String currentTimestamp = currentDateTime.format(formatter);
		JSONObject result = new JSONObject();
  try {
      // Parse the incoming string to JSON (safe even if it's "{}")
      if (filters != null && !filters.trim().isEmpty()) {
          objFilterJson = new JSONObject(filters);
      } else {
          objFilterJson = new JSONObject(); // empty JSON
      }

      System.out.println("test api----" + objFilterJson.length());

      if (objFilterJson.length() == 0) {
          objFilterJson = null; // set to null so filter is not used later
      }
      
      
   // Instantiate Usefulmethods object to call the external service
   			Usefulmethods objUsefulmethods = new Usefulmethods();
   			String strServiceName = "service/totalplasticardprint";

   			// Call the service and get the response
   			objResponse = objUsefulmethods.callService(objFilterJson, strServiceName);
   			
   			
   			if (objResponse != null) {
   				System.out.println("objResponse>>>>> " + objResponse);
   				
   				JSONArray dataArray = objResponse.optJSONArray("data");
   				
   				if (dataArray != null && dataArray.length() > 0) {
   					
   					
   					for (int i = 0; i < dataArray.length(); i++) {
   						
   						JSONObject dataObject = dataArray.optJSONObject(i);
   						
   						if (dataObject != null) {
   				
   				String CityName = dataObject.optString("CityName");
					String total_beneficiaries = dataObject.optString("total_beneficiaries");
					
   				
   				apiDetails.put("CityName", CityName);
   				apiDetails.put("total_beneficiaries", total_beneficiaries);
   				apiDetails.put("apiVersion", "v1");
					apiDetails.put("timeStamp", currentTimestamp);
					apiDetails.put("statusCode", "S");
					apiDetails.put("message", "Success");
					result.put("apiDetails", apiDetails);
					
					
   						}
   					}

   				}
   			}else {
   				
   				apiDetails.put("apiVersion", "v1");
					apiDetails.put("timeStamp", currentTimestamp);
					apiDetails.put("statusCode", "F");
					apiDetails.put("message", "failed");
					result.put("result", "null");
					result.put("apiDetails", apiDetails);
					System.out.println("No valid data object found in the 'data' array.");
   			}

   			return Response.ok(result.toString()).build();

  } catch (Exception e) {
  	e.printStackTrace();

		// Return a response with an error status
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Problem in service!").build();

  }

	
	
	
	

	}

	
	@POST
	@Path("/getempanelledhospitals")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response getempanelledhospitals(String filters) {  System.out.println("test 1");

    JSONObject objFilterJson;
    JSONObject responseJson = new JSONObject();
    JSONObject objResponse = new JSONObject();
    JSONObject apiDetails = new JSONObject();
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String currentTimestamp = currentDateTime.format(formatter);
		JSONObject result = new JSONObject();
  try {
      // Parse the incoming string to JSON (safe even if it's "{}")
      if (filters != null && !filters.trim().isEmpty()) {
          objFilterJson = new JSONObject(filters);
      } else {
          objFilterJson = new JSONObject(); // empty JSON
      }

      System.out.println("test api----" + objFilterJson.length());

      if (objFilterJson.length() == 0) {
          objFilterJson = null; // set to null so filter is not used later
      }
      
      
   // Instantiate Usefulmethods object to call the external service
   			Usefulmethods objUsefulmethods = new Usefulmethods();
   			String strServiceName = "service/empanelledhospitals";

   			// Call the service and get the response
   			objResponse = objUsefulmethods.callService(objFilterJson, strServiceName);
   			
   			
   			if (objResponse != null) {
   				System.out.println("objResponse>>>>> " + objResponse);
   				
   				JSONArray dataArray = objResponse.optJSONArray("data");
   				
   				if (dataArray != null && dataArray.length() > 0) {
   					
   					
   					for (int i = 0; i < dataArray.length(); i++) {
   						
   						JSONObject dataObject = dataArray.optJSONObject(i);
   						
   						if (dataObject != null) {
   				
   				String CityName = dataObject.optString("CityName");
					String total_beneficiaries = dataObject.optString("total_beneficiaries");
					
   				
   				apiDetails.put("CityName", CityName);
   				apiDetails.put("total_beneficiaries", total_beneficiaries);
   				apiDetails.put("apiVersion", "v1");
					apiDetails.put("timeStamp", currentTimestamp);
					apiDetails.put("statusCode", "S");
					apiDetails.put("message", "Success");
					result.put("apiDetails", apiDetails);
					
					
   						}
   					}

   				}
   			}else {
   				
   				apiDetails.put("apiVersion", "v1");
					apiDetails.put("timeStamp", currentTimestamp);
					apiDetails.put("statusCode", "F");
					apiDetails.put("message", "failed");
					result.put("result", "null");
					result.put("apiDetails", apiDetails);
					System.out.println("No valid data object found in the 'data' array.");
   			}

   			return Response.ok(result.toString()).build();

  } catch (Exception e) {
  	e.printStackTrace();

		// Return a response with an error status
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Problem in service!").build();

  }

	
	
	
	

}
	
	
	
	
	@POST
	@Path("/getlifesavingdrugs")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response getlifesavingdrugs(String filters) {
		
		  System.out.println("test 1");

		    JSONObject objFilterJson;
		    JSONObject responseJson = new JSONObject();
		    JSONObject objResponse = new JSONObject();
		    JSONObject apiDetails = new JSONObject();
		    LocalDateTime currentDateTime = LocalDateTime.now();
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String currentTimestamp = currentDateTime.format(formatter);
				JSONObject result = new JSONObject();
		  try {
		      // Parse the incoming string to JSON (safe even if it's "{}")
		      if (filters != null && !filters.trim().isEmpty()) {
		          objFilterJson = new JSONObject(filters);
		      } else {
		          objFilterJson = new JSONObject(); // empty JSON
		      }

		      System.out.println("test api----" + objFilterJson.length());

		      if (objFilterJson.length() == 0) {
		          objFilterJson = null; // set to null so filter is not used later
		      }
		      
		      
		   // Instantiate Usefulmethods object to call the external service
		   			Usefulmethods objUsefulmethods = new Usefulmethods();
		   			String strServiceName = "service/lifesavingdrugs";

		   			// Call the service and get the response
		   			objResponse = objUsefulmethods.callService(objFilterJson, strServiceName);
		   			
		   			
		   			if (objResponse != null) {
		   				System.out.println("objResponse>>>>> " + objResponse);
		   				
		   				JSONArray dataArray = objResponse.optJSONArray("data");
		   				
		   				if (dataArray != null && dataArray.length() > 0) {
		   					
		   					
		   					for (int i = 0; i < dataArray.length(); i++) {
		   						
		   						JSONObject dataObject = dataArray.optJSONObject(i);
		   						
		   						if (dataObject != null) {
		   				
		   				String CityName = dataObject.optString("CityName");
							String total_beneficiaries = dataObject.optString("total_beneficiaries");
							
		   				
		   				apiDetails.put("CityName", CityName);
		   				apiDetails.put("total_beneficiaries", total_beneficiaries);
		   				apiDetails.put("apiVersion", "v1");
							apiDetails.put("timeStamp", currentTimestamp);
							apiDetails.put("statusCode", "S");
							apiDetails.put("message", "Success");
							result.put("apiDetails", apiDetails);
							
							
		   						}
		   					}

		   				}
		   			}else {
		   				
		   				apiDetails.put("apiVersion", "v1");
							apiDetails.put("timeStamp", currentTimestamp);
							apiDetails.put("statusCode", "F");
							apiDetails.put("message", "failed");
							result.put("result", "null");
							result.put("apiDetails", apiDetails);
							System.out.println("No valid data object found in the 'data' array.");
		   			}

		   			return Response.ok(result.toString()).build();

		  } catch (Exception e) {
		  	e.printStackTrace();

				// Return a response with an error status
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Problem in service!").build();

		  }

			
			
			
			


		
		
	}
	
	
	
	@POST
	@Path("/getcitywisedispensary")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response getcitywisedispensary(String filters) {
		
		  System.out.println("test 1");

		    JSONObject objFilterJson;
		    JSONObject responseJson = new JSONObject();
		    JSONObject objResponse = new JSONObject();
		    JSONObject apiDetails = new JSONObject();
		    LocalDateTime currentDateTime = LocalDateTime.now();
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String currentTimestamp = currentDateTime.format(formatter);
				JSONObject result = new JSONObject();
		  try {
		      // Parse the incoming string to JSON (safe even if it's "{}")
		      if (filters != null && !filters.trim().isEmpty()) {
		          objFilterJson = new JSONObject(filters);
		      } else {
		          objFilterJson = new JSONObject(); // empty JSON
		      }

		      System.out.println("test api----" + objFilterJson.length());

		      if (objFilterJson.length() == 0) {
		          objFilterJson = null; // set to null so filter is not used later
		      }
		      
		      
		   // Instantiate Usefulmethods object to call the external service
		   			Usefulmethods objUsefulmethods = new Usefulmethods();
		   			String strServiceName = "service/citywisedispensary";

		   			// Call the service and get the response
		   			objResponse = objUsefulmethods.callService(objFilterJson, strServiceName);
		   			
		   			
		   			if (objResponse != null) {
		   				System.out.println("objResponse>>>>> " + objResponse);
		   				
		   				JSONArray dataArray = objResponse.optJSONArray("data");
		   				
		   				if (dataArray != null && dataArray.length() > 0) {
		   					
		   					
		   					for (int i = 0; i < dataArray.length(); i++) {
		   						
		   						JSONObject dataObject = dataArray.optJSONObject(i);
		   						
		   						if (dataObject != null) {
		   				
		   				String CityName = dataObject.optString("CityName");
							String total_beneficiaries = dataObject.optString("total_beneficiaries");
							
		   				
		   				apiDetails.put("CityName", CityName);
		   				apiDetails.put("total_beneficiaries", total_beneficiaries);
		   				apiDetails.put("apiVersion", "v1");
							apiDetails.put("timeStamp", currentTimestamp);
							apiDetails.put("statusCode", "S");
							apiDetails.put("message", "Success");
							result.put("apiDetails", apiDetails);
							
							
		   						}
		   					}

		   				}
		   			}else {
		   				
		   				apiDetails.put("apiVersion", "v1");
							apiDetails.put("timeStamp", currentTimestamp);
							apiDetails.put("statusCode", "F");
							apiDetails.put("message", "failed");
							result.put("result", "null");
							result.put("apiDetails", apiDetails);
							System.out.println("No valid data object found in the 'data' array.");
		   			}

		   			return Response.ok(result.toString()).build();

		  } catch (Exception e) {
		  	e.printStackTrace();

				// Return a response with an error status
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Problem in service!").build();

		  }

			
			
			
			


		
		
	}

	
	

	
	
	}
