   package hislogin.transactions.utl;

import hisglobal.config.HISConfig;
import hisglobal.exceptions.old.HisException;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.Entry;
import hisglobal.utility.HisUtil;
import hisglobal.utility.helper.DateHelperMethods;
import hislogin.transactions.action.LoginFeaturesACT;
import hislogin.transactions.actionsupport.LoginFeatureSUP;
import hislogin.transactions.data.LoginFeaturesDATA;
import hissso.config.HISSSOConfig;
import hissso.config.HISSSOServerConfig;
import hissso.security.SecureHashAlgorithm;
import hissso.validation.credentails.authentication.AuthenticationCredentials;
import hissso.validation.credentails.authorization.AuthorizationCredentials;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.WebRowSet;
import org.apache.commons.beanutils.BeanUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vo.hissso.LoginVO;
import vo.usermgmt.MenuMasterVO;
import vo.usermgmt.UserLoginLogVO;
import vo.usermgmt.UserMasterVO;

public class LoginFeaturesUTL {
   public static String LOG_FEATURE_STATUS_INITIAL = "INITIAL";
   public static String LOG_FEATURE_STATUS_NEW_PASSWORD = "NEW_PASSWORD";
   public static String LOG_FEATURE_STATUS_MOBILE_VERIFICATION = "MOBILE_VERIFICATION";
   public static String LOG_FEATURE_STATUS_CHANGE_PASSWORD = "CHANGE_PASSWORD";
   public static String LOG_FEATURE_STATUS_CHANGE_USER_DETAILS = "CHANGE_USER_DETAILS";
   public static String LOG_FEATURE_STATUS_ADD_UPDATE_MOBILE_NO = "ADD_UPDATE_MOBILE_NO";
   public static String LOG_FEATURE_STATUS_NEW_USER_DETAILS = "NEW_USER_DETAILS";
   public static String LOG_FEATURE_STATUS_USER_LOG_DETAILS = "USER_LOG_DETAILS";
   private static final int OTP_MAX_LENGTH = 4;
   public static String LOG_FEATURE_STATUS_DONE = "DONE";
   static LinkedHashMap<String, String> emailOTPmap = new LinkedHashMap();
   static LinkedHashMap<String, String> otpmap = new LinkedHashMap();

   public static boolean initForgotPassword(LoginFeatureSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse) {
      boolean flg = true;
      HttpSession objSession = null;

      try {
         objActionSupport.setVarStatus(LOG_FEATURE_STATUS_INITIAL);
         objSession = objRequest.getSession();
         String randomSessionSalt = SecureHashAlgorithm.getRandomSalt(HISSSOServerConfig.LOGIN_SESSION_SALT_BYTE_SIZE);
         objSession.setAttribute(HISSSOServerConfig.LOGIN_FEATURES_SESSION_SALT, randomSessionSalt);
         objActionSupport.clear();
      } catch (Exception var6) {
         flg = false;
         objActionSupport.addActionError("Unknown Problem Occured!");
         var6.printStackTrace();
      }

      return flg;
   }

   public static boolean validateForgotPassword(LoginFeatureSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse) {
      boolean flg = false;
      HttpSession objSession = null;

      try {
         objSession = objRequest.getSession();
         String strSessionSalt = (String)objSession.getAttribute(HISSSOServerConfig.LOGIN_FEATURES_SESSION_SALT);
         LoginVO voLogin = new LoginVO();
         BeanUtils.copyProperties(voLogin, objActionSupport);
         voLogin.setVarLoginSessionSalt(strSessionSalt);
         voLogin.setVarIPAddress(objRequest.getRemoteAddr());
         String randomSessionSalt = SecureHashAlgorithm.getRandomSalt(HISSSOServerConfig.LOGIN_SESSION_SALT_BYTE_SIZE);
         objSession.setAttribute(HISSSOServerConfig.LOGIN_FEATURES_SESSION_SALT, randomSessionSalt);
         UserMasterVO voUser = LoginFeaturesDATA.getValidForgotDetail(voLogin);
         if (voUser != null && !voUser.getVarLoggedIn().equals(HISConfig.NO)) {
            flg = true;
            BeanUtils.copyProperties(objActionSupport, voUser);
            objSession.setAttribute("keyLoginFeaturesUserVO", voUser);
            AuthorizationCredentials objAuthorization = (AuthorizationCredentials)objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHORIZATION_OBJECT);
            objActionSupport.setVarStatus(LOG_FEATURE_STATUS_NEW_PASSWORD);
         } else {
            flg = false;
            if (voUser != null) {
               objActionSupport.addActionError(voUser.getVarLoginMessage());
            } else {
               objActionSupport.addActionError("Invalid Details!");
            }

            objActionSupport.setVarStatus(LOG_FEATURE_STATUS_INITIAL);
            objActionSupport.clear();
         }
      } catch (Exception var10) {
         flg = false;
         objActionSupport.addActionError("Unknown Problem Occured!");
         objActionSupport.clear();
         var10.printStackTrace();
      }

