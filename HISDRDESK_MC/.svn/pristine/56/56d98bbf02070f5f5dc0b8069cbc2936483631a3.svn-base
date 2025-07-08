package new_opd.DAO;

import java.lang.reflect.Field;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import hisglobal.exceptions.HisException;
import hisglobal.transactionmgnt.HisDAO;
import new_opd.vo.DoctorDeskVO;
import new_opd.vo.OPDReferralVO;

public class DoctorDeskDAO {

public static void getInitilaData(DoctorDeskVO vo) {
		
		String strproc_name = "{call pkg_opdDrDesk_view_primary.Proc_patient_dtl(?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;
	 

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;
		
		Boolean isDateEqual=false;
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern( "dd MMMM uuuu" );  
		LocalDateTime now = LocalDateTime.now();  
		if(!vo.getStrPrevDate().equalsIgnoreCase("")) {
		   String currDate= dtf.format(now);
		   LocalDate currDt = LocalDate.parse( currDate , dtf );
		   LocalDate prevDt = LocalDate.parse(vo.getStrPrevDate() , dtf );
		   System.out.println("prevDt>>>>" + prevDt);
		   System.out.println("currDate>>>>" + currDate);
		   
		   isDateEqual=currDt.equals(prevDt);
		   if(isDateEqual==false) {
			   strproc_name = "{call pkg_opdDrDesk_view.Proc_patient_dtl(?,?,?,?,?,?,?,?)}";			
		   }
		   
		}
		else {
			String currDate= dtf.format(now);			
			vo.setStrPrevDate(currDate);
			isDateEqual=true;
		}
		System.out.println("vo.getStrPrevDate()>>>>" + vo.getStrPrevDate());
		System.out.println("strproc_name>>>>" + strproc_name);
		

		try {
			 
			dao = new HisDAO("MMS",	"transactions.PODeskGenerateTransDAO.setItemCatValues()");
			//System.out.println("llllll::::"+vo.getStrDeptCode()==null || vo.getStrDeptCode().equals("0") ? "0" :vo.getStrDeptCode());
			nProcIndex = dao.setProcedure(strproc_name);
			String deptCode= null;
			String mode=null;
			if(vo.getIsScriber().equals("0")) {
				System.out.println("isDateEqual>>>>" + isDateEqual);
				System.out.println("vo.getIsSmartQMSEnabled()>>>>" + vo.getIsSmartQMSEnabled());
				if(isDateEqual==false || vo.getIsSmartQMSEnabled().equals("1"))
					mode="1";
				else 
					mode="11";					
				deptCode= vo.getStrDeptCode()==null ||vo.getStrDeptCode().equalsIgnoreCase("") ? "0" :vo.getStrDeptCode().split("#")[1];
			}else {
				mode="10";				
				deptCode= vo.getStrDeptCode()==null ||vo.getStrDeptCode().equalsIgnoreCase("") ? "0" :vo.getStrDeptCode().split("#")[0];
			}
			
			  System.out.println("mode>>>>" + mode);
			  //System.out.println("deptCode>>>>" + deptCode);
			  
			
			dao.setProcInValue(nProcIndex, "modeval", mode,1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id", vo.getStrSeatId()==null ? "0" :vo.getStrSeatId(),3);
			dao.setProcInValue(nProcIndex, "deptCode", deptCode ,4);
			dao.setProcInValue(nProcIndex, "Room_No", vo.getStrDeptCode()==null ||vo.getStrDeptCode().equalsIgnoreCase("")  ? "0" :vo.getStrDeptCode().split("#")[2],5);
			dao.setProcInValue(nProcIndex, "prev_date", vo.getStrPrevDate()==null ||vo.getStrPrevDate().equalsIgnoreCase("")  ? "0" :vo.getStrPrevDate(),6);
			dao.setProcOutValue(nProcIndex, "err", 1,7);
			dao.setProcOutValue(nProcIndex, "resultset", 2,8);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("getInitilaData wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				vo.setStrInitialWb(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			  new HisException("OPD Ver-2.0","DoctorDeskDAO.getInitilaData()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo
					.setStrMsgString("DoctorDeskVO.getInitilaData() --> "
							+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		 
			wsResult = null;
		}
		
	}

public static void getConfigData(DoctorDeskVO vo) {
		
		String strproc_name = "{call pkg_opdDrDesk_view.Proc_patient_dtl(?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		 

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			 
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.setItemCatValues()");
			//System.out.println("llllll::::"+vo.getStrDeptCode()==null || vo.getStrDeptCode().equals("0") ? "0" :vo.getStrDeptCode());
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "3",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id", vo.getStrSeatId()==null ? "0" :vo.getStrSeatId(),3);
			dao.setProcInValue(nProcIndex, "deptCode", vo.getStrDeptCode()==null ||vo.getStrDeptCode().equalsIgnoreCase("") ? "0" :vo.getStrDeptCode().split("#")[1] ,4);
			dao.setProcInValue(nProcIndex, "Room_No", vo.getStrDeptCode()==null ||vo.getStrDeptCode().equalsIgnoreCase("")  ? "0" :vo.getStrDeptCode().split("#")[2],5);
			dao.setProcInValue(nProcIndex, "prev_date", vo.getStrPrevDate()==null ||vo.getStrPrevDate().equalsIgnoreCase("")  ? "0" :vo.getStrPrevDate(),6);
			dao.setProcOutValue(nProcIndex, "err", 1,7);
			dao.setProcOutValue(nProcIndex, "resultset", 2,8);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("getInitilaData wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				vo.setStrOPDConfigWb(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			  new HisException("OPD Ver-2.0","DoctorDeskDAO.getInitilaData()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo
					.setStrMsgString("DoctorDeskVO.getInitilaData() --> "
							+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		 
			wsResult = null;
		}
		
	}

public static void getpatientTeleConsultancyData(DoctorDeskVO vo) {
		
		String strproc_name = "{call pkg_opdDrDesk_view.Proc_patient_dtl(?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		 

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
		 
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.setItemCatValues()");
			//System.out.println("llllll::::"+vo.getStrDeptCode()==null || vo.getStrDeptCode().equals("0") ? "0" :vo.getStrDeptCode());
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id", vo.getStrSeatId()==null ? "0" :vo.getStrSeatId(),3);
			dao.setProcInValue(nProcIndex, "deptCode", vo.getStrDeptCode()==null ||vo.getStrDeptCode().equalsIgnoreCase("") ? "0" :vo.getStrDeptCode().split("#")[1] ,4);
			dao.setProcInValue(nProcIndex, "Room_No", vo.getStrDeptCode()==null ||vo.getStrDeptCode().equalsIgnoreCase("")  ? "0" :vo.getStrDeptCode().split("#")[2],5);
			dao.setProcInValue(nProcIndex, "prev_date", vo.getStrPrevDate()==null ||vo.getStrPrevDate().equalsIgnoreCase("")  ? "0" :vo.getStrPrevDate(),6);
			dao.setProcOutValue(nProcIndex, "err", 1,7);
			dao.setProcOutValue(nProcIndex, "resultset", 2,8);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("getpatientTeleConsultancyData wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				vo.setStrTeleConsultancyDataWb(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			  new HisException("OPD Ver-2.0","DoctorDeskDAO.getInitilaData()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo
					.setStrMsgString("DoctorDeskVO.getInitilaData() --> "
							+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		 
			wsResult = null;
		}
		
	}


public static void getpatientRefferalConsultancyData(DoctorDeskVO vo) {
	
	String strproc_name = "{call pkg_opdDrDesk_view.Proc_patient_dtl(?,?,?,?,?,?,?,?)}";
	HisDAO dao = null;
	 

	int nProcIndex = 0;

	String strErr = "";
	WebRowSet wsResult = null;

	try {
		 
		dao = new HisDAO("MMS",
				"transactions.PODeskGenerateTransDAO.setItemCatValues()");
		//System.out.println("llllll::::"+vo.getStrDeptCode()==null || vo.getStrDeptCode().equals("0") ? "0" :vo.getStrDeptCode());
		nProcIndex = dao.setProcedure(strproc_name);
		dao.setProcInValue(nProcIndex, "modeval", "5",1);
		dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
		dao.setProcInValue(nProcIndex, "seat_id", vo.getStrSeatId()==null ? "0" :vo.getStrSeatId(),3);
		dao.setProcInValue(nProcIndex, "deptCode", vo.getStrDeptCode()==null ||vo.getStrDeptCode().equalsIgnoreCase("") ? "0" :vo.getStrDeptCode().split("#")[1] ,4);
		dao.setProcInValue(nProcIndex, "Room_No", vo.getStrDeptCode()==null ||vo.getStrDeptCode().equalsIgnoreCase("")  ? "0" :vo.getStrDeptCode().split("#")[2],5);
		dao.setProcInValue(nProcIndex, "prev_date", vo.getStrPrevDate()==null ||vo.getStrPrevDate().equalsIgnoreCase("")  ? "0" :vo.getStrPrevDate(),6);
		dao.setProcOutValue(nProcIndex, "err", 1,7);
		dao.setProcOutValue(nProcIndex, "resultset", 2,8);
		dao.executeProcedureByPosition(nProcIndex);

		strErr = dao.getString(nProcIndex, "err");

		wsResult = dao.getWebRowSet(nProcIndex, "resultset");
		//System.out.println("getpatientTeleConsultancyData wsResult::::::::::::"+wsResult.size());
		if (strErr == null || strErr.equals(""))
			vo.setStrRefeConsultancyDataWb(wsResult);
		else
			throw new Exception(strErr);
	} catch (Exception _Err) {
	  new HisException("OPD Ver-2.0","DoctorDeskDAO.getInitilaData()-->", _Err.getMessage() + "-->" + _Err);
		_Err.printStackTrace();
		vo
				.setStrMsgString("DoctorDeskVO.getInitilaData() --> "
						+ _Err.getMessage());
		vo.setStrMsgType("1");
	} finally {
		if (dao != null) {
			dao.free();
			dao = null;
		}
		 
		wsResult = null;
	}
	
}

	public static void getInvestogation(DoctorDeskVO vo) {
		String strproc_name = "{call pkg_opdDrDesk_view.proc_invtest_dtl(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
	 

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
		 
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.setItemCatValues()");
			
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id", vo.getStrSeatId()==null ? "0" :vo.getStrSeatId(),3);
			dao.setProcInValue(nProcIndex, "deptCode", vo.getStrDeptCode()==null ? "0" :vo.getStrDeptCode() ,4);
			dao.setProcInValue(nProcIndex, "Room_No", vo.getStrRoomCode()==null ? "0" : vo.getStrRoomCode(),5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("getInvestogation wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				vo.setStrTestWb(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
		  new HisException("OPD Ver-2.0","DoctorDeskDAO.getInvestogation()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo
					.setStrMsgString("DoctorDeskVO.getInvestogation() --> "
							+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			 
			wsResult = null;
		}
		
	}
	
	public static void getdrugdtl(DoctorDeskVO vo) {
		String strproc_name = "{call pkg_opdDrDesk_view.proc_drug_dtl(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
	 

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
		 
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.setItemCatValues()");
			
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id",  vo.getStrSeatId()==null ? "0" :vo.getStrSeatId(),3);
			dao.setProcInValue(nProcIndex, "deptCode", "",4);
			dao.setProcInValue(nProcIndex, "Room_No", "",5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("getdrugdtl wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				vo.setStrDrugWb(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			  new HisException("OPD Ver-2.0","DoctorDeskDAO.getdrugdtl()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo
					.setStrMsgString("DoctorDeskVO.getdrugdtl() --> "
							+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			 
			wsResult = null;
		}
		
	}

	public static void getdrug_dosage_dtl(DoctorDeskVO vo) {
		String strproc_name = "{call pkg_opdDrDesk_view.proc_dosage_dtl(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
	 

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
		 
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.setItemCatValues()");
			
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id",  vo.getStrSeatId()==null ? "0" :vo.getStrSeatId(),3);
			dao.setProcInValue(nProcIndex, "deptCode", vo.getHospitalType(),4);
			dao.setProcInValue(nProcIndex, "Room_No", "",5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("getdrug_dosage_dtl wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				vo.setStrDosageWb(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
		  new HisException("OPD Ver-2.0","DoctorDeskDAO.getdrug_dosage_dtl()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo
					.setStrMsgString("DoctorDeskVO.getdrug_dosage_dtl() --> "
							+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		 
			wsResult = null;
		}
		
	}
	
	
	public static void getMacrosDtl(DoctorDeskVO vo) {
		String strproc_name = "{call pkg_opdDrDesk_view.proc_macros_dtl(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
	 

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			 
			dao = new HisDAO("MMS",
					"transactions.DoctorDeskDAO..setItemCatValues()");
			
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id",  vo.getStrSeatId()==null ? "0" :vo.getStrSeatId(),3);
			dao.setProcInValue(nProcIndex, "deptCode", "",4);
			dao.setProcInValue(nProcIndex, "Room_No", "",5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("getMacrosDtl wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				vo.setStrMacrosWb(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
		  new HisException("OPD Ver-2.0","DoctorDeskDAO.getMacrosDtl()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo
					.setStrMsgString("DoctorDeskVO.getMacrosDtl() --> "
							+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		 
			wsResult = null;
		}
		
	}
	
	public static void getClinicalProcedureDtls(DoctorDeskVO vo) {
		String strproc_name = "{call pkg_opdDrDesk_view.proc_macros_dtl(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
	 

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
		 
			dao = new HisDAO("MMS",
					"transactions.DoctorDeskDAO..setItemCatValues()");
			
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id",  vo.getStrSeatId()==null ? "0" :vo.getStrSeatId(),3);
			dao.setProcInValue(nProcIndex, "deptCode", "",4);
			dao.setProcInValue(nProcIndex, "Room_No", "",5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("getMacrosDtl wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				vo.setStrCinicalProcudreWb(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
		 new HisException("OPD Ver-2.0","DoctorDeskDAO.getClinicalProcedureDtls()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo
					.setStrMsgString("DoctorDeskVO.getMacrosDtl() --> "
							+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		 
			wsResult = null;
		}
		
	}
	
	public static void getDeptDtl(DoctorDeskVO vo,HttpServletRequest request) {
		String strproc_name = "{call pkg_opdDrDesk_view.proc_dept_dtl(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
	 

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
		 
			dao = new HisDAO("MMS",
					"transactions.DoctorDeskDAO..setItemCatValues()");
			
			nProcIndex = dao.setProcedure(strproc_name);
			if(vo.getIsScriber().equals("0")) {
				dao.setProcInValue(nProcIndex, "modeval", "1",1);
			}else {
				dao.setProcInValue(nProcIndex, "modeval", "9",1);
			}
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id",  vo.getStrSeatId()==null ? "0" :vo.getStrSeatId(),3);
			dao.setProcInValue(nProcIndex, "deptCode", "",4);
			dao.setProcInValue(nProcIndex, "Room_No", "",5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			
			//System.out.println("getDeptDtl wsResult::::::::::::"+wsResult.size());
			 
			if (strErr == null || strErr.equals(""))
			{
				wsResult = dao.getWebRowSet(nProcIndex, "resultset");
				vo.setStrDeptWb(wsResult);
				if(vo.getStrDeptUnitCode()==null || vo.getStrDeptUnitCode().equals("")){
				if(wsResult.first()){
					vo.setStrHiddenDeptCode(wsResult.getString(1));
				}
				wsResult.beforeFirst();
				}
			}
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
		  new HisException("OPD Ver-2.0","DoctorDeskDAO.getClinicalProcedureDtls()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo
					.setStrMsgString("DoctorDeskVO.getDeptDtl() --> "
							+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		 
			wsResult = null;
		}
		
	}
	public static void getHospitalHeaderName(DoctorDeskVO vo) {
		String strproc_name = "{call pkg_opdDrDesk_view.proc_dept_dtl(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
	 

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
		 
			dao = new HisDAO("MMS",
					"transactions.DoctorDeskDAO..setItemCatValues()");
			
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "8",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id",  vo.getStrSeatId()==null ? "0" :vo.getStrSeatId(),3);
			dao.setProcInValue(nProcIndex, "deptCode", "",4);
			dao.setProcInValue(nProcIndex, "Room_No", "",5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("getDeptDtl wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
			{
				vo.setStrHospitalHeaderWs(wsResult);
				
			}
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
		  new HisException("OPD Ver-2.0","DoctorDeskDAO.getClinicalProcedureDtls()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo
					.setStrMsgString("DoctorDeskVO.getDeptDtl() --> "
							+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
	 
			wsResult = null;
		}
		
	}

	public static void getRefferalDeptDtl(DoctorDeskVO vo) {
		String strproc_name = "{call pkg_opdDrDesk_view.proc_dept_dtl(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {		
			dao = new HisDAO("MMS",	"transactions.DoctorDeskDAO..setItemCatValues()");
			
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id",  vo.getStrSeatId()==null ? "0" :vo.getStrSeatId(),3);
			dao.setProcInValue(nProcIndex, "deptCode", vo.getStrDeptCode(),4);
			dao.setProcInValue(nProcIndex, "Room_No", "",5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("getDeptDtl wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				vo.setStrRefferalDeptWb(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			 new HisException("OPD Ver-2.0","DoctorDeskDAO.getRefferalDeptDtl()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo.setStrMsgString("DoctorDeskVO.getDeptDtl() --> "+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			
			wsResult = null;
		}
		
	}
	public static void getBookMarksTestDtl(DoctorDeskVO vo) {
		String strproc_name = "{call pkg_opdDrDesk_view.proc_Bookmarks_test_dtl(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			
					
			dao = new HisDAO("MMS",
					"transactions.DoctorDeskDAO..setItemCatValues()");
			
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id",  vo.getStrSeatId()==null ? "0" :vo.getStrSeatId(),3);
			dao.setProcInValue(nProcIndex, "deptCode", "",4);
			dao.setProcInValue(nProcIndex, "Room_No", "",5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("getBookMarksTestDtl wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				vo.setStrBookMarksTestWb(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			 new HisException("OPD Ver-2.0","DoctorDeskDAO.getBookMarksTestDtl()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo
					.setStrMsgString("DoctorDeskVO.getBookMarksTestDtl() --> "
							+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			
			wsResult = null;
		}
		
	}
	
	
	
	public static void getGroupTestDtl(DoctorDeskVO vo) {
		String strproc_name = "{call pkg_opdDrDesk_view.proc_Bookmarks_test_dtl(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			
					
			dao = new HisDAO("MMS",
					"transactions.DoctorDeskDAO..setItemCatValues()");
			
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id",  vo.getStrSeatId()==null ? "0" :vo.getStrSeatId(),3);
			dao.setProcInValue(nProcIndex, "deptCode", "",4);
			dao.setProcInValue(nProcIndex, "Room_No", "",5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("getGroupTestDtl wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				vo.setStrGroupTestWb(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			 new HisException("OPD Ver-2.0","DoctorDeskDAO.getGroupTestDtl()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo
					.setStrMsgString("DoctorDeskVO.getGroupTestDtl() --> "
							+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			
			wsResult = null;
		}
		
	}


	public static String getPrevData(DoctorDeskVO vo) {
		String err = "";
    	String proc_name1 = "{call pkg_opddrdesk_view.proc_prev_dtl(?,?,?,?, ?,?,?,?)}";
        int nProcIndex = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
       
         
       
        
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
            dao = new HisDAO("WebServices", "HospotalMgmtDao.getHospitalMgmtData()");
            nProcIndex = dao.setProcedure(proc_name1);
            dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id",  "",3);
			dao.setProcInValue(nProcIndex, "deptCode", "",4);
			dao.setProcInValue(nProcIndex, "episodecode", vo.getStrEpisodeCode(),5);
			dao.setProcInValue(nProcIndex, "puk", vo.getStrPuk(),6);
			dao.setProcOutValue(nProcIndex, "err", 1,7);
			dao.setProcOutValue(nProcIndex, "resultset", 2,8);
			dao.executeProcedureByPosition(nProcIndex);
            err=dao.getString(nProcIndex, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(nProcIndex, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
              while (ws.next()) {
            	  
                 
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		js.put(key, value);
                		
                	}
                	jsonolist.add(js) ;               	
                	
                }
              }
          if(ws != null){
        		ws.close();
        		ws = null;
        	}        
            vo.setStrDrugPrevCodeJSON(jsonolist);
            //System.out.println("jsonolist.toString()DRUG"+jsonolist.toString());
            return jsonolist.toString();
        }
        catch (Exception e) {
        	 new HisException("OPD Ver-2.0","DoctorDeskDAO.getPrevData()-->", e.getMessage() + "-->" + e);
        	vo.setStrMsgType("1");
            e.printStackTrace();
            return jsonolist.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
	}
	public static String getInventoryDrugPrevData(DoctorDeskVO vo) {
		String err = "";
    	String proc_name1 = "{call pkg_opddrdesk_view.proc_prev_dtl(?,?,?,?, ?,?,?,?)}";
        int nProcIndex = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
       
          
        
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
            dao = new HisDAO("WebServices", "HospotalMgmtDao.getHospitalMgmtData()");
            nProcIndex = dao.setProcedure(proc_name1);
            dao.setProcInValue(nProcIndex, "modeval", "13",1);
			dao.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id",  "",3);
			dao.setProcInValue(nProcIndex, "deptCode", "",4);
			dao.setProcInValue(nProcIndex, "episodecode", vo.getStrEpisodeCode(),5);
			dao.setProcInValue(nProcIndex, "puk", vo.getStrPuk(),6);
			dao.setProcOutValue(nProcIndex, "err", 1,7);
			dao.setProcOutValue(nProcIndex, "resultset", 2,8);
			dao.executeProcedureByPosition(nProcIndex);
            err=dao.getString(nProcIndex, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(nProcIndex, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
              while (ws.next()) {
            	 
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		js.put(key, value);
                		
                	}
                	jsonolist.add(js) ;               	
                	
                }
              }
          if(ws != null){
        		ws.close();
        		ws = null;
        	}        
            vo.setStrInvDrugPrevCodeJSON(jsonolist);
            //System.out.println("jsonolist.toString()InvDrugPrevCode==>"+jsonolist.toString());
            return jsonolist.toString();
        }
        catch (Exception e) {
        	 new HisException("OPD Ver-2.0","DoctorDeskDAO.getPrevData()-->", e.getMessage() + "-->" + e);
        	vo.setStrMsgType("1");
            e.printStackTrace();
            return jsonolist.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
	}
	public static String getPrevvisitresonData(DoctorDeskVO vo) {
		String err = "";
    	String proc_name1 = "{call pkg_opddrdesk_view.proc_prev_dtl(?,?,?,?, ?,?,?,?)}";
        int nProcIndex = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        
        
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
            dao = new HisDAO("WebServices", "HospotalMgmtDao.getHospitalMgmtData()");
            nProcIndex = dao.setProcedure(proc_name1);
            dao.setProcInValue(nProcIndex, "modeval", "7",1);
			dao.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id",  "",3);
			dao.setProcInValue(nProcIndex, "deptCode", "",4);
			dao.setProcInValue(nProcIndex, "episodecode", vo.getStrEpisodeCode(),5);
			dao.setProcInValue(nProcIndex, "puk", vo.getStrPuk(),6);
			dao.setProcOutValue(nProcIndex, "err", 1,7);
			dao.setProcOutValue(nProcIndex, "resultset", 2,8);
			dao.executeProcedureByPosition(nProcIndex);
            err=dao.getString(nProcIndex, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(nProcIndex, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
              while (ws.next()) {
            	 
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		js.put(key, value);
                		
                	}
                	jsonolist.add(js) ;               	
                	
                }
              }
          if(ws != null){
        		ws.close();
        		ws = null;
        	}        
            vo.setStrVisitReasonJSON(jsonolist);
            //System.out.println("jsonolist.toString()DRUG"+jsonolist.toString());
            return jsonolist.toString();
        }
        catch (Exception e) {
        	 new HisException("OPD Ver-2.0","DoctorDeskDAO.getPrevData()-->", e.getMessage() + "-->" + e);
        	vo.setStrMsgType("1");
            e.printStackTrace();
            return jsonolist.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
	}
	
	public static String getPatReferredData(DoctorDeskVO vo) {
		String err = "";
    	String proc_name1 = "{call pkg_opddrdesk_view.proc_prev_dtl(?,?,?,?, ?,?,?,?)}";
        int nProcIndex = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
         
       
        
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
            dao = new HisDAO("WebServices", "HospotalMgmtDao.getHospitalMgmtData()");
            nProcIndex = dao.setProcedure(proc_name1);
            dao.setProcInValue(nProcIndex, "modeval", "9",1);
			dao.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id",  "",3);
			dao.setProcInValue(nProcIndex, "deptCode", "",4);
			dao.setProcInValue(nProcIndex, "episodecode", vo.getStrEpisodeCode(),5);
			dao.setProcInValue(nProcIndex, "puk", vo.getStrPuk(),6);
			dao.setProcOutValue(nProcIndex, "err", 1,7);
			dao.setProcOutValue(nProcIndex, "resultset", 2,8);
			dao.executeProcedureByPosition(nProcIndex);
            err=dao.getString(nProcIndex, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(nProcIndex, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
              while (ws.next()) {
            	  //int j=0;
                 
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		if(value == null) 
                			value = "";
                		js.put(key, value);
                		
                	} 
                	jsonolist.add(js) ;               	
                	
                }
              }
          if(ws != null){
        		ws.close();
        		ws = null;
        	}        
            vo.setStrPatRefferalDtls(jsonolist);
            //System.out.println("jsonolist.toString()getLastThreePatientVisitData"+jsonolist.toString().replaceAll("\\\\", ""));
            return jsonolist.toString();
        }
        catch (Exception e) {
        	 new HisException("OPD Ver-2.0","DoctorDeskDAO.getPatReferredData()-->", e.getMessage() + "-->" + e);
        	vo.setStrMsgType("1");
            e.printStackTrace();
            return jsonolist.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
	}
	
	
	public static String getLastThreePatientVisitData(DoctorDeskVO vo) {
		String err = "";
	 
    	String proc_name1 = "{call pkg_opddrdesk_view.proc_prev_dtl(?,?,?,?, ?,?,?,?)}";
        int nProcIndex = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
         
        
        String hosp_code=vo.getStrHospitalCode();
        String episodecode=vo.getStrEpisodeCode();
       // String deptCode=vo.getStrDeptCode();
        String modeval = "8";
        String fromHospCode = "";
       // System.out.println("deptCode : "+deptCode);
        
        if(vo.getStrPatRefferalDtls() != null && vo.getStrPatRefferalDtls().size() > 0) {
        	try {
				hosp_code = vo.getStrPatRefferalDtls().get(0).getString("GNUM_HOSPITAL_CODE");
				episodecode = vo.getStrPatRefferalDtls().get(0).getString("HRGNUM_EPISODE_CODE");
				fromHospCode = vo.getStrPatRefferalDtls().get(0).getString("HRGNUM_EXT_HOSPITAL_CODE");//hrgnum_ext_hospital_code
				
				if(fromHospCode != null && !fromHospCode.equals("") && !fromHospCode.equals(hosp_code))
					modeval = "10";
								
			} catch (JSONException e) {
				e.printStackTrace();
			}
        	
        }
        
        
        
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
            dao = new HisDAO("WebServices", "HospotalMgmtDao.getHospitalMgmtData()");
            nProcIndex = dao.setProcedure(proc_name1);
            dao.setProcInValue(nProcIndex, "modeval", modeval,1);
			dao.setProcInValue(nProcIndex, "hosp_code",hosp_code,2);
			dao.setProcInValue(nProcIndex, "seat_id",  "",3);
			dao.setProcInValue(nProcIndex, "deptCode", vo.getStrDeptCode()==null ||vo.getStrDeptCode().equalsIgnoreCase("") ? "0" :vo.getStrDeptCode() ,4);
			dao.setProcInValue(nProcIndex, "episodecode", episodecode,5);
			dao.setProcInValue(nProcIndex, "puk", vo.getStrPuk(),6);
			dao.setProcOutValue(nProcIndex, "err", 1,7);
			dao.setProcOutValue(nProcIndex, "resultset", 2,8);
			dao.executeProcedureByPosition(nProcIndex);
            err=dao.getString(nProcIndex, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(nProcIndex, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
              while (ws.next()) {
            	  //int j=0;
                	 
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		js.put(key, value);
                		
                	} 
                	jsonolist.add(js) ;               	
                	
                }
              }
          if(ws != null){
        		ws.close();
        		ws = null;
        	}        
            vo.setStrLastThreeVisit(jsonolist);
            //System.out.println("jsonolist.toString()getLastThreePatientVisitData"+jsonolist.toString().replaceAll("\\\\", ""));
            return jsonolist.toString();
        }
        catch (Exception e) {
        	 new HisException("OPD Ver-2.0","DoctorDeskDAO.getLastThreePatientVisitData()-->", e.getMessage() + "-->" + e);
        	vo.setStrMsgType("1");
            e.printStackTrace();
            return jsonolist.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
	}
	
	
	public static String getPrevDataInv(DoctorDeskVO vo) {
		String err = "";
    	String proc_name1 = "{call pkg_opddrdesk_view.proc_prev_dtl(?,?,?,?, ?,?,?,?)}";
        int nProcIndex = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
       
         
        
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
            dao = new HisDAO("WebServices", "HospotalMgmtDao.getHospitalMgmtData()");
            nProcIndex = dao.setProcedure(proc_name1);
            dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id", "",3);
			dao.setProcInValue(nProcIndex, "deptCode", "",4);
			dao.setProcInValue(nProcIndex, "episodecode", vo.getStrEpisodeCode(),5);
			dao.setProcInValue(nProcIndex, "puk", vo.getStrPuk(),6);
			dao.setProcOutValue(nProcIndex, "err", 1,7);
			dao.setProcOutValue(nProcIndex, "resultset", 2,8);
			dao.executeProcedureByPosition(nProcIndex);
            err=dao.getString(nProcIndex, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(nProcIndex, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
              while (ws.next()) {
            	  
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		js.put(key, value);
                		
                	}
                	jsonolist.add(js) ;               	
                	
                }
              }
          if(ws != null){
        		ws.close();
        		ws = null;
        	}   
            vo.setStrInvPrevCodeJSON(jsonolist);
            //System.out.println("jsonolist.toString()INV"+jsonolist.toString());
            return jsonolist.toString();
        }
        catch (Exception e) {
        	 new HisException("OPD Ver-2.0","getPrevDataInv.getPrevData()-->", e.getMessage() + "-->" + e);
        	vo.setStrMsgType("1");
            e.printStackTrace();
            return jsonolist.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
	}
	
	public static String getPrevVisitReason(DoctorDeskVO vo) {
		String err = "";
    	String proc_name1 = "{call pkg_opddrdesk_view.proc_prev_dtl(?,?,?,?, ?,?,?,?)}";
        int nProcIndex = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        
        
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
            dao = new HisDAO("WebServices", "HospotalMgmtDao.getHospitalMgmtData()");
            nProcIndex = dao.setProcedure(proc_name1);
            dao.setProcInValue(nProcIndex, "modeval", "3",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id", vo.getStrVistNo(),3);
			dao.setProcInValue(nProcIndex, "deptCode", "",4);
			dao.setProcInValue(nProcIndex, "episodecode", vo.getStrEpisodeCode(),5);
			dao.setProcInValue(nProcIndex, "puk", vo.getStrPuk(),6);
			dao.setProcOutValue(nProcIndex, "err", 1,7);
			dao.setProcOutValue(nProcIndex, "resultset", 2,8);
			dao.executeProcedureByPosition(nProcIndex);
            err=dao.getString(nProcIndex, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(nProcIndex, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
              while (ws.next()) {
            	    
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		if(key.equalsIgnoreCase("HRSTR_JSON_DATA")) //hrstr_json_data
                		{
                			
                			JSONParser parser = new JSONParser();
                    		org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
                    		js.put(key, json);
                		}else {
                			js.put(key, value);
                		}
                	}
                	jsonolist.add(js) ;               	
                	
                }
              }
          if(ws != null){
        		ws.close();
        		ws = null;
        	}   
            vo.setStrInvPrevVistReasonJSON(jsonolist);
            //System.out.println("jsonolist.toString()INV"+jsonolist.toString());
            return jsonolist.toString();
        }
        catch (Exception e) {
        	 new HisException("OPD Ver-2.0","getPrevDataInv.getPrevDiagnosisDtl()-->", e.getMessage() + "-->" + e);
        	vo.setStrMsgType("1");
            e.printStackTrace();
            return jsonolist.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
	}
	
	
	public static String getPrevDiagnosisDtl(DoctorDeskVO vo) {
		String err = "";
    	String proc_name1 = "{call pkg_opddrdesk_view.proc_prev_dtl(?,?,?,?, ?,?,?,?)}";
        int nProcIndex = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
       
          
        
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
            dao = new HisDAO("WebServices", "HospotalMgmtDao.getHospitalMgmtData()");
            nProcIndex = dao.setProcedure(proc_name1);
            dao.setProcInValue(nProcIndex, "modeval", "4",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id", "",3);
			dao.setProcInValue(nProcIndex, "deptCode", "",4);
			dao.setProcInValue(nProcIndex, "episodecode", vo.getStrEpisodeCode(),5);
			dao.setProcInValue(nProcIndex, "puk", vo.getStrPuk(),6);
			dao.setProcOutValue(nProcIndex, "err", 1,7);
			dao.setProcOutValue(nProcIndex, "resultset", 2,8);
			dao.executeProcedureByPosition(nProcIndex);
            err=dao.getString(nProcIndex, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(nProcIndex, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
              while (ws.next()) {
            	  
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		if(key.equalsIgnoreCase("HRSTR_JSON_DATA")) //hrstr_json_data
                		{
                			
                			JSONParser parser = new JSONParser();
                    		org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
                    		js.put(key, json);
                		}else {
                			js.put(key, value);
                		}
                		
                		
                		
                		
                		
                		
                	}
                	jsonolist.add(js) ;               	
                	
                }
              }
          if(ws != null){
        		ws.close();
        		ws = null;
        	}   
            vo.setStrInvPrevDiagnosisJSON(jsonolist);
            //System.out.println("jsonolist.toString()INV"+jsonolist.toString());
            return jsonolist.toString();
        }
        catch (Exception e) {
        	
        	 new HisException("OPD Ver-2.0","getPrevDataInv.getPrevVisitReason()-->", e.getMessage() + "-->" + e);
        	vo.setStrMsgType("1");
            e.printStackTrace();
            return jsonolist.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
	}

	
	
	public static void getDIAGNOSISDtl(DoctorDeskVO vo) {


		String strproc_name = "{call pkg_opdDrDesk_view.proc_invtest_dtl(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			
					
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.setItemCatValues()");
			
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id", vo.getStrSeatId()==null ? "0" :vo.getStrSeatId(),3);
			dao.setProcInValue(nProcIndex, "deptCode", vo.getStrDeptCode()==null ? "0" :vo.getStrDeptCode() ,4);
			dao.setProcInValue(nProcIndex, "Room_No", vo.getStrRoomCode()==null ? "0" : vo.getStrRoomCode(),5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("getDIAGNOSISDtl wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				vo.setStrDiagnosisWb(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			 new HisException("OPD Ver-2.0","getPrevDataInv.getPrevDiagnosisDtl()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo
					.setStrMsgString("DoctorDeskVO.getDIAGNOSISDtl() --> "
							+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			
			wsResult = null;
		}
		
	}
	
	public static String getPrevVitalforeTeleConsultancy(DoctorDeskVO vo) {
		String err = "";
    	String proc_name1 = "{call pkg_opddrdesk_view.proc_prev_dtl(?,?,?,?, ?,?,?,?)}";
        int nProcIndex = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
       
          
        
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
            dao = new HisDAO("WebServices", "HospotalMgmtDao.getHospitalMgmtData()");
            nProcIndex = dao.setProcedure(proc_name1);
            dao.setProcInValue(nProcIndex, "modeval", "6",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id", vo.getStrVistNo(),3); // Heare Seat Id Visit No
			dao.setProcInValue(nProcIndex, "deptCode", vo.getStreTeleconsultancyReqId(),4);  // here teleconsultancy use as request id
			dao.setProcInValue(nProcIndex, "episodecode", vo.getStrEpisodeCode(),5);
			dao.setProcInValue(nProcIndex, "puk", vo.getStrPuk(),6);
			dao.setProcOutValue(nProcIndex, "err", 1,7);
			dao.setProcOutValue(nProcIndex, "resultset", 2,8);
			dao.executeProcedureByPosition(nProcIndex);
            err=dao.getString(nProcIndex, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(nProcIndex, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
              while (ws.next()) {
            	 
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		js.put(key, value);
                		
                	}
                	jsonolist.add(js) ;               	
                	
                }
              }
          if(ws != null){
        		ws.close();
        		ws = null;
        	}   
            vo.setStrEtelePreVitalJSON(jsonolist);
            //System.out.println("jsonolist.toString()INV"+jsonolist.toString());
            return jsonolist.toString();
        }
        catch (Exception e) {
        	 new HisException("OPD Ver-2.0","getPrevDataInv.getPrevDiagnosisDtl()-->", e.getMessage() + "-->" + e);
        	vo.setStrMsgType("1");
            e.printStackTrace();
            return jsonolist.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
	}

	public static String getPrevVitalDtls(DoctorDeskVO vo) {
		String err = "";
    	String proc_name1 = "{call pkg_opddrdesk_view.proc_prev_dtl(?,?,?,?, ?,?,?,?)}";
        int nProcIndex = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
       
          
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
            dao = new HisDAO("WebServices", "HospotalMgmtDao.getHospitalMgmtData()");
            nProcIndex = dao.setProcedure(proc_name1);
            dao.setProcInValue(nProcIndex, "modeval", "5",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id", vo.getStrVistNo(),3); // Heare Seat Id Visit No
			dao.setProcInValue(nProcIndex, "deptCode", "",4);
			dao.setProcInValue(nProcIndex, "episodecode", vo.getStrEpisodeCode(),5);
			dao.setProcInValue(nProcIndex, "puk", vo.getStrPuk(),6);
			dao.setProcOutValue(nProcIndex, "err", 1,7);
			dao.setProcOutValue(nProcIndex, "resultset", 2,8);
			dao.executeProcedureByPosition(nProcIndex);
            err=dao.getString(nProcIndex, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(nProcIndex, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
              while (ws.next()) {
            	 
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		js.put(key, value);
                		
                	}
                	jsonolist.add(js) ;               	
                	
                }
              }
          if(ws != null){
        		ws.close();
        		ws = null;
        	}   
            vo.setStrPreVitalJSON(jsonolist);
            //System.out.println("jsonolist.toString()INV"+jsonolist.toString());
            return jsonolist.toString();
        }
        catch (Exception e) {
        	 new HisException("OPD Ver-2.0","getPrevDataInv.getPrevDiagnosisDtl()-->", e.getMessage() + "-->" + e);
        	vo.setStrMsgType("1");
            e.printStackTrace();
            return jsonolist.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
	}

	public static void getDrugProfileDtl(DoctorDeskVO vo) {


		String strproc_name = "{call pkg_opdDrDesk_view.proc_invtest_dtl(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			
					
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.getDrugProfileDtl()");
			
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "3",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id", vo.getStrSeatId()==null ? "0" :vo.getStrSeatId(),3);
			dao.setProcInValue(nProcIndex, "deptCode", vo.getStrDeptCode()==null ||vo.getStrDeptCode().equalsIgnoreCase("") ? "0" :vo.getStrDeptCode().split("#")[1] ,4);
			dao.setProcInValue(nProcIndex, "Room_No", vo.getStrRoomCode()==null ? "0" : vo.getStrRoomCode(),5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("getDrugProfileDtl wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				vo.setStrDrugProfileWs(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			 new HisException("OPD Ver-2.0","getPrevDataInv.getPrevDiagnosisDtl()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo
					.setStrMsgString("DoctorDeskVO.getDrugProfileDtl() --> "
							+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			
			wsResult = null;
		}
		
		
	}
	
	public static void getTemplateName(DoctorDeskVO vo) {


		String strproc_name = "{call pkg_opdDrDesk_view.proc_template_dtl(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			
					
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.getDrugProfileDtl()");
			
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id", vo.getStrSeatId()==null ? "0" :vo.getStrSeatId(),3);
			dao.setProcInValue(nProcIndex, "deptCode", vo.getStrDeptCode()==null ||vo.getStrDeptCode().equalsIgnoreCase("") ? "0" :vo.getStrDeptCode().split("#")[1] ,4);
			dao.setProcInValue(nProcIndex, "Room_No", vo.getStrRoomCode()==null ? "0" : vo.getStrRoomCode(),5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("getDrugProfileDtl wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				vo.setStrDrugProfileWs(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			 new HisException("OPD Ver-2.0","getPrevDataInv.getTemplateName()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo
					.setStrMsgString("DoctorDeskVO.getDrugProfileDtl() --> "
							+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			
			wsResult = null;
		}
		
		
	}
	public static void getTemplateDtl(DoctorDeskVO vo) {
		
		String strproc_name = "{call pkg_opdDrDesk_view.proc_template_dtl(?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			
					
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.setItemCatValues()");
			//System.out.println("llllll::::"+vo.getStrDeptCode()==null || vo.getStrDeptCode().equals("0") ? "0" :vo.getStrDeptCode());
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id", vo.getStrSeatId()==null ? "0" :vo.getStrSeatId(),3);
			dao.setProcInValue(nProcIndex, "deptCode", vo.getStrDeptCode()==null ||vo.getStrDeptCode().equalsIgnoreCase("") ? "0" :vo.getStrDeptCode().split("#")[1] ,4);
			dao.setProcInValue(nProcIndex, "Room_No", vo.getStrDeptCode()==null ||vo.getStrDeptCode().equalsIgnoreCase("")  ? "0" :vo.getStrDeptCode().split("#")[2],5);
			dao.setProcInValue(nProcIndex, "prev_date", vo.getStrPrevDate()==null ||vo.getStrPrevDate().equalsIgnoreCase("")  ? "0" :vo.getStrPrevDate(),6);
			dao.setProcOutValue(nProcIndex, "err", 1,7);
			dao.setProcOutValue(nProcIndex, "resultset", 2,8);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("Get Template Data wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				vo.setStrTemplateWebRowSet(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			 new HisException("OPD Ver-2.0","getPrevDataInv.getTemplateDtl()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo.setStrMsgString("getTemplateDtl.getTemplateDtl() --> "+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			
			wsResult = null;
		}
		
	}

	public static void getPresriptionProfileDtl(DoctorDeskVO vo) {


		String strproc_name = "{call pkg_opdDrDesk_view.proc_invtest_dtl(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet ws = null;
	 
        
        JSONArray jsonArray = new JSONArray();
       
        ArrayList<String> columnlist = new ArrayList<String>();
        ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
        int length=0;
       
		try {
			
					
			dao = new HisDAO("MMS",
					"transactions.PODeskGenerateTransDAO.getDrugProfileDtl()");
			
			nProcIndex = dao.setProcedure(strproc_name);
			if(vo.getStrMode() != null && !vo.getStrMode().equalsIgnoreCase("") && vo.getStrMode().equalsIgnoreCase("PRESCRIPTIONBOOKMARKING"))
				dao.setProcInValue(nProcIndex, "modeval", "5",1);
			else{
				dao.setProcInValue(nProcIndex, "modeval", "4",1);
			}
			//dao.setProcInValue(nProcIndex, "modeval", "4",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id", vo.getStrSeatId()==null ? "0" :vo.getStrSeatId(),3);
			dao.setProcInValue(nProcIndex, "deptCode", vo.getStrDeptCode()==null ||vo.getStrDeptCode().equalsIgnoreCase("") ? "0" :vo.getStrDeptCode().split("#")[1] ,4);
			dao.setProcInValue(nProcIndex, "Room_No", vo.getStrRoomCode()==null ? "0" : vo.getStrRoomCode(),5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			ws = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("getprecription profile wsResult::::::::::::"+ws.size());
			if(strErr.equals(""))
			{
				ws = dao.getWebRowSet(nProcIndex, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
              while (ws.next()) {
            	  
                	//status="1";
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		//if(value.equalsIgnoreCase("Active")){
                		if(key.equalsIgnoreCase("HJOSN_RX_COMPLETE")){
                		JSONParser parser = new JSONParser();
                		org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
                		js.put(key, json);
                		}else{
                			js.put(key, value);	
                		}
                		
                		
                	//}
                	}
                	jsonolist.add(js) ;  
                	jsonArray.put(js);
                	
                }
              }
			//System.out.println(jsonolist.toString());
			if (strErr == null || strErr.equals("")){
				vo.setStrPrescriptionProfileJSON(jsonolist);
	 JSONArray jsArray = new JSONArray();			
		for(int j=0 ;  j<jsonArray.length() ;j++){
			if(jsonArray.getJSONObject(j).getString("GNUM_ISVALID").equalsIgnoreCase("Active")){
				//jsonArray.remove(j);
				jsArray.put(jsonArray.get(j));
			}
		}
				vo.setStrPrescriptionProfileJSONArray(jsArray);
				//System.out.println("jsArray"+jsArray);
			//jsonArray.put(jsonolist);
			}
			else{
				throw new Exception(strErr);
			}
		} catch (Exception _Err) {
			 new HisException("OPD Ver-2.0","getPrevDataInv.getPrevDiagnosisDtl()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo
					.setStrMsgString("DoctorDeskVO.getDrugProfileDtl() --> "
							+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			
			ws = null;
		}
		
		
	}
	public static void getExternalHospital(DoctorDeskVO vo) {
		String strproc_name = "{call pkg_opdDrDesk_view.proc_hospital_dtl(?,?,?,?)}";
		HisDAO dao = null;
		

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			
					
			dao = new HisDAO("OPD Ver-2.0",
					"DocDeskDao");
			
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcOutValue(nProcIndex, "err", 1,3);
			dao.setProcOutValue(nProcIndex, "resultset", 2,4);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("getExternalHospital wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				vo.setStrExternalHospitalweb(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			 new HisException("OPD Ver-2.0","DoctorDeskDAO.getRefferalDeptDtl()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo.setStrMsgString("DoctorDeskVO.getExternalHospital() --> "+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			
			wsResult = null;
		}
		
	}
	public static void getExternalInstitute(DoctorDeskVO vo) {
		String strproc_name = "{call pkg_opdDrDesk_view.proc_hospital_dtl(?,?,?,?)}";
		HisDAO dao = null;
		

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			
					
			dao = new HisDAO("OPD Ver-2.0",
					"DocDeskDao");
			
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcOutValue(nProcIndex, "err", 1,3);
			dao.setProcOutValue(nProcIndex, "resultset", 2,4);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("getExternalHospital wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				vo.setStrExternalInstituteweb(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			 new HisException("OPD Ver-2.0","DoctorDeskDAO.getRefferalDeptDtl()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo.setStrMsgString("DoctorDeskVO.getExternalHospital() --> "+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			
			wsResult = null;
		}
		
	}
	public static void getExternalDepartmentList(DoctorDeskVO vo) {
		String strproc_name = "{call pkg_opdDrDesk_view.proc_hospital_dtl(?,?,?,?)}";
		HisDAO dao = null;
		

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			
					
			dao = new HisDAO("OPD Ver-2.0",
					"DocDeskDao");
			
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "3",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcOutValue(nProcIndex, "err", 1,3);
			dao.setProcOutValue(nProcIndex, "resultset", 2,4);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("getExternalHospital wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				vo.setStrExternalDepartmentListweb(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			 new HisException("OPD Ver-2.0","DoctorDeskDAO.getRefferalDeptDtl()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo.setStrMsgString("DoctorDeskVO.getExternalHospital() --> "+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			
			wsResult = null;
		}
		
	}
	
	public static void getEmpanelledDepartmentList(DoctorDeskVO vo) {
		String strproc_name = "{call pkg_opdDrDesk_view.proc_hospital_dtl(?,?,?,?)}";
		HisDAO dao = null;
		

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			
					
			dao = new HisDAO("OPD Ver-2.0",
					"DocDeskDao");
			
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "4",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcOutValue(nProcIndex, "err", 1,3);
			dao.setProcOutValue(nProcIndex, "resultset", 2,4);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("getExternalHospital wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				vo.setStrEmpanelledDepartmentListweb(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			 new HisException("OPD Ver-2.0","DoctorDeskDAO.getEmpanelledDepartmentList()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo.setStrMsgString("DoctorDeskVO.getEmpanelledDepartmentList() --> "+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			
			wsResult = null;
		}
		
	}
	
	public static void getServiceAreaList(DoctorDeskVO vo) {
		String strproc_name = "{call pkg_opdDrDesk_view.proc_macros_dtl(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			
					
			dao = new HisDAO("MMS",
					"transactions.DoctorDeskDAO.getServiceAreaList()");
			
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "3",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id",  vo.getStrSeatId()==null ? "0" :vo.getStrSeatId(),3);
			dao.setProcInValue(nProcIndex, "deptCode",vo.getStrDeptCode()==null ||vo.getStrDeptCode().equalsIgnoreCase("") ? "0" :vo.getStrDeptCode().split("#")[0],4);
			dao.setProcInValue(nProcIndex, "Room_No", "",5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("proc_macros_dtl wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				vo.setStrServiceAreaWebRowSet(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			 new HisException("OPD Ver-2.0","DoctorDeskDAO.getServiceAreaList()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo.setStrMsgString("DoctorDeskVO.getServiceAreaList() --> "+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			
			wsResult = null;
		}
		
	}
	
//	public static void saveFileData(DoctorDeskVO vo) {}
	public static void saveFileData(DoctorDeskVO vo) {

	 
    	String proc_name1 = "{call pkg_OpdDesk_dml.hrgt_document_upload_dtl(?,?,?,?,?, ?,?,?,?,?)}";
    	
        int procIndex1 = 0;
      
        HisDAO dao = null;
       
        
       
        
        try {
        	
   		
			//System.out.println("JsonData"+JsonData);
			//System.out.println("Diagnosis "+object.get("Diagnosis"));
			//System.out.println("CR_No"+object.get("CR_No"));
			//System.out.println("episodeCode"+object.get("episodeCode"));
 	
			dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "p_mode", "3",1);
            dao.setProcInValue(procIndex1, "p_puk", vo.getStrFileData().split(",")[1],2);
            dao.setProcInValue(procIndex1, "p_hospcode", vo.getStrHospitalCode(),3); 
            dao.setProcInValue(procIndex1, "p_seatId", vo.getStrSeatId(),4); 
            dao.setProcInValue(procIndex1, "p_episodecode",vo.getStrFileData().split(",")[2] ,5); 
            dao.setProcInValue(procIndex1, "p_visitno", "1",6);
            dao.setProcInValue(procIndex1, "p_json", vo.getStrLocation().getFileName().replaceAll(" ", "_"),7);
            dao.setProcInValue(procIndex1, "p_ftpPath", vo.getStrFtpPath(),8);
			dao.setProcInValue(procIndex1, "p_isvalid", vo.getStrDocumenttype(),9);
			
            dao.setProcOutValue(procIndex1, "err", 1,10);
            dao.executeProcedureByPosition(procIndex1);
		   		
		   		//	return "DATA INSERTED SUCCESSFULLY";
		   			vo.setStrMsgType("1");
        }
        catch (Exception e) {
        	vo.setStrMsgType("2");
        	 new HisException("OPD Ver-2.0","opdDrDeskDao.SaveEHRData()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
           // return "Something Went Wrong";
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
		
		
	}
	public static String getPrevChronicDtl(DoctorDeskVO vo) {
		String err = "";
    	String proc_name1 = "{call pkg_opddrdesk_view.proc_prev_dtl(?,?,?,?, ?,?,?,?)}";
        int nProcIndex = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
       
          
        
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
            dao = new HisDAO("WebServices", "HospotalMgmtDao.getHospitalMgmtData()");
            nProcIndex = dao.setProcedure(proc_name1);
            dao.setProcInValue(nProcIndex, "modeval", "11",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id", "",3);
			dao.setProcInValue(nProcIndex, "deptCode", "",4);
			dao.setProcInValue(nProcIndex, "episodecode", vo.getStrEpisodeCode(),5);
			dao.setProcInValue(nProcIndex, "puk", vo.getStrPuk(),6);
			dao.setProcOutValue(nProcIndex, "err", 1,7);
			dao.setProcOutValue(nProcIndex, "resultset", 2,8);
			dao.executeProcedureByPosition(nProcIndex);
            err=dao.getString(nProcIndex, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(nProcIndex, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
              while (ws.next()) {
            	 
                	
                	String value=ws.getString(1);
                	if(StringUtils.isNotBlank(value)) {	
                		JSONArray arr= new JSONArray(value);
                		for(int i=0;i<arr.length();i++) {
                			JSONObject js=new JSONObject(arr.getString(i));
                			jsonolist.add(js) ;          
                		}
                	}
                	     	
                	
                }
              }
          if(ws != null){
        		ws.close();
        		ws = null;
        	}   
            vo.setStrPrevChronicDtlJSON(jsonolist);
           // System.out.println("ChronicDtlJSON>>>"+jsonolist.toString());
            return jsonolist.toString();
        }
        catch (Exception e) {
        	
        	 new HisException("OPD Ver-2.0","getPrevDataInv.getPrevVisitReason()-->", e.getMessage() + "-->" + e);
        	vo.setStrMsgType("1");
            e.printStackTrace();
            return jsonolist.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
	}
	public static String getPrevAllergyDtl(DoctorDeskVO vo) {
		String err = "";
    	String proc_name1 = "{call pkg_opddrdesk_view.proc_prev_dtl(?,?,?,?, ?,?,?,?)}";
        int nProcIndex = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
       
          
        
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
            dao = new HisDAO("WebServices", "HospotalMgmtDao.getHospitalMgmtData()");
            nProcIndex = dao.setProcedure(proc_name1);
            dao.setProcInValue(nProcIndex, "modeval", "12",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id", "",3);
			dao.setProcInValue(nProcIndex, "deptCode", "",4);
			dao.setProcInValue(nProcIndex, "episodecode", vo.getStrEpisodeCode(),5);
			dao.setProcInValue(nProcIndex, "puk", vo.getStrPuk(),6);
			dao.setProcOutValue(nProcIndex, "err", 1,7);
			dao.setProcOutValue(nProcIndex, "resultset", 2,8);
			dao.executeProcedureByPosition(nProcIndex);
            err=dao.getString(nProcIndex, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(nProcIndex, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
              while (ws.next()) {
            	  
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i)==null?"":ws.getString(i);
                		if(key.equalsIgnoreCase("HRSTR_JSON_DATA")) //hrstr_json_data
                		{
                			
                			JSONParser parser = new JSONParser();
                    		org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
                    		js.put(key, json);
                		}else {
                			js.put(key, value);
                		}	
                	}
                	jsonolist.add(js) ;               	
                	
                }
              }
          if(ws != null){
        		ws.close();
        		ws = null;
        	}   
            vo.setStrPrevAllergyDtlJSON(jsonolist);
            //System.out.println("jsonolist.toString()INV"+jsonolist.toString());
            return jsonolist.toString();
        }
        catch (Exception e) {
        	
        	 new HisException("OPD Ver-2.0","getPrevDataInv.getPrevVisitReason()-->", e.getMessage() + "-->" + e);
        	vo.setStrMsgType("1");
            e.printStackTrace();
            return jsonolist.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
	}
	
	
	
	public static void getUnRegisteredDrugDtl(DoctorDeskVO vo) {
		String strproc_name = "{call pharmacy_final.pkg_mms_drdesk_dtl.proc_all_drug_list(?,?,?,?,?,?)}";
		HisDAO dao = null;
	 	int nProcIndex = 0;
		String strErr = "";
		WebRowSet wsResult = null;
		try {
		 
			dao = new HisDAO("DRDESK",	"DoctorDeskDAO.getUnRegisteredDrugDtl()");
			
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "seat_id",  vo.getStrSeatId()==null ? "0" :vo.getStrSeatId(),3);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "hosp_type", vo.getHospitalType(),4);			
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("getdrugdtl wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				vo.setStrDrugWb(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			  new HisException("OPD Ver-2.0","DoctorDeskDAO.getUnRegisteredDrugDtl()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo.setStrMsgString("DoctorDeskDAO.getUnRegisteredDrugDtl()--> "+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			 
			wsResult = null;
		}
		
	}

	public static void getStoreDrugs(DoctorDeskVO vo) {
		String strproc_name = "{call pharmacy_final.pkg_mms_drdesk_dtl.proc_stock_list(?,?,?,?,?,?)}";
		HisDAO dao = null;
	 	int nProcIndex = 0;
		String strErr = "";
		WebRowSet wsResult = null;
		 
		try {
		 
			dao = new HisDAO("DRDESK",	"DoctorDeskDAO.getStoreDrugs()");
			 
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "seat_id",  vo.getStrSeatId()==null ? "0" :vo.getStrSeatId(),2);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
			dao.setProcInValue(nProcIndex, "hosp_type", vo.getHospitalType() ,4);			
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);
			strErr = dao.getString(nProcIndex, "err");
			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			
		//	System.out.println("stock drug count >> "+wsResult.size());
			
			if (strErr != null && strErr.equals(""))
				vo.setStrDrugWb(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			  new HisException("OPD Ver-2.0","DoctorDeskDAO.getStoreDrugs()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo.setStrMsgString("DoctorDeskDAO.getStoreDrugs()--> "+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			 
			wsResult = null;
		}
		
		
	}

	
	public static JSONObject queueoperationbydr(JSONObject objInputJson) {
		JSONObject response=new JSONObject();
		String strproc_name = "{call appointment.pkg_online_queue_dtl.queueoperationbydr(?,?,?, ?,?,?, ?,?,?,?,?,?,?,?)}";
		
		/*
		 * PROCEDURE queueoperationbydr(modevalue character varying, hospitalcode
		 * character varying, deptunitid character varying, actionflag character
		 * varying, queueinternalno character varying, queueinternalno_visit character
		 * varying, queuesymbol character varying, callnextpatient character varying,
		 * benid character varying, benname character varying, mobileno character
		 * varying, displayqueueno character varying, OUT retvalueforsms character
		 * varying, OUT err character varying);
		 */
		HisDAO dao = null;
	 	int nProcIndex = 0;
		String strErr = "";
		String strMsg = "";
		try {
			
			/*// objInputJson format
			{hospitalCode:"",
			"deptunitid" :deptunitid, 
			"actionflag":flagStatus, 
				"queueinternalno":$('#queueinternalno').val(), 
				"queueinternalno_visit" :$('#queueinternalno_visit').val(),
				"queuesymbol":$('#queuesymbol').val(), 
				"callnextpatient":flagcallPatient,
				"benid":"" ,
				"benname":"",
				"mobileno":"",
				"displayqueueno":""
				
			}*/
			dao = new HisDAO("DRDESK",	"DoctorDeskDAO.queueoperationbydr()");
			int indx=1; 
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modevalue", "1",indx++);
			dao.setProcInValue(nProcIndex, "hospitalCode",  objInputJson.getString("hospitalCode") ,indx++);
			dao.setProcInValue(nProcIndex, "deptunitid",  objInputJson.getString("deptunitid") ,indx++);
			dao.setProcInValue(nProcIndex, "actionflag",  objInputJson.getString("actionflag") ,indx++);
			dao.setProcInValue(nProcIndex, "queueinternalno",  objInputJson.getString("queueinternalno") ,indx++);
			dao.setProcInValue(nProcIndex, "queueinternalno_visit",  objInputJson.getString("queueinternalno_visit") ,indx++);
			dao.setProcInValue(nProcIndex, "queuesymbol",  objInputJson.getString("queuesymbol") ,indx++);
			dao.setProcInValue(nProcIndex, "callnextpatient",  objInputJson.getString("callnextpatient") ,indx++);
			dao.setProcInValue(nProcIndex, "benid",  objInputJson.getString("benid") ,indx++);
			dao.setProcInValue(nProcIndex, "benname",  objInputJson.getString("benname") ,indx++);
			dao.setProcInValue(nProcIndex, "mobileno",  objInputJson.getString("mobileno") ,indx++);
			dao.setProcInValue(nProcIndex, "displayqueueno",  objInputJson.getString("displayqueueno") ,indx++);			
			dao.setProcOutValue(nProcIndex, "retvalueforsms", 1,indx++);
			dao.setProcOutValue(nProcIndex, "err", 1,indx++);			
			dao.executeProcedureByPosition(nProcIndex);
			
			strErr = dao.getString(nProcIndex, "err");
			String retvalueforsms=dao.getString(nProcIndex, "retvalueforsms");
			if(strErr!=null &&  !strErr.equals("")) {
				throw new Exception(strErr);
			}
			response.put("message", "success");
			response.put("retvalueforsms", retvalueforsms);
			
		} catch (Exception _Err) {
			  new HisException("OPD Ver-2.0","DoctorDeskDAO.callNextPatient()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			try {
				response.put("message", "problem while updating queue");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		return response;
	}
	public static void getDeptForQMS(DoctorDeskVO vo) {
		String strproc_name = "{call pkg_opdDrDesk_view.proc_dept_dtl(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
	 

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
		 
			dao = new HisDAO("MMS",
					"transactions.DoctorDeskDAO.getDeptForQMS()");
			
			nProcIndex = dao.setProcedure(strproc_name);
			
			dao.setProcInValue(nProcIndex, "modeval", "10",1);
			
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "seat_id",  vo.getStrSeatId()==null ? "0" :vo.getStrSeatId(),3);
			dao.setProcInValue(nProcIndex, "deptCode", "",4);
			dao.setProcInValue(nProcIndex, "Room_No", "",5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			
			//System.out.println("getDeptDtl wsResult::::::::::::"+wsResult.size());
			 
			if (strErr == null || strErr.equals(""))
			{
				wsResult = dao.getWebRowSet(nProcIndex, "resultset");
				vo.setStrDeptWb(wsResult);
				
			}
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
		  new HisException("OPD Ver-2.0","DoctorDeskDAO.getDeptForQMS()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo
					.setStrMsgString("DoctorDeskVO.getDeptForQMS() --> "+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		 
			wsResult = null;
		}
		
	}
	
	public static JSONObject saveSickFormData(JSONObject objInputJson) {
		
		System.out.println("Input JSON: \n" + objInputJson); 
	    JSONObject response = new JSONObject();
	    // Updated stored procedure name and parameters
	    String strproc_name = "{call opd.pkg_opddesk_dml.save_crno_and_episodecode_wise_data(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	    HisDAO dao = null;
	    int nProcIndex = 0;
	    String strErr = "";
	    try {
	    	
	    	System.out.println("inside try Input JSON: \n" + objInputJson); 
	        // Initialize DAO
	        dao = new HisDAO("DRDESK", "DoctorDeskDAO.save()");

	        // Set procedure index and input parameters
	        nProcIndex = dao.setProcedure(strproc_name);
	        // Set parameters in this order:
		     dao.setProcInValue(nProcIndex, "crno", objInputJson.getString("puk"), 1);           
		     dao.setProcInValue(nProcIndex, "episodecode", objInputJson.getString("episodeCode"), 2); 
		     dao.setProcInValue(nProcIndex, "formID", objInputJson.getString("formID"),3);    
		     dao.setProcInValue(nProcIndex, "illness", objInputJson.getString("illness"), 4);    
		     dao.setProcInValue(nProcIndex, "designation", objInputJson.getString("designation"), 5);
	         dao.setProcInValue(nProcIndex, "absenceFrom", objInputJson.getString("absenceFrom"), 6);
	         dao.setProcInValue(nProcIndex, "absenceTo", objInputJson.getString("absenceTo"), 7);
	         dao.setProcInValue(nProcIndex, "effectiveDate", objInputJson.getString("effectiveDate"),8);
	         dao.setProcInValue(nProcIndex, "hospitalCode", objInputJson.getString("hospitalCode"),9); 
	         dao.setProcInValue(nProcIndex, "mc_status", objInputJson.getString("mcStatus"),10); 
	         dao.setProcInValue(nProcIndex, "consultantName", objInputJson.getString("consultantName"),11);
	         dao.setProcInValue(nProcIndex, "SeatId", objInputJson.getString("SeatId"),12);
	         dao.setProcInValue(nProcIndex, "visitNo", objInputJson.getString("visitNo"),13);
	         dao.setProcInValue(nProcIndex, "isAttended", objInputJson.getString("isAttended"),14);
		     dao.setProcOutValue(nProcIndex, "err", 1,15);                                      
		     //dao.setProcOutValue(nProcIndex, "resultset", java.sql.Types.REF_CURSOR, 9);        

	        // Execute the stored procedure
	        dao.executeProcedureByPosition(nProcIndex);

	        // Retrieve the error message from the procedure
	        strErr = dao.getString(nProcIndex, "err");

	        // Check for errors
	        if (strErr != null && !strErr.equals("")) {
	            throw new Exception(strErr);

	        }
	        // Success response
	        response.put("message", "success");
	    } catch (Exception _Err) {
	        // Log the exception
	        new HisException("OPD Ver-2.0", "DoctorDeskDAO.saveSickFormData()-->", _Err.getMessage() + "-->" + _Err);
	        _Err.printStackTrace();

	        // Error response
	        try {
	            response.put("message", "problem while saving sick form data");
	        } catch (JSONException e) {
	            e.printStackTrace();
	        }
	    } finally {
	        // Clean up DAO resources
	        if (dao != null) {
	            dao.free();
	            dao = null;
	        }
	    }
	    return response;
	}
	
	
	public static JSONObject updateSickFormStatus(JSONObject objInputJson) {
		
		System.out.println("Input JSON: \n" + objInputJson); 
	    JSONObject response = new JSONObject();
	    // Updated stored procedure name and parameters
	    String strproc_name = "{call opd.pkg_opddesk_dml.update_mc_status_for_ext_fc(?,?,?,?,?)}";
	    HisDAO dao = null;
	    int nProcIndex = 0;
	    String strErr = "";
	    try {
	    	
	    	System.out.println("inside try Input JSON: \n" + objInputJson); 
	        // Initialize DAO
	        dao = new HisDAO("DRDESK", "DoctorDeskDAO.save()");

	        nProcIndex = dao.setProcedure(strproc_name);
	        // Set parameters in this order:
		     dao.setProcInValue(nProcIndex, "crno", objInputJson.getString("puk"), 1);           
		     dao.setProcInValue(nProcIndex, "gnumMedNo", objInputJson.getString("tempGnumMedNo"), 2); 
		     dao.setProcInValue(nProcIndex, "mc_status", objInputJson.getString("mcStatus"),3); 
		     dao.setProcInValue(nProcIndex, "fc_status", objInputJson.getString("fcStatus"),4); 
		     dao.setProcOutValue(nProcIndex, "err", 1,5);                                      
		     //dao.setProcOutValue(nProcIndex, "resultset", java.sql.Types.REF_CURSOR, 9);        

	        // Execute the stored procedure
	        dao.executeProcedureByPosition(nProcIndex);

	        // Retrieve the error message from the procedure
	        strErr = dao.getString(nProcIndex, "err");

	        // Check for errors
	        if (strErr != null && !strErr.equals("")) {
	            throw new Exception(strErr);

	        }
	        // Success response
	        response.put("message", "success");
	    } catch (Exception _Err) {
	        // Log the exception
	        new HisException("OPD Ver-2.0", "DoctorDeskDAO.saveSickFormData()-->", _Err.getMessage() + "-->" + _Err);
	        _Err.printStackTrace();

	        // Error response
	        try {
	            response.put("message", "problem while saving sick form data");
	        } catch (JSONException e) {
	            e.printStackTrace();
	        }
	    } finally {
	        // Clean up DAO resources
	        if (dao != null) {
	            dao.free();
	            dao = null;
	        }
	    }
	    return response;
	}
	
	
	public static JSONObject getMedFromsRecords(JSONObject objInputJson) {
		//System.out.println("Inside getMedFromsRecords try Input JSON: \n" + objInputJson);
	    JSONObject response = new JSONObject();
	    String strProcName = "{call pkg_opddrdesk_view.get_crno_wise_medical_form_data(?,?,?,?,?,?,?,?,?)}";
	    HisDAO dao = null;
	    int nProcIndex = 0;
	    String strErr = "";
	    WebRowSet wsResult = null;

	    try {
	        System.out.println("Inside getMedFromsRecords try Input JSON: \n" + objInputJson);
	        dao = new HisDAO("DRDESK", "DoctorDeskDAO.getMedFromsRecords()");
	        nProcIndex = dao.setProcedure(strProcName);

	        // Set input parameters
	        dao.setProcInValue(nProcIndex, "modeval", objInputJson.getString("modeval"),1);
		    dao.setProcInValue(nProcIndex, "crno", objInputJson.getString("puk"), 2);           
		    dao.setProcInValue(nProcIndex, "episodecode", objInputJson.getString("episodeCode"), 3); 
		    dao.setProcInValue(nProcIndex, "formID", objInputJson.getString("formId"),4);
		    dao.setProcInValue(nProcIndex, "entryDate", objInputJson.getString("entryDate"),5);
		    dao.setProcInValue(nProcIndex, "gnumMedNo", objInputJson.getString("gnumMedNo"),6);
		    dao.setProcInValue(nProcIndex, "designation", objInputJson.getString("tempGnumMedNo"),7);
	        // Set output parameters
	        dao.setProcOutValue(nProcIndex, "err", 1, 8); 
	        dao.setProcOutValue(nProcIndex, "resultset", 2, 9); 

	        dao.executeProcedureByPosition(nProcIndex);

	        strErr = dao.getString(nProcIndex, "err");
	        if (strErr != null && !strErr.isEmpty()) {
	            throw new Exception(strErr);
	        }

	        // Retrieve the result set from the REF CURSOR
	        wsResult = dao.getWebRowSet(nProcIndex, "resultset");
	        JSONArray jsonArray = new JSONArray();
	        
	        // Process WebRowSet to build JSON response
	        if (wsResult != null) {
	        	
	        	//System.out.println("Processing result set, number of rows: " + wsResult.size());
	        	
	            while (wsResult.next()) {
	                JSONObject record = new JSONObject();
	                record.put("puk", wsResult.getString(1));
	                record.put("episodecode", wsResult.getString(2));
	                record.put("formId", wsResult.getString(3));
	                record.put("illness", wsResult.getString(4));
	                record.put("designation", wsResult.getString(5));
	                record.put("absenceFrom", wsResult.getString(6));
	                record.put("absenceTo", wsResult.getString(7));
	                record.put("effectiveDate", wsResult.getString(8));
	                record.put("entryDate", wsResult.getString(9));
	                record.put("gnumMedNo", wsResult.getString(10));
	                record.put("mcStatus", wsResult.getString(11));
	                record.put("fcStatus", wsResult.getString(12));
	                record.put("orgname", wsResult.getString(13));
	                record.put("docName", wsResult.getString(14));
	                record.put("hospName", wsResult.getString(15));
	                //System.out.println("orgname: \n" + wsResult.getString(14));
	                jsonArray.put(record);
	            }
	            response.put("data", jsonArray);
	            //response.put("data", jsonArray);
	            //System.out.println("Inside getMedFromsRecords wsResult: \n" + jsonArray);
	        }

	        response.put("message", "success");

	    } catch (Exception _Err) {
	        // Logging error
	        new HisException("OPD Ver-2.0", "DoctorDeskDAO.getMedFromsRecords()-->", _Err.getMessage() + "-->" + _Err);
	        _Err.printStackTrace();
	        
	        try {
	            response.put("message", "error");
	        } catch (JSONException e1) {
	            e1.printStackTrace();
	        }
	        
	        try {
	            response.put("error", _Err.getMessage());
	        } catch (JSONException e) {
	            e.printStackTrace();
	        }
	    } finally {
	        if (dao != null) {
	            dao.free();
	        }
	        if (wsResult != null) {
	            try {
	                wsResult.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    return response; 
	}

	public static JSONArray getPatientQueueDtl(String benId) {
		JSONArray response=new JSONArray();
		String strproc_name = "{call opd.pkg_opddrdesk_view.get_departmentunitdetailForPatientDisplayboard(?,?,?)}";
		WebRowSet wsResult = null;
		HisDAO dao = null;
	 	int nProcIndex = 0;
		String strErr = "";
		String strMsg = "";
		try {
			dao = new HisDAO("DRDESK",	"DoctorDeskDAO.getPatientQueueDtl()");
			int indx=1; 
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "p_benId", benId,indx++);
			dao.setProcOutValue(nProcIndex, "err", 1,indx++);
			dao.setProcOutValue(nProcIndex, "resultset", 2, indx++);			
			dao.executeProcedureByPosition(nProcIndex);
			
			strErr = dao.getString(nProcIndex, "err");
			if (strErr == null || strErr.equals(""))
			{
				wsResult = dao.getWebRowSet(nProcIndex, "resultset");
				
			}
			else
				throw new Exception(strErr);
			
			
			
		} catch (Exception _Err) {
			  new HisException("OPD Ver-2.0","DoctorDeskDAO.callNextPatient()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();			
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}			
		}
		if(wsResult!=null) {
			try {
				response=printJSONObject(wsResult);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return response;
	}
	public static JSONArray printJSONObject(WebRowSet ws ) throws Exception {
		JSONArray arr = new JSONArray();
	    try {
	    if(ws!=null) {
		  
		    
		    ResultSetMetaData rsmd = ws.getMetaData() ;
	    	int colCount = rsmd.getColumnCount();
	    	while (ws.next()){
	    		JSONObject jsonObject = new JSONObject();
	    		  try {
	  		    	Field changeMap = jsonObject.getClass().getDeclaredField("map");
	  		    	changeMap.setAccessible(true);
	  		    	changeMap.set(jsonObject, new LinkedHashMap<>());
	  		    	changeMap.setAccessible(false);
	  		    } catch (IllegalAccessException | NoSuchFieldException e) {
	  		    // System.out.println(e.getMessage());
	  		    }
	    		for (int i=1;i<=rsmd.getColumnCount();i++){
	    			
	    			String key=rsmd.getColumnName(i).trim();
	    			if(key.equals("?column?")){
	    				key="column_"+i;
	    			}
					String value=ws.getString(i)==null?"":ws.getString(i);
					jsonObject.put(key, value);
	    		}
	    		arr.put(jsonObject);
	    	}		    
	    }
	    }catch(Exception e) {
	    	throw e;
	    }
	    finally {
	    	if(ws!=null) {
	    		ws.close();
	    		ws=null;
	    	}
	    }
	    return arr;
	  }
	
	public static void getReferalLists(OPDReferralVO vo) {
		String strproc_name = "{call pkg_opdDrDesk_view.proc_refral_dtl(?,?,?,?)}";
		HisDAO dao = null;
		

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			
					
			dao = new HisDAO("OPD","DocDeskDao");
			
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", vo.getMode() ,1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcOutValue(nProcIndex, "err", 1,3);
			dao.setProcOutValue(nProcIndex, "resultset", 2,4);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("getExternalHospital wsResult::::::::::::"+wsResult.size());
			if (strErr == null || strErr.equals(""))
				vo.setStrExternalHospitalweb(wsResult);
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			 new HisException("OPD Lite","OPDReferralDAO.getRefferalDeptDtl()-->", _Err.getMessage() + "-->" + _Err);
			_Err.printStackTrace();
			vo.setStrMsgString("OPDReferralVO.getExternalHospital() --> "+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			
			wsResult = null;
		}
		
	}

}
