/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataProcessing;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

/**
 * *************************Start of program***************************** ##
 * Copyright Information	: C-DAC, Noida ## Project Name	: CCD SDK ## Name of
 * Developer	: Siddharth Srivastava ## Module Name	: Health Standards ##
 * Process/Database Object Name	: ## Purpose : ## Date of Creation	: ##
 * Modification Log	: ##	Modify Date	: ##	Reason	(CR/PRS)	: ##	Modify By	:
 */
/**
 *
 * @author Siddharth Srivastava <siddharthsrivastava@cdac.in>
 */
import DataHelper.Config;
import DataHelper.PGDataHelper;
import DataHelper.PropertiesHelper;
import Logging.ServiceLogger;
import TemplateHelper.vo.ResultEntryVO;
import TemplateHelper.vo.ResultEntryVOGroupByValidatedBy;
import hisglobal.vo.UserVO;

public class PDFPrintingProcesses {
	// static String ReportBlackLine=PropertiesHelper.getReportBlackLine();
    String hospitalString = "<table  cellpadding='0' border='0' width='100%' style='border-spacing: 0px'><tr><td align='center' width='100%' colspan='13'><font color='black' size='5'><b>" + Config.hospitalnameatreport + "</b></font></td></tr><tr><td align='center' width='100%' colspan='6'><font color='black' size='4'><b>" + Config.hospitaladdressatreport + "</b></font></td></tr>";
   // final static String lineString = "<tr><td bgcolor='black' colspan='6'><img src='grid.png' width='1' height='1' border='0'/></td></tr>";
    final static String lineString = "<tr><td style='border-bottom:1px solid #000;' colspan='20'>&nbsp;</td></tr>";
   
    final static String standardRangesString = "<tr><td colspan='13' width='100%'><table width='100%'><tr><td width='30%'><font color='black' size='3'><b>Investigation</b></font><td colspan='1' width='40%' align='left' ><div align='left' style=' margin-left: 25px'><font color='black' size='3'><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Result</b></font></div></td><td width='35%'><div align='left'><font color='black' size='3'><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Unit</b></font></div></td><td width='15%'><div align='left'><font color='black' size='3'><b>Ref.Range</b></font></div></td></td></tr></table></td></tr>";
  final static String lineString1="<tr><td style='border-bottom:1px solid #000;' colspan='13'>&nbsp;</td></tr>";
 

