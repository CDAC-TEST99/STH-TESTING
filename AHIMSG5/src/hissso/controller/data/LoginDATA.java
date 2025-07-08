package hissso.controller.data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import hisglobal.exceptions.HISDataAccessException;
import hisglobal.persistence.HelperMethodsDAO;
import hisglobal.transactionmgnt.HisDAO;
import usermgmt.bo.UserManagementBO;
import vo.hissso.LoginVO;
import vo.usermgmt.HospitalMasterVO;
import vo.usermgmt.MenuMasterVO;
import vo.usermgmt.UserLoginLogVO;
import vo.usermgmt.UserMasterVO;

public class LoginDATA
{
	
	
	public static UserMasterVO getValidUserDetail(LoginVO voLogin) throws HISDataAccessException
	{
		UserMasterVO voUser = null;
		try
		{
//			UserMgmtBOi objBusiness = new UserMgmtBO();
//			voUser = objBusiness.getValidUserDetail(voLogin);
			UserManagementBO objBusiness = new UserManagementBO();
			voUser = objBusiness.getUserValidLoginDetail(voLogin);
		}
		catch(Exception e)
		{
			voUser = null;
			throw new HISDataAccessException(e.getMessage());
		}
		return voUser;
	}
	
	
	public static List<HospitalMasterVO> getHospitalVos(String hospitalCode) throws Exception{
		
		UserManagementBO objBusiness = new UserManagementBO();
		return objBusiness.getHospitalVos(hospitalCode);
	}
	
	public static UserMasterVO getValidBenDetail(LoginVO voLogin) throws HISDataAccessException
	{
		UserMasterVO voUser = null;
		try
		{
//			UserMgmtBOi objBusiness = new UserMgmtBO();
//			voUser = objBusiness.getValidUserDetail(voLogin);
			UserManagementBO objBusiness = new UserManagementBO();
			voUser = objBusiness.getBenValidLoginDetail(voLogin);
		}
		catch(Exception e)
		{
			voUser = null;
			throw new HISDataAccessException(e.getMessage());
		}
		return voUser;
	}
	
	public static UserMasterVO getValidBenMobileDetail(LoginVO voLogin) throws HISDataAccessException
	{
		UserMasterVO voUser = null;
		try
		{
//			UserMgmtBOi objBusiness = new UserMgmtBO();
//			voUser = objBusiness.getValidUserDetail(voLogin);
			UserManagementBO objBusiness = new UserManagementBO();
			voUser = objBusiness.getBenValidLoginDetail(voLogin);
		}
		catch(Exception e)
		{
			voUser = null;
			throw new HISDataAccessException(e.getMessage());
		}
		return voUser;
	}
	
	
	public static UserMasterVO getmValidUserDetail(LoginVO voLogin) throws HISDataAccessException
	{
		UserMasterVO voUser = null;
		try
		{
//			UserMgmtBOi objBusiness = new UserMgmtBO();
//			voUser = objBusiness.getValidUserDetail(voLogin);
			UserManagementBO objBusiness = new UserManagementBO();
			voUser = objBusiness.getmUserValidLoginDetail(voLogin);
		}
		catch(Exception e)
		{
			voUser = null;
			throw new HISDataAccessException(e.getMessage());
		}
		return voUser;
	}
	
	
	public static UserMasterVO getmValidBenDetail(LoginVO voLogin) throws HISDataAccessException
	{
		UserMasterVO voUser = null;
		try
		{
//			UserMgmtBOi objBusiness = new UserMgmtBO();
//			voUser = objBusiness.getValidUserDetail(voLogin);
			UserManagementBO objBusiness = new UserManagementBO();
			voUser = objBusiness.getmBenValidLoginDetail(voLogin);
		}
		catch(Exception e)
		{
			voUser = null;
			throw new HISDataAccessException(e.getMessage());
		}
		return voUser;
	}
	
