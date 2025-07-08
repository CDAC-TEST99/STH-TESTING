package new_opd.transaction.controller.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.sql.ResultSetMetaData;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import org.json.JSONArray;
import org.json.JSONObject;

import hisglobal.config.HISConfig;
import hisglobal.presentation.ControllerDATA;
import hisglobal.vo.UserVO;
import new_opd.bo.DoctorDeskBO;
import new_opd.transaction.controller.fb.OPDReferralFB;
import new_opd.vo.OPDReferralVO;

public class OpdReferralDATA extends ControllerDATA {


	public static void getExternalRefralConfiguration(HttpServletRequest request, HttpServletResponse response,
			OPDReferralFB formBean) {
		String json = null;
		String HsopitalCode = (String) request.getSession().getAttribute("HOSPITAL_CODE");
		OPDReferralVO vo = new OPDReferralVO();
		vo.setStrHospitalCode(HsopitalCode);
		vo.setMode("7");
		json = (String) request.getSession().getAttribute("ExternalRefralConfiguration");
		if (json == null) {
			if (vo.getStrHospitalCode() == null) {
				vo.setStrHospitalCode("0");
			}
			DoctorDeskBO bo = new DoctorDeskBO();
			bo.getReferalLists(vo);
			if (vo != null && vo.getStrExternalHospitalweb() != null && vo.getStrExternalHospitalweb().size() > 0) {

				try {
					json = printJSONObject(vo.getStrExternalHospitalweb());
				} catch (Exception e) {
					e.printStackTrace();
				} finally {

					vo = null;
				}
				if (json != null && !json.equals("[]"))
					request.getSession().setAttribute("ExternalRefralConfiguration", json);

			}
		}
		writeInResponse(response, json, true);

	}
	public static void populatestrExternalDepartmentList(HttpServletRequest request, HttpServletResponse response,
			OPDReferralFB formBean) {

		String SeatId = (String) request.getSession().getAttribute("SEATID");
		
		String HsopitalCode = (String) request.getSession().getAttribute("HOSPITAL_CODE");
		String json = null;
		OPDReferralVO vo = new OPDReferralVO();
		vo.setStrHospitalCode(HsopitalCode);
		vo.setStrSeatId(SeatId);
		vo.setMode("5");
		json = (String) request.getSession().getAttribute("strExternalDepartment");
		if (json == null) {
			if (vo.getStrHospitalCode() == null) {
				vo.setStrHospitalCode("0");
			}
			DoctorDeskBO bo = new DoctorDeskBO();
			bo.getReferalLists(vo);
			if (vo != null && vo.getStrExternalHospitalweb() != null && vo.getStrExternalHospitalweb().size() > 0) {

				try {
					json = printJSONObject(vo.getStrExternalHospitalweb());
				} catch (Exception e) {
					e.printStackTrace();
				} finally {

					vo = null;
				}
				if (json != null && !json.equals("[]"))
					request.getSession().setAttribute("strExternalDepartment", json);

			}
		}
		writeInResponse(response, json, true);

	}

	public static void populateExternalInvestigation(HttpServletRequest request, HttpServletResponse response,
			OPDReferralFB formBean) {

		String SeatId = (String) request.getSession().getAttribute("SEATID");
		String HsopitalCode = (String) request.getSession().getAttribute("HOSPITAL_CODE");
		String json = null;
		OPDReferralVO vo = new OPDReferralVO();
		vo.setStrHospitalCode(HsopitalCode);
		vo.setStrSeatId(SeatId);
		vo.setMode("3");
		json = (String) request.getSession().getAttribute("ExternalInvestigation");
		if (json == null) {
			if (vo.getStrHospitalCode() == null) {
				vo.setStrHospitalCode("0");
			}
			DoctorDeskBO bo = new DoctorDeskBO();
			bo.getReferalLists(vo);
			if (vo != null && vo.getStrExternalHospitalweb() != null && vo.getStrExternalHospitalweb().size() > 0) {

				try {
					json = printJSONObject(vo.getStrExternalHospitalweb());
				} catch (Exception e) {
					e.printStackTrace();
				} finally {

					vo = null;
				}
				if (json != null && !json.equals("[]"))
					request.getSession().setAttribute("ExternalInvestigation", json);

			}
		}
		writeInResponse(response, json, true);

	}

	public static void populateExternalProcedure(HttpServletRequest request, HttpServletResponse response,
			OPDReferralFB formBean) {

		String SeatId = (String) request.getSession().getAttribute("SEATID");
		String HsopitalCode = (String) request.getSession().getAttribute("HOSPITAL_CODE");
		String json = null;
		OPDReferralVO vo = new OPDReferralVO();
		vo.setStrHospitalCode(HsopitalCode);
		vo.setStrSeatId(SeatId);
		vo.setMode("4");
		json = (String) request.getSession().getAttribute("ExternalProcedure");
		if (json == null) {
			if (vo.getStrHospitalCode() == null) {
				vo.setStrHospitalCode("0");
			}
			DoctorDeskBO bo = new DoctorDeskBO();
			bo.getReferalLists(vo);
			if (vo != null && vo.getStrExternalHospitalweb() != null && vo.getStrExternalHospitalweb().size() > 0) {

				try {
					json = printJSONObject(vo.getStrExternalHospitalweb());
				} catch (Exception e) {
					e.printStackTrace();
				} finally {

					vo = null;
				}
				if (json != null && !json.equals("[]"))
					request.getSession().setAttribute("ExternalProcedure", json);

			}
		}
		writeInResponse(response, json, true);

	}

