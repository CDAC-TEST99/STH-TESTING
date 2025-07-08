/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataProcessing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import javax.sql.rowset.WebRowSet;

import DataHelper.PGDataHelper;
import DataHelper.QueryConfig;
import FileHandler.XMLFileHandler;
import Logging.ServiceLogger;
import TemplateHelper.TriStringObject;
import TemplateHelper.vo.ResultEntryVO;
import TemplateHelper.vo.ResultEntryVOGroupByValidatedBy;
import TemplateHelper.vo.UserVO;
import hisglobal.transactionmgnt.HisDAO;

/*import hisglobal.vo.UserVO;*/
/**
 *
 * @author Siddharth Srivastava <siddharthsrivastava@cdac.in>
 */
public class PGTemplateProcessing {

	 public boolean processingData(String RequisitionNo,String crno, String isDeptEntry, hisglobal.vo.UserVO _userVO) {
	    	
	    	System.out.println("beepXML Nandini ");
        	System.out.println("RequisitionNo>>"+RequisitionNo);
        	System.out.println("crno>>"+crno);
        	System.out.println("isDeptEntry>>"+isDeptEntry);
	        boolean jobprocessContinue = false;
	      
	        Map<String, String> reportingCRNo = new HashMap<String, String>(5);
	        WebRowSet workorderdetailsQueryRC = null;
	        HisDAO daoObj = null;  
	        
	        try {
	        	
	            	
	            System.out.println("XML File1 Creations");
				daoObj = new HisDAO("Cash Collection Transaction", "CashCollectionTransDAO.getClientPatientNumber");

			   int nProcIndex = daoObj.setProcedure(QueryConfig.P_GET_CRNO_XML_JOBS);
			  
	           daoObj.setProcOutValue(nProcIndex, "workorderdetailsqueryrc", 2, 1);
			   daoObj.setProcInValue(nProcIndex, "workorders", RequisitionNo, 2);
			   daoObj.setProcInValue(nProcIndex, "crno", crno, 3);
			   daoObj.setProcInValue(nProcIndex, "isDept", isDeptEntry, 4);
			   daoObj.setProcOutValue(nProcIndex, "errormsg", 1, 5);
			   daoObj.executeProcedureByPosition(nProcIndex);
	        	
			   
			   String err = daoObj.getString(nProcIndex, "errormsg");
			   
			   if( err != null && err.trim().length() > 0) {
				   
				   throw new Exception(err);
			   }
			   
	           String processingCRNo = crno;
	        //    processingworkorder = daoObj.getString(nProcIndex, "workorders");
				  
	           
	            if (processingCRNo != null ) {
	            
	            	System.out.println("xml start  for Crno:"+processingCRNo);
	            	Log(Level.INFO, "xml start for Crno: " + processingCRNo );
	            	//	 Log(Level.INFO, "WorkOrderPrintingJobs processingCRNo:: " + processingCRNo + " processingworkorder ::" + processingworkorder);
	                workorderdetailsQueryRC = daoObj.getWebRowSet(nProcIndex, "workorderdetailsqueryrc"); 

	                if (workorderdetailsQueryRC == null) {
	                	System.out.println("Null Result Set fro crno: "+processingCRNo);
	                    Log(Level.INFO, "Null Result Set fro crno: "+processingCRNo);

	                }
	                List<ResultEntryVOGroupByValidatedBy> entryVOGroupByValidatedBies = new ArrayList<ResultEntryVOGroupByValidatedBy>();
	                resultsetProcessingForGroupingWorkOrder(workorderdetailsQueryRC, entryVOGroupByValidatedBies);

	                  

	                entryVOGroupByValidatedBies = TemplateProcessingUSE.groupSelectedWorkOrders(entryVOGroupByValidatedBies);

	                for (int i = 0; i < entryVOGroupByValidatedBies.size(); i++) {
	                    ResultEntryVOGroupByValidatedBy voGroupByValidatedBy = entryVOGroupByValidatedBies.get(i);

	                    // changed to true 21/05/2015
	                    //boolean isForPrinting = false;
	                    boolean isForPrinting = true;
	                    voGroupByValidatedBy.setIsGroupUpdateble("true");

	                    for (int workorderIndex = 0; workorderIndex < voGroupByValidatedBy.getResultEntryVOListValidatedBy().size(); workorderIndex++) {
	                        ResultEntryVO entryVO = voGroupByValidatedBy.getResultEntryVOListValidatedBy().get(workorderIndex);
	                        entryVO.setIsWorkOrderUpdateble("true");
	                        if (!isForPrinting && entryVO.getUpdateType().equals("2")) {
	                            isForPrinting = true;
	                        }
	                    }

					
					 int labCodeLength = 0; int crNoLength = 0; if (isForPrinting &&
					  !reportingCRNo.containsKey(voGroupByValidatedBy.getPatCRNo() +
					  voGroupByValidatedBy.getLaboratoryCode())) {
					 reportingCRNo.put(voGroupByValidatedBy.getPatCRNo() +
					  voGroupByValidatedBy.getLaboratoryCode(), voGroupByValidatedBy.getPatCRNo() +
					  voGroupByValidatedBy.getLaboratoryCode()); if
					  (voGroupByValidatedBy.getLaboratoryCode() != null) { labCodeLength =
					  voGroupByValidatedBy.getLaboratoryCode().length(); }
					  
					  if (voGroupByValidatedBy.getPatCRNo() != null) { crNoLength =
					  voGroupByValidatedBy.getPatCRNo().length(); } }
					

	                }

	                XMLFileHandler.updatePatientInvestigationFile(entryVOGroupByValidatedBies);

				/*
				 * jobprocessContinue = true; UserVO userVO = new UserVO();
				 * userVO.setHospitalCode("100"); Log(Level.INFO, "reportingCRNo " +
				 * reportingCRNo); if (reportingCRNo != null && reportingCRNo.size() != 0) { //
				 * PGDataHelper.getInstance().processingToPutTheJobs(userVO, reportingCRNo,
				 * null, null, labCodeLength, crNoLength); ///
				 * PGDataHelper.getInstance().processingToPutTheJobs(entryVOGroupByValidatedBies
				 * ); }
				 * 
				 * 
				 * System.out.println("xml end for crno: "+processingCRNo); Log(Level.INFO,
				 * " xml end for crno: "+processingCRNo);
				 */
	            
			} /*
				 * else { jobprocessContinue = false; }
				 */
	            
	
	        } catch (Exception e) {
	            e.printStackTrace();
	           jobprocessContinue = false;
	        } finally {
	            try {
	               
	                if (daoObj != null)
	    			{
	    				daoObj.free();
	    				daoObj = null;
	    			}

	            }catch(Exception e) {
	            	
	            	e.printStackTrace();
	            	
	            } 

	        }

	        return jobprocessContinue;
	    }