	/*
	 * ///MObileLogin
	 */
	/*
	 * public static UserMasterVO getValidUserMobileDetail(String mobileNumber)
	 * throws HISDataAccessException { UserMasterVO voMUser = null; try {
	 * UserManagementBO objBusiness = new UserManagementBO(); voMUser =
	 * objBusiness.getUserValidMLoginDetail(mobileNumber, true); } catch(Exception
	 * e) { voMUser = null; throw new HISDataAccessException(e.getMessage()); }
	 * return voMUser; }
	 */
	
	
	public static UserMasterVO updateActiveSessionFlag(UserMasterVO voUser) throws HISDataAccessException {
        try {
        	
        	//System.out.println("INSIDE LOGIN DATA 1");
                UserManagementBO objBusiness = new UserManagementBO();
                voUser = objBusiness.updateActiveSessionFlag(voUser);
              //  System.out.println("INSIDE LOGIN DATA 2"+voUser.getActiveSessionFlag());
        } catch (Exception e) {
                voUser = null;
                throw new HISDataAccessException(e.getMessage());
        }
        return voUser;
}
	
	
	public static UserMasterVO updateActiveSessionFlagBen(UserMasterVO voUser) throws HISDataAccessException {
        try {
        	
        //	System.out.println("INSIDE LOGIN DATA 1");
                UserManagementBO objBusiness = new UserManagementBO();
                voUser = objBusiness.updateActiveSessionFlagBen(voUser);
              //  System.out.println("INSIDE LOGIN DATA 2"+voUser.getActiveSessionFlag());
        } catch (Exception e) {
                voUser = null;
                throw new HISDataAccessException(e.getMessage());
        }
        return voUser;
}
	

	public static UserLoginLogVO updateActiveSessionFlagLogout(UserLoginLogVO voUser) throws HISDataAccessException {
        
        try {
                UserManagementBO objBusiness = new UserManagementBO();
                voUser = objBusiness.updateActiveSessionFlagLogout(voUser);
        } catch (Exception e) {
                voUser = null;
                throw new HISDataAccessException(e.getMessage());
        }
        return voUser;
}

	public static List<MenuMasterVO> getUserAuthorizationDetail(UserMasterVO voUser) throws HISDataAccessException
	{
		List<MenuMasterVO> lstMenus = null;
		try
		{
//			UserMgmtBOi objBusiness = new UserMgmtBO();
//			lstMenus = objBusiness.getUserAuthorizationDetail(voUser);
			UserManagementBO objBusiness = new UserManagementBO();
			lstMenus = objBusiness.getUserMenusList(voUser);
		}
		catch(Exception e)
		{
			lstMenus = null;
			throw new HISDataAccessException(e.getMessage());
		}
		return lstMenus;
	}

	public static Map<String, Object> logUserLoginDetail(UserLoginLogVO voLogUser) throws HISDataAccessException
	{
		Map<String, Object> mpData = null;
		try
		{
			UserManagementBO objBusiness = new UserManagementBO();
			mpData = objBusiness.logUserSuccessfulLogin(voLogUser);
		}
		catch(Exception e)
		{
			mpData = null;
			throw new HISDataAccessException(e.getMessage());
		}
		return mpData;
	}
	
	
	public static Map<String, Object> logBenLoginDetail(UserLoginLogVO voLogUser) throws HISDataAccessException
	{
		Map<String, Object> mpData = null;
		try
		{
			UserManagementBO objBusiness = new UserManagementBO();
			mpData = objBusiness.logBenSuccessfulLogin(voLogUser);
		}
		catch(Exception e)
		{
			mpData = null;
			throw new HISDataAccessException(e.getMessage());
		}
		return mpData;
	}

