/**********************************************************
 Project:	   CDWH	
 File:         Config.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package hisglobal.hisconfig;

// TODO: Auto-generated Javadoc
/**
 * The Interface Config.
 */
public interface Config {
	// ********************************************************************************************
	// CONFIGURABLE FLAGS & PATHS
	// ********************************************************************************************

	// -- Client Configuration
	/** The client gnctd. */
	String CLIENT_GNCTD = "0"; // CLIENT is GNCTD

	/** The client pgimer. */
	String CLIENT_PGIMER = "1"; // CLIENT is PGIMER

	/** The client sms. */
	String CLIENT_SMS = "2";

	/** The client. */
	String CLIENT = CLIENT_PGIMER;

	// -- Hospital Code Configuration
	/** The hospital code value. */
	String HOSPITAL_CODE_VALUE = "998";

	// -- CR Number Size Configuration
	/** The cr no format size twelve. */
	String CR_NO_FORMAT_SIZE_TWELVE = "12"; // value for size 12

	/** The cr no format size thirteen. */
	String CR_NO_FORMAT_SIZE_THIRTEEN = "13"; // value for size 13

	/** The cr no format size. */
	String CR_NO_FORMAT_SIZE = CR_NO_FORMAT_SIZE_THIRTEEN;
	// 12 for PGIMER and 13 FOR GNCTD AND SMS and passed
	// in InputCrNoTag

	// -- Time Duration For Patient Detail Modification
	/** The time duration modification. */
	String TIME_DURATION_MODIFICATION = "10";

	// -- Emergency Brought By Detail For Registration And 10 Minimum
	// Modification
	/** The emg brought by detail flag value true. */
	String EMG_BROUGHT_BY_DETAIL_FLAG_VALUE_TRUE = "1";

	/** The emg brought by detail flag value false. */
	String EMG_BROUGHT_BY_DETAIL_FLAG_VALUE_FALSE = "0";

	/** The emg brought by detail flag value. */
	String EMG_BROUGHT_BY_DETAIL_FLAG_VALUE = EMG_BROUGHT_BY_DETAIL_FLAG_VALUE_TRUE;
	// EMG_BROUGHT_BY_DETAIL_FLAG_VALUE=0 :: Don't Display Brought By Detail
	// EMG_BROUGHT_BY_DETAIL_FLAG_VALUE=1 :: Display Brought By Detail

	// -- Emergency Brought By Detail For MLC And MLC Modification
	/** The emg brought by detail mlc flag value true. */
	String EMG_BROUGHT_BY_DETAIL_MLC_FLAG_VALUE_TRUE = "1";

	/** The emg brought by detail mlc flag value false. */
	String EMG_BROUGHT_BY_DETAIL_MLC_FLAG_VALUE_FALSE = "0";

	/** The emg brought by detail mlc flag value. */
	String EMG_BROUGHT_BY_DETAIL_MLC_FLAG_VALUE = EMG_BROUGHT_BY_DETAIL_MLC_FLAG_VALUE_TRUE;
	// EMG_BROUGHT_BY_DETAIL_MLC_FLAG_VALUE=0 :: Don't Display Brought By Detail
	// EMG_BROUGHT_BY_DETAIL_MLC_FLAG_VALUE=1 :: Display Brought By Detail

	// -- File No Generation
	/** The file no genration false. */
	String FILE_NO_GENRATION_FALSE = "0";

	/** The file no genration mannual true. */
	String FILE_NO_GENRATION_MANNUAL_TRUE = "1";

	/** The file no genration auto true. */
	String FILE_NO_GENRATION_AUTO_TRUE = "2";

	/** The file no generation flag. */
	String FILE_NO_GENERATION_FLAG = FILE_NO_GENRATION_AUTO_TRUE;
	// i. FILE_NO_GENERATION_FLAG 0: No Need of File No.
	// ii. FILE_NO_GENERATION_FLAG 1: Manual Allotment of File No.
	// iii. FILE_NO_GENERATION_FLAG 2: Auto Generated File No.
	// ///////////////// File no genration type --> set
	// FILENO_GENRATION_TYPE_AUTO for autogenrated FileNo//////
	/** The fileno genration type auto. */
	String FILENO_GENRATION_TYPE_AUTO = "0";
	// ////////////////File no genration type --> set
	// FILENO_GENRATION_TYPE_MANNUAL for Mannual entry of FileNo//////
	/** The fileno genration type mannual. */
	String FILENO_GENRATION_TYPE_MANNUAL = "1";

	// -- File No Visibility Flag --> Assign value true to make it visible
	// otherwise make it false
	/** The fileno visibilty flag active. */
	boolean FILENO_VISIBILTY_FLAG_ACTIVE = false;