    private List<ResultEntryVOGroupByValidatedBy> resultsetProcessingForGroupingWorkOrder(ResultSet rs, List<ResultEntryVOGroupByValidatedBy> workOrderGroupListForresultEntry) {
        ResultEntryVO resultEntryVO = null;
        Map<String, ResultEntryVOGroupByValidatedBy> checkMap = new LinkedHashMap<String, ResultEntryVOGroupByValidatedBy>();
        ResultEntryVOGroupByValidatedBy resultEntryVOGroupByValidatedBy = null;
        try {

            while (rs.next()) {

                if (resultEntryVO == null) {

                    resultEntryVO = new ResultEntryVO(rs.getString("laboratorycode"), rs.getString("testcode"), rs.getString("groupcode"), rs.getString("hospitalcode"), rs.getString("samplecode"));
                    DataHandler.populateVOfrmRS(resultEntryVO, rs);
                    resultEntryVOGroupByValidatedBy = new ResultEntryVOGroupByValidatedBy();
                    DataHandler.populate(resultEntryVOGroupByValidatedBy, resultEntryVO);
                    if (resultEntryVOGroupByValidatedBy.getResultEntryVOListValidatedBy() == null) {
                        resultEntryVOGroupByValidatedBy.setResultEntryVOListValidatedBy(new ArrayList<ResultEntryVO>());
                    }

                    resultEntryVOGroupByValidatedBy.getResultEntryVOListValidatedBy().add(resultEntryVO);
                    workOrderGroupListForresultEntry.add(resultEntryVOGroupByValidatedBy);

                    if (resultEntryVOGroupByValidatedBy.getGroupCode() != null) {
                        checkMap.put(resultEntryVO.getRequisitionNo() + resultEntryVOGroupByValidatedBy.getLaboratoryCode() + resultEntryVOGroupByValidatedBy.getGroupCode(), resultEntryVOGroupByValidatedBy);
                    }

                } else {
                    if (((resultEntryVO.getRequisitionNo()).equals(rs.getString("requisitionNo")) == true) && (resultEntryVO.getLaboratoryCode().equals(rs.getString("laboratoryCode")) == true) && (resultEntryVO.getTestCode().equals(rs.getString("testCode")) == true)) {
                        if (resultEntryVO.getIsTestMultiSession() != null && resultEntryVO.getIsTestMultiSession().equals("1"))// if test is Multi session
                        {
                            //if test is sample re grouped
                            if ((resultEntryVO.getSampleGroupCode() != null) && (resultEntryVO.getSampleGroupCode().equals(rs.getString("sampleGroupCode")) == true)) {
                                if (resultEntryVO.getIsMultiSessionRegrouped().equals("0"))//grouping is not achieved
                                {
                                    if (resultEntryVO.getSessionId().equals(rs.getString("sessionId"))) {
                                        if (resultEntryVO.getAssociatedWorkOrders() == null) {
                                            resultEntryVO.setAssociatedWorkOrders(new ArrayList<TriStringObject>());
                                        }

                                        resultEntryVO.getAssociatedWorkOrders().add(new TriStringObject(rs.getString("requisitionDNo"), rs.getString("sampleNo"), rs.getString("sessionId")));

                                    } else {

                                        //resultEntryVO=new ResultEntryVO(); caching implementation 
                                        resultEntryVO = new ResultEntryVO(rs.getString("laboratoryCode"), rs.getString("testcode"), rs.getString("groupcode"), rs.getString("hospitalcode"), rs.getString("samplecode"));

                                        DataHandler.populateVOfrmRS(resultEntryVO, rs);

                                        if (checkMap.containsKey(resultEntryVO.getRequisitionNo() + resultEntryVO.getLaboratoryCode() + resultEntryVO.getGroupCode())) {
                                            resultEntryVOGroupByValidatedBy = checkMap.get(resultEntryVO.getLaboratoryCode() + resultEntryVO.getGroupCode());
                                        } else {
                                            resultEntryVOGroupByValidatedBy = new ResultEntryVOGroupByValidatedBy();
                                            DataHandler.populate(resultEntryVOGroupByValidatedBy, resultEntryVO);
                                            workOrderGroupListForresultEntry.add(resultEntryVOGroupByValidatedBy);
                                            if (resultEntryVOGroupByValidatedBy.getGroupCode() != null) {
                                                checkMap.put(resultEntryVO.getRequisitionNo() + resultEntryVOGroupByValidatedBy.getLaboratoryCode() + resultEntryVOGroupByValidatedBy.getGroupCode(), resultEntryVOGroupByValidatedBy);
                                            }
                                        }

                                        if (resultEntryVOGroupByValidatedBy.getResultEntryVOListValidatedBy() == null) {
                                            resultEntryVOGroupByValidatedBy.setResultEntryVOListValidatedBy(new ArrayList<ResultEntryVO>());
                                        }

                                        resultEntryVOGroupByValidatedBy.getResultEntryVOListValidatedBy().add(resultEntryVO);

                                    }
                                } else // grouping to be achieved
                                {
                                    if (resultEntryVO.getAssociatedWorkOrders() == null) {
                                        resultEntryVO.setAssociatedWorkOrders(new ArrayList<TriStringObject>());
                                    }

                                    resultEntryVO.getAssociatedWorkOrders().add(new TriStringObject(rs.getString("requisitionDNo"), rs.getString("sampleNo"), rs.getString("sessionId")));

                                }

                            } else// test not raised with sample groupCode
                            {

                                if (resultEntryVO.getIsMultiSessionRegrouped() != null && resultEntryVO.getIsMultiSessionRegrouped().equals("0"))// grouping is not achieved
                                {

                                    //resultEntryVO=new ResultEntryVO(); caching implementation 
                                    resultEntryVO = new ResultEntryVO(rs.getString("laboratoryCode"), rs.getString("testcode"), rs.getString("groupcode"), rs.getString("hospitalcode"), rs.getString("samplecode"));
                                    DataHandler.populateVOfrmRS(resultEntryVO, rs);

                                    if (checkMap.containsKey(resultEntryVO.getRequisitionNo() + resultEntryVO.getLaboratoryCode() + resultEntryVO.getGroupCode())) {
                                        resultEntryVOGroupByValidatedBy = checkMap.get(resultEntryVO.getLaboratoryCode() + resultEntryVO.getGroupCode());
                                    } else {
                                        resultEntryVOGroupByValidatedBy = new ResultEntryVOGroupByValidatedBy();
                                        DataHandler.populate(resultEntryVOGroupByValidatedBy, resultEntryVO);
                                        workOrderGroupListForresultEntry.add(resultEntryVOGroupByValidatedBy);
                                        if (resultEntryVOGroupByValidatedBy.getGroupCode() != null) {
                                            checkMap.put(resultEntryVO.getRequisitionNo() + resultEntryVOGroupByValidatedBy.getLaboratoryCode() + resultEntryVOGroupByValidatedBy.getGroupCode(), resultEntryVOGroupByValidatedBy);
                                        }
                                    }

                                    if (resultEntryVOGroupByValidatedBy.getResultEntryVOListValidatedBy() == null) {
                                        resultEntryVOGroupByValidatedBy.setResultEntryVOListValidatedBy(new ArrayList<ResultEntryVO>());
                                    }

                                    resultEntryVOGroupByValidatedBy.getResultEntryVOListValidatedBy().add(resultEntryVO);

                                } else // grouping to be achieved
                                {
                                    if (resultEntryVO.getAssociatedWorkOrders() == null) {
                                        resultEntryVO.setAssociatedWorkOrders(new ArrayList<TriStringObject>());
                                    }

                                    resultEntryVO.getAssociatedWorkOrders().add(new TriStringObject(rs.getString("requisitionDNo"), rs.getString("sampleNo"), rs.getString("sessionId")));
                                }

                            }

                        } else //Test is not multisessioned
                        {
                            if ((resultEntryVO.getSampleGroupCode() != null) && (resultEntryVO.getSampleGroupCode().equals(rs.getString("sampleGroupCode")) == true)) {
                                if (resultEntryVO.getAssociatedWorkOrders() == null) {
                                    resultEntryVO.setAssociatedWorkOrders(new ArrayList<TriStringObject>());
                                }

                                resultEntryVO.getAssociatedWorkOrders().add(new TriStringObject(rs.getString("requisitionDNo"), rs.getString("sampleNo"), rs.getString("sessionId")));
                            } else {

                                //resultEntryVO=new ResultEntryVO(); caching implementation 
                                resultEntryVO = new ResultEntryVO(rs.getString("laboratoryCode"), rs.getString("testcode"), rs.getString("groupcode"), rs.getString("hospitalcode"), rs.getString("samplecode"));
                                DataHandler.populateVOfrmRS(resultEntryVO, rs);
                                if (checkMap.containsKey(resultEntryVO.getRequisitionNo() + resultEntryVO.getLaboratoryCode() + resultEntryVO.getGroupCode())) {
                                    resultEntryVOGroupByValidatedBy = checkMap.get(resultEntryVO.getRequisitionNo() + resultEntryVO.getLaboratoryCode() + resultEntryVO.getGroupCode());
                                } else {
                                    resultEntryVOGroupByValidatedBy = new ResultEntryVOGroupByValidatedBy();
                                    DataHandler.populate(resultEntryVOGroupByValidatedBy, resultEntryVO);
                                    workOrderGroupListForresultEntry.add(resultEntryVOGroupByValidatedBy);
                                    if (resultEntryVOGroupByValidatedBy.getGroupCode() != null) {
                                        checkMap.put(resultEntryVOGroupByValidatedBy.getRequisitionNo() + resultEntryVOGroupByValidatedBy.getLaboratoryCode() + resultEntryVOGroupByValidatedBy.getGroupCode(), resultEntryVOGroupByValidatedBy);
                                    }
                                }

                                if (resultEntryVOGroupByValidatedBy.getResultEntryVOListValidatedBy() == null) {
                                    resultEntryVOGroupByValidatedBy.setResultEntryVOListValidatedBy(new ArrayList<ResultEntryVO>());
                                }

                                resultEntryVOGroupByValidatedBy.getResultEntryVOListValidatedBy().add(resultEntryVO);

                            }
                        }

                    } else {

                        //resultEntryVO=new ResultEntryVO(); caching implementation 
                        resultEntryVO = new ResultEntryVO(rs.getString("laboratoryCode"), rs.getString("testcode"), rs.getString("groupcode"), rs.getString("hospitalcode"), rs.getString("samplecode"));
                        DataHandler.populateVOfrmRS(resultEntryVO, rs);
                        if (checkMap.containsKey(resultEntryVO.getRequisitionNo() + resultEntryVO.getLaboratoryCode() + resultEntryVO.getGroupCode())) {
                            resultEntryVOGroupByValidatedBy = checkMap.get(resultEntryVO.getRequisitionNo() + resultEntryVO.getLaboratoryCode() + resultEntryVO.getGroupCode());
                        } else {
                            resultEntryVOGroupByValidatedBy = new ResultEntryVOGroupByValidatedBy();
                            DataHandler.populate(resultEntryVOGroupByValidatedBy, resultEntryVO);
                            workOrderGroupListForresultEntry.add(resultEntryVOGroupByValidatedBy);
                            if (resultEntryVOGroupByValidatedBy.getGroupCode() != null) {
                                checkMap.put(resultEntryVOGroupByValidatedBy.getRequisitionNo() + resultEntryVOGroupByValidatedBy.getLaboratoryCode() + resultEntryVOGroupByValidatedBy.getGroupCode(), resultEntryVOGroupByValidatedBy);
                            }
                        }

                        if (resultEntryVOGroupByValidatedBy.getResultEntryVOListValidatedBy() == null) {
                            resultEntryVOGroupByValidatedBy.setResultEntryVOListValidatedBy(new ArrayList<ResultEntryVO>());
                        }

                        resultEntryVOGroupByValidatedBy.getResultEntryVOListValidatedBy().add(resultEntryVO);

                    }

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // LOGGER_INV.log(Level.INFO, "END" + workOrderGroupListForresultEntry.size());
        return workOrderGroupListForresultEntry;
    }

    private void Log(Level level, String msg) {
        ServiceLogger.Log(PGTemplateProcessing.class.getName(), level, msg);
    }



}
