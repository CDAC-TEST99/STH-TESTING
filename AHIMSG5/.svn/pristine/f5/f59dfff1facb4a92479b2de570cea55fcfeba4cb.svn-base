package usermgmt.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import hisglobal.config.HISConfig;
import hisglobal.exceptions.HISApplicationExecutionException;
import hisglobal.exceptions.HISDataAccessException;
import hisglobal.exceptions.HISException;
import hisglobal.exceptions.HISRecordNotFoundException;
import hisglobal.security.SecureHashAlgorithm;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.Entry;
import hisglobal.vo.CommonAlertVO;
import hissso.config.HISSSOConfig;
import usermgmt.config.UserManagementConfig;
import usermgmt.dao.UserManagementDAO;
import vo.hissso.LoginVO;
import vo.usermgmt.HolidayMasterVO;
import vo.usermgmt.HospitalMasterVO;
import vo.usermgmt.MenuMasterVO;
import vo.usermgmt.UserLoginLogVO;
import vo.usermgmt.UserMasterVO;
import vo.usermgmt.UserSeatVO;

public class UserManagementBO {
	/**
	 * Getting User Detail
	 * 
	 * @param voLogin
	 * @return voUser
	 * @author Pragya Sharma 07-Jan-2014
	 */
	public UserMasterVO getUserValidLoginDetail(LoginVO voLoginUser_p) {
		UserMasterVO voUserFinal = null;
		HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
		String _isLocked = "0";
		 		
		try {
			UserManagementDAO daoUserMgmt = new UserManagementDAO();

			UserMasterVO voUser = new UserMasterVO();
			BeanUtils.copyProperties(voUser, voLoginUser_p);

			// Fetching User Detail based on User Name
			List<UserMasterVO> lstUserMasterVO = daoUserMgmt.getUserDetail(hisDAO, "1", voUser);
			if (lstUserMasterVO == null || lstUserMasterVO.size() <= 0) {
				// If User Detail not found, No Action, returnError message
				voUser.setVarLoggedIn(HISConfig.NO);
				voUser.setVarLoginMessage("Invalid User Name/Password!");
				voUserFinal = voUser;
			} else {
				// If found, first check for Valid User
				for (UserMasterVO voUserTmp : lstUserMasterVO) {
					 
					
					  String strHashedPassword = SecureHashAlgorithm
					  .SHA2(voUserTmp.getVarPassword() + voLoginUser_p.getVarLoginSessionSalt());
					 
					
					//  wrong password
					// attempt is infinite and when user enters correct password, user locked
					// message displays
					if (voUserTmp.getVarLock().equals("1"))
						_isLocked = "1";
					// End
					
				 
					 

					if (voLoginUser_p.getVarPassword().equals(strHashedPassword)) {
						voUserFinal = voUserTmp;
						break;
					}
				}

				if (voUserFinal == null) {
					// If Not Valid User
					// set Status, return Error Message
					voUser.setVarLoggedIn(HISConfig.NO);
					voUser.setVarLoginMessage("Invalid User Name/Password!");
					if (_isLocked.equals("1"))
						voUser.setVarLoginMessage("User is Locked!! Contact System Administrator!");
					
					
					
					voUserFinal = voUser;

					// Insert for Unsuccessful Login Detail
					UserLoginLogVO voUserUnsuccessLoginLog = new UserLoginLogVO();
					BeanUtils.copyProperties(voUserUnsuccessLoginLog, voLoginUser_p);

					daoUserMgmt.dmlUserLoginLog(hisDAO, "1", voUserUnsuccessLoginLog);

					// Getting Unsuccessful Count
					List<UserLoginLogVO> lstUnsuccessLoginLog = daoUserMgmt.getUserLoginLog(hisDAO, "1",
							voUserUnsuccessLoginLog, null, null);
					int nUnsuccessLoginCount = 0;
					if (lstUnsuccessLoginLog != null && lstUnsuccessLoginLog.size() > 0
							&& lstUnsuccessLoginLog.get(0) != null) {
						UserLoginLogVO voLog = lstUnsuccessLoginLog.get(0);
						if (voLog != null && voLog.getVarUnsuccessfulCount() != null) {
							nUnsuccessLoginCount = Integer.parseInt(voLog.getVarUnsuccessfulCount());
						}
					}

					// Check for Max Unsuccessful Login Count exceeds
					if (nUnsuccessLoginCount >= HISSSOConfig.LOGIN_LOCK_AFTER_UNSUCCESSFUL_LOGIN_COUNT) {
						// If yes,
						// Lock User with Given User Name and IP Address
						daoUserMgmt.dmlUserDetail(hisDAO, "1", voUserFinal);

					 
					}
				} else {
				 
					// Check Logic for Locked User
					if (voUserFinal.getVarLock().equals(HISConfig.YES)) {
						voUserFinal.setVarLoggedIn(HISConfig.NO);
						voUserFinal.setVarLoginMessage("User is Locked!! Contact System Administrator!");
					}else if(voUserFinal.getVarDefaultPasswordChange().equals("0")){
						
						voUserFinal.setVarLoginMessage("Change Password");
												
						
					} else {
						// --- Check user already logged in somewhere else

						voUserFinal.setVarLoggedIn(HISConfig.YES);

						// Getting Default Page, District etc inside UserVO

						// Getting Hospital Detail
						
						if(!"0".equals(voUserFinal.getVarHospitalCode())) {
							HospitalMasterVO voHospital = new HospitalMasterVO();
							BeanUtils.copyProperties(voHospital, voUserFinal);
							List<HospitalMasterVO> lstHospital = daoUserMgmt.getHospitalDetail(hisDAO, "1", voHospital);
							voHospital = lstHospital.get(0);
							voUserFinal.setVoHospital(voHospital);
						}
						
						
					List<UserSeatVO> userSeatsDtl =	daoUserMgmt.getUserSeatDetail(hisDAO, "1", voUserFinal.getVarHospitalCode(), voUserFinal.getVarUserId(), voUserFinal.getVarSeatId());
					voUserFinal.setUserSeatsDtl(userSeatsDtl);
					
					
					}
				}
			}
		} catch (HISRecordNotFoundException e) {
			throw new HISRecordNotFoundException(
					"UserManagementBO.getUserValidLoginDetail()::HISRecordNotFoundException -> " + e.getMessage());
		} catch (HISDataAccessException e) {
			throw new HISDataAccessException(
					"UserManagementBO.getUserValidLoginDetail()::HISDataAccessException -> " + e.getMessage());
		} catch (HISApplicationExecutionException e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.getUserValidLoginDetail()::HISApplicationExecutionException -> "
							+ e.getMessage());
		} catch (HISException e) {
			throw new HISException("UserManagementBO.getUserValidLoginDetail()::HISException -> " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new HISApplicationExecutionException(
					"UserManagementBO.getUserValidLoginDetail()::HISApplicationExecutionException -> "
							+ e.getMessage());
		} finally {
			if (hisDAO != null) {
				hisDAO.free();
				hisDAO = null;
			}
		}
		return voUserFinal;
	}
	
	public List<HospitalMasterVO> getHospitalVos(String hospitalCode) throws Exception{
		
		UserManagementDAO daoUserMgmt = null;
		HisDAO hisDAO = null;
		HospitalMasterVO voHospital = new HospitalMasterVO();
		List<HospitalMasterVO> lstHospital = null;
		try {
		  daoUserMgmt = new UserManagementDAO();
		  hisDAO = new HisDAO("UserManagment", "UserManagementBO");
		
		voHospital.setVarHospitalCode(hospitalCode);
		 lstHospital = daoUserMgmt.getHospitalDetail(hisDAO, "1", voHospital);
		
	} catch (Exception e) {
		e.printStackTrace();
		throw new HISApplicationExecutionException(
				"UserManagementBO.getUserValidLoginDetail()::HISApplicationExecutionException -> "
						+ e.getMessage());
	} finally {
		if (hisDAO != null) {
			hisDAO.free();
			hisDAO = null;
		}
		
	}
		
		return lstHospital;
		
	}
	
