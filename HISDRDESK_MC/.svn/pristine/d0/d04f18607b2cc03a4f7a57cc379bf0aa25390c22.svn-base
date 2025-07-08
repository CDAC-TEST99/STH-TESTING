package HisWeb.webservice;

import java.text.ParseException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import HisWeb.dao.EHRDetailsDAO;
import HisWeb.util.FTPImageToBase64;
import HisWeb.util.HtmlToPdfConvertor;

@Path("/patdata")
public class EHRDetails {
	
	
	/*   @POST
	   @Path("/getPatEHR") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getEHRDetails(  
			   @FormParam("Modval") String Modval,
			   @FormParam("CrNo") String CrNo,
			   @FormParam("episodeCode") String episodeCode,
			   @FormParam("visitNo") String visitNo,
			   @FormParam("seatId") String seatId,
			   @FormParam("Entrydate") String Entrydate,
			   @FormParam("hosp_code") String hosp_code
			   ) throws Exception{ 
		   String response=null;
		   System.out.println("CrNo::::::::::: \n"+ CrNo);
		   response=EHRDetailsDAO.getPatinetEHRDtls(Modval, CrNo , episodeCode , visitNo , seatId , Entrydate , hosp_code);
		   return response;
		} */
	   
	   @GET
	   @Path("/getPatData") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getEHRDetails1(  
			   @QueryParam("Modval") String Modval,
			   @QueryParam("CrNo") String CrNo,
			   @QueryParam("episodeCode") String episodeCode,
			   @QueryParam("visitNo") String visitNo,
			   @QueryParam("seatId") String seatId,
			   @QueryParam("Entrydate") String Entrydate,
			   @QueryParam("hosp_code") String hosp_code
			   ) throws Exception{ 
		   String response=null;
		 //  System.out.println("CrNo::::::::::: 11\n"+ Modval);
		//   System.out.println("CrNo::::::::::: 11\n"+ CrNo);
		 //  System.out.println("CrNo::::::::::: 11\n"+ episodeCode);
		 //  System.out.println("CrNo::::::::::: 11\n"+ visitNo);
		 //  System.out.println("CrNo::::::::::: 11\n"+ seatId);
		//   System.out.println("CrNo::::::::::: 11\n"+ Entrydate);
		 //  System.out.println("CrNo::::::::::: 11\n"+ hosp_code);
		   response=EHRDetailsDAO.getPatinetEHRDtls(Modval, CrNo , episodeCode , visitNo , seatId , Entrydate , hosp_code);
		   return response;
		} 
	   
	   
	   @GET
	   @Path("/getPatDatawithcrNo") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getEHRDetails1New(  
			   @QueryParam("Modval") String Modval,
			   @QueryParam("CrNo") String CrNo,
			   @QueryParam("episodeCode") String episodeCode,
			 //  @QueryParam("visitNo") String visitNo,
			 //  @QueryParam("seatId") String seatId,
			   @QueryParam("Entrydate") String Entrydate,
			   @QueryParam("hosp_code") String hosp_code,
			   @QueryParam("strIsPrescribedSaveFlg") String strIsPrescribedSaveFlg
			   
			   ) throws Exception{ 
		   String response=null;
		   // System.out.println("getPatData1::::::::::: "+ CrNo);
		   response=EHRDetailsDAO.getPatinetEHRDtlsNew(Modval, CrNo , episodeCode , Entrydate , hosp_code, strIsPrescribedSaveFlg);
		   return response;
		} 
	   
	   @GET
	   @Path("/getVitalData") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getVitalDtlsDtls(  
			   @QueryParam("Modval") String Modval,
			   @QueryParam("CrNo") String CrNo,
			   @QueryParam("episodeCode") String episodeCode,
			   @QueryParam("visitNo") String visitNo,
			   @QueryParam("seatId") String seatId,
			   @QueryParam("Entrydate") String Entrydate,
			   @QueryParam("hosp_code") String hosp_code
			   ) throws Exception{ 
		   String response=null;
		   //System.out.println("CrNo::::::::::: \n"+ CrNo);
		   response=EHRDetailsDAO.getPatinetEHRDtls(Modval, CrNo , episodeCode , visitNo , seatId , Entrydate , hosp_code);
		   return response;
		} 
	   
