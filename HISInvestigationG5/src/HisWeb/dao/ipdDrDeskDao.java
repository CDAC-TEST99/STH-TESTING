package HisWeb.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hisglobal.exceptions.HisException;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.vo.UserVO;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ipdDrDeskDao {
	
	public static String SaveDrugAdviceData( String JsonData)
	{

    	String err = "";
    	String proc_name1 = "{call pkg_ipdDesk_dml.proc_insert_drdesk_data(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?)}";
    	
        int procIndex1 = 0;
        int procIndex2 = 0;
        HisDAO dao = null;
        int totBillQty=0;
        
         String reqno=null,billNo=null,crno=null;
         JSONObject mainObj = new JSONObject();
         HttpServletRequest request=null;
         StringBuffer buffer=new StringBuffer();
         JSONObject mainObj1 = new JSONObject(); 
         int lineNumber = 0;
        
        try {
        	
   		 JSONObject object = new JSONObject(JsonData);
			//System.out.println("JsonData"+JsonData);
			//System.out.println("DrugCodeCat "+object.get("DrugCodeCat"));
			//System.out.println("CR_No"+object.get("CR_No"));
			//System.out.println("episodeCode"+object.get("episodeCode"));

   			String Crno=(String) object.get("CR_No");
   			String EpisodeCode=(String) object.get("episodeCode");
   			String seatId=(String) object.get("seatId");
   			String hosp_code=(String) object.get("hosp_code");
   			String EpisodeVisitNo=(String) object.get("episodeVisitNo");
   			String admissionNo=(String) object.get("admissionNo");
   			JSONArray DrugObjArray =(JSONArray) object.get("DrugCodeCat");
   			String PatCompleteGeneralDtl=(String) object.get("PatCompleteGeneralDtl");
   			
   			
   			if(DrugObjArray!=null)
   				{
   				
		   			for (int i=0 ;i<DrugObjArray.length();i++)
		   			{
		   				try {
				   				lineNumber = 0;
				   				
				   				dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
				   	            procIndex1 = dao.setProcedure(proc_name1);
				   	            dao.setProcInValue(procIndex1, "modval", "1",1);
				   	            dao.setProcInValue(procIndex1, "puk", Crno,2);
				   	            dao.setProcInValue(procIndex1, "episodecode", EpisodeCode,3); 
				   	            dao.setProcInValue(procIndex1, "slno", String.valueOf(i+1),4); 
				   	            dao.setProcInValue(procIndex1, "admno", admissionNo,5);
				   	            dao.setProcInValue(procIndex1, "visitno", EpisodeVisitNo,6); 
				   	            String tmp = (String) DrugObjArray.get(i);
				   	            String tmpArray[]=tmp.split("&&");
				   	            lineNumber++;
				   	            dao.setProcInValue(procIndex1, "itemid",tmpArray[1].split("#")[0] ,7);
				   	            lineNumber++;
				   	            dao.setProcInValue(procIndex1, "doseid", tmpArray[3],8);
				   	            lineNumber++;
								dao.setProcInValue(procIndex1, "seatid", seatId,9);
								lineNumber++;
								dao.setProcInValue(procIndex1, "doseName", tmpArray[2],10);
								lineNumber++;
								dao.setProcInValue(procIndex1, "routeid", tmpArray[13],11);
								lineNumber++;
								dao.setProcInValue(procIndex1, "frqid",  tmpArray[5],12);
								lineNumber++;
								
								dao.setProcInValue(procIndex1, "days",  tmpArray[7].split("#")[0],13);
								lineNumber++;
								dao.setProcInValue(procIndex1, "startdate",  tmpArray[6],14);
								lineNumber++;
								dao.setProcInValue(procIndex1, "endDate",  tmpArray[6],15);
								lineNumber++;
								if(tmpArray[8].trim().isEmpty())
									dao.setProcInValue(procIndex1, "remarks",  "",16);
								else
									dao.setProcInValue(procIndex1, "remarks",  tmpArray[8].trim(),16);
								
								lineNumber++;
								
								dao.setProcInValue(procIndex1, "itemName", tmpArray[0],17);
								lineNumber++;
								dao.setProcInValue(procIndex1, "hospcode", hosp_code,18);
								lineNumber++;
								dao.setProcInValue(procIndex1, "empid", "0",19);
								lineNumber++;
								
								if(tmpArray[7].split("#").length > 1)
									dao.setProcInValue(procIndex1, "doseqty", tmpArray[7].split("#")[1],20);
								else
									dao.setProcInValue(procIndex1, "doseqty", tmpArray[7].split("#")[0],20);
								
								lineNumber++;
								dao.setProcInValue(procIndex1, "brandId", tmpArray[1].split("#")[4],21);
								lineNumber++;
								dao.setProcInValue(procIndex1, "itemtypeid", tmpArray[1].split("#")[1],22);
								lineNumber++;
								dao.setProcInValue(procIndex1, "frequencyname", tmpArray[4],23);
								lineNumber++;
								dao.setProcInValue(procIndex1, "adminname", "",24);
								lineNumber++;
								String routename = tmpArray[14];
								if(tmpArray[13].equals("0"))
									routename = "";
								dao.setProcInValue(procIndex1, "routename", routename,25);
								lineNumber++;
								dao.setProcInValue(procIndex1, "drugadmid", tmpArray[12],26);
								lineNumber++;
								
								dao.setProcInValue(procIndex1, "deptunitcode", PatCompleteGeneralDtl.split("#")[5],27);
								dao.setProcInValue(procIndex1, "deptcode", PatCompleteGeneralDtl.split("#")[6],28);
								
				   	            dao.setProcOutValue(procIndex1, "err", 1,29);
				   	            lineNumber++;
				   	            dao.executeProcedureByPosition(procIndex1);
				   	            
				   	         
		   					}
		   					catch (Exception e) {
		   						HisException eObj = new HisException("OPD Lite","opdDrDeskDao.SaveDrugAdviceData() inside forloop -->", "lineNumber -> "+lineNumber+" : "+"JSON -> "+DrugObjArray.get(i)+" :: "+e.getMessage() + "-->" + e);
		   						e.printStackTrace();
		   						// return "Something Went Wrong";
		   					}
		   	    	}
		   			SaveAdmDrugAdviceData(JsonData);
   				}
            return "DATA INSERTED SUCCESSFULLY";
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.SaveDrugAdviceData()-->", "lineNumber : "+lineNumber+" :: "+e.getMessage() + "-->" + e);
            e.printStackTrace();
            return "Something Went Wrong";
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
    }
	public static String SaveAdmDrugAdviceData( String JsonData)
	{

    	String proc_name1 = "{call pkg_ipdDesk_dml.proc_insert_drdesk_admin_drug_data(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,? ,?,?,?,?,?, ?,?)}";
    	
        int procIndex1 = 0;
        HisDAO dao = null;
        
         
         int lineNumber = 0;
        
        try {
        	
   		 	JSONObject object = new JSONObject(JsonData);
   			String Crno=(String) object.get("CR_No");
   			String EpisodeCode=(String) object.get("episodeCode");
   			String seatId=(String) object.get("seatId");
   			String hosp_code=(String) object.get("hosp_code");
   			String EpisodeVisitNo=(String) object.get("episodeVisitNo");
   			String admissionNo=(String) object.get("admissionNo");
   			JSONArray DrugObjArray =(JSONArray) object.get("DrugCodeCat");  			
   			
   			if(DrugObjArray!=null)
   				{
   				
		   			for (int i=0 ;i<DrugObjArray.length();i++)
		   			{
		   				try {
				   				lineNumber = 0;
				   				
				   				dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
				   	            procIndex1 = dao.setProcedure(proc_name1);
				   	            dao.setProcInValue(procIndex1, "modval", "1",1);
				   	            dao.setProcInValue(procIndex1, "puk", Crno,2);
				   	            dao.setProcInValue(procIndex1, "episodecode", EpisodeCode,3);
				   	            dao.setProcInValue(procIndex1, "admno", admissionNo,4); 
				   	            dao.setProcInValue(procIndex1, "visitno", EpisodeVisitNo,5); 
				   	            String tmp = (String) DrugObjArray.get(i);
				   	            String tmpArray[]=tmp.split("&&");
				   	            lineNumber++;
				   	            dao.setProcInValue(procIndex1, "itemid",tmpArray[1].split("#")[0] ,6);
				   	            lineNumber++;
				   	            dao.setProcInValue(procIndex1, "doseid", tmpArray[3],7);
				   	            lineNumber++;
								dao.setProcInValue(procIndex1, "seatid", seatId,8);
								lineNumber++;
								dao.setProcInValue(procIndex1, "doseName", tmpArray[2],9);
								lineNumber++;
								String routeId= tmpArray[13]!=null && !tmpArray[13].equals("") && !tmpArray[13].equals("0")?tmpArray[13]:"38";
								dao.setProcInValue(procIndex1, "routeid", routeId,10);						
								lineNumber++;
								if(tmpArray[8].trim().isEmpty())
									dao.setProcInValue(procIndex1, "remarks",  "",11);
								else
									dao.setProcInValue(procIndex1, "remarks",  tmpArray[8].trim(),11);
								lineNumber++;
								dao.setProcInValue(procIndex1, "itemName", tmpArray[0],12);
								lineNumber++;
								dao.setProcInValue(procIndex1, "hospcode", hosp_code,13);
								lineNumber++;
								dao.setProcInValue(procIndex1, "empid", "0",14);
								lineNumber++;
								dao.setProcInValue(procIndex1, "brandId", tmpArray[1].split("#")[4],15);
								lineNumber++;
								String dosetime="",cutofftime="";
									switch (tmpArray[12]) {
									case "1":
										dosetime = "06:00";
										cutofftime="05:00";
										break;
									case "2":
										dosetime = "08:00";
										cutofftime="07:00";
										break;
									case "3":
										dosetime = "12:00";
										cutofftime="11:00";
										break;
									case "4":
										dosetime = "14:00";
										cutofftime="13:00";
										break;
									case "5":
										dosetime = "18:00";
										cutofftime="17:00";
										break;
									case "6":
										dosetime = "20:00";
										cutofftime="19:00";
										break;
									default:
										dosetime = "12:00";
										cutofftime="12:00";
									}
								dao.setProcInValue(procIndex1, "dosetime", dosetime,16);
								lineNumber++;
								dao.setProcInValue(procIndex1, "admtime", "",17);
								lineNumber++;
								dao.setProcInValue(procIndex1, "admendtime", "",18);
								lineNumber++;
								dao.setProcInValue(procIndex1, "doseshift", "",19);
								lineNumber++;
								dao.setProcInValue(procIndex1, "dosesrcflag", "",20);
								lineNumber++;
								dao.setProcInValue(procIndex1, "batchno", "",21);
								lineNumber++;
								dao.setProcInValue(procIndex1, "expdate", "",22);
								lineNumber++;
								dao.setProcInValue(procIndex1, "isemptystomach", "",23);
								lineNumber++;
								dao.setProcInValue(procIndex1, "isreaction", "0",24);
								lineNumber++;
								dao.setProcInValue(procIndex1, "admflag", "1",25);
								lineNumber++;
								dao.setProcInValue(procIndex1, "actdoseid", "",26);
								lineNumber++;
								dao.setProcInValue(procIndex1, "actdosename", "",27);
								lineNumber++;
								dao.setProcInValue(procIndex1, "actrouteid", "",28);
								lineNumber++;
								dao.setProcInValue(procIndex1, "volume", "",29);
								lineNumber++;
								dao.setProcInValue(procIndex1, "itemtypeid", tmpArray[1].split("#")[1],30);
								lineNumber++;
								dao.setProcInValue(procIndex1, "cutofftime", cutofftime,31);
								lineNumber++;
				   	            dao.setProcOutValue(procIndex1, "err", 1,32);
				   	            lineNumber++;
				   	            dao.executeProcedureByPosition(procIndex1);
		   					}
		   					catch (Exception e) {
		   						HisException eObj = new HisException("OPD Lite","opdDrDeskDao.SaveAdmDrugAdviceData() inside forloop -->", "lineNumber -> "+lineNumber+" : "+"JSON -> "+DrugObjArray.get(i)+" :: "+e.getMessage() + "-->" + e);
		   						e.printStackTrace();
		   						// return "Something Went Wrong";
		   					}
		   	    	}
		   			
   				}
            return "DATA INSERTED SUCCESSFULLY";
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.SaveAdmDrugAdviceData()-->", "lineNumber : "+lineNumber+" :: "+e.getMessage() + "-->" + e);
            e.printStackTrace();
            return "Something Went Wrong";
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
    }
	
	public static String SaveInvData(String JsonData) {
		System.out.println("method called for ipd SaveInvData2--->");
		String err = "";
    	String proc_name1 = "{call pkg_inv_dml.proc_insert_hivt_requisition_dtl(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
    	String proc_name3 = "{call pkg_inv_dml.proc_insert_hivt_reqisition_header(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
    	String proc_name2 = "{? = call pkg_inv_unique_no_generation.generate_save_requisitionno(?, ?)}";
    	String proc_name4="{call Bill_Interface.Dml_Online_Billreq(?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?)}";
    	String proc_name5="{call Bill_Interface.Dml_Online_Billreq(?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?)}";
    	
        int procIndex1 = 0;
        int procIndex2 = 0;
        int procIndex3 =0;
        int procIndex4 =0;
        int procIndex5 =0;
        
        int funcIndex = 0;
		String strRequisitionNo = "";
        HisDAO dao = null;
        int totBillQty=0;
        
         String reqno=null,billNo=null,crno=null;
         JSONObject mainObj = new JSONObject();
         HttpServletRequest request=null;
         StringBuffer buffer=new StringBuffer();
         JSONObject mainObj1 = new JSONObject(); 
         WebRowSet wb =null;
         String strRequisitionDNo="";
         String testGrpsb="";
         String testGrpQtysb="";
         String testsb="";
         String testQtysb="";
         String strBillingstrRequisitionNo="";
        try {
        	
   		    JSONObject object = new JSONObject(JsonData);
			System.out.println("JsonData"+JsonData);
			System.out.println("DrugCodeCat "+object.get("DrugCodeCat"));
			System.out.println("CR_No"+object.get("CR_No"));
			System.out.println("pat_Name"+object.get("pat_Name"));
			System.out.println("patGender"+object.get("patGender"));
			System.out.println("patAge"+object.get("patAge"));
			System.out.println("patCat"+object.get("patCat"));
			System.out.println("admissionNo"+object.get("admissionNo"));
			
   			String Crno=(String) object.get("CR_No");
   			String EpisodeCode=(String) object.get("episodeCode");
   			String seatId=(String) object.get("seatId");
   			String hosp_code=(String) object.get("hosp_code");
   			String patName=(String) object.get("pat_Name");
   			String patGender=(String) object.get("patGender");
   			String patAge=(String) object.get("patAge");
   			String PatCompleteGeneralDtl=(String) object.get("PatCompleteGeneralDtl");
   			String admissionNo = (String) object.get("admissionNo");
   			JSONArray InvesObjArray =(JSONArray) object.get("InvTestCode");
   			StringBuffer sb = new StringBuffer();
   			JSONArray ReasonOfVisit =(JSONArray) object.get("ReasonOfVisit");
   			String strInvestgationNote=(String) object.get("strInvestgationNote");
   			
   			if(ReasonOfVisit!=null)
   			   				{
   			   				
   					   			for (int i=0 ;i<ReasonOfVisit.length();i++)
   					   			{
   					   				sb.append((ReasonOfVisit.get(i).toString().split("\\^")[1]).replaceAll(";", "") +";");
   					   			}
   			   				}
   			/*int index =Arrays.asList(InvesObjArray).indexOf("0^0^0^0^0");
   			System.out.println("Index Value "+index);
   			*/
   			HashMap <String ,List> map=null;
   			HashMap <String ,List> bldMap=null;
   			List<String> l1=null;
   			List<String> bldList=null;
   			map=new HashMap<String, List>();
		   		//if(InvesObjArray.length() > 0 ){
		   			if(InvesObjArray!=null && InvesObjArray.length() >0)
		   			{
		   			for(int j=0 ;j<InvesObjArray.length();j++)
		   			{
		   				dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.getRequistion No()");
		   				String tmpInv = (String) InvesObjArray.get(j);
		   				String labCode=tmpInv.split("\\^")[1];
		   				System.out.println("labCode1:::"+labCode);
		   				l1=new ArrayList<String>();
		   				for(int k=0;k<InvesObjArray.length();k++)
		   				{
		   					String tmpInv1 = (String) InvesObjArray.get(k);
		   					//System.out.println("labCode2:::"+labCode);
		   					
		   					if(labCode.equalsIgnoreCase(tmpInv1.split("\\^")[1]))
		   					{
		   						l1.add(tmpInv1.split("\\^")[0]+"^"+tmpInv1.split("\\^")[2]+"^"+tmpInv1.split("\\^")[3]+"^"+tmpInv1.split("\\^")[6]+"^"+tmpInv1.split("\\^")[7]);   						
		   					}
		   					
		   				}
		   				map.put(labCode, l1);
		   				
		   			}
		   			System.out.println("MAP::::::::::::\n"+map);
		   			//System.out.println("List:::::::::::\n"+l1);
		   		
		   		if(map!=null)
		   		{
		   			bldMap=new HashMap<>();
	   				bldList=new ArrayList<String>();
		   			for(Map.Entry m:map.entrySet())
		   	   		{
		   				funcIndex = dao.setFunction(proc_name2);
		   	   			dao.setFuncInValue(funcIndex, 2, hosp_code);
		   				dao.setFuncInValue(funcIndex, 3, m.getKey().toString());
		   				dao.setFuncOutValue(funcIndex, 1);
		   				dao.executeFunction(funcIndex);
		   				strRequisitionNo = dao.getFuncString(funcIndex);
		   				
		   				bldMap.put(strRequisitionNo, (ArrayList)m.getValue());
		   				System.out.println("RequisitionNo::::::::"+strRequisitionNo);
		   				System.out.println("Array List :::: "+m.getValue());
		   				
		   					procIndex3 = dao.setProcedure(proc_name3);
			   	            dao.setProcInValue(procIndex3, "hmode", "4",1);
			   	            dao.setProcInValue(procIndex3, "req_no", strRequisitionNo,2);
			   	         
			   	            dao.setProcInValue(procIndex3, "puk_no", Crno,3); 
			   	            dao.setProcInValue(procIndex3, "hcode", hosp_code,4); 
			   	            dao.setProcInValue(procIndex3, "visitno", PatCompleteGeneralDtl.split("#")[4],5); 
			   	            dao.setProcInValue(procIndex3, "labcode", m.getKey().toString(),6); 
			   	         
		
			   	            dao.setProcInValue(procIndex3, "isconfidential", "0",7);
			   	            dao.setProcInValue(procIndex3, "reqheader_status", "1",8);
							dao.setProcInValue(procIndex3, "seatid", seatId,9);
							dao.setProcInValue(procIndex3, "episode_code", EpisodeCode,10);
							dao.setProcInValue(procIndex3, "patname", patName,11);
							dao.setProcInValue(procIndex3, "requisition_type",  "1",12);
							
							dao.setProcInValue(procIndex3, "dob", "",13);
							dao.setProcInValue(procIndex3, "visit_date",  PatCompleteGeneralDtl.split("#")[7],14);
							dao.setProcInValue(procIndex3, "isactual_dob",  "",15);
							dao.setProcInValue(procIndex3, "ordered_by_doc",  "",16);
							
							dao.setProcInValue(procIndex3, "gender_code", patGender,17);
							dao.setProcInValue(procIndex3, "req_raised_through", "7",18);
							dao.setProcInValue(procIndex3, "age", patAge,19);
							dao.setProcInValue(procIndex3, "admno", admissionNo,20);
							dao.setProcInValue(procIndex3, "address", "",21);
							dao.setProcInValue(procIndex3, "wardcode", "",22);
							
							dao.setProcInValue(procIndex3, "mobile_no", "",23);
							dao.setProcInValue(procIndex3, "email_id", "",24);
							dao.setProcInValue(procIndex3, "room_code", "",25);
							dao.setProcInValue(procIndex3, "bed_code", "",26);
							dao.setProcInValue(procIndex3, "mlc_no", "",27);
							dao.setProcInValue(procIndex3, "bed_name", "",28);
							
							
							dao.setProcInValue(procIndex3, "room_name", "",29);
							dao.setProcInValue(procIndex3, "ward_name", "",30);
							dao.setProcInValue(procIndex3, "dept_name", PatCompleteGeneralDtl.split("#")[8],31);
							dao.setProcInValue(procIndex3, "request_del_seatid", "",32);
							dao.setProcInValue(procIndex3, "unit_name", PatCompleteGeneralDtl.split("#")[9],33);
							dao.setProcInValue(procIndex3, "dept_code", PatCompleteGeneralDtl.split("#")[6],34);
							
							dao.setProcInValue(procIndex3, "deptunitcode", PatCompleteGeneralDtl.split("#")[5],35);
							dao.setProcInValue(procIndex3, "isautomated_request", "",36);
							dao.setProcInValue(procIndex3, "ordered_by_doc_name", "",37);
							dao.setProcInValue(procIndex3, "reffered_hospital_code", "",38);
							dao.setProcInValue(procIndex3, "reffered_dept_unit_name","",39);
							dao.setProcInValue(procIndex3, "reffered_lab_code", "",40);
							dao.setProcInValue(procIndex3, "ext_hosporlab_name", "",41);
							
							dao.setProcInValue(procIndex3, "ext_crnumber","",42);
							dao.setProcInValue(procIndex3, "bill_no", "",43);
							dao.setProcInValue(procIndex3, "delete_reason", "",44);
							dao.setProcInValue(procIndex3, "isvalid", "1",45);
							dao.setProcInValue(procIndex3, "req_date", "",46);
							dao.setProcInValue(procIndex3, "hgnum_patient_cat_code", "",47);
							dao.setProcInValue(procIndex3, "visit_reason", sb.toString()+""+strInvestgationNote,48);
							dao.setProcOutValue(procIndex3, "err", 1,49);
							dao.execute(procIndex3,1);
		   				
		   				
		   				ArrayList<String> TestCodeList=(ArrayList)m.getValue();
		   				if(TestCodeList!=null)
		   				{
		   					for(int i=0 ;i <TestCodeList.size();i++)
		   					{
		   						
		   		   	            procIndex1 = dao.setProcedure(proc_name1);
		   		   	            dao.setProcInValue(procIndex1, "hmode", "5",1);
		   		   	            dao.setProcInValue(procIndex1, "hcode", hosp_code,2);
		   		   	            if(i<9)
		   		   	            {
		   		   	            strRequisitionDNo=strRequisitionNo+"0"+(i+1);	
		   		   	            }else{
		   		   	          strRequisitionDNo=strRequisitionNo+(i+1);	
		   		   	            }
		   		   	            dao.setProcInValue(procIndex1, "reqdno", strRequisitionDNo,3); 
		   		   	            dao.setProcInValue(procIndex1, "isappointment", "0",4); 
		   		   	            dao.setProcInValue(procIndex1, "labcode", m.getKey().toString(),5); 
		   		   	            dao.setProcInValue(procIndex1, "testcode", TestCodeList.get(i).split("\\^")[0],6); 
		   		   	         
		
		   		   	            dao.setProcInValue(procIndex1, "isconfidential", "0",7);
		   		   	            dao.setProcInValue(procIndex1, "prioritycode", "1",8);
		   						dao.setProcInValue(procIndex1, "resultseatid", "",9);
		   						String staus="";
		   						//System.out.println("test Code Value"+TestCodeList.get(i).split("\\^")[1]);
		   						if(TestCodeList.get(i).split("\\^")[1].equalsIgnoreCase("-1") || TestCodeList.get(i).split("\\^")[1].equalsIgnoreCase("0"))
		   						{
		   							 staus="5";
		   						}else
		   						{
		   							staus="2";
		   						}
		   						
		   						dao.setProcInValue(procIndex1, "req_dtl_status", staus,10);
		   						dao.setProcInValue(procIndex1, "seatid", seatId,11);
		   						dao.setProcInValue(procIndex1, "app_ref_no",  "",12);
		   						
		   						dao.setProcInValue(procIndex1, "temp_sample_no", "",13);
		   						if(TestCodeList.get(i).split("\\^")[3].equals("1"))
		   						{
		   							dao.setProcInValue(procIndex1, "groupcode",  TestCodeList.get(i).split("\\^")[4].substring(5,9),14);
			   						dao.setProcInValue(procIndex1, "grouptype",  "1",15);
		   							
		   						}else
		   						{
		   							dao.setProcInValue(procIndex1, "groupcode",  "",14);
			   						dao.setProcInValue(procIndex1, "grouptype",  "",15);
		   						}
		   						dao.setProcInValue(procIndex1, "cancellation_seat_id",  "",16);
		   						
		   						dao.setProcInValue(procIndex1, "billno", "",17);
		   						dao.setProcInValue(procIndex1, "res_val_seat_id", "",18);
		   						dao.setProcInValue(procIndex1, "res_re_val_seat_id", "",19);
		   						dao.setProcInValue(procIndex1, "samplecode", TestCodeList.get(i).split("\\^")[1],20);
		   						dao.setProcInValue(procIndex1, "res_print_seat_id", "",21);
		   						dao.setProcInValue(procIndex1, "daily_lab_no", "",22);
		   						
		   						dao.setProcInValue(procIndex1, "pat_rejection_reason", "",23);
		   						dao.setProcInValue(procIndex1, "res_modify_seat_id", "",24);
		   						dao.setProcInValue(procIndex1, "pat_rejection_action", "",25);
		   						dao.setProcInValue(procIndex1, "reschedule_seat_id", "",26);
		   						dao.setProcInValue(procIndex1, "work_order_seq", "",27);
		   						dao.setProcInValue(procIndex1, "sam_rejection_action", "",28);
		   						
		   						
		   						dao.setProcInValue(procIndex1, "sam_rejection_reason", "",29);
		   						dao.setProcInValue(procIndex1, "test_delete_seat_id", "",30);
		   						dao.setProcInValue(procIndex1, "type_of_component", "",31);
		   						dao.setProcInValue(procIndex1, "req_no", strRequisitionNo,32);
		   						dao.setProcInValue(procIndex1, "is_accepted", "",33);
		   						dao.setProcInValue(procIndex1, "packing_list_no", "",34);
		   						
		   						dao.setProcInValue(procIndex1, "machinecode", "",35);
		   						dao.setProcInValue(procIndex1, "acceptance_seat_id", "",36);
		   						dao.setProcInValue(procIndex1, "collection_seat_id", "",37);
		   						dao.setProcInValue(procIndex1, "sample_col_area_code", "",38);
		   						dao.setProcInValue(procIndex1, "appointment_time","",39);
		   						dao.setProcInValue(procIndex1, "packing_list_seat_id", "",40);
		   						dao.setProcInValue(procIndex1, "is_sample_received", "",41);
		   						
		   						dao.setProcInValue(procIndex1, "sample_no","",42);
		   						dao.setProcInValue(procIndex1, "uomcode", "",43);
		   						dao.setProcInValue(procIndex1, "collected_vol", "",44);
		   						dao.setProcInValue(procIndex1, "container_code", "",45);
		   						dao.setProcInValue(procIndex1, "appointment_date", "",46);
		   						dao.setProcInValue(procIndex1, "priority_all", "",47);
		   						dao.setProcOutValue(procIndex1, "err", 1,48);
		   						dao.setProcInValue(procIndex1, "site", "",49);
		   		   	            //dao.executeProcedure(procIndex1);
		   						dao.execute(procIndex1,1);
		   						
		   					}
		   				}
		   			}
		   			
		   			
		   			
		   			/* Billing  */
		   			
		   			
		   			System.out.println("bldMap"+bldMap);
		   			if(bldMap!=null)
			   		{
		   				/*testsb=new StringBuffer();
		   				testQtysb=new StringBuffer();*/
		   				
			   			for(Map.Entry bldMap1:bldMap.entrySet())
			   	   		{
			   				String reqNo=bldMap1.getKey().toString();
			   				
			   				ArrayList<String> BLDgenerationLogic=(ArrayList)bldMap1.getValue();
			   				ArrayList<String> tariffList = new ArrayList<String>();
			   				int temprpt=0;
			   				for(int tempbld=0;tempbld<BLDgenerationLogic.size();tempbld++)
			   				{
			   					if(BLDgenerationLogic.get(tempbld).split("\\^")[3].equals("1"))
			   					{
			   						if(tempbld==0)
			   							tariffList.add(BLDgenerationLogic.get(tempbld).split("\\^")[4]);
			   						else
			   						{
			   							if(!tariffList.contains(BLDgenerationLogic.get(tempbld).split("\\^")[4]))
			   								tariffList.add(BLDgenerationLogic.get(tempbld).split("\\^")[4]);
			   						}

			   						if(BLDgenerationLogic.get(0).split("\\^")[2].equalsIgnoreCase("BLD"))
				   					{
				   						if(temprpt==0)
				   						{
				   						strBillingstrRequisitionNo=strBillingstrRequisitionNo+reqNo+"|BLD";
				   						temprpt++;
				   						}else{
				   							strBillingstrRequisitionNo=strBillingstrRequisitionNo+"|BLD";
				   							//temprpt++;
				   						}
				   						
				   					}else{
				   						strBillingstrRequisitionNo=strBillingstrRequisitionNo+reqNo;
				   					}
			   					}
								else
								{
									testQtysb+=("1"+"^");
				   					String TestCode=BLDgenerationLogic.get(tempbld).split("\\^")[0];
									testsb+=(TestCode+"#1^");
									
									if(BLDgenerationLogic.get(0).split("\\^")[2].equalsIgnoreCase("BLD"))
				   					{
				   						if(temprpt==0)
				   						{
				   						strBillingstrRequisitionNo=strBillingstrRequisitionNo+reqNo+"|BLD";
				   						temprpt++;
				   						}else{
				   							strBillingstrRequisitionNo=strBillingstrRequisitionNo+"|BLD";
				   							//temprpt++;
				   						}
				   						
				   					}else{
				   						strBillingstrRequisitionNo=strBillingstrRequisitionNo+reqNo;
				   					}
								}
			   				}
			   				strBillingstrRequisitionNo=strBillingstrRequisitionNo+"!";
			   				
			   				if(tariffList.size()>0)
			   				{
			   					for (String t : tariffList) {
			   						testGrpQtysb+=("1"+"^");
			   						testGrpsb+=(t+"#1^");
								}
			   					
			   				}
			   	   		}
			   		}
		   			
		   			//System.out.println("strBillingstrRequisitionNo"+strBillingstrRequisitionNo);
		   			if(testsb!=null && !testsb.isEmpty() && testsb.split("^").length>0)
					{
						for (int q = 0; q < testsb.split("^").length; q++) {
						procIndex4 = dao.setProcedure(proc_name4);
						dao.setProcInValue(procIndex4, "modval", "1",1);
						dao.setProcInValue(procIndex4, "gnum_dept_code", PatCompleteGeneralDtl.split("#")[6],2);
						//dao.setProcInValue(procIndex4, "sblnum_chargetype_id", PatCompleteGeneralDtl.split("#")[11],3);
						dao.setProcInValue(procIndex4, "sblnum_chargetype_id", "2",3);
						dao.setProcInValue(procIndex4, "sblnum_service_id", "1",4); 
						dao.setProcInValue(procIndex4, "gstr_req_no", strBillingstrRequisitionNo,5); 
						dao.setProcInValue(procIndex4, "gnum_treatment_cat", PatCompleteGeneralDtl.split("#")[10],6); 
						//System.out.println("gnum_treatment_cat"+PatCompleteGeneralDtl.split("#")[10]);
						//System.out.println("testsb.toString().substring(0, testsb.toString().length() - 1)"+testsb.toString().substring(0, testsb.toString().length() - 1));
						dao.setProcInValue(procIndex4, "hrgnum_episode_code", EpisodeCode,7);
						dao.setProcInValue(procIndex4, "hrgnum_puk", Crno,8);
						dao.setProcInValue(procIndex4, "gstr_tariff", testsb.toString().substring(0, testsb.toString().length() - 1),9);
						dao.setProcInValue(procIndex4, "gstr_reqqty", testQtysb.toString().substring(0, testQtysb.toString().length() - 1),10);
						dao.setProcInValue(procIndex4, "hblstr_patient_name", "0",11);
						//dao.setProcInValue(procIndex4, "app_ref_no",  "",12);
						
						dao.setProcInValue(procIndex4, "hblstr_pat_address", "0",12);
						dao.setProcInValue(procIndex4, "hblstr_contact_no",  "0",13);
						dao.setProcInValue(procIndex4, "age",  "0",14);
						dao.setProcInValue(procIndex4, "ageunit",  "0",15);
						
						dao.setProcInValue(procIndex4, "gender", "0",16);
						dao.setProcInValue(procIndex4, "refdoctor", "0",17);
						dao.setProcInValue(procIndex4, "refdoccontactno", "0",18);
						dao.setProcInValue(procIndex4, "gnum_seatid", seatId,19);
						dao.setProcInValue(procIndex4, "hosp_code", hosp_code,20);
						dao.setProcInValue(procIndex4, "ward_code", "0",21);
						
						dao.setProcInValue(procIndex4, "admno", admissionNo,22);
						dao.setProcInValue(procIndex4, "visitno", "1",23);
						dao.setProcOutValue(procIndex4, "err",1, 24);
						
						//dao.executeProcedure(procIndex1);
						dao.execute(procIndex4,1);
						}
					}
		   			if(testGrpsb!=null && !testGrpsb.isEmpty() && testGrpsb.split("^").length>0)
					{
						for (int q = 0; q < testsb.split("^").length; q++) {
						procIndex5 = dao.setProcedure(proc_name5);
						dao.setProcInValue(procIndex5, "modval", "1",1);
						dao.setProcInValue(procIndex5, "gnum_dept_code", PatCompleteGeneralDtl.split("#")[6],2);
						//dao.setProcInValue(procIndex4, "sblnum_chargetype_id", PatCompleteGeneralDtl.split("#")[11],3);
						dao.setProcInValue(procIndex5, "sblnum_chargetype_id", "2",3);
						dao.setProcInValue(procIndex5, "sblnum_service_id", "4",4); 
						dao.setProcInValue(procIndex5, "gstr_req_no", strBillingstrRequisitionNo,5); 
						dao.setProcInValue(procIndex5, "gnum_treatment_cat", PatCompleteGeneralDtl.split("#")[10],6); 
						//System.out.println("gnum_treatment_cat"+PatCompleteGeneralDtl.split("#")[10]);
						//System.out.println("testGrpsb.toString().substring(0, testGrpsb.toString().length() - 1)"+testGrpsb.toString().substring(0, testGrpsb.toString().length() - 1));
						dao.setProcInValue(procIndex5, "hrgnum_episode_code", EpisodeCode,7);
						dao.setProcInValue(procIndex5, "hrgnum_puk", Crno,8);
						dao.setProcInValue(procIndex5, "gstr_tariff", testGrpsb.toString().substring(0, testGrpsb.toString().length() - 1),9);
						dao.setProcInValue(procIndex5, "gstr_reqqty", testGrpQtysb.toString().substring(0, testGrpQtysb.toString().length() - 1),10);
						dao.setProcInValue(procIndex5, "hblstr_patient_name", "0",11);
						//dao.setProcInValue(procIndex4, "app_ref_no",  "",12);
						
						dao.setProcInValue(procIndex5, "hblstr_pat_address", "0",12);
						dao.setProcInValue(procIndex5, "hblstr_contact_no",  "0",13);
						dao.setProcInValue(procIndex5, "age",  "0",14);
						dao.setProcInValue(procIndex5, "ageunit",  "0",15);
						
						dao.setProcInValue(procIndex5, "gender", "0",16);
						dao.setProcInValue(procIndex5, "refdoctor", "0",17);
						dao.setProcInValue(procIndex5, "refdoccontactno", "0",18);
						dao.setProcInValue(procIndex5, "gnum_seatid", seatId,19);
						dao.setProcInValue(procIndex5, "hosp_code", hosp_code,20);
						dao.setProcInValue(procIndex5, "ward_code", "0",21);
						
						dao.setProcInValue(procIndex5, "admno", admissionNo,22);
						dao.setProcInValue(procIndex5, "visitno", "1",23);
						dao.setProcOutValue(procIndex5, "err",1, 24);
						
						//dao.executeProcedure(procIndex1);
						dao.execute(procIndex5,1);
						}
					}
		   			
		   			
		   		}
		   		
		   		synchronized (dao) 
				{
					
						dao.fire();
						return "DATA INSERTED SUCCESSFULLY";
				}
		   	}
		   //}
         
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.SaveInvData()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return "Something Went Wrong";
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
		return "No Record Updated";
		
		
	}

	public static String SaveGenralData(String JsonData) {
		System.out.println("method called for ipd SaveGenralData3--->");
		String err = "";
    	String proc_name1 = "{call pkg_ipdDesk_dml.proc_hrgt_episode_diagnosis_dml(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?)}";
    	
        int procIndex1 = 0;
        int procIndex2 = 0;
        HisDAO dao = null;
        int totBillQty=0;
        
         String reqno=null,billNo=null,crno=null;
         JSONObject mainObj = new JSONObject();
         HttpServletRequest request=null;
         StringBuffer buffer=new StringBuffer();
         JSONObject mainObj1 = new JSONObject(); 
        
        try {
        	
   		 JSONObject object = new JSONObject(JsonData);
			System.out.println("JsonData"+JsonData);
			System.out.println("Diagnosis "+object.get("Diagnosis"));
			System.out.println("CR_No"+object.get("CR_No"));
			System.out.println("episodeCode"+object.get("episodeCode"));
			System.out.println("admissionNo=="+object.get("admissionNo"));
   			String Crno=(String) object.get("CR_No");
   			String EpisodeCode=(String) object.get("episodeCode");
   			String seatId=(String) object.get("seatId");
   			String hosp_code=(String) object.get("hosp_code");
   			String admissionNo=(String) object.get("admissionNo");
   			JSONArray Diagnosis =(JSONArray) object.get("Diagnosis");
   			String PatCompleteGeneralDtl=(String) object.get("PatCompleteGeneralDtl");
   			if(Diagnosis!=null)
   				{
   				
		   			for (int i=0 ;i<Diagnosis.length();i++)
		   			{
		   				
		   				dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
		   	            procIndex1 = dao.setProcedure(proc_name1);
		   	            dao.setProcInValue(procIndex1, "p_mode", "1",1);
		   	            dao.setProcInValue(procIndex1, "p_puk", Crno,2);
		   	            dao.setProcInValue(procIndex1, "p_episodecode", EpisodeCode,3); 
		   	            dao.setProcInValue(procIndex1, "p_visit_no", PatCompleteGeneralDtl.split("#")[4],4); 
		   	            dao.setProcInValue(procIndex1, "p_admissionno", admissionNo,5); 
		   	            String tmp[] = Diagnosis.getString(i).split("\\^");
		   	            dao.setProcInValue(procIndex1, "p_diagnostictypecode", tmp[0].split("#")[1],6); 
		   	          // String tmpArray[]=tmp.split("&&");*/
		   	            System.out.println("Diagnosis Code"+tmp[0].split("#")[0]);
		   	            dao.setProcInValue(procIndex1, "p_diagnosticcode",tmp[0].split("#")[0] ,7); 
		   	            dao.setProcInValue(procIndex1, "p_seat_id", seatId,8);
						dao.setProcInValue(procIndex1, "p_isvalid", "1",9);
						dao.setProcInValue(procIndex1, "p_episodedate", "",10);
						dao.setProcInValue(procIndex1, "p_remarks", "",11);
						//System.out.println(tmp[0] +"fffffffffffffffffffff"+tmp[0].split("#")[2]);
						dao.setProcInValue(procIndex1, "p_diagnosiscode_type",  tmp[0].split("#")[2],12);
						
						dao.setProcInValue(procIndex1, "p_hospcode",  hosp_code,13);
						dao.setProcInValue(procIndex1, "p_isrepeat",  "0",14);
						dao.setProcInValue(procIndex1, "p_diseasesiteid",  "",15);
						dao.setProcInValue(procIndex1, "p_diagnostic_name",  tmp[1].split("#")[0],16);
						
						dao.setProcInValue(procIndex1, "p_diagnostictypename",  tmp[1].split("#")[1],17);
						dao.setProcInValue(procIndex1, "p_disease_site", "",18);
						dao.setProcInValue(procIndex1, "p_source", "",19);
						dao.setProcInValue(procIndex1, "p_somedicdmapped", "",20);
						
		   	            dao.setProcOutValue(procIndex1, "err", 1,21);
		   	            dao.executeProcedureByPosition(procIndex1);
		   	    	}
   				}
            return "DATA INSERTED SUCCESSFULLY";
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.SaveGenralData()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return "Something Went Wrong";
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
        
		
	}

	public static String SaveVisitReasonData(String JsonData) {
		System.out.println("method called for ipd SaveVisitReasonData4--->");
		String err = "";
    	String proc_name1 = "{call pkg_ipdDesk_dml.proc_hrgt_episode_dtl(?,?,?,?,?, ?,?,?,?,?,?)}";
    	
        int procIndex1 = 0;
        int procIndex2 = 0;
        HisDAO dao = null;
        int totBillQty=0;
        
         String reqno=null,billNo=null,crno=null;
         JSONObject mainObj = new JSONObject();
         HttpServletRequest request=null;
         StringBuffer buffer=new StringBuffer();
         JSONObject mainObj1 = new JSONObject(); 
        
        try {
        	
   		 JSONObject object = new JSONObject(JsonData);
			System.out.println("JsonData"+JsonData);
			System.out.println("Diagnosis "+object.get("Diagnosis"));
			System.out.println("CR_No"+object.get("CR_No"));
			System.out.println("episodeCode"+object.get("episodeCode"));
			System.out.println("admissionNo"+object.get("admissionNo"));
   			String Crno=(String) object.get("CR_No");
   			String EpisodeCode=(String) object.get("episodeCode");
   			String seatId=(String) object.get("seatId");
   			String hosp_code=(String) object.get("hosp_code");
   			JSONArray ReasonOfVisit =(JSONArray) object.get("ReasonOfVisit");
   			String PatCompleteGeneralDtl=(String) object.get("PatCompleteGeneralDtl");
   			String admissionNo=(String) object.get("admissionNo");
   			StringBuffer sb=new StringBuffer();
   			if(ReasonOfVisit!=null)
   				{
   				
		   			for (int i=0 ;i<ReasonOfVisit.length();i++)
		   			{
		   				sb.append((ReasonOfVisit.get(i).toString().split("\\^")[1]).replaceAll(";", "") +";");
		   			}
   				}
		   			if(ReasonOfVisit.length()>0)
		   			{
		   				dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
		   	            procIndex1 = dao.setProcedure(proc_name1);
		   	            dao.setProcInValue(procIndex1, "p_mode", "1",1);
		   	            dao.setProcInValue(procIndex1, "p_puk", Crno,2);
		   	            dao.setProcInValue(procIndex1, "p_hospcode", hosp_code,3); 
		   	            dao.setProcInValue(procIndex1, "p_visitreason", sb.toString(),4); 
		   	            dao.setProcInValue(procIndex1, "p_snomedpt", "0",5); 
		   	            dao.setProcInValue(procIndex1, "p_snomedcid", "1",6); 
		   	            dao.setProcInValue(procIndex1, "p_episodecode",EpisodeCode ,7);
		   	            dao.setProcInValue(procIndex1, "p_visitno", PatCompleteGeneralDtl.split("#")[4],8);
		   	            dao.setProcInValue(procIndex1, "p_isvalid", "1",9);
		   	            dao.setProcInValue(procIndex1, "p_admno",admissionNo ,10);						
						
		   	            dao.setProcOutValue(procIndex1, "err", 1,11);
		   	            dao.executeProcedureByPosition(procIndex1);
		   			}
		   			return "DATA INSERTED SUCCESSFULLY";
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.SaveVisitReasonData()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return "Something Went Wrong";
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
        
	}
	public static String FollowUpDTL(String JsonData) {
		System.out.println("method called for ipd FollowUpDTL5--->");
		String err = "";
    	String proc_name1 = "{call pkg_ipdDesk_dml.proc_save_pat_follow_up_dtl(?,?,?,?,?, ?,?,?,?,? ,?)}";
    	
        int procIndex1 = 0;
        int procIndex2 = 0;
        HisDAO dao = null;
        int totBillQty=0;
        
         String reqno=null,billNo=null,crno=null;
         JSONObject mainObj = new JSONObject();
         HttpServletRequest request=null;
         StringBuffer buffer=new StringBuffer();
         JSONObject mainObj1 = new JSONObject(); 
        
        try {
        	
   		 JSONObject object = new JSONObject(JsonData);
			System.out.println("JsonData"+JsonData);
			System.out.println("Diagnosis "+object.get("Diagnosis"));
			System.out.println("CR_No"+object.get("CR_No"));
			System.out.println("episodeCode"+object.get("episodeCode"));
			System.out.println("admissionNo"+object.get("admissionNo"));
   			String Crno=(String) object.get("CR_No");
   			String EpisodeCode=(String) object.get("episodeCode");
   			String seatId=(String) object.get("seatId");
   			String hosp_code=(String) object.get("hosp_code");
   			String admissionNo=(String) object.get("admissionNo");
   			JSONArray ReasonOfVisit =(JSONArray) object.get("ReasonOfVisit");
   			String PatCompleteGeneralDtl=(String) object.get("PatCompleteGeneralDtl");
   			JSONArray FOLLOWUPDTL=(JSONArray) object.get("FOLLOW_UP");
   			StringBuffer sb=new StringBuffer();
   			
		   			if(FOLLOWUPDTL.length()>0)
		   			{
		   				JSONObject FollowupJson= (JSONObject) FOLLOWUPDTL.get(0);
		   				JSONArray arr=(JSONArray) FollowupJson.get("Planned_Visit");
		   				
		   				String  progressNote=(String) FollowupJson.get("progressNote").toString().replaceAll("[\\[\\]]", "");
		   				//String  progressNote=(String) FollowupJson.get("progressNoteNew");
		   				
		   				System.out.println("arr"+arr);
		   				JSONObject temp=(JSONObject) arr.get(0);
		   				
		   				//JSONObject temp1=(JSONObject) arr.get(0);
		   				System.out.println("plannedVisitDays"+temp.get("plannedVisitSos"));
		   				dao = new HisDAO("OPD DR DESK DAO", "FollowUpDTL.save()");
		   	            procIndex1 = dao.setProcedure(proc_name1);
		   	            dao.setProcInValue(procIndex1, "p_mode", "1",1);
		   	            dao.setProcInValue(procIndex1, "p_puk", Crno,2);
		   	            dao.setProcInValue(procIndex1, "p_hospcode", hosp_code,3); 
		   	            dao.setProcInValue(procIndex1, "p_visitreason", "",4); 
		   	            dao.setProcInValue(procIndex1, "p_episodecode",EpisodeCode ,5); 
		   	            dao.setProcInValue(procIndex1, "p_visitno", PatCompleteGeneralDtl.split("#")[4],6);
		   	            dao.setProcInValue(procIndex1, "p_is_open", "1",7);
						dao.setProcInValue(procIndex1, "p_is_confirm", "1",8);
						dao.setProcInValue(procIndex1, "p_visitnotes", progressNote,9);
						dao.setProcInValue(procIndex1, "p_visitdate", temp.getString("plannedVisitDate"),10);
						dao.setProcOutValue(procIndex1, "err", 1,11);
		   	            dao.executeProcedureByPosition(procIndex1);
		   			}
		   			return "DATA INSERTED SUCCESSFULLY";
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.FollowUpDTL()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return "Something Went Wrong";
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
        
	}

	public static String SaveEHRData(String JsonData) {
		System.out.println("method called for ipd SaveEHRData6--->");
		String err = "";
    	String proc_name1 = "{call pkg_ipdDesk_dml.hrgt_ehrjson_dtl(?,?,?,?,?, ?,?,?,?,?)}";
    	
        int procIndex1 = 0;
        int procIndex2 = 0;
        HisDAO dao = null;
        int totBillQty=0;
        
         String reqno=null,billNo=null,crno=null;
         JSONObject mainObj = new JSONObject();
         HttpServletRequest request=null;
         StringBuffer buffer=new StringBuffer();
         JSONObject mainObj1 = new JSONObject(); 
        
        try {
        	
   		 JSONObject object = new JSONObject(JsonData);
			System.out.println("JsonData"+JsonData);
			System.out.println("Diagnosis "+object.get("Diagnosis"));
			System.out.println("CR_No"+object.get("CR_No"));
			System.out.println("episodeCode"+object.get("episodeCode"));
			System.out.println("admissionNo"+object.get("admissionNo"));
   			String Crno=(String) object.get("CR_No");
   			String EpisodeCode=(String) object.get("episodeCode");
   			String seatId=(String) object.get("seatId");
   			String hosp_code=(String) object.get("hosp_code");
   			String admissionNo=(String) object.get("admissionNo");
   			JSONArray ReasonOfVisit =(JSONArray) object.get("ReasonOfVisit");
   			String PatCompleteGeneralDtl=(String) object.get("PatCompleteGeneralDtl");
   			StringBuffer sb=new StringBuffer();
   			
			dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "p_mode", "1",1);
            dao.setProcInValue(procIndex1, "p_puk", Crno,2);
            dao.setProcInValue(procIndex1, "p_hospcode", hosp_code,3); 
            dao.setProcInValue(procIndex1, "p_seatId", seatId,4); 
            dao.setProcInValue(procIndex1, "p_episodecode",EpisodeCode ,5); 
            dao.setProcInValue(procIndex1, "p_visitno", PatCompleteGeneralDtl.split("#")[4],6);
            dao.setProcInValue(procIndex1, "p_json", JsonData,7);
			dao.setProcInValue(procIndex1, "p_isvalid", "1",8);
			dao.setProcInValue(procIndex1, "p_admno", admissionNo,9);
			
            dao.setProcOutValue(procIndex1, "err", 1,10);
            dao.executeProcedureByPosition(procIndex1);
		   		
		   			return "DATA INSERTED SUCCESSFULLY";
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.SaveEHRData()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return "Something Went Wrong";
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
		
		
	}
	public static String SaveAllergyData(String JsonData) {

		String err = "";
    	
        int procIndex1 = 0;
        int procIndex2 = 0;
        HisDAO dao = null;
        int totBillQty=0;
        
         //String reqno=null,billNo=null,crno=null;
         JSONObject mainObj = new JSONObject();
         HttpServletRequest request=null;
         StringBuffer buffer=new StringBuffer();
         JSONObject mainObj1 = new JSONObject();
         
         String strSensivityName=null,strAllergySytmptomsCode=null,strAllergysiteName=null,strAllergyRemarks=null,strSensivityCode=null,strAllergyNameCode=null,strAllergySytmptomsName=null,strAllergyName=null,stDurationTime=null,strAllergysiteCode=null;
        
        try {
        	
   		 JSONObject object = new JSONObject(JsonData);
   		 System.out.println("JsonData"+JsonData);
		System.out.println("strDrugAllergy "+object.get("strDrugAllergy"));
		System.out.println("CR_No"+object.get("CR_No"));
		System.out.println("episodeCode"+object.get("episodeCode"));
		System.out.println("admissionNo"+object.get("admissionNo"));

   			String Crno=(String) object.get("CR_No");
   			String EpisodeCode=(String) object.get("episodeCode");
   			String seatId=(String) object.get("seatId");
   			String hosp_code=(String) object.get("hosp_code");
   			String visitNo=(String) object.get("episodeVisitNo");
   			//String strRefrealRemaks=(String) object.get("strReffralReason");
   			String admissionNo=(String) object.get("admissionNo");
   			
   			StringBuffer sb=new StringBuffer();
   			JSONArray strDrugAllergy =(JSONArray) object.get("strDrugAllergy");
   			int length=((JSONArray) object.get("strDrugAllergy")).length();
   			dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
   			
   			for(int i=0 ; i< length ; i++){
   			 
   			 JSONObject strjsonObj =(JSONObject) strDrugAllergy.get(i);

   			 strSensivityName = (String) strjsonObj.get("strSensivityName")==null ? "" : (String) strjsonObj.get("strSensivityName") ;
             strAllergySytmptomsCode = (String) strjsonObj.get("strAllergySytmptomsCode")==null ? "" : (String) strjsonObj.get("strAllergySytmptomsCode") ;
             strAllergysiteName = (String) strjsonObj.get("strAllergysiteName")==null ? "" : (String) strjsonObj.get("strAllergysiteName") ;
             strAllergyRemarks = (String) strjsonObj.get("strAllergyRemarks")==null ? "" : (String) strjsonObj.get("strAllergyRemarks") ;
             strSensivityCode = (String) strjsonObj.get("strSensivityCode")==null ? "" : (String) strjsonObj.get("strSensivityCode") ;
             strAllergyNameCode = (String) strjsonObj.get("strAllergyNameCode")==null ? "" : (String) strjsonObj.get("strAllergyNameCode") ;
             strAllergySytmptomsName = (String) strjsonObj.get("strAllergySytmptomsName")==null ? "" : (String) strjsonObj.get("strAllergySytmptomsName") ;
             strAllergyName = (String) strjsonObj.get("strAllergyName")==null ? "" : ((String) strjsonObj.get("strAllergyName")).replace(";",""); ;
             stDurationTime = (String) strjsonObj.get("stDurationTime")==null ? "" : (String) strjsonObj.get("stDurationTime") ;
             strAllergysiteCode = (String) strjsonObj.get("strAllergysiteCode")==null ? "" : (String) strjsonObj.get("strAllergysiteCode") ;
   			
   			 String proc_name1 = "{call pkg_ipdDesk_dml.proc_hpmrt_pat_allergy_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?)}";
   			 procIndex1 = dao.setProcedure(proc_name1);
             dao.setProcInValue(procIndex1, "p_mode", "1",1);
             dao.setProcInValue(procIndex1, "p_puk", Crno,2);
             dao.setProcInValue(procIndex1, "p_allergy_name", strAllergyName,3);
             dao.setProcInValue(procIndex1, "p_allergy_type_code", strSensivityName,4); 
             dao.setProcInValue(procIndex1, "p_effective_frm","" ,5); 
             dao.setProcInValue(procIndex1, "p_allergy_type", strSensivityName,6);
             dao.setProcInValue(procIndex1, "p_allergy_id", strAllergyNameCode,7);
             dao.setProcInValue(procIndex1, "p_isvalid", "1",8); 
             dao.setProcInValue(procIndex1, "p_seatid",seatId,9); 
             dao.setProcInValue(procIndex1, "p_hospcode", hosp_code,10);
             dao.setProcInValue(procIndex1, "p_duration_date",stDurationTime,11); 
             dao.setProcInValue(procIndex1, "p_entry_mode","3",12); 
             dao.setProcInValue(procIndex1, "p_episodecode",EpisodeCode,13); 
             dao.setProcInValue(procIndex1, "p_admission_no", admissionNo,14);
             dao.setProcInValue(procIndex1, "p_sensitivity", strSensivityCode,15);
             dao.setProcInValue(procIndex1, "p_symtom_desc", strAllergySytmptomsName+"^"+strAllergySytmptomsCode,16);
             dao.setProcInValue(procIndex1, "p_allergy_site", strAllergysiteName+"^"+strAllergysiteCode,17);
             dao.setProcInValue(procIndex1, "p_advice", strAllergyRemarks,18);
             dao.setProcOutValue(procIndex1, "err", 1,19);
             dao.execute(procIndex1, 1);
   			
   			}
   			
   			synchronized (dao) {
				dao.fire();
			}
   			 		
		   			return "1";
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.SaveAllergyData()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return "2";
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
	}
	
	
	public static String SaveChronicData(String JsonData) {

		String err = "";
    	
        int procIndex1 = 0;
        int procIndex2 = 0;
        HisDAO dao = null;
        int totBillQty=0;
        
         //String reqno=null,billNo=null,crno=null;
         JSONObject mainObj = new JSONObject();
         HttpServletRequest request=null;
         StringBuffer buffer=new StringBuffer();
         JSONObject mainObj1 = new JSONObject(); 
         
         String strCronicDiseaseName=null,strCronicDiseaseId=null,strCronicDiseaseDuration=null,strCronicDiseaseRemarks=null;
        
        try {
        	
   		 JSONObject object = new JSONObject(JsonData);
   		System.out.println("JsonData"+JsonData);
		System.out.println("strChronicDisease "+object.get("strChronicDisease"));
		System.out.println("CR_No"+object.get("CR_No"));
		System.out.println("episodeCode"+object.get("episodeCode"));
		System.out.println("admissionNo"+object.get("admissionNo"));

   			String Crno=(String) object.get("CR_No");
   			String EpisodeCode=(String) object.get("episodeCode");
   			String seatId=(String) object.get("seatId");
   			String hosp_code=(String) object.get("hosp_code");
   			String visitNo=(String) object.get("episodeVisitNo");
   			String admissionNo=(String) object.get("admissionNo");
   			//String strRefrealRemaks=(String) object.get("strReffralReason");
   			
   			StringBuffer sb=new StringBuffer();
   			JSONArray strChronicDisease =(JSONArray) object.get("strChronicDisease");
   			int length=((JSONArray) object.get("strChronicDisease")).length();
   			dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
   			
   			for(int i=0 ; i< length ; i++){
   			 
   			 JSONObject strjsonObj =(JSONObject) strChronicDisease.get(i);

   			 strCronicDiseaseName = (String) strjsonObj.get("CronicDiseaseName")==null ? "" : ((String) strjsonObj.get("CronicDiseaseName")).replace(";",""); 
   			 strCronicDiseaseId = (String) strjsonObj.get("CronicDiseaseId")==null ? "" : (String) strjsonObj.get("CronicDiseaseId") ;
   			 strCronicDiseaseDuration = (String) strjsonObj.get("CronicDiseaseDuration")==null ? "" : (String) strjsonObj.get("CronicDiseaseDuration") ;
   			 strCronicDiseaseRemarks = (String) strjsonObj.get("CronicDiseaseRemarks")==null ? "" : (String) strjsonObj.get("CronicDiseaseRemarks") ;
   			
   			 String proc_name1 = "{call pkg_ipdDesk_dml.proc_hpmrt_pat_alerts_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?)}";
   			 procIndex1 = dao.setProcedure(proc_name1);
             dao.setProcInValue(procIndex1, "p_mode", "1",1);
             dao.setProcInValue(procIndex1, "p_puk", Crno,2);
             dao.setProcInValue(procIndex1, "p_disease_name", strCronicDiseaseName,3);
             dao.setProcInValue(procIndex1, "p_disease_code", strCronicDiseaseId,4); 
             dao.setProcInValue(procIndex1, "p_effective_frm","" ,5); 
             dao.setProcInValue(procIndex1, "p_advice",strCronicDiseaseRemarks,6);
             dao.setProcInValue(procIndex1, "p_duration_date", strCronicDiseaseDuration,7);
             dao.setProcInValue(procIndex1, "p_visitno", visitNo,8);
             dao.setProcInValue(procIndex1, "p_isvalid", "1",9); 
             dao.setProcInValue(procIndex1, "p_admission_no", admissionNo,10);
             dao.setProcInValue(procIndex1, "p_seatid",seatId,11); 
             dao.setProcInValue(procIndex1, "p_hospcode", hosp_code,12);
             dao.setProcInValue(procIndex1, "p_entry_mode","3",13); 
             dao.setProcInValue(procIndex1, "p_episodecode",EpisodeCode,14);
             dao.setProcOutValue(procIndex1, "err", 1,15);
             dao.execute(procIndex1, 1);
   			
   			}
   			
   			synchronized (dao) {
				dao.fire();
			}
   			 		
		   			return "1";
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.SaveChronicData()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return "2";
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
	}
	
	public static String SaveHistoryOfPresentIllNess(String JsonData) {

		String err = "";
    	
        int procIndex1 = 0;
        int procIndex2 = 0;
        HisDAO dao = null;
        int totBillQty=0;
        
         //String reqno=null,billNo=null,crno=null;
         JSONObject mainObj = new JSONObject();
         HttpServletRequest request=null;
         StringBuffer buffer=new StringBuffer();
         JSONObject mainObj1 = new JSONObject(); 
         
         String strpastHistory=null,strpersonalHistory=null,strfamilyHistory=null,strtreatmentHistory=null,strsurgicalHistory=null;
        
        try {
        	
   		 JSONObject object = new JSONObject(JsonData);
   		System.out.println("JsonData"+JsonData);
		System.out.println("strCompleteHistory "+object.get("strCompleteHistory"));
		System.out.println("CR_No"+object.get("CR_No"));
		System.out.println("episodeCode"+object.get("episodeCode"));
		System.out.println("admissionNo"+object.get("admissionNo"));
		
			String Crno=(String) object.get("CR_No");
   			String EpisodeCode=(String) object.get("episodeCode");
   			String seatId=(String) object.get("seatId");
   			String hosp_code=(String) object.get("hosp_code");
   			String visitNo=(String) object.get("episodeVisitNo");
   			String admissionNo=(String) object.get("admissionNo");
   			//String strRefrealRemaks=(String) object.get("strReffralReason");
   			
   			StringBuffer sb=new StringBuffer();
   			//JSONArray strCompleteHistory =(JSONArray) object.get("strCompleteHistory");
   			//int length=((JSONArray) object.get("strCompleteHistory")).length();
   			dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
   			
   			
   			 String strHistoryOfPresentIllNess=(String) object.get("strHistoryOfPresentIllNess")==null ? "" : (String) object.get("strHistoryOfPresentIllNess") ;
   			 JSONObject strjsonObj =(JSONObject) object.get("strCompleteHistory");

   			 strpastHistory = (String) strjsonObj.get("strpastHistory")==null ? "" : ((String) strjsonObj.get("strpastHistory")).replace(";",""); 
   			 strpersonalHistory = (String) strjsonObj.get("strpersonalHistory")==null ? "" : (String) strjsonObj.get("strpersonalHistory") ;
   			 strfamilyHistory = (String) strjsonObj.get("strfamilyHistory")==null ? "" : (String) strjsonObj.get("strfamilyHistory") ;
   			 strtreatmentHistory = (String) strjsonObj.get("strtreatmentHistory")==null ? "" : (String) strjsonObj.get("strtreatmentHistory") ;
   			 strsurgicalHistory = (String) strjsonObj.get("strsurgicalHistory")==null ? "" : (String) strjsonObj.get("strsurgicalHistory") ;
   			
			
			  String proc_name1 =  "{call pkg_ipdDesk_dml.proc_ehrt_pat_hpi_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?)}" ; 
			  procIndex1 = dao.setProcedure(proc_name1); 
			  dao.setProcInValue(procIndex1, "p_mode", "1",1);
			  dao.setProcInValue(procIndex1, "p_puk", Crno,2);
			  dao.setProcInValue(procIndex1, "p_hospcode", hosp_code,3);
			  dao.setProcInValue(procIndex1, "p_episodecode",EpisodeCode,4);
			  dao.setProcInValue(procIndex1, "p_visitno", visitNo,5);
			  dao.setProcInValue(procIndex1, "p_record_date", "" ,6);
			  dao.setProcInValue(procIndex1, "p_slno", "1",7);
			  dao.setProcInValue(procIndex1, "p_admission_no", admissionNo,8);
			  dao.setProcInValue(procIndex1, "p_hpi",strHistoryOfPresentIllNess ,9);
			  dao.setProcInValue(procIndex1, "p_personal_history",strpersonalHistory,10);
			  dao.setProcInValue(procIndex1, "p_family_history",strfamilyHistory,11); 
			  dao.setProcInValue(procIndex1, "p_treatment_history", strtreatmentHistory,12); 
			  dao.setProcInValue(procIndex1, "p_surgical_history",strsurgicalHistory,13);
			  dao.setProcInValue(procIndex1, "p_drug_addiction_history","",14);
			  dao.setProcInValue(procIndex1, "p_menstrual_obstetrics_history", "",15);
			  dao.setProcInValue(procIndex1, "p_birth_history", "",16); 
			  dao.setProcInValue(procIndex1, "p_development_history", "",17);
			  dao.setProcInValue(procIndex1, "p_immunization_history", "",18);
			  dao.setProcInValue(procIndex1, "p_nutrition_history", "",19); 
			  dao.setProcInValue(procIndex1, "p_isvalid", "1",20);
			  dao.setProcInValue(procIndex1, "p_seatid",seatId,21);
			  dao.setProcInValue(procIndex1, "p_entry_source","3",22);
			  dao.setProcInValue(procIndex1, "p_past_history",strpastHistory,23);
			  dao.setProcInValue(procIndex1, "p_other_relevant_history","",24);
			  
			  dao.setProcOutValue(procIndex1, "err", 1,25);
			  
			  dao.executeProcedureByPosition(procIndex1);
			  
              return "1";
   			

        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.SaveHistoryOfPresentIllNess()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return "2";
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
	}
	
	public static String SaveCompleteHistoryData(String JsonData) {

		String err = "";
    	
        int procIndex1 = 0;
        int procIndex2 = 0;
        HisDAO dao = null;
        int totBillQty=0;
        
         //String reqno=null,billNo=null,crno=null;
         JSONObject mainObj = new JSONObject();
         HttpServletRequest request=null;
         StringBuffer buffer=new StringBuffer();
         JSONObject mainObj1 = new JSONObject(); 
         
         String strpastHistory=null,strpersonalHistory=null,strfamilyHistory=null,strtreatmentHistory=null,strsurgicalHistory=null;
        
        try {
        	
   		 JSONObject object = new JSONObject(JsonData);
   		System.out.println("JsonData"+JsonData);
		System.out.println("strCompleteHistory 2 "+object.get("strCompleteHistory"));
		System.out.println("CR_No"+object.get("CR_No"));
		System.out.println("episodeCode"+object.get("episodeCode"));
		System.out.println("admissionNo"+object.get("admissionNo"));

   			String Crno=(String) object.get("CR_No");
   			String EpisodeCode=(String) object.get("episodeCode");
   			String seatId=(String) object.get("seatId");
   			String hosp_code=(String) object.get("hosp_code");
   			String visitNo=(String) object.get("episodeVisitNo");
   			String admissionNo=(String) object.get("admissionNo");
   			//String strRefrealRemaks=(String) object.get("strReffralReason");
   			
   			StringBuffer sb=new StringBuffer();
   			//JSONArray strCompleteHistory =(JSONArray) object.get("strCompleteHistory");
   			//int length=((JSONArray) object.get("strCompleteHistory")).length();
   			dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
   			
   			
   			// String strHistoryOfPresentIllNess=(String) object.get("strHistoryOfPresentIllNess")==null ? "" : (String) object.get("strHistoryOfPresentIllNess") ;
   			 JSONObject strjsonObj =(JSONObject) object.get("strCompleteHistory");

   			 strpastHistory = (String) strjsonObj.get("strpastHistory")==null ? "" : ((String) strjsonObj.get("strpastHistory")).replace(";",""); 
   			 strpersonalHistory = (String) strjsonObj.get("strpersonalHistory")==null ? "" : (String) strjsonObj.get("strpersonalHistory") ;
   			 strfamilyHistory = (String) strjsonObj.get("strfamilyHistory")==null ? "" : (String) strjsonObj.get("strfamilyHistory") ;
   			 strtreatmentHistory = (String) strjsonObj.get("strtreatmentHistory")==null ? "" : (String) strjsonObj.get("strtreatmentHistory") ;
   			 strsurgicalHistory = (String) strjsonObj.get("strsurgicalHistory")==null ? "" : (String) strjsonObj.get("strsurgicalHistory") ;
   			
			
			  String proc_name1 =  "{call pkg_ipdDesk_dml.proc_ehrt_pat_cln_history_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?)}" ; 
			  procIndex1 = dao.setProcedure(proc_name1); 
			  dao.setProcInValue(procIndex1, "p_mode", "1",1);
			  dao.setProcInValue(procIndex1, "p_puk", Crno,2);
			  dao.setProcInValue(procIndex1, "p_hospcode", hosp_code,3);
			  dao.setProcInValue(procIndex1, "p_episodecode",EpisodeCode,4);
			  dao.setProcInValue(procIndex1, "p_visitno", visitNo,5);
			  dao.setProcInValue(procIndex1, "p_record_date", "" ,6);
			  dao.setProcInValue(procIndex1, "p_slno", "1",7);
			  dao.setProcInValue(procIndex1, "p_admission_no", admissionNo,8);
			  dao.setProcInValue(procIndex1, "p_personal_history",strpersonalHistory,9);
			  dao.setProcInValue(procIndex1, "p_family_history",strfamilyHistory,10); 
			  dao.setProcInValue(procIndex1, "p_treatment_history", strtreatmentHistory,11); 
			  dao.setProcInValue(procIndex1, "p_surgical_history",strsurgicalHistory,12);
			  dao.setProcInValue(procIndex1, "p_drug_addiction_history","",13);
			  dao.setProcInValue(procIndex1, "p_menstrual_obstetrics_history", "",14);
			  dao.setProcInValue(procIndex1, "p_birth_history", "",15); 
			  dao.setProcInValue(procIndex1, "p_development_history", "",16);
			  dao.setProcInValue(procIndex1, "p_immunization_history", "",17);
			  dao.setProcInValue(procIndex1, "p_nutrition_history", "",18); 
			  dao.setProcInValue(procIndex1, "p_isvalid", "1",19);
			  dao.setProcInValue(procIndex1, "p_seatid",seatId,20);
			  dao.setProcInValue(procIndex1, "p_entry_source","3",21);
			  dao.setProcInValue(procIndex1, "p_past_history",strpastHistory,22);
			  dao.setProcInValue(procIndex1, "p_other_relevant_history","",23);
			  
			  dao.setProcOutValue(procIndex1, "err", 1,24);
			  
			  dao.executeProcedureByPosition(procIndex1);
			  
              return "1";
   			

        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.SaveCompleteHistoryData()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return "2";
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
	}
	
	
	public static String SaveExamniationData(String JsonData) {

		String err = "";
    	
        int procIndex1 = 0;
        int procIndex2 = 0;
        HisDAO dao = null;
        int totBillQty=0;
        
         JSONObject mainObj = new JSONObject();
         HttpServletRequest request=null;
         StringBuffer buffer=new StringBuffer();
         JSONObject mainObj1 = new JSONObject();
         
         //"strSystematicExamniation":{"strcvs":"","strrs":"","strcns":"","strpA":"","strotherExamn":"","strmuscularExamn":"","strLocalExamn":""}
         
         String strcvs=null,strrs=null,strcns=null,strpA=null,strotherExamn=null,strmuscularExamn=null,strLocalExamn=null;
        
        try {
        	
   		 JSONObject object = new JSONObject(JsonData);
   		System.out.println("JsonData"+JsonData);
		System.out.println("strSystematicExamniation "+object.get("strSystematicExamniation"));
		System.out.println("CR_No"+object.get("CR_No"));
		System.out.println("episodeCode"+object.get("episodeCode"));
		System.out.println("admissionNo"+object.get("admissionNo"));

   			String Crno=(String) object.get("CR_No");
   			String EpisodeCode=(String) object.get("episodeCode");
   			String seatId=(String) object.get("seatId");
   			String hosp_code=(String) object.get("hosp_code");
   			String visitNo=(String) object.get("episodeVisitNo");
   			String admissionNo=(String) object.get("admissionNo");
   			//String strRefrealRemaks=(String) object.get("strReffralReason");
   			
   			StringBuffer sb=new StringBuffer();
   			//JSONArray strCompleteHistory =(JSONArray) object.get("strCompleteHistory");
   			//int length=((JSONArray) object.get("strCompleteHistory")).length();
   			dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
   			
   			
   			 
   			 JSONObject strjsonObj =(JSONObject) object.get("strSystematicExamniation");

   			  strcvs = (String) strjsonObj.get("strcvs")==null ? "" : ((String) strjsonObj.get("strcvs")).replace(";",""); 
   			  strrs = (String) strjsonObj.get("strrs")==null ? "" : (String) strjsonObj.get("strrs") ;
   			  strcns = (String) strjsonObj.get("strcns")==null ? "" : (String) strjsonObj.get("strcns") ;
   			  strpA = (String) strjsonObj.get("strpA")==null ? "" : (String) strjsonObj.get("strpA") ;
   			  strotherExamn = (String) strjsonObj.get("strotherExamn")==null ? "" : (String) strjsonObj.get("strotherExamn") ;
   			  strmuscularExamn = (String) strjsonObj.get("strmuscularExamn")==null ? "" : (String) strjsonObj.get("strmuscularExamn") ;
   			  strLocalExamn = (String) strjsonObj.get("strLocalExamn")==null ? "" : (String) strjsonObj.get("strLocalExamn") ;
   			
			
			  String proc_name1 =  "{call pkg_ipdDesk_dml.proc_ehrt_pat_sys_exam_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}" ; 
			  procIndex1 = dao.setProcedure(proc_name1); 
			  dao.setProcInValue(procIndex1, "p_mode", "1",1);
			  dao.setProcInValue(procIndex1, "p_puk", Crno,2);
			  dao.setProcInValue(procIndex1, "p_hospcode", hosp_code,3);
			  dao.setProcInValue(procIndex1, "p_episodecode",EpisodeCode,4);
			  dao.setProcInValue(procIndex1, "p_visitno", visitNo,5);
			  dao.setProcInValue(procIndex1, "p_record_date", "" ,6);
			  dao.setProcInValue(procIndex1, "p_slno", "1",7);
			  dao.setProcInValue(procIndex1, "p_admission_no", admissionNo,8);
			  dao.setProcInValue(procIndex1, "p_g_p_exam","" ,9);
			  dao.setProcInValue(procIndex1, "p_chest_exam","",10);
			  dao.setProcInValue(procIndex1, "p_cvs_exam",strcvs,11); 
			  dao.setProcInValue(procIndex1, "p_rs_exam", strrs,12); 
			  dao.setProcInValue(procIndex1, "p_cns_exam",strcns,13);
			  dao.setProcInValue(procIndex1, "p_muscskel_exam","",14);
			  dao.setProcInValue(procIndex1, "p_abdomen_exam", "",15);
			  dao.setProcInValue(procIndex1, "p_gi_sys_exam", "",16); 
			  dao.setProcInValue(procIndex1, "p_p_a_exam", strpA,17);
			  dao.setProcInValue(procIndex1, "p_developmental_exam", strotherExamn,18);
			  dao.setProcInValue(procIndex1, "p_muscular_exam", strmuscularExamn,19); 
			  dao.setProcInValue(procIndex1, "p_isvalid", "1",20);
			  dao.setProcInValue(procIndex1, "p_seatid",seatId,21);
			  dao.setProcInValue(procIndex1, "p_entry_source","3",22);
			  
			  dao.setProcOutValue(procIndex1, "err", 1,23);
			  
			  dao.executeProcedureByPosition(procIndex1);
			  
              return "1";
   			
              
              

        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.SaveExamniationData()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return "2";
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
	}
	
	public static String saveReferPatientDetails(String JsonData) {
        System.out.println("method calling ipd saveReferPatientDetails---->");
		String err = "";
    	
        int procIndex1 = 0;
        int procIndex2 = 0;
        HisDAO dao = null;
        int totBillQty=0;
        
         String reqno=null,billNo=null,crno=null;
         JSONObject mainObj = new JSONObject();
         HttpServletRequest request=null;
         StringBuffer buffer=new StringBuffer();
         JSONObject mainObj1 = new JSONObject(); 
        
        try {
        	
   		 JSONObject object = new JSONObject(JsonData);
   		System.out.println("JsonData"+JsonData);
		System.out.println("Diagnosis "+object.get("Diagnosis"));
		System.out.println("CR_No"+object.get("CR_No"));
		System.out.println("episodeCode"+object.get("episodeCode"));
		System.out.println("admissionNo"+object.get("admissionNo"));

   			String Crno=(String) object.get("CR_No");
   			String EpisodeCode=(String) object.get("episodeCode");
   			String seatId=(String) object.get("seatId");
   			String hosp_code=(String) object.get("hosp_code");
   			String visitNo=(String) object.get("episodeVisitNo");
   			String admissionNo=(String) object.get("admissionNo");
   			//String strRefrealRemaks=(String) object.get("strReffralReason");
   			StringBuffer sb=new StringBuffer();
   			JSONArray strRefferalDept =(JSONArray) object.get("strReferal");
   			int length=((JSONArray) object.get("strReferal")).length();
   			
   			dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
   			for(int i=0 ; i< length ; i++){
   				JSONObject strjsonObj =(JSONObject) strRefferalDept.get(i);
   				String reftype=(String)strjsonObj.get("strreferralType") ; 
				/*
				 * String proc_name1 =
				 * "{call pkg_ipdDesk_dml.patient_referal_confirmation_flag(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,?)}"
				 * ; procIndex1 = dao.setProcedure(proc_name1); dao.setProcInValue(procIndex1,
				 * "p_mode", "1",1); dao.setProcInValue(procIndex1, "p_puk", Crno,2);
				 * dao.setProcInValue(procIndex1, "p_hospcode", hosp_code,3);
				 * dao.setProcInValue(procIndex1, "p_seatId", seatId,4);
				 * dao.setProcInValue(procIndex1, "p_episodecode",EpisodeCode ,5);
				 * dao.setProcInValue(procIndex1, "from_dept", "",6);
				 * dao.setProcInValue(procIndex1, "from_deptunit", "",7);
				 * dao.setProcInValue(procIndex1, "to_dept",
				 * ((String)(strjsonObj.get("strReffralDeptDone"))).split("#")[0],8);
				 * dao.setProcInValue(procIndex1, "to_deptunit",
				 * ((String)(strjsonObj.get("strReffralDeptDone"))).split("#")[1],9);
				 * dao.setProcInValue(procIndex1, "p_visitno", visitNo,10);
				 * dao.setProcInValue(procIndex1, "to_ip_address", "",11);
				 * dao.setProcInValue(procIndex1, "remarks",
				 * (String)strjsonObj.get("strReffralReason"),12);
				 * dao.setProcInValue(procIndex1, "isref_out",
				 * (String)strjsonObj.get("strreferralType"),13); dao.setProcInValue(procIndex1,
				 * "p_json", JsonData,14); dao.setProcInValue(procIndex1, "p_admno",
				 * admissionNo,15); dao.setProcOutValue(procIndex1, "err", 1,16);
				 * dao.execute(procIndex1, 1);
				 */
             if(reftype.equalsIgnoreCase("1") || reftype.equalsIgnoreCase("2") || reftype.equalsIgnoreCase("3"))	{
       			 String proc_name1 = "{call pkg_ipdDesk_dml.patient_referal_confirmation_flag(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?)}";
       			 procIndex1 = dao.setProcedure(proc_name1);
                 dao.setProcInValue(procIndex1, "p_mode", "1",1);
                 dao.setProcInValue(procIndex1, "p_puk", Crno,2);
                 dao.setProcInValue(procIndex1, "p_hospcode", hosp_code,3);
                 dao.setProcInValue(procIndex1, "p_seatId", seatId,4); 
                 dao.setProcInValue(procIndex1, "p_episodecode",EpisodeCode ,5); 
                 dao.setProcInValue(procIndex1, "from_dept", "",6);
                 dao.setProcInValue(procIndex1, "from_deptunit", "",7);
                 dao.setProcInValue(procIndex1, "to_dept", ((String)(strjsonObj.get("strReffralDeptDone"))).split("#")[0],8);
                 dao.setProcInValue(procIndex1, "to_deptunit", ((String)(strjsonObj.get("strReffralDeptDone"))).split("#")[1],9);
                 dao.setProcInValue(procIndex1, "p_visitno", visitNo,10);
                 dao.setProcInValue(procIndex1, "to_ip_address", "",11);
                 dao.setProcInValue(procIndex1, "remarks", (String)strjsonObj.get("strReffralReason"),12);
                 dao.setProcInValue(procIndex1, "isref_out", (String)strjsonObj.get("strreferralType"),13);
                 dao.setProcInValue(procIndex1, "p_json", JsonData,14);
                 dao.setProcInValue(procIndex1, "p_admno", admissionNo,15);
                 dao.setProcOutValue(procIndex1, "err", 1,16);
                 dao.execute(procIndex1, 1);
       			}else if(reftype.equalsIgnoreCase("4")) {
       				String proc_name1 = "{call pkg_ipdDesk_dml.patient_referal_confirmation_flag(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?)}";
          			 procIndex1 = dao.setProcedure(proc_name1);
                    dao.setProcInValue(procIndex1, "p_mode", "2",1);
                    dao.setProcInValue(procIndex1, "p_puk", Crno,2);
                    dao.setProcInValue(procIndex1, "p_hospcode", hosp_code,3);
                    dao.setProcInValue(procIndex1, "p_seatId", seatId,4); 
                    dao.setProcInValue(procIndex1, "p_episodecode",EpisodeCode ,5); 
                    dao.setProcInValue(procIndex1, "from_dept", "",6);
                    dao.setProcInValue(procIndex1, "from_deptunit", "",7);
                    dao.setProcInValue(procIndex1, "to_dept", ((String)(strjsonObj.get("strExternalDepartmentcode"))).split("#")[0],8);
                    dao.setProcInValue(procIndex1, "to_deptunit", ((String)(strjsonObj.get("strExternalDepartmentcode"))).split("#")[1],9);
                    dao.setProcInValue(procIndex1, "p_visitno", visitNo,10);
                    dao.setProcInValue(procIndex1, "to_ip_address", strjsonObj.toString(),11);
                    dao.setProcInValue(procIndex1, "remarks", (String)strjsonObj.get("strReffralReason"),12);
                    dao.setProcInValue(procIndex1, "isref_out", (String)strjsonObj.get("strreferralType"),13);
                    dao.setProcInValue(procIndex1, "p_json", JsonData,14);
                    dao.setProcInValue(procIndex1, "p_admno", admissionNo,15);
                    dao.setProcOutValue(procIndex1, "err", 1,16);
                    dao.execute(procIndex1, 1);
       			}
       			else if(reftype.equalsIgnoreCase("5")) {
       				String proc_name1 = "{call pkg_ipdDesk_dml.patient_referal_confirmation_flag(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?)}";
          			 procIndex1 = dao.setProcedure(proc_name1);
                    dao.setProcInValue(procIndex1, "p_mode", "3",1);
                    dao.setProcInValue(procIndex1, "p_puk", Crno,2);
                    dao.setProcInValue(procIndex1, "p_hospcode", hosp_code,3);
                    dao.setProcInValue(procIndex1, "p_seatId", seatId,4); 
                    dao.setProcInValue(procIndex1, "p_episodecode",EpisodeCode ,5); 
                    dao.setProcInValue(procIndex1, "from_dept", "",6);
                    dao.setProcInValue(procIndex1, "from_deptunit", "",7);
                    dao.setProcInValue(procIndex1, "to_dept", ((String)(strjsonObj.get("strExternalDepartmentcode"))).split("#")[0],8);
                    dao.setProcInValue(procIndex1, "to_deptunit", ((String)(strjsonObj.get("strExternalDepartmentcode"))).split("#")[1],9);
                    dao.setProcInValue(procIndex1, "p_visitno", visitNo,10);
                    dao.setProcInValue(procIndex1, "to_ip_address", "",11);
                    dao.setProcInValue(procIndex1, "remarks", strjsonObj.toString(),12);
                    dao.setProcInValue(procIndex1, "isref_out", (String)strjsonObj.get("strreferralType"),13);
                    dao.setProcInValue(procIndex1, "p_json", JsonData,14);
                    dao.setProcInValue(procIndex1, "p_admno", admissionNo,15);
                    dao.setProcOutValue(procIndex1, "err", 1,16);
                    dao.execute(procIndex1, 1);	
       			}
   			}
   			
   			synchronized (dao) {
				dao.fire();
			}
   			 		
		   			return "1";
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.saveReferPatientDetails()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return "2";
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
	}
	
	public static String SaveVitalData(String JsonData) {
        System.out.println("method called SaveVitalData--->  ");
		String err = "";
    	String proc_name1 = "{call pkg_ipdDesk_dml.Dml_Vital_dtls(?,?,?,?,?, ?,?,?,?,?,  ?,?,?,?,?, ?,?,?,?,?, ?,?)}";
    	
        int procIndex1 = 0;
        HisDAO dao = null;
        try {
        	
   		 	JSONObject object = new JSONObject(JsonData);
   		 	String []strPatdtls=((String) object.get("strPatdtls")).split("\\^");
   			StringBuffer sb=new StringBuffer();
   			String strWeight=(String) object.get("strWeight")==null ? "" : (String) object.get("strWeight") ;
   			String strHeight=(String) object.get("strHeight")==null ? "" : (String) object.get("strHeight") ;
   			String strBmid=(String) object.get("strBmid")==null ? "" : (String) object.get("strBmid") ;
   			String strTempreature=(String) object.get("strTempreature")==null ? "" : (String) object.get("strTempreature") ;
   			
   			String strrespRate=(String) object.get("strrespRate")==null ? "" : (String) object.get("strrespRate") ;
   			String strhaemoglobin=(String) object.get("strhaemoglobin")==null ? "" : (String) object.get("strhaemoglobin") ;
   			String strdiastolic=(String) object.get("strdiastolic")==null ? "" : (String) object.get("strdiastolic") ;
   			String strsystolic=(String) object.get("strsystolic")==null ? "" : (String) object.get("strsystolic") ;
   			
   			String strfasting=(String) object.get("strfasting")==null ? "" : (String) object.get("strfasting") ;
   			String strRateId=(String) object.get("strRateId")==null ? "" : (String) object.get("strRateId") ;
   			String strhba1c=(String) object.get("strhba1c")==null ? "" : (String) object.get("strhba1c") ;
   			String strsymptoms=(String) object.get("strsymptoms")==null ? "" : (String) object.get("strsymptoms") ;
   			
   			
   			
   			
			dao = new HisDAO("OPD DR DESK DAO", "vitalSave.save()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "p_mode", "1",1);
            dao.setProcInValue(procIndex1, "p_puk", strPatdtls[1],2);
            dao.setProcInValue(procIndex1, "p_hospcode", strPatdtls[4],3); 
            dao.setProcInValue(procIndex1, "p_seatId", strPatdtls[7],4); 
            dao.setProcInValue(procIndex1, "p_episodecode",strPatdtls[2] ,5); 
            dao.setProcInValue(procIndex1, "p_visitno", "0",6);
           
            dao.setProcInValue(procIndex1, "strWeight", strWeight,7);
            dao.setProcInValue(procIndex1, "strHeight", strHeight,8);
            dao.setProcInValue(procIndex1, "strBmid", strBmid,9);
            dao.setProcInValue(procIndex1, "strTempreature", strTempreature,10);
            dao.setProcInValue(procIndex1, "strrespRate", strrespRate,11);
            dao.setProcInValue(procIndex1, "strhaemoglobin", strhaemoglobin,12);
            dao.setProcInValue(procIndex1, "strdiastolic", strdiastolic,13);
            
            
            dao.setProcInValue(procIndex1, "strsystolic", strsystolic,14);
            dao.setProcInValue(procIndex1, "strfasting", strfasting,15);
            dao.setProcInValue(procIndex1, "strRateId", strRateId,16);
            dao.setProcInValue(procIndex1, "strhba1c", strhba1c,17);
            dao.setProcInValue(procIndex1, "strsymptoms", strsymptoms,18);
            
            dao.setProcInValue(procIndex1, "p_json", JsonData,19);
			dao.setProcInValue(procIndex1, "p_isvalid", "1",20);
			dao.setProcInValue(procIndex1, "p_admno", strPatdtls[3],21);
			
            dao.setProcOutValue(procIndex1, "err", 1,22);
            dao.executeProcedureByPosition(procIndex1);
		   	
            return "1";
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.SaveVitalData()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return "0";
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
		
		
	}

	public static String savePrecriptionProfileData(String JsonData){
		
     System.out.println("method called for ipd savePrecriptionProfileData for table check--->");

		String err = "";
    	String proc_name1 = "{call pkg_ipdDesk_dml.hopl_emr_dtl(?,?,?,?,?, ?,?,?,?)}";
    	
        int procIndex1 = 0;
        int procIndex2 = 0;
        HisDAO dao = null;
        int totBillQty=0;
        
         String reqno=null,billNo=null,crno=null;
         JSONObject mainObj = new JSONObject();
         HttpServletRequest request=null;
         StringBuffer buffer=new StringBuffer();
         JSONObject mainObj1 = new JSONObject(); 
        
        try {
        	
   		 JSONObject object = new JSONObject(JsonData);
   		Integer strProfileId=(Integer) object.get("strProfileId");
   		Integer strStatus=(Integer) object.get("strStatus");
   			
			dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "p_mode", "3",1);
            dao.setProcInValue(procIndex1, "p_puk", "",2);
            dao.setProcInValue(procIndex1, "p_hospcode", String.valueOf(strProfileId),3); 
            dao.setProcInValue(procIndex1, "p_seatId", String.valueOf(strStatus),4); 
            dao.setProcInValue(procIndex1, "p_episodecode","" ,5); 
            dao.setProcInValue(procIndex1, "p_visitno", "",6);
            dao.setProcInValue(procIndex1, "p_json", JsonData,7);
			dao.setProcInValue(procIndex1, "p_isvalid", "1",8);
			
            dao.setProcOutValue(procIndex1, "err", 1,9);
            dao.executeProcedureByPosition(procIndex1);
		   		
		   			return "1";
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.SavePrescriptionBookMarkData()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return "0";
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
	}
	
	
	
	public static String SaveEMRVitalData(String JsonData) {
      
		System.out.println("method called for SaveEMRVitalData---->");
		String err = "";
    	String proc_name1 = "{call pkg_emr_dtl.sync_pat_vitals_from_oplite(?,?,?,?,?, ?,?,?,?,?,  ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,   ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?, ?,?,?,?)}";
    	
        int procIndex1 = 0;
        HisDAO dao = null;
        try {
        	
   		 	JSONObject object = new JSONObject(JsonData);
   		 	String []strPatdtls=((String) object.get("strPatdtls")).split("\\^");
   			StringBuffer sb=new StringBuffer();
   			String strWeight=(String) object.get("strWeight")==null ? "" : (String) object.get("strWeight") ;
   			String strHeight=(String) object.get("strHeight")==null ? "" : (String) object.get("strHeight") ;
   			String strBmid=(String) object.get("strBmid")==null ? "" : (String) object.get("strBmid") ;
   			String strTempreature=(String) object.get("strTempreature")==null ? "" : (String) object.get("strTempreature") ;
   			
   			String strrespRate=(String) object.get("strrespRate")==null ? "" : (String) object.get("strrespRate") ;
   			String strhaemoglobin=(String) object.get("strhaemoglobin")==null ? "" : (String) object.get("strhaemoglobin") ;
   			String strdiastolic=(String) object.get("strdiastolic")==null ? "" : (String) object.get("strdiastolic") ;
   			String strsystolic=(String) object.get("strsystolic")==null ? "" : (String) object.get("strsystolic") ;
   			
   			String strfasting=(String) object.get("strfasting")==null ? "" : (String) object.get("strfasting") ;
   			String strRateId=(String) object.get("strRateId")==null ? "" : (String) object.get("strRateId") ;
   			String strhba1c=(String) object.get("strhba1c")==null ? "" : (String) object.get("strhba1c") ;
   			String strsymptoms=(String) object.get("strsymptoms")==null ? "" : (String) object.get("strsymptoms") ;
   			
   			
   			String strpulseRate=(String) object.get("strpulseRate")==null ? "" : (String) object.get("strpulseRate") ;
   			String strbloodGroup=(String) object.get("strbloodGroup")==null ? "" : (String) object.get("strbloodGroup") ;
   			String strmuac=(String) object.get("strmuac")==null ? "" : (String) object.get("strmuac") ;
   			String strcurcumference=(String) object.get("strcurcumference")==null ? "" : (String) object.get("strcurcumference") ;
   			
   			String strbmiErrmsg=(String) object.get("strbmiErrmsg")==null ? "" : (String) object.get("strbmiErrmsg") ;
   			String strtemperatureErrmsg=(String) object.get("strtemperatureErrmsg")==null ? "" : (String) object.get("strtemperatureErrmsg") ;
   			String strrespRateErrmsg=(String) object.get("strrespRateErrmsg")==null ? "" : (String) object.get("strrespRateErrmsg") ;
   			String strhaemoglobinErrmsg=(String) object.get("strhaemoglobinErrmsg")==null ? "" : (String) object.get("strhaemoglobinErrmsg") ;
   			
   			String strbpErrmsg=(String) object.get("strbpErrmsg")==null ? "" : (String) object.get("strbpErrmsg") ;
   			String strfastingErrmsg=(String) object.get("strfastingErrmsg")==null ? "" : (String) object.get("strfastingErrmsg") ;
   			String strppRateErrmsg=(String) object.get("strppRateErrmsg")==null ? "" : (String) object.get("strppRateErrmsg") ;
   			String strhba1cErrmsg=(String) object.get("strhba1cErrmsg")==null ? "" : (String) object.get("strhba1cErrmsg") ;
   			
   			/* <!-- ----------------------added for cancer screening--------------- --> */
   			String strcancerScreening = object.get("strcancerScreening").toString().replaceAll("[\\[\\]]", "").replaceAll("\"", "");
   			
   			
   			
   			
   			
   			
   			
			dao = new HisDAO("OPD DR DESK DAO", "emrsave.save()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "pmode", "1",1);
            dao.setProcInValue(procIndex1, "puk", strPatdtls[1],2);
            dao.setProcInValue(procIndex1, "episode_code", strPatdtls[2],3); 
            dao.setProcInValue(procIndex1, "visit_no", strPatdtls[3],4); 
            dao.setProcInValue(procIndex1, "seq_no","" ,5); 
            dao.setProcInValue(procIndex1, "hospital_code", strPatdtls[4],6);
           
            dao.setProcInValue(procIndex1, "weight_val", strWeight,7);
            dao.setProcInValue(procIndex1, "height_val", strHeight,8);
            dao.setProcInValue(procIndex1, "bmi_val", strBmid,9);
            dao.setProcInValue(procIndex1, "bmi_class", strTempreature,10);
            dao.setProcInValue(procIndex1, "hoplstr_bmi_classname", strtemperatureErrmsg,11);
            dao.setProcInValue(procIndex1, "temp_val", strTempreature,12);
            dao.setProcInValue(procIndex1, "istemphigh", "0",13);
            
            
            dao.setProcInValue(procIndex1, "rr_val", strrespRate,14);
            dao.setProcInValue(procIndex1, "isrrabnormal", "0",15);
            dao.setProcInValue(procIndex1, "hoplstr_rr_classname", strrespRateErrmsg,16);
            dao.setProcInValue(procIndex1, "hb_val", strhaemoglobin,17);
            dao.setProcInValue(procIndex1, "ishbabnormal", "0",18);
            
            dao.setProcInValue(procIndex1, "bpsy_val", strsystolic,19);
            dao.setProcInValue(procIndex1, "bpdiasy_val", strfasting,20);
            dao.setProcInValue(procIndex1, "bpclass", strbpErrmsg,21);
            dao.setProcInValue(procIndex1, "hoplstr_bp_classname", strbpErrmsg,22);
            dao.setProcInValue(procIndex1, "sugarfast_val", strfasting,23);
            dao.setProcInValue(procIndex1, "sugarpp_val", strRateId,24);
            dao.setProcInValue(procIndex1, "diabeticclass", strbpErrmsg,25);
            dao.setProcInValue(procIndex1, "hoplstr_diabetic_classname", strfastingErrmsg,26);
            dao.setProcInValue(procIndex1, "hba1c_val", strhba1c,27);
            dao.setProcInValue(procIndex1, "hba1c_class", strhba1cErrmsg,28);
            
            
            
            dao.setProcInValue(procIndex1, "hoplstr_hba1cclassname", strhba1cErrmsg,29);
            dao.setProcInValue(procIndex1, "hoplstr_sympinfo_val", strsymptoms,30);
            dao.setProcInValue(procIndex1, "gnum_isvalid", "1",31);
            dao.setProcInValue(procIndex1, "gnum_seat_id", strPatdtls[7],32);
            dao.setProcInValue(procIndex1, "gnum_lstmod_seat_id", "",33);
            dao.setProcInValue(procIndex1, "hopldt_entry_date", "",34);
            dao.setProcInValue(procIndex1, "hopldt_lstmod_date", "",35);
            dao.setProcInValue(procIndex1, "hoplstr_chronic_vitals", "",36);
            dao.setProcInValue(procIndex1, "hoplstr_tempreture_classname", "",37);
            dao.setProcInValue(procIndex1, "hoplstr_sugarpp_classname", "",38);
            
            
            
            
            dao.setProcInValue(procIndex1, "hoplstr_json_data", JsonData,39);
            dao.setProcInValue(procIndex1, "pulse_rate", strpulseRate,40);
            dao.setProcInValue(procIndex1, "hoplstr_blood_group", strbloodGroup,41);
            dao.setProcInValue(procIndex1, "curcumference_val", strcurcumference,42);
            
            
            dao.setProcInValue(procIndex1, "muac_val", strmuac,43);
           
             dao.setProcOutValue(procIndex1, "err", 1,44);
            dao.executeProcedureByPosition(procIndex1);
		   	
            return "1";
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.SaveEMRVitalData()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return "0";
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
		
		
	}
	
	public static String getModifyVitalData(String JsonData) throws JSONException {

		
		System.out.println("method called for getModifyVitalData----> ");
		/* Get EHR Details */
    	String err = "";
    	String proc_name1 = "{call pkg_ipddrdesk_view.get_vital_dtls(?,?,?,?,? ,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        
         String status="0";
         JSONObject mainObj = new JSONObject();
         
         JSONArray ja = new JSONArray();
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
        	JSONObject object = new JSONObject(JsonData);
   		 	String CR_No=(String) object.get("CR_No")==null ? "" : (String) object.get("CR_No") ;
   			String episodeCode=(String) object.get("episodeCode")==null ? "" : (String) object.get("episodeCode") ;
   			String hospitalCode=(String) object.get("hospitalCode")==null ? "" : (String) object.get("hospitalCode") ;
   			String admno=(String) object.get("admno")==null ? "" : (String) object.get("admno") ;
        	//System.out.println("crno::::::::::::::"+crno);
            dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtls()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modeval", "1",1);
            dao.setProcInValue(procIndex1, "crno", CR_No,2);
            dao.setProcInValue(procIndex1, "episodeCode", episodeCode,3);
            dao.setProcInValue(procIndex1, "admno", admno,4);
            dao.setProcInValue(procIndex1, "seatId", "",5);
            dao.setProcInValue(procIndex1, "entrydate", "",6);
            dao.setProcInValue(procIndex1, "hosp_code", hospitalCode,7);
            dao.setProcOutValue(procIndex1, "err", 1,8);
            dao.setProcOutValue(procIndex1, "resultset", 2,9);
            //dao.executeProcedureByPosition(procIndex1);
            
            dao.executeProcedureByPosition(procIndex1);
            err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
              while (ws.next()) {
            	  int j=0;
                	status="1";
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		//JSONParser parser = new JSONParser();
                		//org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
                		js.put(key, value);
                		
                	}
                	jsonolist.add(js) ;               	
                	
                }
             
              }
       
          
         
          mainObj.put("status", "1");
          mainObj.put("VitalDtls", jsonolist);
         
             if(ws != null){
        		ws.close();
        		ws = null;
        	}          
            return mainObj.toString();
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.getModifyVitalData()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            mainObj.put("status", "2");
            mainObj.put("VitalDtls", "");
            return mainObj.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
    }
	public static void SaveGenralDataFormattedData(String JsonData) {
		
       System.out.println("method called for ipd SaveGenralDataFormattedData for data check---->");

		String err = "";
    	String proc_name1 = "{call pkg_ipdDesk_dml.hopl_emr_dtl(?,?,?,?,?, ?,?,?,?,?)}";
    	
        int procIndex1 = 0;
        int procIndex2 = 0;
        HisDAO dao = null;
        int totBillQty=0;
        
         String reqno=null,billNo=null,crno=null;
         JSONObject mainObj = new JSONObject();
         HttpServletRequest request=null;
         StringBuffer buffer=new StringBuffer();
         JSONObject mainObj1 = new JSONObject(); 
        
        try {
        	
   		 JSONObject object = new JSONObject(JsonData);
			System.out.println("JsonData"+JsonData);
			/*System.out.println("Diagnosis "+object.get("Diagnosis"));
			System.out.println("CR_No"+object.get("CR_No"));
			System.out.println("episodeCode"+object.get("episodeCode"));*/

   			String Crno=(String) object.get("CR_No");
   			String EpisodeCode=(String) object.get("EpisodeCode");
   			String seatId=(String) object.get("seatId");
   			String hosp_code=(String) object.get("hosp_code");
   			String EpisodeVisitNo=(String) object.get("EpisodeVisitNo");
   			String admissionNo=(String) object.get("admissionNo");
   			/*JSONArray ReasonOfVisit =(JSONArray) object.get("ReasonOfVisit");
   			*/
   			StringBuffer sb=new StringBuffer();
   			
			dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "p_mode", "1",1);
            dao.setProcInValue(procIndex1, "p_puk", Crno,2);
            dao.setProcInValue(procIndex1, "p_hospcode", hosp_code,3); 
            dao.setProcInValue(procIndex1, "p_seatId", seatId,4); 
            dao.setProcInValue(procIndex1, "p_episodecode",EpisodeCode ,5); 
            dao.setProcInValue(procIndex1, "p_visitno", EpisodeVisitNo,6);
            dao.setProcInValue(procIndex1, "p_json", JsonData,7);
			dao.setProcInValue(procIndex1, "p_isvalid", "1",8);
			dao.setProcInValue(procIndex1, "p_admno", admissionNo,9);
            dao.setProcOutValue(procIndex1, "err", 1,10);
            dao.executeProcedureByPosition(procIndex1);
		   		
		   			return ;
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.SaveGenralDataFormattedData()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return ;
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
	}
	
	public static void SavePrescriptionBookMarkData(String JsonData) {
		
		 System.out.println("method called for ipd SavePrescriptionBookMarkData for data check---->");


		String err = "";
    	String proc_name1 = "{call pkg_ipdDesk_dml.hopl_emr_dtl(?,?,?,?,?, ?,?,?,?,?)}";
    	
        int procIndex1 = 0;
        int procIndex2 = 0;
        HisDAO dao = null;
        int totBillQty=0;
        
         String reqno=null,billNo=null,crno=null;
         JSONObject mainObj = new JSONObject();
         HttpServletRequest request=null;
         StringBuffer buffer=new StringBuffer();
         JSONObject mainObj1 = new JSONObject(); 
        
        try {
        	
   		 JSONObject object = new JSONObject(JsonData);
			System.out.println("JsonData"+JsonData);
			/*System.out.println("Diagnosis "+object.get("Diagnosis"));
			System.out.println("CR_No"+object.get("CR_No"));
			System.out.println("episodeCode"+object.get("episodeCode"));*/

   			//String Crno=(String) object.get("CR_No");
   			//String EpisodeCode=(String) object.get("EpisodeCode");
   			String seatId=(String) object.get("seatId");
   			String hosp_code=(String) object.get("hosp_code");
   			String admissionNo=(String) object.get("admissionNo");
   			//String EpisodeVisitNo=(String) object.get("EpisodeVisitNo");
   			/*JSONArray ReasonOfVisit =(JSONArray) object.get("ReasonOfVisit");
   			*/
   			StringBuffer sb=new StringBuffer();
   			
			dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "p_mode", "2",1);
            dao.setProcInValue(procIndex1, "p_puk", "",2);
            dao.setProcInValue(procIndex1, "p_hospcode", hosp_code,3); 
            dao.setProcInValue(procIndex1, "p_seatId", seatId,4); 
            dao.setProcInValue(procIndex1, "p_episodecode","" ,5); 
            dao.setProcInValue(procIndex1, "p_visitno", "",6);
            dao.setProcInValue(procIndex1, "p_json", JsonData,7);
			dao.setProcInValue(procIndex1, "p_isvalid", "1",8);
			dao.setProcInValue(procIndex1, "p_admno", admissionNo,9);
            dao.setProcOutValue(procIndex1, "err", 1,10);
            dao.executeProcedureByPosition(procIndex1);
		   		
		   			return ;
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.SavePrescriptionBookMarkData()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return ;
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
	}
	
	
	public static String SaveEConsultancyData(String JsonData) {
		System.out.println("method called for ipd SaveEConsultancyData--->");
		String err = "";
    	String proc_name1 = "{call pkg_webservices.update_request_status(?,?,?,?,?, ?,?,?)}";
    	
        int procIndex1 = 0;
        int procIndex2 = 0;
        HisDAO dao = null;
        int totBillQty=0;
        
         String reqno=null,billNo=null,crno=null;
         JSONObject mainObj = new JSONObject();
         HttpServletRequest request=null;
         StringBuffer buffer=new StringBuffer();
         JSONObject mainObj1 = new JSONObject(); 
        
        try {
        	
   		 JSONObject object = new JSONObject(JsonData);
			System.out.println("JsonData"+JsonData);
			System.out.println("Diagnosis "+object.get("Diagnosis"));
			System.out.println("CR_No"+object.get("CR_No"));
			System.out.println("episodeCode"+object.get("episodeCode"));

   			String Crno=(String) object.get("CR_No");
   			String EpisodeCode=(String) object.get("episodeCode");
   			String seatId=(String) object.get("seatId");
   			String hosp_code=(String) object.get("hosp_code");
   			JSONArray ReasonOfVisit =(JSONArray) object.get("ReasonOfVisit");
   			String PatCompleteGeneralDtl=(String) object.get("PatCompleteGeneralDtl");
   			StringBuffer sb=new StringBuffer();
   			
			dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.SaveEConsultancyData()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "p_mode_val", "1",1);
            dao.setProcInValue(procIndex1, "p_req_id", PatCompleteGeneralDtl.split("#")[19],2);
            dao.setProcInValue(procIndex1, "p_hosp_code", hosp_code,3); 
            dao.setProcInValue(procIndex1, "p_req_status", "3",4); 
            dao.setProcInValue(procIndex1, "p_cons_id","" ,5); 
            dao.setProcInValue(procIndex1, "p_cons_name", "",6);
            dao.setProcInValue(procIndex1, "p_cons_mob_no", "",7);
            dao.setProcOutValue(procIndex1, "err", 1,8);
            
            dao.executeProcedureByPosition(procIndex1);
		   		
		   			return "DATA INSERTED SUCCESSFULLY";
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.SaveEHRData()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return "Something Went Wrong";
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
		
		
	}	
	
	public static String SaveChiefComplaintData( String JsonData)
	{

    	String err = "";
    	String proc_name1 = "{call pkg_ipdDesk_dml.proc_ehrt_pat_cc_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";
    	
        int procIndex1 = 0;
        HisDAO dao = null;
        
        try {
        	
   		 JSONObject object = new JSONObject(JsonData);
			System.out.println("JsonData"+JsonData);
			System.out.println("ReasonOfVisit "+object.get("ReasonOfVisit"));
			System.out.println("CR_No"+object.get("CR_No"));
			System.out.println("episodeCode"+object.get("episodeCode"));
			System.out.println("seatId"+object.get("seatId"));
			System.out.println("hosp_code"+object.get("hosp_code"));
			System.out.println("admissionNo"+object.get("admissionNo"));
   			String Crno=(String) object.get("CR_No");
   			String EpisodeCode=(String) object.get("episodeCode");
   			String seatId=(String) object.get("seatId");
   			String hosp_code=(String) object.get("hosp_code");
   			String EpisodeVisitNo=(String) object.get("episodeVisitNo");
   			String admissionNo=(String) object.get("admissionNo");
   			JSONArray reasonOfVisitArr =(JSONArray) object.get("ReasonOfVisit");  			
   			
   			if(reasonOfVisitArr!=null)
			{

				for (int i = 0; i < reasonOfVisitArr.length(); i++) {
					try {

						dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
						procIndex1 = dao.setProcedure(proc_name1);
						dao.setProcInValue(procIndex1, "p_mode", "1", 1);
						dao.setProcInValue(procIndex1, "p_puk", Crno, 2);
						dao.setProcInValue(procIndex1, "p_episodecode", EpisodeCode, 3);
						dao.setProcInValue(procIndex1, "p_isvalid", "1", 4);
						dao.setProcInValue(procIndex1, "p_admno", admissionNo, 5);
						dao.setProcInValue(procIndex1, "p_visitno", EpisodeVisitNo, 6);
						dao.setProcInValue(procIndex1, "p_seatid", seatId, 7);
						dao.setProcInValue(procIndex1, "p_hospcode", hosp_code, 8);
						
						String tmp = (String) reasonOfVisitArr.get(i);
						//System.out.println(tmp);
						
						dao.setProcInValue(procIndex1, "p_otherinfo", tmp, 9);
						String tmpArray[] = tmp.split("\\^");
						//System.out.println("tmep arr =="+tmpArray[0]);
						dao.setProcInValue(procIndex1, "p_ccid", tmpArray[0], 10);
						dao.setProcInValue(procIndex1, "p_ccname", tmpArray[1], 11);
						dao.setProcInValue(procIndex1, "p_ccsite", tmpArray[2], 12);

						dao.setProcOutValue(procIndex1, "err", 1, 13);
						dao.executeProcedureByPosition(procIndex1);
					} catch (Exception e) {
						HisException eObj = new HisException("OPD Lite",
								"opdDrDeskDao.SaveChiefComplaintData() inside forloop -->",
								"JSON -> " + reasonOfVisitArr.get(i) + " :: " + e.getMessage() + "-->" + e);
						e.printStackTrace();
					}
				}

			}
            return "DATA INSERTED SUCCESSFULLY";
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.SaveChiefComplaintData()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return "Something Went Wrong";
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
    }
	public static String SaveHoplCourseData( String JsonData)
	{

    	String err = "";
    	String proc_name1 = "{call pkg_ipdDesk_dml.proc_hopl_course_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?)}";
    	
        int procIndex1 = 0;
        HisDAO dao = null;

        try {
        	
   		 JSONObject object = new JSONObject(JsonData);
			System.out.println("SaveHoplCourseData JsonData"+JsonData);
			System.out.println("CR_No"+object.get("CR_No"));
			System.out.println("episodeCode"+object.get("episodeCode"));
			System.out.println("seatId"+object.get("seatId"));
			System.out.println("hosp_code"+object.get("hosp_code"));
			System.out.println("admissionNo"+object.get("admissionNo"));
   			String Crno=(String) object.get("CR_No");
   			String EpisodeCode=(String) object.get("episodeCode");
   			String seatId=(String) object.get("seatId");
   			String hosp_code=(String) object.get("hosp_code");
   			String EpisodeVisitNo=(String) object.get("episodeVisitNo");
   			String admissionNo=(String) object.get("admissionNo");
   			String hoplCrsVisitDate=(String) object.get("hoplCrsVisitDate");
   			String courseNote=(String) object.get("courseNote");
   			String insTreatNote=(String) object.get("insTreatNote");		
			try {
				String[] date = hoplCrsVisitDate.split("\\:");
				String visidate = date[0]+" "+date[1]+":"+date[2];
				dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
				procIndex1 = dao.setProcedure(proc_name1);
				dao.setProcInValue(procIndex1, "p_mode", "1", 1);
				dao.setProcInValue(procIndex1, "p_puk", Crno, 2);
				dao.setProcInValue(procIndex1, "p_episodecode", EpisodeCode, 3);
				dao.setProcInValue(procIndex1, "p_isvalid", "1", 4);
				dao.setProcInValue(procIndex1, "p_admno", admissionNo, 5);
				dao.setProcInValue(procIndex1, "p_visitno", EpisodeVisitNo, 6);
				dao.setProcInValue(procIndex1, "p_seatid", seatId, 7);
				dao.setProcInValue(procIndex1, "p_hospcode", hosp_code, 8);
				dao.setProcInValue(procIndex1, "p_visitDateTime", visidate, 9);
				dao.setProcInValue(procIndex1, "p_coursenote", courseNote, 10);
				dao.setProcInValue(procIndex1, "p_instreatnote", insTreatNote, 11);
				dao.setProcOutValue(procIndex1, "err", 1, 12);
				dao.executeProcedureByPosition(procIndex1);
			} catch (Exception e) {
				HisException eObj = new HisException("OPD Lite",
						"opdDrDeskDao.SaveChiefComplaintData() inside forloop -->", e.getMessage() + "-->" + e);
				e.printStackTrace();
			}
            return "DATA INSERTED SUCCESSFULLY";
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.SaveChiefComplaintData()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return "Something Went Wrong";
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
    }
	public static String saveOperationDetails(String JsonData)
	{
		String err = "";
		String strProcName2 = "{call pkg_ipddesk_dml.proc_save_ehrt_pat_operation_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,?)}";

		int nProcIndex2 = 0;
		HisDAO daoObj = null;
		try {
			JSONObject object = new JSONObject(JsonData);
			System.out.println("saveOperationDetails JsonData" + JsonData);
			System.out.println("CR_No" + object.get("CR_No"));
			System.out.println("episodeCode" + object.get("episodeCode"));
			System.out.println("seatId" + object.get("seatId"));
			System.out.println("hosp_code" + object.get("hosp_code"));
			System.out.println("admissionNo" + object.get("admissionNo"));
			String Crno = (String) object.get("CR_No");
			String EpisodeCode = (String) object.get("episodeCode");
			String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("hosp_code");
			String EpisodeVisitNo = (String) object.get("episodeVisitNo");
			String admissionNo = (String) object.get("admissionNo");
			JSONArray OtDtlArray = (JSONArray) object.get("OtDtl");
			if (OtDtlArray != null) {

				for (int i = 0; i < OtDtlArray.length(); i++) {
					
					String tmp = (String) OtDtlArray.get(i);
		   	     	String tmpArray[]=tmp.split("&&");
		   	        System.out.println("tmpArray=="+tmpArray.length);    
					daoObj = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
					nProcIndex2 = daoObj.setProcedure(strProcName2);
					daoObj.setProcInValue(nProcIndex2, "p_mode", "1", 1);
					daoObj.setProcInValue(nProcIndex2, "p_hrgnum_puk", Crno, 2);
					daoObj.setProcInValue(nProcIndex2, "p_hrgnum_episode_code", EpisodeCode, 3);
					daoObj.setProcInValue(nProcIndex2, "p_hipnum_admno", admissionNo, 4);
					daoObj.setProcInValue(nProcIndex2, "p_hrgnum_visit_no", EpisodeVisitNo, 5);					
					daoObj.setProcInValue(nProcIndex2, "p_hotnum_operation_code",tmpArray[1] ,6);
					daoObj.setProcInValue(nProcIndex2, "p_hotdt_operation_date", tmpArray[0],7);
					daoObj.setProcInValue(nProcIndex2, "p_gnum_seat_id", seatId, 8);
					daoObj.setProcInValue(nProcIndex2, "p_hotstr_surgeons", tmpArray[4], 9);
					daoObj.setProcInValue(nProcIndex2, "p_hotstr_surgeon_empids", tmpArray[3],10);
					daoObj.setProcInValue(nProcIndex2, "p_hotstr_operation_remarks",tmpArray[5].trim(),11);
					daoObj.setProcInValue(nProcIndex2, "p_hotstr_operation_name", tmpArray[2],12);
					daoObj.setProcInValue(nProcIndex2, "p_gnum_hospital_code", hosp_code, 13);
					daoObj.setProcInValue(nProcIndex2, "p_hotstr_operation_complications",tmpArray[6].trim(),14);
					daoObj.setProcInValue(nProcIndex2, "p_hotstr_operation_implant",tmpArray[7].trim(),15);
					daoObj.setProcInValue(nProcIndex2, "p_hotstr_operation_PreOp",tmpArray[8].trim(),16);
					daoObj.setProcInValue(nProcIndex2, "p_hotstr_operation_PostOp",tmpArray[9].trim(),17);
					daoObj.setProcInValue(nProcIndex2, "p_hotstr_nurses", "", 18);
					daoObj.setProcInValue(nProcIndex2, "p_hotstr_nurse_empids", "", 19);
					daoObj.setProcOutValue(nProcIndex2, "err", 1, 20);

					daoObj.executeProcedureByPosition(nProcIndex2);

				}
			}
			return "DATA INSERTED SUCCESSFULLY";
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.SaveDrugAdviceData()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return "Something Went Wrong";
        }
        finally {
        	if (daoObj != null) {
        		daoObj.free();
        		daoObj = null;
            }
        }
	}
	
	public static String saveClinicalProcedure(String JsonData)
	{
		String err = "";
		String strProcName1 = "{call pkg_ipddesk_dml.SaveServiceRequisitionOfflineNew1(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";

		int nInsertedIndex1 = 0;
		HisDAO dao = null;
		try {
			JSONObject object = new JSONObject(JsonData);
			System.out.println("saveClinicalProcedure JsonData" + JsonData);
			System.out.println("CR_No" + object.get("CR_No"));
			System.out.println("episodeCode" + object.get("episodeCode"));
			System.out.println("seatId" + object.get("seatId"));
			System.out.println("hosp_code" + object.get("hosp_code"));
			System.out.println("admissionNo" + object.get("admissionNo"));
			String Crno = (String) object.get("CR_No");
			String EpisodeCode = (String) object.get("episodeCode");
			String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("hosp_code");
			String EpisodeVisitNo = (String) object.get("episodeVisitNo");
			String admissionNo = (String) object.get("admissionNo");
			JSONArray strClinicalProcedure = (JSONArray) object.get("strClinicalProcedure");
			String PatCompleteGeneralDtl=(String) object.get("PatCompleteGeneralDtl");
			if (strClinicalProcedure != null) {

				for (int i = 0; i < strClinicalProcedure.length(); i++) {
					
					String tmp = (String) strClinicalProcedure.get(i);
		   	        String tmpArray[]=tmp.split("\\#");
					
					dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
					nInsertedIndex1 = dao.setProcedure(strProcName1);
					dao.setProcInValue(nInsertedIndex1, "modval", "1", 1);
            		dao.setProcInValue(nInsertedIndex1, "hospcode", hosp_code, 2);
            		dao.setProcInValue(nInsertedIndex1, "patcrnum", Crno, 3);
            		dao.setProcInValue(nInsertedIndex1, "sareacode", tmpArray[5].split("\\^")[0], 4);
            		dao.setProcInValue(nInsertedIndex1, "deptcode", PatCompleteGeneralDtl.split("\\#")[6], 5);
            		dao.setProcInValue(nInsertedIndex1, "proc_code", tmpArray[1].split("\\^")[0], 6);
            		dao.setProcInValue(nInsertedIndex1, "procdate", PatCompleteGeneralDtl.split("\\#")[7].trim(), 7);
            		//if(service_Req_dtlVO.getServiceTimeHr()[x]==null || service_Req_dtlVO.getServiceTimeHr()[x].equals(""))
            		//{
            			dao.setProcInValue(nInsertedIndex1, "proctime", "00:00", 8);
            		//}
            		/*else
            		{
            			dao.setProcInValue(nInsertedIndex1, "proctime", service_Req_dtlVO.getServiceTimeHr()[x]+":"+service_Req_dtlVO.getServiceTimeMin()[x], 8);
            		}*/
    				        		
            		dao.setProcInValue(nInsertedIndex1, "apptstatus", "0", 9);
            		dao.setProcInValue(nInsertedIndex1, "appno","0", 10);
            		dao.setProcInValue(nInsertedIndex1, "reqstatusraised", "0", 11);
            		dao.setProcInValue(nInsertedIndex1, "seatid", seatId, 12);
            		dao.setProcInValue(nInsertedIndex1, "episodecode", EpisodeCode, 13);
            		dao.setProcInValue(nInsertedIndex1, "visitno",EpisodeVisitNo , 14);
            		dao.setProcInValue(nInsertedIndex1, "remarks", tmpArray[4].trim(), 15);
            		dao.setProcInValue(nInsertedIndex1, "paraflag", "0", 16);
            		dao.setProcOutValue(nInsertedIndex1, "err", 1, 17);
            		dao.setProcInValue(nInsertedIndex1, "serviceReqNo", "0",18);
            		dao.setProcInValue(nInsertedIndex1, "admissionNo", admissionNo, 19);
            		dao.setProcInValue(nInsertedIndex1, "wardCode", "", 20);
            		dao.setProcInValue(nInsertedIndex1, "tariffId", tmpArray[1].split("\\^")[0], 21);
            		dao.setProcInValue(nInsertedIndex1, "quantity", "1", 22);
            		dao.setProcInValue(nInsertedIndex1, "count", "0", 23);
            		dao.executeProcedureByPosition(nInsertedIndex1);

				}
			}
			return "DATA INSERTED SUCCESSFULLY";
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","opdDrDeskDao.saveClinicalProcedure()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return "Something Went Wrong";
        }
        finally {
        	if (dao != null) {
        		dao.free();
        		dao = null;
            }
        }
	}
	
	public static String getDrugRoute(String drugItemTypeId){
		String err = "";
		String proc_name1 = "{call pkg_ipddrdesk_view.get_drugroute_list(?,?,?)}";
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;  
		JSONObject mainObj = new JSONObject();
		String status="0";
		ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
		int length=0;
		try {
			dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "itemTypId", drugItemTypeId,1);
			dao.setProcOutValue(procIndex1, "err", 1,2);
			dao.setProcOutValue(procIndex1, "resultset", 2,3);


			dao.executeProcedureByPosition(procIndex1);
			err=dao.getString(procIndex1, "err");

			if(err.isEmpty())
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				length=	ws.getMetaData().getColumnCount();
			if(length>0)
			{
				status="1";
				while (ws.next()) {

				
					JSONObject js=new JSONObject();
					for (int i=1;i<=length;i++)
					{
						String key=ws.getMetaData().getColumnName(i).toUpperCase();
						String value=ws.getString(i);
						js.put(key, value);

					}
					jsonolist.add(js) ;               	

				}
			}
			mainObj.put("status", status);
			mainObj.put("drugRoute_details", jsonolist);
	
			}else{
		status="0";
		mainObj.put("status", status);
		mainObj.put("msg", err);
		mainObj.put("drugRoute_details", jsonolist);
	}
			if(ws != null){
				ws.close();
				ws = null;
			}          
			return mainObj.toString();
		}
		catch (Exception e) {
			e.printStackTrace();
			HisException eObj = new HisException("OPD Lite","opdDrDeskDao.getDrugRoute()-->", e.getMessage() + "-->" + e +" Status -->"+status);
            e.printStackTrace();
            return "Something Went Wrong";
			//return mainObj.toString();
		}
		finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	public static String getMotherAdmDtl(String patAdmNo,String hospCode){
		String err = "";
		String proc_name1 = "{call pkg_ipddrdesk_view.proc_mother_admission_dtl(?,?,?,?,?)}";
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;  
		JSONObject mainObj = new JSONObject();
		String status="0";
		ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
		int length=0;
		try {
			dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "p_modeval", "1",1);
			dao.setProcInValue(procIndex1, "p_gnum_hospital_code", hospCode,2);
			dao.setProcInValue(procIndex1, "p_hrgnum_adm_no", patAdmNo,3);
			dao.setProcOutValue(procIndex1, "err", 1,4);
			dao.setProcOutValue(procIndex1, "resultset", 2,5);


			dao.executeProcedureByPosition(procIndex1);
			err=dao.getString(procIndex1, "err");

			if(err.isEmpty())
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				length=	ws.getMetaData().getColumnCount();
			if(length>0)
			{
				status="1";
				while (ws.next()) {

				
					JSONObject js=new JSONObject();
					for (int i=1;i<=length;i++)
					{
						String key=ws.getMetaData().getColumnName(i).toUpperCase();
						String value=ws.getString(i)!=null && !ws.getString(i).isEmpty()?ws.getString(i):"";
						js.put(key, value);

					}
					jsonolist.add(js) ;               	

				}
			}
			mainObj.put("status", status);
			mainObj.put("json_details", jsonolist);
	
			}else{
		status="0";
		mainObj.put("status", status);
		mainObj.put("msg", err);
		mainObj.put("json_details", jsonolist);
	}
			if(ws != null){
				ws.close();
				ws = null;
			}          
			return mainObj.toString();
		}
		catch (Exception e) {
			e.printStackTrace();
			HisException eObj = new HisException("OPD Lite","opdDrDeskDao.getMotherAdmDtl()-->", e.getMessage() + "-->" + e +" Status -->"+status);
            e.printStackTrace();
            return "Something Went Wrong";
			//return mainObj.toString();
		}
		finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	public static String revokeDrugData(String JsonData) {
		System.out.println("method called for ipd revokeDrugData--->");
		String err = "";
    	String proc_name1 = "{call pkg_ipdDesk_dml.proc_hrgt_revoke_drug_dtl(?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        try {
   			
			dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "p_mode", "1",1);
            dao.setProcInValue(procIndex1, "p_json", JsonData,2);			
            dao.setProcOutValue(procIndex1, "err", 1,3);
            dao.executeProcedureByPosition(procIndex1);
		   	
            return "1";
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Lite","ipdDrDeskDao.revokeDrugData()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return "0";
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
		
		
	}
}