	public UserMasterVO getBenValidLoginDetail(LoginVO voLoginUser_p) {
		UserMasterVO voUserFinal = null;
		HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
		String _isLocked = "0";
		try {
			UserManagementDAO daoUserMgmt = new UserManagementDAO();

			UserMasterVO voUser = new UserMasterVO();
			BeanUtils.copyProperties(voUser, voLoginUser_p);

			// Fetching User Detail based on User Name
			List<UserMasterVO> lstUserMasterVO = daoUserMgmt.getBenDetail(hisDAO, "1", voUser);
			if (lstUserMasterVO == null || lstUserMasterVO.size() <= 0) {
				// If User Detail not found, No Action, returnError message
				voUser.setVarLoggedIn(HISConfig.NO);
				voUser.setVarLoginMessage("Invalid User Name/Password!");
				voUserFinal = voUser;
			} else {
				// If found, first check for Valid User
				for (UserMasterVO voUserTmp : lstUserMasterVO) {
					 
					
					  String strHashedPassword = SecureHashAlgorithm
					  .SHA2(voUserTmp.getVarPassword() + voLoginUser_p.getVarLoginSessionSalt());
					 
					
					//  wrong password
					// attempt is infinite and when user enters correct password, user locked
					// message displays
					if (voUserTmp.getVarLock().equals("1"))
						_isLocked = "1";
					// End
					
				 
					 

					if (voLoginUser_p.getVarPassword().equals(strHashedPassword)) { // checking if password is correct 
						voUserFinal = voUserTmp;
						break;
					}
				}

				if (voUserFinal == null) {									// if a valid user is not found or the password is incorrect
					// If Not Valid User
					// set Status, return Error Message
					voUser.setVarLoggedIn(HISConfig.NO);
					voUser.setVarLoginMessage("Invalid User Name/Password!");
					if (_isLocked.equals("1"))
						voUser.setVarLoginMessage("User is Locked!! Contact System Administrator!");
					
					
					
					voUserFinal = voUser;

					// Insert for Unsuccessful Login Detail
					UserLoginLogVO voUserUnsuccessLoginLog = new UserLoginLogVO();
					BeanUtils.copyProperties(voUserUnsuccessLoginLog, voLoginUser_p);

					daoUserMgmt.dmlBenLoginLog(hisDAO, "1", voUserUnsuccessLoginLog);

					// Getting Unsuccessful Count
					List<UserLoginLogVO> lstUnsuccessLoginLog = daoUserMgmt.getBenLoginLog(hisDAO, "1",
							voUserUnsuccessLoginLog, null, null);
					int nUnsuccessLoginCount = 0;
					if (lstUnsuccessLoginLog != null && lstUnsuccessLoginLog.size() > 0
							&& lstUnsuccessLoginLog.get(0) != null) {
						UserLoginLogVO voLog = lstUnsuccessLoginLog.get(0);
						if (voLog != null && voLog.getVarUnsuccessfulCount() != null) {
							nUnsuccessLoginCount = Integer.parseInt(voLog.getVarUnsuccessfulCount());
						}
					}

					// Check for Max Unsuccessful Login Count exceeds
					if (nUnsuccessLoginCount >= HISSSOConfig.LOGIN_LOCK_AFTER_UNSUCCESSFUL_LOGIN_COUNT) {
						// If yes,
						// Lock User with Given User Name and IP Address
						daoUserMgmt.dmlBenDetail(hisDAO, "1", voUserFinal);

					 
					}
				} else {											// if a valid user is found or the password is correct
				 
					// Check Logic for Locked User
					if (voUserFinal.getVarLock().equals(HISConfig.YES)) {					// check if the user is locked or not?
						voUserFinal.setVarLoggedIn(HISConfig.NO);
						voUserFinal.setVarLoginMessage("User is Locked!! Contact System Administrator!");
					}
					else if(voUserFinal.getVarDefaultPasswordChange().equals("0")){		// check if password change is required in the added flag
						voUserFinal.setVarLoginMessage("Change Password");			// if the flag is 0---> reset password using first login page
						voUser.setVarLoggedIn(HISConfig.NO);
					}
					else {
						// --- Check user already logged in somewhere else

						voUserFinal.setVarLoggedIn(HISConfig.YES);

						voUserFinal.setVarIsBen("1");
						
						// Getting Default Page, District etc inside UserVO

						// Getting Hospital Detail
						
						if(!"0".equals(voUserFinal.getVarHospitalCode())) {
							HospitalMasterVO voHospital = new HospitalMasterVO();
							BeanUtils.copyProperties(voHospital, voUserFinal);
							List<HospitalMasterVO> lstHospital = daoUserMgmt.getHospitalDetail(hisDAO, "1", voHospital);
							voHospital = lstHospital.get(0);
							voUserFinal.setVoHospital(voHospital);
						}
						
						
					List<UserSeatVO> userSeatsDtl =	daoUserMgmt.getBenSeatDetail(hisDAO, "1", voUserFinal.getVarHospitalCode(), voUserFinal.getVarUserId(), voUserFinal.getVarSeatId());
					voUserFinal.setUserSeatsDtl(userSeatsDtl);
					
					
					}
				}
			}
		} catch (HISRecordNotFoundException e) {
			throw new HISRecordNotFoundException(
					"UserManagementBO.getUserValidLoginDetail()::HISRecordNotFoundException -> " + e.getMessage());
		} catch (HISDataAccessException e) {
			throw new HISDataAccessException(
					"UserManagementBO.getUserValidLoginDetail()::HISDataAccessException -> " + e.getMessage());
		} catch (HISApplicationExecutionException e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.getUserValidLoginDetail()::HISApplicationExecutionException -> "
							+ e.getMessage());
		} catch (HISException e) {
			throw new HISException("UserManagementBO.getUserValidLoginDetail()::HISException -> " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new HISApplicationExecutionException(
					"UserManagementBO.getUserValidLoginDetail()::HISApplicationExecutionException -> "
							+ e.getMessage());
		} finally {
			if (hisDAO != null) {
				hisDAO.free();
				hisDAO = null;
			}
		}
		return voUserFinal;
	}
	
	
	public UserMasterVO getmBenValidLoginDetail(LoginVO voLoginUser_p) {
  		UserMasterVO voUserFinal = null;
		HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
		String _isLocked = "0";
		try {
			UserManagementDAO daoUserMgmt = new UserManagementDAO();

			UserMasterVO voUser = new UserMasterVO();
			BeanUtils.copyProperties(voUser, voLoginUser_p);

			voUser.setVarMobileNumber(voLoginUser_p.getVarMobileNumber());
			voUser.setVarUserName(voLoginUser_p.getVarUserName() );
			
			
			// Fetching User Detail based on User Name
			List<UserMasterVO> lstUserMasterVO = daoUserMgmt.getmBenDetail(hisDAO, "1", voUser);
			if (lstUserMasterVO == null || lstUserMasterVO.size() <= 0 && lstUserMasterVO.size() > 1) {
				// If User Detail not found, No Action, returnError message
				voUser.setVarLoggedIn(HISConfig.NO);
				voUser.setVarLoginMessage("Invalid User, Please Try with Valid One!");
				voUserFinal = voUser;
			} else {
				// If found, first check for Valid User

				voUserFinal = lstUserMasterVO.get(0);
				

				if (voUserFinal == null) {
					// If Not Valid User
					// set Status, return Error Message
					voUser.setVarLoggedIn(HISConfig.NO);
					voUser.setVarLoginMessage("Invalid User Name/Password!");
					if (_isLocked.equals("1"))
						voUser.setVarLoginMessage("User is Locked!! Contact System Administrator!");
					
					
					
					voUserFinal = voUser;

					// Insert for Unsuccessful Login Detail
					UserLoginLogVO voUserUnsuccessLoginLog = new UserLoginLogVO();
					BeanUtils.copyProperties(voUserUnsuccessLoginLog, voLoginUser_p);

					daoUserMgmt.dmlUserLoginLog(hisDAO, "1", voUserUnsuccessLoginLog);

					// Getting Unsuccessful Count
					List<UserLoginLogVO> lstUnsuccessLoginLog = daoUserMgmt.getUserLoginLog(hisDAO, "1",
							voUserUnsuccessLoginLog, null, null);
					int nUnsuccessLoginCount = 0;
					if (lstUnsuccessLoginLog != null && lstUnsuccessLoginLog.size() > 0
							&& lstUnsuccessLoginLog.get(0) != null) {
						UserLoginLogVO voLog = lstUnsuccessLoginLog.get(0);
						if (voLog != null && voLog.getVarUnsuccessfulCount() != null) {
							nUnsuccessLoginCount = Integer.parseInt(voLog.getVarUnsuccessfulCount());
						}
					}

					// Check for Max Unsuccessful Login Count exceeds
					if (nUnsuccessLoginCount >= HISSSOConfig.LOGIN_LOCK_AFTER_UNSUCCESSFUL_LOGIN_COUNT) {
						// If yes,
						// Lock User with Given User Name and IP Address
						daoUserMgmt.dmlUserDetail(hisDAO, "1", voUserFinal);

						// Update Unsuccessful Login Log after Lock
						// Here deleting all Log of User ???
						// loginObj.updateUnsuccessfulLoginLog(request.getParameter("uid"));
					}
				} else {
					// If Valid User,
					// Removing Sensitive Information like Password
					// voUserFinal.setVarPassword(null);
					// voUserFinal.setVarHintAnswer(null);

					// Check for Other Logic based on IP Address/Location
					// Seat Wise IPs Addresses
					// Hospital Wise IP Addresses
					// If it will not found in defined range, then return "Proper Message" set
					// status
					// Seat Association Check
					// INVALID_IP_ADDRESS User Is Not Allowed To Login From This System
					// NO_SEAT_ASSOCIATED
					// voUserFinal.setVarLoggedIn(HISConfig.NO);
					// voUserFinal.setVarLoginMessage("User Not Allowed To Login From this
					// System!");

					// Check Logic for Locked User
					if (voUserFinal.getVarLock().equals(HISConfig.YES)) {
						voUserFinal.setVarLoggedIn(HISConfig.NO);
						voUserFinal.setVarLoginMessage("User is Locked!! Contact System Administrator!");
					} else {
						// --- Check user already logged in somewhere else

						voUserFinal.setVarLoggedIn(HISConfig.YES);

						voUserFinal.setVarIsBen("1");
						
						// Getting Default Page, District etc inside UserVO

						// Getting Hospital Detail
						
						if(!"0".equals(voUserFinal.getVarHospitalCode())) {
							HospitalMasterVO voHospital = new HospitalMasterVO();
							BeanUtils.copyProperties(voHospital, voUserFinal);
							List<HospitalMasterVO> lstHospital = daoUserMgmt.getHospitalDetail(hisDAO, "1", voHospital);
							voHospital = lstHospital.get(0);
							voUserFinal.setVoHospital(voHospital);
						}
						
						 						
						List<UserSeatVO> userSeatsDtl =	daoUserMgmt.getBenSeatDetail(hisDAO, "1", voUserFinal.getVarHospitalCode(), voUserFinal.getVarUserId(), voUserFinal.getVarSeatId());
						voUserFinal.setUserSeatsDtl(userSeatsDtl);
						
						
						
					}
				}
			}
		} catch (HISRecordNotFoundException e) {
			throw new HISRecordNotFoundException(
					"UserManagementBO.getUserValidLoginDetail()::HISRecordNotFoundException -> " + e.getMessage());
		} catch (HISDataAccessException e) {
			throw new HISDataAccessException(
					"UserManagementBO.getUserValidLoginDetail()::HISDataAccessException -> " + e.getMessage());
		} catch (HISApplicationExecutionException e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.getUserValidLoginDetail()::HISApplicationExecutionException -> "
							+ e.getMessage());
		} catch (HISException e) {
			throw new HISException("UserManagementBO.getUserValidLoginDetail()::HISException -> " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new HISApplicationExecutionException(
					"UserManagementBO.getUserValidLoginDetail()::HISApplicationExecutionException -> "
							+ e.getMessage());
		} finally {
			if (hisDAO != null) {
				hisDAO.free();
				hisDAO = null;
			}
		}
		return voUserFinal;
	}
	
	
	