	// -- Color Codification and Priority Order for Patient List at Doctor Desk
	/** The opd pat list color code priority arr. */
	String OPD_PAT_LIST_COLOR_CODE_PRIORITY_ARR[] = { "", "", "", "", "", "" };
	// {"","#0000CD","#0000FF","#7B68EE","#00BFFF","#87CEEB"};
	// "#0000CD" - Medium Blue
	// "#0000FF" - Blue
	// "#7B68EE" - Medium Slate Blue
	// "#00BFFF" - Deep Sky Blue
	// "#87CEEB" - Sky Blue
	/** The opd pat list color code mlc. */
	String OPD_PAT_LIST_COLOR_CODE_MLC = "#FF0000"; // Red

	/** The opd pat list color code brought dead. */
	String OPD_PAT_LIST_COLOR_CODE_BROUGHT_DEAD = "#FFFFFF"; // White

	/** The opd pat list color code unknown. */
	String OPD_PAT_LIST_COLOR_CODE_UNKNOWN = "#FFC0CB"; // Pink

	/** The opd pat list color code visitd. */
	String OPD_PAT_LIST_COLOR_CODE_VISITD = ""; // Light Gray

	/** The opd pat list color code priority arr order. */
	String OPD_PAT_LIST_COLOR_CODE_PRIORITY_ARR_ORDER[] = { "0", "0", "0", "0",
			"0", "0" };

	/** The opd pat list color code priority order. */
	String OPD_PAT_LIST_COLOR_CODE_PRIORITY_ORDER = "10";

	/** The opd pat list color code mlc order. */
	String OPD_PAT_LIST_COLOR_CODE_MLC_ORDER = "20";

	/** The opd pat list color code brought dead order. */
	String OPD_PAT_LIST_COLOR_CODE_BROUGHT_DEAD_ORDER = "40";

	/** The opd pat list color code unknown order. */
	String OPD_PAT_LIST_COLOR_CODE_UNKNOWN_ORDER = "30";

	/** The opd pat list color code visitd order. */
	String OPD_PAT_LIST_COLOR_CODE_VISITD_ORDER = "50";

	// -- HIS Resource Bundle
	/** The resource bundle property file path. */
	String RESOURCE_BUNDLE_PROPERTY_FILE_PATH = "mms.hisglobal.hisconfig.hisResourceBundle";

	// **** Storage Paths ************************************************
	 
	// OPD
	/* Not in Use */
	// String OPD_TEMPLATE_HTML_DOCUMENT_FILE_STORAGE_PATH =
	// "c:\\OpdDocumentDIR\\OpdTemplateDIR";
	// String OPD_TEMPLATE_HTML_DOCUMENT_FILE_STORAGE_NAME = "OpdTemplate_"; //
	// concatenated with TemplateId int
	// String OPD_PATIENT_PROFILE_STORAGE_PATH = "c:\\OpdPatientProfileDIR";
	// String OPD_EXAMINATION_IMAGE_PATH = "C:/OPDImages/OPDExaminationImages/";
	// String OPD_EXAMINATION_PAT_IMAGE_PATH = "C:/PImage/";
	// String OPD_DOCUMENT_FILE_STORAGE_PATH = "c:\\OpdDocumentDIR";

	 
	/** The image editor examination filename startswith. */
	String IMAGE_EDITOR_EXAMINATION_FILENAME_STARTSWITH = "I"; // concatenated
																// with Par Cr
																// No +
	/** The image editor examination filename connector. */
	String IMAGE_EDITOR_EXAMINATION_FILENAME_CONNECTOR = "$"; // concatenated
	// with Serial
	// No +
	/** The image editor examination filename extension. */
	String IMAGE_EDITOR_EXAMINATION_FILENAME_EXTENSION = ".png";

	 
	// Audio Video Player
	/** The url of audio video file on server. */
	String URL_OF_AUDIO_VIDEO_FILE_ON_SERVER = "ftp://administrator:hisopd@10.0.5.177/dir/";

	/** The opd audio video storage path. */
	String OPD_AUDIO_VIDEO_STORAGE_PATH = "C:/OPDAV/OPDAudioVideo";

  
	/** The generic template html document file storage name. */
	String GENERIC_TEMPLATE_HTML_DOCUMENT_FILE_STORAGE_NAME = "GenericTemplate_"; // concatenated
																					// with
																					// TemplateId
																					// int
	/** The generic template html document file storage ext. */
	String GENERIC_TEMPLATE_HTML_DOCUMENT_FILE_STORAGE_EXT = ".htm"; // concatenated
	// with
	// Generic
	// Temp
	// Name