	public static boolean logUserLogoutDetail(UserLoginLogVO voLogUser) throws HISDataAccessException
	{
		boolean flg = true;
		try
		{
//			UserMgmtBOi objBusiness = new UserMgmtBO();
//			if(!objBusiness.logUserLogoutDetail(voLogUser))
//				throw new HISDataAccessException("Can't Log User Logout Detail");

			UserManagementBO objBusiness = new UserManagementBO();
			objBusiness.logUserSuccessfulLogout(voLogUser);
		}
		catch(Exception e)
		{
			flg = false;
			throw new HISDataAccessException(e.getMessage());
		}
		return flg;
	}
	
	
	public static boolean logBenLogoutDetail(UserLoginLogVO voLogUser) throws HISDataAccessException
	{
		boolean flg = true;
		try
		{
//			UserMgmtBOi objBusiness = new UserMgmtBO();
//			if(!objBusiness.logUserLogoutDetail(voLogUser))
//				throw new HISDataAccessException("Can't Log User Logout Detail");

			UserManagementBO objBusiness = new UserManagementBO();
			objBusiness.logBenSuccessfulLogout(voLogUser);
		}
		catch(Exception e)
		{
			flg = false;
			throw new HISDataAccessException(e.getMessage());
		}
		return flg;
	}
	
	 
	public static List getHospitalList()
	{
		List alRecord = new ArrayList(); 
		HisDAO hisDAO_p = new HisDAO("Reg", "regbo");
		ResultSet rs = null;
		final String strProcName = "{call PKG_CLINICAL_UTIL_VIEW.proc_gblt_hospital_mst_login_combo(?,?,?,?)}";
		final int nProcedureIndex;
		final String strDbErr;
		try
		{
			nProcedureIndex = hisDAO_p.setProcedure(strProcName);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_mode","1",1);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_gnum_isvalid","1",2);
			//hisDAO_p.setProcInValue(nProcedureIndex, "p_gnum_moduleId",RegistrationConfig.MODULE_ID_REGISTRATION,3);
			//hisDAO_p.setProcInValue(nProcedureIndex, "p_gnum_seatId",uservo.getUserSeatId(),3);
			//hisDAO_p.setProcInValue(nProcedureIndex, "p_gnum_hoscode",uservo.getHospitalCode(),4);

			hisDAO_p.setProcOutValue(nProcedureIndex, "err", 1,3); 
			hisDAO_p.setProcOutValue(nProcedureIndex, "resultset", 2,4);

			hisDAO_p.executeProcedureByPosition(nProcedureIndex);

			strDbErr = hisDAO_p.getString(nProcedureIndex, "err");
			
			rs = hisDAO_p.getWebRowSet(nProcedureIndex, "resultset");			

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new HISDataAccessException(e.getMessage());
		}

		try 
		{
			if (!rs.next()) 
			{
				//throw new HisRecordNotFoundException("hospital List Not Found");
			}
			else
			{
				rs.beforeFirst();
				alRecord=HelperMethodsDAO.getAlOfEntryObjects(rs);
			}
		}
		catch (Exception e) 
		{
			throw new HISDataAccessException(e.getMessage());
		}
		finally 
		{
			if (hisDAO_p != null) 
			{
				hisDAO_p.free();hisDAO_p = null;
			}
		}