	public UserMasterVO getmUserValidLoginDetail(LoginVO voLoginUser_p) {
  		UserMasterVO voUserFinal = null;
		HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
		String _isLocked = "0";
		try {
			UserManagementDAO daoUserMgmt = new UserManagementDAO();

			UserMasterVO voUser = new UserMasterVO();
			BeanUtils.copyProperties(voUser, voLoginUser_p);

			voUser.setVarMobileNumber(voLoginUser_p.getVarMobileNumber());
			voUser.setVarUserId(voLoginUser_p.getVarUserId() );
			// Fetching User Detail based on User Name
			List<UserMasterVO> lstUserMasterVO = daoUserMgmt.getmUserDetail(hisDAO, "1", voUser);
			//System.out.println("size>>>> " + lstUserMasterVO.size() );
			if (lstUserMasterVO == null || lstUserMasterVO.size() <= 0 || lstUserMasterVO.size() > 1) {
				// If User Detail not found, No Action, returnError message
				voUser.setVarLoggedIn(HISConfig.NO);
				//voUser.setVarLoginMessage("Invalid User, Please Try with Valid One!");
				voUser.setVarLoginMessage("Mobile Number Registered for more than One User. Cannot Login!");
				voUserFinal = voUser;
			} else {
				// If found, first check for Valid User
				voUserFinal = lstUserMasterVO.get(0);
				

				if (voUserFinal == null) {
					// If Not Valid User
					// set Status, return Error Message
					voUser.setVarLoggedIn(HISConfig.NO);
					voUser.setVarLoginMessage("Invalid User Name/Password!");
					if (_isLocked.equals("1"))
						voUser.setVarLoginMessage("User is Locked!! Contact System Administrator!");
					
					
					
					voUserFinal = voUser;

					// Insert for Unsuccessful Login Detail
					UserLoginLogVO voUserUnsuccessLoginLog = new UserLoginLogVO();
					BeanUtils.copyProperties(voUserUnsuccessLoginLog, voLoginUser_p);

					daoUserMgmt.dmlUserLoginLog(hisDAO, "1", voUserUnsuccessLoginLog);

					// Getting Unsuccessful Count
					List<UserLoginLogVO> lstUnsuccessLoginLog = daoUserMgmt.getUserLoginLog(hisDAO, "1",
							voUserUnsuccessLoginLog, null, null);
					int nUnsuccessLoginCount = 0;
					if (lstUnsuccessLoginLog != null && lstUnsuccessLoginLog.size() > 0
							&& lstUnsuccessLoginLog.get(0) != null) {
						UserLoginLogVO voLog = lstUnsuccessLoginLog.get(0);
						if (voLog != null && voLog.getVarUnsuccessfulCount() != null) {
							nUnsuccessLoginCount = Integer.parseInt(voLog.getVarUnsuccessfulCount());
						}
					}

					// Check for Max Unsuccessful Login Count exceeds
					if (nUnsuccessLoginCount >= HISSSOConfig.LOGIN_LOCK_AFTER_UNSUCCESSFUL_LOGIN_COUNT) {
						// If yes,
						// Lock User with Given User Name and IP Address
						daoUserMgmt.dmlUserDetail(hisDAO, "1", voUserFinal);

						// Update Unsuccessful Login Log after Lock
						// Here deleting all Log of User ???
						// loginObj.updateUnsuccessfulLoginLog(request.getParameter("uid"));
					}
				} else {
					// If Valid User,
					// Removing Sensitive Information like Password
					// voUserFinal.setVarPassword(null);
					// voUserFinal.setVarHintAnswer(null);

					// Check for Other Logic based on IP Address/Location
					// Seat Wise IPs Addresses
					// Hospital Wise IP Addresses
					// If it will not found in defined range, then return "Proper Message" set
					// status
					// Seat Association Check
					// INVALID_IP_ADDRESS User Is Not Allowed To Login From This System
					// NO_SEAT_ASSOCIATED
					// voUserFinal.setVarLoggedIn(HISConfig.NO);
					// voUserFinal.setVarLoginMessage("User Not Allowed To Login From this
					// System!");

					// Check Logic for Locked User
					if (voUserFinal.getVarLock().equals(HISConfig.YES)) {
						voUserFinal.setVarLoggedIn(HISConfig.NO);
						voUserFinal.setVarLoginMessage("User is Locked!! Contact System Administrator!");
					} else {
						// --- Check user already logged in somewhere else

						voUserFinal.setVarLoggedIn(HISConfig.YES);

						// Getting Default Page, District etc inside UserVO

						// Getting Hospital Detail
						
						if(!"0".equals(voUserFinal.getVarHospitalCode())) {
							HospitalMasterVO voHospital = new HospitalMasterVO();
							BeanUtils.copyProperties(voHospital, voUserFinal);
							List<HospitalMasterVO> lstHospital = daoUserMgmt.getHospitalDetail(hisDAO, "1", voHospital);
							voHospital = lstHospital.get(0);
							voUserFinal.setVoHospital(voHospital);
						}
						
						 						
						List<UserSeatVO> userSeatsDtl =	daoUserMgmt.getUserSeatDetail(hisDAO, "1", voUserFinal.getVarHospitalCode(), voUserFinal.getVarUserId(), voUserFinal.getVarSeatId());
						voUserFinal.setUserSeatsDtl(userSeatsDtl);
						
						
						
					}
				}
			}
		} catch (HISRecordNotFoundException e) {
			throw new HISRecordNotFoundException(
					"UserManagementBO.getUserValidLoginDetail()::HISRecordNotFoundException -> " + e.getMessage());
		} catch (HISDataAccessException e) {
			throw new HISDataAccessException(
					"UserManagementBO.getUserValidLoginDetail()::HISDataAccessException -> " + e.getMessage());
		} catch (HISApplicationExecutionException e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.getUserValidLoginDetail()::HISApplicationExecutionException -> "
							+ e.getMessage());
		} catch (HISException e) {
			throw new HISException("UserManagementBO.getUserValidLoginDetail()::HISException -> " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new HISApplicationExecutionException(
					"UserManagementBO.getUserValidLoginDetail()::HISApplicationExecutionException -> "
							+ e.getMessage());
		} finally {
			if (hisDAO != null) {
				hisDAO.free();
				hisDAO = null;
			}
		}
		return voUserFinal;
	}
	
	
	/*
	 * ///MObileLogin
	 */	
	
	/*
	 * public UserMasterVO getUserValidMLoginDetail(LoginVO voMLoginUser_p, boolean
	 * isMobileLogin) { // TODO Auto-generated method stub return null; }
	 */
	
//	public UserMasterVO getUserValidMLoginDetail(LoginVO voMLoginUser_p, boolean isMobileLogin) {
//		
//		UserMasterVO voMUserFinal = null;
//		HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
//		/* String _isLocked = "0"; */
//	    try {
//	    	
//	    	UserManagementDAO daoUserMgmt = new UserManagementDAO();
//
//			UserMasterVO voMUser = new UserMasterVO();
//			BeanUtils.copyProperties(voMUser, voMLoginUser_p);
//	    	
//
//	        if (isMobileLogin) {
//	            // Mobile login flow using OTP
//	            boolean isOtpValid = validateMobileOTP(voMLoginUser_p.getVarMobileNumber(), voMLoginUser_p.getVarOtp());
//	            if (!isOtpValid) {
//	            	voMLoginUser_p.setVarLoggedIn(HISConfig.NO);
//	            	voMLoginUser_p.setVarLoginMessage("Invalid OTP!");
//	                return voMUser;
//	            }
//	            
//	            
//	            // Fetch user details by mobile number
//	            List<UserMasterVO> lstUserMasterVO = daoUserMgmt.getUserDetailByMobile(hisDAO, voMUser.getVarMobileNumber(), voMUser, voMUser);
//	            if (lstUserMasterVO == null || lstUserMasterVO.isEmpty()) {
//	            	voMUser.setVarLoggedIn(HISConfig.NO);
//	            	voMUser.setVarLoginMessage("User not found!");
//	                return voMUser;
//	            }
//	            voMUserFinal = lstUserMasterVO.get(0);
//	        } else {
//	            // Existing login flow (username/password)
//	            // Unchanged logic...
//	        }
//
//	        // Set user as successfully logged in
//	        if (voMUserFinal != null) {
//	            voMUserFinal.setVarLoggedIn(HISConfig.YES);
//	        }
//	    } catch (Exception e) {
//	        throw new HISApplicationExecutionException(
//	            "UserManagementBO.getUserValidLoginDetail()::Exception -> " + e.getMessage());
//	    } finally {
//	        if (hisDAO != null) {
//	            hisDAO.free();
//	            hisDAO = null;
//	        }
//	    }
//	    return voMUserFinal;
//	}
//
//
//	
//	private boolean validateMobileOTP(Object varMobileNumber, Object varOtp) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	
//	
	/*
	 * public List<MenuMasterVO> getUserMenusList(UserMasterVO voUser) throws
	 * HISException { JDBCTransactionContext objTransaction = new
	 * JDBCTransactionContext(); UserManagementDAO daoUserMgmt = new
	 * UserManagementDAO(objTransaction); List<MenuMasterVO> lstMenus = null; try {
	 * objTransaction.begin(); ResultSet
	 * resultSet=daoUserMgmt.getMenuForUser(voUser.getVarHospitalCode(),
	 * voUser.getVarUserSeatId()); lstMenus = new ArrayList<MenuMasterVO>();
	 * while(resultSet.next()) { MenuMasterVO objEntry = new MenuMasterVO();
	 * objEntry.setVarMenuName(resultSet.getString(1));
	 * objEntry.setVarURL(resultSet.getString(2)); lstMenus.add(objEntry); } } catch
	 * (Exception e) { e.printStackTrace(); objTransaction.rollback(); throw new
	 * HISException(e.getMessage()); } finally { objTransaction.close(); } return
	 * lstMenus; }
	 */

	


	/**
	 * Getting User Menu Detail
	 * 
	 * @param voUser
	 * @return List<MenuMasterVO>
	 * @author Pragya Sharma 2014.01.10
	 */
	public List<MenuMasterVO> getUserMenusList(UserMasterVO voUser_p) {
		List<MenuMasterVO> lstMenus = null;
		HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
		try {
			UserManagementDAO daoUserMgmt = new UserManagementDAO();

			lstMenus = daoUserMgmt.getUserMenuDetail(hisDAO, "1", voUser_p);
		} catch (HISRecordNotFoundException e) {
			throw new HISRecordNotFoundException(
					"UserManagementBO.getUserMenusList()::HISRecordNotFoundException -> " + e.getMessage());
		} catch (HISDataAccessException e) {
			throw new HISDataAccessException(
					"UserManagementBO.getUserMenusList()::HISDataAccessException -> " + e.getMessage());
		} catch (HISApplicationExecutionException e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.getUserMenusList()::HISApplicationExecutionException -> " + e.getMessage());
		} catch (HISException e) {
			throw new HISException("UserManagementBO.getUserMenusList()::HISException -> " + e.getMessage());
		} catch (Exception e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.getUserMenusList()::HISApplicationExecutionException -> " + e.getMessage());
		} finally {
			if (hisDAO != null) {
				hisDAO.free();
				hisDAO = null;
			}
		}
		return lstMenus;
	}