      return flg;
   }

   public static String CheckLoginID(String loginID) {
      HisDAO hisdao = new HisDAO("LabRptRegistrationServlet", "CheckMobileNo()");
      WebRowSet wb = null;
      String status = null;

      try {
         String query = "select nvl(gstr_email_id,'reenasharma@cdac.in') from UMMT_USER_MST  where GSTR_LOGIN_ID='" + loginID + "'";
         int nIndex = hisdao.setQuery(query);

         for(wb = hisdao.executeQry(nIndex); wb.next(); status = wb.getString(1)) {
         }
      } catch (Exception var6) {
         var6.printStackTrace();
      }

      return status;
   }

   public static boolean saveForgotPassword(LoginFeatureSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse) {
      boolean flg = true;
      HttpSession objSession = null;

      try {
         objSession = objRequest.getSession();
         UserMasterVO voUser = (UserMasterVO)objSession.getAttribute("keyLoginFeaturesUserVO");
         UserMasterVO voUserNew = new UserMasterVO();
         BeanUtils.copyProperties(voUserNew, voUser);
         voUserNew.setVarUserId(voUser.getVarUserId());
         voUserNew.setVarHospitalCode(voUser.getVarHospitalCode());
         voUserNew.setVarSeatId(voUser.getVarUserId());
         voUserNew.setVarUserSeatId(voUser.getVarUserSeatId());
         voUserNew.setVarOldPassword(voUser.getVarPassword());
         voUserNew.setVarPassword(objActionSupport.getVarPassword());
         String oldPwd = voUser.getVarOldPassword();
         String newPwd = voUserNew.getVarPassword();
         if (oldPwd.equals(newPwd)) {
            objActionSupport.addActionError("New Password can't be same as Old Password. Kindly choose another password to proceed.");
         } else {
            LoginFeaturesDATA.changeForgotPassword(voUserNew);
            objActionSupport.setVarStatus(LOG_FEATURE_STATUS_DONE);
            objActionSupport.addActionError("Password Changed Successfully!");
         }
      } catch (Exception var9) {
         flg = false;
         objActionSupport.addActionError("Unknown Problem Occured! Your Password is not Changed!");
         objActionSupport.clear();
         var9.printStackTrace();
      }

      return flg;
   }

   public static boolean initFirstLogin(LoginFeatureSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse) {
      boolean flg = true;
      HttpSession objSession = null;

      try {
         objActionSupport.clear();
         objSession = objRequest.getSession();
         AuthenticationCredentials objAuthenticate = (AuthenticationCredentials)objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
         if (objAuthenticate == null) {
            return false;
         }

         objActionSupport.setVarUserName(objAuthenticate.getVoUser().getVarUserName());
         objActionSupport.setVarUsrName(objAuthenticate.getVoUser().getVarUsrName());
         List<Entry> lstQuestions = LoginFeaturesDATA.getQuestionList(new UserMasterVO());
         objSession.setAttribute("keyQuestionList", lstQuestions);
      } catch (Exception var7) {
         flg = false;
         objActionSupport.addActionError("Unknown Problem Occured!");
         var7.printStackTrace();
      }

      return flg;
   }

   public static boolean saveFirstLogin(LoginFeatureSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse) {
      boolean flg = true;
      HttpSession objSession = null;

      try {
         objSession = objRequest.getSession();
         AuthenticationCredentials objAuthenticate = (AuthenticationCredentials)objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
         UserMasterVO voUser = objAuthenticate.getVoUser();
         UserMasterVO voUserNew = new UserMasterVO();
         BeanUtils.copyProperties(voUserNew, objActionSupport);
         voUserNew.setVarUserId(voUser.getVarUserId());
         voUserNew.setVarHospitalCode(voUser.getVarHospitalCode());
         voUserNew.setVarOldPassword(voUser.getVarPassword());
         voUserNew.setVarSeatId(voUser.getVarSeatId());
         LoginFeaturesDATA.changeUserDetail(voUserNew);
         voUser.setVarQuestionId(objActionSupport.getVarQuestionId());
         voUser.setVarHintAnswer(objActionSupport.getVarHintAnswer());
         voUser.setVarOldPassword(voUser.getVarPassword());
         voUser.setVarPassword(objActionSupport.getVarPassword());
         objActionSupport.setVarStatus(LOG_FEATURE_STATUS_DONE);
         objActionSupport.addActionError("User Detail Changed Successfully!");
      } catch (Exception var8) {
         flg = false;
         objActionSupport.addActionError("Unknown Problem Occured! Your Password is not Changed!");
         objActionSupport.clear();
         var8.printStackTrace();
      }

      return flg;
   }

   public static boolean initChangePassword(LoginFeatureSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse) {
      boolean flg = true;
      HttpSession objSession = null;

      try {
         objActionSupport.clear();
         objSession = objRequest.getSession();
         AuthenticationCredentials objAuthenticate = (AuthenticationCredentials)objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
         if (objAuthenticate == null) {
            return false;
         }

         objActionSupport.setVarUserName(objAuthenticate.getVoUser().getVarUserName());
      } catch (Exception var6) {
         flg = false;
         objActionSupport.addActionError("Unknown Problem Occured!");
         var6.printStackTrace();
      }

      return flg;
   }

   public static boolean saveChangePassword(LoginFeatureSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse) {
      boolean flg = true;
      String oldPassword = "";
      String oldPassword2 = "";
      String oldPassword3 = "";
      String oldPassword4 = "";
      String oldPassword5 = "";
      HttpSession objSession = null;

      try {
         objSession = objRequest.getSession();
         AuthenticationCredentials objAuthenticate = (AuthenticationCredentials)objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
         UserMasterVO voUser = objAuthenticate.getVoUser();
         if (!voUser.getVarPassword().equals(objActionSupport.getVarOldPassword())) {
            objActionSupport.addActionError("Old Password is Wrong!");
         } else {
            UserMasterVO voUserNew = new UserMasterVO();
            BeanUtils.copyProperties(voUserNew, objActionSupport);
            voUserNew.setVarUserId(voUser.getVarUserId());
            voUserNew.setVarHospitalCode(voUser.getVarHospitalCode());
            voUserNew.setVarSeatId(voUser.getVarUserId());
            voUserNew.setVarUserSeatId(voUser.getVarUserSeatId());
            List<UserMasterVO> lstUserMasterVO = LoginFeaturesDATA.getUserDetail(voUser.getVarUserName());

            UserMasterVO obj;
            for(Iterator var15 = lstUserMasterVO.iterator(); var15.hasNext(); oldPassword4 = obj.getVarOldPassword4() == null ? "" : obj.getVarOldPassword4()) {
               obj = (UserMasterVO)var15.next();
               oldPassword = obj.getVarPassword();
               oldPassword2 = obj.getVarOldPassword2() == null ? "" : obj.getVarOldPassword2();
               oldPassword3 = obj.getVarOldPassword3() == null ? "" : obj.getVarOldPassword3();
            }

            if (objActionSupport.getVarPassword().equals(oldPassword) || objActionSupport.getVarPassword().equals(oldPassword2) || objActionSupport.getVarPassword().equals(oldPassword3) || objActionSupport.getVarPassword().equals(oldPassword4)) {
               objActionSupport.addActionError("New Password should not match last 5 Passwords!");
               return false;
            }

            LoginFeaturesDATA.changeUserPasswordDetail(voUserNew);
            voUser.setVarOldPassword(voUser.getVarPassword());
            voUser.setVarPassword(objActionSupport.getVarPassword());
            objActionSupport.setVarStatus(LOG_FEATURE_STATUS_DONE);
            objActionSupport.addActionError("User Password Changed Successfully!");
         }
      } catch (Exception var16) {
         flg = false;
         objActionSupport.addActionError("Unknown Problem Occured! Your Password is not Changed!");
         objActionSupport.clear();
         var16.printStackTrace();
      }

      return flg;
   }

   public static boolean initChangeUserDetails(LoginFeatureSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse) {
      boolean flg = true;
      HttpSession objSession = null;

      try {
         objSession = objRequest.getSession();
         objActionSupport.setVarStatus(LOG_FEATURE_STATUS_INITIAL);
         AuthenticationCredentials objAuthenticate = (AuthenticationCredentials)objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
         if (objAuthenticate != null) {
            objActionSupport.setVarUserName(objAuthenticate.getVoUser().getVarUserName());
         }
      } catch (Exception var6) {
         flg = false;
         objActionSupport.addActionError("Unknown Problem Occured!");
         var6.printStackTrace();
      }

      return flg;
   }

   public static boolean initAddUpdateMobileNo(LoginFeatureSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse) {
      boolean flg = true;
      HttpSession objSession = null;

      try {
         objSession = objRequest.getSession();
         objActionSupport.setVarStatus(LOG_FEATURE_STATUS_INITIAL);
         AuthenticationCredentials objAuthenticate = (AuthenticationCredentials)objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
         if (objAuthenticate != null) {
            objActionSupport.setVarUserName(objAuthenticate.getVoUser().getVarUserName());
         }
      } catch (Exception var6) {
         flg = false;
         objActionSupport.addActionError("Unknown Problem Occured!");
         var6.printStackTrace();
      }

      return flg;
   }

   public static boolean validateAddUpdatePassword(LoginFeatureSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse) {
      boolean flg = true;
      HttpSession objSession = null;

      try {
         objSession = objRequest.getSession();
         AuthenticationCredentials objAuthenticate = (AuthenticationCredentials)objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
         UserMasterVO voUser = objAuthenticate.getVoUser();
         if (!voUser.getVarPassword().equals(objActionSupport.getVarPassword())) {
            objActionSupport.setVarPassword("");
            objActionSupport.setVarStatus(LOG_FEATURE_STATUS_INITIAL);
            objActionSupport.addActionError("Password is Wrong!");
         } else {
            flg = true;
            BeanUtils.copyProperties(objActionSupport, voUser);
            objActionSupport.setVarOldHintAnswer(objAuthenticate.getVoUser().getVarHintAnswer());
            objSession.setAttribute("keyLoginFeaturesUserVO", voUser);
            AuthorizationCredentials objAuthorization = (AuthorizationCredentials)objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHORIZATION_OBJECT);
            objActionSupport.setVarStatus(LOG_FEATURE_STATUS_ADD_UPDATE_MOBILE_NO);
         }
      } catch (Exception var8) {
         flg = false;
         objActionSupport.addActionError("Unknown Problem Occured!");
         objActionSupport.clear();
         var8.printStackTrace();
      }

      return flg;
   }

   public static boolean saveAddUpdateMobileNo(LoginFeatureSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse) {
      boolean flg = true;
      HttpSession objSession = null;

      try {
         objSession = objRequest.getSession();
         String varNewMobileNumber = objRequest.getParameter("varNewMobileNumber");
         AuthenticationCredentials objAuthenticate = (AuthenticationCredentials)objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
         UserMasterVO voUser = objAuthenticate.getVoUser();
         UserMasterVO voUserFinal = new UserMasterVO();
         BeanUtils.copyProperties(voUserFinal, voUser);
         voUserFinal.setVarMobileNumber(varNewMobileNumber);
         LoginFeaturesDATA.addUpdateMobileNo(voUserFinal);
         voUser.setVarMobileNumber(varNewMobileNumber);
         objActionSupport.setVarStatus(LOG_FEATURE_STATUS_INITIAL);
         objActionSupport.addActionError("User Mobile No Added/Changed Successfully! Refresh or Re-login to see changes.");
      } catch (Exception var9) {
         flg = false;
         objActionSupport.addActionError("Unknown Problem Occured! Your User Login details are not Changed!" + var9.getMessage());
         objActionSupport.clear();
         var9.printStackTrace();
      }

      return flg;
   }

   public static boolean validatePassword(LoginFeatureSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse) {
      boolean flg = true;
      HttpSession objSession = null;

      try {
         objSession = objRequest.getSession();
         AuthenticationCredentials objAuthenticate = (AuthenticationCredentials)objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
         UserMasterVO voUser = objAuthenticate.getVoUser();
         if (!voUser.getVarPassword().equals(objActionSupport.getVarPassword())) {
            objActionSupport.setVarPassword("");
            objActionSupport.setVarStatus(LOG_FEATURE_STATUS_INITIAL);
            objActionSupport.addActionError("Password is Wrong!");
         } else {
            flg = true;
            BeanUtils.copyProperties(objActionSupport, voUser);
            objActionSupport.setVarOldHintAnswer(objAuthenticate.getVoUser().getVarHintAnswer());
            objSession.setAttribute("keyLoginFeaturesUserVO", voUser);
            List<Entry> lstQuestions = LoginFeaturesDATA.getQuestionList(new UserMasterVO());
            objSession.setAttribute("keyQuestionList", lstQuestions);
            AuthorizationCredentials objAuthorization = (AuthorizationCredentials)objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHORIZATION_OBJECT);
            if (objAuthorization != null) {
               List<Entry> lstDefMenus = new ArrayList();
               HashSet<String> lstModules = new HashSet();
               List<Entry> lstModuleNames = new ArrayList();
               List<MenuMasterVO> lstMenus = objAuthorization.getMenuList();
               if (lstMenus != null) {
                  Iterator var14 = lstMenus.iterator();

                  Entry objEn;
                  while(var14.hasNext()) {
                     MenuMasterVO v = (MenuMasterVO)var14.next();
                     objEn = new Entry();
                     objEn.setLabel(v.getVarModuleName() + "->" + v.getVarMenuName());
                     objEn.setValue(v.getVarMenuId());
                     lstDefMenus.add(objEn);
                     new String();
                     String str = v.getVarModuleName();
                     lstModules.add(str);
                  }

                  var14 = lstModules.iterator();

                  while(var14.hasNext()) {
                     String str = (String)var14.next();
                     objEn = new Entry();
                     objEn.setLabel(str);
                     objEn.setValue(str);
                     lstModuleNames.add(objEn);
                  }
               }

               List<MenuMasterVO> lstManuals = objAuthorization.getManualList();
               List<Entry> lstDefManuals = new ArrayList();
               if (lstManuals != null) {
                  Iterator var26 = lstManuals.iterator();

                  Entry objEn;
                  while(var26.hasNext()) {
                     MenuMasterVO v = (MenuMasterVO)var26.next();
                     objEn = new Entry();
                     objEn.setLabel(v.getVarModuleName() + "->" + v.getVarMenuName());
                     objEn.setValue(v.getVarMenuId());
                     lstDefManuals.add(objEn);
                     new String();
                     String str = v.getVarModuleName();
                     lstModules.add(str);
                  }

                  var26 = lstModules.iterator();

                  while(var26.hasNext()) {
                     String str = (String)var26.next();
                     objEn = new Entry();
                     objEn.setLabel(str);
                     objEn.setValue(str);
                     lstModuleNames.add(objEn);
                  }
               }

               List<MenuMasterVO> lstFavourite = (List)objSession.getAttribute("keyLoggedInUserFavouriteMenuList");
               List<Entry> lstFavourites = new ArrayList();
               if (lstFavourite != null) {
                  Iterator var30 = lstFavourite.iterator();

                  while(var30.hasNext()) {
                     MenuMasterVO v = (MenuMasterVO)var30.next();
                     Entry objEnt = new Entry();
                     objEnt.setLabel(v.getVarMenuName());
                     objEnt.setValue(v.getVarMenuId());
                     lstFavourites.add(objEnt);
                  }
               }

               objSession.setAttribute("keyMenuList", lstDefMenus);
               objSession.setAttribute("keyManualList", lstDefManuals);
               objSession.setAttribute("keyModuleList", lstModuleNames);
               objSession.setAttribute("keyModuleMenuList", new ArrayList());
               objSession.setAttribute("keyModuleManualList", new ArrayList());
               objSession.setAttribute("keyFavouriteList", lstFavourites);
            }

            objActionSupport.setVarStatus(LOG_FEATURE_STATUS_CHANGE_USER_DETAILS);
         }
      } catch (Exception var20) {
         flg = false;
         objActionSupport.addActionError("Unknown Problem Occured!");
         objActionSupport.clear();
         var20.printStackTrace();
      }

      return flg;
   }

   public static boolean saveChangeUserDetails(LoginFeatureSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse) {
      boolean flg = true;
      HttpSession objSession = null;

      try {
         objSession = objRequest.getSession();
         AuthenticationCredentials objAuthenticate = (AuthenticationCredentials)objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
         UserMasterVO voUser = objAuthenticate.getVoUser();
         UserMasterVO voUserFinal = new UserMasterVO();
         BeanUtils.copyProperties(voUserFinal, voUser);
         voUserFinal.setVarQuestionId(objActionSupport.getVarQuestionId());
         voUserFinal.setVarHintAnswer(objActionSupport.getVarHintAnswer());
         voUserFinal.setVarMobileNumber(objActionSupport.getVarMobileNumber());
         voUserFinal.setVarEmailId(objActionSupport.getVarEmailId());
         voUserFinal.setVarMenuId(objActionSupport.getVarMenuId());
         String[] strFavMenu = objActionSupport.getVarFavMenuId();
         List<MenuMasterVO> lstNewFav = new ArrayList();
         String[] var13 = strFavMenu;
         int var12 = strFavMenu.length;

         for(int var11 = 0; var11 < var12; ++var11) {
            String menuId = var13[var11];
            int i = 0;
            MenuMasterVO voMenu = new MenuMasterVO();
            voMenu.setVarUserId(voUserFinal.getVarUserId());
            voMenu.setVarHospitalCode(voUser.getVarHospitalCode());
            voMenu.setVarDisplayOrder(Integer.toString(i));
            voMenu.setVarSeatId(voUserFinal.getVarSeatId());
            voMenu.setVarMenuId(menuId);
            lstNewFav.add(voMenu);
            int var18 = i + 1;
         }

         for(int i = 0; i < strFavMenu.length; ++i) {
            System.out.println(strFavMenu[i]);
         }

         LoginFeaturesDATA.changeLoginUserDetails(voUserFinal, lstNewFav);
         voUser.setVarQuestionId(objActionSupport.getVarQuestionId());
         voUser.setVarHintAnswer(objActionSupport.getVarHintAnswer());
         voUser.setVarMobileNumber(objActionSupport.getVarMobileNumber());
         voUser.setVarEmailId(objActionSupport.getVarEmailId());
         voUser.setVarMenuId(objActionSupport.getVarMenuId());
         objActionSupport.setVarStatus(LOG_FEATURE_STATUS_INITIAL);
         objActionSupport.addActionError("User Login details Changed Successfully! Re-login to see changes.");
      } catch (Exception var16) {
         flg = false;
         objActionSupport.addActionError("Unknown Problem Occured! Your User Login details are not Changed!" + var16.getMessage());
         objActionSupport.clear();
         var16.printStackTrace();
      }

      return flg;
   }

   public static void getMenuList(HttpServletRequest objRequest, HttpServletResponse objResponse) {
      System.out.println("LoginFeaturesUTL :: getMenuList");
      StringBuilder strResponse = new StringBuilder();
      ArrayList lstModuleMenu = new ArrayList();

      try {
         String strModuleId = objRequest.getParameter("moduleId");
         HttpSession objSession = objRequest.getSession();
         AuthorizationCredentials objAuthorization = (AuthorizationCredentials)objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHORIZATION_OBJECT);
         if (objAuthorization != null) {
            strResponse.append("{");
            List<MenuMasterVO> lstMenus = objAuthorization.getMenuList();
            int i = 0;
            if (strModuleId != null && !strModuleId.equals("")) {
               Iterator var10 = lstMenus.iterator();

               while(var10.hasNext()) {
                  MenuMasterVO v = (MenuMasterVO)var10.next();
                  if (v.getVarModuleName().equals(strModuleId)) {
                     if (i == 0) {
                        strResponse.append("\"" + v.getVarMenuId() + "\":\"" + v.getVarMenuName().trim() + "\"");
                     } else {
                        strResponse.append(",\"" + v.getVarMenuId() + "\":\"" + v.getVarMenuName() + "\"");
                     }

                     ++i;
                     lstModuleMenu.add(new Entry(v.getVarMenuName(), v.getVarMenuId()));
                  }
               }
            }

            objSession.setAttribute("keyModuleMenuList", lstModuleMenu);
            strResponse.append("}");
         }
      } catch (Exception var14) {
         var14.printStackTrace();
      } finally {
         writeResponse(objResponse, strResponse.toString());
      }

   }

   public static void getManualList(HttpServletRequest objRequest, HttpServletResponse objResponse) {
      StringBuilder strResponse = new StringBuilder();
      ArrayList lstModuleMenu = new ArrayList();

      try {
         String strModuleId = objRequest.getParameter("moduleId");
         HttpSession objSession = objRequest.getSession();
         AuthorizationCredentials objAuthorization = (AuthorizationCredentials)objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHORIZATION_OBJECT);
         if (objAuthorization != null) {
            strResponse.append("{");
            List<MenuMasterVO> lstManuals = objAuthorization.getManualList();
            int i = 0;
            if (strModuleId != null && !strModuleId.equals("")) {
               Iterator var10 = lstManuals.iterator();

               while(var10.hasNext()) {
                  MenuMasterVO v = (MenuMasterVO)var10.next();
                  if (v.getVarModuleName().equals(strModuleId)) {
                     if (i == 0) {
                        strResponse.append("\"" + v.getVarMenuId() + "\":\"" + v.getVarMenuName().trim() + "\"");
                     } else {
                        strResponse.append(",\"" + v.getVarMenuId() + "\":\"" + v.getVarMenuName() + "\"");
                     }

                     ++i;
                     lstModuleMenu.add(new Entry(v.getVarMenuName(), v.getVarMenuId()));
                  }
               }
            }

            objSession.setAttribute("keyModuleManualList", lstModuleMenu);
            strResponse.append("}");
         }
      } catch (Exception var14) {
         var14.printStackTrace();
      } finally {
         writeResponse(objResponse, strResponse.toString());
      }

   }

   public static void writeResponse(HttpServletResponse resp, String output) {
      try {
         resp.reset();
         resp.setContentType("text/xml");
         resp.setHeader("Cache-Control", "no-cache");
         resp.getWriter().write(output);
      } catch (Exception var3) {
         System.out.println(var3);
      }

   }

   public static boolean inituserLogDetails(LoginFeatureSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse, String frDate, String toDate) {
      int num = 10;
      boolean flg = true;
      HttpSession objSession = null;

      try {
         objSession = objRequest.getSession();
         AuthenticationCredentials objAuthenticate = (AuthenticationCredentials)objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
         UserMasterVO voUser = objAuthenticate.getVoUser();
         flg = true;
         objSession.setAttribute("keyLoginFeaturesUserVO", voUser);
         List<UserLoginLogVO> LoginList = LoginFeaturesDATA.getLogList(voUser, num, (String)null, (String)null);
         objSession.setAttribute("keyLoginLog", LoginList);
         objActionSupport.setVarStatus(LOG_FEATURE_STATUS_INITIAL);
      } catch (Exception var11) {
         flg = false;
         objActionSupport.addActionError("Unknown Problem Occured!" + var11.getMessage());
         var11.printStackTrace();
      }

      return flg;
   }

   public static boolean allUserLogDetails(LoginFeatureSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse, String frDate, String toDate) {
      int num = 11;
      boolean flg = true;
      HttpSession objSession = null;

      try {
         objSession = objRequest.getSession();
         AuthenticationCredentials objAuthenticate = (AuthenticationCredentials)objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
         UserMasterVO voUser = objAuthenticate.getVoUser();
         Date objSysDate = (Date)objSession.getAttribute(HISSSOConfig.LOGGEDIN_SYSDATE_OBJECT);
         if (objSysDate != null) {
            frDate = DateHelperMethods.getDateString(objSysDate, "dd-MMM-yyyy");
         }

         toDate = DateHelperMethods.getDateString(objSysDate, "dd-MMM-yyyy");
         flg = true;
         objSession.setAttribute("keyLoginFeaturesUserVO", voUser);
         List<UserLoginLogVO> LoginList = LoginFeaturesDATA.getLogList(voUser, num, frDate, toDate);
         objSession.setAttribute("keyLoginLog", LoginList);
         objActionSupport.setVarStatus(LOG_FEATURE_STATUS_USER_LOG_DETAILS);
      } catch (Exception var12) {
         flg = false;
         objActionSupport.addActionError("Unknown Problem Occured!" + var12.getMessage());
         var12.printStackTrace();
      }

      return flg;
   }

   public static boolean datewiseUserLogDetails(LoginFeatureSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse, String frDate, String toDate) {
      int num = 11;
      boolean flg = true;
      HttpSession objSession = null;

      try {
         objSession = objRequest.getSession();
         AuthenticationCredentials objAuthenticate = (AuthenticationCredentials)objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
         UserMasterVO voUser = objAuthenticate.getVoUser();
         flg = true;
         objSession.setAttribute("keyLoginFeaturesUserVO", voUser);
         List<UserLoginLogVO> LoginList = LoginFeaturesDATA.getLogList(voUser, num, frDate, toDate);
         objSession.setAttribute("keyLoginLog", LoginList);
         objActionSupport.setVarStatus(LOG_FEATURE_STATUS_USER_LOG_DETAILS);
      } catch (Exception var11) {
         flg = false;
         objActionSupport.addActionError("Unknown Problem Occured!" + var11.getMessage());
         var11.printStackTrace();
      }

      return flg;
   }

   public static void setCaptcha(LoginFeatureSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse) throws ServletException, IOException {
      int width = 160;
      byte height = 58;

      try {
         BufferedImage image = new BufferedImage(width, height, 1);
         Graphics2D graphics2D = image.createGraphics();
         String ch = generateCaptchaString();
         Color c = new Color(0.0F, 0.0F, 0.0F);
         graphics2D.setColor(Color.decode("#FFFFFF"));
         graphics2D.fillRect(0, 0, image.getWidth(), image.getHeight());
         GradientPaint gp = new GradientPaint(30.0F, 30.0F, c, 15.0F, 25.0F, Color.black, true);
         graphics2D.setPaint(gp);
         Font font = new Font("Verdana", 1, 30);
         graphics2D.setFont(font);
         graphics2D.drawString(ch, 10, 40);
         graphics2D.dispose();
         HttpSession session = objRequest.getSession(true);
         session.setAttribute("PASSWORD_CAPTCHA_KEY", ch);
         OutputStream outputStream = objResponse.getOutputStream();
         ImageIO.write(image, "jpeg", outputStream);
         outputStream.close();
      } catch (Exception var13) {
         objActionSupport.addActionError("Unknown Problem Occured While Trying to fetch Captcha!");
      }

   }

   public static String generateCaptchaString() {
      Random random = new Random();
      int length = 6;
      StringBuffer captchaStringBuffer = new StringBuffer();

      for(int i = 0; i < length; ++i) {
         int baseCharNumber = Math.abs(random.nextInt()) % 62;
         int charNumber = false;
         int charNumber;
         if (baseCharNumber < 26) {
            charNumber = 65 + baseCharNumber;
         } else if (baseCharNumber < 52) {
            charNumber = 97 + (baseCharNumber - 26);
         } else {
            charNumber = 48 + (baseCharNumber - 52);
         }

         captchaStringBuffer.append((char)charNumber);
      }

      return captchaStringBuffer.toString();
   }

   public static String getOTP() {
      SecureRandom random = new SecureRandom();
      return (new BigInteger(130, random)).abs().toString().substring(0, 4);
   }

   public static String generateAndStoreOTP(String mobileNumber) {
      SecureRandom random = new SecureRandom();
      String otp = String.format("%04d", random.nextInt((int)Math.pow(10.0D, 4.0D)));
      otpmap.put(mobileNumber, otp);
      return otp;
   }

   public static String addOtpToValidationMap(String varNewMobileNo, String otp) {
      SecureRandom random = new SecureRandom();
      otpmap.put(varNewMobileNo, otp);
      return (new BigInteger(130, random)).abs().toString().substring(0, 4);
   }

   public static int getexpireotpajax(String varNewMobileNo, String otp) {
      int status = 1;
      Iterator hospIterator = otpmap.keySet().iterator();
      otpmap.remove(varNewMobileNo);
      return status;
   }

   public static int getOTPValidationStatus(String varNewMobileNo, String otp) {
      int status = true;
      String correctOTP = (String)otpmap.get(varNewMobileNo);
      System.out.println("correctOTP=====>>>" + correctOTP);
      byte status;
      if (correctOTP == null) {
         status = 3;
      } else if (correctOTP.equalsIgnoreCase(otp)) {
         status = 1;
      } else {
         status = 2;
      }

      return status;
   }

   public static void getHospitalRegTypeList(LoginFeaturesACT loginFeaturesACT, HttpServletRequest objRequest, HttpServletResponse objResponse) {
      HisDAO dao = null;
      HisUtil util = null;

      try {
         dao = new HisDAO("", "");
         int index = dao.setQuery("SELECT gnum_hospital_type, gstr_hospital_type_name FROM usm.gblt_hospital_reg_type_mst where gnum_isvalid = 1 order by gnum_hospital_type");
         WebRowSet ws = dao.executeQry(index);
         util = new HisUtil("", "");
         String options = util.getOptionValue(ws, "0", "0^*Select Institution Type", false);
         objRequest.getSession().setAttribute("hosp_reg_type", options);
      } catch (Exception var11) {
         var11.printStackTrace();
      } finally {
         if (dao != null) {
            dao.free();
         }

         if (util != null) {
            util = null;
         }

      }

   }

   public static String getPatHandleRateList(LoginFeaturesACT loginFeaturesACT, HttpServletRequest objRequest, HttpServletResponse objResponse) {
      HisDAO dao = null;
      HisUtil util = null;
      String options = "";
      String hospType = objRequest.getParameter("hosp_type");

      try {
         dao = new HisDAO("", "");
         int index = dao.setQuery("SELECT gnum_pathandle_rate_code||'^'||gnum_pathandle_rate, gstr_pathandle_rate_name FROM ahiscl.gblt_pat_handling_rate_mst WHERE gnum_isvalid = 1 and gnum_hospital_type = ? ");
         dao.setQryValue(index, 1, hospType);
         WebRowSet ws = dao.executeQry(index);
         util = new HisUtil("", "");
         options = util.getOptionValue(ws, "0", "0^*Select Patient Handling per Month", false);
      } catch (Exception var12) {
         var12.printStackTrace();
      } finally {
         if (dao != null) {
            dao.free();
         }

         if (util != null) {
            util = null;
         }

      }

      return options;
   }

   public static void saveRegOTP(LoginFeaturesACT loginFeaturesACT, HttpServletRequest objRequest, HttpServletResponse objResponse, String otp) {
      String toEmailAddress = objRequest.getParameter("emailId");
      System.out.println("otpinsaveregotp" + otp);
      HisDAO dao = null;
      int idx = 0;
      Integer slNo = 0;
      WebRowSet wb = null;
      Integer var10 = 0;

      try {
         dao = new HisDAO("", "");
         String procedure = "{call pkg_usermgmt_new.dml_email_mgmt(?,?,?,?,?, ?,?,?,?,?)}";
         int index = dao.setProcedure(procedure);
         int idx = idx + 1;
         dao.setProcInValue(index, "p_mode", "1", idx);
         ++idx;
         dao.setProcInValue(index, "client_code", "100", idx);
         ++idx;
         dao.setProcInValue(index, "from_address", "", idx);
         ++idx;
         dao.setProcInValue(index, "to_address", toEmailAddress, idx);
         ++idx;
         dao.setProcInValue(index, "subject", "eSushrut-Clinic Registration OTP", idx);
         String var10003 = "Dear Client, <br/> The OTP for your Client Registration is <b>" + otp + "</b> which is Valid for 10 Minutes";
         ++idx;
         dao.setProcInValue(index, "body", var10003, idx);
         ++idx;
         dao.setProcInValue(index, "attachment_paths", "", idx);
         ++idx;
         dao.setProcInValue(index, "schedule_time", "", idx);
         ++idx;
         dao.setProcInValue(index, "seatid", "10001", idx);
         ++idx;
         dao.setProcOutValue(index, "err", 1, idx);
         dao.executeProcedureByPosition(index);
         String strDBErr = dao.getString(index, "err");
         if (strDBErr != null && !strDBErr.equals("")) {
            throw new Exception("Data Base Error:" + strDBErr);
         }
      } catch (Exception var14) {
         var14.printStackTrace();
      }

   }

   public static void addCountForOTP(LoginFeaturesACT loginFeaturesACT, HttpServletRequest objRequest, HttpServletResponse objResponse, String emailType, String varCUserId, String varCHospCode, String varCUserName) {
      HisDAO dao = null;
      byte var8 = 0;

      try {
         dao = new HisDAO("", "");
         String procedure = "{call pkg_usermgmt_new.dml_otp_count(?,?,?,?,?)}";
         int index = dao.setProcedure(procedure);
         int idx = var8 + 1;
         dao.setProcInValue(index, "hospCode", varCHospCode, idx);
         ++idx;
         dao.setProcInValue(index, "gnum_isValid", "1", idx);
         ++idx;
         dao.setProcInValue(index, "userId", varCUserId, idx);
         ++idx;
         dao.setProcInValue(index, "email_Type", emailType, idx);
         ++idx;
         dao.setProcOutValue(index, "err", 1, idx);
         dao.executeProcedureByPosition(index);
         String strDBErr = dao.getString(index, "err");
         if (strDBErr != null && !strDBErr.equals("")) {
            throw new Exception("Data Base Error:" + strDBErr);
         }
      } catch (Exception var12) {
         var12.printStackTrace();
      }

   }

   public static String getOTPCount(LoginFeaturesACT loginFeaturesACT, HttpServletRequest objRequest, HttpServletResponse objResponse, String emailType, String varCUserId, String varCHospCode) {
      HisDAO dao = null;
      int idx = 0;
      String otpCount = "";

      try {
         dao = new HisDAO("", "");
         String procedure = "{call pkg_usermgmt_new.getOTPCount(?,?,?,?,?,?)}";
         int index = dao.setProcedure(procedure);
         int idx = idx + 1;
         dao.setProcInValue(index, "hospCode", varCHospCode, idx);
         ++idx;
         dao.setProcInValue(index, "gnum_isValid", "1", idx);
         ++idx;
         dao.setProcInValue(index, "userId", varCUserId, idx);
         ++idx;
         dao.setProcInValue(index, "email_Type", emailType, idx);
         ++idx;
         dao.setProcOutValue(index, "err", 1, idx);
         ++idx;
         dao.setProcOutValue(index, "otp_count", 1, idx);
         dao.executeProcedureByPosition(index);
         String strDBErr = dao.getString(index, "err");
         if (strDBErr != null && !strDBErr.equals("")) {
            throw new Exception("Data Base Error:" + strDBErr);
         }

         otpCount = dao.getString(index, "otp_count");
      } catch (Exception var12) {
         var12.printStackTrace();
      }

      return otpCount;
   }

   public static String saveHospitalRegistration(LoginFeaturesACT loginFeaturesACT, HttpServletRequest objRequest, HttpServletResponse objResponse) {
      String p_hospital_name = objRequest.getParameter("hname");
      String p_hosp_short_name = objRequest.getParameter("hshortname");
      String p_hospital_add1 = objRequest.getParameter("haddress");
      String p_hospital_add2 = objRequest.getParameter("haddress2");
      String p_city = objRequest.getParameter("city");
      String p_dist_id = objRequest.getParameter("district");
      String p_state_code = objRequest.getParameter("state");
      String p_pin_code = objRequest.getParameter("pincode");
      String p_phone = objRequest.getParameter("phone");
      String p_fax = "0";
      String p_email = objRequest.getParameter("email");
      String p_contact_person = objRequest.getParameter("uname");
      String p_gst_no = objRequest.getParameter("gst");
      HisDAO dao = null;
      int idx = 0;
      String regId = "";

      try {
         dao = new HisDAO("", "");
         String procedure = "{call pkg_usermgmt_new.dml_new_hospital_reg(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?)}";
         int index = dao.setProcedure(procedure);
         int idx = idx + 1;
         dao.setProcInValue(index, "p_mode", "1", idx);
         ++idx;
         dao.setProcInValue(index, "p_hospital_name", p_hospital_name, idx);
         ++idx;
         dao.setProcInValue(index, "p_hosp_short_name", p_hosp_short_name, idx);
         ++idx;
         dao.setProcInValue(index, "p_hospital_add1", p_hospital_add1, idx);
         String var10003 = p_hospital_add2 != null && (p_hospital_add2 == null || p_hospital_add2.trim().length() != 0) ? p_hospital_add2 : "0";
         ++idx;
         dao.setProcInValue(index, "p_hospital_add2", var10003, idx);
         ++idx;
         dao.setProcInValue(index, "p_city", p_city, idx);
         ++idx;
         dao.setProcInValue(index, "p_dist_id", p_dist_id, idx);
         ++idx;
         dao.setProcInValue(index, "p_state_code", p_state_code, idx);
         ++idx;
         dao.setProcInValue(index, "p_pin_code", p_pin_code, idx);
         ++idx;
         dao.setProcInValue(index, "p_phone", p_phone, idx);
         ++idx;
         dao.setProcInValue(index, "p_fax", p_fax, idx);
         ++idx;
         dao.setProcInValue(index, "p_email", p_email, idx);
         ++idx;
         dao.setProcInValue(index, "p_contact_person", p_contact_person, idx);
         ++idx;
         dao.setProcInValue(index, "p_payable_amount", "0", idx);
         ++idx;
         dao.setProcInValue(index, "p_hospital_type", "0", idx);
         ++idx;
         dao.setProcInValue(index, "p_gst_no", p_gst_no, idx);
         ++idx;
         dao.setProcInValue(index, "p_hosp_reg_id", "0", idx);
         ++idx;
         dao.setProcInValue(index, "p_hosp_reg_status", "0", idx);
         ++idx;
         dao.setProcInValue(index, "p_remarks", "0", idx);
         ++idx;
         dao.setProcInValue(index, "p_pat_handle_id", "0", idx);
         ++idx;
         dao.setProcOutValue(index, "err", 1, idx);
         ++idx;
         dao.setProcOutValue(index, "regId", 1, idx);
         dao.executeProcedureByPosition(index);
         String strDBErr = dao.getString(index, "err");
         if (strDBErr != null && !strDBErr.equals("")) {
            throw new Exception("Data Base Error:" + strDBErr);
         }

         regId = dao.getString(index, "regId");
      } catch (Exception var22) {
         var22.printStackTrace();
      }

      return regId;
   }

   public static String saveContactUs(LoginFeaturesACT loginFeaturesACT, HttpServletRequest objRequest, HttpServletResponse objResponse) {
      String p_hospital_type = objRequest.getParameter("htype");
      String p_phone = objRequest.getParameter("phone");
      String p_message = objRequest.getParameter("message");
      String p_email = objRequest.getParameter("email");
      String p_contact_person = objRequest.getParameter("uname");
      HisDAO dao = null;
      int idx = 0;
      String regId = "";

      try {
         dao = new HisDAO("", "");
         String procedure = "{call pkg_usermgmt_new.dml_new_contact_us(?,?,?,?,?,?,?,?,?,?,?)}";
         int index = dao.setProcedure(procedure);
         int idx = idx + 1;
         dao.setProcInValue(index, "p_mode", "1", idx);
         ++idx;
         dao.setProcInValue(index, "p_trail_type", "1", idx);
         ++idx;
         dao.setProcInValue(index, "p_contact_person", p_contact_person, idx);
         ++idx;
         dao.setProcInValue(index, "p_phone", p_phone, idx);
         ++idx;
         dao.setProcInValue(index, "p_message", p_message, idx);
         ++idx;
         dao.setProcInValue(index, "p_email", p_email, idx);
         ++idx;
         dao.setProcInValue(index, "p_status", "0", idx);
         ++idx;
         dao.setProcInValue(index, "p_hospital_type", p_hospital_type, idx);
         ++idx;
         dao.setProcInValue(index, "p_reg_id", "0", idx);
         ++idx;
         dao.setProcOutValue(index, "err", 1, idx);
         ++idx;
         dao.setProcOutValue(index, "regId", 1, idx);
         dao.executeProcedureByPosition(index);
         String strDBErr = dao.getString(index, "err");
         if (strDBErr != null && !strDBErr.equals("")) {
            throw new Exception("Data Base Error:" + strDBErr);
         }

         regId = dao.getString(index, "regId");
      } catch (Exception var14) {
         var14.printStackTrace();
      }

      return regId;
   }

   public static String saveTrailRequest(LoginFeaturesACT loginFeaturesACT, HttpServletRequest objRequest, HttpServletResponse objResponse) {
      String p_hospital_type = objRequest.getParameter("htype");
      String p_phone = objRequest.getParameter("phone");
      String p_message = objRequest.getParameter("message");
      String p_email = objRequest.getParameter("email");
      String p_contact_person = objRequest.getParameter("uname");
      HisDAO dao = null;
      int idx = 0;
      String regId = "";

      try {
         dao = new HisDAO("", "");
         String procedure = "{call pkg_usermgmt_new.dml_new_contact_us(?,?,?,?,?,?,?,?,?,?,?)}";
         int index = dao.setProcedure(procedure);
         int idx = idx + 1;
         dao.setProcInValue(index, "p_mode", "1", idx);
         ++idx;
         dao.setProcInValue(index, "p_trail_type", "2", idx);
         ++idx;
         dao.setProcInValue(index, "p_contact_person", p_contact_person, idx);
         ++idx;
         dao.setProcInValue(index, "p_phone", p_phone, idx);
         ++idx;
         dao.setProcInValue(index, "p_message", p_message, idx);
         ++idx;
         dao.setProcInValue(index, "p_email", p_email, idx);
         ++idx;
         dao.setProcInValue(index, "p_status", "0", idx);
         ++idx;
         dao.setProcInValue(index, "p_hospital_type", p_hospital_type, idx);
         ++idx;
         dao.setProcInValue(index, "p_reg_id", "0", idx);
         ++idx;
         dao.setProcOutValue(index, "err", 1, idx);
         ++idx;
         dao.setProcOutValue(index, "regId", 1, idx);
         dao.executeProcedureByPosition(index);
         String strDBErr = dao.getString(index, "err");
         if (strDBErr != null && !strDBErr.equals("")) {
            throw new Exception("Data Base Error:" + strDBErr);
         }

         regId = dao.getString(index, "regId");
      } catch (Exception var14) {
         var14.printStackTrace();
      }

      return regId;
   }

   public static void getStateList(LoginFeaturesACT loginFeaturesACT, HttpServletRequest objRequest, HttpServletResponse objResponse) {
      HisDAO dao = null;
      HisUtil util = null;

      try {
         dao = new HisDAO("", "");
         int index = dao.setQuery("SELECT gnum_statecode , gstr_statename FROM usm.gblt_state_mst_imsc where gnum_isvalid = 1 order by gstr_statename");
         WebRowSet ws = dao.executeQry(index);
         util = new HisUtil("", "");
         String stateoptions = util.getOptionValue(ws, "0", "0^*Select a State", false);
         objRequest.getSession().setAttribute("state_combo_value", stateoptions);
      } catch (Exception var11) {
         var11.printStackTrace();
      } finally {
         if (dao != null) {
            dao.free();
         }

         if (util != null) {
            util = null;
         }

      }

   }

   public static String getDistrictList(LoginFeaturesACT loginFeaturesACT, HttpServletRequest objRequest, HttpServletResponse objResponse) {
      String stateId = objRequest.getParameter("state_id");
      HisDAO dao = null;
      HisUtil util = null;

      try {
         dao = new HisDAO("", "");
         int index = dao.setQuery("SELECT num_dist_id, str_dist_name\tFROM usm.gblt_district_mst_imsc WHERE gnum_isvalid = 1 and gnum_statecode = ? ORDER BY str_dist_name");
         dao.setQryValue(index, 1, stateId);
         WebRowSet ws = dao.executeQry(index);
         util = new HisUtil("", "");
         String districtOptions = util.getOptionValue(ws, "0", "0^*Select a District", false);
         String var10 = districtOptions;
         return var10;
      } catch (Exception var13) {
         var13.printStackTrace();
      } finally {
         if (dao != null) {
            dao.free();
         }

         if (util != null) {
            util = null;
         }

      }

      return "";
   }
   
  /* String query = "SELECT cm.hstnum_circuler_id AS circularId, cm.hststr_descriptiON AS description, cm.gdt_from_date AS fromDate, cm.gdt_to_date AS toDate, cf.hststr_file_name AS fileName, cf.hststr_display_eng AS displayName FROM grievance.hstt_circuler_mst cm LEFT JOIN grievance.hstt_circular_fileupload cf ON cm.hstnum_circuler_id = cf.hstnum_circuler_id WHERE cm.is_public_circuler = 1 AND cm.gnum_isvalid = 1 AND cf.gnum_isvalid = 1 ";
   if (groupId != null && subGroupId != null && !groupId.equals("0") && !subGroupId.equals("0")) {
      query = query + "AND cm.num_group_id = '" + groupId + "' " + "AND cm.hstnum_Subgrpid = '" + subGroupId + "' ";
   }

   query = query + "order by gdt_entry_date desc";
   int nIndex = hisdao.setQuery(query);
   wb = hisdao.executeQry(nIndex);*/

   public static JSONArray fetchCircularDetailsDTL(HttpServletRequest objRequest, HttpServletResponse objResponse, String groupId, String subGroupId) {
      HisDAO hisdao = new HisDAO("FetchCircularDetailsServlet", "groupId()");
      JSONArray circularDetailsArray = new JSONArray();
      WebRowSet wb = null;

      try {
    	  String query = "SELECT cm.hstnum_circuler_id AS circularId, cm.hststr_descriptiON AS description, cm.gdt_from_date AS fromDate, cm.gdt_to_date AS toDate, cf.hststr_file_name AS fileName, cf.hststr_display_eng AS displayName, cf.hststr_display_hin AS displayHinName  FROM grievance.hstt_circuler_mst cm LEFT JOIN grievance.hstt_circular_fileupload cf ON cm.hstnum_circuler_id = cf.hstnum_circuler_id WHERE cm.is_public_circuler = 1 AND cm.gnum_isvalid = 1 AND cf.gnum_isvalid = 1 ";
    	   if (groupId != null && subGroupId != null && !groupId.equals("0") && !subGroupId.equals("0")) {
    	      query = query + "AND cm.num_group_id = '" + groupId + "' " + "AND cm.hstnum_Subgrpid = '" + subGroupId + "' ";
    	   }

         query = query + "order by gdt_entry_date desc";
         int nIndex = hisdao.setQuery(query);
         wb = hisdao.executeQry(nIndex);

         while(wb.next()) {
            JSONObject circularDetail = new JSONObject();
            circularDetail.put("circularId", wb.getString("circularId"));
            circularDetail.put("description", wb.getString("description"));
            circularDetail.put("fromDate", wb.getString("fromDate"));
            circularDetail.put("toDate", wb.getString("toDate"));
            circularDetail.put("fileName", wb.getString("fileName"));
            circularDetail.put("displayName", wb.getString("displayName"));
            circularDetail.put("displayHinName", wb.getString("displayHinName"));
            circularDetailsArray.put(circularDetail);
         }
      } catch (Exception var18) {
         System.err.println("Error while fetching circular details: " + var18.getMessage());
         var18.printStackTrace();
      } finally {
         if (wb != null) {
            try {
               wb.close();
            } catch (SQLException var17) {
               System.err.println("Error closing WebRowSet: " + var17.getMessage());
               var17.printStackTrace();
            }
         }

      }

      return circularDetailsArray;
   }

   public static JSONObject getCityNamesDTL() {
      JSONObject result = new JSONObject();
      HisDAO hisdao = new HisDAO("FetchCircularDetailsServlet", "groupId()");
      JSONArray cityNamesArray = new JSONArray();
      WebRowSet wb = null;

      //SELECT DISTINCT gstr_city_name FROM gblt_ad_city_mst WHERE gstr_city_name IS NOT NULL
      
      try {
         String query = "SELECT gstr_city_name as cityName, gstr_city_name_hindi as cityHinName ,gnum_city_id as cityId FROM gblt_ad_city_mst WHERE gstr_city_name IS NOT NULL ORDER BY gstr_city_name";
         int nIndex = hisdao.setQuery(query);
         wb = hisdao.executeQry(nIndex);

         while(wb.next()) {
            JSONObject cityNamesDetail = new JSONObject();
            cityNamesDetail.put("cityName", wb.getString("cityName"));
            cityNamesDetail.put("cityHinName", wb.getString("cityHinName"));
            cityNamesDetail.put("cityId", wb.getString("cityId"));
            cityNamesArray.put(cityNamesDetail);
         }

         result.put("cityNamesDtl", cityNamesArray);
      } catch (Exception var15) {
         System.err.println("Error while fetching city  details: " + var15.getMessage());
         var15.printStackTrace();
      } finally {
         if (wb != null) {
            try {
               wb.close();
            } catch (SQLException var14) {
               System.err.println("Error closing WebRowSet: " + var14.getMessage());
               var14.printStackTrace();
            }
         }

      }

      return result;
   }

   
   public static JSONObject getHospitalDTL(HttpServletRequest objRequest, HttpServletResponse objResponse, String cityId) {
	      JSONObject result = new JSONObject();
	      HisDAO hisdao = new HisDAO("FetchHospitalServlet", "cityId()");
	      JSONArray hospitalNamesArray = new JSONArray();
	      WebRowSet wb = null;
// 
	      try {
	    	  String query = "SELECT city.gstr_city_name AS city_name, " +
	                  "emp.hosp_name as hospName, emp.hosp_address as hospAdd, emp.hosp_accreditation as hospAcc, emp.facilities_empled_for as facEmpled " +
	                  "FROM hopt_empanelled_hospital AS emp " +
	                  "JOIN gblt_ad_city_mst AS city ON emp.ad_city_id = city.gnum_city_id " +
	                  "WHERE city.gnum_city_id = '" + cityId + "' AND emp.gnum_isvalid = 1";
	         
	         int nIndex = hisdao.setQuery(query);
	         wb = hisdao.executeQry(nIndex);

	         while(wb.next()) {
	            JSONObject hospitalNamesDetail = new JSONObject();
	            hospitalNamesDetail.put("hospName", wb.getString("hospName"));
	            hospitalNamesDetail.put("hospAcc", wb.getString("hospAcc"));
	            hospitalNamesDetail.put("hospAdd", wb.getString("hospAdd"));
	            hospitalNamesDetail.put("facEmpled", wb.getString("facEmpled"));
	            hospitalNamesArray.put(hospitalNamesDetail);
	         }

	         result.put("hospitalNamesDtl", hospitalNamesArray	);
	      } catch (Exception var15) {
	         System.err.println("Error while fetching city  details: " + var15.getMessage());
	         var15.printStackTrace();
	      } finally {
	         if (wb != null) {
	            try {
	               wb.close();
	            } catch (SQLException var14) {
	               System.err.println("Error closing WebRowSet: " + var14.getMessage());
	               var14.printStackTrace();
	            }
	         }

	      }

	      return result;
	   }
   
   public static JSONObject fetchWellnessCenterByCityUTL(HttpServletRequest objRequest, HttpServletResponse objResponse, String cityId) {
	      JSONObject result = new JSONObject();
	      HisDAO hisdao = new HisDAO("FetchHospitalServlet", "cityId()");
	      JSONArray hospitalNamesArray = new JSONArray();
	      WebRowSet wb = null;
//
	      try {

	    	  String query =  "SELECT (wc.gstr_hospital_name ,(select gstr_wc_type_name from gblt_wc_type_mst where gnum_wc_type_id = wc.gnum_hospital_type)) as hospNameCodeType"
	    			  		  +", wc.gstr_hosp_short_name as shortname, wc.gstr_hospital_add1 as address,"
	    			  		  +"wc.gstr_phone as phone ,wc.gstr_email as email"
				    		  +" FROM gblt_hospital_mst AS wc" 
				    		  +" JOIN gblt_ad_city_mst AS city ON wc.gnum_ad_city_id = city.gnum_city_id" 
				    		  +" WHERE city.gnum_city_id = '" + cityId + "' AND wc.gnum_isvalid = 1 AND wc.is_virtual = 0";
	    	  
	    	  
	         int nIndex = hisdao.setQuery(query);
	         wb = hisdao.executeQry(nIndex);

	         while(wb.next()) {
	            JSONObject hospitalNamesDetail = new JSONObject();
	            hospitalNamesDetail.put("hospNameCodeType", wb.getString("hospNameCodeType"));
	            hospitalNamesDetail.put("shortname", wb.getString("shortname"));
	            hospitalNamesDetail.put("address", wb.getString("address"));
	            hospitalNamesDetail.put("phone", wb.getString("phone"));
	            hospitalNamesDetail.put("email", wb.getString("email"));
	            hospitalNamesArray.put(hospitalNamesDetail);
	         }

	         result.put("hospitalNamesDtl", hospitalNamesArray	);
	      } catch (Exception var15) {
	         System.err.println("Error while fetching city  details: " + var15.getMessage());
	         var15.printStackTrace();
	      } finally {
	         if (wb != null) {
	            try {
	               wb.close();
	            } catch (SQLException var14) {
	               System.err.println("Error closing WebRowSet: " + var14.getMessage());
	               var14.printStackTrace();
	            }
	         }

	      }

	      return result;
	   }

	public static String insertHITCount(String urlPath, String hitCount, String deviceType) throws JSONException {
		// Changed to standard JDBC call syntax
		String procName = "{call pkg_online_appointment.insert_hit_count(?,?,?,?)}";
		HisDAO dao = null;
		String status = "0";
		JSONObject response = new JSONObject();

		try {
			dao = new HisDAO("WebServices", "insertHITCount");
			int procIndex = dao.setProcedure(procName);

			// Set input parameters
			dao.setProcInValue(procIndex, "urlPath", urlPath, 1);
			dao.setProcInValue(procIndex, "hitCount", hitCount, 2);
			dao.setProcInValue(procIndex, "deviceType", deviceType, 3);
			dao.setProcOutValue(procIndex, "err", 1, 4);

			// Execute procedure
			dao.executeProcedureByPosition(procIndex);

			String error = dao.getString(procIndex, "err");
			if (error == null || error.isEmpty() || error.startsWith("SUCCESS:")) {
				status = "1";
			}

			response.put("status", status);
			if (error != null && !error.isEmpty()) {
				response.put("error", error);
			}
			//System.out.println("response:::::   : " + response.toString());
			return response.toString();
		} catch (Exception e) {
			HisException eObj = new HisException("WebServices", "insertHITCount", e.getMessage());
			e.printStackTrace();
			response.put("status", "0");
			response.put("error", "Failed to insert HIT count: " + e.getMessage());

			return response.toString();
		} finally {
			if (dao != null) {
				dao.free();
			}
		}
	}

	public static String updateTable1(String hitCount) throws JSONException {
		// Changed to standard JDBC call syntax
		String procName = "{call pkg_online_appointment.update_total_hit_count_table(?,?)}";
		HisDAO dao = null;
		String status = "0";
		JSONObject response = new JSONObject();

		try {
			dao = new HisDAO("WebServices", "insertHITCount");
			int procIndex = dao.setProcedure(procName);

			dao.setProcInValue(procIndex, "hitCount", "1", 1);
			dao.setProcOutValue(procIndex, "err", 1, 1);

			// Execute procedure
			dao.executeProcedureByPosition(procIndex);

			String error = dao.getString(procIndex, "err");
			if (error == null || error.isEmpty() || error.startsWith("SUCCESS:")) {
				status = "1";
			}

			response.put("status", status);
			if (error != null && !error.isEmpty()) {
				response.put("error", error);
			}
			//System.out.println("response:::::   : " + response.toString());
			return response.toString();
		} catch (Exception e) {
			HisException eObj = new HisException("WebServices", "updateTable", e.getMessage());
			e.printStackTrace();
			response.put("status", "0");
			response.put("error", "Failed to update Total hit count table:  " + e.getMessage());

			return response.toString();
		} finally {
			if (dao != null) {
				dao.free();
			}
		}
	}


	 public static JSONObject getHITCount() {
	      JSONObject result = new JSONObject();
	      HisDAO hisdao = new HisDAO("FetchHospitalServlet", "cityId()");
	      JSONArray hitCountAllArray = new JSONArray();
	      WebRowSet wb = null;

	      try {
	    	 
	    	  String query = "WITH daily_counts AS ("+
	  	    		"   SELECT"+ 
		    		"     COUNT(*) AS total_daily,											"+
					"     SUM(CASE WHEN device_type = 'D' THEN 1 ELSE 0 END) AS daily_desktop,"+
		    		"     SUM(CASE WHEN device_type = 'M' THEN 1 ELSE 0 END) AS daily_mobile  "+
		    		"   FROM appointment.daily_hit_count_stats                                "+
		    		" ),                                                                      "+
		    		" total_counts AS (                                                       "+
		    		"   SELECT                                                                "+
		    		"     COUNT(*) AS total,                                                  "+
		    		"     SUM(CASE WHEN device_type = 'D' THEN 1 ELSE 0 END) AS total_desktop,"+
		    		"     SUM(CASE WHEN device_type = 'M' THEN 1 ELSE 0 END) AS total_mobile  "+
		    		"   FROM appointment.total_hit_count_stats                                "+
		    		" )                                                                       "+
		    		" SELECT                                                                  "+
		    		"   (t.total + d.total_daily) ::numeric AS total_count,                   "+
		    		"   d.total_daily ::numeric AS total_daily_count,                         "+
		    		"   d.daily_desktop ::numeric AS desktop_device_daily,                    "+
		    		"   d.daily_mobile ::numeric AS mobile_device_daily,                      "+
		    		"   (d.daily_desktop + t.total_desktop) ::numeric AS desktop_device_total,"+
		    		"   (d.daily_mobile + t.total_mobile) ::numeric AS mobile_device_total    "+
		    		" FROM total_counts t, daily_counts d";
	    	  
	    	  
	         int nIndex = hisdao.setQuery(query);
	         wb = hisdao.executeQry(nIndex);

	         while(wb.next()) {
	        	//System.out.println("totalCount>>> " + wb.getString(1));
	            JSONObject hitCountAll = new JSONObject();
	        	 hitCountAll.put("totalCount", wb.getString(1));
	        	 hitCountAll.put("totalDailyCount", wb.getString(2));
	        	 hitCountAll.put("desktopDeviceDaily", wb.getString(3));
	             hitCountAll.put("mobileDeviceDaily", wb.getString(4));
	             hitCountAll.put("desktopDeviceTotal", wb.getString(5));
	             hitCountAll.put("mobileDeviceTotal", wb.getString(6));
	             hitCountAllArray.put(hitCountAll);
	         }

	         result.put("hitCountAllArray", hitCountAllArray	);
	         //System.out.println("hitCountAllArray    >>> " + hitCountAllArray);
	      } catch (Exception var15) {
	         System.err.println("Error while fetching city  details: " + var15.getMessage());
	         var15.printStackTrace();
	      } finally {
	         if (wb != null) {
	            try {
	               wb.close();
	            } catch (SQLException var14) {
	               System.err.println("Error closing WebRowSet: " + var14.getMessage());
	               var14.printStackTrace();
	            }
	         }

	      }

	      return result;
	   }
	
	 
	 public static JSONObject updateTable() throws JSONException {
		    JSONObject result = new JSONObject();
		    HisDAO hisdao = new HisDAO("total_hit_count_stats", "updateTable()");
		    WebRowSet wb = null;
		    int status = 0; // Default status is 0 (failure)
		    //System.out.println("updateTable()  :::::   : " );
		    
		    try {
		    
		            String updateQuery = 
		                "INSERT INTO appointment.total_hit_count_stats (url_path, gdt_entry_date, total_count, device_type) " +
		                "SELECT d.url_path, d.gdt_entry_date, d.daily_count, d.device_type " +
		                "FROM appointment.daily_hit_count_stats d ";
		            
		            int updateIndex = hisdao.setQuery(updateQuery);
		            hisdao.executeQry(updateIndex);
		            //int rowsInserted = hisdao.setQuery(updateIndex);
		            
		            // Step 3: Clear the daily table if insert was successful
			        String clearDailyQuery = "TRUNCATE TABLE appointment.daily_hit_count_stats";
			        int clearIndex = hisdao.setQuery(clearDailyQuery);
			        hisdao.executeQry(clearIndex);
		       
		        
		        // If we reach here, both queries executed successfully
		        status = 1;

		    } catch (Exception var15) {
		        //System.err.println("Error while fetching city details: " + var15.getMessage());
		        var15.printStackTrace();
		    } finally {
		        if (wb != null) {
		            try {
		                wb.close();
		            } catch (SQLException var14) {
		             //   System.err.println("Error closing WebRowSet: " + var14.getMessage());
		                var14.printStackTrace();
		            }
		        }
		    }

		    result.put("status", status);
		    return result;
		}

	public static JSONObject restMedicineUTL(HttpServletRequest objRequest, HttpServletResponse objResponse,
			String flag) {
		  JSONObject result = new JSONObject();
	      HisDAO hisdao = new HisDAO("FetchHospitalServlet", "cityId()");
	      JSONArray restrictedMedicineArray = new JSONArray();
	      WebRowSet wb = null;
//
	      try {

	    	  String query =  "SELECT  HSTSTR_ITEM_NAME as rmName, "	
			    			  +"MMS_MST.GET_ITEMTYPE_DTL(1, GNUM_HOSPITAL_CODE, HSTNUM_ITEMTYPE_ID ) as dosage, "
			    			  +"NVL(mms_mst.get_supp_dtl(1,GNUM_HOSPITAL_CODE,hstnum_manufacturer_id),'-') as supplier " 
			    			  +"FROM HSTT_DRUGBRAND_MST B "
			    			  +"WHERE  GNUM_ISVALID = 1 "
			    			  +"and hstnum_restricted_hv_drug_flag='"+flag+"'";
	    	  
	    	  
	         int nIndex = hisdao.setQuery(query);
	         wb = hisdao.executeQry(nIndex);

	         while(wb.next()) {
	            JSONObject restrictedMedicineDetail = new JSONObject();
	            restrictedMedicineDetail.put("rmName", wb.getString("rmName"));
	            restrictedMedicineDetail.put("dosage", wb.getString("dosage"));
	            restrictedMedicineDetail.put("supplier", wb.getString("supplier"));
	            restrictedMedicineArray.put(restrictedMedicineDetail);
	         }

	         result.put("restrictedMedicineDtl", restrictedMedicineArray	);
	      } catch (Exception var15) {
	         System.err.println("Error while fetching city  details: " + var15.getMessage());
	         var15.printStackTrace();
	      } finally {
	         if (wb != null) {
	            try {
	               wb.close();
	            } catch (SQLException var14) {
	               System.err.println("Error closing WebRowSet: " + var14.getMessage());
	               var14.printStackTrace();
	            }
	         }

	      }

	      return result;


	}


}