	/** The generic template image view file storage name. */
	String GENERIC_TEMPLATE_IMAGE_VIEW_FILE_STORAGE_NAME = "IMG_"; // concatenated
	// with
	// TemplateId
	// int +"_"+
	// row_col

	 
	// -- Registration Renewal Configuration
	/** The renewal type. */
	String RENEWAL_TYPE = "3";
	// RENEWAL=0 : NO NEED OF RENEWAL
	// RENEWAL=1 : HOSPITAL RENEWAL : MONTH BASIS : EXPIRY WILL SAVE IN
	// HRGT_PATIENT_DTL
	// RENEWAL=2 : HOSPITAL RENEWAL : DAYS BASIS : EXPIRY WILL SAVE IN
	// HRGT_PATIENT_DTL
	// RENEWAL=3 : UNIT WISE RENEWAL: CONSTANT MONTH BASIS SAME AS 1 BUT EXPIRY
	// WILL SAVE IN HRGT_EPISODE_DTL
	// RENEWAL=4 : UNIT WISE RENEWAL: CONSTANT DAYS BASIS SAME AS 1 BUT EXPIRY
	// WILL SAVE IN HRGT_EPISODE_DTL
	// RENEWAL=5 : UNIT WISE RENEWAL MONTH/DAYS BASIS FROM DATABASE, AND EXPIRY
	// WILL SAVE IN HRGT_EPISOE_DTL
	/** The hospital renewal expiry month. */
	String HOSPITAL_RENEWAL_EXPIRY_MONTH = "31-Dec"; // Format must be like
														// dd-mon
	/** The hospital renewal expiry day. */
	String HOSPITAL_RENEWAL_EXPIRY_DAY = "30";

	// //This ExpiryDate Is For Bi YearLy registration Used For PGI Only//////
	// /It works For Case 3 only/////////////////
	// ////If in any hospital case 3 is required but Bi yearly Registration is
	// not required
	// /than set both expirt dates same////

	/** The hospital renewal expiry month first. */
	String HOSPITAL_RENEWAL_EXPIRY_MONTH_FIRST = "30-Jun";

	/** The hospital renewal expiry month second. */
	String HOSPITAL_RENEWAL_EXPIRY_MONTH_SECOND = "31-Dec";

	// ////////////////////////////////////////////////////////////////
	// -- Patient Category Employee Configuration
	/** The patcat employee data from table false. */
	String PATCAT_EMPLOYEE_DATA_FROM_TABLE_FALSE = "0"; // / Data is not fetched
														// from Table
	/** The patcat employee data from table true. */
	String PATCAT_EMPLOYEE_DATA_FROM_TABLE_TRUE = "1"; // / Data is fetched from
	// table
	/** The patcat employee data from table value. */
	String PATCAT_EMPLOYEE_DATA_FROM_TABLE_VALUE = PATCAT_EMPLOYEE_DATA_FROM_TABLE_TRUE;
	// / To make fields editable even if data is fetched from table
	// -PATCAT_EMPLOYEE_DATA_FROM_TABLE_VALUE =
	// PATCAT_EMPLOYEE_DATA_FROM_TABLE_FALSE
	/** The patcat employee field editable false. */
	String PATCAT_EMPLOYEE_FIELD_EDITABLE_FALSE = "0";

	/** The patcat employee field editable true. */
	String PATCAT_EMPLOYEE_FIELD_EDITABLE_TRUE = "1";

	/** The patcat employee field value. */
	String PATCAT_EMPLOYEE_FIELD_VALUE = PATCAT_EMPLOYEE_FIELD_EDITABLE_FALSE;
	// i. PATCAT_EMPLOYEE_FIELD_VALUE 0: Data will be fetched from Employee
	// Table only and Fields are not editable except nationalId,Refer.
	// ii. PATCAT_EMPLOYEE_FIELD_VALUE 1: Data can either fetched from table or
	// entered Manually.
	// 1) If data fetched from table i.e. PATCAT_EMPLOYEE_DATA_FROM_TABLE_TRUE
	// then Fields are not editable except nationalId,Refer
	// 2) If Data entered manually i.e. PATCAT_EMPLOYEE_DATA_FROM_TABLE_FALSE
	// then all fields are editable

	// -- Billing Grouping Configuration
	/** The registration billing grouping flag. */
	String REGISTRATION_BILLING_GROUPING_FLAG = "1";
	// Flag = 0 :: For normal billing i.e. without grouping
	// Flag = 1 :: For billing with grouping in case of Referral

	// -- File Number Printing Required
	/** The print required true. */
	String PRINT_REQUIRED_TRUE = "1";

	/** The print required false. */
	String PRINT_REQUIRED_FALSE = "0";