	/**
	 * Inserting User Log Detail After Login and Returning User Detail
	 * 
	 * @param voUserLoginLog_p
	 * @return Map<String, Object>
	 * @author Pragya Sharma 2014.01.10
	 */
	public Map<String, Object> logUserSuccessfulLogin(UserLoginLogVO voUserLoginLog_p) {
		Map<String, Object> mapData = new HashMap<String, Object>();
		HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
		try {
			UserManagementDAO daoUserMgmt = new UserManagementDAO();

			// Log User Login Detail
			daoUserMgmt.dmlUserLoginLog(hisDAO, "2", voUserLoginLog_p);

			// Getting User Menu Detail and Set in Map
			UserMasterVO voUser = new UserMasterVO();
			BeanUtils.copyProperties(voUser, voUserLoginLog_p);
			voUser.setVarUserSeatId(voUserLoginLog_p.getVarSeatId());
			List<MenuMasterVO> lstMenus = daoUserMgmt.getUserMenuDetail(hisDAO, "1", voUser);
			mapData.put(UserManagementConfig.KEY_USER_MENU_LIST, lstMenus);
			
			/*
			 * //Added by Anjali List<MenuMasterVO>
			 * lstManuals=daoUserMgmt.getUserManualDetail(hisDAO, "1", voUser);
			 * mapData.put(UserManagementConfig.KEY_USER_MANUAL_LIST, lstManuals);
			 */
			//

			// Getting User Allowed Menu Detail and Set in Map
		//	List<MenuMasterVO> lstAllowedMenus = daoUserMgmt.getUserMenuDetail(hisDAO, "4", voUser);
		//	mapData.put(UserManagementConfig.KEY_USER_ALLOWED_MENU_LIST, lstAllowedMenus);

			// Getting System Date Other
			List<UserMasterVO> lstUserMasterVO = daoUserMgmt.getUserDetail(hisDAO, "2", voUser);
			if (lstUserMasterVO != null && lstUserMasterVO.size() > 0) {
				UserMasterVO voUserSysDateTime = lstUserMasterVO.get(0);
				mapData.put(UserManagementConfig.KEY_SYSTEM_DATETIME, voUserSysDateTime);
			}

			/*
			 * // Getting Favorite Menu List List<MenuMasterVO> lstFavoriteMenus =
			 * daoUserMgmt.getUserMenuDetail(hisDAO, "2", voUser);
			 * mapData.put(UserManagementConfig.KEY_USER_FAVORITE_MENU_LIST,
			 * lstFavoriteMenus);
			 */

			// Get the Back Date day end flag details, Added by Singaravelan on 02-Jun-2015
			//String checkBackDateEndFlag = daoUserMgmt.checkBackDateDayEnd(hisDAO, "1", voUser);
			//mapData.put(UserManagementConfig.KEY_CASH_COLLECTION_ALLOWED, checkBackDateEndFlag);

		} catch (HISRecordNotFoundException e) {
			throw new HISRecordNotFoundException(
					"UserManagementBO.getUserMenusList()::HISRecordNotFoundException -> " + e.getMessage());
		} catch (HISDataAccessException e) {
			throw new HISDataAccessException(
					"UserManagementBO.getUserMenusList()::HISDataAccessException -> " + e.getMessage());
		} catch (HISApplicationExecutionException e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.getUserMenusList()::HISApplicationExecutionException -> " + e.getMessage());
		} catch (HISException e) {
			throw new HISException("UserManagementBO.getUserMenusList()::HISException -> " + e.getMessage());
		} catch (Exception e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.getUserMenusList()::HISApplicationExecutionException -> " + e.getMessage());
		} finally {
			if (hisDAO != null) {
				hisDAO.free();
				hisDAO = null;
			}
		}
		return mapData;
	}
	
	
	public Map<String, Object> logBenSuccessfulLogin(UserLoginLogVO voUserLoginLog_p) {
		Map<String, Object> mapData = new HashMap<String, Object>();
		HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
		try {
			UserManagementDAO daoUserMgmt = new UserManagementDAO();

			// Log User Login Detail
			daoUserMgmt.dmlBenLoginLog(hisDAO, "2", voUserLoginLog_p);

			// Getting User Menu Detail and Set in Map
			UserMasterVO voUser = new UserMasterVO();
			BeanUtils.copyProperties(voUser, voUserLoginLog_p);
			voUser.setVarUserSeatId(voUserLoginLog_p.getVarSeatId());
			List<MenuMasterVO> lstMenus = daoUserMgmt.getUserMenuDetail(hisDAO, "1", voUser);
			mapData.put(UserManagementConfig.KEY_USER_MENU_LIST, lstMenus);
			
			/*
			 * //Added by Anjali List<MenuMasterVO>
			 * lstManuals=daoUserMgmt.getUserManualDetail(hisDAO, "1", voUser);
			 * mapData.put(UserManagementConfig.KEY_USER_MANUAL_LIST, lstManuals);
			 */
			//

			// Getting User Allowed Menu Detail and Set in Map
		//	List<MenuMasterVO> lstAllowedMenus = daoUserMgmt.getUserMenuDetail(hisDAO, "4", voUser);
		//	mapData.put(UserManagementConfig.KEY_USER_ALLOWED_MENU_LIST, lstAllowedMenus);

			// Getting System Date Other
			List<UserMasterVO> lstUserMasterVO = daoUserMgmt.getBenDetail(hisDAO, "2", voUser);
			if (lstUserMasterVO != null && lstUserMasterVO.size() > 0) {
				UserMasterVO voUserSysDateTime = lstUserMasterVO.get(0);
				mapData.put(UserManagementConfig.KEY_SYSTEM_DATETIME, voUserSysDateTime);
			}

			// Getting Favorite Menu List
			List<MenuMasterVO> lstFavoriteMenus = daoUserMgmt.getUserMenuDetail(hisDAO, "2", voUser);
			mapData.put(UserManagementConfig.KEY_USER_FAVORITE_MENU_LIST, lstFavoriteMenus);

			// Get the Back Date day end flag details, Added by Singaravelan on 02-Jun-2015
			//String checkBackDateEndFlag = daoUserMgmt.checkBackDateDayEnd(hisDAO, "1", voUser);
			//mapData.put(UserManagementConfig.KEY_CASH_COLLECTION_ALLOWED, checkBackDateEndFlag);

		} catch (HISRecordNotFoundException e) {
			throw new HISRecordNotFoundException(
					"UserManagementBO.getUserMenusList()::HISRecordNotFoundException -> " + e.getMessage());
		} catch (HISDataAccessException e) {
			throw new HISDataAccessException(
					"UserManagementBO.getUserMenusList()::HISDataAccessException -> " + e.getMessage());
		} catch (HISApplicationExecutionException e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.getUserMenusList()::HISApplicationExecutionException -> " + e.getMessage());
		} catch (HISException e) {
			throw new HISException("UserManagementBO.getUserMenusList()::HISException -> " + e.getMessage());
		} catch (Exception e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.getUserMenusList()::HISApplicationExecutionException -> " + e.getMessage());
		} finally {
			if (hisDAO != null) {
				hisDAO.free();
				hisDAO = null;
			}
		}
		return mapData;
	}

	/**
	 * Inserting User Logout Detail at logout
	 * 
	 * @param voUserLoginLog_p
	 * @return Boolean
	 * @author Komal Yadav 2014.02.19
	 */
	public Boolean logUserSuccessfulLogout(UserLoginLogVO voUserLoginLog_p) {

		HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
		try {
			UserManagementDAO daoUserMgmt = new UserManagementDAO();

			// Log User Login Detail
			daoUserMgmt.dmlUserLoginLog(hisDAO, "3", voUserLoginLog_p);

		}

		catch (HISDataAccessException e) {
			throw new HISDataAccessException(
					"UserManagementBO.getUserMenusList()::HISDataAccessException -> " + e.getMessage());
		} catch (HISApplicationExecutionException e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.getUserMenusList()::HISApplicationExecutionException -> " + e.getMessage());
		} catch (HISException e) {
			throw new HISException("UserManagementBO.getUserMenusList()::HISException -> " + e.getMessage());
		} catch (Exception e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.getUserMenusList()::HISApplicationExecutionException -> " + e.getMessage());
		} finally {
			if (hisDAO != null) {
				hisDAO.free();
				hisDAO = null;
			}
		}
		return true;
	}
	
	
	public Boolean logBenSuccessfulLogout(UserLoginLogVO voUserLoginLog_p) {

		HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
		try {
			UserManagementDAO daoUserMgmt = new UserManagementDAO();

			// Log User Login Detail
			daoUserMgmt.dmlBenLoginLog(hisDAO, "3", voUserLoginLog_p);

		}

		catch (HISDataAccessException e) {
			throw new HISDataAccessException(
					"UserManagementBO.getUserMenusList()::HISDataAccessException -> " + e.getMessage());
		} catch (HISApplicationExecutionException e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.getUserMenusList()::HISApplicationExecutionException -> " + e.getMessage());
		} catch (HISException e) {
			throw new HISException("UserManagementBO.getUserMenusList()::HISException -> " + e.getMessage());
		} catch (Exception e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.getUserMenusList()::HISApplicationExecutionException -> " + e.getMessage());
		} finally {
			if (hisDAO != null) {
				hisDAO.free();
				hisDAO = null;
			}
		}
		return true;
	}

	/**
	 * Question List
	 * 
	 * @param voUser_p
	 * @return List<Entry>
	 * @author Pragya Sharma 2014.01.20
	 */
	public List<Entry> getQuestionList(UserMasterVO voUser_p) {
		List<Entry> lstData = new ArrayList<Entry>();
		HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
		try {
			UserManagementDAO daoUserMgmt = new UserManagementDAO();
			lstData = daoUserMgmt.getDetailedList(hisDAO, "1", voUser_p);
		} catch (HISRecordNotFoundException e) {
			throw new HISRecordNotFoundException(
					"UserManagementBO.getQuestionList()::HISRecordNotFoundException -> " + e.getMessage());
		} catch (HISDataAccessException e) {
			throw new HISDataAccessException(
					"UserManagementBO.getQuestionList()::HISDataAccessException -> " + e.getMessage());
		} catch (HISApplicationExecutionException e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.getQuestionList()::HISApplicationExecutionException -> " + e.getMessage());
		} catch (HISException e) {
			throw new HISException("UserManagementBO.getQuestionList()::HISException -> " + e.getMessage());
		} catch (Exception e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.getQuestionList()::HISApplicationExecutionException -> " + e.getMessage());
		} finally {
			if (hisDAO != null) {
				hisDAO.free();
				hisDAO = null;
			}
		}
		return lstData;
	}

	/**
	 * Getting User Detail after Validate Forgot Password
	 * 
	 * @param voLogin
	 * @return voUser
	 * @author Pragya Sharma 27-Jan-2014
	 */
	public UserMasterVO validateForgotPassword(LoginVO voLoginUser_p) {
		UserMasterVO voUserFinal = null;
		HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
		try {
			UserManagementDAO daoUserMgmt = new UserManagementDAO();

			UserMasterVO voUser = new UserMasterVO();
			BeanUtils.copyProperties(voUser, voLoginUser_p);

			// Fetching User Detail based on User Name Only
			List<UserMasterVO> lstUserMasterVO = daoUserMgmt.getUserDetail(hisDAO, "1", voUser);
			if (lstUserMasterVO == null || lstUserMasterVO.size() <= 0) {
				// If User Detail not found, No Action, returnError message
				voUser.setVarLoggedIn(HISConfig.NO);
				voUser.setVarLoginMessage("");
				voUserFinal = voUser;
			} else {
				// If found, first check for Valid User
				
				  for (UserMasterVO voUserTmp : lstUserMasterVO) { 
					  /*String strHashedAnswer =
				  SecureHashAlgorithm .SHA1(voUserTmp.getVarHintAnswer() +
				  voLoginUser_p.getVarLoginSessionSalt()); 
				  if(voLoginUser_p.getVarHintAnswer().equals(strHashedAnswer)) { */
					  voUserFinal =
				  voUserTmp; 
				  break; 
				  } 
				//  }
				 
				
				

				if (voUserFinal == null) {
					// If Not Valid User
					// set Status, return Error Message
					voUser.setVarLoggedIn(HISConfig.NO);
					voUser.setVarLoginMessage("Invalid Details! No user with provided User ID found.");
					voUserFinal = voUser;
				} else {
					// If Valid User,
					// Removing Sensitive Information like Password
					// voUserFinal.setVarHintAnswer(null);

					voUserFinal.setVarLoggedIn(HISConfig.YES);
				}
			}
		} catch (HISRecordNotFoundException e) {
			throw new HISRecordNotFoundException(
					"UserManagementBO.validateForgotPassword()::HISRecordNotFoundException -> " + e.getMessage());
		} catch (HISDataAccessException e) {
			throw new HISDataAccessException(
					"UserManagementBO.validateForgotPassword()::HISDataAccessException -> " + e.getMessage());
		} catch (HISApplicationExecutionException e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.validateForgotPassword()::HISApplicationExecutionException -> " + e.getMessage());
		} catch (HISException e) {
			throw new HISException("UserManagementBO.validateForgotPassword()::HISException -> " + e.getMessage());
		} catch (Exception e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.validateForgotPassword()::HISApplicationExecutionException -> " + e.getMessage());
		} finally {
			if (hisDAO != null) {
				hisDAO.free();
				hisDAO = null;
			}
		}
		return voUserFinal;
	}

	/**
	 * Updating User Password
	 * 
	 * @param voUser
	 * @return voUser
	 * @author Pragya Sharma 31-Jan-2014
	 */
	public UserMasterVO changeUserPassword(UserMasterVO voUser_p) {
		HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
		try {
			UserManagementDAO daoUserMgmt = new UserManagementDAO();
			voUser_p.setVarLoggedIn(HISConfig.NO);

			
			
			
			
			// Updating User Password
			daoUserMgmt.dmlUserDetail(hisDAO, "2", voUser_p);
			voUser_p.setVarLoggedIn(HISConfig.YES);
		} catch (HISRecordNotFoundException e) {
			throw new HISRecordNotFoundException(
					"UserManagementBO.changeUserPassword()::HISRecordNotFoundException -> " + e.getMessage());
		} catch (HISDataAccessException e) {
			throw new HISDataAccessException(
					"UserManagementBO.changeUserPassword()::HISDataAccessException -> " + e.getMessage());
		} catch (HISApplicationExecutionException e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.changeUserPassword()::HISApplicationExecutionException -> " + e.getMessage());
		} catch (HISException e) {
			throw new HISException("UserManagementBO.changeUserPassword()::HISException -> " + e.getMessage());
		} catch (Exception e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.changeUserPassword()::HISApplicationExecutionException -> " + e.getMessage());
		} finally {
			if (hisDAO != null) {
				hisDAO.free();
				hisDAO = null;
			}
		}
		return voUser_p;
	}
	
