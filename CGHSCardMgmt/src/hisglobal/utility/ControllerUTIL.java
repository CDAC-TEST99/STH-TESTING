/**********************************************************
 Project:	   CDWH	
 File:         ControllerUTIL.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package hisglobal.utility;

import hisglobal.hisconfig.Config;
import hisglobal.vo.TransactionVO;
import hisglobal.vo.UserVO;

import javax.servlet.http.HttpServletRequest;


// TODO: Auto-generated Javadoc
/**
 * The Class ControllerUTIL.
 */
public class ControllerUTIL {

	/**
	 * Instantiates a new controller util.
	 * 
	 * @roseuid 45C2F539034B
	 */
	public ControllerUTIL() {
	}

	
	/**
	 * Gets the user vo.
	 * 
	 * @param request
	 *            the request
	 * @return the user vo
	 */
	public static UserVO getUserVO(HttpServletRequest request) {
		UserVO userVO = (UserVO) request.getAttribute(Config.USER_VO);
		if (userVO == null) {
			userVO = new UserVO();

			// ////////////getting seat id from session and setting it to
			// uservo///////
			String seatID = (String) request.getAttribute(Config.SEAT_ID);
			if (seatID == null) {
				seatID = (String) request.getSession().getAttribute(
						Config.SEAT_ID);
				if (seatID == null)
					seatID = request.getParameter(Config.SEAT_ID);
			}
			userVO.setSeatId(seatID);
			request.getSession().setAttribute(Config.USER_VO, userVO);
			// if (seatID == null) userVO.setSeatId("10008");
			if (seatID == null)
				userVO.setSeatId("10001");

			// /////////////Getting HOSPITAL_ID from session and setting it to
			// uservo///////
			String hospitaCode = (String) request
					.getAttribute(Config.HOSPITAL_CODE);
			if (hospitaCode == null) {
				hospitaCode = (String) request.getSession().getAttribute(
						Config.HOSPITAL_CODE);
				if (hospitaCode == null)
					hospitaCode = request.getParameter(Config.HOSPITAL_CODE);
			}
			userVO.setHospitalCode(hospitaCode);
			
			String userName = (String) request
					.getAttribute(Config.USER_FULL_NAME);
			if (userName == null) {
				userName = (String) request.getSession().getAttribute(
						Config.USER_FULL_NAME);
				//System.out.println("username2++++++"+userName);
				if (userName == null)
					userName = request.getParameter(Config.USER_FULL_NAME);
				//System.out.println("usernam1e++++++"+userName);
			}
			userVO.setUserName(userName);
			//System.out.println("username++++++"+userName);

			request.getSession().setAttribute(Config.USER_VO, userVO);
			if (hospitaCode == null)
				userVO.setHospitalCode(Config.HOSPITAL_CODE_VALUE);

			// /////////////IP_ADDRESS from session and setting it to
			// uservo///////
			String ipAddress = (String) request.getAttribute(Config.IP_ADDRESS);
			if (ipAddress == null) {
				ipAddress = (String) request.getSession().getAttribute(
						Config.IP_ADDRESS);
				if (ipAddress == null)
					ipAddress = request.getParameter(Config.IP_ADDRESS);
			}
			userVO.setIpAddress(ipAddress);
			request.getSession().setAttribute(Config.USER_VO, userVO);

			// Getting User seat id from session and place into UserVO
			// ***************
			String userSeatId = (String) request
					.getAttribute(Config.USER_SEAT_ID);
			if (userSeatId == null) {
				userSeatId = (String) request.getSession().getAttribute(
						Config.USER_SEAT_ID);
				if (userSeatId == null)
					userSeatId = request.getParameter(Config.USER_SEAT_ID);
			}
			userVO.setUserSeatId(userSeatId);
			request.getSession().setAttribute(Config.USER_VO, userVO);
			if (userSeatId == null)
				userVO.setUserSeatId("10003");

			// Get Employee ID from session and place into User VO
			// *********************
			String userEmpId = (String) request
					.getAttribute(Config.USER_EMP_ID);
			if (userEmpId == null) {
				userEmpId = (String) request.getSession().getAttribute(
						Config.USER_EMP_ID);
				if (userEmpId == null)
					userEmpId = request.getParameter(Config.USER_EMP_ID);
			}
			userVO.setUserEmpID(userEmpId);
			request.getSession().setAttribute(Config.USER_VO, userVO);
		}
		TransactionVO transactionVO = userVO.getTransactionInfo();
		if (transactionVO == null) {
			transactionVO = new TransactionVO();
			userVO.setTransactionInfo(transactionVO);
		}
		String menuID = (String) request.getSession().getAttribute(
				Config.MENU_ID);
		if (menuID == null)
			menuID = "10000";
		transactionVO.setMenuID(menuID);

		return userVO;

	}

	

}