	/** The file number print required. */
	String FILE_NUMBER_PRINT_REQUIRED = PRINT_REQUIRED_TRUE;

	// -- OPD Card Printing Required
	/** The opd card printing required. */
	String OPD_CARD_PRINTING_REQUIRED = PRINT_REQUIRED_TRUE;

	// -- Print Required for Renewal of Registration
	/** The card printing required for renewal. */
	String CARD_PRINTING_REQUIRED_FOR_RENEWAL = PRINT_REQUIRED_TRUE;

	// -- Number of file number slips to be generated
	/** The number of file slip to be generated. */
	String NUMBER_OF_FILE_SLIP_TO_BE_GENERATED = "1";

	// End
	// ****************************************************************************************

	// ****
	/** The tree name. */
	String TREE_NAME = "trICD";

	/** The diagnosis tree. */
	String DIAGNOSIS_TREE = "diagnosistree";

	/** The client name. */
	String CLIENT_NAME = "clientName";

	/** The default value cr no format. */
	String DEFAULT_VALUE_CR_NO_FORMAT = "defaultValueCrNoFormat";

	// **** Sorting Flags
	/** The sort type asc. */
	String SORT_TYPE_ASC = "0";

	/** The sort type dsc. */
	String SORT_TYPE_DSC = "1";

	// **** Registration Timings
	/** The registration allowed true. */
	String REGISTRATION_ALLOWED_TRUE = "1";

	/** The registration allowed false. */
	String REGISTRATION_ALLOWED_FALSE = "0";

	// **** Registration Mandatory
	/** The registration mandatory dept list. */
	String REGISTRATION_MANDATORY_DEPT_LIST = "registrationMandatoryDeptList";

	/** The properties file for mandatory field. */
	String PROPERTIES_FILE_FOR_MANDATORY_FIELD = "registration.MandatoryFields";

	/** The properties file for refer departments. */
	String PROPERTIES_FILE_FOR_REFER_DEPARTMENTS = "registration.ReferDepartments";

	// **** Emergency Brought By Detail For Registration And 10 Minimum
	// Modification
	/** The emg brought by detail flag. */
	String EMG_BROUGHT_BY_DETAIL_FLAG = "emgBroughtByDetail";

	// **** Emergency Brought By Detail For MLC And MLC Modification
	/** The emg brought by detail mlc flag. */
	String EMG_BROUGHT_BY_DETAIL_MLC_FLAG = "emgBroughtByMlcDetail";

	// **** File No Generation
	/** The file no generation flag name. */
	String FILE_NO_GENERATION_FLAG_NAME = "fileNoGenrationFlag";

	/** The file number label. */
	String FILE_NUMBER_LABEL = "fileNumberLabel"; // temporary file name for
													// label generation

	// **** Report Chart Related
	/** The query file for report chart. */
	String QUERY_FILE_FOR_REPORT_CHART = "registration.ReportsChartQuery";

	/** The upload chart image. */
	String UPLOAD_CHART_IMAGE = "chartImage";

	/** The pdf. */
	String PDF = "1";

	/** The rtf. */
	String RTF = "2";

	/** The pie. */
	String PIE = "1";

	/** The bar. */
	String BAR = "2";

	/** The line. */
	String LINE = "3";

	/** The graph. */
	String GRAPH = "GRAPH";

	/** The text. */
	String TEXT = "TEXT";

	/** The choice today. */
	String CHOICE_TODAY = "T";

	/** The choice date wise. */
	String CHOICE_DATE_WISE = "D";

	/** The choice month wise. */
	String CHOICE_MONTH_WISE = "M";

	/** The choice year wise. */
	String CHOICE_YEAR_WISE = "Y";

	/** The old. */
	String OLD = "1";

	/** The new. */
	String NEW = "2";

	// **** Session Related
	/** The transaction specific session items. */
	String TRANSACTION_SPECIFIC_SESSION_ITEMS = "Transactionspecificsessionitems";

	/** The master specific session items. */
	String MASTER_SPECIFIC_SESSION_ITEMS = "masterSpecificSessionItems";

	/** The status object. */
	String STATUS_OBJECT = "statusobject";

	/** The user vo. */
	String USER_VO = "USERVO";

	/** The seat id. */
	String SEAT_ID = "SEATID";

	/** The hospital code. */
	String HOSPITAL_CODE = "HOSPITAL_CODE";

	/** The ip address. */
	String IP_ADDRESS = "IP_ADDR";

	/** The menu id. */
	String MENU_ID = "MENUID";

	/** The sysdate. */
	String SYSDATE = "SYSDATE";

	/** The sysdateobject. */
	String SYSDATEOBJECT = "SYSDATEOBJECT";