		return alRecord;
	}
	
	public static void saveDesktopClientInfo(UserLoginLogVO voLogUser) throws HISDataAccessException
	{
		try
		{
			UserManagementBO objBusiness = new UserManagementBO();
			objBusiness.saveDesktopClientInfo(voLogUser);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new HISDataAccessException(e.getMessage());
		}
	}


	public static boolean changePasswordFirst(LoginVO voLogin) {
	 
		boolean flag = false;
		final int nProcedureIndex;
		String strDbErr = "";
		String proc = "{call  pkg_usermgmt_new.dml_change_password_firstlogin_mst(?,?,?,?,?,?) }";
		HisDAO hisDAO_p = new HisDAO("Login", "loginbo");
	
		try
		{
			nProcedureIndex = hisDAO_p.setProcedure(proc);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_mode","1",1);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_user_id",new String(Base64.getDecoder().decode(voLogin.getVarUserId())) ,2);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_user_name",new String(Base64.getDecoder().decode(voLogin.getVarUserName())),3);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_oldPassword", new String(Base64.getDecoder().decode(voLogin.getVarOldPassword())) ,4);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_newPassword", new String(Base64.getDecoder().decode(voLogin.getVarPassword())) ,5);
			hisDAO_p.setProcOutValue(nProcedureIndex, "err", 1,6); 
			

			hisDAO_p.executeProcedureByPosition(nProcedureIndex);

			strDbErr = hisDAO_p.getString(nProcedureIndex, "err");
			 	
			if(strDbErr == null)
				strDbErr = "";
			
			
			if(strDbErr != null && !strDbErr.equals("")) {
				flag = false;
				throw new Exception(strDbErr);
				 	
				
			}else {
				
			flag = true;	
			}
			
 
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			flag = false;
			
		}
 
		finally 
		{
			if (hisDAO_p != null) 
			{
				hisDAO_p.free();
				hisDAO_p = null;
			}
		}
		
		 return flag;
	}
	
	public static boolean changePasswordFirstBen(LoginVO voLogin) { 		// Used in 2 places forget and register new password
		 
		boolean flag = false;
		final int nProcedureIndex;
		String strDbErr = "";
		String proc = "{call  pkg_usermgmt_new.dml_change_password_firstlogin_mst(?,?,?,?,?,?) }";
		HisDAO hisDAO_p = new HisDAO("Login", "loginbo");
	
		try
		{	
			nProcedureIndex = hisDAO_p.setProcedure(proc);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_mode","4",1);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_user_id",voLogin.getVarUserName()  ,2);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_user_name",voLogin.getVarUserName(),3);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_oldPassword", new String(Base64.getDecoder().decode(voLogin.getVarOldPassword())) ,4);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_newPassword", new String(Base64.getDecoder().decode(voLogin.getVarPassword())) ,5);
			hisDAO_p.setProcOutValue(nProcedureIndex, "err", 1,6); 
			

			hisDAO_p.executeProcedureByPosition(nProcedureIndex);

			strDbErr = hisDAO_p.getString(nProcedureIndex, "err");
			 	
			if(strDbErr == null)
				strDbErr = "";
			
			
			if(strDbErr != null && !strDbErr.equals("")) {
				flag = false;
				throw new Exception(strDbErr);
				 	
				
			}else {
				
			flag = true;	
			}
			
 
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			flag = false;
			
		}
 
		finally 
		{
			if (hisDAO_p != null) 
			{
				hisDAO_p.free();
				hisDAO_p = null;
			}
		}
		
		 return flag;
	}
	
	
	public static boolean RegistersaveBenPassword(LoginVO voLogin) { 		// Used in 2 places forget and register new password
		 
		boolean flag = false;
		final int nProcedureIndex;
		String strDbErr = "";
		String proc = "{call  pkg_usermgmt_new.dml_change_password_firstlogin_mst(?,?,?,?,?,?) }";
		HisDAO hisDAO_p = new HisDAO("Login", "loginbo");
	
		try
		{	
			nProcedureIndex = hisDAO_p.setProcedure(proc);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_mode","4",1);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_user_id", new String(Base64.getDecoder().decode(voLogin.getVarUserName()))  ,2);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_user_name",new String(Base64.getDecoder().decode(voLogin.getVarUserName())),3);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_oldPassword", new String(Base64.getDecoder().decode(voLogin.getVarPassword())) ,4); //  No use
			hisDAO_p.setProcInValue(nProcedureIndex, "p_newPassword", new String(Base64.getDecoder().decode(voLogin.getVarPassword())) ,5);
			hisDAO_p.setProcOutValue(nProcedureIndex, "err", 1,6); 
			

			hisDAO_p.executeProcedureByPosition(nProcedureIndex);

			strDbErr = hisDAO_p.getString(nProcedureIndex, "err");
			 	
			if(strDbErr == null)
				strDbErr = "";
			
			
			if(strDbErr != null && !strDbErr.equals("")) {
				flag = false;
				throw new Exception(strDbErr);
				 	
				
			}else {
				
			flag = true;	
			}
			
 
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			flag = false;
			
		}
 
		finally 
		{
			if (hisDAO_p != null) 
			{
				hisDAO_p.free();
				hisDAO_p = null;
			}
		}
		
		 return flag;
	}
	
	
	public static boolean changePasswordReset(String NewPassword, String userId) {
		 
		boolean flag = false;
		final int nProcedureIndex;
		String strDbErr = "";
		String proc = "{call  pkg_usermgmt_new.dml_change_password_firstlogin_mst(?,?,?,?,?,?) }";
		HisDAO hisDAO_p = new HisDAO("Login", "loginbo");
	
		try
		{
			nProcedureIndex = hisDAO_p.setProcedure(proc);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_mode","2",1);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_user_id",userId ,2);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_user_name",userId,3);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_oldPassword", userId ,4);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_newPassword",NewPassword ,5);
			hisDAO_p.setProcOutValue(nProcedureIndex, "err", 1,6); 
			

			hisDAO_p.executeProcedureByPosition(nProcedureIndex);

			strDbErr = hisDAO_p.getString(nProcedureIndex, "err");
			 	
			if(strDbErr == null)
				strDbErr = "";
			
			
			if(strDbErr != null && !strDbErr.equals("")) {
				flag = false;
				throw new Exception(strDbErr);
				 	
				
			}else {
				
			flag = true;	
			}
			
 
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			flag = false;
			
		}
 
		finally 
		{
			if (hisDAO_p != null) 
			{
				hisDAO_p.free();
				hisDAO_p = null;
			}
		}
		
		 return flag;
	}
	
	public static boolean changePasswordResetBen(String NewPassword, String userId) {
		 
		boolean flag = false;
		final int nProcedureIndex;
		String strDbErr = "";
		String proc = "{call  pkg_usermgmt_new.dml_change_password_firstlogin_mst(?,?,?,?,?,?) }";
		HisDAO hisDAO_p = new HisDAO("Login", "loginbo");
	
		try
		{
			nProcedureIndex = hisDAO_p.setProcedure(proc);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_mode","3",1);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_user_id",userId ,2);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_user_name",userId,3);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_oldPassword", userId ,4);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_newPassword",NewPassword ,5);
			hisDAO_p.setProcOutValue(nProcedureIndex, "err", 1,6); 
			

			hisDAO_p.executeProcedureByPosition(nProcedureIndex);

			strDbErr = hisDAO_p.getString(nProcedureIndex, "err");
			 	
			if(strDbErr == null)
				strDbErr = "";
			
			
			if(strDbErr != null && !strDbErr.equals("")) {
				flag = false;
				throw new Exception(strDbErr);
				 	
				
			}else {
				
			flag = true;	
			}
			
 
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			flag = false;
			
		}
 
		finally 
		{
			if (hisDAO_p != null) 
			{
				hisDAO_p.free();
				hisDAO_p = null;
			}
		}
		
		 return flag;
	}
	
	public static boolean unlockBenProc( String userId) {
		 
		boolean flag = false;
		final int nProcedureIndex;
		String strDbErr = "";
		String proc = "{call  pkg_usermgmt_new.dml_unlock_beneficiary(?,?,?) }";
		HisDAO hisDAO_p = new HisDAO("Login", "loginbo");
		
		try
		{
			nProcedureIndex = hisDAO_p.setProcedure(proc);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_mode","1",1);
			hisDAO_p.setProcInValue(nProcedureIndex, "p_user_id",userId ,2);
			hisDAO_p.setProcOutValue(nProcedureIndex, "err", 1,3); 
			

			hisDAO_p.executeProcedureByPosition(nProcedureIndex);

			strDbErr = hisDAO_p.getString(nProcedureIndex, "err");
			 	
			if(strDbErr == null)
				strDbErr = "";
			
			
			if(strDbErr != null && !strDbErr.equals("")) {
				flag = false;
				throw new Exception(strDbErr);
				 	
				
			}else {
				
			flag = true;	
			}
			
 
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			flag = false;
			
		}
 
		finally 
		{
			if (hisDAO_p != null) 
			{
				hisDAO_p.free();
				hisDAO_p = null;
			}
		}
		
		 return flag;
	}
	
	
}
