package new_opd.transaction.controller.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import org.apache.commons.collections.map.MultiValueMap;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import hisglobal.config.HISConfig;
import hisglobal.presentation.ControllerDATA;
import hisglobal.presentation.ControllerUTIL;
import hisglobal.vo.HospitalMstVO;
import hisglobal.vo.UserVO;
import jcs.DrugData;
import jcs.UnregisteredDrugDataManager;
import new_opd.bo.DoctorDeskBO;
import new_opd.transaction.controller.action.SSEServlet;
import new_opd.transaction.controller.fb.DoctorDeskFB;
import new_opd.transaction.controller.util.OPDTemplateMstUtil;
import new_opd.vo.DoctorDeskVO;
import new_opd.vo.DrugVO;

public class DoctorDeskDATA extends ControllerDATA {

	public static void getDeptDtlData(DoctorDeskFB formBean, HttpServletRequest request) {
		DoctorDeskVO vo = null;
		DoctorDeskBO bo = null;
		// Map<String ,List> m=null;
		// List <String> list=null;
		/*
		 * Map<String ,List> TestMap=null; Map<String ,List> DiagnosisMap=null;
		 * Map<String ,List> DrugMap=null; Map<String ,List> DosageMap=null; Map<String,
		 * String> MacrosMap=null; Map<String, String> clinicalProcedureMap=null; List
		 * <String> TestList=null; List <String> DiagnosisList=null; List <String>
		 * DrugList=null; List <String> DosageList=null; List <String>
		 * BookmarkList=null;
		 */
		Map<String, String> DeptCmb = null;

		// Map<String, String> strExternalHospital=null;
		/*
		 * Map<String, String> strExternalInstitute=null;
		 * 
		 * Map <String ,List> BookmarkMap=null;
		 */
		try {
			vo = new DoctorDeskVO();
			bo = new DoctorDeskBO();
			String HsopitalCode = (String) request.getSession().getAttribute("HOSPITAL_CODE");
			UserVO userVO = (UserVO) request.getSession().getAttribute(HISConfig.USER_VO);
			String SeatId = (String) request.getSession().getAttribute("SEATID");

			if (HsopitalCode != null)
				vo.setStrHospitalCode(HsopitalCode);
			else
				vo.setStrHospitalCode("0");
			// System.out.println("Seat id -->> "+SeatId);
			// System.out.println("user vo Seat id -->> "+userVO.getSeatId());
			vo.setStrSeatId(SeatId);
			// System.out.println("userVO:::::::::"+userVO.getUserName());
			// System.out.println("userVO:::::::"+userVO.getUsrName());
			vo.setStrRoomCode(formBean.getStrRoomCode());
			vo.setStrDeptCode(formBean.getDeptUnitName());

			vo.setStrDeptUnitCode(formBean.getDeptUnitName());
			vo.setStrPrevDate(formBean.getStrPrevDate());
			// System.out.println("formBean.getStrPrevDate():::::"+formBean.getStrPrevDate());

			vo.setIsScriber(formBean.getIsScriber());
			bo.getInitilasData1(vo, request);
			// bo.getInitilasData(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception();
			}

			DeptCmb = new LinkedHashMap<String, String>();
			if (vo.getStrDeptWb().size() > 0) {
				while (vo.getStrDeptWb().next()) {
					DeptCmb.put(vo.getStrDeptWb().getString(1), vo.getStrDeptWb().getString(2));

				}
			}

			request.getSession().setAttribute("DeptDTL", DeptCmb);
			if (StringUtils.isBlank(formBean.getDeptUnitName()))
				formBean.setStrHiddenDeptCode(vo.getStrHiddenDeptCode());
			else
				formBean.setStrHiddenDeptCode(formBean.getDeptUnitName());
			/*
			 * request.getSession().setAttribute("ReffralDeptCmb", ReffralDeptCmb);
			 * 
			 * request.getSession().setAttribute("BookmarkDTL", BookmarkMap);
			 * request.getSession().setAttribute("DiagnosisDTL", mapIcdCodeLst);
			 */
			request.getSession().setAttribute("UserName", userVO.getUsrName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void getInitailData(DoctorDeskFB formBean, HttpServletRequest request) {
		DoctorDeskVO vo = null;
		DoctorDeskBO bo = null;
		Map<String, List> m = null;
		List<String> list = null;
		Map<String, List> TestMap = null;
		Map<String, List> DiagnosisMap = null;
		Map<String, List> DosageMap = null;

		Map<String, String> clinicalProcedureMap = null;
		List<String> TestList = null;
		List<String> DiagnosisList = null;
		List<String> DosageList = null;
		List<String> BookmarkList = null;

		ArrayList<String> columnlist = new ArrayList<String>();
		ArrayList<String> columnlist1 = new ArrayList<String>();
		Map<String, List> BookmarkMap = null;
		// Map <String ,String> strTemplateHtmlMap=null;
		try {
			vo = new DoctorDeskVO();
			bo = new DoctorDeskBO();
			HospitalMstVO objHospitalMstVO = ControllerUTIL.getHospitalVO(request);
			
			String HsopitalCode = (String) request.getSession().getAttribute("HOSPITAL_CODE");
			UserVO userVO = (UserVO) request.getSession().getAttribute(HISConfig.USER_VO);
			String SeatId = (String) request.getSession().getAttribute("SEATID");
			String IsSmartQMSEnabled =(String)request.getSession().getAttribute("ISSMARTQMSENABLED");
			
			formBean.setIsSmartQMSEnabled(IsSmartQMSEnabled);
			vo.setIsSmartQMSEnabled(IsSmartQMSEnabled);
			
			LocalDate currentDate = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
			formBean.setCurrentDate(currentDate.format(formatter));

			if (HsopitalCode != null)
				vo.setStrHospitalCode(HsopitalCode);
			else
				vo.setStrHospitalCode("0");

			vo.setIsScriber(formBean.getIsScriber());
			vo.setStrMode(formBean.getStrmode());
			vo.setStrSeatId(SeatId);
			formBean.setStrSeatId(SeatId);
			vo.setHospitalType(objHospitalMstVO.getHospitalTypeCode());

			vo.setStrRoomCode(formBean.getStrRoomCode());
			vo.setStrDeptCode(formBean.getStrHiddenDeptCode());

			vo.setStrDeptUnitCode(formBean.getStrHiddenDeptCode());
			vo.setStrPrevDate(formBean.getStrPrevDate());
			bo.getInitilasData(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception();
			}
			if (vo.getStrOPDConfigWb() != null && vo.getStrOPDConfigWb().size() > 0) {
				while (vo.getStrOPDConfigWb().next()) {
					formBean.setStrRailTailFlg(vo.getStrOPDConfigWb().getString(1));
					request.getSession().setAttribute("RAILTEL_FLAG", vo.getStrOPDConfigWb().getString(1));
				}
			}

			m = new LinkedHashMap<String, List>();
			if (vo.getStrInitialWb().size() > 0) {
				while (vo.getStrInitialWb().next()) {

					list = new ArrayList<String>();
					int ColumnLength = vo.getStrInitialWb().getMetaData().getColumnCount();
					for (int i = 1; i <= ColumnLength; i++) {
						list.add(vo.getStrInitialWb().getString(i));
					}
					m.put(vo.getStrInitialWb().getString(39), list);

				}
			}
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception();
			}

			TestMap = new HashMap<String, List>();
			if (vo.getStrTestWb()!=null &&  vo.getStrTestWb().size() > 0) {
				while (vo.getStrTestWb().next()) {

					TestList = new ArrayList<String>();
					int ColumnLength = vo.getStrTestWb().getMetaData().getColumnCount();
					for (int i = 1; i <= ColumnLength; i++) {
						TestList.add(vo.getStrTestWb().getString(i));
					}
					TestMap.put(vo.getStrTestWb().getString(1), TestList);
				}
			}

			/*
			 * DrugMap=new HashMap<String , List>(); if(vo.getStrDrugWb() != null &&
			 * vo.getStrDrugWb().size() > 0) { while(vo.getStrDrugWb().next()) {
			 * 
			 * DrugList=new ArrayList<String>(); int ColumnLength=
			 * vo.getStrDrugWb().getMetaData().getColumnCount(); for(int i=1
			 * ;i<=ColumnLength;i++) { DrugList.add(vo.getStrDrugWb().getString(i)); }
			 * DrugMap.put(vo.getStrDrugWb().getString(2), DrugList); } }
			 */

			JSONArray obj2 = new JSONArray();
			if (vo.getStrDrugWb() != null && vo.getStrDrugWb().size() > 0) {
				while (vo.getStrDrugWb().next()) {
					int ColumnLength = vo.getStrDrugWb().getMetaData().getColumnCount();
					JSONObject obj = new JSONObject();
					String drugId = vo.getStrDrugWb().getString(1);
					String drugName = vo.getStrDrugWb().getString(2).split("^")[0];
					String drugStatus = vo.getStrDrugWb().getString(2).split("^")[0];
					String programId = vo.getStrDrugWb().getString(3);
					String programName = vo.getStrDrugWb().getString(4).split("#")[0];
					String color = vo.getStrDrugWb().getString(4).split("#")[1];
					String drugQuan = vo.getStrDrugWb().getString(5);

					obj.put("drugName", drugName != null ? drugName : "");
					obj.put("drugId", drugId != null ? drugId : "");
					obj.put("drugQuan", drugQuan != null ? (drugQuan.equals("0") ? "" : drugQuan) : "");
					obj.put("drugStatus", drugStatus != null ? drugStatus : "");
					obj.put("programId", programId != null ? programId : "");
					obj.put("programName", programName != null ? programName : "");
					obj.put("color", color != null ? color : "");

					obj2.put(obj);
				}

			}
			String dosageOptionHTML="";
			DosageMap = new LinkedHashMap<String, List>();
			if (vo.getStrDosageWb().size() > 0) {
				
				while (vo.getStrDosageWb().next()) {
					String optionValue="";
					String optionText="";
					DosageList = new ArrayList<String>();
					int ColumnLength = vo.getStrDosageWb().getMetaData().getColumnCount();
					optionValue=vo.getStrDosageWb().getString(1);
					optionText=vo.getStrDosageWb().getString(2);
					dosageOptionHTML+="<option value="+optionValue+">"+optionText+"</option>";
					for (int i = 1; i <= ColumnLength; i++) {
						DosageList.add(vo.getStrDosageWb().getString(i));
					}
					DosageMap.put(vo.getStrDosageWb().getString(1), DosageList);
				}
			}
			String frequencyHTML="";
			frequencyHTML+="<option value='11'>OD(1-0-0)</option>";
			frequencyHTML+="<option value='19'>OD(0-1-0)</option>";
			frequencyHTML+="<option value='20'>OD(0-0-1)</option>";
			frequencyHTML+="<option value='12'>BD(1-0-1)</option>";
			frequencyHTML+="<option value='13'>TDS(1-1-1)</option>";
			frequencyHTML+="<option value='15'>QID(1-1-1-1)</option>";
			frequencyHTML+="<option value='14'>SOS(As per Requirement)</option>";			
			frequencyHTML+="<option value='16'>HS(At Bed Time)</option>";
			frequencyHTML+="<option value='18'>HSQW(Once a Week)</option>";
			frequencyHTML+="<option value='21'>STAT</option>";
			frequencyHTML+="<option value='-1'>Custom</option>"; 
			
			/*
			 * MacrosMap=new HashMap<String, String>();
			 * 
			 * if(vo.getStrMacrosWb().size()>0) { while (vo.getStrMacrosWb().next()) {
			 * MacrosMap.put(vo.getStrMacrosWb().getString(1),
			 * vo.getStrMacrosWb().getString(2));
			 * 
			 * } }
			 */

			ArrayList<String> macrosmultimapList = new ArrayList<String>();
			MultiValueMap macrosmultimap = null;
			macrosmultimap = new MultiValueMap();
			

			if (vo.getStrMacrosWb() != null && vo.getStrMacrosWb().size() > 0) {
				int macrosmultimaplength = vo.getStrMacrosWb().getMetaData().getColumnCount();
				for (int i = 1; i <= macrosmultimaplength; i++) {
					macrosmultimapList.add(vo.getStrMacrosWb().getMetaData().getColumnName(i).toUpperCase());
				}	
				while (vo.getStrMacrosWb().next()) {
					int j = 0;
					// status="1";
					JSONObject js = new JSONObject();
					for (int i = 1; i <= macrosmultimaplength; i++) {
						String key = macrosmultimapList.get(i - 1);
						String value = vo.getStrMacrosWb().getString(i);
						js.put(key, value);

					}
					macrosmultimap.put(vo.getStrMacrosWb().getString(1), js);

				}
				// ja.put(jsonolist);
			}

			// System.out.println("macrosmultimap.toString()"+macrosmultimap.toString());

			clinicalProcedureMap = new HashMap<String, String>();

			if (vo.getStrCinicalProcudreWb()!=null && vo.getStrCinicalProcudreWb().size() > 0) {
				while (vo.getStrCinicalProcudreWb().next()) {
					clinicalProcedureMap.put(vo.getStrCinicalProcudreWb().getString(1),
							vo.getStrCinicalProcudreWb().getString(2));

				}
			}

			/*
			 * DeptCmb=new LinkedHashMap<String, String>(); if(vo.getStrDeptWb().size()>0) {
			 * while (vo.getStrDeptWb().next()) {
			 * DeptCmb.put(vo.getStrDeptWb().getString(1), vo.getStrDeptWb().getString(2));
			 * 
			 * } }
			 */

			// System.out.println("formBean.getDeptUnitName()"+formBean.getDeptUnitName());
			if (formBean.getDeptUnitName() != null) {
				request.getSession().setAttribute("SelectedDeptId", formBean.getDeptUnitName());
			} else {
				request.getSession().setAttribute("SelectedDeptId", "0");
			}

			BookmarkMap = new HashMap<String, List>();
			if (vo.getStrBookMarksTestWb().size() > 0) {
				while (vo.getStrBookMarksTestWb().next()) {
					if (BookmarkMap.containsKey(vo.getStrBookMarksTestWb().getString(1))) {

					} else {
						BookmarkList = new ArrayList<String>();
					}

					int ColumnLength = vo.getStrBookMarksTestWb().getMetaData().getColumnCount();
					for (int i = 1; i <= ColumnLength; i++) {
						BookmarkList.add(vo.getStrBookMarksTestWb().getString(i));
					}
					BookmarkMap.put(vo.getStrBookMarksTestWb().getString(1), BookmarkList);
				}
			}

			// added for group test by ashutoshk

			if (vo.getStrGroupTestWb()!=null &&  vo.getStrGroupTestWb().size() > 0) {
				while (vo.getStrGroupTestWb().next()) {
					if (BookmarkMap.containsKey(vo.getStrGroupTestWb().getString(1))) {

					} else {
						BookmarkList = new ArrayList<String>();
					}

					int ColumnLength = vo.getStrGroupTestWb().getMetaData().getColumnCount();
					for (int i = 1; i <= ColumnLength; i++) {
						BookmarkList.add(vo.getStrGroupTestWb().getString(i));
					}
					BookmarkMap.put(vo.getStrGroupTestWb().getString(1), BookmarkList);
				}
			}

			DiagnosisMap = new HashMap<String, List>();
			if (vo.getStrDiagnosisWb().size() > 0) {
				while (vo.getStrDiagnosisWb().next()) {

					DiagnosisList = new ArrayList<String>();
					int ColumnLength = vo.getStrDiagnosisWb().getMetaData().getColumnCount();
					for (int i = 1; i <= ColumnLength; i++) {
						DiagnosisList.add(vo.getStrDiagnosisWb().getString(i));
					}
					DiagnosisMap.put(vo.getStrDiagnosisWb().getString(1), DiagnosisList);
				}
			}

			JSONArray mapIcdCodeLst = new JSONArray();
			for (Map.Entry mapIcdCodeItem : DiagnosisMap.entrySet()) {
				JSONObject mapIcdCodeLstSubObj = new JSONObject();
				String strCode = (String) mapIcdCodeItem.getKey();
				ArrayList lst = (ArrayList) mapIcdCodeItem.getValue();
				mapIcdCodeLstSubObj.put("icdCode", strCode != null ? strCode : "");
				mapIcdCodeLstSubObj.put("diagnosisName", lst.get(1) != null ? lst.get(1) : "");
				mapIcdCodeLst.put(mapIcdCodeLstSubObj);
			}
			// System.out.println("obj icd:::::::::::::>>>>>>>>>
			// "+mapIcdCodeLst.toString());
			HashMap<String, List> mapTestDtl = (HashMap) TestMap;
			JSONArray mapTestDtlLst = new JSONArray();
			for (Map.Entry mapTestDtlItem : mapTestDtl.entrySet()) {
				JSONObject mapTestDtlLstSubObj = new JSONObject();
				ArrayList lst = (ArrayList) mapTestDtlItem.getValue();
				mapTestDtlLstSubObj.put("testName", lst.get(1) != null ? lst.get(1) : "");
				mapTestDtlLstSubObj.put("testId", lst.get(0) != null ? lst.get(0) : "");
				mapTestDtlLstSubObj.put("labName", lst.get(2) != null ? lst.get(2) : "");
				mapTestDtlLst.put(mapTestDtlLstSubObj);
			}

			HashMap<String, List> clinicalProcedureMapDtl = (HashMap) clinicalProcedureMap;
			JSONArray clinicalProcedureMapDtlList = new JSONArray();
			for (Map.Entry mapTestDtlItem : clinicalProcedureMapDtl.entrySet()) {
				JSONObject mapTestDtlLstSubObj = new JSONObject();
				// ArrayList lst = (ArrayList) mapTestDtlItem.getValue();
				mapTestDtlLstSubObj.put("testName", mapTestDtlItem.getValue() != null ? mapTestDtlItem.getValue() : "");
				mapTestDtlLstSubObj.put("testId", mapTestDtlItem.getKey() != null ? mapTestDtlItem.getKey() : "");
				// mapTestDtlLstSubObj.put("labName", lst.get(2)!=null?lst.get(2):"");
				clinicalProcedureMapDtlList.put(mapTestDtlLstSubObj);
			}

			// HashMap<String ,List> map1 = (HashMap) DrugMap;
			/*
			 * JSONArray obj2 = new JSONArray(); for(Map.Entry m1:map1.entrySet()){
			 * JSONObject obj = new JSONObject(); ArrayList lst = (ArrayList) m1.getValue();
			 * obj.put("drugName", lst.get(1)!=null?lst.get(1):""); obj.put("drugId",
			 * lst.get(0)!=null?lst.get(0):""); obj.put("drugQuan",
			 * lst.get(2)!=null?(lst.get(2).equals("0")?"":lst.get(2)):""); obj2.put(obj); }
			 */
			int length = 0;
			MultiValueMap strDrugProfile = null;
			strDrugProfile = new MultiValueMap();
			
			if (vo.getStrDrugProfileWs() != null && vo.getStrDrugProfileWs().size() > 0) {
				length = vo.getStrDrugProfileWs().getMetaData().getColumnCount();

				for (int i = 1; i <= length; i++) {
					columnlist.add(vo.getStrDrugProfileWs().getMetaData().getColumnName(i).toUpperCase());
				}

				while (vo.getStrDrugProfileWs().next()) {
					int j = 0;
					// status="1";
					JSONObject js = new JSONObject();
					for (int i = 1; i <= length; i++) {
						String key = columnlist.get(i - 1);
						String value = vo.getStrDrugProfileWs().getString(i);
						js.put(key, value);

					}
					strDrugProfile.put(
							vo.getStrDrugProfileWs().getString(1) + "#" + vo.getStrDrugProfileWs().getString(2), js);

				}
				// ja.put(jsonolist);
			}
			MultiValueMap TemplateProfile = null;
			int lengthl = 0;
			if (vo.getStrTemplateWebRowSet() != null && vo.getStrTemplateWebRowSet().size() > 0) {

				TemplateProfile = new MultiValueMap();
				// strTemplateHtmlMap=new HashMap<String, String>();
				lengthl = vo.getStrTemplateWebRowSet().getMetaData().getColumnCount();

				for (int i = 1; i <= lengthl; i++) {
					columnlist1.add(vo.getStrTemplateWebRowSet().getMetaData().getColumnName(i).toUpperCase());
				}
			}
			HashSet<String> htmlhashSet = new HashSet<>();
			if (vo.getStrTemplateWebRowSet() != null && vo.getStrTemplateWebRowSet().size() > 0) {
				while (vo.getStrTemplateWebRowSet().next()) {
					int j = 0;
					// status="1";
					JSONObject js = new JSONObject();
					for (int i = 1; i <= lengthl; i++) {
						String key = columnlist1.get(i - 1);
						String value = vo.getStrTemplateWebRowSet().getString(i);
						js.put(key, value);
					}
					htmlhashSet.add(vo.getStrTemplateWebRowSet().getString(1));
					TemplateProfile.put(vo.getStrTemplateWebRowSet().getString(1), js);
					// strTemplateHtmlMap.put(vo.getStrTemplateWebRowSet().getString(1),OPDTemplateMstUtil.getHtmlFileFromFTP(vo.getStrTemplateWebRowSet().getString(1).split("#")[0],
					// HsopitalCode) );
				}
			}

			/*
			 * if(htmlhashSet !=null){ if(htmlhashSet.size() > 0){
			 * 
			 * Iterator<String> value = htmlhashSet.iterator();
			 * 
			 * while (value.hasNext()) { String strTemplateId=value.next();
			 * //strTemplateHtmlMap.put(strTemplateId,OPDTemplateMstUtil.getHtmlFileFromFTP(
			 * strTemplateId.split("#")[0], HsopitalCode) );
			 * 
			 * } } }
			 */

			/*
			 * strExternalHospital=new LinkedHashMap<String, String>();
			 * if(vo.getStrExternalHospitalweb().size()>0) { while
			 * (vo.getStrExternalHospitalweb().next()) {
			 * strExternalHospital.put(vo.getStrExternalHospitalweb().getString(1),
			 * vo.getStrExternalHospitalweb().getString(2));
			 * 
			 * } }
			 * 
			 * strExternalInstitute=new LinkedHashMap<String, String>();
			 * if(vo.getStrExternalInstituteweb().size()>0) { while
			 * (vo.getStrExternalInstituteweb().next()) {
			 * strExternalInstitute.put(vo.getStrExternalInstituteweb().getString(1),
			 * vo.getStrExternalInstituteweb().getString(2));
			 * 
			 * } }
			 * 
			 * strExternalDepartmentList=new LinkedHashMap<String, String>();
			 * if(vo.getStrExternalDepartmentListweb().size()>0) { while
			 * (vo.getStrExternalDepartmentListweb().next()) {
			 * strExternalDepartmentList.put(vo.getStrExternalDepartmentListweb().getString(
			 * 1), vo.getStrExternalDepartmentListweb().getString(2));
			 * 
			 * } }
			 */

			/*
			 * strEmpanelledDepartmentList=new LinkedHashMap<String, String>();
			 * if(vo.getStrEmpanelledDepartmentListweb()
			 * !=nullvo.getStrEmpanelledDepartmentListweb().size()>0) { while
			 * (vo.getStrEmpanelledDepartmentListweb().next()) {
			 * strEmpanelledDepartmentList.put(vo.getStrEmpanelledDepartmentListweb().
			 * getString(1), vo.getStrEmpanelledDepartmentListweb().getString(2));
			 * 
			 * } }
			 */

			ArrayList<String> teleConsultancyApprovalData = new ArrayList<String>();
			int teleConsultancyApprovalDatacount = 0;

			if (vo.getStrTeleConsultancyDataWb() != null) {
				while (vo.getStrTeleConsultancyDataWb().next()) {
					teleConsultancyApprovalDatacount++;
					teleConsultancyApprovalData.add(vo.getStrTeleConsultancyDataWb().getString(1));

				}
			}

			ArrayList<String> RefeConsultancyApprovalData = new ArrayList<String>();
			int RefeConsultancyApprovalDatacount = 0;

			if (vo.getStrRefeConsultancyDataWb() != null) {
				while (vo.getStrRefeConsultancyDataWb().next()) {
					RefeConsultancyApprovalDatacount++;
					RefeConsultancyApprovalData.add(vo.getStrRefeConsultancyDataWb().getString(1));

				}
			}

			if (vo.getStrHospitalHeaderWs().size() > 0) {
				while (vo.getStrHospitalHeaderWs().next()) {
					request.getSession().setAttribute("HOSPITAL_NAME", vo.getStrHospitalHeaderWs().getString(2));
					request.getSession().setAttribute("HOSPITAL_ADDRESS", vo.getStrHospitalHeaderWs().getString(3));

				}
			}

			LinkedHashMap<String, String> strServiceAreaHashMap = new LinkedHashMap<>();

			if (vo.getStrServiceAreaWebRowSet()!=null &&  vo.getStrServiceAreaWebRowSet().size() > 0) {
				while (vo.getStrServiceAreaWebRowSet().next()) {
					strServiceAreaHashMap.put(vo.getStrServiceAreaWebRowSet().getString(1),
							vo.getStrServiceAreaWebRowSet().getString(2));
				}
			}

			// System.out.println("strServiceAreaHashMap"+strServiceAreaHashMap.toString());
			// System.out.println("teleConsultancyApprovalData::::"+new
			// JSONArray(teleConsultancyApprovalData).toString());
			// System.out.println("TemplateProfile :::::::::::
			// "+TemplateProfile.toString());

			// System.out.println("strTemplateHtmlMap :::::::::::
			// "+strTemplateHtmlMap.toString());

			// System.out.println("DrugProfileBookMarks"+strDrugProfile.toString());
			// System.out.println("BookmarkMap\n"+BookmarkMap);
			// System.out.println("DosageDTL\n"+DosageMap);
			request.getSession().setAttribute("OPDDRDESKDATA", m);
			// System.out.println("TestMap"+TestMap.size());
			// System.out.println("DrugDTL"+DrugMap.size());
			request.getSession().setAttribute("TESTDTL", mapTestDtlLst);
			request.getSession().setAttribute("CILINICALPROCEDURE", clinicalProcedureMapDtlList);
			request.getSession().setAttribute("clinicalProcedureMap", clinicalProcedureMap);
			request.getSession().setAttribute("UNREGISTERED_DrugDTL", obj2);
			request.getSession().setAttribute("DosageDTL", DosageMap);
			request.getSession().setAttribute("dosageOptionHTML", dosageOptionHTML);
			request.getSession().setAttribute("frequencyHTML", frequencyHTML);
			
			
			request.getSession().setAttribute("MacrosDTL", macrosmultimap);
			// request.getSession().setAttribute("DeptDTL", DeptCmb);

			// request.getSession().setAttribute("strExternalHospital",
			// strExternalHospital);
			// request.getSession().setAttribute("strExternalInstitute",
			// strExternalInstitute);
			// request.getSession().setAttribute("strExternalDepartmentList",
			// strExternalDepartmentList);
			// request.getSession().setAttribute("strEmpanelledDepartmentList",
			// strEmpanelledDepartmentList);

			request.getSession().setAttribute("BookmarkDTL", BookmarkMap);
			request.getSession().setAttribute("DiagnosisDTL", mapIcdCodeLst);
			request.getSession().setAttribute("UserName", userVO.getUsrName());
			request.getSession().setAttribute("DrugProfile", strDrugProfile);

			request.getSession().setAttribute("ServiceAreaDtl", strServiceAreaHashMap);
			if (vo.getStrPrescriptionProfileJSON() != null)
				request.getSession().setAttribute("PrescriptionBookMark", vo.getStrPrescriptionProfileJSON());
			else
				request.getSession().setAttribute("PrescriptionBookMark", null);

			if (vo.getStrPrescriptionProfileJSONArray() != null
					&& vo.getStrPrescriptionProfileJSONArray().length() > 0) {
				request.getSession().setAttribute("PrescriptionBookMarkJsonArray",
						vo.getStrPrescriptionProfileJSONArray());
			} else {
				request.getSession().setAttribute("PrescriptionBookMarkJsonArray", null);
			}

			if (TemplateProfile != null) {
				request.getSession().setAttribute("TemplateProfile", TemplateProfile);
				// request.getSession().setAttribute("strTemplateHtmlMap", strTemplateHtmlMap);
			}
			request.getSession().setAttribute("teleConsultancyApprovalData", teleConsultancyApprovalData);

			request.getSession().setAttribute("RefeConsultancyApprovalData", RefeConsultancyApprovalData);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void getPrevDtl(HttpServletRequest request, HttpServletResponse response) {

		DoctorDeskVO vo = null;
		DoctorDeskBO bo = null;
		ArrayList<JSONObject> strDrugJson = null;
		ArrayList<JSONObject> strinvJson = null;
		JSONObject mainObj = new JSONObject();
		try {

			vo = new DoctorDeskVO();
			bo = new DoctorDeskBO();

			// System.out.println("req:::::::::"+request.getAttribute("PUK"));
			vo.setStrPuk(request.getParameter("PUK").toString());
			vo.setStrEpisodeCode(request.getParameter("EPISODECODE").toString());
			vo.setStrHospitalCode(request.getParameter("HOSPITALCODE").toString());
			vo.setStrVistNo(request.getParameter("visitNo").toString());
			vo.setStreTeleconsultancyReqId(request.getParameter("eTeleconsultancyReqId").toString());
			vo.setStrPatReferred(request.getParameter("isPatReferred").toString());
			vo.setStrDeptCode(request.getParameter("deptCode").toString());

			bo.getPrevData(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception();
			}
			mainObj.put("DRUGDATA", vo.getStrDrugPrevCodeJSON());
			mainObj.put("INVDATA", vo.getStrInvPrevCodeJSON());
			mainObj.put("VISTREASON", vo.getStrInvPrevVistReasonJSON());
			// mainObj.put("DIAGNOSIS", vo.getStrInvPrevDiagnosisJSON());
			mainObj.put("VITALDTLS", vo.getStrPreVitalJSON());
			mainObj.put("ETELECONSULTANCYVITAL", vo.getStrEtelePreVitalJSON());
			mainObj.put("REGISTRATIONVISIT", vo.getStrVisitReasonJSON());
			//mainObj.put("LASTTHREEVISIT", vo.getStrLastThreeVisit());
			mainObj.put("CHRONICDISEASE", vo.getStrPrevChronicDtlJSON());
			mainObj.put("ALLEGRY", vo.getStrPrevAllergyDtlJSON());
			mainObj.put("INVENTORYDRUG", vo.getStrInvDrugPrevCodeJSON());
			response.setContentType("application/json");
			response.getWriter().print(mainObj);
			// response.sendRedirect(arg0);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * public static void getInitailDataMobile(DoctorDeskFB formBean,
	 * HttpServletRequest request) { DoctorDeskVO vo=null; DoctorDeskBO bo=null;
	 * Map<String ,List> m=null; List <String> list=null; Map<String ,List>
	 * TestMap=null; Map<String ,List> DiagnosisMap=null; Map<String ,List>
	 * DrugMap=null; Map<String ,List> DosageMap=null; Map<String, String>
	 * MacrosMap=null; List <String> TestList=null; List <String>
	 * DiagnosisList=null; List <String> DrugList=null; List <String>
	 * DosageList=null; List <String> BookmarkList=null; Map<String, String>
	 * DeptCmb=null;
	 * 
	 * Map <String ,List> BookmarkMap=null; try { vo=new DoctorDeskVO(); bo=new
	 * DoctorDeskBO(); String HsopitalCode=(String)
	 * request.getSession().getAttribute("HOSPITAL_CODE");
	 * 
	 * UserVO userVO = (UserVO)
	 * request.getSession().getAttribute(HISConfig.USER_VO); String SeatId=(String)
	 * request.getSession().getAttribute("SEATID"); //String
	 * userName=userVO.getUsrName(); String userName=(String)
	 * request.getSession().getAttribute("USER_NAME");
	 * vo.setStrHospitalCode(HsopitalCode); //vo.setStrSeatId(userVO.getSeatId());
	 * vo.setStrSeatId(SeatId);
	 * //System.out.println("userVO:::::::::"+userVO.getUserName());
	 * //System.out.println("userVO:::::::"+userVO.getUsrName());
	 * vo.setStrRoomCode(formBean.getStrRoomCode());
	 * vo.setStrDeptCode(formBean.getDeptUnitName());
	 * vo.setStrPrevDate(formBean.getStrPrevDate());
	 * System.out.println("formBean.getStrPrevDate():::::"+formBean.getStrPrevDate()
	 * ); bo.getInitilasData(vo); if(vo.getStrMsgType().equals("1")) { throw new
	 * Exception(); } m=new LinkedHashMap<String , List>();
	 * if(vo.getStrInitialWb().size() > 0) { while(vo.getStrInitialWb().next()) {
	 * 
	 * list=new ArrayList<String>(); int ColumnLength=
	 * vo.getStrInitialWb().getMetaData().getColumnCount(); for(int i=1
	 * ;i<=ColumnLength;i++) { list.add(vo.getStrInitialWb().getString(i)); }
	 * m.put(vo.getStrInitialWb().getString(39), list); } }
	 * if(vo.getStrMsgType().equals("1")) { throw new Exception(); }
	 * 
	 * 
	 * TestMap=new HashMap<String , List>(); if(vo.getStrTestWb().size() > 0) {
	 * while(vo.getStrTestWb().next()) {
	 * 
	 * TestList=new ArrayList<String>(); int ColumnLength=
	 * vo.getStrTestWb().getMetaData().getColumnCount(); for(int i=1
	 * ;i<=ColumnLength;i++) { TestList.add(vo.getStrTestWb().getString(i)); }
	 * TestMap.put(vo.getStrTestWb().getString(1), TestList); } }
	 * 
	 * DrugMap=new HashMap<String , List>(); if(vo.getStrDrugWb().size() > 0) {
	 * while(vo.getStrDrugWb().next()) {
	 * 
	 * DrugList=new ArrayList<String>(); int ColumnLength=
	 * vo.getStrDrugWb().getMetaData().getColumnCount(); for(int i=1
	 * ;i<=ColumnLength;i++) { DrugList.add(vo.getStrDrugWb().getString(i)); }
	 * DrugMap.put(vo.getStrDrugWb().getString(2), DrugList); } }
	 * 
	 * DosageMap=new HashMap<String , List>(); if(vo.getStrDosageWb().size() > 0) {
	 * while(vo.getStrDosageWb().next()) {
	 * 
	 * DosageList=new ArrayList<String>(); int ColumnLength=
	 * vo.getStrDosageWb().getMetaData().getColumnCount(); for(int i=1
	 * ;i<=ColumnLength;i++) { DosageList.add(vo.getStrDosageWb().getString(i)); }
	 * DosageMap.put(vo.getStrDosageWb().getString(1), DosageList); } }
	 * MacrosMap=new HashMap<String, String>();
	 * 
	 * if(vo.getStrMacrosWb().size()>0) { while (vo.getStrMacrosWb().next()) {
	 * MacrosMap.put(vo.getStrMacrosWb().getString(1),
	 * vo.getStrMacrosWb().getString(2));
	 * 
	 * } } DeptCmb=new LinkedHashMap<String, String>();
	 * if(vo.getStrDeptWb().size()>0) { while (vo.getStrDeptWb().next()) {
	 * DeptCmb.put(vo.getStrDeptWb().getString(1), vo.getStrDeptWb().getString(2));
	 * 
	 * } }
	 * System.out.println("formBean.getDeptUnitName()"+formBean.getDeptUnitName());
	 * if(formBean.getDeptUnitName()!=null) {
	 * request.getSession().setAttribute("SelectedDeptId",
	 * formBean.getDeptUnitName()); }else{
	 * request.getSession().setAttribute("SelectedDeptId", "0"); }
	 * 
	 * BookmarkMap=new HashMap<String , List>();
	 * if(vo.getStrBookMarksTestWb().size() > 0) {
	 * while(vo.getStrBookMarksTestWb().next()) {
	 * if(BookmarkMap.containsKey(vo.getStrBookMarksTestWb().getString(1))) {
	 * 
	 * }else { BookmarkList=new ArrayList<String>(); }
	 * 
	 * int ColumnLength= vo.getStrBookMarksTestWb().getMetaData().getColumnCount();
	 * for(int i=1 ;i<=ColumnLength;i++) {
	 * BookmarkList.add(vo.getStrBookMarksTestWb().getString(i)); }
	 * BookmarkMap.put(vo.getStrBookMarksTestWb().getString(1), BookmarkList); } }
	 * 
	 * DiagnosisMap=new HashMap<String , List>(); if(vo.getStrDiagnosisWb().size() >
	 * 0) { while(vo.getStrDiagnosisWb().next()) {
	 * 
	 * DiagnosisList=new ArrayList<String>(); int ColumnLength=
	 * vo.getStrDiagnosisWb().getMetaData().getColumnCount(); for(int i=1
	 * ;i<=ColumnLength;i++) {
	 * DiagnosisList.add(vo.getStrDiagnosisWb().getString(i)); }
	 * DiagnosisMap.put(vo.getStrDiagnosisWb().getString(1), DiagnosisList); } }
	 * 
	 * JSONArray mapIcdCodeLst = new JSONArray(); for(Map.Entry
	 * mapIcdCodeItem:DiagnosisMap.entrySet()){ JSONObject mapIcdCodeLstSubObj = new
	 * JSONObject(); String strCode=(String)mapIcdCodeItem.getKey(); ArrayList lst =
	 * (ArrayList) mapIcdCodeItem.getValue(); mapIcdCodeLstSubObj.put("icdCode",
	 * strCode!=null?strCode:""); mapIcdCodeLstSubObj.put("diagnosisName",
	 * lst.get(1)!=null?lst.get(1):""); mapIcdCodeLst.put(mapIcdCodeLstSubObj); } //
	 * System.out.println("obj icd:::::::::::::>>>>>>>>> "+mapIcdCodeLst.toString())
	 * ; HashMap<String ,List> mapTestDtl = (HashMap) TestMap; JSONArray
	 * mapTestDtlLst = new JSONArray(); for(Map.Entry
	 * mapTestDtlItem:mapTestDtl.entrySet()){ JSONObject mapTestDtlLstSubObj = new
	 * JSONObject(); ArrayList lst = (ArrayList) mapTestDtlItem.getValue();
	 * mapTestDtlLstSubObj.put("testName", lst.get(1)!=null?lst.get(1):"");
	 * mapTestDtlLstSubObj.put("testId", lst.get(0)!=null?lst.get(0):"");
	 * mapTestDtlLstSubObj.put("labName", lst.get(2)!=null?lst.get(2):"");
	 * mapTestDtlLst.put(mapTestDtlLstSubObj); }
	 * 
	 * 
	 * HashMap<String ,List> map1 = (HashMap) DrugMap; JSONArray obj2 = new
	 * JSONArray(); for(Map.Entry m1:map1.entrySet()){ JSONObject obj = new
	 * JSONObject(); ArrayList lst = (ArrayList) m1.getValue(); obj.put("drugName",
	 * lst.get(1)!=null?lst.get(1):""); obj.put("drugId",
	 * lst.get(0)!=null?lst.get(0):""); obj.put("drugQuan",
	 * lst.get(2)!=null?(lst.get(2).equals("0")?"":lst.get(2)):""); obj2.put(obj); }
	 * 
	 * 
	 * // System.out.println("BookmarkMap\n"+BookmarkMap);
	 * //System.out.println("DosageDTL\n"+DosageMap);
	 * request.getSession().setAttribute("OPDDRDESKDATA", m);
	 * System.out.println("TestMap"+TestMap.size());
	 * System.out.println("DrugDTL"+DrugMap.size());
	 * request.getSession().setAttribute("TESTDTL", mapTestDtlLst);
	 * request.getSession().setAttribute("DrugDTL", obj2);
	 * request.getSession().setAttribute("DosageDTL", DosageMap);
	 * request.getSession().setAttribute("MacrosDTL", MacrosMap);
	 * request.getSession().setAttribute("DeptDTL", DeptCmb);
	 * request.getSession().setAttribute("BookmarkDTL", BookmarkMap);
	 * request.getSession().setAttribute("DiagnosisDTL", mapIcdCodeLst);
	 * request.getSession().setAttribute("UserName", userName); }catch(Exception e)
	 * { e.printStackTrace(); }
	 * 
	 * }
	 */
	public static void getInitailDataForMobileApp(DoctorDeskFB formBean, HttpServletRequest request) {
		DoctorDeskVO vo = null;
		DoctorDeskBO bo = null;
		Map<String, List> m = null;
		List<String> list = null;
		Map<String, List> TestMap = null;
		Map<String, List> DiagnosisMap = null;
		Map<String, List> DrugMap = null;
		Map<String, List> DosageMap = null;
		Map<String, String> MacrosMap = null;
		Map<String, String> clinicalProcedureMap = null;
		List<String> TestList = null;
		List<String> DiagnosisList = null;
		List<String> DrugList = null;
		List<String> DosageList = null;
		List<String> BookmarkList = null;
		Map<String, String> DeptCmb = null;
		Map<String, String> ReffralDeptCmb = null;
		ArrayList<String> columnlist = new ArrayList<String>();
		ArrayList<String> columnlist1 = new ArrayList<String>();
		Map<String, List> BookmarkMap = null;
		// Map <String ,String> strTemplateHtmlMap=null;
		try {
			vo = new DoctorDeskVO();
			bo = new DoctorDeskBO();
			String HsopitalCode = (String) request.getSession().getAttribute("HOSPITAL_CODE");
			UserVO userVO = (UserVO) request.getSession().getAttribute(HISConfig.USER_VO);
			String SeatId = (String) request.getSession().getAttribute("SEATID");
			vo.setStrHospitalCode(HsopitalCode);
			vo.setStrMode("");
			// System.out.println("Seat id -->> "+SeatId);
			// System.out.println("user vo Seat id -->> "+userVO.getSeatId());
			vo.setStrSeatId(SeatId);
			// System.out.println("userVO:::::::::"+userVO.getUserName());
			// System.out.println("formBean.getStrHiddenDeptCode()"+formBean.getStrHiddenDeptCode());
			// System.out.println("userVO:::::::"+userVO.getUsrName());
			// vo.setStrRoomCode(formBean.getStrRoomCode());
			vo.setStrDeptCode(formBean.getDeptUnitName());

			// vo.setStrDeptUnitCode(formBean.getStrHiddenDeptCode());
			vo.setStrPrevDate(formBean.getStrPrevDate());
			// System.out.println("formBean.getStrPrevDate():::::"+formBean.getStrPrevDate());
			// bo.getInitilasData1(vo, request);
			bo.getInitilasDataForMobileApp(vo, request);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception();
			}
			m = new LinkedHashMap<String, List>();
			if (vo.getStrInitialWb().size() > 0) {
				while (vo.getStrInitialWb().next()) {

					list = new ArrayList<String>();
					int ColumnLength = vo.getStrInitialWb().getMetaData().getColumnCount();
					for (int i = 1; i <= ColumnLength; i++) {
						list.add(vo.getStrInitialWb().getString(i));
					}
					m.put(vo.getStrInitialWb().getString(39), list);
				}
			}
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception();
			}

			TestMap = new HashMap<String, List>();
			if (vo.getStrTestWb().size() > 0) {
				while (vo.getStrTestWb().next()) {

					TestList = new ArrayList<String>();
					int ColumnLength = vo.getStrTestWb().getMetaData().getColumnCount();
					for (int i = 1; i <= ColumnLength; i++) {
						TestList.add(vo.getStrTestWb().getString(i));
					}
					TestMap.put(vo.getStrTestWb().getString(1), TestList);
				}
			}

			DrugMap = new HashMap<String, List>();
			if (vo.getStrDrugWb().size() > 0) {
				while (vo.getStrDrugWb().next()) {

					DrugList = new ArrayList<String>();
					int ColumnLength = vo.getStrDrugWb().getMetaData().getColumnCount();
					for (int i = 1; i <= ColumnLength; i++) {
						DrugList.add(vo.getStrDrugWb().getString(i));
					}
					DrugMap.put(vo.getStrDrugWb().getString(2), DrugList);
				}
			}

			DosageMap = new LinkedHashMap<String, List>();
			if (vo.getStrDosageWb().size() > 0) {
				while (vo.getStrDosageWb().next()) {

					DosageList = new ArrayList<String>();
					int ColumnLength = vo.getStrDosageWb().getMetaData().getColumnCount();
					for (int i = 1; i <= ColumnLength; i++) {
						DosageList.add(vo.getStrDosageWb().getString(i));
					}
					DosageMap.put(vo.getStrDosageWb().getString(1), DosageList);
				}
			}
			/*
			 * MacrosMap=new HashMap<String, String>();
			 * 
			 * if(vo.getStrMacrosWb().size()>0) { while (vo.getStrMacrosWb().next()) {
			 * MacrosMap.put(vo.getStrMacrosWb().getString(1),
			 * vo.getStrMacrosWb().getString(2));
			 * 
			 * } }
			 */

			ArrayList<String> macrosmultimapList = new ArrayList<String>();
			MultiValueMap macrosmultimap = null;
			macrosmultimap = new MultiValueMap();
			int macrosmultimaplength = vo.getStrMacrosWb().getMetaData().getColumnCount();
			for (int i = 1; i <= macrosmultimaplength; i++) {
				macrosmultimapList.add(vo.getStrMacrosWb().getMetaData().getColumnName(i).toUpperCase());
			}

			if (vo.getStrMacrosWb() != null && vo.getStrMacrosWb().size() > 0) {
				while (vo.getStrMacrosWb().next()) {
					int j = 0;
					// status="1";
					JSONObject js = new JSONObject();
					for (int i = 1; i <= macrosmultimaplength; i++) {
						String key = macrosmultimapList.get(i - 1);
						String value = vo.getStrMacrosWb().getString(i);
						js.put(key, value);

					}
					macrosmultimap.put(vo.getStrMacrosWb().getString(1), js);

				}
				// ja.put(jsonolist);
			}

			// System.out.println("macrosmultimap.toString()"+macrosmultimap.toString());

			clinicalProcedureMap = new HashMap<String, String>();

			if (vo.getStrCinicalProcudreWb().size() > 0) {
				while (vo.getStrCinicalProcudreWb().next()) {
					clinicalProcedureMap.put(vo.getStrCinicalProcudreWb().getString(1),
							vo.getStrCinicalProcudreWb().getString(2));

				}
			}

			DeptCmb = new LinkedHashMap<String, String>();
			if (vo.getStrDeptWb().size() > 0) {
				while (vo.getStrDeptWb().next()) {
					DeptCmb.put(vo.getStrDeptWb().getString(1), vo.getStrDeptWb().getString(2));

				}
			}

			ReffralDeptCmb = new LinkedHashMap<String, String>();
			if (vo.getStrRefferalDeptWb().size() > 0) {
				while (vo.getStrRefferalDeptWb().next()) {
					ReffralDeptCmb.put(vo.getStrRefferalDeptWb().getString(1), vo.getStrRefferalDeptWb().getString(2));

				}
			}
			// System.out.println("formBean.getDeptUnitName()"+formBean.getDeptUnitName());
			if (formBean.getDeptUnitName() != null) {
				request.getSession().setAttribute("SelectedDeptId", formBean.getDeptUnitName());
			} else {
				request.getSession().setAttribute("SelectedDeptId", "0");
			}

			BookmarkMap = new HashMap<String, List>();
			if (vo.getStrBookMarksTestWb().size() > 0) {
				while (vo.getStrBookMarksTestWb().next()) {
					if (BookmarkMap.containsKey(vo.getStrBookMarksTestWb().getString(1))) {

					} else {
						BookmarkList = new ArrayList<String>();
					}

					int ColumnLength = vo.getStrBookMarksTestWb().getMetaData().getColumnCount();
					for (int i = 1; i <= ColumnLength; i++) {
						BookmarkList.add(vo.getStrBookMarksTestWb().getString(i));
					}
					BookmarkMap.put(vo.getStrBookMarksTestWb().getString(1), BookmarkList);
				}
			}

			DiagnosisMap = new HashMap<String, List>();
			if (vo.getStrDiagnosisWb().size() > 0) {
				while (vo.getStrDiagnosisWb().next()) {

					DiagnosisList = new ArrayList<String>();
					int ColumnLength = vo.getStrDiagnosisWb().getMetaData().getColumnCount();
					for (int i = 1; i <= ColumnLength; i++) {
						DiagnosisList.add(vo.getStrDiagnosisWb().getString(i));
					}
					DiagnosisMap.put(vo.getStrDiagnosisWb().getString(1), DiagnosisList);
				}
			}

			JSONArray mapIcdCodeLst = new JSONArray();
			for (Map.Entry mapIcdCodeItem : DiagnosisMap.entrySet()) {
				JSONObject mapIcdCodeLstSubObj = new JSONObject();
				String strCode = (String) mapIcdCodeItem.getKey();
				ArrayList lst = (ArrayList) mapIcdCodeItem.getValue();
				mapIcdCodeLstSubObj.put("icdCode", strCode != null ? strCode : "");
				mapIcdCodeLstSubObj.put("diagnosisName", lst.get(1) != null ? lst.get(1) : "");
				mapIcdCodeLst.put(mapIcdCodeLstSubObj);
			}
			// System.out.println("obj icd:::::::::::::>>>>>>>>>
			// "+mapIcdCodeLst.toString());
			HashMap<String, List> mapTestDtl = (HashMap) TestMap;
			JSONArray mapTestDtlLst = new JSONArray();
			for (Map.Entry mapTestDtlItem : mapTestDtl.entrySet()) {
				JSONObject mapTestDtlLstSubObj = new JSONObject();
				ArrayList lst = (ArrayList) mapTestDtlItem.getValue();
				mapTestDtlLstSubObj.put("testName", lst.get(1) != null ? lst.get(1) : "");
				mapTestDtlLstSubObj.put("testId", lst.get(0) != null ? lst.get(0) : "");
				mapTestDtlLstSubObj.put("labName", lst.get(2) != null ? lst.get(2) : "");
				mapTestDtlLst.put(mapTestDtlLstSubObj);
			}

			HashMap<String, List> clinicalProcedureMapDtl = (HashMap) clinicalProcedureMap;
			JSONArray clinicalProcedureMapDtlList = new JSONArray();
			for (Map.Entry mapTestDtlItem : clinicalProcedureMapDtl.entrySet()) {
				JSONObject mapTestDtlLstSubObj = new JSONObject();
				// ArrayList lst = (ArrayList) mapTestDtlItem.getValue();
				mapTestDtlLstSubObj.put("testName", mapTestDtlItem.getValue() != null ? mapTestDtlItem.getValue() : "");
				mapTestDtlLstSubObj.put("testId", mapTestDtlItem.getKey() != null ? mapTestDtlItem.getKey() : "");
				// mapTestDtlLstSubObj.put("labName", lst.get(2)!=null?lst.get(2):"");
				clinicalProcedureMapDtlList.put(mapTestDtlLstSubObj);
			}

			HashMap<String, List> map1 = (HashMap) DrugMap;
			JSONArray obj2 = new JSONArray();
			for (Map.Entry m1 : map1.entrySet()) {
				JSONObject obj = new JSONObject();
				ArrayList lst = (ArrayList) m1.getValue();
				obj.put("drugName", lst.get(1) != null ? lst.get(1) : "");
				obj.put("drugId", lst.get(0) != null ? lst.get(0) : "");
				obj.put("drugQuan", lst.get(2) != null ? (lst.get(2).equals("0") ? "" : lst.get(2)) : "");
				obj2.put(obj);
			}
			int length = 0;
			MultiValueMap strDrugProfile = null;
			strDrugProfile = new MultiValueMap();
			length = vo.getStrDrugProfileWs().getMetaData().getColumnCount();

			for (int i = 1; i <= length; i++) {
				columnlist.add(vo.getStrDrugProfileWs().getMetaData().getColumnName(i).toUpperCase());
			}

			if (vo.getStrDrugProfileWs() != null && vo.getStrDrugProfileWs().size() > 0) {
				while (vo.getStrDrugProfileWs().next()) {
					int j = 0;
					// status="1";
					JSONObject js = new JSONObject();
					for (int i = 1; i <= length; i++) {
						String key = columnlist.get(i - 1);
						String value = vo.getStrDrugProfileWs().getString(i);
						js.put(key, value);

					}
					strDrugProfile.put(
							vo.getStrDrugProfileWs().getString(1) + "#" + vo.getStrDrugProfileWs().getString(2), js);

				}
				// ja.put(jsonolist);
			}

			MultiValueMap TemplateProfile = null;
			int lengthl = 0;
			if (vo.getStrTemplateWebRowSet() != null && vo.getStrTemplateWebRowSet().size() > 0) {

				TemplateProfile = new MultiValueMap();
				// strTemplateHtmlMap=new HashMap<String, String>();
				lengthl = vo.getStrTemplateWebRowSet().getMetaData().getColumnCount();

				for (int i = 1; i <= lengthl; i++) {
					columnlist1.add(vo.getStrTemplateWebRowSet().getMetaData().getColumnName(i).toUpperCase());
				}
			}

			/*
			 * if(htmlhashSet !=null){ if(htmlhashSet.size() > 0){
			 * 
			 * Iterator<String> value = htmlhashSet.iterator();
			 * 
			 * while (value.hasNext()) { String strTemplateId=value.next();
			 * //strTemplateHtmlMap.put(strTemplateId,OPDTemplateMstUtil.getHtmlFileFromFTP(
			 * strTemplateId.split("#")[0], HsopitalCode) );
			 * strTemplateHtmlMap.put(strTemplateId,"" ); } } }
			 */

			ArrayList<String> teleConsultancyApprovalData = new ArrayList<String>();
			int teleConsultancyApprovalDatacount = 0;

			while (vo.getStrTeleConsultancyDataWb().next()) {
				teleConsultancyApprovalDatacount++;
				teleConsultancyApprovalData.add(vo.getStrTeleConsultancyDataWb().getString(1));

			}

			if (vo.getStrHospitalHeaderWs().size() > 0) {
				while (vo.getStrHospitalHeaderWs().next()) {
					request.getSession().setAttribute("HOSPITAL_NAME", vo.getStrHospitalHeaderWs().getString(2));
					request.getSession().setAttribute("HOSPITAL_ADDRESS", vo.getStrHospitalHeaderWs().getString(3));

				}
			}

			LinkedHashMap<String, String> strServiceAreaHashMap = new LinkedHashMap<>();

			if (vo.getStrServiceAreaWebRowSet().size() > 0) {
				while (vo.getStrServiceAreaWebRowSet().next()) {
					strServiceAreaHashMap.put(vo.getStrServiceAreaWebRowSet().getString(1),
							vo.getStrServiceAreaWebRowSet().getString(2));
				}
			}

			ArrayList<String> RefeConsultancyApprovalData = new ArrayList<String>();
			int RefeConsultancyApprovalDatacount = 0;

			while (vo.getStrRefeConsultancyDataWb().next()) {
				RefeConsultancyApprovalDatacount++;
				RefeConsultancyApprovalData.add(vo.getStrRefeConsultancyDataWb().getString(1));

			}

			/*
			 * System.out.println("TemplateProfile ::::::::::: "+TemplateProfile.toString())
			 * ; System.out.println("DrugProfileBookMarks"+strDrugProfile.toString());
			 */
			// System.out.println("BookmarkMap\n"+BookmarkMap);
			// System.out.println("DosageDTL\n"+DosageMap);
			request.getSession().setAttribute("OPDDRDESKDATA", m);
			// System.out.println("TestMap"+TestMap.size());
			// System.out.println("DrugDTL"+DrugMap.size());
			request.getSession().setAttribute("TESTDTL", mapTestDtlLst);
			request.getSession().setAttribute("CILINICALPROCEDURE", clinicalProcedureMapDtlList);
			request.getSession().setAttribute("DrugDTL", obj2);
			request.getSession().setAttribute("DosageDTL", DosageMap);
			request.getSession().setAttribute("MacrosDTL", macrosmultimap);
			request.getSession().setAttribute("DeptDTL", DeptCmb);
			request.getSession().setAttribute("ReffralDeptCmb", ReffralDeptCmb);
			request.getSession().setAttribute("BookmarkDTL", BookmarkMap);
			request.getSession().setAttribute("DiagnosisDTL", mapIcdCodeLst);
			request.getSession().setAttribute("UserName", userVO.getUsrName());
			request.getSession().setAttribute("DrugProfile", strDrugProfile);

			request.getSession().setAttribute("ServiceAreaDtl", strServiceAreaHashMap);
			if (vo.getStrPrescriptionProfileJSON() != null)
				request.getSession().setAttribute("PrescriptionBookMark", vo.getStrPrescriptionProfileJSON());
			else
				request.getSession().setAttribute("PrescriptionBookMark", null);

			if (vo.getStrPrescriptionProfileJSONArray() != null
					&& vo.getStrPrescriptionProfileJSONArray().length() > 0) {
				request.getSession().setAttribute("PrescriptionBookMarkJsonArray",
						vo.getStrPrescriptionProfileJSONArray());
			} else {
				request.getSession().setAttribute("PrescriptionBookMarkJsonArray", null);
			}

			if (TemplateProfile != null) {
				request.getSession().setAttribute("TemplateProfile", TemplateProfile);
				// request.getSession().setAttribute("strTemplateHtmlMap", strTemplateHtmlMap);
			} else {
				request.getSession().setAttribute("TemplateProfile", null);
				// request.getSession().setAttribute("strTemplateHtmlMap", null);
			}
			request.getSession().setAttribute("teleConsultancyApprovalData", teleConsultancyApprovalData);
			request.getSession().setAttribute("RefeConsultancyApprovalData", RefeConsultancyApprovalData);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void getHospitalHeader(HttpServletRequest request, HttpServletResponse response,
			DoctorDeskFB doctorDeskFB) {
		DoctorDeskBO bo = null;
		DoctorDeskVO vo = null;
		try {

			bo = new DoctorDeskBO();
			vo = new DoctorDeskVO();
			vo.setStrHospitalCode(doctorDeskFB.getStrMobileHospitalCode());
			bo.getHospitalHeader(vo);

			if (vo.getStrHospitalHeaderWs().size() > 0) {
				while (vo.getStrHospitalHeaderWs().next()) {
					request.getSession().setAttribute("HOSPITAL_NAME", vo.getStrHospitalHeaderWs().getString(2));
					request.getSession().setAttribute("HOSPITAL_ADDRESS", vo.getStrHospitalHeaderWs().getString(3));
					doctorDeskFB.setStrHospitalName(vo.getStrHospitalHeaderWs().getString(2));
					doctorDeskFB.setStrHospitalAddres(vo.getStrHospitalHeaderWs().getString(3));

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void saveFileData(HttpServletRequest request, HttpServletResponse response, DoctorDeskFB doctorDeskFB,
			String ftpPath) {
		DoctorDeskBO bo = null;
		DoctorDeskVO vo = null;
		try {

			bo = new DoctorDeskBO();
			vo = new DoctorDeskVO();

			vo.setStrDocumenttype(doctorDeskFB.getStrDocumenttype());
			vo.setStrFileData(doctorDeskFB.getStrFileData());
			vo.setStrLocation(doctorDeskFB.getStrLocation());
			String HsopitalCode = (String) request.getSession().getAttribute("HOSPITAL_CODE");
			UserVO userVO = (UserVO) request.getSession().getAttribute(HISConfig.USER_VO);
			String SeatId = (String) request.getSession().getAttribute("SEATID");
			vo.setStrHospitalCode(HsopitalCode);
			vo.setStrSeatId(SeatId);
			vo.setStrFtpPath(ftpPath);
			bo.saveFileData(vo);

			doctorDeskFB.setStrMsgType(vo.getStrMsgType());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void populateteplatesInSession(HttpServletRequest request, HttpServletResponse response) {
		HashMap<String, String> strTemplateHtmlMap = new HashMap<String, String>();
		MultiValueMap TemplateProfile = new MultiValueMap();
		strTemplateHtmlMap = (HashMap) request.getSession().getAttribute("strTemplateHtmlMap");
		TemplateProfile = (MultiValueMap) request.getSession().getAttribute("TemplateProfile");
		String HsopitalCode = (String) request.getSession().getAttribute("HOSPITAL_CODE");
		if ((strTemplateHtmlMap == null || strTemplateHtmlMap.size() == 0) && TemplateProfile != null
				&& TemplateProfile.size() > 0) {
			HashSet<String> htmlhashSet = new HashSet<>();
			Iterator<String> it = TemplateProfile.keySet().iterator();
			strTemplateHtmlMap = new HashMap<String, String>();
			while (it.hasNext()) {
				String theKey = (String) it.next();
				// System.out.println("theKey--" + theKey);
				try {
					String html = OPDTemplateMstUtil.getHtmlFileFromFTP(theKey.split("#")[0], HsopitalCode);
					if (html.equals("FTP Access Required")) {
						break;
					}
					strTemplateHtmlMap.put(theKey, html);
				} catch (Exception e) {
					System.out.println("exception  in populateteplatesInSession== " + e.getMessage());
					break;
				}

			}
			if (strTemplateHtmlMap != null && strTemplateHtmlMap.size() > 0) {
				request.getSession().setAttribute("strTemplateHtmlMap", strTemplateHtmlMap);
			}
			/*
			 * else { // System.out.println("No Template found"); }
			 */

		}

	}

	public static void populateReffralDeptCmb(HttpServletRequest request, HttpServletResponse response) {

		String HsopitalCode = (String) request.getSession().getAttribute("HOSPITAL_CODE");
		Map<String, String> ReffralDeptCmb = new LinkedHashMap<String, String>();
		UserVO userVO = (UserVO) request.getSession().getAttribute(HISConfig.USER_VO);
		String SeatId = (String) request.getSession().getAttribute("SEATID");
		String json = "{}";
		DoctorDeskVO vo = new DoctorDeskVO();
		String strHiddenDeptCode = request.getParameter("strHiddenDeptCode");
		// System.out.println("strHiddenDeptCode>>>" + strHiddenDeptCode);
		json = (String) request.getSession().getAttribute("ReffralDeptCmb");
		if (json == null) {
			if (HsopitalCode != null)
				vo.setStrHospitalCode(HsopitalCode);
			else
				vo.setStrHospitalCode("0");
			vo.setStrSeatId(SeatId);
			vo.setStrDeptCode(strHiddenDeptCode);
			DoctorDeskBO bo = new DoctorDeskBO();
			bo.getRefferalDeptDtl(vo);
			if (vo != null && vo.getStrRefferalDeptWb().size() > 0) {

				try {
					json = printJSONObject(vo.getStrRefferalDeptWb());
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					vo.setStrRefferalDeptWb(null);
					vo = null;
				}

			}

			request.getSession().setAttribute("ReffralDeptCmb", json);
		}

		writeInResponse(response, json, true);

	}

	public static void populateStrExternalHospital(HttpServletRequest request, HttpServletResponse response) {

		String HsopitalCode = (String) request.getSession().getAttribute("HOSPITAL_CODE");
		Map<String, String> ReffralDeptCmb = new LinkedHashMap<String, String>();
		UserVO userVO = (UserVO) request.getSession().getAttribute(HISConfig.USER_VO);
		String SeatId = (String) request.getSession().getAttribute("SEATID");
		String json = "{}";
		DoctorDeskVO vo = new DoctorDeskVO();
		json = (String) request.getSession().getAttribute("strExternalHospital");
		if (json == null) {
			if (HsopitalCode != null)
				vo.setStrHospitalCode(HsopitalCode);
			else
				vo.setStrHospitalCode("0");
			vo.setStrSeatId(SeatId);
			DoctorDeskBO bo = new DoctorDeskBO();
			bo.getExternalHospital(vo);
			if (vo != null && vo.getStrExternalHospitalweb().size() > 0) {

				try {
					json = printJSONObject(vo.getStrExternalHospitalweb());
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					vo.setStrExternalHospitalweb(null);
					vo = null;
				}

			}
			if (json != null && !json.equals("[]"))
				request.getSession().setAttribute("strExternalHospital", json);
		}

		writeInResponse(response, json, true);

	}

	public static void writeInResponse(HttpServletResponse response, String strResult, boolean isJson) {
		try {
			response.flushBuffer();
			if (isJson)
				response.setContentType("application/json");
			response.setHeader("Cache-Control", "no-cache");
			PrintWriter writer = response.getWriter();
			writer.write(strResult);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String printJSONObject(WebRowSet ws) throws Exception {
		JSONArray arr = new JSONArray();
		try {
			if (ws != null) {

				ResultSetMetaData rsmd = ws.getMetaData();
				int colCount = rsmd.getColumnCount();
				while (ws.next()) {
					JSONObject jsonObject = new JSONObject();
					try {
						Field changeMap = jsonObject.getClass().getDeclaredField("map");
						changeMap.setAccessible(true);
						changeMap.set(jsonObject, new LinkedHashMap<>());
						changeMap.setAccessible(false);
					} catch (IllegalAccessException | NoSuchFieldException e) {
						System.out.println(e.getMessage());
					}
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {

						String key = rsmd.getColumnName(i).trim();
						if (key.equals("?column?")) {
							key = "column_" + i;
						}
						String value = ws.getString(i) == null ? "" : ws.getString(i);
						jsonObject.put(key, value);
					}
					arr.put(jsonObject);
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}
		}
		return arr.toString();
	}

	

	

	public static void getUnRegisteredDrugDtl(DoctorDeskFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		DoctorDeskVO vo = null;
		DoctorDeskBO bo = null;
		List<DrugVO> lstUnregisteredDrug = new ArrayList<DrugVO>();
		String status = "ERROR";
		try {
			HospitalMstVO objHospitalMstVO =ControllerUTIL.getHospitalVO(request);
			
			if(objHospitalMstVO.getHospitalTypeCode()==null) {
				throw new Exception("Hospital type not found");
			}
				
			vo = new DoctorDeskVO();
			bo = new DoctorDeskBO();
			String date = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
			String hospitalType=objHospitalMstVO.getHospitalTypeCode();
			vo.setHospitalType(hospitalType);
			// checking in cache if drug is present for current date
		
			DrugData objDrugData = UnregisteredDrugDataManager.getInstance().getDrugDataObj("unregistereddrug_"+hospitalType + date);
			if (objDrugData == null) {

				// removing all previous objects
				UnregisteredDrugDataManager.getInstance().removeDrugDataObj("unregistereddrug_"+hospitalType);

				String HsopitalCode = (String) request.getSession().getAttribute("HOSPITAL_CODE");
				UserVO userVO = (UserVO) request.getSession().getAttribute(HISConfig.USER_VO);
				String SeatId = (String) request.getSession().getAttribute("SEATID");

				if (HsopitalCode != null)
					vo.setStrHospitalCode(HsopitalCode);
				else
					vo.setStrHospitalCode("0");

				vo.setStrSeatId(SeatId);

				bo.getUnRegisteredDrugDtl(vo);
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception();
				}

				if (vo.getStrDrugWb() != null && vo.getStrDrugWb().size() > 0) {
					while (vo.getStrDrugWb().next()) {
						int ColumnLength = vo.getStrDrugWb().getMetaData().getColumnCount();
						JSONObject obj = new JSONObject();
						DrugVO objDrugVO = new DrugVO();
						objDrugVO.setDrugId(vo.getStrDrugWb().getString(1));
						objDrugVO.setDrugBrandId(vo.getStrDrugWb().getString(2));
						objDrugVO.setDrugName(vo.getStrDrugWb().getString(3));
						
						 
						
						String []arr=vo.getStrDrugWb().getString(4).replace("^", "#").split("#");
						objDrugVO.setItemTypeId(arr[0]);
						objDrugVO.setDrugForm(arr[1]);// tab, cap etc
						objDrugVO.setIsQuantityCalculated(arr[2]); // 1 or 0
						
						
						objDrugVO.setDrugStatus(vo.getStrDrugWb().getString(5)); 
						// DrugStatus 0 means normal ,1 restricted , 2 High Value
						//objDrugVO.setDrugBrandName(vo.getStrDrugWb().getString(6));
					//	String drugname=vo.getStrDrugWb().getString(3);
					//	String drugBrandNameForDisplay = vo.getStrDrugWb().getString(6);
						 	
						objDrugVO.setDrugBrandName(objDrugVO.getDrugName());
						objDrugVO.setDrugBrandNameForDisplay(objDrugVO.getDrugName());
						objDrugVO.setProgramId(vo.getStrDrugWb().getString(7));
						objDrugVO.setProgramName("");
						objDrugVO.setColor("black");	
						String drugQuan=vo.getStrDrugWb().getString(8);
						if(drugQuan==null || drugQuan.equals(""))
							drugQuan="0";
						objDrugVO.setDrugQuan(drugQuan);
						
						if (drugQuan.equals("0")) {
							objDrugVO.setQuantityDisplay("");
						} else
							objDrugVO.setQuantityDisplay("-(Qty-" + drugQuan + ")");
						
						objDrugVO.setPackSize(vo.getStrDrugWb().getString(9));
						objDrugVO.setMaxCapQty(vo.getStrDrugWb().getString(10));
						
						lstUnregisteredDrug.add(objDrugVO);
					}
					// System.out.println("lstUnregisteredDrug>>>" + lstUnregisteredDrug.size());
					UnregisteredDrugDataManager.getInstance().loadDrugDataObj("unregistereddrug_" +hospitalType+ date,
							lstUnregisteredDrug);
				}
				// System.out.println("getting from db");
			}
			/*
			 * else { System.out.println("already in cache"); }
			 */
			objDrugData=null;
			

			status = "OK";

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writeInResponse(response, status, false);
		}
	}

	public static void getStoreDrugs(DoctorDeskFB formBean, HttpServletRequest request, HttpServletResponse response) {
		DoctorDeskVO vo = null;
		DoctorDeskBO bo = null;
		List<DrugVO> lstDrug = null;
		String json = "[]";
		try {
			HospitalMstVO objHospitalMstVO =ControllerUTIL.getHospitalVO(request);
			
			if(objHospitalMstVO.getHospitalTypeCode()==null) {
				throw new Exception("Hospital type not found");
			}

			lstDrug = (List) request.getSession().getAttribute("STORE_DRUG");
			
			if (lstDrug == null || lstDrug.size() == 0) {
				vo = new DoctorDeskVO();
				bo = new DoctorDeskBO();

				lstDrug = new ArrayList<DrugVO>();

				String HsopitalCode = (String) request.getSession().getAttribute("HOSPITAL_CODE");
				UserVO userVO = (UserVO) request.getSession().getAttribute(HISConfig.USER_VO);
				String SeatId = (String) request.getSession().getAttribute("SEATID");
				String hospitalType=objHospitalMstVO.getHospitalTypeCode();
				vo.setHospitalType(hospitalType);
				if (HsopitalCode != null)
					vo.setStrHospitalCode(HsopitalCode);
				else
					vo.setStrHospitalCode("0");

				vo.setStrSeatId(SeatId);

				bo.getStoreDrugs(vo);
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception();
				}

				if (vo.getStrDrugWb() != null && vo.getStrDrugWb().size() > 0) {
					while (vo.getStrDrugWb().next()) {
						int ColumnLength = vo.getStrDrugWb().getMetaData().getColumnCount();
						JSONObject obj = new JSONObject();
						if (vo.getStrDrugWb().getString(2) == null)
							continue;
						DrugVO objDrugVO = new DrugVO();
						objDrugVO.setDrugId(vo.getStrDrugWb().getString(1));
						objDrugVO.setDrugBrandId(vo.getStrDrugWb().getString(2));
						objDrugVO.setDrugName(vo.getStrDrugWb().getString(3));
						
						
						String drugForm= vo.getStrDrugWb().getString(4);
						if(drugForm!=null && !drugForm.equals("-") && !drugForm.equals("")) {
							String []arr=drugForm.replace("^", "#").split("#");
							objDrugVO.setItemTypeId(arr[0]);
							objDrugVO.setDrugForm(arr[1]);// tab, cap etc
							objDrugVO.setIsQuantityCalculated(arr[2]); // 1 or 0
						}
						else {
							objDrugVO.setItemTypeId("");
							objDrugVO.setDrugForm("-");// tab, cap etc
							objDrugVO.setIsQuantityCalculated("0"); // 1 or 0
						}
						
						/*
						 * String []arr=vo.getStrDrugWb().getString(4).replace("^", "#").split("#");
						 * objDrugVO.setItemTypeId(arr[0]); objDrugVO.setDrugForm(arr[1]);// tab, cap
						 * etc objDrugVO.setIsQuantityCalculated(arr[2]); // 1 or 0
						 */						
						objDrugVO.setDrugStatus(vo.getStrDrugWb().getString(5)); 
						// DrugStatus 0 means normal ,1 restricted , 2 High Value
						
						
						
						
						String brandName=vo.getStrDrugWb().getString(6);
						objDrugVO.setDrugBrandName(objDrugVO.getDrugName());
						objDrugVO.setDrugBrandNameForDisplay(objDrugVO.getDrugName());
						objDrugVO.setProgramId(vo.getStrDrugWb().getString(7));
						objDrugVO.setProgramName("");
						
						String drugQuan=vo.getStrDrugWb().getString(8);
						
						if(drugQuan==null || drugQuan.equals("0")|| drugQuan.trim().equals("")) {
							drugQuan="0";
							objDrugVO.setColor("black");
							objDrugVO.setQuantityDisplay("");
						}
						else {
							objDrugVO.setColor("green");
							objDrugVO.setQuantityDisplay("-(Qty-" + drugQuan + ")");
						}
						objDrugVO.setDrugQuan(drugQuan); 
						
						
						
						
                       
                        objDrugVO.setPackSize(vo.getStrDrugWb().getString(9));
                        objDrugVO.setMaxCapQty(vo.getStrDrugWb().getString(10));
						
						lstDrug.add(objDrugVO);
					}

					if (lstDrug.size() > 0)
						System.out.println("store drug from session --" + lstDrug.size());
					
						request.getSession().setAttribute("STORE_DRUG", lstDrug);
				}
			}
			else {
				System.out.println("store drug from session --" + lstDrug.size());
			}
			Gson gson = new Gson();
			json = gson.toJson(lstDrug);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writeInResponse(response, json, false);
		}

	}

	
	public static void searchDrugOld(DoctorDeskFB formBean, HttpServletRequest request, HttpServletResponse response) {
	    String json = "[]";
	    List<DrugVO> searchedDrugList = new ArrayList<>();

	    try {
	        HospitalMstVO hospitalMstVO = ControllerUTIL.getHospitalVO(request);
	        if (hospitalMstVO.getHospitalTypeCode() == null) {
	            throw new Exception("Hospital type not found");
	        }

	        String searchTerm = request.getParameter("keyword");
	        if (searchTerm != null && !searchTerm.trim().isEmpty()) {
	            List<DrugVO> storeDrugs = (List<DrugVO>) request.getSession().getAttribute("STORE_DRUG");
	            if (storeDrugs != null) {
	                searchedDrugList.addAll(storeDrugs.stream()
	                        .filter(drug -> Arrays.stream(searchTerm.split(" "))
	                                .allMatch(keyword -> drug.getDrugBrandName().toLowerCase().contains(keyword.toLowerCase())))
	                        .collect(Collectors.toList()));
	              
	            }

	            String date = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
	            DrugData unregisteredDrugData = UnregisteredDrugDataManager.getInstance()
	                    .getDrugDataObj("unregistereddrug_" + hospitalMstVO.getHospitalTypeCode() + date);

	            if (unregisteredDrugData != null && unregisteredDrugData.lstData != null) {
	                List<DrugVO> unauthorizedDrugs = new ArrayList<>(unregisteredDrugData.lstData);
	                unauthorizedDrugs.removeAll(searchedDrugList);
	                searchedDrugList.addAll(unauthorizedDrugs.stream()
	                        .filter(drug -> Arrays.stream(searchTerm.split(" "))
	                                .allMatch(keyword -> drug.getDrugBrandName().toLowerCase().contains(keyword.toLowerCase())))
	                        .collect(Collectors.toList()));
	            }
	          
	            if (!searchedDrugList.isEmpty()) {
	            	
	            	
	            	List<DrugVO> finalSearchedDrugList = searchedDrugList.stream()
	            		    .sorted(Comparator
	            		        .comparing((DrugVO drug) -> {
	            		            try {
	            		                return Integer.parseInt(drug.getDrugQuan()) > 0 ? 0 : 1;
	            		            } catch (NumberFormatException e) {
	            		                return 1;
	            		            }
	            		        })
	            		        .thenComparing((DrugVO drug) -> 
	            		            drug.getDrugBrandName() != null &&
	            		            drug.getDrugBrandName().toLowerCase().startsWith(searchTerm.toLowerCase()) ? 0 : 1)
	            		        .thenComparingInt(drug -> 
	            		            drug.getDrugBrandName() != null ? 
	            		                drug.getDrugBrandName().length() : Integer.MAX_VALUE)
	            		        .thenComparing(drug -> 
	            		            drug.getDrugBrandName() != null ? 
	            		                drug.getDrugBrandName().toLowerCase() : ""))
	            		    .collect(Collectors.toList());
	            	
	                json = new Gson().toJson(finalSearchedDrugList);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        writeInResponse(response, json, true);
	    }
	}

	public static void searchInCurrentDateStoreData(DoctorDeskFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		List<DrugVO> lstDrug = new ArrayList<DrugVO>();
		JSONObject objjson = null;
		try {
			String searchTerm = request.getParameter("keyword");

			if (searchTerm != null && searchTerm.trim().length() > 0) {
				objjson = new JSONObject(searchTerm);

				Date start = new Date();
				if (!objjson.getString("IsExterNal").equals("1")) {
					String drugId = objjson.getString("drugId");
					String drugBrandId = objjson.getString("drugBrandId");
					String programId = objjson.getString("programId");

					/* checking in store drug */
					lstDrug = (List) request.getSession().getAttribute("STORE_DRUG");

					if (lstDrug != null && lstDrug.size() > 0) {
						List<DrugVO> matchingDrug = lstDrug.stream()
								.filter(drug -> drug.getDrugId().equals(drugId)
										&& drug.getDrugBrandId().equals(drugBrandId)
										)
								.collect(Collectors.toList());
						if (matchingDrug != null && matchingDrug.size() == 1) {
							DrugVO objDrugVO = matchingDrug.get(0);
							objjson.put("drugQuan", objDrugVO.getDrugQuan());
						}						
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writeInResponse(response, objjson.toString(), true);
		}

	}

	public static void queueoperationbydr(DoctorDeskFB formBean, HttpServletRequest request,
			HttpServletResponse response) {
		JSONObject objjson = new JSONObject();
		JSONObject objInputJson =null;
		String hospitalCode = (String) request.getSession().getAttribute("HOSPITAL_CODE");
		String retvalueforsms =null;
		try {
			DoctorDeskBO bo = new DoctorDeskBO();

			
			// UserVO userVO = (UserVO)
			// request.getSession().getAttribute(HISConfig.USER_VO);
			// String SeatId=(String) request.getSession().getAttribute("SEATID");
			 objInputJson = new JSONObject(formBean.getInputjson());
			objInputJson.put("hospitalCode", hospitalCode);
			// objInputJson.put("seatId", SeatId);

			objjson = bo.queueoperationbydr(objInputJson);

			 retvalueforsms = objjson.getString("retvalueforsms");
			if (retvalueforsms != null && !retvalueforsms.equals("") && !retvalueforsms.equals("0")) {
				
				retvalueforsms = "[" + retvalueforsms + "]";
				//System.out.println("retvalueforsms>>>>" + retvalueforsms);								
				
			}

		} catch (Exception e) {
			try {
				if (objjson == null)
					objjson = new JSONObject();
				objjson.put("message", "Problem while calling !");

			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			writeInResponse(response, objjson.toString(), true);
			try {
				SSEServlet.addDataForSMS(hospitalCode, objInputJson.getString("deptunitid"), retvalueforsms);
			}catch(Exception e) {
				e.getMessage();
			}
		}

	}

	public static void SendCallToDisplayBoard(DoctorDeskFB formBean, 
			HttpServletRequest request, HttpServletResponse response) {
		JSONObject objjson = new JSONObject();
		
		new Thread( new Runnable() {
	           public void run(){
					try {
						DoctorDeskBO bo = new DoctorDeskBO();
			
						String hospitalCode = (String) request.getSession().getAttribute("HOSPITAL_CODE");
						if (hospitalCode != null && formBean.getDepartmentUnitCode()!=null   && formBean.getInputjson()!=null ) {
							//System.out.println("formBean.getInputjson()>>>>" + formBean.getInputjson());				
							SSEServlet.addDataForDisplayBoard(hospitalCode, formBean.getDepartmentUnitCode(), formBean.getInputjson());
						}
			
					} catch (Exception e) {
						e.printStackTrace();
						
					} 
	           
		return; // to stop the thread
               }
        }).start();	
	 
		
		writeInResponse(response, objjson.toString(), true);
		}
	
	
	public static void saveSickFormData(DoctorDeskFB formBean, HttpServletRequest request, HttpServletResponse response) {
		JSONObject objjson = new JSONObject();
	    
	    try {
	        // Create business object
	        DoctorDeskBO bo = new DoctorDeskBO();

	        String hospitalCode = (String) request.getSession().getAttribute("HOSPITAL_CODE");
	        String SeatId = (String) request.getSession().getAttribute("SEATID");
	        JSONObject objInputJson = new JSONObject(formBean.getInputjson());
	        
	        //System.out.println("Input inside saveSickForm getInputjson: \n" + objInputJson); 

	        objInputJson.put("hospitalCode", hospitalCode);
	        objInputJson.put("SeatId", SeatId);
	        

	        // Parse input JSON from formBean
	        //JSONObject objInputJson = new JSONObject(formBean.getInputjson());
	        
	        //System.out.println("Input inside saveSickForm getInputjson: \n" + objInputJson); 

	        // Add session-specific data to the input JSON
	       // objInputJson.put("hospitalCode", hospitalCode);


	        // Call the business logic method
	        objjson = bo.saveSickFormData(objInputJson);

	    } catch (Exception e) {
	         try {
	            // Handle null JSON object
	            if (objjson == null) {
	                objjson = new JSONObject();
	            }
	            // Add error message
	            objjson.put("message", "Problem while saving sick form data!");
	        } catch (JSONException e1) {
	            e1.printStackTrace();
	        }
	        e.printStackTrace();
	    } finally {
	    	
	        writeInResponse(response, objjson.toString(), true);
	    }
	    
	    
	}
	
	public static void updateSickFormStatus(DoctorDeskFB formBean, HttpServletRequest request, HttpServletResponse response) {
		JSONObject objjson = new JSONObject();
		//System.out.println("inside updateSickFormStatusDATA 2");
	    try {
	        // Create business object
	        DoctorDeskBO bo = new DoctorDeskBO();

	        // Retrieve session data
	        String hospitalCode = (String) request.getSession().getAttribute("HOSPITAL_CODE");

	        // Parse input JSON from formBean
	        JSONObject objInputJson = new JSONObject(formBean.getInputjson());
	        
	       // System.out.println("Input inside updateSickFormStatus getInputjson: \n" + objInputJson); 

	        // Add session-specific data to the input JSON
	        objInputJson.put("hospitalCode", hospitalCode);


	        // Call the business logic method
	        objjson = bo.updateSickFormStatus(objInputJson);

	    } catch (Exception e) {
	         try {
	            // Handle null JSON object
	            if (objjson == null) {
	                objjson = new JSONObject();
	            }
	            // Add error message
	            objjson.put("message", "Problem while saving sick form data!");
	        } catch (JSONException e1) {
	            e1.printStackTrace();
	        }
	        e.printStackTrace();
	    } finally {
	    	
	        writeInResponse(response, objjson.toString(), true);
	    }
	    
	    
	}

	public static void getMedFromsRecords(DoctorDeskFB formBean, HttpServletRequest request, HttpServletResponse response) throws JSONException, SQLException {
	    
	    java.util.Enumeration<String> parameterNames = request.getParameterNames();
	    JSONObject objInputJson = new JSONObject(); 

	    while (parameterNames.hasMoreElements()) {
	        String paramName = parameterNames.nextElement();
	        String paramValue = request.getParameter(paramName);
	     //   System.out.println("Request Parameter - " + paramName + ": " + paramValue);
	        
	        
	        // Add each parameter to the JSONObject
	        objInputJson.put(paramName, paramValue);

	    }

	    //System.out.println("Manually Constructed JSON: \n" + objInputJson);

	    JSONObject objjson = new JSONObject();
	    //System.out.println("Inside getMedFromsRecords22 >>>");

	    try {
	        DoctorDeskBO bo = new DoctorDeskBO();
	        String hospitalCode = (String) request.getSession().getAttribute("HOSPITAL_CODE");
	       // System.out.println("Inside getMedFromsRecords122 >>>");
	        
	        String inputJsonString = objInputJson.getString("inputJson");

	        JSONObject inputJson = new JSONObject(inputJsonString);


	        String modeval = objInputJson.getString("modeval");
	        //System.out.println("modeval: " + modeval);

	        inputJson.put("modeval", modeval);
	        inputJson.put("hospitalCode", hospitalCode);

	        //System.out.println("Inside bo.getMedFromsRecords(inputJson); Input JSON: \n" + inputJson);
	        objjson = bo.getMedFromsRecords(inputJson);

	    } catch (Exception e) {
	        try {
	            objjson = new JSONObject();
	            objjson.put("success", false);
	            objjson.put("message", "Problem fetching records: " + e.getMessage());
	            System.err.println("Error in getMedFromsRecords: " + e.getMessage());
	            e.printStackTrace();
	        } catch (JSONException e1) {
	            e1.printStackTrace();
	        }
	    } finally {
	        writeInResponse(response, objjson.toString(), true);
	    }
	}

	public static void searchDrug(DoctorDeskFB formBean, HttpServletRequest request, HttpServletResponse response) {
	    String json = "[]";
	    List<DrugVO> searchedDrugList = new ArrayList<>();
	    boolean debug=false;
	    
	    List<DrugVO> searchedDrugListStore = new ArrayList<>();
	    List<DrugVO> searchedDrugListUnregistered = new ArrayList<>();
	    try {
	        HospitalMstVO hospitalMstVO = ControllerUTIL.getHospitalVO(request);
	        if (hospitalMstVO.getHospitalTypeCode() == null) {
	            throw new Exception("Hospital type not found");
	        }

	        String searchTerm = request.getParameter("keyword");
	        if (searchTerm != null && !searchTerm.trim().isEmpty()) {
	            List<DrugVO> storeDrugs = (List<DrugVO>) request.getSession().getAttribute("STORE_DRUG");
	            if (storeDrugs != null) {
	            	
	            	if(debug==true) {
	            		searchedDrugListStore.addAll(storeDrugs.stream()
	                        .filter(drug -> Arrays.stream(searchTerm.split(" "))
	                                .allMatch(keyword -> drug.getDrugBrandName().toLowerCase().contains(keyword.toLowerCase())))
	                        .collect(Collectors.toList()));
	            		System.out.println("searchedDrugListStore size>>>"+ searchedDrugListStore.size());
	            	}
	            	searchedDrugList.addAll(storeDrugs.stream()
	                        .filter(drug -> Arrays.stream(searchTerm.split(" "))
	                                .allMatch(keyword -> drug.getDrugBrandName().toLowerCase().contains(keyword.toLowerCase())))
	                        .collect(Collectors.toList()));
	              
	            }

	            String date = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
	            DrugData unregisteredDrugData = UnregisteredDrugDataManager.getInstance()
	                    .getDrugDataObj("unregistereddrug_" + hospitalMstVO.getHospitalTypeCode() + date);

	            if (unregisteredDrugData != null && unregisteredDrugData.lstData != null) {
	                List<DrugVO> unauthorizedDrugs = new ArrayList<>(unregisteredDrugData.lstData);
	                
	                if(debug==true) {
	                	searchedDrugListUnregistered.addAll(unauthorizedDrugs.stream()
	                        .filter(drug -> Arrays.stream(searchTerm.split(" "))
	                                .allMatch(keyword -> drug.getDrugBrandName().toLowerCase().contains(keyword.toLowerCase())))
	                        .collect(Collectors.toList()));
	                	System.out.println("searchedDrugListUnregistered size>>>"+ searchedDrugListUnregistered.size());
	                }
	                searchedDrugList.addAll(unauthorizedDrugs.stream()
	                        .filter(drug -> Arrays.stream(searchTerm.split(" "))
	                                .allMatch(keyword -> drug.getDrugBrandName().toLowerCase().contains(keyword.toLowerCase())))
	                        .collect(Collectors.toList()));
	                
	            }
	            
	            if (!searchedDrugList.isEmpty()) {
	            	  if(debug==true) {
	            		  System.out.println("Total searchedDrugListStore+searchedDrugListUnregistered size>>>"+ (searchedDrugListStore.size()+searchedDrugListUnregistered.size()));
	            		  System.out.println("searchedDrugList size>>>"+ searchedDrugList.size());
	            	  }
	            	
	            	List<DrugVO> finalSearchedDrugList = searchedDrugList.stream()
	            		    .sorted(Comparator
	            		        .comparing((DrugVO drug) -> {
	            		            try {
	            		                return Integer.parseInt(drug.getDrugQuan()) > 0 ? 0 : 1;
	            		            } catch (NumberFormatException e) {
	            		                return 1;
	            		            }
	            		        })
	            		        .thenComparing((DrugVO drug) -> 
	            		            drug.getDrugBrandName() != null &&
	            		            drug.getDrugBrandName().toLowerCase().startsWith(searchTerm.toLowerCase()) ? 0 : 1)
	            		        .thenComparingInt(drug -> 
	            		            drug.getDrugBrandName() != null ? 
	            		                drug.getDrugBrandName().length() : Integer.MAX_VALUE)
	            		        .thenComparing(drug -> 
	            		            drug.getDrugBrandName() != null ? 
	            		                drug.getDrugBrandName().toLowerCase() : ""))
	            		    .collect(Collectors.toList());
	            	  if(debug==true) {
	            		  	System.out.println("finalSearchedDrugList size>>>"+ finalSearchedDrugList.size());
	            	  }
	            	  
	            	  Map<String, DrugVO> uniqueDrugMap = new LinkedHashMap<>();

	            	  for (DrugVO drug : finalSearchedDrugList) {
	            	      String drugId = drug.getDrugId();
	            	      String drugBrandId = drug.getDrugBrandId();
	            	      String key=drugId+"-"+drugBrandId;
	            	      boolean isBetter = false;

	            	      if (!uniqueDrugMap.containsKey(key)) {
	            	          isBetter = true;
	            	      } else {
	            	          try {
	            	              int existingQty = Integer.parseInt(uniqueDrugMap.get(key).getDrugQuan());
	            	              int currentQty = Integer.parseInt(drug.getDrugQuan());
	            	              if (currentQty > 0 && existingQty <= 0) {
	            	                  isBetter = true;
	            	              }
	            	          } catch (NumberFormatException e) {
	            	              // Prefer current if existing quantity is invalid or non-numeric
	            	              isBetter = true;
	            	          }
	            	      }

	            	      if (isBetter) {
	            	          uniqueDrugMap.put(key, drug);
	            	      }
	            	  }

	            	  finalSearchedDrugList = new ArrayList<>(uniqueDrugMap.values());
	            	  if(debug==true) {
	            		  	System.out.println("finalSearchedDrugList size befor Gson>>>"+ finalSearchedDrugList.size());
	            	  }
	                json = new Gson().toJson(finalSearchedDrugList);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        writeInResponse(response, json, true);
	    }
	}
	
}