	/** The user seat id. */
	String USER_SEAT_ID = "ACTUALSEATID";

	/** The user emp id. */
	String USER_EMP_ID = "EMPID";

	/** The user full name. */
	String USER_FULL_NAME = "UserFullName";

	/** The user level. */
	String USER_LEVEL = "USER_LEVEL";

	// **** Global Query Property File
	/** The global query file for globalessentialdao. */
	String GLOBAL_QUERY_FILE_FOR_GLOBALESSENTIALDAO = "mms.hisglobal.persistence.globalQuery";

	// **** Validation Flags
	/** The is valid inactive. */
	String IS_VALID_INACTIVE = "2";

	/** The is valid active. */
	String IS_VALID_ACTIVE = "1";

	/** The is valid deleted. */
	String IS_VALID_DELETED = "0";

	// **** Primary Category
	/** The primary category normal code. */
	String PRIMARY_CATEGORY_NORMAL_CODE = "11";

	/** The primary category employee code. */
	String PRIMARY_CATEGORY_EMPLOYEE_CODE = "12";

	/** The primary category poor free code. */
	String PRIMARY_CATEGORY_POOR_FREE_CODE = "13";

	/** The primary category senior citizen. */
	String PRIMARY_CATEGORY_SENIOR_CITIZEN = "14";

	/** The senior citizen age. */
	String SENIOR_CITIZEN_AGE = "65";

	/** The primary category staff code. */
	String PRIMARY_CATEGORY_STAFF_CODE = "15";

	// **** Order By
	/** The opd patient oredre by queue no. */
	String OPD_PATIENT_OREDRE_BY_QUEUE_NO = "0";

	/** The opd patient order by visit date. */
	String OPD_PATIENT_ORDER_BY_VISIT_DATE = "5";

	/** The opd patient oredre by cr no. */
	String OPD_PATIENT_OREDRE_BY_CR_NO = "1";

	/** The opd patient oredre by name. */
	String OPD_PATIENT_OREDRE_BY_NAME = "2";

	/** The opd patient oredre by patient category. */
	String OPD_PATIENT_OREDRE_BY_PATIENT_CATEGORY = "3";

	/** The opd patient oredre by color code. */
	String OPD_PATIENT_OREDRE_BY_COLOR_CODE = "4";

	/** The opd patient oredre by triage duration. */
	String OPD_PATIENT_OREDRE_BY_TRIAGE_DURATION = "5";

	/** The order by admission no. */
	String ORDER_BY_ADMISSION_NO = "6";

	/** The order by admission date. */
	String ORDER_BY_ADMISSION_DATE = "7";

	/** The ipd patient oredre by name. */
	String IPD_PATIENT_OREDRE_BY_NAME = "8";

	/** The opd patient desk new. */
	String OPD_PATIENT_DESK_NEW = "0";

	/** The opd patient desk old. */
	String OPD_PATIENT_DESK_OLD = "1";

	// **** REGISTRATION ONLINE_OFFLIINE FLAG
	/** The registration offline. */
	String REGISTRATION_OFFLINE = "0";

	/** The registration online. */
	String REGISTRATION_ONLINE = "1";

	/** The registration online offline both. */
	String REGISTRATION_ONLINE_OFFLINE_BOTH = "2";

	/** The registration online offline type. */
	String REGISTRATION_ONLINE_OFFLINE_TYPE = REGISTRATION_ONLINE;

	// **** Patient Category Employee Name
	/** The patcat employee name. */
	String PATCAT_EMPLOYEE_NAME = "patCatEmployeeName";

	// **** Master Workshop
	/** The essentialbo option department. */
	String ESSENTIALBO_OPTION_DEPARTMENT = "optionDepartment";

	/** The essentialbo option dept unit. */
	String ESSENTIALBO_OPTION_DEPT_UNIT = "deptUnit";

	/** The sequence details arr. */
	String SEQUENCE_DETAILS_ARR = "sequenceDetails";

	/** The sequence list. */
	String SEQUENCE_LIST = "sequencelist";

	/** The essential bo weekday. */
	String ESSENTIAL_BO_WEEKDAY = "weekday";

	/** The roster sequence details arr. */
	String ROSTER_SEQUENCE_DETAILS_ARR = "rostersequenceDetailsarr";

	/** The roster sequence list. */
	String ROSTER_SEQUENCE_LIST = "rostersequencelist";

	// ////Color For the project/////////////

	/** The application color code. */
	String APPLICATION_COLOR_CODE = "#FFB468";
	// String APPLICATION_COLOR_CODE="#9090b0";////Previous Color of Application
	/** The image for title tag. */
	String IMAGE_FOR_TITLE_TAG = "shd-trans-FFB468.png";