	  /* @GET
	   @Path("/getPatDataForPastPrescription") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getEHRDetailsForPastPrescription(  
			   @QueryParam("Modval") String Modval,
			   @QueryParam("CrNo") String CrNo,
			   @QueryParam("episodeCode") String episodeCode,
			   @QueryParam("visitNo") String visitNo,
			   @QueryParam("seatId") String seatId,
			   @QueryParam("Entrydate") String Entrydate,
			   @QueryParam("hosp_code") String hosp_code
			   ) throws Exception{ 
		   String response=null;
		   System.out.println("CrNo::::::::::: \n"+ CrNo);
		   response=EHRDetailsDAO.getPatientEHRDtlsForPastPrescription(Modval, CrNo , episodeCode , visitNo , seatId , Entrydate , hosp_code);
		   return response;
		} */

	   
	   @GET
	   @Path("/getPatDataForPastPrescription") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getEHRDetailsForPastPrescription(  
			   @QueryParam("Modval") String Modval,
			   @QueryParam("CrNo") String CrNo,
			   @QueryParam("episodeCode") String episodeCode,
			   @QueryParam("visitNo") String visitNo,
			   @QueryParam("seatId") String seatId,
			   @QueryParam("Entrydate") String Entrydate,
			   @QueryParam("hosp_code") String hosp_code
			   ) throws Exception{ 
		   String response=null;
		/*
		 * System.out.println("EHR DETAIL CrNo::::::::::: \n"+ CrNo);
		 * System.out.println("EHR DETAIL episodeCode::::::::::: \n"+ episodeCode);
		 * System.out.println("EHR DETAIL visitNo::::::::::: \n"+ visitNo);
		 * System.out.println("EHR DETAIL seatId::::::::::: \n"+ seatId);
		 * System.out.println("EHR DETAIL Entrydate::::::::::: \n"+ Entrydate);
		 * System.out.println("EHR DETAIL hosp_code::::::::::: \n"+ hosp_code);
		 */
		   response=EHRDetailsDAO.getPatientEHRDtlsForPastPrescription(Modval, CrNo , episodeCode , visitNo , seatId , Entrydate , hosp_code);
		   return response;
		} 
 //added to get investigation data for all department 
	   
	   @GET
	   @Path("/getInvestigationDtl") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getEHRInvestigationDtl(  
			   @QueryParam("Modval") String Modval,
			   @QueryParam("CrNo") String CrNo,
			   @QueryParam("episodeCode") String episodeCode,
			   @QueryParam("visitNo") String visitNo,
			   @QueryParam("seatId") String seatId,
			   @QueryParam("Entrydate") String Entrydate,
			   @QueryParam("hosp_code") String hosp_code
			   ) throws Exception{ 
		   ArrayList<JSONObject> response=null;
		/*
		 * System.out.println("EHR DETAIL CrNo::::::::::: \n"+ CrNo);
		 * System.out.println("EHR DETAIL episodeCode::::::::::: \n"+ episodeCode);
		 * System.out.println("EHR DETAIL visitNo::::::::::: \n"+ visitNo);
		 * System.out.println("EHR DETAIL seatId::::::::::: \n"+ seatId);
		 * System.out.println("EHR DETAIL Entrydate::::::::::: \n"+ Entrydate);
		 * System.out.println("EHR DETAIL hosp_code::::::::::: \n"+ hosp_code);
		 */
		   return EHRDetailsDAO.getPatientEHRInvestigationDtl(Modval, CrNo , episodeCode , visitNo , seatId , Entrydate , hosp_code).toString();
		
		} 
	   