    public static synchronized void getDefaultHeaderRegisteredPatient(ResultEntryVOGroupByValidatedBy resultEntryVOGroupByValidatedBy,UserVO _UserVO, String qrCODE) {
        StringBuffer headerString = new StringBuffer();
        Map<String,String> islabelprintindoubleline=new HashMap<String,String>();

        Map<String,String> mp=new HashMap<String,String>(); // map sample no wise append
        Map<String,String> mplabno=new HashMap<String,String>();
        String userName=_UserVO.getUsrName();
       // System.out.println("<<<usrName>>"+_UserVO.getUsrName());
        
        for(ResultEntryVO resultEntryVO: resultEntryVOGroupByValidatedBy.getResultEntryVOListValidatedBy())
		{
        	 Map<String,String> mpgrp=new HashMap<String,String>(); // map sample no wise append
             
        	if(mp!=null && mp.size()>0)
                        {
                        	String key=resultEntryVO.getRequisitionNo()+"#"+resultEntryVO.getSampleCode()+"#"+resultEntryVO.getLaboratoryCode();
                            
                        	
                        	
                        	if(mp.containsKey(key))
                        	{
                        	      String sampleno=	mp.get(key);
                        	      
                        	    if(sampleno!=null &&  !sampleno.contains(resultEntryVO.getUserSampleNo()))
                        	      {
                        	    	
                        	    	  sampleno=sampleno+","+resultEntryVO.getUserSampleNo(); 	
                        	      
                        	    	  if(!mpgrp.containsKey(resultEntryVO.getRequisitionNo()+"#"+resultEntryVO.getGroupCode()))
                                 	     mp.put(key, sampleno);

                        	      }
                        	    
                        	      
                        	}
                        	else
                        	   {
                        		if(!mpgrp.containsKey(resultEntryVO.getRequisitionNo()+"#"+resultEntryVO.getGroupCode()))
                            	mp.put(key, resultEntryVO.getUserSampleNo());
                        	
                        	   }
                        	
                        }
                        else
                        {
                        	
                        	String key=resultEntryVO.getRequisitionNo()+"#"+resultEntryVO.getSampleCode()+"#"+resultEntryVO.getLaboratoryCode();
                         
                        	if(!mpgrp.containsKey(resultEntryVO.getRequisitionNo()+"#"+resultEntryVO.getGroupCode()))
                           	 mp.put(key, resultEntryVO.getUserSampleNo());
                        
                        }
                        
                        
        	
                        if(mplabno!=null && mplabno.size()>0)
                        {
                        	String key=resultEntryVO.getRequisitionNo()+"#"+resultEntryVO.getSampleCode()+"#"+resultEntryVO.getLaboratoryCode();
                            
                        	if(mplabno.containsKey(key))
                        	{
                        	      String labno=	mplabno.get(key);
                        	      
                        	    if(!labno.contains(resultEntryVO.getLabNo()))
                        	      {
                        	    	
                        	    	  labno=labno+","+resultEntryVO.getLabNo(); 	
                        	      
                        	    	  if(!mpgrp.containsKey(resultEntryVO.getRequisitionNo()+"#"+resultEntryVO.getGroupCode()))
                                        mplabno.put(key, labno);

                        	      }
                        	    
                        	      
                        	}
                        	else
                        	   {
                        		
                        		if(!mpgrp.containsKey(resultEntryVO.getRequisitionNo()+"#"+resultEntryVO.getGroupCode()))
                                 	mplabno.put(key, resultEntryVO.getLabNo());
                        	   
                        	   }
                        	
                        }
                        else
                        {
                        	
                        	String key=resultEntryVO.getRequisitionNo()+"#"+resultEntryVO.getSampleCode()+"#"+resultEntryVO.getLaboratoryCode();
                         
                        	
                        	if(!mpgrp.containsKey(resultEntryVO.getRequisitionNo()+"#"+resultEntryVO.getGroupCode()))
                           	   mplabno.put(key, resultEntryVO.getLabNo());
                        
                        }
                        
                        
                        
                        
                        if(resultEntryVO.getGroupCode()==null)
                    	{}
                    	else
                    	{
                    			  mpgrp.put(resultEntryVO.getRequisitionNo()+"#"+resultEntryVO.getGroupCode(), "1");
                    	}
                        
        	
		}

        //String hospitalString = "<table cellspacing='0' cellpadding='0' border='0' width='100%'><tr><td align='center' width='100%' colspan='13'><font color='black' size='5'><b>" + Config.hospitalnameatreport + "</b></font></td></tr><tr><td align='center'width='100%' colspan='13'><font color='black' size='4'><b>" + Config.hospitaladdressatreport + "</b></font></td></tr>";
       // String hospitalString = "<table cellspacing='0' cellpadding='0' border='0' width='100%'><tr><td align='center' width='100%' colspan='13'><font color='black' size='5'><b>" + resultEntryVOGroupByValidatedBy.getHospitalName() + "</b></font></td></tr><tr><td align='center'width='100%' colspan='13'><font color='black' size='4'><b>" + resultEntryVOGroupByValidatedBy.getHospitalCity() + "</b></font></td></tr>";
       // String hospitalString = "<table cellspacing='0' cellpadding='0' border='0' width='100%'><tr><td align='center' width='100%' colspan='13'><table><tr><td width='10%' rowspan='2'><img src='nims.gif'/></td><td width='90%' align='center'><font color='black' size='5'><b>" + resultEntryVOGroupByValidatedBy.getHospitalName() + "</b></font></td></tr></table></td></tr><tr><td align='center'width='100%' colspan='13'><font color='black' size='4'><b>" + resultEntryVOGroupByValidatedBy.getHospitalCity() + "</b></font></td></tr>";
       int noLinesPresent=0;// to subtract from header height if hos add not present
        String reportLogoPath = PropertiesHelper.getReportLogoPath();
        ///String ReportBlackLine=PropertiesHelper.getReportBlackLine();
        String reportRightLogoPath = PropertiesHelper.getReportRightLogoPath();
        
        
		/*
		 * String reportHeaderPath = PropertiesHelper.getReportHeaderPath(); String
		 * NablLogo = PropertiesHelper.getNablLogoPath();
		 */
         String hospitalString = "";
         String addressMetaData = (((resultEntryVOGroupByValidatedBy.getHosAdd1().equals(""))||(resultEntryVOGroupByValidatedBy.getHosAdd1().equals(" "))) ? "":(resultEntryVOGroupByValidatedBy.getHosAdd1()+"<br>")) +
        		 (((resultEntryVOGroupByValidatedBy.getHosAdd2().equals(""))||(resultEntryVOGroupByValidatedBy.getHosAdd2().equals(" "))) ? "":(resultEntryVOGroupByValidatedBy.getHosAdd2()+"<br>")) +
         		(((resultEntryVOGroupByValidatedBy.getHospitalCity().equals(""))||(resultEntryVOGroupByValidatedBy.getHospitalCity().equals(" "))) ? "":(resultEntryVOGroupByValidatedBy.getHospitalCity()+","))+
         		resultEntryVOGroupByValidatedBy.getHosDistrict()+
         		((resultEntryVOGroupByValidatedBy.getHosPin().equals("")) ? "":("-" + resultEntryVOGroupByValidatedBy.getHosPin()+","))+
         		((resultEntryVOGroupByValidatedBy.getHosState().equals("")) ? "":(resultEntryVOGroupByValidatedBy.getHosState()+","))+
         		" INDIA"+
         		"<br>" +
         		(((resultEntryVOGroupByValidatedBy.getHospitalPhone().equals(""))||(resultEntryVOGroupByValidatedBy.getHospitalPhone().equals(" "))) ? "":("Phone :"+resultEntryVOGroupByValidatedBy.getHospitalPhone()+" "))+
         		(((resultEntryVOGroupByValidatedBy.getHosFax().equals(""))||(resultEntryVOGroupByValidatedBy.getHosFax().equals(" "))) ? "":("Fax :"+resultEntryVOGroupByValidatedBy.getHosFax()+" "))+
         		(((resultEntryVOGroupByValidatedBy.getHosEmail().equals(""))||(resultEntryVOGroupByValidatedBy.getHosEmail().equals(" "))) ? "":("Email :"+resultEntryVOGroupByValidatedBy.getHosEmail()));
         
         String deptName = "<tr align='center'><td colspan='13' width='100%'><font color='black' size='4'>Department of " + resultEntryVOGroupByValidatedBy.getLabDeptName() + "</font></td></tr>";
       
         if(((resultEntryVOGroupByValidatedBy.getHosAdd2().equals(""))||(resultEntryVOGroupByValidatedBy.getHosAdd2().equals(" "))))
        	 	noLinesPresent++;
         if(((resultEntryVOGroupByValidatedBy.getHosAdd1().equals(""))||(resultEntryVOGroupByValidatedBy.getHosAdd1().equals(" "))))
        	 noLinesPresent++;
     
      
         if(resultEntryVOGroupByValidatedBy.getIsreportlablabelchanged()!=null && !resultEntryVOGroupByValidatedBy.getIsreportlablabelchanged().equals("0"))
         {
        	 
         if(reportLogoPath != null && reportLogoPath != "")
         {
        	 hospitalString = "<table cellspacing='0' cellpadding='0' border='0' width='100%'><tr><td align='center' width='100%' colspan='13'>" + 
               		"<table><tr><td width='10%' rowspan='2'><img src='" + reportLogoPath + 
               		"' height='50' width='50'/></td>"+
               		"<td width='90%' align='center'><font color='black' size='4'><b>" 
               		+ resultEntryVOGroupByValidatedBy.getHospitalName() +             		
               		"</b>"+
               		"</font>"+
               		"<br>" + 
               		"<font color='black' size='3'><b>" + 
               		addressMetaData +
               	    "</b></font></td> <td width='10%' rowspan='2'><img src='" + reportRightLogoPath + "' height='50' width='50'/></td></tr>"
       
               	    + "</table></td></tr>";
        	 
    
            	    
         }
         else {
        	
        	 
        	 hospitalString = "<table  cellpadding='0' border='0' width='100%' style='border-spacing: 0px'><tr><td align='center' width='100%' colspan='13'><tr><td align='left'><span>"+qrCODE+"</span></td></tr>" 
             		+"<table><tr><td width='10%' rowspan='2'></td>"+
             		"<td width='90%' align='center'><font color='black' size='4'><b>" 
             		+ resultEntryVOGroupByValidatedBy.getHospitalName() +          		
             		"</b>"+
             		"</font>"+
             		"<br>" + 
             		"<font color='black' size='3'><b>" + 
             		addressMetaData +
             		" " +
             	    "</b></font></td></tr>"
						/* "<tr><td align='left'><span>"+qrCODE+"</span></td></tr>" */
             	    + "</table></td></tr>"; 
         }
       
        System.out.println("hospitalString nandini>>"+hospitalString);
        
        headerString.append(hospitalString);
         
       
        headerString.append("<tr align='center'><td colspan='13' width='100%'><font color='black' size='4'>Department of " + resultEntryVOGroupByValidatedBy.getLabDeptName() + "</font></td></tr>");
        //headerString.append("<tr><td  colspan='6'><font color='black' size='3'><b>Laboratory :</b>" + resultEntryVOGroupByValidatedBy.getLaboratoryName() + "</font></td>");
        headerString.append("<tr><td  colspan='6'><font color='black' size='3'>" + resultEntryVOGroupByValidatedBy.getLaboratoryName() + "</font></td>");
        
    
        if(resultEntryVOGroupByValidatedBy.getIsDeptEntry().equals("1"))
       	 headerString.append("<td align='right' colspan='7'><font color='black' size='3'><b>Department Report</b>");
      
        else  if(resultEntryVOGroupByValidatedBy.getIsReportChange().equals("2") || resultEntryVOGroupByValidatedBy.getIsReportChange().equals("3") || resultEntryVOGroupByValidatedBy.getIsReportChange().equals("1"))
        	 headerString.append("<td align='right' colspan='7'><font color='black' size='3'><b>Status :</b>"+ resultEntryVOGroupByValidatedBy.getChangeCount() +" Amendment/Addendum Report</td></tr>");
       else
        	 headerString.append("<td align='right' colspan='7'></td></tr>");
        
        
        
        /*Add Sample Name for Changed Request Recived on 29 dec 2010*/
        setPageHeaderHeight(resultEntryVOGroupByValidatedBy);
        headerString.append(lineString);

        //subtract from header height according to the hos lines not present
        resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) - (noLinesPresent*15)));
     
        if (resultEntryVOGroupByValidatedBy.getPatAdmissionNo() != null) {
            headerString.append("<tr><td width='10%'><div align='left'><font size='2'><b>CR 2No</b></font></div></td>");
            headerString.append("<td width='57%' colspan='3'><div align='left'>: <font size='2'>" + resultEntryVOGroupByValidatedBy.getPatCRNo() + (resultEntryVOGroupByValidatedBy.getSampleCollectionOfflineRemarks() != null ? "(" + resultEntryVOGroupByValidatedBy.getSampleCollectionOfflineRemarks() + ")" : "") + "</font></div></td>");
            //headerString.append("<td width="17%"><div align='left'>:&nbsp;<font style="text-transform: capitalize;"><bean:write name="workOrderGroup"  property="visitDate"/></font></div></td>-->
            headerString.append("<td width='15%'><div align='left'><font size='2'><b>Admission No</b></font></div></td>");
            headerString.append("<td width='18%'><div align='left'>: <font size='2'>" + resultEntryVOGroupByValidatedBy.getPatAdmissionNo() + "</font></div></td>");
            headerString.append("</tr>");
        } else {

         
        	
        	 headerString.append("<tr><td colspan='2'><div align='left'><font size='2'><b>CR 3No</b></font></div></td>");
             headerString.append("<td colspan='3'><div align='left'>: <font size='2'>" + resultEntryVOGroupByValidatedBy.getPatCRNo() + (resultEntryVOGroupByValidatedBy.getSampleCollectionOfflineRemarks() != null ? "(" + resultEntryVOGroupByValidatedBy.getSampleCollectionOfflineRemarks() + ")" : "") + "</font></div></td>");
             //headerString.append("<td width="17%"><div align='left'>:&nbsp;<font style="text-transform: capitalize;"><bean:write name="workOrderGroup"  property="visitDate"/></font></div></td>-->
             
             if(resultEntryVOGroupByValidatedBy.getIsreportlablabelchanged()==null || resultEntryVOGroupByValidatedBy.getIsreportlablabelchanged().equals("0"))
             headerString.append("<td colspan='2'><div align='left'><font size='2'><b>Lab/Study No.</b></font></div></td>");
             else
            	 headerString.append("<td colspan='2'><div align='left'><font size='2'><b>Accession No.</b></font></div></td>");	 
             
             
         	String key=resultEntryVOGroupByValidatedBy.getRequisitionNo()+"#"+resultEntryVOGroupByValidatedBy.getSampleCode()+"#"+resultEntryVOGroupByValidatedBy.getLaboratoryCode();

      	  /* if(mp!=null && mp.containsKey(key))
        	   {
      	      String labno=	mp.get(key);
      	     resultEntryVOGroupByValidatedBy.setLabNo(labno);
        	   }*/
      	   
         	 if(mplabno!=null && mplabno.containsKey(key))
      	   {
    	      String labno=	mplabno.get(key);
    	      if(labno!=null)
    	     resultEntryVOGroupByValidatedBy.setLabNo(labno);
    	      else
    	      {
    	    	 if(mp!=null && mp.containsKey(key))
        	   {
    	    		String labno1=	mp.get(key);
          	      if(labno1!=null)
          	     resultEntryVOGroupByValidatedBy.setLabNo(labno1); 
        	   }
    	      }
    	      
      	   }
         	 else if(mp!=null && mp.containsKey(key))
      	   {
  	    		String labno1=	mp.get(key);
        	      if(labno1!=null)
        	     resultEntryVOGroupByValidatedBy.setLabNo(labno1); 
      	   }
         	 
             headerString.append("<td colspan='2'><div align='left'> <font size='2'>:&nbsp;" + resultEntryVOGroupByValidatedBy.getLabNo() + "</font></div></td>");
             
             if(resultEntryVOGroupByValidatedBy.getLabNo()!=null && resultEntryVOGroupByValidatedBy.getLabNo()!=null && resultEntryVOGroupByValidatedBy.getLabNo().length()>13)
             {    islabelprintindoubleline.put("lab/accessno", "1");
                islabelprintindoubleline.put("lab/accessno1", "1");
             }
             
             headerString.append("<td colspan='2'><div align='left'><font size='2'><b>Procedure Date</b></font></div></td>");
             
             String collDate = resultEntryVOGroupByValidatedBy.getCollDate();
             if (collDate == null || collDate == "null") {
             	if(resultEntryVOGroupByValidatedBy.getUserSampleNo() != null)
             		collDate = "--";
             	else if(resultEntryVOGroupByValidatedBy.getPatAcceptanceDate() != null)
             		collDate = resultEntryVOGroupByValidatedBy.getPatAcceptanceDate();
             	else
             		collDate = "--";
             }
             
            
             headerString.append("<td colspan='2'><div align='left'>: <font size='1'>" + collDate + "</font></div></td>");
 			
             
             headerString.append("</tr>");
        }
            
        //added by chandan
        headerString.append("<tr><td colspan='2'><div align='left'><font size='2'><b>Patient Name</b></font></div></td>");
        headerString.append("<td colspan='3'><div align='left'>: <font size='2'>" + resultEntryVOGroupByValidatedBy.getPatName() + "</font></div></td>");
        //headerString.append("<td width="17%"><div align='left'>:&nbsp;<font style="text-transform: capitalize;"><bean:write name="workOrderGroup"  property="visitDate"/></font></div></td>-->
     

        if(resultEntryVOGroupByValidatedBy.getPatName().length()>21)
        {
        	islabelprintindoubleline.put("patname", "1");
            islabelprintindoubleline.put("patname1", "1");
        }
        
        headerString.append("<td colspan='2''><div align='left'><font size='2'><b>Age/Sex</b></font></div></td>");
        headerString.append("<td colspan='2'><div align='left'>: <font size='2'>" + resultEntryVOGroupByValidatedBy.getPatAge() + "/" + resultEntryVOGroupByValidatedBy.getPatGenderShortName() + "</font></div></td>");
      
        headerString.append("<td colspan='2'><div align='left'><font size='2'><b>Reporting Date</b></font></div></td>");
      
        String reportDate = resultEntryVOGroupByValidatedBy.getResultValidationDate();
        if (reportDate == null || reportDate == "null") {
        	reportDate = "--";
        }
        
        headerString.append("<td colspan='2'><div align='left'>: <font size='1'>" + reportDate + "</font></div></td>");
        headerString.append("</tr>");
        
      
        if(resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired()==null || resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired().equals("0"))
        {
        headerString.append("<tr><td colspan='2'><div align='left'><font size='2'><b>Sample Type/No</b></font></div></td>");
        if(resultEntryVOGroupByValidatedBy.getUserSampleNo() != null)
        {
        	
        	String key=resultEntryVOGroupByValidatedBy.getRequisitionNo()+"#"+resultEntryVOGroupByValidatedBy.getSampleCode()+"#"+resultEntryVOGroupByValidatedBy.getLaboratoryCode();

     	   if(mp!=null && mp.containsKey(key))
       	   {
     	      String sampleno=	mp.get(key);
     	     resultEntryVOGroupByValidatedBy.setUserSampleNo(sampleno);
       	   }
     	   
        	headerString.append("<td colspan='3'><div align='left'> <font size='2'>:&nbsp;" + resultEntryVOGroupByValidatedBy.getSampleName() + "/" + resultEntryVOGroupByValidatedBy.getUserSampleNo() + "</font></div></td>");
        

            if((resultEntryVOGroupByValidatedBy.getSampleName()+resultEntryVOGroupByValidatedBy.getUserSampleNo()).length()>21)
            {
            	islabelprintindoubleline.put("sampletype_ward", "1");
            	islabelprintindoubleline.put("sampletype_ward1", "1");
            }
        }else
        {
        	headerString.append("<td colspan='3'><div align='left'> <font size='2'>:&nbsp;" + resultEntryVOGroupByValidatedBy.getSampleName() + "</font></div></td>");
        

            if((resultEntryVOGroupByValidatedBy.getSampleName()).length()>21)
            {
            	islabelprintindoubleline.put("sampletype_ward", "1");
            	islabelprintindoubleline.put("sampletype_ward1", "1");
            }
        }

        
        
        }
        else
        {
        	if (resultEntryVOGroupByValidatedBy.getRequisitionTypeCode() != null && resultEntryVOGroupByValidatedBy.getRequisitionTypeCode().equals("1")) {
        	
            	headerString.append("<tr><td  colspan='2'><div align='left'><font size='2'><b>Ward/OPD</b></font></div></td>");
                headerString.append("<td  colspan='3'><div align='left'>: <font size='2'>OPD</font></div></td>");
                
        	}
        	else if (resultEntryVOGroupByValidatedBy.getRequisitionTypeCode() != null && resultEntryVOGroupByValidatedBy.getRequisitionTypeCode().equals("2")) {
        		
        		headerString.append("<tr><td colspan='2'><div align='left'><font size='2'><b>Ward</b></font></div></td>");
                headerString.append("<td  colspan='3'><div align='left'>: <font size='2'>" + ((resultEntryVOGroupByValidatedBy.getWardName() == null) ? "IPD" : resultEntryVOGroupByValidatedBy.getWardName())  + "</font></div></td>");
                
              
                
        	}

        	if (resultEntryVOGroupByValidatedBy.getRequisitionTypeCode() != null && resultEntryVOGroupByValidatedBy.getRequisitionTypeCode().equals("3")) {
            	
            	headerString.append("<tr><td  colspan='2'><div align='left'><font size='2'><b>Ward/OPD</b></font></div></td>");
                headerString.append("<td  colspan='3'><div align='left'>: <font size='2'>OPD</font></div></td>");
                
        	}if (resultEntryVOGroupByValidatedBy.getRequisitionTypeCode() != null && resultEntryVOGroupByValidatedBy.getRequisitionTypeCode().equals("4")) {
        	
            	headerString.append("<tr><td  colspan='2'><div align='left'><font size='2'><b>Ward/OPD</b></font></div></td>");
                headerString.append("<td  colspan='3'><div align='left'>: <font size='2'>OPD</font></div></td>");
                
        	}
        	
        }
        //headerString.append("<td width="17%"><div align='left'>:&nbsp;<font style="text-transform: capitalize;"><bean:write name="workOrderGroup"  property="visitDate"/></font></div></td>-->
       
        
        
        if (resultEntryVOGroupByValidatedBy.getRequisitionTypeCode() != null && resultEntryVOGroupByValidatedBy.getRequisitionTypeCode().equals("2")) 
        	{      
        	if(resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired()!=null || resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired().equals("1"))
            {
        	
        		 headerString.append("<td  colspan='2'><div align='left'><font size='2'><b>Room/Bed</b></font></div></td>");
        	        headerString.append("<td  colspan='6'><div align='left'>: <font size='2'>" + ((resultEntryVOGroupByValidatedBy.getRoomName() == null) ? "-" : resultEntryVOGroupByValidatedBy.getRoomName().trim()) +"/"+((resultEntryVOGroupByValidatedBy.getBedName() == null) ? "-" : resultEntryVOGroupByValidatedBy.getBedName().trim()) + "</font></div></td></tr>");
        	       
        	        
            }
        	
        	else
        	{
        headerString.append("<td  colspan='2'><div align='left'><font size='2'><b>Room/Bed</b></font></div></td>");
        headerString.append("<td  colspan='2'><div align='left'>: <font size='2'>" + ((resultEntryVOGroupByValidatedBy.getRoomName() == null) ? "-" : resultEntryVOGroupByValidatedBy.getRoomName().trim()) +"/"+((resultEntryVOGroupByValidatedBy.getBedName() == null) ? "-" : resultEntryVOGroupByValidatedBy.getBedName().trim()) + "</font></div></td>");
        	}
        	
        	}
        	else
        	{
        		
        		  headerString.append("<td colspan='2'><div align='left'><font size='2'><b>Dept/Unit8</b></font></div></td>");
        	        headerString.append("<td colspan='2'><div align='left'>: <font size='2'>" + resultEntryVOGroupByValidatedBy.getPatDeptUnit() + "</font></div></td>");
        	       
        	        if(resultEntryVOGroupByValidatedBy.getPatDeptUnit().length()>16)
                        {
        	        	islabelprintindoubleline.put("deptunit", "1");
                        islabelprintindoubleline.put("deptunit1", "1");
                        }
        	        
        	        if (resultEntryVOGroupByValidatedBy.getRequisitionTypeCode().equals("3") || resultEntryVOGroupByValidatedBy.getRequisitionTypeCode().equals("4") || resultEntryVOGroupByValidatedBy.getRequisitionTypeCode().equals("1")) 
                	{  
        	        if(resultEntryVOGroupByValidatedBy.getIsReportChange().equals("1")||resultEntryVOGroupByValidatedBy.getIsReportChange().equals("2")||resultEntryVOGroupByValidatedBy.getIsReportChange().equals("3"))
        	        {
        	        	if(resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired()!=null && resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired().equals("1"))
        	            {
        	        	headerString.append("<td colspan='2'><div align='left'><font size='2'><b>Addendum Date</b></font></div></td>");
        	            headerString.append("<td colspan='2'><div align='left'>: <font size='1'>" + resultEntryVOGroupByValidatedBy.getAddendumDate()+ "</font></div></td>");
        	           
        	            headerString.append("</tr><tr><td colspan='9'></td>");
            	        
        	            }
        	        	
        	            }
        	        else
        	        {
        	        	if(resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired()!=null && resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired().equals("1"))
        	            {
        	        headerString.append("<td colspan='2'></td>");
        	        headerString.append("<td colspan='2'></td>");
        	        headerString.append("</tr><tr><td colspan='9'></td>");
        	                	        
        	            }
        	        	
        	            }
                	}

        	}
 
    
      
        if(resultEntryVOGroupByValidatedBy.getIsReportChange().equals("1")||resultEntryVOGroupByValidatedBy.getIsReportChange().equals("2")||resultEntryVOGroupByValidatedBy.getIsReportChange().equals("3"))
        {
        	if(resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired()==null || resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired().equals("0"))
            {
        	headerString.append("<td colspan='2'><div align='left'><font size='2'><b>Addendum Date</b></font></div></td>");
            headerString.append("<td colspan='2'><div align='left'>: <font size='1'>" + resultEntryVOGroupByValidatedBy.getAddendumDate()+ "</font></div></td>");
            }
        	
            }
        else
        {
        	if(resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired()==null || resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired().equals("0"))
            {
        headerString.append("<td colspan='2'></td>");
        headerString.append("<td colspan='2'></td>");
            }
        	
            }
        
        
   
        if(resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired()==null || resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired().equals("0"))
        {
        headerString.append("</tr>");
        }
        
        
        if (resultEntryVOGroupByValidatedBy.getRequisitionTypeCode() != null && resultEntryVOGroupByValidatedBy.getRequisitionTypeCode().equals("2")) 
    	{  
        	if(resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired()==null || resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired().equals("0"))
            {
        headerString.append("<tr><td colspan='2'><div align='left'><font size='2'><b>Dept/Unit1</b></font></div></td>");
        headerString.append("<td colspan='3'><div align='left'>: <font size='2'>" + resultEntryVOGroupByValidatedBy.getPatDeptUnit() + "</font></div></td>");
    	}
        	else
        	{
        		headerString.append("<tr><td colspan='2'><div align='left'><font size='2'><b>Dept/Unit2</b></font></div></td>");
                headerString.append("<td colspan='7'><div align='left'>: <font size='2'>" + resultEntryVOGroupByValidatedBy.getPatDeptUnit() + "</font></div></td>");
            		
                if(resultEntryVOGroupByValidatedBy.getIsReportChange().equals("1")||resultEntryVOGroupByValidatedBy.getIsReportChange().equals("2")||resultEntryVOGroupByValidatedBy.getIsReportChange().equals("3"))
                {
                	headerString.append("<td colspan='2'><div align='left'><font size='2'><b>Addendum Date</b></font></div></td>");
                    headerString.append("<td colspan='2'><div align='left'>: <font size='1'>" + resultEntryVOGroupByValidatedBy.getAddendumDate()+ "</font></div></td>");
                    
                	
                    }
                else
                {
                	
                	headerString.append("<td colspan='2'></td>");
                    headerString.append("<td colspan='2'></td>");
                    
                    
                }
                
        	}
    	}
        else
        {
        	headerString.append("<tr><td colspan='2'><div align='left'><font size='2'></font></div></td>");
            headerString.append("<td colspan='3'><div align='left'> <font size='2'></font></div></td>");
        		
        }
        
        if(resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired()==null || resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired().equals("0"))
        {
        headerString.append("<td  colspan='2'><div align='left'><font size='2'></div></td>");
        headerString.append("<td  colspan='5'><div align='left'> <font size='2'></font></div></td>");
        headerString.append("<td colspan='1'></td></tr>");
        }
        


        String labNoString = "";
        if (resultEntryVOGroupByValidatedBy.getLabNoList() != null && resultEntryVOGroupByValidatedBy.getLabNoList().size() != 0) {
            labNoString = "";
            for (int i = 0; i < resultEntryVOGroupByValidatedBy.getLabNoList().size(); i++) {
                if (i == 0) {
                    labNoString = resultEntryVOGroupByValidatedBy.getLabNoList().get(i);
                } else {
                    labNoString += "," + resultEntryVOGroupByValidatedBy.getLabNoList().get(i);
                }
            }

        }

    
      
       
        headerString.append("<tr>");
       
       
        //column header should be removed in case of dynamic Report template.Bug 12237.
        //not required for laboratory radiology
        //this condition needs to be replaced by the flag for particular lab
        if(resultEntryVOGroupByValidatedBy.getDisplayHeader().equals("0"))
        {
        	if (resultEntryVOGroupByValidatedBy.getPrintingType() != null && resultEntryVOGroupByValidatedBy.getPrintingType().equals("1")) {
                headerString.append(lineString);
               
                resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) + 10));
            } else {
                resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) - 2));
            }
        	
        	
        }
        else
        {
        if(resultEntryVOGroupByValidatedBy.getIsdynamicGroupTemplate().equals("0") && resultEntryVOGroupByValidatedBy.getIsdynamicTestTemplate().equals("0"))
        {
        if (resultEntryVOGroupByValidatedBy.getPrintingType() != null && resultEntryVOGroupByValidatedBy.getPrintingType().equals("1")) {
            headerString.append(lineString);
            headerString.append(standardRangesString);
            //resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) + 4));
            resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) + 25));
        } else {
            resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) - 2));
        }
        }
        else
        {
            if (resultEntryVOGroupByValidatedBy.getPrintingType() != null && resultEntryVOGroupByValidatedBy.getPrintingType().equals("1")) {
                headerString.append(lineString);
                headerString.append(standardRangesString);
                resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) + 10));
            } else {
                resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) - 2));
            }
        	
        	
        	
        }
        }
        //resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) + 2));
        resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) + 12));
        headerString.append(lineString);
        headerString.append("</table>");
    }
         else
        	 
         {
         
         
         //nandini
         ///chanduuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu
        
         if(reportLogoPath != null && reportLogoPath != "")
         {
        	
        	 reportLogoPath="data:image/jpeg;base64,/9j/4QAYRXhpZgAASUkqAAgAAAAAAAAAAAAAAP/sABFEdWNreQABAAQAAABkAAD/4QMtaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLwA8P3hwYWNrZXQgYmVnaW49Iu+7vyIgaWQ9Ilc1TTBNcENlaGlIenJlU3pOVGN6a2M5ZCI/PiA8eDp4bXBtZXRhIHhtbG5zOng9ImFkb2JlOm5zOm1ldGEvIiB4OnhtcHRrPSJBZG9iZSBYTVAgQ29yZSA3LjEtYzAwMCA3OS5kYWJhY2JiLCAyMDIxLzA0LzE0LTAwOjM5OjQ0ICAgICAgICAiPiA8cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPiA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtbG5zOnhtcE1NPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvbW0vIiB4bWxuczpzdFJlZj0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL3NUeXBlL1Jlc291cmNlUmVmIyIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgMjIuNSAoV2luZG93cykiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6QkYxNjI2QjM4QzgxMTFFRkJCOEVFMEU0ODhBODg0MzIiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6QkYxNjI2QjQ4QzgxMTFFRkJCOEVFMEU0ODhBODg0MzIiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDpCRjE2MjZCMThDODExMUVGQkI4RUUwRTQ4OEE4ODQzMiIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDpCRjE2MjZCMjhDODExMUVGQkI4RUUwRTQ4OEE4ODQzMiIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/Pv/uAA5BZG9iZQBkwAAAAAH/2wCEAAEBAQEBAQEBAQEBAQEBAQEB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";

        	 
        	 
        	 hospitalString = "<table cellspacing='0' cellpadding='0' border='0' style='width:100%;' >" + 
        	 		//"    <tr><td align='right'><span>"+qrCODE+"</span></td></tr>" + 
        	 		"     <tr><td><img  src='"+reportLogoPath+"' style='margin-left: 250%;' height='100' width='100'/></td><td><span>"+qrCODE+"</span></td></tr></table> " + 
        	 		"       <table cellspacing='0' cellpadding='0' border='0' style='width:100%;text-align:center'>" + 
        	 		"        <tr><td><font color='black' size='3'><b>"+ resultEntryVOGroupByValidatedBy.getHospitalName() +"</b></font></td></tr>" + 
        	 		"        <tr><td><font color='black' size='3'><b>"+addressMetaData+"</b></font></td></tr>"+
        	 		"</table>" ;
        	 
				/* <tr><td align='right'><span>"+qrCODE+"</span></td></tr> */
            	    
         }
         else {
          
        	 
        	 
        	 hospitalString = "<table cellspacing='0' cellpadding='0' border='0' style='width:100%;text-align:center'><tr><td><font color='black' size='4'><b>For Testing Only</b></font></td></tr>" + 
         	 		"        <tr><td><font color='black' size='3'><b>"+ resultEntryVOGroupByValidatedBy.getHospitalName() +"</b></font></td></tr>" + 
         	 		"        <tr><td><font color='black' size='3'><b>"+addressMetaData+"</b></font></td></tr></table>" ;
         	 
         }
       
        
        headerString.append(hospitalString);
    
        
        
        headerString.append("<table cellspacing='0' cellpadding='0' border='0' style='width:100%;text-align:center'>" + 
        		"    <tr>" + 
        		"        <td><font color='black' size='4'>  Lab Report </font></td>" + 
        		"    </tr>" + 
        		"     <tr>" + 
        		"         <td style='text-align:left;'><font color='black' size='3'><b>" + resultEntryVOGroupByValidatedBy.getLaboratoryName() + "</b></font></td>" + 
        		"         </tr></table>");
        
        
         
     	headerString.append("<tr>");
        if(resultEntryVOGroupByValidatedBy.getIsDeptEntry().equals("1"))
       	 headerString.append("<td align='right' colspan='7'><font color='black' size='3'><b>Department Report</b></td></tr>");
      
        else  if(resultEntryVOGroupByValidatedBy.getIsReportChange().equals("2") || resultEntryVOGroupByValidatedBy.getIsReportChange().equals("3") || resultEntryVOGroupByValidatedBy.getIsReportChange().equals("1"))
        	 headerString.append("<td align='right' colspan='7'><font color='black' size='3'><b>Status :</b>"+ resultEntryVOGroupByValidatedBy.getChangeCount() +" Amendment/Addendum Report</td></tr>");
       else
        	 headerString.append("<td align='right' colspan='7'></td></tr>");
        
        
        
        /*Add Sample Name for Changed Request Recived on 29 dec 2010*/
        setPageHeaderHeight(resultEntryVOGroupByValidatedBy);
        headerString.append("<table style='width:100%;'><tr><td align='right' colspan='7'></td></tr>");
        headerString.append(lineString);

        //subtract from header height according to the hos lines not present
        resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) - (noLinesPresent*15)));
     
        if (resultEntryVOGroupByValidatedBy.getPatAdmissionNo() != null) {
            headerString.append("<tr><td width='10%'><div align='left'><font size='1'><b>Ben Id</b></font></div></td>");
            headerString.append("<td width='57%' colspan='3'><div align='left'>: <font size='1'>" + resultEntryVOGroupByValidatedBy.getPatCRNo() + (resultEntryVOGroupByValidatedBy.getSampleCollectionOfflineRemarks() != null ? "(" + resultEntryVOGroupByValidatedBy.getSampleCollectionOfflineRemarks() + ")" : "") + "</font></div></td>");
             headerString.append("<td width='15%'><div align='left'><font size='2'><b>Admission No</b></font></div></td>");
            headerString.append("<td width='18%'><div align='left'>: <font size='2'>" + resultEntryVOGroupByValidatedBy.getPatAdmissionNo() + "</font></div></td>");
            headerString.append("</tr>");
        } else {

            
        	
        	 headerString.append("<tr><td colspan='2'><div align='left'><font style='font-size: 12px;'><b>Ben Id</b></font></div></td>");
             headerString.append("<td colspan='3'><div align='left'>: <font style='font-size: 12px;'>" + resultEntryVOGroupByValidatedBy.getPatCRNo() + (resultEntryVOGroupByValidatedBy.getSampleCollectionOfflineRemarks() != null ? "(" + resultEntryVOGroupByValidatedBy.getSampleCollectionOfflineRemarks() + ")" : "") + "</font></div></td>");
              
            
             if(resultEntryVOGroupByValidatedBy.getIsreportlablabelchanged()==null || resultEntryVOGroupByValidatedBy.getIsreportlablabelchanged().equals("0"))
             headerString.append("<td colspan='2'><div align='left'><font style='font-size: 12px;'><b>Lab/Study No.</b></font></div></td>");
             else
            	 headerString.append("<td colspan='2'><div align='left'><font size='2'><b>Accession No.</b></font></div></td>");	
             
             String key=resultEntryVOGroupByValidatedBy.getRequisitionNo()+"#"+resultEntryVOGroupByValidatedBy.getSampleCode()+"#"+resultEntryVOGroupByValidatedBy.getLaboratoryCode();

        	   
             if(mplabno!=null && mplabno.containsKey(key))
      	   {
    	      String labno=	mplabno.get(key);
    	      if(labno!=null)
    	     resultEntryVOGroupByValidatedBy.setLabNo(labno);
    	      else
    	      {
    	    	 if(mp!=null && mp.containsKey(key))
        	   {
    	    		String labno1=	mp.get(key);
          	      if(labno1!=null)
          	     resultEntryVOGroupByValidatedBy.setLabNo(labno1); 
        	   }
    	      }
    	      
      	   }
             else if(mp!=null && mp.containsKey(key))
      	   {
  	    		String labno1=	mp.get(key);
        	      if(labno1!=null)
        	     resultEntryVOGroupByValidatedBy.setLabNo(labno1); 
      	   }
             
             
             headerString.append("<td colspan='2'><div align='left'> <font style='font-size: 12px;'>:&nbsp;" + resultEntryVOGroupByValidatedBy.getLabNo() + "</font></div></td>");
          
             if(resultEntryVOGroupByValidatedBy.getLabNo().length()>13)
             {  islabelprintindoubleline.put("lab/accessno", "1");
             islabelprintindoubleline.put("lab/accessno1", "1");
             }
            
             headerString.append("<td colspan='2'><div align='left'><font style='font-size: 12px;'><b>Requisition Date</b></font></div></td>");
             String reqDate = resultEntryVOGroupByValidatedBy.getRequisitionDate();
             if (reqDate == null || reqDate == "null") {
                 reqDate = "--";
             }
             headerString.append("<td colspan='2'><div align='left'>: <font style='font-size: 12px;'>" + reqDate + "</font></div></td>");
 			
             
             headerString.append("</tr>");
        }
            
        //added by chandan
        
        
        headerString.append("<tr><td colspan='2'><div align='left'><font style='font-size: 12px;'><b>Patient Name</b></font></div></td>");
        headerString.append("<td colspan='3'><div align='left'>: <font style='font-size: 12px;'>" + resultEntryVOGroupByValidatedBy.getPatName() + "</font></div></td>");
      
        if(resultEntryVOGroupByValidatedBy.getPatName().length()>15)
            {
        	islabelprintindoubleline.put("patname", "1");
            islabelprintindoubleline.put("patname1", "1");

            }
        
        headerString.append("<td colspan='2'><div align='left'><font style='font-size: 12px;'><b>Age/Sex</b></font></div></td>");
        headerString.append("<td colspan='2'><div align='left'>: <font style='font-size: 12px;'>" + resultEntryVOGroupByValidatedBy.getPatAge() + "/" + resultEntryVOGroupByValidatedBy.getPatGenderShortName() + "</font></div></td>");
        if(resultEntryVOGroupByValidatedBy.getIsreportcollectionlabelchanged()==null || resultEntryVOGroupByValidatedBy.getIsreportcollectionlabelchanged().equals("0"))
        headerString.append("<td colspan='2'><div align='left'><font style='font-size: 12px;'><b>Coll./Study Date</b></font></div></td>");
        else
        	headerString.append("<td colspan='2'><div align='left'><font style='font-size: 12px;'><b>Study Date</b></font></div></td>");
        String collDate = resultEntryVOGroupByValidatedBy.getCollDate();
        if (collDate == null || collDate == "null") {
        	if(resultEntryVOGroupByValidatedBy.getUserSampleNo() != null)
        		collDate = "--";
        	else if(resultEntryVOGroupByValidatedBy.getPatAcceptanceDate() != null)
        		collDate = resultEntryVOGroupByValidatedBy.getPatAcceptanceDate();
        	else
        		collDate = "--";
        }
        
        headerString.append("<td colspan='2'><div align='left'>: <font style='font-size: 11px;'>" + collDate + "</font></div></td>");
        headerString.append("</tr>");
        
      

        if(resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired()==null || resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired().equals("0"))
        {
        headerString.append("<tr><td colspan='2'><div align='left'><font style='font-size: 12px;'><b>Sample Type/No</b></font></div></td>");
        if(resultEntryVOGroupByValidatedBy.getUserSampleNo() != null)
        	{
        	
        	String key=resultEntryVOGroupByValidatedBy.getRequisitionNo()+"#"+resultEntryVOGroupByValidatedBy.getSampleCode()+"#"+resultEntryVOGroupByValidatedBy.getLaboratoryCode();

     	   if(mp!=null && mp.containsKey(key))
       	   {
     	      String sampleno=	mp.get(key);
     	     resultEntryVOGroupByValidatedBy.setUserSampleNo(sampleno);
       	   }
     	   
        	headerString.append("<td colspan='3'><div align='left'> <font style='font-size: 12px;'>:&nbsp;" + resultEntryVOGroupByValidatedBy.getSampleName() + "/" + resultEntryVOGroupByValidatedBy.getUserSampleNo() + "</font></div></td>");
        	

            if((resultEntryVOGroupByValidatedBy.getSampleName()+resultEntryVOGroupByValidatedBy.getUserSampleNo()).length()>20)
                islabelprintindoubleline.put("sampletype_ward", "1");
            islabelprintindoubleline.put("sampletype_ward1", "1");
        	} else
        { 	
        	headerString.append("<td colspan='3'><div align='left'> <font style='font-size: 12px;'>:&nbsp;" + resultEntryVOGroupByValidatedBy.getSampleName() + "</font></div></td>");
        

        if((resultEntryVOGroupByValidatedBy.getSampleName()).length()>20)
        {
            islabelprintindoubleline.put("sampletype_ward", "1");
        islabelprintindoubleline.put("sampletype_ward1", "1");
        }
        
        }
        
        }
        else
        {
        	if (resultEntryVOGroupByValidatedBy.getRequisitionTypeCode() != null && resultEntryVOGroupByValidatedBy.getRequisitionTypeCode().equals("1")) {
        	
            	headerString.append("<td  colspan='2'><div align='left'><font style='font-size: 12px;'><b>Ward/OPD</b></font></div></td>");
                headerString.append("<td  colspan='3'><div align='left'>: <font size='2'>OPD</font></div></td>");
                
        	}
        	else if (resultEntryVOGroupByValidatedBy.getRequisitionTypeCode() != null && resultEntryVOGroupByValidatedBy.getRequisitionTypeCode().equals("2")) {
        		
        		headerString.append("<td colspan='2'><div align='left'><font size='2'><b>Ward</b></font></div></td>");
                headerString.append("<td  colspan='3'><div align='left'>: <font style='font-size: 12px;'>" + ((resultEntryVOGroupByValidatedBy.getWardName() == null) ? "IPD" : resultEntryVOGroupByValidatedBy.getWardName())  + "</font></div></td>");
                
                if((resultEntryVOGroupByValidatedBy.getWardName()).length()>15)
                {
                	islabelprintindoubleline.put("sampletype_ward", "1");
                    islabelprintindoubleline.put("sampletype_ward1", "1");
                    
                }
                
        	}

        	
        }
        //headerString.append("<td width="17%"><div align='left'>:&nbsp;<font style="text-transform: capitalize;"><bean:write name="workOrderGroup"  property="visitDate"/></font></div></td>-->
       
       /* headerString.append("<td colspan='2''><div align='left'><font size='2'><b>Clinician</b></font></div></td>");
        String clinicianName = resultEntryVOGroupByValidatedBy.getClinicianName();
        if (clinicianName == null || clinicianName == "null") {
            clinicianName = "--";
        }
        headerString.append("<td colspan='2'><div align='left'>: <font size='2'>" + clinicianName + "</font></div></td>");
      */
        
        if (resultEntryVOGroupByValidatedBy.getRequisitionTypeCode() != null && resultEntryVOGroupByValidatedBy.getRequisitionTypeCode().equals("2")) 
        {

        	   headerString.append("<td colspan='2'><div align='left'><font size='2'><b>Ward</b></font></div></td>");
               headerString.append("<td  colspan='2'><div align='left'>: <font style='font-size: 11px;'>" + ((resultEntryVOGroupByValidatedBy.getWardName() == null) ? "IPD" : resultEntryVOGroupByValidatedBy.getWardName())  + "</font></div></td>");
               
               if((resultEntryVOGroupByValidatedBy.getWardName()).length()>15)
                   {
            	      	islabelprintindoubleline.put("sampletype_ward", "1");
                       islabelprintindoubleline.put("sampletype_ward1", "1");
                   }
                   
               
        }
        else if (resultEntryVOGroupByValidatedBy.getRequisitionTypeCode() != null && resultEntryVOGroupByValidatedBy.getRequisitionTypeCode().equals("1")) {
            
    		headerString.append("<td  colspan='2'><div align='left'><font style='font-size: 12px;'><b>Ward/OPD</b></font></div></td>");
               headerString.append("<td  colspan='2'><div align='left'>: <font size='1'>OPD</font></div></td>");
        }
        else if (resultEntryVOGroupByValidatedBy.getRequisitionTypeCode() != null && resultEntryVOGroupByValidatedBy.getRequisitionTypeCode().equals("3")) {
            // headerString.append("<tr>");//emergency case. modify as reqd.
             headerString.append("<td  colspan='2'><div align='left'><font size='2'><b>Ward/OPD</b></font></div></td>");
             headerString.append("<td  colspan='2'><div align='left'>: <font size='1'>OPD</font></div></td>");
        }
        else if (resultEntryVOGroupByValidatedBy.getRequisitionTypeCode() != null && resultEntryVOGroupByValidatedBy.getRequisitionTypeCode().equals("4")) {
            // headerString.append("<tr>");//special case. modify as reqd.
             headerString.append("<td  colspan='2'><div align='left'><font size='2'><b>Ward/OPD</b></font></div></td>");
             headerString.append("<td  colspan='2'><div align='left'>: <font size='1'>OPD</font></div></td>");
        }
        
        
        
        headerString.append("<td colspan='2'><div align='left'><font style='font-size: 12px;'><b>Reporting Date</b></font></div></td>");
        String reportDate = resultEntryVOGroupByValidatedBy.getResultValidationDate();
        if (reportDate == null || reportDate == "null") {
        	reportDate = "--";
        }
        headerString.append("<td colspan='2'><div align='left'>: <font style='font-size: 12px;'>" + reportDate + "</font></div></td>");
       
        
        headerString.append("</tr>");
        
        
        

        String labNoString = "";
        if (resultEntryVOGroupByValidatedBy.getLabNoList() != null && resultEntryVOGroupByValidatedBy.getLabNoList().size() != 0) {
            labNoString = "";
            for (int i = 0; i < resultEntryVOGroupByValidatedBy.getLabNoList().size(); i++) {
                if (i == 0) {
                    labNoString = resultEntryVOGroupByValidatedBy.getLabNoList().get(i);
                } else {
                    labNoString += "," + resultEntryVOGroupByValidatedBy.getLabNoList().get(i);
                }
            }

        }

 
    
        
        if (resultEntryVOGroupByValidatedBy.getRequisitionTypeCode() != null && resultEntryVOGroupByValidatedBy.getRequisitionTypeCode().equals("2")) {

       	 
        	if(resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired()==null || resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired().equals("0"))
        	{

            headerString.append("<tr><td  colspan='2'><div align='left'><font size='2'><b>Room/Bed</b></font></div></td>");
            headerString.append("<td  colspan='3'><div align='left'>: <font size='2'>" + ((resultEntryVOGroupByValidatedBy.getRoomName() == null) ? "-" : resultEntryVOGroupByValidatedBy.getRoomName().trim()) +"/"+((resultEntryVOGroupByValidatedBy.getBedName() == null) ? "-" : resultEntryVOGroupByValidatedBy.getBedName().trim()) + "</font></div></td>");
            
            headerString.append("<td colspan='2'><div align='left'><font size='2'><b>Dept/Unit3</b></font></div></td>");
            headerString.append("<td colspan='6'><div align='left'>: <font size='2'>" + resultEntryVOGroupByValidatedBy.getPatDeptUnit() + "</font></div></td>");
            
           // headerString.append("<td colspan='2'></td>");
            //headerString.append("<td  colspan='3'></td>");
              
            
            //headerString.append("<td colspan='1'></td></tr>");
            headerString.append("</tr>");
        	}
        	else
        	{
        		  headerString.append("<tr><td  colspan='2'><div align='left'><font size='2'><b>Room/Bed</b></font></div></td>");
                  headerString.append("<td  colspan='3'><div align='left'>: <font size='2'>" + ((resultEntryVOGroupByValidatedBy.getRoomName() == null) ? "-" : resultEntryVOGroupByValidatedBy.getRoomName().trim()) +"/"+((resultEntryVOGroupByValidatedBy.getBedName() == null) ? "-" : resultEntryVOGroupByValidatedBy.getBedName().trim()) + "</font></div></td>");
                  //headerString.append("<td colspan='6'></td></tr>");
                  
                  headerString.append("<td colspan='2'><div align='left'><font size='2'><b>Dept/Unit4</b></font></div></td>");
                  headerString.append("<td colspan='6'><div align='left'>: <font size='2'>" + resultEntryVOGroupByValidatedBy.getPatDeptUnit() + "</font></div></td>");
                  
                  headerString.append("</tr>");
              		
        		
        	}

           resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) + 80));
       } else if (resultEntryVOGroupByValidatedBy.getRequisitionTypeCode() != null && resultEntryVOGroupByValidatedBy.getRequisitionTypeCode().equals("1")) {
         //  headerString.append("<tr>");
    	   if(resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired()==null || resultEntryVOGroupByValidatedBy.getIsreportsamplelabelrequired().equals("0"))

    		   {
    		   
    		   // unit26
    		   
    		   headerString.append("<tr><td colspan='2'><div align='left'><font style='font-size: 12px;'><b>Dept/Unit</b></font></div></td>");
               headerString.append("<td colspan='11'><div align='left'>: <font style='font-size: 12px;'>" + resultEntryVOGroupByValidatedBy.getPatDeptUnit() + "</font></div></td>");
               headerString.append("<tr><td colspan='2'><div align='left'><font style='font-size: 12px;'><b>Lab InCharge</b></font></div></td>");
               headerString.append("<td colspan='11'><div align='left'>: <font style='font-size: 12px;'>" + userName + "</font></div></td>");
              
    		   }
    	  //  headerString.append("<td colspan='2'><div align='left'><font style='font-size: 12px;'><b>Lab</b></font></div></td>");
            //headerString.append("<td colspan='2'><div align='left'>:<font style='font-size: 12px;'>"+userName+"</font></div></td>");
    	   headerString.append("</tr>");
    	
          headerString.append("</tr>");
//           resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) + 10));
          
         System.out.print(" resultEntryVOGroupByValidatedBy.getHeaderHeight()>>>>"+resultEntryVOGroupByValidatedBy.getHeaderHeight()); 
           resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) + 40));
       } else if (resultEntryVOGroupByValidatedBy.getRequisitionTypeCode() != null && resultEntryVOGroupByValidatedBy.getRequisitionTypeCode().equals("3")) {
          // headerString.append("<tr>");//emergency case. modify as reqd.
         //  headerString.append("<td  colspan='2'><div align='left'><font size='2'><b>Ward/OPD</b></font></div></td>");
           //headerString.append("<td  colspan='3'><div align='left'>: <font size='2'>OPD</font></div></td>");
           //headerString.append("<td colspan='2'></td>");
          // headerString.append("<td  colspan='3'></td>");
         
				/*
				 * headerString.append("<td colspan='2'></td>");
				 * headerString.append("<td colspan='2'></td>");
				 * headerString.append("<td colspan='2'></td>");
				 * headerString.append("<td colspan='2'></td></tr>");
				 */
         // Unit50
    	   headerString.append("<tr><td colspan='2'><div align='left'><font size='2'><b>Dept/Unit</b></font></div></td>");
           headerString.append("<td colspan='11'><div align='left'>: <font size='2'>" + resultEntryVOGroupByValidatedBy.getPatDeptUnit() + "</font></div></td>");
           headerString.append("<tr><td colspan='2'><div align='left'><font style='font-size: 12px;'><b>Lab InCharge</b></font></div></td>");
           headerString.append("<td colspan='11'><div align='left'>: <font style='font-size: 12px;'>" + userName + "</font></div></td>");
          
           headerString.append("</tr>");
//           resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) + 10));
           resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) + 40));

       }  else if (resultEntryVOGroupByValidatedBy.getRequisitionTypeCode() != null && resultEntryVOGroupByValidatedBy.getRequisitionTypeCode().equals("4")) {
          // headerString.append("<tr>");//special case. modify as reqd.
         //  headerString.append("<td  colspan='2'><div align='left'><font size='2'><b>Ward/OPD</b></font></div></td>");
          // headerString.append("<td  colspan='3'><div align='left'>: <font size='2'>OPD</font></div></td>");
    	   //headerString.append("<td colspan='2'></td>");
          // headerString.append("<td  colspan='3'></td>");
         
				/*
				 * headerString.append("<td colspan='2'></td>");
				 * headerString.append("<td colspan='2'></td>");
				 * headerString.append("<td colspan='2'></td>");
				 * headerString.append("<td colspan='2'></td>");
				 */
    	   
    	   // Unit7
           
           headerString.append("<tr><td colspan='2'><div align='left'><font size='2'><b>Dept/Unit</b></font></div></td>");
           headerString.append("<td colspan='11'><div align='left'>: <font size='2'>" + resultEntryVOGroupByValidatedBy.getPatDeptUnit() + "</font></div></td>");
           headerString.append("<tr><td colspan='2'><div align='left'><font style='font-size: 12px;'><b>Lab InCharge</b></font></div></td>");
           headerString.append("<td colspan='11'><div align='left'>: <font style='font-size: 12px;'>" + userName + "</font></div></td>");
          
           headerString.append("</tr>");
        //   headerString.append("</tr>");
//           resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) + 10));
           resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) + 40));

       }
         //end
     //   headerString.append(lineString1);
         
       
        


        //column header should be removed in case of dynamic Report template.Bug 12237.
        //not required for laboratory radiology
        //this condition needs to be replaced by the flag for particular lab
        if(resultEntryVOGroupByValidatedBy.getDisplayHeader().equals("0"))
        {
        	if (resultEntryVOGroupByValidatedBy.getPrintingType() != null && resultEntryVOGroupByValidatedBy.getPrintingType().equals("1")) {
                headerString.append(lineString);
               
                resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) + 10));
            } else {
                resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) - 2));
            }
        	
        	
        }
        else
        {
        if(resultEntryVOGroupByValidatedBy.getIsdynamicGroupTemplate().equals("0") && resultEntryVOGroupByValidatedBy.getIsdynamicTestTemplate().equals("0"))
        {
        if (resultEntryVOGroupByValidatedBy.getPrintingType() != null && resultEntryVOGroupByValidatedBy.getPrintingType().equals("1")) {
            headerString.append(lineString);
          //  headerString.append("</table>");
            headerString.append(standardRangesString);
            headerString.append(lineString);
            headerString.append("</table>");
            System.out.println("TestName"+resultEntryVOGroupByValidatedBy.getTestName());
           // headerString.append(lineString1);
            resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) + 25));
            resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) - 2));
        } else {
            resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) - 2));
        }
        }
        else
        {
            if (resultEntryVOGroupByValidatedBy.getPrintingType() != null && resultEntryVOGroupByValidatedBy.getPrintingType().equals("1")) {
                //headerString.append(lineString);
                //headerString.append(standardRangesString);
                //resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) + 10));
                resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) - 2));
            } else {
                resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) - 2));
            }
        	
        	
        	
        }
        }
        //resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) + 2));
        resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) + 12));
        headerString.append(lineString);
        headerString.append("</table>");
        
         }
         
         
        //setPageHeaderHeight(resultEntryVOGroupByValidatedBy);

         //Log(Level.INFO, "headerString------->" + headerString.toString());
        resultEntryVOGroupByValidatedBy.setHeader(headerString.toString());

	       
        if(islabelprintindoubleline!=null && islabelprintindoubleline.size()>0)
        	resultEntryVOGroupByValidatedBy.setIslabeldoubleline(islabelprintindoubleline.size());
        	else
        		resultEntryVOGroupByValidatedBy.setIslabeldoubleline(0);
    }

    public static synchronized void getDefaultHeaderUnRegisteredPatient(ResultEntryVOGroupByValidatedBy resultEntryVOGroupByValidatedBy) {
        StringBuffer headerString = new StringBuffer();
        String hospitalString = "<table  cellpadding='0' border='0' width='100%' style='border-spacing: 0px'><tr><td align='center' width='100%' colspan='13'><font color='black' size='5'><b>" + Config.hospitalnameatreport + "</b></font></td></tr><tr><td align='center'width='100%' colspan='13'><font color='black' size='4'><b>" + Config.hospitaladdressatreport + "</b></font></td></tr>";
        headerString.append(hospitalString);

        headerString.append("<tr align='center'><td colspan='13' width='100%'><font color='black' size='2'>Dept.56 of " + resultEntryVOGroupByValidatedBy.getDepartmentName() + "</font></td></tr>");

        headerString.append("<tr><td width='50%' colspan='3'><font color='black' size='2'><b>Laboratory43 :</b>" + resultEntryVOGroupByValidatedBy.getLaboratoryName() + "</font></td>");
        /*change reuqest 29 dec 2010*/
        if (resultEntryVOGroupByValidatedBy.getSampleNameList() != null && resultEntryVOGroupByValidatedBy.getSampleNameList().size() != 0) {
            String sampleNameString = "";
            for (int i = 0; i < resultEntryVOGroupByValidatedBy.getSampleNameList().size(); i++) {
                if (i == 0) {
                    sampleNameString = resultEntryVOGroupByValidatedBy.getSampleNameList().get(i);
                } else {
                    sampleNameString = "," + resultEntryVOGroupByValidatedBy.getSampleNameList().get(i);
                }
            }

            headerString.append("<td align='right' width='50%' colspan='3'><font color='black' size='3'><b>Sample :</b>" + sampleNameString + "</font></td></tr>");
        } else {
            headerString.append("<td align='right' width='50%' colspan='3'></td></tr>");
        }
        /*change reuqest 29 dec 2010*/
        headerString.append(lineString);

        headerString.append("<tr>");
        headerString.append("<td width='5%'><div align='left'><b>CR No</b></div></td>");
        headerString.append("<td width='20%'><div align='left'>:&nbsp;<font style='text-transform: capitalize;'>NA</font></div></td>");
        headerString.append("<td width='20%'><div align='left'><b>Patient Name</b></div></td>");
        headerString.append("<td width='32%'><div align='left'>:&nbsp;<font style='text-transform: capitalize;'>" + resultEntryVOGroupByValidatedBy.getPatName() + "</font></div></td>");
        headerString.append("<td width='15%'><div align='left'><b>Age/Sex</b></div></td>");
        headerString.append("<td width='18%'><div align='left'>:&nbsp;<font style='text-transform: capitalize;'>" + resultEntryVOGroupByValidatedBy.getPatAge() + "/" + resultEntryVOGroupByValidatedBy.getPatGenderShortName() + "</font></div></td>");
        headerString.append("</tr>");
        headerString.append("<tr>");
        headerString.append("<td width='5%'><div align='left'><b>Unit</b></div></td>");
        headerString.append("<td width='60%' colspan='3'><div align='left'>:&nbsp;<font style='text-transform: capitalize;'>NA</font></div></td>");
        //headerString.append("<td width="17%"><div align='left'>:&nbsp;<font style="text-transform: capitalize;"><bean:write name="workOrderGroup"  property="visitDate"/></font></div></td>-->
        headerString.append("<td width='15%'><div align='left'><b>Req. Date</b></div></td>");
        String reqDate = resultEntryVOGroupByValidatedBy.getRequisitionDate();
        if (reqDate == null || reqDate == "null") {
            reqDate = "--";
        }
        headerString.append("<td width='20%'><div align='left'>:&nbsp;<font style='text-transform: capitalize;'>" + reqDate + "</font></div></td>");
        headerString.append("</tr>");
        headerString.append("<tr>");
        headerString.append("<td width='5%'><div align='left'><b>Clinician</b></div></td>");
        String clinicianName = resultEntryVOGroupByValidatedBy.getClinicianName();
        if (clinicianName == null || clinicianName == "null") {
            clinicianName = "";
        }
        headerString.append("<td width='29%'><div align='left'>:&nbsp;<font style='text-transform: capitalize;'>" + clinicianName + "</font></div></td>");

        /*if(resultEntryVOGroupByValidatedBy.getSampleNameList()!=null && resultEntryVOGroupByValidatedBy.getSampleNameList().size()!=0)  
         {
         String sampleNameString=""; 
         for(int i=0;i<resultEntryVOGroupByValidatedBy.getSampleNameList().size();i++)
         {
         if(i==0)
         {
         sampleNameString=resultEntryVOGroupByValidatedBy.getSampleNameList().get(i);
         }
         else
         {
         sampleNameString=","+resultEntryVOGroupByValidatedBy.getSampleNameList().get(i);
         }
         }
			
         headerString.append("<td width='16%'><div align='left'><b>Sample </b></div></td>");
         headerString.append("<td width='17%'><div align='left'>:&nbsp;<font style='text-transform: capitalize;'>"+sampleNameString+"</font></div></td>");
         }*/
        if (resultEntryVOGroupByValidatedBy.getResultEntryVOListValidatedBy().size() != 1) {
            headerString.append("<td width='15%'><div align='left'><b>&nbsp;</b></div></td>");
            headerString.append("<td width='18%'><div align='left'>&nbsp;</div></td>");
        } else {
            headerString.append("<td width='15%'><div align='left'><b>Test</b></div></td>");
            headerString.append("<td width='18%'><div align='left'>:&nbsp;<font style='text-transform: capitalize;'>" + resultEntryVOGroupByValidatedBy.getTestName() + "</font></div></td>");
        }
        headerString.append("<tr>");

        if (resultEntryVOGroupByValidatedBy.getCurrentDiagnosis() != null) {
           /* headerString.append("<tr><td width='10%'><div align='left'><font size='2'><b>Diagnosis</b></font></div></td><td width='90%' colspan='5'><div align='left'>: <font size='2'>" + resultEntryVOGroupByValidatedBy.getCurrentDiagnosisName() + "</font></div></td></tr>");*/
            headerString.append("<tr><td width='10%'><div align='left'><font size='2'><b>Diagnosis</b></font></div></td><td width='90%' colspan='5'><div align='left'>: <font size='2'></font></div></td></tr>");        
        
        } else {
            headerString.append("<tr><td width='10%'><div align='left'><font size='2'><b>Diagnosis</b></font></div></td><td width='90%' colspan='5'><div align='left'>: <font size='2'></font></div></td></tr>");
        }

        resultEntryVOGroupByValidatedBy.setHeaderHeight("" + (Float.parseFloat(resultEntryVOGroupByValidatedBy.getHeaderHeight()) + 35)); //added this line whenever add new tr

        if(resultEntryVOGroupByValidatedBy.getIsdynamicGroupTemplate().equals("0") && resultEntryVOGroupByValidatedBy.getIsdynamicTestTemplate().equals("0"))
        if (resultEntryVOGroupByValidatedBy.getPrintingType().equals("1")) {
            headerString.append(lineString);
            headerString.append(standardRangesString);

        }
        else
        {
        	  if (resultEntryVOGroupByValidatedBy.getPrintingType().equals("1")) {
                  headerString.append(lineString);
                  

              }
        	
        	
        }

     //   headerString.append(lineString);

        //Log(Level.INFO,headerString.toString());
        resultEntryVOGroupByValidatedBy.setHeader(headerString.toString());

    }

    public static synchronized String setPageHeaderHeight(ResultEntryVOGroupByValidatedBy resultEntryVOGroupByValidatedBy) {
        String pageHeaderHeight = "";
        if (resultEntryVOGroupByValidatedBy.getPageSize() == null || resultEntryVOGroupByValidatedBy.getPageSize().equals("") == false) {
            resultEntryVOGroupByValidatedBy.setPageSize(Config.pagewidthheight);
        }

        if (resultEntryVOGroupByValidatedBy.getPageSize().equals(Config.pagewidthheight)) {
            resultEntryVOGroupByValidatedBy.setHeaderHeight("198.0");

            if (resultEntryVOGroupByValidatedBy.getPrintingType() != null && resultEntryVOGroupByValidatedBy.getPrintingType().equals("1")) {
                resultEntryVOGroupByValidatedBy.setHeaderHeight("200.0");
            }

        } else if (resultEntryVOGroupByValidatedBy.getPageSize().equals("A2")) {
            resultEntryVOGroupByValidatedBy.setHeaderHeight("120.0");
        } else {
            resultEntryVOGroupByValidatedBy.setHeaderHeight("200.0");
        }

        return pageHeaderHeight;
    }

    public static synchronized void getDefaultFooter(ResultEntryVOGroupByValidatedBy resultEntryVOGroupByValidatedBy) {
        StringBuffer headerString = new StringBuffer();
        
        
        
        headerString.append("<div ><table width='100%' height='5%' cellspacing='0' cellpadding='0' border='0'>");
      //  headerString.append(lineString);
        
        if(resultEntryVOGroupByValidatedBy.getIsReportChange()!=null && !resultEntryVOGroupByValidatedBy.getIsReportChange().equals("0") )
        {
        	headerString.append("<tr><td><font color='black' size='1px'>" + Config.disclaimeratreport + " </font></td></tr>");
        	headerString.append("<tr><td align='right' colspan='6'><div align='left'><font color='black' size='1'><b>" + Config.specialstringatreport +
        			" </b></font></div></td><td align='right' colspan='7'><div align='right'><font color='black' size='1'><b>Report Modified By: </b>" +
        			resultEntryVOGroupByValidatedBy.getReportChangedBy() + "</font></div></td></tr>");
        	
        }
        else{
    /*    if (resultEntryVOGroupByValidatedBy.getLaboratoryCode().equals("10401")) {

            headerString.append("<tr><td align='right' colspan='3'><div align='left'><font color='black' size='1'><b>" + Config.specialstringatreport + " </b></font></div></td><td align='right' colspan='3'><div align='right'><font color='black' size='1'><b>Entered By: </b>" + resultEntryVOGroupByValidatedBy.getResultEnteredBy() + "</font></div><div align='right'><font color='black' size='1'><b>Validated By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy() + "(" + resultEntryVOGroupByValidatedBy.getValidatedDate() + ")</font></div></td></tr>");
        } else {*/
        	
        	if(resultEntryVOGroupByValidatedBy.getIsDeptEntry().equals("1"))
        	{
        		if(resultEntryVOGroupByValidatedBy.getIsNablAccritedTest()!=null && resultEntryVOGroupByValidatedBy.getIsNablAccritedTest().equals("1"))
        		{
        			String 	testcodes=PGDataHelper.getInstance().getTestCodesAccrebited(resultEntryVOGroupByValidatedBy.getHospitalCode());
                  	String 	TestNames=PGDataHelper.getInstance().getTestNameAccrebited(testcodes);
                  	String NablLogo = PropertiesHelper.getNablLogoPath();
                  	
                  	System.out.println("TestNames>>>>>>"+TestNames);
                  	headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='2'><b>" +"\"*"+ TestNames + " Tests are NABL accredited.\" </b></font></div></td></tr>");
                 
                  	headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1px'>" + Config.disclaimeratreport + " </font></div></td></tr>");
                  	
                  	
                  	if(resultEntryVOGroupByValidatedBy.getIsenteredbyrequired()!=null && resultEntryVOGroupByValidatedBy.getIsenteredbyrequired().equals("1"))
                  	{
                  	
                  		if(resultEntryVOGroupByValidatedBy.getRevalidatedBy()!=null && !resultEntryVOGroupByValidatedBy.getRevalidatedBy().equals("") && !resultEntryVOGroupByValidatedBy.getRevalidatedBy().equals(",") )
          			{
        			headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1'><b>Prepared By: </b>" + resultEntryVOGroupByValidatedBy.getEnteredby()  +  "<b>&nbsp;&nbsp;&nbsp;Validated By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy()  + "<b>&nbsp;&nbsp;&nbsp;Revalidated By: </b>" + resultEntryVOGroupByValidatedBy.getRevalidatedBy() +   "</font></div></td></tr>");
          			}else
          				headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1'><b>Prepared By: </b>" + resultEntryVOGroupByValidatedBy.getEnteredby()  +  "<b>&nbsp;&nbsp;&nbsp;Validated By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy()  +    "</font></div></td></tr>");
                  	
                  	}
                  	else
                  	{
                  	
                  		if(resultEntryVOGroupByValidatedBy.getRevalidatedBy()!=null && !resultEntryVOGroupByValidatedBy.getRevalidatedBy().equals("") &&  !resultEntryVOGroupByValidatedBy.getRevalidatedBy().equals(","))
              			{
            			headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1'><b>Validated By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy()  + "<b>&nbsp;&nbsp;&nbsp;Revalidated By: </b>" + resultEntryVOGroupByValidatedBy.getRevalidatedBy() +   "</font></div></td></tr>");
              			}else
              				headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1'><b>Validated 2By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy()  +    "</font></div></td></tr>");
                 
                  	}
                  	
                  	//headerString.append("<tr><td align='right' colspan='6'><div align='left'><font color='black' size='1'><b>" + Config.specialstringatreport + " </b></font></div></td><td align='right' colspan='7'><div align='right'><font color='black' size='1'><b>Entered By: </b>" + resultEntryVOGroupByValidatedBy.getDeptResultEnteredBy() + "</font></div><div align='right'><font color='black' size='2'><b>Validated By: </b>" + ((resultEntryVOGroupByValidatedBy.getDeptResultModifyBy()==null || resultEntryVOGroupByValidatedBy.getDeptResultModifyBy().equals("")) ?resultEntryVOGroupByValidatedBy.getDeptResultEnteredBy():resultEntryVOGroupByValidatedBy.getDeptResultModifyBy()) + "</font></div></td></tr>");
                  	if(resultEntryVOGroupByValidatedBy.getRevalidatedBy()!=null && !resultEntryVOGroupByValidatedBy.getRevalidatedBy().equals("") && !resultEntryVOGroupByValidatedBy.getRevalidatedBy().equals(","))
          			{
    	  				headerString.append("<tr><td align='right' colspan='13'><div align='left' ><font color='black' size='1'><b>" + Config.specialstringatreport + " </b></font></div></td></tr>");
    	  				
    	  			//	headerString.append("<tr><td align='right' colspan='13'><div align='right'  ><font color='black' size='2'><b>Validated By: </b>" + ((resultEntryVOGroupByValidatedBy.getDeptResultModifyBy()==null || resultEntryVOGroupByValidatedBy.getDeptResultModifyBy().equals("")) ?resultEntryVOGroupByValidatedBy.getDeptResultEnteredBy():resultEntryVOGroupByValidatedBy.getDeptResultModifyBy()) + "<b>&nbsp;&nbsp;&nbsp;&nbsp;Revalidated By: </b>" + resultEntryVOGroupByValidatedBy.getRevalidatedBy() + "</font></div></td></tr>");
          			}
    	  			else
                  	headerString.append("<tr><td align='right' colspan='6'><div align='left'><font color='black' size='1'><b>" + Config.specialstringatreport + " </b></font></div></td><td align='right' colspan='7'></td></tr>");
        		}
        		else{
        		
        			headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1px'>" + Config.disclaimeratreport + " </font></div></td></tr>");
        			
        			
        			if(resultEntryVOGroupByValidatedBy.getIsenteredbyrequired()!=null && resultEntryVOGroupByValidatedBy.getIsenteredbyrequired().equals("1"))
                  	{
                  	
                  		if(resultEntryVOGroupByValidatedBy.getRevalidatedBy()!=null && !resultEntryVOGroupByValidatedBy.getRevalidatedBy().equals("") && !resultEntryVOGroupByValidatedBy.getRevalidatedBy().equals(","))
          			{
        			headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1'><b>Prepared By: </b>" + resultEntryVOGroupByValidatedBy.getEnteredby()  +  "<b>&nbsp;&nbsp;&nbsp;Validated By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy()  + "<b>&nbsp;&nbsp;&nbsp;Revalidated By: </b>" + resultEntryVOGroupByValidatedBy.getRevalidatedBy() +   "</font></div></td></tr>");
          			}else
          				headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1'><b>Prepared By: </b>" + resultEntryVOGroupByValidatedBy.getEnteredby()  +  "<b>&nbsp;&nbsp;&nbsp;Validated By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy()  +    "</font></div></td></tr>");
                  	
                  	}
                  	else
                  	{
                  	
                  		if(resultEntryVOGroupByValidatedBy.getRevalidatedBy()!=null && !resultEntryVOGroupByValidatedBy.getRevalidatedBy().equals("") && !resultEntryVOGroupByValidatedBy.getRevalidatedBy().equals(","))
              			{
            			headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1'><b>Validated By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy()  + "<b>&nbsp;&nbsp;&nbsp;Revalidated By: </b>" + resultEntryVOGroupByValidatedBy.getRevalidatedBy() +   "</font></div></td></tr>");
              			}else
              				headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1'><b>Validated By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy()  +    "</font></div></td></tr>");
                 
                  	}
        			
             //headerString.append("<tr><td align='right' colspan='6'><div align='left'><font color='black' size='1'><b>" + Config.specialstringatreport + " </b></font></div></td><td align='right' colspan='7'><div align='right'><font color='black' size='1'><b>Entered By: </b>" + resultEntryVOGroupByValidatedBy.getDeptResultEnteredBy() + "</font></div><div align='right'><font color='black' size='2'><b>Validated By: </b>" + ((resultEntryVOGroupByValidatedBy.getDeptResultModifyBy()==null || resultEntryVOGroupByValidatedBy.getDeptResultModifyBy().equals("")) ?resultEntryVOGroupByValidatedBy.getDeptResultEnteredBy():resultEntryVOGroupByValidatedBy.getDeptResultModifyBy()) + "</font></div></td></tr>");
        			if(resultEntryVOGroupByValidatedBy.getRevalidatedBy()!=null && !resultEntryVOGroupByValidatedBy.getRevalidatedBy().equals("") && !resultEntryVOGroupByValidatedBy.getRevalidatedBy().equals(","))
          			{
    	  			//	headerString.append("<tr><td align='right' colspan='13'><div align='left' ><font color='black' size='1'><b>" + Config.specialstringatreport + " </b></font></div></td></tr>");
    	  			//	headerString.append("<tr><td align='right' colspan='13'><div align='right'  ><font color='black' size='2'><b>Validated By: </b>" + ((resultEntryVOGroupByValidatedBy.getDeptResultModifyBy()==null || resultEntryVOGroupByValidatedBy.getDeptResultModifyBy().equals("")) ?resultEntryVOGroupByValidatedBy.getDeptResultEnteredBy():resultEntryVOGroupByValidatedBy.getDeptResultModifyBy()) + "<b>&nbsp;&nbsp;&nbsp;&nbsp;Revalidated By: </b>" + resultEntryVOGroupByValidatedBy.getRevalidatedBy() + "</font></div></td></tr>");
          			}
    	  			else
        			headerString.append("<tr><td align='right' colspan='6'><div align='left'><font color='black' size='1'><b>" + Config.specialstringatreport + " </b></font></div></td><td align='right' colspan='7'></td></tr>");
        		}
        		
        	
        	}	/*else  if(resultEntryVOGroupByValidatedBy.getIsNablAccritedTest()!=null && resultEntryVOGroupByValidatedBy.getIsNablAccritedTest().equals("1"))
          		
          	{
          		String 	testcodes=PGDataHelper.getInstance().getTestCodesAccrebited(resultEntryVOGroupByValidatedBy.getHospitalCode());
          	String 	TestNames=PGDataHelper.getInstance().getTestNameAccrebited(testcodes);
          	String NablLogo = PropertiesHelper.getNablLogoPath();
          	headerString.append("<tr><td align='left' colspan='12'><div align='left'  ><font color='black' size='2'><b>" +"** "+ TestNames + " Tests are NABL accredited. </b></font></div></td><td align='right' colspan='1'><div align='right' > <img src='" + NablLogo + "' height='40' width='50'/></div></td></tr>");
          	headerString.append("<tr ><td align='right' colspan='6'><div align='left' ><font color='black' size='1'><b>" + Config.specialstringatreport + " </b></font></div></td><td align='right' colspan='7'><div align='right' ><font color='black' size='1'><b>Entered By: </b>" + resultEntryVOGroupByValidatedBy.getResultEnteredBy() + "</font></div><div align='right'  ><font color='black' size='1'><b>Validated By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy() + "</font></div></td></tr>");
          	
          	}*/
        		else {
        			
        			if(resultEntryVOGroupByValidatedBy.getIsNablAccritedTest()!=null && resultEntryVOGroupByValidatedBy.getIsNablAccritedTest().equals("1"))
        			{
        				String 	testcodes=PGDataHelper.getInstance().getTestCodesAccrebited(resultEntryVOGroupByValidatedBy.getHospitalCode());
        	          	String 	TestNames=PGDataHelper.getInstance().getTestNameAccrebited(testcodes);
        	          	String NablLogo = PropertiesHelper.getNablLogoPath();
        	          	headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='2'><b>" +"\"*"+ TestNames + " Tests are NABL accredited.\" </b></font></div></td></tr>");
        	          /*	if(resultEntryVOGroupByValidatedBy.getRevalidatedBy()!=null && !resultEntryVOGroupByValidatedBy.getRevalidatedBy().equals(""))
              			{
        	          	headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1'><b>" + Config.disclaimeratreport + " </b>"+ "<b>&nbsp;&nbsp;&nbsp;Validated By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy()  + "<b>&nbsp;&nbsp;&nbsp;Revalidated By: </b>" + resultEntryVOGroupByValidatedBy.getRevalidatedBy() +   "</font></div></td></tr>");
              			}
        	          	else
                      		headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1'><b>" + Config.disclaimeratreport + " </b>"+ "<b>&nbsp;&nbsp;&nbsp;Validated By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy()  +  "</font></div></td></tr>");		
        	          	*/
        	          	headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1px'>" + Config.disclaimeratreport + " </font></div></td></tr>");
        				
        	          	if(resultEntryVOGroupByValidatedBy.getIsenteredbyrequired()!=null && resultEntryVOGroupByValidatedBy.getIsenteredbyrequired().equals("1"))
                      	{
                      	
                      		if(resultEntryVOGroupByValidatedBy.getRevalidatedBy()!=null && !resultEntryVOGroupByValidatedBy.getRevalidatedBy().equals("") && !resultEntryVOGroupByValidatedBy.getRevalidatedBy().equals(","))
              			{
            			headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1'><b>Prepared By: </b>" + resultEntryVOGroupByValidatedBy.getEnteredby()  +  "<b>&nbsp;&nbsp;&nbsp;Validated By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy()  + "<b>&nbsp;&nbsp;&nbsp;Revalidated By: </b>" + resultEntryVOGroupByValidatedBy.getRevalidatedBy() +   "</font></div></td></tr>");
              			}else
              				headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1'><b>Prepared By: </b>" + resultEntryVOGroupByValidatedBy.getEnteredby()  +  "<b>&nbsp;&nbsp;&nbsp;Validated By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy()  +    "</font></div></td></tr>");
                      	
                      	}
                      	else
                      	{
                      	
                      		if(resultEntryVOGroupByValidatedBy.getRevalidatedBy()!=null && !resultEntryVOGroupByValidatedBy.getRevalidatedBy().equals("") && !resultEntryVOGroupByValidatedBy.getRevalidatedBy().equals(","))
                  			{
                			headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1'><b>Validated By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy()  + "<b>&nbsp;&nbsp;&nbsp;Revalidated By: </b>" + resultEntryVOGroupByValidatedBy.getRevalidatedBy() +   "</font></div></td></tr>");
                  			}else
                  				headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1'><b>Validated By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy()  +    "</font></div></td></tr>");
                     
                      	}
        	          	
        	          	//headerString.append("<tr ><td align='right' colspan='6'><div align='left' ><font color='black' size='1'><b>" + Config.specialstringatreport + " </b></font></div></td><td align='right' colspan='7'><div align='right' ><font color='black' size='1'><b>Entered By: </b>" + resultEntryVOGroupByValidatedBy.getResultEnteredBy() + "</font></div><div align='right'  ><font color='black' size='2'><b>Validated By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy() + "</font></div></td></tr>");
        	          	
        	          	headerString.append("<tr><td align='right' colspan='6'><div align='left' ><font color='black' size='1'><b>" + Config.specialstringatreport + " </b></font></div></td><td align='right' colspan='7'></td></tr>");
        				
        			}
        			else{
//        				
        				headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1px'>" + Config.disclaimeratreport + " </font></div></td></tr>");
        				
        				/*if(resultEntryVOGroupByValidatedBy.getRevalidatedBy()!=null && !resultEntryVOGroupByValidatedBy.getRevalidatedBy().equals(""))
              			{
        				headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1'><b>" + Config.disclaimeratreport + " </b>"+ "<b>&nbsp;&nbsp;&nbsp;Validated By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy()  + "<b>&nbsp;&nbsp;&nbsp;Revalidated By: </b>" + resultEntryVOGroupByValidatedBy.getRevalidatedBy() +   "</font></div></td></tr>");
              			}
        				else
                      		headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1'><b>" + Config.disclaimeratreport + " </b>"+ "<b>&nbsp;&nbsp;&nbsp;Validated By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy()  +  "</font></div></td></tr>");		
        				*/
        				
        				if(resultEntryVOGroupByValidatedBy.getIsenteredbyrequired()!=null && resultEntryVOGroupByValidatedBy.getIsenteredbyrequired().equals("1"))
                      	{
                      	
                      		if(resultEntryVOGroupByValidatedBy.getRevalidatedBy()!=null && !resultEntryVOGroupByValidatedBy.getRevalidatedBy().equals("") && !resultEntryVOGroupByValidatedBy.getRevalidatedBy().equals(","))
              			{
            			headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1'><b>Prepared By: </b>" + resultEntryVOGroupByValidatedBy.getEnteredby()  +  "<b>&nbsp;&nbsp;&nbsp;Validated By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy()  + "<b>&nbsp;&nbsp;&nbsp;Revalidated By: </b>" + resultEntryVOGroupByValidatedBy.getRevalidatedBy() +   "</font></div></td></tr>");
              			}else
              				headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1'><b>Prepared By: </b>" + resultEntryVOGroupByValidatedBy.getEnteredby()  +  "<b>&nbsp;&nbsp;&nbsp;Validated By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy()  +    "</font></div></td></tr>");
                      	
                      	}
                      	else
                      	{
                      	
                      		if(resultEntryVOGroupByValidatedBy.getRevalidatedBy()!=null && !resultEntryVOGroupByValidatedBy.getRevalidatedBy().equals("") && !resultEntryVOGroupByValidatedBy.getRevalidatedBy().equals(","))
                  			{
                			headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1'><b>Validated By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy()  + "<b>&nbsp;&nbsp;&nbsp;Revalidated By: </b>" + resultEntryVOGroupByValidatedBy.getRevalidatedBy() +   "</font></div></td></tr>");
                  			}else
                  				headerString.append("<tr><td align='left' colspan='13'><div align='left'  ><font color='black' size='1'><b>Validated By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy()  +    "</font></div></td></tr>");
                     
                      	}
        				
  //<tr><td ><font color='black' size='1'><b> This is computer generated report. Signature not required </b></font></td></tr>
                        
                              				
        				//headerString.append("<tr><td align='right' colspan='6'><div align='left'><font color='black' size='1'><b>" + Config.specialstringatreport + " </b></font></div></td><td align='right' colspan='7'><div align='right'><font color='black' size='1'><b>Entered By: </b>" + resultEntryVOGroupByValidatedBy.getResultEnteredBy() + "</font></div><div align='right'><font color='black' size='2'><b>Validated By: </b>" + resultEntryVOGroupByValidatedBy.getValidatedBy() + "</font></div></td></tr>");
        			
        				headerString.append("<tr><td><font color='black' size='1'><b>" + Config.specialstringatreport + " "
        						+ "</b></font></td></tr>");
        			}
                      
        		
        		
        		}
            //  }
            
        }
        
       
        //headerString.append("<tr><td>" + ". "+ "<br></td></tr>");
        headerString.append(lineString);
        headerString.append("</table></div>");
        //Log(Level.INFO,"getDefaultFooter "+headerString.toString());
        resultEntryVOGroupByValidatedBy.setFooter(headerString.toString());
      //  System.out.println("footerrr:"+headerString);
    }

    private static void Log(Level level, String msg) {
        ServiceLogger.Log(PDFPrintingProcesses.class.getName(), level, msg);
    }

    private static void Log(Level level, Exception e) {
        ServiceLogger.Log(PDFPrintingProcesses.class.getName(), level, e);
    }

}