	/**
	 * Updating User Password
	 * 
	 * @param voUser
	 * @return voUser
	 * @author Pragya Sharma 31-Jan-2014
	 */
	public UserMasterVO updateForgotPassword(UserMasterVO voUser_p) {
		HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
		try {
			UserManagementDAO daoUserMgmt = new UserManagementDAO();
			voUser_p.setVarLoggedIn(HISConfig.NO);

			// Updating User Password
			daoUserMgmt.dmlUserDetail(hisDAO, "6", voUser_p);
			voUser_p.setVarLoggedIn(HISConfig.YES);
		} catch (HISRecordNotFoundException e) {
			throw new HISRecordNotFoundException(
					"UserManagementBO.changeUserPassword()::HISRecordNotFoundException -> " + e.getMessage());
		} catch (HISDataAccessException e) {
			throw new HISDataAccessException(
					"UserManagementBO.changeUserPassword()::HISDataAccessException -> " + e.getMessage());
		} catch (HISApplicationExecutionException e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.changeUserPassword()::HISApplicationExecutionException -> " + e.getMessage());
		} catch (HISException e) {
			throw new HISException("UserManagementBO.changeUserPassword()::HISException -> " + e.getMessage());
		} catch (Exception e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.changeUserPassword()::HISApplicationExecutionException -> " + e.getMessage());
		} finally {
			if (hisDAO != null) {
				hisDAO.free();
				hisDAO = null;
			}
		}
		return voUser_p;
	}
	

	
	public UserMasterVO updateActiveSessionFlag(UserMasterVO voUser_p) {
        HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
        try {
                UserManagementDAO daoUserMgmt = new UserManagementDAO();
                
               // System.out.println("INSIDE LOGIN BO 1");
                // Updating User Password
                daoUserMgmt.updateActiveSessionFlag(hisDAO,"1",voUser_p );
                //System.out.println("INSIDE LOGIN  BO 1 2"+voUser_p.getActiveSessionFlag());
        
        } catch (HISRecordNotFoundException e) {
                throw new HISRecordNotFoundException(
                                "UserManagementBO.updateActiveSessionFlag()::HISRecordNotFoundException -> " + e.getMessage());
        } catch (HISDataAccessException e) {
                throw new HISDataAccessException(
                                "UserManagementBO.updateActiveSessionFlag()::HISDataAccessException -> " + e.getMessage());
        } catch (HISApplicationExecutionException e) {
                throw new HISApplicationExecutionException(
                                "UserManagementBO.updateActiveSessionFlag()::HISApplicationExecutionException -> " + e.getMessage());
        } catch (HISException e) {
                throw new HISException("UserManagementBO.updateActiveSessionFlag()::HISException -> " + e.getMessage());
        } catch (Exception e) {
                throw new HISApplicationExecutionException(
                                "UserManagementBO.updateActiveSessionFlag()::HISApplicationExecutionException -> " + e.getMessage());
        } finally {
                if (hisDAO != null) {
                        hisDAO.free();
                        hisDAO = null;
                }
        }
        return voUser_p;
}
	
	
	public UserMasterVO updateActiveSessionFlagBen(UserMasterVO voUser_p) {
        HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
        try {
                UserManagementDAO daoUserMgmt = new UserManagementDAO();
                
               // System.out.println("INSIDE LOGIN BO 1");
                // Updating User Password
                daoUserMgmt.updateActiveSessionFlagBen(hisDAO,"1",voUser_p );
                //System.out.println("INSIDE LOGIN  BO 1 2"+voUser_p.getActiveSessionFlag());
        
        } catch (HISRecordNotFoundException e) {
                throw new HISRecordNotFoundException(
                                "UserManagementBO.updateActiveSessionFlag()::HISRecordNotFoundException -> " + e.getMessage());
        } catch (HISDataAccessException e) {
                throw new HISDataAccessException(
                                "UserManagementBO.updateActiveSessionFlag()::HISDataAccessException -> " + e.getMessage());
        } catch (HISApplicationExecutionException e) {
                throw new HISApplicationExecutionException(
                                "UserManagementBO.updateActiveSessionFlag()::HISApplicationExecutionException -> " + e.getMessage());
        } catch (HISException e) {
                throw new HISException("UserManagementBO.updateActiveSessionFlag()::HISException -> " + e.getMessage());
        } catch (Exception e) {
                throw new HISApplicationExecutionException(
                                "UserManagementBO.updateActiveSessionFlag()::HISApplicationExecutionException -> " + e.getMessage());
        } finally {
                if (hisDAO != null) {
                        hisDAO.free();
                        hisDAO = null;
                }
        }
        return voUser_p;
}


public UserLoginLogVO updateActiveSessionFlagLogout(UserLoginLogVO voUser_p) {
        HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
        try {
                UserManagementDAO daoUserMgmt = new UserManagementDAO();
                

                // Updating User Password
                daoUserMgmt.updateActiveSessionFlagLogout(hisDAO,"2",voUser_p);
        
        } catch (HISRecordNotFoundException e) {
                throw new HISRecordNotFoundException(
                                "UserManagementBO.updateActiveSessionFlagLogout()::HISRecordNotFoundException -> " + e.getMessage());
        } catch (HISDataAccessException e) {
                throw new HISDataAccessException(
                                "UserManagementBO.updateActiveSessionFlagLogout()::HISDataAccessException -> " + e.getMessage());
        } catch (HISApplicationExecutionException e) {
                throw new HISApplicationExecutionException(
                                "UserManagementBO.updateActiveSessionFlagLogout()::HISApplicationExecutionException -> " + e.getMessage());
        } catch (HISException e) {
                throw new HISException("UserManagementBO.updateActiveSessionFlagLogout()::HISException -> " + e.getMessage());
        } catch (Exception e) {
                throw new HISApplicationExecutionException(
                                "UserManagementBO.updateActiveSessionFlagLogout()::HISApplicationExecutionException -> " + e.getMessage());
        } finally {
                if (hisDAO != null) {
                        hisDAO.free();
                        hisDAO = null;
                }
        }
        return voUser_p;
}

	/**
	 * Updating User Detail
	 * 
	 * @param voUser
	 * @return voUser
	 * @author Pragya Sharma 31-Jan-2014
	 */
	public UserMasterVO changeUserDetail(UserMasterVO voUser_p) {
		HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
		try {
			UserManagementDAO daoUserMgmt = new UserManagementDAO();
			voUser_p.setVarLoggedIn(HISConfig.NO);

			// Updating User Password
			daoUserMgmt.dmlUserDetail(hisDAO, "3", voUser_p);
			voUser_p.setVarLoggedIn(HISConfig.YES);
		} catch (HISRecordNotFoundException e) {
			throw new HISRecordNotFoundException(
					"UserManagementBO.changeUserDetail()::HISRecordNotFoundException -> " + e.getMessage());
		} catch (HISDataAccessException e) {
			throw new HISDataAccessException(
					"UserManagementBO.changeUserDetail()::HISDataAccessException -> " + e.getMessage());
		} catch (HISApplicationExecutionException e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.changeUserDetail()::HISApplicationExecutionException -> " + e.getMessage());
		} catch (HISException e) {
			throw new HISException("UserManagementBO.changeUserDetail()::HISException -> " + e.getMessage());
		} catch (Exception e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.changeUserDetail()::HISApplicationExecutionException -> " + e.getMessage());
		} finally {
			if (hisDAO != null) {
				hisDAO.free();
				hisDAO = null;
			}
		}
		return voUser_p;
	}

	/**
	 * Updating User Login Details
	 * 
	 * @param voUser
	 * @return voUser
	 * @author Komal Yadav 10-Feb-2014
	 */
	public UserMasterVO changeLoginUserDetails(UserMasterVO voUser_p, List<MenuMasterVO> menuMasterVO_p) {

		HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
		try {
			UserManagementDAO daoUserMgmt = new UserManagementDAO();
			voUser_p.setVarLoggedIn(HISConfig.NO);

			// Updating User Login Details
			daoUserMgmt.dmlUserDetail(hisDAO, "4", voUser_p);

			MenuMasterVO voMenu = new MenuMasterVO();
			BeanUtils.copyProperties(voMenu, voUser_p);
			daoUserMgmt.dmlMenuMasterDetail(hisDAO, "2", voMenu);
			for (MenuMasterVO menuMaster : menuMasterVO_p) {
				System.out.println("user id====Bo" + menuMaster.getVarUserId());
				daoUserMgmt.dmlMenuMasterDetail(hisDAO, "1", menuMaster);
			}
			voUser_p.setVarLoggedIn(HISConfig.YES);
		} catch (HISRecordNotFoundException e) {
			throw new HISRecordNotFoundException(
					"UserManagementBO.changeLoginUserDetails()::HISRecordNotFoundException -> " + e.getMessage());
		} catch (HISDataAccessException e) {
			throw new HISDataAccessException(
					"UserManagementBO.changeLoginUserDetails()::HISDataAccessException -> " + e.getMessage());
		} catch (HISApplicationExecutionException e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.changeLoginUserDetails()::HISApplicationExecutionException -> " + e.getMessage());
		} catch (HISException e) {
			throw new HISException("UserManagementBO.changeUserDetails()::HISException -> " + e.getMessage());
		} catch (Exception e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.changeLoginUserDetails()::HISApplicationExecutionException -> " + e.getMessage());
		} finally {
			if (hisDAO != null) {
				hisDAO.free();
				hisDAO = null;
			}
		}
		return voUser_p;
	}
	
	/**
	 * Updating User Login Details
	 * 
	 * @param voUser
	 * @return voUser
	 * @author Komal Yadav 10-Feb-2014
	 */
	public UserMasterVO addUpdateMobileNo(UserMasterVO voUser_p) {

		HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
		try {
			UserManagementDAO daoUserMgmt = new UserManagementDAO();
			voUser_p.setVarLoggedIn(HISConfig.NO);

			// Updating User Login Details
			daoUserMgmt.dmlAddUpdateMobileNo(hisDAO, "5", voUser_p);

			
			voUser_p.setVarLoggedIn(HISConfig.YES);
		} catch (HISRecordNotFoundException e) {
			throw new HISRecordNotFoundException(
					"UserManagementBO.changeLoginUserDetails()::HISRecordNotFoundException -> " + e.getMessage());
		} catch (HISDataAccessException e) {
			throw new HISDataAccessException(
					"UserManagementBO.changeLoginUserDetails()::HISDataAccessException -> " + e.getMessage());
		} catch (HISApplicationExecutionException e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.changeLoginUserDetails()::HISApplicationExecutionException -> " + e.getMessage());
		} catch (HISException e) {
			throw new HISException("UserManagementBO.changeUserDetails()::HISException -> " + e.getMessage());
		} catch (Exception e) {
			throw new HISApplicationExecutionException(
					"UserManagementBO.changeLoginUserDetails()::HISApplicationExecutionException -> " + e.getMessage());
		} finally {
			if (hisDAO != null) {
				hisDAO.free();
				hisDAO = null;
			}
		}
		return voUser_p;
	}