	   @GET
	   @Path("/getIpdPatDataForPastPrescription") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getIpdEHRDetailsForPastPrescription(  
			   @QueryParam("Modval") String Modval,
			   @QueryParam("CrNo") String CrNo,
			   @QueryParam("episodeCode") String episodeCode,
			   @QueryParam("visitNo") String visitNo,
			   @QueryParam("seatId") String seatId,
			   @QueryParam("Entrydate") String Entrydate,
			   @QueryParam("hosp_code") String hosp_code,
			   @QueryParam("admNo") String admNo
			   ) throws Exception{ 
		   String response=null;
		/*
		 * System.out.println("EHR IPD DETAIL CrNo::::::::::: \n"+ CrNo);
		 * System.out.println("EHR IPD DETAIL episodeCode::::::::::: \n"+ episodeCode);
		 * System.out.println("EHR IPD DETAIL visitNo::::::::::: \n"+ visitNo);
		 * System.out.println("EHR IPD DETAIL seatId::::::::::: \n"+ seatId);
		 * System.out.println("EHR IPD DETAIL Entrydate::::::::::: \n"+ Entrydate);
		 * System.out.println("EHR IPD DETAIL hosp_code::::::::::: \n"+ hosp_code);
		 * System.out.println("EHR IPD DETAIL admNo::::::::::: \n"+ admNo);
		 */
		   response=EHRDetailsDAO.getIpdPatEHRDtlsForPastPrescription(Modval, CrNo , episodeCode , visitNo , seatId , Entrydate , hosp_code , admNo);
		   return response;
		}
	   @GET
	   @Path("/getPatientEHRDtlsForInvDrug") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getPatientEHRDtlsForInvDrug(  
			   @QueryParam("Modval") String Modval,
			   @QueryParam("CrNo") String CrNo,
			   @QueryParam("episodeCode") String episodeCode,
			   @QueryParam("visitNo") String visitNo,
			   @QueryParam("seatId") String seatId,
			   @QueryParam("Entrydate") String Entrydate,
			   @QueryParam("hosp_code") String hosp_code
			   ) throws Exception{ 
		   String response=null;
		/*
		 * System.out.println("EHR DETAIL CrNo::::::::::: \n"+ CrNo);
		 * System.out.println("EHR DETAIL episodeCode::::::::::: \n"+ episodeCode);
		 * System.out.println("EHR DETAIL visitNo::::::::::: \n"+ visitNo);
		 * System.out.println("EHR DETAIL seatId::::::::::: \n"+ seatId);
		 * System.out.println("EHR DETAIL Entrydate::::::::::: \n"+ Entrydate);
		 * System.out.println("EHR DETAIL hosp_code::::::::::: \n"+ hosp_code);
		 */
		   response=EHRDetailsDAO.getPatientEHRDtlsForInvDrug(Modval, CrNo , episodeCode , visitNo , seatId , Entrydate , hosp_code);
		   return response;
		}
	   
	   @GET
	   @Path("/getPatientEHRDtlsForTemplatePrescription") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getPatientEHRDtlsForTemplatePrescription(  
			   @QueryParam("Modval") String Modval,
			   @QueryParam("CrNo") String CrNo,
			   @QueryParam("episodeCode") String episodeCode,
			   @QueryParam("visitNo") String visitNo,
			   @QueryParam("seatId") String seatId,
			   @QueryParam("Entrydate") String Entrydate,
			   @QueryParam("hosp_code") String hosp_code
			   ) throws Exception{ 
		   String response=null;
		   //System.out.println("CrNo::::::::::: \n"+ CrNo);
		   EHRDetailsDAO.getPatientEHRDtlsForTemplatePrescription(Modval, CrNo , episodeCode , visitNo , seatId , Entrydate , hosp_code,"0");
		   return response;
		} 
	   // getPatientEHRDtlsForTemplatePrescription
	   @GET
	   @Path("/getPatVitalDataForDetailedPrescription") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getPatVitalDataForDetailedPrescription(  
			   @QueryParam("Modval") String Modval,
			   @QueryParam("CrNo") String CrNo,
			   @QueryParam("episodeCode") String episodeCode,
			   @QueryParam("visitNo") String visitNo,
			   @QueryParam("seatId") String seatId,
			   @QueryParam("Entrydate") String Entrydate,
			   @QueryParam("hosp_code") String hosp_code
			   ) throws Exception{ 
		   String response=null;
		   //System.out.println("CrNo::::::::::: \n"+ CrNo);
		   response=EHRDetailsDAO.getPatVitalDataDtlsForDetailedPrescription(Modval, CrNo , episodeCode , visitNo , seatId , Entrydate , hosp_code);
		   return response;
		} 
	   
	   
	   @GET
	   @Path("/getIpdPatVitalDataForDtlPrescription") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getIpdPatVitalDataForDtlPrescription(  
			   @QueryParam("Modval") String Modval,
			   @QueryParam("CrNo") String CrNo,
			   @QueryParam("episodeCode") String episodeCode,
			   @QueryParam("visitNo") String visitNo,
			   @QueryParam("seatId") String seatId,
			   @QueryParam("Entrydate") String Entrydate,
			   @QueryParam("hosp_code") String hosp_code,
			   @QueryParam("admNo") String admNo
			   ) throws Exception{ 
		   String response=null;
		   //System.out.println("CrNo::::::::::: \n"+ CrNo);
		   response=EHRDetailsDAO.getIpdPatVitalDataDtlsForDtlPrescription(Modval, CrNo , episodeCode , visitNo , seatId , Entrydate , hosp_code , admNo);
		   return response;
		} 
	   
