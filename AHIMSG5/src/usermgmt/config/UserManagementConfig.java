package usermgmt.config;

public interface UserManagementConfig
{
	// Configuration Settings
	
	// Status Flags
	

	// View Procedures
	String PROC_VIEW_USER_MASTER = "{call usm.pkg_usermgmt_new.proc_gblt_user_mst(?,?,?,?,?,?,?,?,?,?,?)}";
	String PROC_VIEW_BEN_MASTER = "{call usm.pkg_usermgmt_new.proc_gblt_ben_mst(?,?,?,?,?,?,?,?,?,?,?)}";
	String PROC_VIEW_HOSPITAL_MASTER = "{call usm.pkg_usermgmt_new.proc_gblt_hospital_mst(?,?,?,?,?,?)}";
	String PROC_VIEW_USER_SEAT_MASTER = "{call usm.pkg_usermgmt_new.proc_user_seat_mst(?,?,?,?,?,?)}";
	String PROC_VIEW_BEN_SEAT_MASTER = "{call usm.pkg_usermgmt_new.proc_ben_seat_mst(?,?,?,?,?,?)}";
	String PROC_VIEW_MENU_MASTER = "{call usm.pkg_usermgmt_new.proc_gblt_menu_mst(?,?,?,?,?,?)}";
	String PROC_VIEW_MANUAL_MASTER="{call usm.pkg_usermgmt_new.proc_gblt_manual_mst(?,?,?,?,?,?)}";//Added by Anjali
	
	
	String PROC_VIEW_MOB_USER_MASTER = "{call usm.pkg_usermgmt_new.proc_gblt_mob_user_mst(?,?,?,?,?,?,?,?,?,?,?)}";
	
	String PROC_VIEW_MOB_BEN_MASTER = "{call usm.pkg_usermgmt_new.proc_gblt_mob_ben_mst(?,?,?,?,?,?,?,?,?,?,?,?)}";
	
	/*
	 * //mobileLogin
	 */	
	String PROC_CHECK_MOBILE_UNIQUENESS="";
	
	String PROC_VIEW_USER_LOGIN_LOG_DETAIL = "{call usm.pkg_usermgmt_new.proc_user_login_log(?,?,?,?,?,?,?,?,?,?)}";
	String PROC_VIEW_BEN_LOGIN_LOG_DETAIL = "{call usm.pkg_usermgmt_new.proc_ben_login_log(?,?,?,?,?,?,?,?,?,?)}";
	String PROC_VIEW_UM_TABLES = "{call usm.pkg_usermgmt_new.proc_gblt_tables(?,?,?,?,?)}";
	// DML Procedures
	String PROC_DML_USER_LOGIN_LOG_DETAIL = "{CALL usm.pkg_usermgmt_new.dml_user_login_log(?,?,?,?,?,?,?,?,?)}";
	String PROC_DML_BEN_LOGIN_LOG_DETAIL = "{CALL usm.pkg_usermgmt_new.dml_ben_login_log(?,?,?,?,?,?,?,?,?)}";
	String PROC_DML_USER_MASTER = "{CALL usm.pkg_usermgmt_new.dml_gblt_user_mst(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	String PROC_DML_BEN_MASTER = "{CALL usm.pkg_usermgmt_new.dml_gblt_ben_mst(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    String PROC_DML_MENU_MASTER="{CALL usm.pkg_usermgmt_new.dml_gblt_menu_mst(?,?,?,?,?,?,?)}";
    
    String dml_hmis_client_system_data_dtl = "{call usm.pkg_usermgmt_new.dml_hmis_client_system_data_dtl(?,?,?,?,?  ,?,?,?,?,?, ?,?,?,?,?)}";
    
    String PROC_DML_USER_ActiveSession = "{CALL pkg_usermgmt_new.proc_update_activesessionflag_dtl(?,?,?)}"; 

    

    String PROC_DML_BEN_ActiveSession = "{CALL pkg_usermgmt_new.proc_ben_update_activesessionflag_dtl(?,?,?)}"; 


	// Keys
	String KEY_USER_MENU_LIST = "keyUserMenuList";
	String KEY_USER_MANUAL_LIST="keyUserManualList";//Added by Anjali
	String KEY_USER_FAVORITE_MENU_LIST = "keyUserFavoriteMenuList";
	String KEY_SYSTEM_DATETIME = "keySystemDateTime";
	String KEY_CASH_COLLECTION_ALLOWED = "keyCashCollectionAllowed";
	String KEY_USER_ALLOWED_MENU_LIST = "keyUserAllowedMenuList";

}