	/**
	 * Login date and time List
	 * 
	 * @param voUser_p
	 * @return List<Entry>
	 * @author Komal yadav 2014.02.17
	 */
	public List<UserLoginLogVO> getLogList(UserMasterVO voUser_p, int n, String frDate, String toDate) {
		List<UserLoginLogVO> lstData = new ArrayList<UserLoginLogVO>();
		HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
		try {
			UserManagementDAO daoUserMgmt = new UserManagementDAO();
			UserLoginLogVO voLoginLog = new UserLoginLogVO();
			BeanUtils.copyProperties(voLoginLog, voUser_p);

			if (n == 10)
				lstData = daoUserMgmt.getUserLoginLog(hisDAO, "2", voLoginLog, frDate, toDate);
			else
				lstData = daoUserMgmt.getUserLoginLog(hisDAO, "3", voLoginLog, frDate, toDate);
		} catch (HISRecordNotFoundException e) {
			e.printStackTrace();
			throw new HISRecordNotFoundException(
					"UserManagementBO.getLogList()::HISRecordNotFoundException -> " + e.getMessage());
		} catch (HISDataAccessException e) {
			e.printStackTrace();
			throw new HISDataAccessException(
					"UserManagementBO.getLogList()::HISDataAccessException -> " + e.getMessage());
		} catch (HISApplicationExecutionException e) {
			e.printStackTrace();
			throw new HISApplicationExecutionException(
					"UserManagementBO.getLogList()::HISApplicationExecutionException -> " + e.getMessage());
		} catch (HISException e) {
			throw new HISException("UserManagementBO.getLogList()::HISException -> " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new HISApplicationExecutionException(
					"UserManagementBO.getLogList()::HISApplicationExecutionException -> " + e.getMessage());
		} finally {
			if (hisDAO != null) {
				hisDAO.free();
				hisDAO = null;
			}
		}
		return lstData;
	}

	/**
	 * To Fetch the Alert Count
	 * 
	 * @param voUser_p
	 * @return CommonAlertVO Array
	 * @author Singaravelan 21-Nov-2014
	 */
	public CommonAlertVO[] getAllAutomaticAlertBySeatID(UserMasterVO _userVo) {
		HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
		CommonAlertVO[] _commonAlertVo;
		try {
			UserManagementDAO daoUserMgmt = new UserManagementDAO();
			_commonAlertVo = daoUserMgmt.getAllAutomaticAlertBySeatID(hisDAO, _userVo);
		} catch (HISRecordNotFoundException e) {
			e.printStackTrace();
			throw new HISRecordNotFoundException(
					"UserManagementBO.getAllAutomaticAlertBySeatID()::HISRecordNotFoundException -> " + e.getMessage());
		} catch (HISDataAccessException e) {
			e.printStackTrace();
			throw new HISDataAccessException(
					"UserManagementBO.getAllAutomaticAlertBySeatID()::HISDataAccessException -> " + e.getMessage());
		} catch (HISApplicationExecutionException e) {
			e.printStackTrace();
			throw new HISApplicationExecutionException(
					"UserManagementBO.getAllAutomaticAlertBySeatID()::HISApplicationExecutionException -> "
							+ e.getMessage());
		} catch (HISException e) {
			throw new HISException(
					"UserManagementBO.getAllAutomaticAlertBySeatID()::HISException -> " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new HISApplicationExecutionException(
					"UserManagementBO.getAllAutomaticAlertBySeatID()::HISApplicationExecutionException -> "
							+ e.getMessage());
		} finally {
			if (hisDAO != null) {
				hisDAO.free();
				hisDAO = null;
			}
		}
		return _commonAlertVo;
	}

	/**
	 * To Fetch the User Wise Cash Collected Details
	 * 
	 * @param voUser_p
	 * @return CommonAlertVO Array
	 * @author Singaravelan 02-Jun-2014
	 */
	public Map<String, String> getUserWiseCashCollected(UserMasterVO _userVo) {
		HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
		Map<String, String> userDtlMap = null;
		try {
			UserManagementDAO daoUserMgmt = new UserManagementDAO();
			userDtlMap = daoUserMgmt.getUserWiseCashCollected(hisDAO, _userVo);
		} catch (HISRecordNotFoundException e) {
			e.printStackTrace();
			throw new HISRecordNotFoundException(
					"UserManagementBO.getUserWiseCashCollected()::HISRecordNotFoundException -> " + e.getMessage());
		} catch (HISDataAccessException e) {
			e.printStackTrace();
			throw new HISDataAccessException(
					"UserManagementBO.getUserWiseCashCollected()::HISDataAccessException -> " + e.getMessage());
		} catch (HISApplicationExecutionException e) {
			e.printStackTrace();
			throw new HISApplicationExecutionException(
					"UserManagementBO.getUserWiseCashCollected()::HISApplicationExecutionException -> "
							+ e.getMessage());
		} catch (HISException e) {
			throw new HISException("UserManagementBO.getUserWiseCashCollected()::HISException -> " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			// throw new
			// HISApplicationExecutionException("UserManagementBO.getUserWiseCashCollected()::HISApplicationExecutionException
			// -> "
			// + e.getMessage());
		} finally {
			if (hisDAO != null) {
				hisDAO.free();
				hisDAO = null;
			}
		}
		return userDtlMap;
	}

	/**
	 * To Fetch the BackEndDayCheck Flag Details
	 * 
	 * @param voUser_p
	 * @return CommonAlertVO Array
	 * @author Singaravelan 02-Jun-2014
	 */
	public String checkBackDateDayEnd(UserMasterVO _userVo) {
		HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
		String checkBackDateDayEndFlag;
		try {
			UserManagementDAO daoUserMgmt = new UserManagementDAO();
			checkBackDateDayEndFlag = daoUserMgmt.checkBackDateDayEnd(hisDAO, "1", _userVo);
		} catch (HISRecordNotFoundException e) {
			e.printStackTrace();
			throw new HISRecordNotFoundException(
					"UserManagementBO.getUserWiseCashCollected()::HISRecordNotFoundException -> " + e.getMessage());
		} catch (HISDataAccessException e) {
			e.printStackTrace();
			throw new HISDataAccessException(
					"UserManagementBO.getUserWiseCashCollected()::HISDataAccessException -> " + e.getMessage());
		} catch (HISApplicationExecutionException e) {
			e.printStackTrace();
			throw new HISApplicationExecutionException(
					"UserManagementBO.getUserWiseCashCollected()::HISApplicationExecutionException -> "
							+ e.getMessage());
		} catch (HISException e) {
			throw new HISException("UserManagementBO.getUserWiseCashCollected()::HISException -> " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new HISApplicationExecutionException(
					"UserManagementBO.getUserWiseCashCollected()::HISApplicationExecutionException -> "
							+ e.getMessage());
		} finally {
			if (hisDAO != null) {
				hisDAO.free();
				hisDAO = null;
			}
		}
		return checkBackDateDayEndFlag;
	}

 

	public void saveDesktopClientInfo(UserLoginLogVO voUserLoginLog_p) {
		HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
		try {
			UserManagementDAO daoUserMgmt = new UserManagementDAO();

			daoUserMgmt.getDesktopClientDataSlNo(hisDAO, voUserLoginLog_p);

			// save client system's data in table
			daoUserMgmt.saveDesktopClientInfo(hisDAO, "1", voUserLoginLog_p);

		} catch (HISRecordNotFoundException e) {
			e.printStackTrace();
			throw new HISRecordNotFoundException(
					"UserManagementBO.saveDesktopClientInfo()::HISRecordNotFoundException -> " + e.getMessage());
		} catch (HISDataAccessException e) {
			e.printStackTrace();
			throw new HISDataAccessException(
					"UserManagementBO.saveDesktopClientInfo()::HISDataAccessException -> " + e.getMessage());
		} catch (HISApplicationExecutionException e) {
			e.printStackTrace();
			throw new HISApplicationExecutionException(
					"UserManagementBO.saveDesktopClientInfo()::HISApplicationExecutionException -> " + e.getMessage());
		} catch (HISException e) {
			e.printStackTrace();
			throw new HISException("UserManagementBO.saveDesktopClientInfo()::HISException -> " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new HISApplicationExecutionException(
					"UserManagementBO.saveDesktopClientInfo()::HISApplicationExecutionException -> " + e.getMessage());
		} finally {
			if (hisDAO != null) {
				hisDAO.free();
				hisDAO = null;
			}
		}
	}

	public List<UserMasterVO> getUserDetail(String varUserName) {
		
		UserMasterVO voUser = new UserMasterVO();
		
		voUser.setVarUserName(varUserName);
				
		List<UserMasterVO> lstUserMasterVO =  null;
		
		HisDAO hisDAO = new HisDAO("UserManagment", "UserManagementBO");
		UserManagementDAO daoUserMgmt = new UserManagementDAO();
		try {
			 lstUserMasterVO = daoUserMgmt.getUserDetail(hisDAO, "1", voUser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lstUserMasterVO;
	}

	

	/*
	 * public Map<String, Object> getUserDeskDetail(UserMasterVO voUser) throws
	 * HISException { JDBCTransactionContext objTransaction = new
	 * JDBCTransactionContext(); UserManagementDAO daoUserMgmt = new
	 * UserManagementDAO(objTransaction); Map<String, Object> mapData = new
	 * HashMap<String, Object>(); List<MenuMasterVO> lstMenus = null; try {
	 * objTransaction.begin(); // Fetch Favorite Menus
	 * 
	 * 
	 * // Fetch Marque Message // Marque message
	 * 
	 * // User Login Log ????
	 * 
	 * // USER CUSTOM DETAIL, SYSDATE in Session // Calling DAO for setting Last
	 * User Log Detail ----
	 * //voUser.setVoLastUserLog(umgmtDAO.getLastUserLogDetail(voUser, "1"));
	 * 
	 * // Calling DAO for setting Last Unlogged User Log Detail ----
	 * //voUser.setLstUnloggedUserLoginDtl(umgmtDAO.getUserLogDetailList(voUser,
	 * "2"));
	 * 
	 * 
	 * 
	 * ResultSet resultSet=daoUserMgmt.getMenuForUser(voUser.getVarHospitalCode(),
	 * voUser.getVarUserSeatId()); lstMenus = new ArrayList<MenuMasterVO>();
	 * while(resultSet.next()) { MenuMasterVO objEntry = new MenuMasterVO();
	 * objEntry.setVarMenuName(resultSet.getString(1));
	 * objEntry.setVarURL(resultSet.getString(2)); lstMenus.add(objEntry); } } catch
	 * (Exception e) { e.printStackTrace(); objTransaction.rollback(); throw new
	 * HISException(e.getMessage()); } finally { objTransaction.close(); } return
	 * mapData; }
	 */

	/*
	 * public login validateUid(String ipnumber) throws HISException { login
	 * loginObj=new login();
	 * 
	 * JDBCTransactionContext objTransaction=new JDBCTransactionContext(); loginDao
	 * dao=new loginDao(objTransaction);
	 * 
	 * try{ objTransaction.begin();
	 * loginObj=dao.validateUidDao(this.uid,SecurityUtil.encrypt(this.pwd),
	 * ipnumber);
	 * 
	 * } catch(Exception e){
	 * 
	 * e.printStackTrace(); objTransaction.rollback(); throw new
	 * HisException(e.getMessage()); } finally{ objTransaction.close();
	 * 
	 * } return loginObj; }//End of validateUid
	 * 
	 * //here we are maintaing the log of the user being login
	 * 
	 * public login maintainLog(String userId,String seatId,String ipnumber,String
	 * hospitalCode) throws HisException {
	 * 
	 * 
	 * 
	 * login loginObj=new login();
	 * 
	 * JDBCTransactionContext objTransaction=new JDBCTransactionContext(); loginDao
	 * dao=new loginDao(objTransaction);
	 * 
	 * 
	 * 
	 * int result=0;
	 * 
	 * 
	 * 
	 * 
	 * try{ objTransaction.begin();
	 * result=dao.maintainLog(userId,seatId,ipnumber,hospitalCode);
	 * //dao.updateUnsuccessfulLoginLog(this.uid);
	 * 
	 * } catch(Exception e){
	 * 
	 * e.printStackTrace(); objTransaction.rollback(); throw new
	 * HisException(e.getMessage()); } finally{ objTransaction.close();
	 * 
	 * } return loginObj; }//End of validateUid //Getting the Hint Questions from
	 * the Database and setting into the request public void
	 * hintQuestions(HttpServletRequest request) throws HisException { //After
	 * creating successfull session ,we are getting the hint questions from database
	 * 
	 * 
	 * 
	 * JDBCTransactionContext objTransaction=new JDBCTransactionContext(); loginDao
	 * dao=new loginDao(objTransaction);
	 * 
	 * 
	 * try{ objTransaction.begin(); dao.hintQuestionsDao(request); } catch(Exception
	 * e){
	 * 
	 * e.printStackTrace(); objTransaction.rollback(); throw new
	 * HisException(e.getMessage()); } finally{ objTransaction.close();
	 * 
	 * }
	 * 
	 * } //Function used for checking old Password public int
	 * oldPasswordCheck(HttpServletRequest request) throws HisException { //After
	 * creating successfull session ,we are getting the hint questions from database
	 * // System.out.println("entry in password check--->"); int validUser=0;
	 * 
	 * JDBCTransactionContext objTransaction=new JDBCTransactionContext(); loginDao
	 * dao=new loginDao(objTransaction);
	 * 
	 * 
	 * try{ objTransaction.begin(); validUser=dao.oldPasswordCheckDao(request); //
	 * System.out.println("entry in oldPasswordCheck check--->"+validUser); }
	 * catch(Exception e){
	 * 
	 * e.printStackTrace(); objTransaction.rollback(); throw new
	 * HisException(e.getMessage()); } finally{ objTransaction.close();
	 * 
	 * } return validUser;
	 * 
	 * 
	 * } //function for updating password and giving hint question and answer
	 * //After creating successfull session ,we are updating the password details
	 * and hint question public int firstLogin(HttpServletRequest request) throws
	 * HisException {
	 * 
	 * int firstLogin=0;
	 * 
	 * JDBCTransactionContext objTransaction=new JDBCTransactionContext(); loginDao
	 * dao=new loginDao(objTransaction);
	 * 
	 * 
	 * try{ objTransaction.begin(); firstLogin=dao.firstLoginDao(request); }
	 * catch(Exception e){
	 * 
	 * e.printStackTrace(); objTransaction.rollback(); throw new
	 * HisException(e.getMessage()); } finally{ objTransaction.close();
	 * 
	 * } return firstLogin;
	 * 
	 * 
	 * } //function for updating password only public int
	 * updatePasswordOnly(HttpServletRequest request) throws HisException {
	 * 
	 * int result=0;
	 * 
	 * JDBCTransactionContext objTransaction=new JDBCTransactionContext(); loginDao
	 * dao=new loginDao(objTransaction);
	 * 
	 * 
	 * try{ objTransaction.begin(); result=dao.updatePasswordOnly(request); }
	 * catch(Exception e){
	 * 
	 * e.printStackTrace(); objTransaction.rollback(); throw new
	 * HisException(e.getMessage()); } finally{ objTransaction.close();
	 * 
	 * }
	 * 
	 * return result;
	 * 
	 * } //Function used for getting Forgot Password public Map
	 * forgotPassword(HttpServletRequest request) throws HisException { //After
	 * creating successfull session ,we are getting the hint questions from database
	 * 
	 * Map resultantMAP = new HashMap();
	 * 
	 * 
	 * JDBCTransactionContext objTransaction=new JDBCTransactionContext(); loginDao
	 * dao=new loginDao(objTransaction);
	 * 
	 * 
	 * try{ objTransaction.begin(); resultantMAP=dao.forgotPassword(request); }
	 * catch(Exception e){
	 * 
	 * e.printStackTrace(); objTransaction.rollback(); throw new
	 * HisException(e.getMessage()); } finally{ objTransaction.close();
	 * 
	 * }
	 * 
	 * return resultantMAP;
	 * 
	 * } // public int newPassword(HttpServletRequest request) throws HisException {
	 * //After creating successfull session ,we are getting the hint questions from
	 * database
	 * 
	 * int result=0;
	 * 
	 * 
	 * JDBCTransactionContext objTransaction=new JDBCTransactionContext(); loginDao
	 * dao=new loginDao(objTransaction);
	 * 
	 * 
	 * try{ objTransaction.begin(); result=dao.newPassword(request); }
	 * catch(Exception e){
	 * 
	 * e.printStackTrace(); objTransaction.rollback(); throw new
	 * HisException(e.getMessage()); } finally{ objTransaction.close();
	 * 
	 * }
	 * 
	 * return result;
	 * 
	 * } //FUNCTION USED FOR UPDATING USER DETAILS
	 * 
	 * public int updateUserDetails(HttpServletRequest request) throws HisException
	 * { //After creating successfull session ,we areupdating the user details
	 * 
	 * 
	 * int validUser=0;
	 * 
	 * 
	 * JDBCTransactionContext objTransaction=new JDBCTransactionContext(); loginDao
	 * dao=new loginDao(objTransaction);
	 * 
	 * 
	 * try{ objTransaction.begin(); validUser=dao.updateUserDetails(request); }
	 * catch(Exception e){
	 * 
	 * e.printStackTrace(); objTransaction.rollback(); throw new
	 * HisException(e.getMessage()); } finally{ objTransaction.close();
	 * 
	 * }
	 * 
	 * return validUser;
	 * 
	 * } //function for updating audit log of user details public int
	 * updateAuditLog(HttpServletRequest request,String oldValue) throws
	 * HisException {
	 * 
	 * JDBCTransactionContext objTransaction=new JDBCTransactionContext(); loginDao
	 * dao=new loginDao(objTransaction); int result=0;
	 * 
	 * 
	 * String moduleId = "12" ; //menuId.substring(3,5); String menuId = "10" ;
	 * //request.getParameter("menuId"); String ipAddress = request.getRemoteAddr();
	 * String primarKeyValue=""; String userName=""; String seatId=""; String
	 * tableName="";
	 * 
	 * 
	 * 
	 * primarKeyValue=(String)request.getSession().getAttribute("USER_ID")+"^"+
	 * request.getSession().getAttribute("HOSPITAL_CODE");
	 * 
	 * 
	 * String newValue="GSTR_USR_NAME"+"^"+request.getParameter("userFullName")+"#"+
	 * "GNUM_QUESTION_ID"+"^"+request.getParameter("hintQuestion")+"#"+
	 * "GSTR_HINT_ANSWER"+"^"+request.getParameter("answer")+"#"+
	 * "GNUM_MOBILE_NUMBER"+"^"+request.getParameter("mobileNo")+"#"+
	 * "GSTR_EMAIL_ID"+"^"+request.getParameter("emailId");
	 * 
	 * 
	 * 
	 * //Since The above code is treated as a Single Line String Declaration //Hence
	 * we are using string otherwise we would have used StringBuilder /StringBuffer
	 * //if we were making multiple strings while string concatination as the String
	 * is immutable
	 * 
	 * 
	 * seatId=(String)request.getSession().getAttribute("ACTUALSEATID");
	 * userId=(String)request.getSession().getAttribute("USER_ID");
	 * userName=(String)request.getSession().getAttribute("userName");
	 * tableName="GBLT_USER_MST";
	 * 
	 * // System.out.println("pkValue ---"+primarKeyValue); //
	 * System.out.println("oldValue ---"+oldValue); //
	 * System.out.println("newValue ---"+newValue);
	 * 
	 * 
	 * try{ objTransaction.begin();
	 * result=dao.updateAuditLogDao(request,moduleId,menuId,primarKeyValue,oldValue,
	 * newValue,seatId,userId,ipAddress,userName,tableName); } catch(Exception e){
	 * 
	 * e.printStackTrace(); objTransaction.rollback(); throw new
	 * HisException(e.getMessage()); } finally{ objTransaction.close();
	 * 
	 * }
	 * 
	 * return result;
	 * 
	 * }//auditlog for first time login
	 * 
	 * 
	 * public int updateAuditLogFirstTimeLogin(HttpServletRequest request,String
	 * oldValue) throws HisException {
	 * 
	 * 
	 * JDBCTransactionContext objTransaction=new JDBCTransactionContext(); loginDao
	 * dao=new loginDao(objTransaction); int result=0;
	 * 
	 * 
	 * String moduleId = "12" ; //menuId.substring(3,5); String menuId = "10" ;
	 * //request.getParameter("menuId"); String ipAddress = request.getRemoteAddr();
	 * String userName=""; String seatId=""; String tableName="";
	 * 
	 * 
	 * 
	 * String
	 * primarKeyValue=(String)request.getSession().getAttribute("USER_ID")+"^"+
	 * request.getSession().getAttribute("HOSPITAL_CODE");
	 * 
	 * String
	 * newValue="GNUM_QUESTION_ID"+"^"+request.getParameter("hintQuestion")+"#"+
	 * "GSTR_HINT_ANSWER"+"^"+request.getParameter("answer");
	 * 
	 * 
	 * 
	 * //Since The above code is treated as a Single Line String Declaration //Hence
	 * we are using string otherwise we would have used StringBuilder /StringBuffer
	 * //if we were making multiple strings while string concatination as the String
	 * is immutable
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * seatId=(String)request.getSession().getAttribute("ACTUALSEATID");
	 * userId=(String)request.getSession().getAttribute("USER_ID");
	 * userName=(String)request.getSession().getAttribute("userName");
	 * tableName="GBLT_USER_MST";
	 * 
	 * // System.out.println("pkValue ---"+primarKeyValue); //
	 * System.out.println("oldValue ---"+oldValue); //
	 * System.out.println("newValue ---"+newValue);
	 * 
	 * 
	 * try{ objTransaction.begin();
	 * result=dao.updateAuditLogDao(request,moduleId,menuId,primarKeyValue,oldValue,
	 * newValue,seatId,userId,ipAddress,userName,tableName); } catch(Exception e){
	 * 
	 * e.printStackTrace(); objTransaction.rollback(); throw new
	 * HisException(e.getMessage()); } finally{ objTransaction.close();
	 * 
	 * }
	 * 
	 * return result;
	 * 
	 * } //auditlog for change password in case he forgets his password
	 * 
	 * public int updateAuditLogForgotPassword(HttpServletRequest request,String
	 * oldValue,String newValue) throws HisException {
	 * 
	 * 
	 * JDBCTransactionContext objTransaction=new JDBCTransactionContext(); loginDao
	 * dao=new loginDao(objTransaction); int result=0;
	 * 
	 * 
	 * String moduleId = "12" ; //menuId.substring(3,5); String menuId = "10" ;
	 * //request.getParameter("menuId"); String ipAddress = request.getRemoteAddr();
	 * String userName=""; String seatId=""; String tableName="";
	 * 
	 * 
	 * // System.out.println("USER_ID value in auditlog of login===="+request.
	 * getAttribute("USER_ID"));
	 * 
	 * String primarKeyValue=(String)request.getAttribute("USER_ID")+"^"+
	 * request.getAttribute("HOSPITAL_CODE");
	 * 
	 * 
	 * //Since The above code is treated as a Single Line String Declaration //Hence
	 * we are using string otherwise we would have used StringBuilder /StringBuffer
	 * //if we were making multiple strings while string concatination as the String
	 * is immutable
	 * 
	 * 
	 * 
	 * 
	 * seatId=(String)request.getAttribute("USER_SEATID");
	 * userId=(String)request.getAttribute("USER_ID");
	 * userName=(String)request.getAttribute("USER_NAME");
	 * tableName="GBLT_USER_MST";
	 * 
	 * // System.out.println("pkValue ---"+primarKeyValue); //
	 * System.out.println("oldValue ---"+oldValue); //
	 * System.out.println("newValue ---"+newValue);
	 * 
	 * 
	 * try{ objTransaction.begin();
	 * result=dao.updateAuditLogDao(request,moduleId,menuId,primarKeyValue,oldValue,
	 * newValue,seatId,userId,ipAddress,userName,tableName); } catch(Exception e){
	 * 
	 * e.printStackTrace(); objTransaction.rollback(); throw new
	 * HisException(e.getMessage()); } finally{ objTransaction.close();
	 * 
	 * }
	 * 
	 * return result;
	 * 
	 * } //logout function public void logoutUser(String userId,String
	 * ipnumber,String _hospitalCode) throws HisException { JDBCTransactionContext
	 * objTransaction=new JDBCTransactionContext(); loginDao dao=new
	 * loginDao(objTransaction);
	 * 
	 * try{ objTransaction.begin(); dao.logoutUser(userId,ipnumber,_hospitalCode); }
	 * catch(Exception e){
	 * 
	 * e.printStackTrace(); objTransaction.rollback(); throw new
	 * HisException(e.getMessage()); } finally{ objTransaction.close();
	 * 
	 * }
	 * 
	 * 
	 * }
	 * 
	 * public void createUnsuccessfulLoginLog(String userName,String ipAddress)
	 * throws HisException { JDBCTransactionContext objTransaction=new
	 * JDBCTransactionContext(); loginDao dao=new loginDao(objTransaction);
	 * 
	 * try{ objTransaction.begin();
	 * dao.createUnsuccessfulLoginLog(userName,ipAddress);
	 * //dao.maintainLogForUnsuccessFullLogin(uid,ipNo,hospitalCode);
	 * //numberOfUnsuccessFulLogin=dao.selectUnsuccessfulLoginLog(userName); }
	 * catch(Exception e){
	 * 
	 * e.printStackTrace(); objTransaction.rollback(); throw new
	 * HisException(e.getMessage()); } finally{ objTransaction.close();
	 * 
	 * }
	 * 
	 * 
	 * }
	 * 
	 * public int selectUnsuccessfulLoginLog(String userName) throws HisException {
	 * 
	 * JDBCTransactionContext objTransaction=new JDBCTransactionContext(); loginDao
	 * dao=new loginDao(objTransaction); int numberOfUnsuccessFulLogin=0;
	 * 
	 * try{ objTransaction.begin();
	 * numberOfUnsuccessFulLogin=dao.selectUnsuccessfulLoginLog(userName); }
	 * catch(Exception e){
	 * 
	 * e.printStackTrace(); objTransaction.rollback(); throw new
	 * HisException(e.getMessage()); } finally{ objTransaction.close();
	 * 
	 * }
	 * 
	 * return numberOfUnsuccessFulLogin; }
	 * 
	 * 
	 * public int selectMaxUserLicenseHospWise(String hospCode) throws HisException
	 * {
	 * 
	 * JDBCTransactionContext objTransaction=new JDBCTransactionContext(); loginDao
	 * dao=new loginDao(objTransaction); int numberOfLicense=0;
	 * 
	 * try{ objTransaction.begin();
	 * numberOfLicense=dao.selectMaxUserLicenseHospWise(hospCode); } catch(Exception
	 * e){
	 * 
	 * e.printStackTrace(); objTransaction.rollback(); throw new
	 * HisException(e.getMessage()); } finally{ objTransaction.close();
	 * 
	 * }
	 * 
	 * return numberOfLicense; }
	 * 
	 * public void updateUnsuccessfulLoginLog(String userName) throws HisException {
	 * 
	 * JDBCTransactionContext objTransaction=new JDBCTransactionContext(); loginDao
	 * dao=new loginDao(objTransaction); try{ objTransaction.begin();
	 * dao.updateUnsuccessfulLoginLog(userName);
	 * //numberOfUnsuccessFulLogin=dao.selectUnsuccessfulLoginLog(userName); }
	 * catch(Exception e){
	 * 
	 * e.printStackTrace(); objTransaction.rollback(); throw new
	 * HisException(e.getMessage()); } finally{ objTransaction.close();
	 * 
	 * }
	 * 
	 * 
	 * }
	 * 
	 * public void lockUserId(String userName) throws HisException {
	 * JDBCTransactionContext objTransaction=new JDBCTransactionContext(); loginDao
	 * dao=new loginDao(objTransaction); try{ objTransaction.begin();
	 * dao.updateIsLocked(userName);
	 * //numberOfUnsuccessFulLogin=dao.selectUnsuccessfulLoginLog(userName); }
	 * catch(Exception e){
	 * 
	 * e.printStackTrace(); objTransaction.rollback(); throw new
	 * HisException(e.getMessage()); } finally{ objTransaction.close();
	 * 
	 * }
	 * 
	 * 
	 * }
	 * 
	 * public Map getUserRolesAndPrivelages(String userId,String hospitalCode)
	 * throws HisException { login loginObj=new login(); JDBCTransactionContext
	 * objTransaction=new JDBCTransactionContext(); loginDao dao=new
	 * loginDao(objTransaction); String rolesList=""; String[] rolesArray=null;
	 * String[] roleIdArray=null; String[] rolenameArray=null; String
	 * privelagesList=""; List tablesList=new ArrayList(); Map EssentialMap=new
	 * HashMap();
	 * 
	 * try{ objTransaction.begin(); rolesList=dao.getUserRolesAndPrivelages(
	 * userId,hospitalCode);
	 * 
	 * 
	 * 
	 * 
	 * rolesArray=rolesList.split("#");
	 * 
	 * if(rolesArray!=null) {
	 * 
	 * roleIdArray=rolesArray[0].split("@"); rolenameArray=rolesArray[1].split("@");
	 * 
	 * if(rolesList!=null) EssentialMap.put(Config.LIST_OF_ROLES_CONCATE,rolesList);
	 * 
	 * if(roleIdArray!=null) EssentialMap.put(Config.LIST_OF_ROLES_ID,roleIdArray);
	 * 
	 * if(rolenameArray!=null)
	 * EssentialMap.put(Config.LIST_OF_ROLES_NAME,rolenameArray);
	 * 
	 * }
	 * 
	 * if(roleIdArray.length==1 && rolenameArray.length==1) { String
	 * roleId=roleIdArray[0]; String menusList=loginObj.getUserMenus(roleId,
	 * hospitalCode);
	 * 
	 * if(menusList!=null) EssentialMap.put(Config.LIST_OF_MENUS,menusList);
	 * 
	 * }
	 * 
	 * tablesList=dao.getTablePrivelages(userId, hospitalCode);
	 * 
	 * 
	 * if(tablesList!=null) privelagesList=dao.createPrivelages(userId,
	 * hospitalCode,tablesList);
	 * 
	 * if(privelagesList!=null)
	 * EssentialMap.put(Config.LIST_OF_PRIVELAGES,privelagesList);
	 * 
	 * 
	 * } catch(Exception e){
	 * 
	 * e.printStackTrace(); objTransaction.rollback(); throw new
	 * HisException(e.getMessage()); } finally{ objTransaction.close();
	 * 
	 * }
	 * 
	 * return EssentialMap; }
	 * 
	 * 
	 * public String getUserMenus(String roleId,String hospitalCode) throws
	 * HisException { JDBCTransactionContext objTransaction=new
	 * JDBCTransactionContext(); loginDao dao=new loginDao(objTransaction); String
	 * menusList="";
	 * 
	 * try{ objTransaction.begin(); menusList=dao.getUserMenus(
	 * roleId,hospitalCode);
	 * 
	 * } catch(Exception e){
	 * 
	 * e.printStackTrace(); objTransaction.rollback(); throw new
	 * HisException(e.getMessage()); } finally{ objTransaction.close();
	 * 
	 * }
	 * 
	 * return menusList; }
	 * 
	 * public String getUserAllMenus(String roleId,String hospitalCode) throws
	 * HisException { JDBCTransactionContext objTransaction=new
	 * JDBCTransactionContext(); loginDao dao=new loginDao(objTransaction); String
	 * allMenusList="";
	 * 
	 * try{ objTransaction.begin(); allMenusList=dao.getUserAllMenus(
	 * roleId,hospitalCode);
	 * 
	 * } catch(Exception e){
	 * 
	 * e.printStackTrace(); objTransaction.rollback(); throw new
	 * HisException(e.getMessage()); } finally{ objTransaction.close();
	 * 
	 * }
	 * 
	 * return allMenusList; } public String getMarqueMessage(UserVO _userVO){
	 * 
	 * String message="";
	 * 
	 * 
	 * JDBCTransactionContext objTransaction =new JDBCTransactionContext(); try{
	 * objTransaction.begin();
	 * 
	 * loginDao objEssentialDAO=new loginDao(objTransaction);
	 * message=objEssentialDAO.marqueMsg(_userVO);
	 * 
	 * } catch(HisRecordNotFoundException e){ objTransaction.rollback();
	 * e.getEssentialMap(); e.printStackTrace(); throw new
	 * HisRecordNotFoundException(e.getMessage()); }
	 * catch(HisApplicationExecutionException e){ objTransaction.rollback();
	 * e.printStackTrace(); throw new HisApplicationExecutionException(); }
	 * 
	 * catch(HisDataAccessException e){ objTransaction.rollback();
	 * e.printStackTrace(); throw new HisDataAccessException(); } catch(Exception
	 * e){ e.printStackTrace(); // System.out.println("error.... Essential BO");
	 * objTransaction.rollback(); throw new HisApplicationExecutionException(); }
	 * finally{ objTransaction.close(); } return message; }
	 * 
	 * 
	 * public login[] getAllLowLevelUsersForTheUserGroup(String userId,String
	 * hospitalCode) throws HisException { JDBCTransactionContext objTransaction=new
	 * JDBCTransactionContext(); loginDao dao=new loginDao(objTransaction); login[]
	 * loginObjArray=null;
	 * 
	 * try{ objTransaction.begin();
	 * loginObjArray=dao.getAllLowLevelUsersForTheUserGroup(userId,hospitalCode);
	 * 
	 * } catch(Exception e){
	 * 
	 * e.printStackTrace(); objTransaction.rollback(); throw new
	 * HisException(e.getMessage()); } finally{ objTransaction.close();
	 * 
	 * }
	 * 
	 * return loginObjArray; }
	 * 
	 * public int resetPassword(String superUserId,String userId,String
	 * hospitalCode, String userPassword) throws HisException {
	 * JDBCTransactionContext objTransaction=new JDBCTransactionContext(); loginDao
	 * dao=new loginDao(objTransaction); int result1=0; int result2=0;
	 * 
	 * try{ objTransaction.begin();
	 * result1=dao.resetPassword(superUserId,userId,hospitalCode,userPassword);
	 * 
	 * if(result1 > 0) result2=dao.resetPasswordUnsucessfullLog(userId,
	 * hospitalCode);
	 * 
	 * } catch(Exception e){
	 * 
	 * e.printStackTrace(); objTransaction.rollback(); throw new
	 * HisException(e.getMessage()); } finally{ objTransaction.close();
	 * 
	 * }
	 * 
	 * return result1; }
	 */
}