	  /* @GET
	   @Path("/digi") 
	   @Produces(MediaType.TEXT_PLAIN)
	   public Response getPdf(  
	
	  @QueryParam("Modval") String Modval,
	  
	  @QueryParam("CrNo") String CrNo,
	  
	  @QueryParam("episodeCode") String episodeCode,
	  
	  @QueryParam("visitNo") String visitNo,
	  
	  @QueryParam("seatId") String seatId,
	  
	  @QueryParam("Entrydate") String Entrydate,
	  
	  @QueryParam("hosp_code") String hosp_code
	 
			   ) throws Exception{ 
		  
		 //  System.out.println("CrNo::::::::::: \n"+ CrNo);
		  String data= EHRDetailsDAO.getpdfForDigiLocaker(Modval, CrNo , episodeCode , visitNo , seatId , Entrydate , hosp_code);
		 String Data1= EHRDetailsDAO.getHospitalHeaderName(Modval, CrNo , episodeCode , visitNo , seatId , Entrydate , hosp_code);
		  org.json.JSONArray ja=new  org.json.JSONArray(data);
		  org.json.JSONArray ja1=new  org.json.JSONArray(Data1);
		  
		//System.out.println(" ja.length()"+ ja.length());
		  //System.out.println(data);
		   for(int i=0 ; i<ja.length() ;i++) {
			   org.json.JSONObject jsonObject=new  org.json.JSONObject(ja.get(i).toString());
			   //System.out.println(jsonObject);
			//   JSONObject obj=new JSONObject(Data1);
			   PDFCreator.createPdf( jsonObject.get("HRSTR_JSON").toString(),  jsonObject.get("VITAL_DATA").toString() , ja1.get(i).toString() ,jsonObject.get("USER_NAME").toString() , jsonObject.get("DATASAVE_TIME").toString()   );  
		   }
		
		   String filePath = HisUtil.getParameterFromHisPathXML("CREDIT_BILL_PATH")+"/print.pdf" ;
	        //System.out.println("Sending file: " + filePath);
	        byte[] fileBytes=null;
	        try {
	            File file = new File(filePath);
	            FileInputStream fis = new FileInputStream(file);
	            BufferedInputStream inputStream = new BufferedInputStream(fis);
	            fileBytes = new byte[(int) file.length()];
	            inputStream.read(fileBytes);
	            inputStream.close();
	             
	          //  return fileBytes;
	        } catch (IOException ex) {
	            System.err.println(ex);
	            throw new WebServiceException(ex);
	        }
	        String response="";
	        if(ja.length() > 0) {
	        	 response=Base64.getEncoder().encodeToString(fileBytes);
	        }else {
	        	response= "No Data Found";
	        }
	        
	        //System.out.println(response);
		  return Response.ok().entity(  response) .header("Access-Control-Allow-Origin","*") .build();
		 
		   
		  // return response;
		} 
	   */
	   @GET
	   @Path("/getAdmissionAdvice") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getAdmissionAdvice(  
			   @QueryParam("Modval") String Modval,
			   @QueryParam("CrNo") String CrNo,
			   @QueryParam("episodeCode") String episodeCode,
			   @QueryParam("visitNo") String visitNo,
			   @QueryParam("seatId") String seatId,
			   @QueryParam("Entrydate") String Entrydate,
			   @QueryParam("hosp_code") String hosp_code
			   ) throws Exception{ 
		   String response=null;
		   //System.out.println("CrNo::::::::::: \n"+ CrNo);
		   return EHRDetailsDAO.getAdmissionAdvice(Modval, CrNo , episodeCode , visitNo , seatId , Entrydate , hosp_code).toString();
		   //return response;
		} 
	   