	/** The is location combo req. */
	String IS_LOCATION_COMBO_REQ = "0";// 1-Combo Required YES, 0-Combo Required
										// NO
	/** The is location combo req yes. */
	String IS_LOCATION_COMBO_REQ_YES = "1";

	/** The is location combo req no. */
	String IS_LOCATION_COMBO_REQ_NO = "0";

	// ///Mapping Location With Estate////

	/** The location mapping with estate required. */
	String LOCATION_MAPPING_WITH_ESTATE_REQUIRED = "1"; // 1-Mapping Required
														// YES, 0-Mapping
														// Required NO
	/** The location mapping with estate required yes. */
	String LOCATION_MAPPING_WITH_ESTATE_REQUIRED_YES = "1";

	/** The location mapping with estate required no. */
	String LOCATION_MAPPING_WITH_ESTATE_REQUIRED_NO = "0";

	/** The patient cat type. */
	String PATIENT_CAT_TYPE = "0";

	/** The patient cat type is paid no. */
	String PATIENT_CAT_TYPE_IS_PAID_NO = "0";

	// ******************* Certificate Related Configuration flags
	// Medical Certificate Generation Option
	/** The medical certificate generation automatic. */
	String MEDICAL_CERTIFICATE_GENERATION_AUTOMATIC = "1";

	/** The medical certificate generation manual. */
	String MEDICAL_CERTIFICATE_GENERATION_MANUAL = "2";

	/** The medical certificate generation. */
	String MEDICAL_CERTIFICATE_GENERATION = MEDICAL_CERTIFICATE_GENERATION_AUTOMATIC;

	// Medical Certificate Received Option
	/** The certificate received online. */
	String CERTIFICATE_RECEIVED_ONLINE = "1";

	/** The certificate received offline. */
	String CERTIFICATE_RECEIVED_OFFLINE = "2";

	/** The certificate received option. */
	String CERTIFICATE_RECEIVED_OPTION = CERTIFICATE_RECEIVED_ONLINE;

	// Medical Certificate Generation Option Back Dated
	/** The generate medical certificate back dated yes. */
	String GENERATE_MEDICAL_CERTIFICATE_BACK_DATED_YES = "1";

	/** The generate medical certificate back dated no. */
	String GENERATE_MEDICAL_CERTIFICATE_BACK_DATED_NO = "2";

	/** The generate medical certificate back dated. */
	String GENERATE_MEDICAL_CERTIFICATE_BACK_DATED = GENERATE_MEDICAL_CERTIFICATE_BACK_DATED_YES;

	// Fitness Certificate Generation Option Back Dated
	/** The generate fitness certificate back dated yes. */
	String GENERATE_FITNESS_CERTIFICATE_BACK_DATED_YES = "1";

	/** The generate fitness certificate back dated no. */
	String GENERATE_FITNESS_CERTIFICATE_BACK_DATED_NO = "2";

	/** The generate fitness certificate back dated. */
	String GENERATE_FITNESS_CERTIFICATE_BACK_DATED = GENERATE_FITNESS_CERTIFICATE_BACK_DATED_YES;

	// Consultant Name Mapping
	/** The medical certificate employee mapping online. */
	String MEDICAL_CERTIFICATE_EMPLOYEE_MAPPING_ONLINE = "1";

	/** The medical certificate employee mapping offline. */
	String MEDICAL_CERTIFICATE_EMPLOYEE_MAPPING_OFFLINE = "2";

	/** The medical certificate employee mapping. */
	String MEDICAL_CERTIFICATE_EMPLOYEE_MAPPING = MEDICAL_CERTIFICATE_EMPLOYEE_MAPPING_OFFLINE;

	/** The marque message. */
	String MARQUE_MESSAGE = "marqueMessage";

	// //////////////User for prompting and forcing the user to change his
	// password after a certain duration//

	/** The no of days allowed to login after password changed. */
	int NO_OF_DAYS_ALLOWED_TO_LOGIN_AFTER_PASSWORD_CHANGED = 90;

	/** The no of days before to ask user for password changed. */
	int NO_OF_DAYS_BEFORE_TO_ASK_USER_FOR_PASSWORD_CHANGED = 3;

	// ////////////////User Roles and Privelages To be shown through it
	// ////////////////////////////////////////////////

	/** The list of roles concate. */
	String LIST_OF_ROLES_CONCATE = "listOfRolesConcate";

	/** The list of roles id. */
	String LIST_OF_ROLES_ID = "listOfRolesId";

	/** The list of roles name. */
	String LIST_OF_ROLES_NAME = "listOfRolesName";