	public static void populateExternalFollowup(HttpServletRequest request, HttpServletResponse response,
			OPDReferralFB formBean) {
		String SeatId = (String) request.getSession().getAttribute("SEATID");
		String HsopitalCode = (String) request.getSession().getAttribute("HOSPITAL_CODE");
		String json = null;
		OPDReferralVO vo = new OPDReferralVO();
		vo.setStrHospitalCode(HsopitalCode);
		vo.setStrSeatId(SeatId);
		vo.setMode("6");
		json = (String) request.getSession().getAttribute("ExternalFollowup");
		if (json == null) {
			if (vo.getStrHospitalCode() == null) {
				vo.setStrHospitalCode("0");
			}
			DoctorDeskBO bo = new DoctorDeskBO();
			bo.getReferalLists(vo);
			if (vo != null && vo.getStrExternalHospitalweb() != null && vo.getStrExternalHospitalweb().size() > 0) {

				try {
					json = printJSONObject(vo.getStrExternalHospitalweb());
				} catch (Exception e) {
					e.printStackTrace();
				} finally {

					vo = null;
				}
				if (json != null && !json.equals("[]"))
					request.getSession().setAttribute("ExternalFollowup", json);

			}
		}
		writeInResponse(response, json, true);

	}

	public static void populateEndorsementHospital(HttpServletRequest request, HttpServletResponse response) {
		String HsopitalCode = (String) request.getSession().getAttribute("HOSPITAL_CODE");
		Map<String, String> ReffralDeptCmb = new LinkedHashMap<String, String>();
		UserVO userVO = (UserVO) request.getSession().getAttribute(HISConfig.USER_VO);
		String SeatId = (String) request.getSession().getAttribute("SEATID");
		String json = null;
		OPDReferralVO vo = new OPDReferralVO();
		json = (String) request.getSession().getAttribute("strEndorsementHospital");
		if (json == null) {
			if (HsopitalCode != null)
				vo.setStrHospitalCode(HsopitalCode);
			else
				vo.setStrHospitalCode("0");
			vo.setStrSeatId(SeatId);
			vo.setMode("1");
			DoctorDeskBO bo = new DoctorDeskBO();
			bo.getReferalLists(vo);
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
				request.getSession().setAttribute("strEndorsementHospital", json);
		}

		writeInResponse(response, json, true);

	}

	public static void populateEndorsementDepartment(HttpServletRequest request, HttpServletResponse response,
			OPDReferralFB formBean) {

		String SeatId = (String) request.getSession().getAttribute("SEATID");
		String HsopitalCode = (String) request.getSession().getAttribute("HOSPITAL_CODE");
		String json = null;
		OPDReferralVO vo = new OPDReferralVO();
		vo.setStrHospitalCode(HsopitalCode);
		vo.setStrSeatId(SeatId);
		vo.setMode("2");
		json = (String) request.getSession().getAttribute("strEndorsementDepartment");
		if (json == null) {
			if (vo.getStrHospitalCode() == null) {
				vo.setStrHospitalCode("0");
			}
			DoctorDeskBO bo = new DoctorDeskBO();
			bo.getReferalLists(vo);
			if (vo != null && vo.getStrExternalHospitalweb() != null && vo.getStrExternalHospitalweb().size() > 0) {

				try {
					json = printJSONObject(vo.getStrExternalHospitalweb());
				} catch (Exception e) {
					e.printStackTrace();
				} finally {

					vo = null;
				}
				if (json != null && !json.equals("[]"))
					request.getSession().setAttribute("strEndorsementDepartment", json);

			}
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
	
	public static void populateEndorsementCity(HttpServletRequest request, HttpServletResponse response) {
		String HsopitalCode = (String) request.getSession().getAttribute("HOSPITAL_CODE");
		Map<String, String> ReffralDeptCmb = new LinkedHashMap<String, String>();
		UserVO userVO = (UserVO) request.getSession().getAttribute(HISConfig.USER_VO);
		String SeatId = (String) request.getSession().getAttribute("SEATID");
		String json = null;
		OPDReferralVO vo = new OPDReferralVO();
		json = (String) request.getSession().getAttribute("strEndorsementCity");
		if (json == null) {
			if (HsopitalCode != null)
				vo.setStrHospitalCode(HsopitalCode);
			else
				vo.setStrHospitalCode("0");
			vo.setStrSeatId(SeatId);
			vo.setMode("8");
			DoctorDeskBO bo = new DoctorDeskBO();
			bo.getReferalLists(vo);
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
				request.getSession().setAttribute("strEndorsementCity", json);
		}

		writeInResponse(response, json, true);

	}
	
}