	   @GET
	   @Path("/getPatUmidData") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getPatUmidData(  
			   @QueryParam("Modval") String Modval,
			   @QueryParam("CrNo") String CrNo,
			   @QueryParam("hosp_code") String hosp_code
			   ) throws Exception{ 
		   String response=null;
		   //System.out.println("CrNo::::::::::: \n"+ CrNo);
		   return EHRDetailsDAO.getPatUmidData(Modval, CrNo , hosp_code);
		   //return response;
		}
	   
	   @GET
	   @Path("/getInternalReferralPatientData") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getInternalReferralPatientData(  
			   @QueryParam("departmentCode") String departmentCode,
			   @QueryParam("departmentUnitCode") String departmentUnitCode,
			   @QueryParam("hosp_code") String hosp_code
			   ) throws Exception{ 
		   String response= "{}";
		/*
		 * System.out.println("department::::::::::: "+ departmentCode);
		 * System.out.println("departmentUnitCode::::::::::: "+ departmentUnitCode);
		 * System.out.println("hosp_code::::::::::: "+ hosp_code);
		 */
		   response=EHRDetailsDAO.getInternalReferralPatientData(departmentCode,departmentUnitCode , hosp_code);
		   return response;
		} 
	   @GET
	   @Path("/getCRNoWiseExternalReferralData") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getCRNoWiseExternalReferralData(  
			   @QueryParam("crNo") String crNo,
			   @QueryParam("episodeCode") String episodeCode,
			   @QueryParam("visitNo") String visitNo,
			   @QueryParam("seatId") String seatId,			   
			   @QueryParam("hosp_code") String hosp_code,
			   @QueryParam("referStatus") String referStatus
			   ) throws Exception{ 
		   String response= "{}";
		  // System.out.println("crNo::::::::::: "+ crNo);
		  // System.out.println("episodeCode::::::::::: "+ episodeCode);
		 //  System.out.println("visitNo::::::::::: "+ visitNo);
		  // System.out.println("seatId::::::::::: "+ seatId);		   
		  // System.out.println("hosp_code::::::::::: "+ hosp_code);
		   JSONObject mainObj = new JSONObject();
		   mainObj.put("status", "0");
		   String status="1";
		   if(referStatus.equals("3")) {/*getting endorsement details*/
			   JSONObject endorsementJsonObj = new JSONObject(); 
			   endorsementJsonObj =EHRDetailsDAO.getCRNoWiseExternalReferralData("1" ,crNo,episodeCode , visitNo,seatId, hosp_code,referStatus);
			   status=endorsementJsonObj.getString("status");
			    if(status=="1") {
				  mainObj.put("status", "1");
				  mainObj.put("endorsementData", endorsementJsonObj.get("data"));
				}
			    else
			    	mainObj.put("status", "0");
		   }
		   if(status.equals("1")) {
			   JSONObject extJsonObj = new JSONObject();
			   extJsonObj =EHRDetailsDAO.getCRNoWiseExternalReferralData("2" ,crNo,episodeCode , visitNo,seatId, hosp_code,referStatus);
			   status=extJsonObj.getString("status");
			   if(status.equals("1")) {
					  mainObj.put("status", "1");
					  mainObj.put("externalReferralData", extJsonObj.get("data"));
				}
		   }
		   return mainObj.toString();
		}
	   
	   @GET
	   @Path("/digi") 
	   @Produces(MediaType.TEXT_PLAIN)
	   public Response getPdf(  
	
	  @QueryParam("Modval") String Modval,
	  
	  @QueryParam("CrNo") String CrNo,
	  
	  @QueryParam("episodeCode") String episodeCode,
	  
	  @QueryParam("visitNo") String visitNo,
	  
	  @QueryParam("seatId") String seatId,
	  
	  @QueryParam("Entrydate") String Entrydate,
	  
	  @QueryParam("hosp_code") String hosp_code
	 
			   ) throws Exception{ 
		  
		  if(CrNo.contains("-")) {
			  CrNo=CrNo.replace("-","/");
		  }
		
		//  System.out.println("Modval==" + Modval); System.out.println("CrNo==" + CrNo);
		// System.out.println("episodeCode==" + episodeCode);
		// System.out.println("visitNo==" + visitNo); System.out.println("seatId==" +
		 // seatId); System.out.println("Entrydate" + Entrydate);
		// System.out.println("hosp_code" + hosp_code);
		 
		  
		  String response=HtmlToPdfConvertor.get_pat_prescription_pdf(Modval, CrNo, episodeCode, visitNo, seatId, Entrydate, hosp_code);	       
		  return Response.ok().entity(  response) .header("Access-Control-Allow-Origin","*") .build();
		 
		   
		  // return response;
		}
	   