	/** The list of menus. */
	String LIST_OF_MENUS = "listOfMenus";

	/** The list of privelages. */
	String LIST_OF_PRIVELAGES = "listOfPrivelages";

	/** The user roles list. */
	String USER_ROLES_LIST = "userRolesList";

	// All Low level Users for the corresponding Group to be shown

	/** The list of all low level users for the group. */
	String LIST_OF_ALL_LOW_LEVEL_USERS_FOR_THE_GROUP = "listOfAllLowLevelUsersForTheGroup";

	/** The reset password. */
	String RESET_PASSWORD = "123456";

	// //// MLC Detail Process- Police Verification Detail Required///////////
	/** The mlc detail police verification required yes. */
	String MLC_DETAIL_POLICE_VERIFICATION_REQUIRED_YES = "1";

	/** The mlc detail police verification required no. */
	String MLC_DETAIL_POLICE_VERIFICATION_REQUIRED_NO = "0";

	/** The mlc detail police verification required. */
	String MLC_DETAIL_POLICE_VERIFICATION_REQUIRED = MLC_DETAIL_POLICE_VERIFICATION_REQUIRED_NO;

	// //////////Normal Death Body Handover ////////////
	/** The body handover mortuary yes. */
	String BODY_HANDOVER_MORTUARY_YES = "1";

	/** The body handover mortuary no. */
	String BODY_HANDOVER_MORTUARY_NO = "0";

	/** The body handover mortuary. */
	String BODY_HANDOVER_MORTUARY = BODY_HANDOVER_MORTUARY_NO;

	// ////////// Normal Death Body Handover ////////////
	/** The normal body handover mortuary. */
	String NORMAL_BODY_HANDOVER_MORTUARY = "1";

	/** The normal body handover patient. */
	String NORMAL_BODY_HANDOVER_PATIENT = "0";

	/** The normal body handover. */
	String NORMAL_BODY_HANDOVER = NORMAL_BODY_HANDOVER_MORTUARY;

	// ////////// MLC Death Body Handover ////////////
	/** The mlc body handover mortuary. */
	String MLC_BODY_HANDOVER_MORTUARY = "1";

	/** The mlc body handover police. */
	String MLC_BODY_HANDOVER_POLICE = "0";

	/** The mlc body handover. */
	String MLC_BODY_HANDOVER = MLC_BODY_HANDOVER_MORTUARY;

	// /////////////ANC Detail Options//////////
	/** The anc detail minimun age for anc eligibility. */
	String ANC_DETAIL_MINIMUN_AGE_FOR_ANC_ELIGIBILITY = "12";

	/** The anc detail maximum gestation week for anc. */
	String ANC_DETAIL_MAXIMUM_GESTATION_WEEK_FOR_ANC = "40";

	/** The anc detail manimum gestation week for delivery. */
	String ANC_DETAIL_MANIMUM_GESTATION_WEEK_FOR_DELIVERY = "24";

	/** The anc detail maximum week gap for obstetric death. */
	String ANC_DETAIL_MAXIMUM_WEEK_GAP_FOR_OBSTETRIC_DEATH = "6"; // Death
																	// Detail
																	// Mother
																	// Death
																	// Status
																	// Check
	/** The anc detail maximum no of birth. */
	String ANC_DETAIL_MAXIMUM_NO_OF_BIRTH = "6";

	// /////////////Gender Types //////////
	/** The gender type male. */
	String GENDER_TYPE_MALE = "1";

	/** The gender type female. */
	String GENDER_TYPE_FEMALE = "2";

	/** The gender type other. */
	String GENDER_TYPE_OTHER = "3";

	// ////////////////Image Parameter//////////////////
	/** The image byte array. */
	String IMAGE_BYTE_ARRAY = "imageByteArray";

	/** The req parameter image index. */
	String REQ_PARAMETER_IMAGE_INDEX = "reqParameterImageIndex";

	/** The image byte array key. */
	String IMAGE_BYTE_ARRAY_KEY = "key";
	// ////////////////////////////////

	// ////////////////////Path to save Pdf file for
	// printing////////////////////////////////////
	/** The print pdf file path windows. */
	String PRINT_PDF_FILE_PATH_WINDOWS = "C:/printFile";

	/** The print pdf file path linux. */
	String PRINT_PDF_FILE_PATH_LINUX = "/printFile";

	/** The print pdf file name. */
	String PRINT_PDF_FILE_NAME = "print.pdf";

	// //////////////////////Operating System
	// Type///////////////////////////////////////////
	/** The os type windows. */
	String OS_TYPE_WINDOWS = "1";

	/** The os type linux. */
	String OS_TYPE_LINUX = "2";