	   @GET
	   @Path("/referralPDF") 
	   @Produces(MediaType.TEXT_PLAIN)
	   public Response getreferralPDF(  
	  @QueryParam("Modval") String Modval,
	  @QueryParam("CrNo") String CrNo,@QueryParam("episodeCode") String episodeCode,@QueryParam("visitNo") String visitNo,
	  @QueryParam("seatId") String seatId,@QueryParam("Entrydate") String Entrydate, @QueryParam("hosp_code") String hosp_code
	 
			   ) throws Exception{ 
		  
		  if(CrNo.contains("-")) {
			  CrNo=CrNo.replace("-","/");
		  }
		
		 // System.out.println("Modval==" + Modval); System.out.println("CrNo==" + CrNo);
		/// System.out.println("episodeCode==" + episodeCode);
		/// System.out.println("visitNo==" + visitNo); System.out.println("seatId==" +
		//  seatId); System.out.println("Entrydate" + Entrydate);
		// System.out.println("hosp_code" + hosp_code);
		 
		  
		  String response=HtmlToPdfConvertor.get_pat_referral_pdf(Modval, CrNo, episodeCode, visitNo, seatId, Entrydate, hosp_code);	       
		  return Response.ok().entity(  response) .header("Access-Control-Allow-Origin","*") .build();
		 
		   
		  // return response;
		}
	   
	   
	   
	   @GET
	   @Path("/digiHTML") 
	   @Produces(MediaType.TEXT_PLAIN)
	   public Response getHTMLPrescription(  
	
	  @QueryParam("Modval") String Modval,
	  
	  @QueryParam("CrNo") String CrNo,
	  
	  @QueryParam("episodeCode") String episodeCode,
	  
	  @QueryParam("visitNo") String visitNo,
	  
	  @QueryParam("seatId") String seatId,
	  
	  @QueryParam("Entrydate") String Entrydate,
	  
	  @QueryParam("hosp_code") String hosp_code
	 
			   ) throws Exception{ 
		  
		  if(CrNo.contains("-")) {
			  CrNo=CrNo.replace("-","/");
		  }
		/*
		 * System.out.println("Modval==" + Modval); System.out.println("CrNo==" + CrNo);
		 * System.out.println("episodeCode==" + episodeCode);
		 * System.out.println("visitNo==" + visitNo); System.out.println("seatId==" +
		 * seatId); System.out.println("Entrydate" + Entrydate);
		 * System.out.println("hosp_code" + hosp_code);
		 */
		  
		  String response=HtmlToPdfConvertor.get_pat_prescription_html_details(Modval, CrNo, episodeCode, visitNo, seatId, Entrydate, hosp_code);	       
		  return Response.ok().entity(  response) .header("Access-Control-Allow-Origin","*") .build();
		 
		   
		  // return response;
		}
	   
	   @GET
	   @Path("/ReferralHTML") 
	   @Produces(MediaType.TEXT_PLAIN)
	   public Response getHTMLReferral(  
	
	  @QueryParam("Modval") String Modval,
	  
	  @QueryParam("CrNo") String CrNo,
	  
	  @QueryParam("episodeCode") String episodeCode,
	  
	  @QueryParam("visitNo") String visitNo,
	  
	  @QueryParam("seatId") String seatId,
	  
	  @QueryParam("Entrydate") String Entrydate,
	  
	  @QueryParam("hosp_code") String hosp_code
	 
			   ) throws Exception{ 
		  
		  if(CrNo.contains("-")) {
			  CrNo=CrNo.replace("-","/");
		  }
		  //	System.out.println("Modval==" + Modval); System.out.println("CrNo==" + CrNo);
		 ///System.out.println("episodeCode==" + episodeCode);
		//  System.out.println("visitNo==" + visitNo); System.out.println("seatId==" +
		//  seatId); System.out.println("Entrydate" + Entrydate);
		//  System.out.println("hosp_code" + hosp_code);
		 
		  
		  String response=HtmlToPdfConvertor.get_pat_referral_details(Modval, CrNo, episodeCode, visitNo, seatId, Entrydate, hosp_code);	       
		  return Response.ok().entity(  response) .header("Access-Control-Allow-Origin","*") .build();
		 
		   
		  // return response;
		}
	   
	   
	   
	   @GET
	   @Path("/getPreviousPatientReviewData") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getPreviousPatientReviewData(  
			   @QueryParam("crNo") String crNo,
			   @QueryParam("episodeCode") String episodeCode,
			   @QueryParam("visitNo") String visitNo,		   
			   @QueryParam("hosp_code") String hosp_code,
			   @QueryParam("seatId") String seatId
			   ) throws Exception{ 
		   String response= "{}";
		/*
		 * System.out.println("crNo::::::::::: "+ crNo);
		 * System.out.println("episodeCode::::::::::: "+ episodeCode);
		 * System.out.println("visitNo::::::::::: "+ visitNo);
		 * System.out.println("seatId::::::::::: "+ seatId);
		 * System.out.println("hosp_code::::::::::: "+ hosp_code);
		 */
		   JSONObject mainObj = new JSONObject();
		   mainObj.put("status", "0");
		  
		   mainObj =EHRDetailsDAO.getPreviousPatientReviewData(crNo,episodeCode , visitNo,seatId, hosp_code);
			   
		   
		   return mainObj.toString();
		}
	   
	   @GET
	   @Path("/getPatientBase64Image") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getPatientBase64Image(  
			   @QueryParam("fileName") String fileName,
			   @QueryParam("shortName") String shortName
			  			  
			   ) throws Exception{ 
		   String response= "{}";
		   //System.out.println("fileName::::::::::: "+ fileName);
		   JSONObject mainObj = new JSONObject();
		   mainObj.put("status", "0");
		   try {
			   String base64Img=FTPImageToBase64.getImageAsBase64(fileName ,shortName);
			   if(base64Img!=null) {
				   mainObj.put("status", "1");
				   mainObj.put("base64Img",base64Img);
			   }
			   else {
				   mainObj.put("status", "0");
			   }
		   }catch(Exception e) {
			   
		   }
			   
		   
		   return mainObj.toString();
		}
	   
	   @GET
	   @Path("/getBendataFromPool") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getBendataFromPool(  
			   @QueryParam("departmentCode") String departmentCode,
			   @QueryParam("departmentUnitCode") String departmentUnitCode,
			   @QueryParam("hosp_code") String hosp_code,
			   @QueryParam("isSmartQueueEnabled") String isSmartQueueEnabled
			   ) throws Exception{ 
		   String response= "{}";
		/*
		 * System.out.println("department::::::::::: "+ departmentCode);
		 * System.out.println("departmentUnitCode::::::::::: "+ departmentUnitCode);
		 * System.out.println("hosp_code::::::::::: "+ hosp_code);
		 */
		   if(isSmartQueueEnabled.equals("1"))
			   response=EHRDetailsDAO.getBendataFromPoolSmartQMS(departmentCode,departmentUnitCode , hosp_code);
		   else
			   response=EHRDetailsDAO.getBendataFromPoolWithoutSmartQMS(departmentCode,departmentUnitCode , hosp_code);
				   
		   return response;
		}
	   
	  
	   @POST
		@Path("/getSectionBookmarks")   
		@Produces({ MediaType.APPLICATION_JSON })
		@Consumes({ MediaType.APPLICATION_JSON })	
		public Response getSectionBookmarks(String JsonData ) throws JSONException, ParseException{
			
			JSONObject resultObject= new JSONObject();
			resultObject.put("status", "ERROR");
			resultObject =EHRDetailsDAO.getSectionBookmarks(JsonData);
			if(resultObject.has("status") && resultObject.getString("status").equals("SUCCESS")) {
			 return Response.ok()
		               .entity(resultObject.toString())
		               .header("Access-Control-Allow-Origin", "*")
		               .build();
			}
			else {
				resultObject.put("status", "ERROR");
				return Response
		                .status(Response.Status.BAD_REQUEST)
		                .entity(resultObject.toString())
		                .build();			 
			}
		}
	   @GET
	   @Path("/getPatAllData") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getEHRDetailsAll(  
			   @QueryParam("Modval") String Modval,
			   @QueryParam("CrNo") String CrNo
			   ) throws Exception{ 
		   String response=null;
		   //System.out.println("Modval::::::::::: 11\n"+ Modval);
		  // System.out.println("CrNo::::::::::: 11\n"+ CrNo);
		   response=EHRDetailsDAO.getPatinetEHRAllDtls(Modval, CrNo );
		   return response;
		}
	   
	  
	   