	/** The software list vo. */
	String SOFTWARE_LIST_VO = "softwareListVO";

	// //////////Hospital VO for Printing Header
	/** The hospital vo. */
	String HOSPITAL_VO = "hospitalVOForHeader";

	//

	/** The sl no. */
	String SL_NO = "1";

	// ////////Disaster Plan Storage Path
 
	// Master verification
	/** The master verification module list. */
	String MASTER_VERIFICATION_MODULE_LIST = "masterVerficationModuleList";

	/** The master verification vo list. */
	String MASTER_VERIFICATION_VO_LIST = "masterVerficationVOList";

	/** The master verification master option list. */
	String MASTER_VERIFICATION_MASTER_OPTION_LIST = "masterOptionList";

	/** The master verification orderby option list. */
	String MASTER_VERIFICATION_ORDERBY_OPTION_LIST = "orderByOptionList";

	/** The master verification vo. */
	String MASTER_VERIFICATION_VO = "masterVerificationVO";

	/** The master data list. */
	String MASTER_DATA_LIST = "masterDataList";

	/** The master criteria option list. */
	String MASTER_CRITERIA_OPTION_LIST = "masterCriteriaOptionList";

	/** The master criteria data. */
	String MASTER_CRITERIA_DATA = "masterCriteriaDataList";

	/** The master data map. */
	String MASTER_DATA_MAP = "masterDataMap";

	/** The master list. */
	String MASTER_LIST = "masterList";

	/** The master column list. */
	String MASTER_COLUMN_LIST = "masterColumnList";

	// /////Registration Timine Bound

	/** The time bound registration required yes. */
	String TIME_BOUND_REGISTRATION_REQUIRED_YES = "1";

	/** The time bound registration required no. */
	String TIME_BOUND_REGISTRATION_REQUIRED_NO = "0";

	/** The time bound registration required. */
	String TIME_BOUND_REGISTRATION_REQUIRED = TIME_BOUND_REGISTRATION_REQUIRED_NO;

	// //Module ID
	/** The module id registration. */
	String MODULE_ID_REGISTRATION = "11";

	/** The module id emergency. */
	String MODULE_ID_EMERGENCY = "12";

	// ////Refer Patient Acceptence Days

	/** The refer patient acceptence within days. */
	String REFER_PATIENT_ACCEPTENCE_WITHIN_DAYS = "1";

	// ///////Registration Billing Required

	/*
	 * String REGISTRATION_BILLING_REQUIRED_YES="1"; String
	 * REGISTRATION_BILLING_REQUIRED_NO="0"; String
	 * REGISTRATION_BILLING_REQUIRED=REGISTRATION_BILLING_REQUIRED_NO;
	 */

	/** The patient audit log mst vo list. */
	String PATIENT_AUDIT_LOG_MST_VO_LIST = "patientAuditLogVOList";

	/** The patient audit log data. */
	String PATIENT_AUDIT_LOG_DATA = "patientAuditLogData";

	/** The patient audit log options. */
	String PATIENT_AUDIT_LOG_OPTIONS = "patientAuditLogOptions";

	/** The audit log column name list. */
	String AUDIT_LOG_COLUMN_NAME_LIST = "auditLogColumnNameList";

	/** The audit log current record row list. */
	String AUDIT_LOG_CURRENT_RECORD_ROW_LIST = "auditLogCurrentRecordRowList";

	/** The audit log row list. */
	String AUDIT_LOG_ROW_LIST = "auditLogRowList";

	/** The audit log display logic not needed. */
	String AUDIT_LOG_DISPLAY_LOGIC_NOT_NEEDED = "1"; // if no logic is needed to
														// display the record
	/** The audit log display logic needed. */
	String AUDIT_LOG_DISPLAY_LOGIC_NEEDED = "2"; // to display the entry date
	// and enter by
	/** The audit log display logic needed for baserecord. */
	String AUDIT_LOG_DISPLAY_LOGIC_NEEDED_FOR_BASERECORD = "3"; // separate
	// Query for the
	// base/first
	// record
	/** The audit header list. */
	String AUDIT_HEADER_LIST = "auditHeaderList";

	/** The sysdate login. */
	String SYSDATE_LOGIN = "SYSDATELOGIN";

	/** The sysdateobject login. */
	String SYSDATEOBJECT_LOGIN = "SYSDATEOBJECTLOGIN";

	/** The is valid arr. */
	String[] IS_VALID_ARR = { "Deleted", "Active", "InActive" };

	// int deploymentMode = 1;// for linux
	/** The deployment mode. */
	int deploymentMode = 0;// for windows

	/** The cancelpage. */
	String CANCELPAGE = "CANCELPAGE";
}