	   @GET
	   @Path("/getBenDetails") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getBenDetails(  
			   @QueryParam("Modval") String Modval,
			   @QueryParam("CrNo") String CrNo
			   ) throws Exception{ 
		   String response=null;
		   System.out.println("Modval::::::::::: "+ Modval);
		   System.out.println("CrNo::::::::::: "+ CrNo);
		   response=EHRDetailsDAO.getBenDetailsDAO(Modval, CrNo );
		   return response;
		}
	   

		@GET
		@Path("/getPatVitalDataForEMR") 
		@Produces(MediaType.APPLICATION_JSON) 
		public String getPatVitalDataForEMR(  
				   @QueryParam("Modval") String Modval,
				   @QueryParam("CrNo") String CrNo
				   ) throws Exception{ 
			   String response=null;
			   //System.out.println("CrNo::::::::::: \n"+ CrNo);
			   response=EHRDetailsDAO.getPatVitalDataDtlsForEMR(Modval, CrNo);
			   return response;
			}
		
		@GET
		@Path("/getPatINVDataForEMR") 
		@Produces(MediaType.APPLICATION_JSON) 
		public String getPatINVDataForEMR(  
				   @QueryParam("Modval") String Modval,
				   @QueryParam("CrNo") String CrNo
				   ) throws Exception{ 
			   String response=null;
			   //System.out.println("CrNo::::::::::: \n"+ CrNo);
			   response=EHRDetailsDAO.getPatINVDataForEMRDAO(Modval, CrNo);
			   return response;
			}
		
		@GET
		@Path("/getPatReffDataForEMR") 
		@Produces(MediaType.APPLICATION_JSON) 
		public String getPatReffDataForEMR(  
				   @QueryParam("Modval") String Modval,
				   @QueryParam("CrNo") String CrNo
				   ) throws Exception{ 
			   String response=null;
			   //System.out.println("CrNo::::::::::: \n"+ CrNo);
			   response=EHRDetailsDAO.getPatReffDataForEMRDAO(Modval, CrNo);
			   return response;
			}
		
		
		@GET
		@Path("/getDepartmentUnitForEMR") 
		@Produces(MediaType.APPLICATION_JSON) 
		public String getDepartmentUnitForEMR(  
				   @QueryParam("Modval") String Modval,
				   @QueryParam("CrNo") String CrNo
				   ) throws Exception{ 
			   String response=null;
			   //System.out.println("CrNo::::::::::: \n"+ CrNo);
			   response=EHRDetailsDAO.getDepartmentUnitForEMR(Modval, CrNo);
			   return response;
			}
		
		@GET
		@Path("/getDrugDTLS") 
		@Produces(MediaType.APPLICATION_JSON) 
		public String getDrugDTLSEMR(  
				   @QueryParam("Modval") String Modval,
				   @QueryParam("CrNo") String CrNo
				   ) throws Exception{ 
			   String response=null;
			   //System.out.println("CrNo::::::::::: \n"+ CrNo);
			   response=EHRDetailsDAO.getDrugDTLSEMR(Modval, CrNo);
			   return response;
			}
		

		   @GET
		   @Path("/updateReferralDisableSatatus") 
		   @Produces(MediaType.APPLICATION_JSON) 
		   public JSONObject updateReferralDisableSatatus(  
				   @QueryParam("crNo") String crNo,
				   @QueryParam("episodeCode") String episodeCode,
				   @QueryParam("disableSatatus") String disableSatatus,
				   @QueryParam("refId") String refId,
				   @QueryParam("strReffralExtId") String strReffralExtId,
				   @QueryParam("disableRemark") String disableRemark

				   ) throws Exception{	   
			   		JSONObject response=null;
				   System.out.println("CrNo:::  \n "+ crNo  +"refID:::  \n "+refId +"disableRemark:::  \n "+ disableRemark );
				   response=EHRDetailsDAO.updateReferralDisableSatatus(crNo, episodeCode,strReffralExtId,refId,disableSatatus,disableRemark);
				    System.out.println("response 1  : "+response);
				   return response;
		   }
	   
}
