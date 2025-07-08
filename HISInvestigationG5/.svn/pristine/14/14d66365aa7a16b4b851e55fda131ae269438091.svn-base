package hisglobal;

import hisglobal.exceptions.HisException;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.vo.HospitalMstVO;
import hisglobal.vo.UserVO;
import ipd.IpdBO;
import ipd.IpdVO;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.sql.rowset.WebRowSet;

import org.json.JSONObject;
public class PatientDetailNew implements Tag {

	static PageContext pageContext;
	private String crNo = "0";
	private String benId = "0";
	


	private boolean address = false;
	private boolean motherCrFlag = false;
	String tileBgColor="transparent";
	public static String USER_VO = "keyUserVO";
	public static String PATIENT_VO = "keyPatientVO";
	public static String HOSPITAL_VO = "keyHospitalVO";
	
	public boolean isAddress() {
		return address;
	}
	public void setAddress(boolean address) {
		this.address = address;
	}
	public String getCrNo() {
		return crNo;
	}
	public void setCrNo(String crNo) {
		this.crNo = crNo;
	}
	
	public String getBenId() {
		return benId;
	}
	public void setBenId(String benId) {
		this.benId = benId;
	}
	public boolean isMotherCrFlag() {
		return motherCrFlag;
	}
	public void setMotherCrFlag(boolean motherCrFlag) {
		this.motherCrFlag = motherCrFlag;
	}
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}
	
	
	
	public int doStartTag() throws JspException {
		IpdVO voObj = null;
		WebRowSet ws = null;
		JspWriter jw = null;
		String isBPL="0";
		String isMLC="0";
		String isRefer="0";
		String isNewBorn="0";
		JSONObject obj=null;
		
		HttpServletRequest _request = (HttpServletRequest)getPageContext().getRequest();
		
		try {
			voObj = new IpdVO();
			jw = pageContext.getOut();
			ws = getPatientDtlsWs(voObj);
			System.out.println("crNo"+crNo);
			//System.out.println("ws.size :"+ws.size());
			if (ws!=null && ws.size()>0) {
				try {
					
					UserVO userVO = getUserVO(_request);
					
					String patOthersVal =retrieveJsonByCrNo( crNo ,  userVO.getHospitalCode() );
					if(patOthersVal!=null) {
					 obj=new JSONObject(patOthersVal);
					////System.out.println("patOthersValpatOthersValpatOthersValpatOthersVal"+patOthersVal);
					}
					
					
					if (ws.next()) {
						String strAgeAndSex = 			ws.getString(2);
						String strPatientName = 		ws.getString(3);
						String strFather = ws.getString(4);
						String strHusbandName=ws.getString(10);
						String strReligion =			ws.getString(5);
						String strCategoryName =		ws.getString(6);
						String strCategoryCode =		ws.getString(7);
						String strAddress =				ws.getString(8);
						String strMlcNo=ws.getString(9);
						String strMotherName=ws.getString(11);
						String strMotherPuk=ws.getString(12);
						String strEmailId=ws.getString(15);
						String strMobile=ws.getString(17);
						String strMotherDtl=strMotherName+"^"+strMotherPuk;
						String strRegDt=ws.getString(18);
						String strEmgContact=ws.getString(19);
						String strBornInHosp=ws.getString(20);
						if(strHusbandName == null) strHusbandName = "";//"---";
						String strHiddenPatDtl=strPatientName+"^"+strFather+"/"+strHusbandName+"^"+strCategoryName+"^"+strAgeAndSex+"^"+strAddress;
						if(strAgeAndSex == null) strAgeAndSex = "";
						if(strPatientName == null) strPatientName = "";
						if(strFather == null) strFather = "";
						if(strHusbandName == null) strHusbandName = "";
						if(strReligion == null) strReligion = "";
						if(strCategoryName == null) strCategoryName = "";
						if(strCategoryCode == null) strCategoryCode = "";
						if(strAddress == null) strAddress = "";
						if(strMlcNo == null) strMlcNo = "";
						if(strMlcNo.equals("0")) strMlcNo = "";
						
						String fatherHusbandName="";//Show Either Father Name or Husband Name
						if(strFather == null || strFather.equals(""))
						{
							if(strHusbandName == null || strHusbandName.equals("")) 
								fatherHusbandName ="---";
							else
								fatherHusbandName=strHusbandName;
						}
						else
							fatherHusbandName=strFather;
						
						String str_patstatus=ws.getString(21);
						String str_patunknown=ws.getString(22);
						String str_patdead=ws.getString(23);
						String str_patvip=ws.getString(24);

						
						
						String gender=strAgeAndSex.replace("/", "#").split("#")[1].trim();
						String genderClass="<i class='fas fa-user' style='font-size: 26px;color: #6363ff;'></i>";
						
						if(patOthersVal!=null && (!obj.getString("profile_pic").equalsIgnoreCase("NULL"))) {
							//if(voObj.getIsNewBorn().equals("1"))
								//sb.append("<i class='fas fa-baby' style='font-size: 26px; color: rgba(33, 32, 32, 0.7);'></i>");
							if(gender.equalsIgnoreCase("M"))
							//sb.append("<i class='fas fa-user' style='font-size: 26px; color: #6363ff;'></i>");
								genderClass=("<img src="+obj.getString("profile_pic")+" class='cutumIcons' width='26'>");
							else if(gender.equalsIgnoreCase("F"))
								genderClass=("<img src="+obj.getString("profile_pic")+" class='cutumIcons' width='26'>");
								//sb.append("<i class='fa fa-female'aria-hidden='true' style='font-size: 26px; color: #dd8d9b;'></i>");

							else
								genderClass=("<img src='/HISInvestigationG5/hisglobal/images/patIcon.png' style=' height: 26px;vertical-align: text-bottom;padding-right: 10px;'> ");
							
							if(strMotherPuk!=null)
							{
								if(strMotherPuk.equals("") || strMotherPuk.equals(" ") || strMotherPuk.equals("0"))
									genderClass=genderClass;
								else
								{
									genderClass="<i class='fa fa-baby fa-lg'  title='New Born:Mother Ben Id.:"+strMotherPuk+"' style='cursor: pointer; cursor: hand'></i>";
									isNewBorn="1";
									fatherHusbandName=strMotherName;
								}
							}
							
							}else {
								if(gender.equals("M"))
									genderClass=("<img src='/HIS/hisglobal/images/img_avatar_Male.png'  class='cutumIcons'  width='26'> ");
								else if(gender.equals("F"))
									genderClass=("<img src='/HIS/hisglobal/images/img_avatar_Female.png'  class='cutumIcons'  width='26'> ");
								else
									genderClass=("<img src='/HISInvestigationG5/hisglobal/images/patIcon.png'  class='cutumIcons'  width='26'> ");
								
								if(strMotherPuk!=null)
								{
									if(strMotherPuk.equals("") || strMotherPuk.equals(" ") || strMotherPuk.equals("0"))
										genderClass=genderClass;
									else
									{
										genderClass="<i class='fa fa-baby fa-lg'  title='New Born:Mother Ben Id.:"+strMotherPuk+"' style='cursor: pointer; cursor: hand'></i>";
										isNewBorn="1";
										fatherHusbandName=strMotherName;
									}
								}
									
							}
						
					/*	if(gender.equals("M"))
							genderClass="<i class='fas fa-user' style='font-size: 26px;color: #6363ff;' title='Male'></i>";
						if(gender.equals("F"))
							genderClass="<i class='fa fa-female' style='font-size: 26px;color: #dd8d9b;' title='Female'></i>";
						if(gender.equals("O"))
							genderClass="<i class='fas fa-neuter' style='font-size: 26px;color: #6363ff;' title='Others'></i>";
						if(strMotherPuk!=null)
						{
							if(strMotherPuk.equals("") || strMotherPuk.equals(" ") || strMotherPuk.equals("0"))
								genderClass=genderClass;
							else
							{
								genderClass="<i class='fa fa-baby fa-lg'  title='New Born:Mother CR No.:"+strMotherPuk+"' style='cursor: pointer; cursor: hand'></i>";
								isNewBorn="1";
								fatherHusbandName=strMotherName;
							}
						}		*/				
						
						
						/*if(ws.getObject("MotherPuk")!=null && !ws.getObject("MotherPuk").equals(""))		
						{
							isNewBorn="1";
							jw.print("<input type='hidden' name='strHiddenPatDtl' value='"+strHiddenPatDtl+"'><input type='hidden' name='strPatName' value='"+strPatientName+"'>");
							jw.print("<table class='TABLEWIDTH' border='0' cellspacing='1px' align='center' ><tr><td width='25%' class='LABEL'>Name</td>");
							jw.print("<td  width='25%' class='CONTROL' title='CR No:"+ws.getString(1)+"' style='cursor: pointer; cursor: hand'> ");
							jw.print(strPatientName);
							jw.print("</td>");
							jw.print("<td width='25%' class='LABEL'>Mother Name</td>");
							jw.print("<td  width='25%' class='CONTROL' title='Mother CR No.:"+strMotherPuk+"' style='cursor: pointer; cursor: hand'> ");
							jw.print("<font color='blue'>"+strMotherName+"</font>");
							jw.print("</td>");
							
							fatherHusbandName=strMotherName;
						}
						else
						{*/
							/*jw.print("<input type='hidden' name='strHiddenPatDtl' value='"+strHiddenPatDtl+"'><input type='hidden' name='strPatName' value='"+strPatientName+"'>");
							jw.print("<table class='TABLEWIDTH' border='0' cellspacing='1px' align='center' ><tr><td width='25%' class='LABEL'>Name</td>");
							jw.print("<td colspan='3' width='75%' class='CONTROL' title='CR No:"+ws.getString(1)+"' style='cursor: pointer; cursor: hand'> ");
							jw.print(strPatientName);
							jw.print("</td>");*/
							
							jw.print("<input type='hidden' name='strHiddenPatDtl' value='"+strHiddenPatDtl+"'><input type='hidden' name='strPatName' value='"+strPatientName+"'>");
							jw.print("<input type='hidden' name='strCategoryCode' value='"+strCategoryCode+"'>");
							jw.print("<input type='hidden' name='ispat_vip' value='"+str_patvip+"'>");
							jw.print("<input type='hidden' name='ispat_dead' value='"+str_patdead+"'>");
							jw.print("<input type='hidden' name='ispat_unknown' value='"+str_patunknown+"'>");
							

							/*jw.print("<table class='table'><thead><tr><th ></th><th></th><th></th><th></th></tr></thead>");
							jw.print("<tbody>");
							jw.print("<tr><td align='Right' class='LABEL'>Name</td>");
							jw.print("<td title='CR No:"+ws.getString(1)+"' style='cursor: pointer; cursor: hand'> ");
							jw.print(strPatientName);
							jw.print("</td>");
							jw.print("<td>");
							jw.print("</td>");
							jw.print("<td>");
							jw.print("</td>");*/
							jw.print("<div class='patTile'>");
							//jw.print("<nav class='navbar navbar-expand-sm  navbar-dark' style='padding: .1rem 1rem; border-radius: .1rem;  line-height: 2.1'>");
							
							//jw.print("<i class='fa fa-user'></i>&nbsp;&nbsp;&nbsp;&nbsp;");
							//jw.print("<div class='row'><div class='col-sm-4'><b>CR No:&nbsp;&nbsp;"+ws.getString(1)+"&nbsp;&nbsp;&nbsp;&nbsp;  •&nbsp;&nbsp;&nbsp;&nbsp;Name:&nbsp;&nbsp;"+strPatientName+" &nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;&nbsp;&nbsp; AgeAndSex:&nbsp;&nbsp;"+strAgeAndSex+" &nbsp;&nbsp;&nbsp;&nbsp;• &nbsp;&nbsp;&nbsp;&nbsp;Father&nbsp;&nbsp;"+ strFather+"/"+strHusbandName+" &nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;&nbsp;&nbsp; CategoryName:&nbsp;&nbsp;"+strCategoryName);
							//jw.print("<div class='row'><div class='col-xs-2'><i class='fa fa-user'></i>&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='col-xs-2'><b>CR No:&nbsp;&nbsp;"+ws.getString(1)+"&nbsp;&nbsp;&nbsp;&nbsp;</b></div><div class='col-xs-2'><b>•&nbsp;&nbsp;&nbsp;&nbsp;Name:&nbsp;&nbsp;"+strPatientName+" &nbsp;&nbsp;&nbsp;&nbsp;</b></div><div class='col-xs-2'><b>•&nbsp;&nbsp;&nbsp;&nbsp; AgeAndSex:&nbsp;&nbsp;"+strAgeAndSex+" &nbsp;&nbsp;&nbsp;&nbsp;</b></div><div class='col-xs-2'><b>• &nbsp;&nbsp;&nbsp;&nbsp;Father&nbsp;&nbsp;"+ strFather+"/"+strHusbandName+" &nbsp;&nbsp;&nbsp;&nbsp;</b></div><div class='col-xs-2'><b>•&nbsp;&nbsp;&nbsp;&nbsp; CategoryName:&nbsp;&nbsp;"+strCategoryName);    
							
							if((ws.getString(9).equals("0")))  //for MLC
							{
								//jw.print("<div class='row'><div class='col-xs-2'>"+genderClass+"</i>&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='col-xs-2'>CR No:&nbsp;&nbsp;"+ws.getString(1)+"&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='col-xs-2'>•&nbsp;&nbsp;&nbsp;&nbsp;Name:&nbsp;&nbsp;"+strPatientName+" &nbsp;&nbsp;&nbsp;&nbsp;</div><div class='col-xs-1'>•&nbsp;&nbsp;&nbsp;&nbsp; Age/Gender:&nbsp;&nbsp;"+strAgeAndSex+" &nbsp;&nbsp;&nbsp;&nbsp;</div><div class='col-xs-2'>• &nbsp;&nbsp;&nbsp;&nbsp;Father:&nbsp;&nbsp;"+ strFather+"/"+strHusbandName+" &nbsp;&nbsp;&nbsp;&nbsp;</div><div class='col-xs-2'>•&nbsp;&nbsp;&nbsp;&nbsp; CategoryName:&nbsp;&nbsp;"+strCategoryName+"</div><div class='col-xs-1'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class='fas fa-flag text-danger'> MLC</i></div>");
								//jw.print("<div class='row'><div class='col-xs-2'>"+genderClass+"</i></div><div class='col-xs-2'>CR No:&nbsp;&nbsp;"+ws.getString(1)+"</div><div class='col-xs-2'>•Name:&nbsp;&nbsp;"+strPatientName+" </div><div class='col-xs-1'>•Age/Gender:&nbsp;&nbsp;"+strAgeAndSex+" </div><div class='col-xs-2'>•Father:&nbsp;&nbsp;"+ strFather+"/"+strHusbandName+"</div><div class='col-xs-2'>•CategoryName:&nbsp;&nbsp;"+strCategoryName+"</div><div class='col-xs-1'><i class='fas fa-flag text-danger'> MLC</i></div>");
								jw.print("<div style='font-size: 14px;font-weight: 400 !important; letter-spacing: 3px; color: rgba(75,75,75, 0.7); text-transform: uppercase;' class='row justify-content-center tileHeader rownopadding'>");								
								jw.print("<div class='col-xs-1'>"+genderClass+"</i></div>");
								jw.print("<div class='col-xs-1' style='margin-left:20px'></div>");
								jw.print("<div class='col-xs-2' title='Patient Name'>"+strPatientName+" </div>");
								jw.print("<div class='col-xs-4'> ("+strAgeAndSex+"  / "+strCategoryName+"  / "+strMobile+") </div>");
								if(isMotherCrFlag())
									jw.print("<div class='col-xs-2'>&nbsp;&nbsp;<b> Mother Ben Id:"+ws.getString(1)+"<b></div>");
								else
								{
									
										jw.print("<div class='col-xs-2'>&nbsp;&nbsp;<b>Ben Id :"+ws.getString(1)+"</b></div>");
								}
								//jw.print("<div class='col-xs-2 ml-auto'><i class='fas fa-flag text-danger' title='"+strMlcNo+"' style='cursor: pointer; cursor: hand'>MLC</i></div>");								
								//jw.print("<div class='col-xs-1'><i class='fas fa-flag text-danger' title='"+strMlcNo+"' style='cursor: pointer; cursor: hand'>MLC</i></div>");
							
								if(patOthersVal!=null) {
									
									//sb.append("<b style='letter-spacing: 1px;'>UMID :</b><font style='letter-spacing: 1px;font-size: 14px;font-weight: 400 !important;'> &nbsp;"+obj.getString("umid_no")+" </font>");
									jw.print("<div class='col-xs-2'>&nbsp;&nbsp;<b>UMID :"+obj.getString("umid_no")+"</b></div>");
								}
								
								
								if(str_patvip!=null && str_patvip.equals("1"))
									jw.print("<div class='col-xs-2'><span style='color:red'><b>&nbsp;&nbsp;(VIP)</b></span></div>");
								
								
								if(str_patdead!=null && str_patdead.equals("1"))
									jw.print("<div class='col-xs-2'><span style='color:red'><b>&nbsp;&nbsp;(Dead)</b></span></div>");
									
								if(str_patunknown!=null && str_patunknown.equals("1"))
									jw.print("<div class='col-xs-2'><span style='color:red'><b>&nbsp;&nbsp;(unknown)</b></span></div>");
								
								
								if(str_patstatus!=null && str_patstatus.equals("IPD"))
									jw.print("<div class='col-xs-2'><span style='color:green'><b>&nbsp;&nbsp;(Admitted)</b></span></div>");
									
								
								jw.print("<div class='col-xs-2'><i class='fa fa-users' style='font-size: 26px;color:#4067c5; margin-left: 40px;' onclick='openDetailedPatInfo()' id='patInfo'></i></div>");
								
								
								jw.print("<div class='col-xs-2'><i id='sd1' class='fa fa-plus-square' aria-hidden='true' data-toggle='modal' data-target='#myModal2'  style='font-size: 26px;color:#4067c5; margin-left: 40px;' ></i></div>");
							
							}
							else
							{
								//jw.print("<div class='row'><div class='col-xs-2'>"+genderClass+"</i>&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='col-xs-2'>CR No:&nbsp;&nbsp;"+ws.getString(1)+"&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='col-xs-2'>•&nbsp;&nbsp;&nbsp;&nbsp;Name:&nbsp;&nbsp;"+strPatientName+" &nbsp;&nbsp;&nbsp;&nbsp;</div><div class='col-xs-2'>•&nbsp;&nbsp;&nbsp;&nbsp; Age/Gender:&nbsp;&nbsp;"+strAgeAndSex+" &nbsp;&nbsp;&nbsp;&nbsp;</div><div class='col-xs-2'>• &nbsp;&nbsp;&nbsp;&nbsp;Father&nbsp;&nbsp;"+ strFather+"/"+strHusbandName+" &nbsp;&nbsp;&nbsp;&nbsp;</div><div class='col-xs-2'>•&nbsp;&nbsp;&nbsp;&nbsp; CategoryName:&nbsp;&nbsp;"+strCategoryName+"</div>");
								jw.print("<div style='font-size: 14px;font-weight: 400 !important; letter-spacing: 3px; color: rgba(75,75,75, 0.7); text-transform: uppercase;' class='row justify-content-center tileHeader'>");								
								jw.print("<div class='col-xs-1'>"+genderClass+"</i></div>");
								jw.print("<div class='col-xs-1' style='margin-left:20px'></div>");
								jw.print("<div class='col-xs-2'>"+strPatientName+" </div>");
								jw.print("<div class='col-xs-4'> ("+strAgeAndSex+"  / "+strCategoryName+"  / "+strMobile+") </div>");
								if(isMotherCrFlag())
									jw.print("<div class='col-xs-2'>&nbsp;&nbsp;<b> Mother Ben Id :"+ws.getString(1)+"</b></div>");
								else
								{
										jw.print("<div class='col-xs-2'>&nbsp;&nbsp;<b>Ben Id:"+ws.getString(1)+"</b></div>");
								}
								
								if(patOthersVal!=null) {
									
									//sb.append("<b style='letter-spacing: 1px;'>UMID :</b><font style='letter-spacing: 1px;font-size: 14px;font-weight: 400 !important;'> &nbsp;"+obj.getString("umid_no")+" </font>");
									jw.print("<div class='col-xs-2'>&nbsp;&nbsp;<b>UMID :"+obj.getString("umid_no")+"</b></div>");
								}
								
								
								//jw.print("<div class='col-xs-2 ml-auto'><i class='fas fa-flag text-danger' title='"+strMlcNo+"' style='cursor: pointer; cursor: hand'>MLC</i></div>");
								jw.print("<div class='col-xs-1'><i class='fas fa-flag text-danger' title='"+strMlcNo+"' style='cursor: pointer; cursor: hand'>MLC</i></div>");
								
								if(str_patvip!=null && str_patvip.equals("1"))
									jw.print("<div class='col-xs-2'><span style='color:red'><b>&nbsp;&nbsp;(VIP)</b></span></div>");
								
								
								if(str_patdead!=null && str_patdead.equals("1"))
									jw.print("<div class='col-xs-2'><span style='color:red'><b>&nbsp;&nbsp;(Dead)</b></span></div>");
							
								
								if(str_patunknown!=null && str_patunknown.equals("1"))
									jw.print("<div class='col-xs-2'><span style='color:red'><b>&nbsp;&nbsp;(unknown)</b></span></div>");
								
								
								if(str_patstatus!=null && str_patstatus.equals("IPD"))
									jw.print("<div class='col-xs-2'><span style='color:green'><b>&nbsp;&nbsp;(Admitted)</b></span></div>");
									
								jw.print("<div class='col-xs-1'><i class='fa fa-users' title='Patient More Info' style='font-size: 26px;color:#4067c5; margin-left: 40px;' onclick='openDetailedPatInfo()' id='patInfo'></i></div>");								
							
								jw.print("<div class='col-xs-2'><i id='sd1' class='fa fa-plus-square' aria-hidden='true' data-toggle='modal' data-target='#myModal2'  style='font-size: 26px;color:#4067c5; margin-left: 40px;'  ></i></div>");
							}
							//jw.print("<div class="row"><div class="col-sm-4"><label>House No.</label><input type="text" class="form-control form-control-sm" name="strHouseNo" value="" tabindex="2" maxlength="20"></div><div class="col-sm-4"><label><font color="red">*</font>Street/Mohallah</label><input type="text" class="form-control form-control-sm" name="strStreet" value="Fgfdg" tabindex="1" maxlength="60"></div><div class="col-sm-4"><label>Location</label><input type="text" class="form-control form-control-sm" name="strCityLocation" value="" tabindex="2" maxlength="60" onkeypress="return validateData(event,4);"></div></div>
							
							jw.print("</div>");
							//jw.print("</nav>");
							jw.print("</div>");
							
							
							
							//jw.print("<div id='patSideListId' class='patSideList' style='display: none;'>");
							//jw.print("<div id='patSideListId' class='patSideList' style='overflow: scroll;'>");
							
							/* jw.print("<legend class='text-center totalPatHeader' style='color: #fff'>");
							jw.print("<i class='far fa-user-circle fa-lg'></i>");
							jw.print("&nbsp;&nbsp;&nbsp; Patient's Information </legend>"); */
							
							if(patOthersVal!=null) {
								
								jw.print("<div id='patSideListId' class='patSideList' style='overflow: scroll;'>");
								
								//sb.append("<b style='letter-spacing: 1px;'>UMID :</b><font style='letter-spacing: 1px;font-size: 14px;font-weight: 400 !important;'> &nbsp;"+obj.getString("umid_no")+" </font>");
								jw.print("<legend class='text-center totalPatHeader'style='color: #fff'><img src='"+obj.getString("profile_pic")+"' style='height: 50px; width: 50px; border-radius: 24px;'> </img> &nbsp;&nbsp;&nbsp; Patient's Information </legend>");
								}else {
									jw.print("<div id='patSideListId' class='patSideList' style='display: none;'>");
							
							if(gender.equals("M"))
								jw.print("<legend class='text-center totalPatHeader'style='color: #fff'><img src='/HIS/hisglobal/images/img_avatar_Male.png' style='height: 50px; width: 50px; border-radius: 24px;'> </img> &nbsp;&nbsp;&nbsp; Patient's Information </legend>");
							else if(gender.equals("F"))
								jw.print("<legend class='text-center totalPatHeader'style='color: #fff'><img src='/HIS/hisglobal/images/img_avatar_Female.png' style='height: 50px; width: 50px;'> </img> &nbsp;&nbsp;&nbsp; Patient's Information </legend>");
							else
								jw.print("<legend class='text-center totalPatHeader'style='color: #fff'><i class='fas fa-user-circle' style='font-size: 36px;  color: #405562;'> </i> &nbsp;&nbsp;&nbsp; Patient's Information </legend>");
							
								}
							
							
							jw.print("<ul id='patOtherDtl'>");
							jw.print("<li style=' border: none;'>Registration Date:<label class='label'>"+strRegDt+"</label></li>");
							jw.print("<li style=' border: none;'>Father / Spouse Name:<label class='label'>"+fatherHusbandName+"</label></li>");
							jw.print("<li style=' border: none;'>Address:<label class='label'>"+strAddress+"</label></li>");
							jw.print("<li style=' border: none;'>Emergency Contact:<label class='label'>"+strEmgContact+"</label></li>");
							jw.print("<li style=' border: none;'>Borned in Hospital:<label class='label'>"+strBornInHosp+"</label></li>");
							
							if(patOthersVal !=null) {
								
								jw.print("<li style=' border: none;'> UMID		:<label class='label'>" +obj.getString("umid_no")+ "<label></li>");
								jw.print("<li style=' border: none;'> Email Id		:<label class='label'>" +obj.getString("email_id")+ "<label></li>");
								
								jw.print("<li style=' border: none;'> Validity		:<label class='label'>" +obj.getString("validity")+ "<label></li>");
								jw.print("<li style=' border: none;'> Status		:<label class='label'>" +obj.getString("current_status")+ "<label></li>");
								jw.print("<li style=' border: none;'> Age		:<label class='label'>" +obj.getString("age")+ "<label></li>");
								jw.print("<li style=' border: none;'> Blood Group		:<label class='label'>" +obj.getString("blood_group")+ "<label></li>");
								
								jw.print("<li style=' border: none;'> Handicapped		:<label class='label'>" +obj.getString("handicap_status")+ "<label></li>");
								jw.print("<li style=' border: none;'> Level of entitilment		:<label class='label'>" +obj.getString("level_of_entitilment")+ "<label></li>");
								jw.print("<li style=' border: none;'> Department		:<label class='label'>" +obj.getString("department")+ "<label></li>");
								jw.print("<li style=' border: none;'>  Opd eligibility		:<label class='label'>" +obj.getString("opd_eligibility")+ "<label></li>");
								jw.print("<li style=' border: none;'> Ipd eligibility	:<label class='label'>" +obj.getString("ipd_eligibility")+ "<label></li>");
								jw.print("<li style=' border: none;'> Beneficiary		:<label class='label'>" +obj.getString("beneficiary_type")+ "<label></li>");
								
								
								jw.print("<li style=' border: none;'> <label class='label'><label></li>");
								jw.print("<li style=' border: none;'> <label class='label'><label></li>");
								
								
							}
							
							jw.print("</ul></div>");
							
							 /*jw.print("<div class='container' style='line-height: 0.5;'>\n");
							 jw.print("<div class='row justify-content-center'>\n");
							 jw.print("<div class='col-md-12'>\n");
							 jw.print("<div class='card'>\n");
							 jw.print("<article class='card-body'>\n");
							 jw.print("<div class='form-row'>");
							 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Name:</label>&nbsp;&nbsp;"+strPatientName+"");
			                 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("</div>");*/
							


							
						//}
						/*jw.print("</tr>");
						jw.print("<tr><td align='Right' class='LABEL'>Patient Category</td>");
						jw.print("<td>");
						jw.print(strCategoryName);
						jw.print("<input type='hidden' name='strCategoryCode' value='"+strCategoryCode+"'></td>");
						jw.print("<td align='Right'  class='LABEL'>Age/Gender</td>");
						jw.print("<td>");
						jw.print(strAgeAndSex);
						jw.print("</td></tr>");
						jw.print("<tr><td align='Right'  class='LABEL'>Father Name</td>");
						jw.print("<td>");
						jw.print(strFather);
						jw.print("</td>");
						jw.print("<td align='Right'  class='LABEL'>Spouse Name</td>");
						jw.print("<td>");
						jw.print(strHusbandName);
						jw.print("</td></tr>");*/
						
						 /*jw.print("<div class='form-row'>");
						 jw.print("<div class='col form-group'>");
						 jw.print("</div>");
		                 jw.print("<div class='col form-group'>");
		                 jw.print("<input type='hidden' name='strCategoryCode' value='"+strCategoryCode+"'><label>Patient Category:</label>&nbsp;&nbsp;"+strCategoryName+"");
		                 jw.print("</div>");
		                 jw.print("<div class='col form-group'>");
		                 jw.print("<label>Age/Gender:</label>&nbsp;&nbsp;"+strAgeAndSex+"");
						 jw.print("</div>");
		                 jw.print("</div>");
		                 
		                 jw.print("<div class='form-row'>");
						 jw.print("<div class='col form-group'>");
						 jw.print("</div>");
		                 jw.print("<div class='col form-group'>");
		                 jw.print("<label>Father Name:</label>&nbsp;&nbsp;"+strFather+"");
		                 jw.print("</div>");
		                 jw.print("<div class='col form-group'>");
		                 jw.print("<label>Spouse Name:</label>&nbsp;&nbsp;"+strHusbandName+"");
						 jw.print("</div>");
		                 jw.print("</div>");*/
		                 
						
						
						
						if(!(ws.getString(13).equals("0")))  //for BPL
						{
							isBPL="1";
						/*	jw.print("<tr><td align='Right'><font color='red' weight='strong'>Is BPL</font></td>");
							jw.print("<td>Yes</td> ");	
							jw.print("<td align='Right'><font color='red' weight='strong'>BPL No.</font></td>");
							jw.print("<td> ");
							jw.print("<font color='red'>"+ws.getString(13)+"</font></td>");
							jw.print("</tr>");*/
							
							/* jw.print("<div class='form-row'>");
							 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Is BPL:</label>&nbsp;&nbsp;Yes");
			                 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>BPL No:</label>nbsp;&nbsp&;"+ws.getString(13)+"");
							 jw.print("</div>");
			                 jw.print("</div>");*/
			                 
						}
						else
						{
							/*jw.print("<tr><td align='Right' class='LABEL'>Is BPL</td>");
							jw.print("<td>No</td><td></td><td></td>");
							jw.print("</tr>");*/
							
							 /*jw.print("<div class='form-row'>");
							 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Is BPL:</label>&nbsp;&nbsp;No");
			                 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("</div>");*/
							
						}
						
						if(!(ws.getString(9).equals("0")))  //for MLC
						{
							/*isMLC="1";
							jw.print("<tr><td align='Right'>Is MLC</td>");
							jw.print("<td>Yes</td> ");
							
							jw.print("<td align='Right'>MLC No.</td>");
							jw.print("<td> ");
							jw.print("<font color='red'>"+ws.getString(9)+"</font></td>");
							jw.print("</tr>");*/
							
							
							 /*jw.print("<div class='form-row'>");
							 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Is MLC:</label>&nbsp;&nbsp;Yes");
			                 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>MLC No:</label>nbsp;&nbsp&;"+ws.getString(9)+"");
							 jw.print("</div>");
			                 jw.print("</div>");*/
							
						}else
						{
							/*jw.print("<tr><td align='Right' class='LABEL'>Is MLC</td>");
							jw.print("<td>No</td><td></td><td></td> ");
							jw.print("</tr>");*/
							
							 /*jw.print("<div class='form-row'>");
							 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Is MLC:</label>&nbsp;&nbsp;No");
			                 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("</div>");*/
							
						}
						
						if(!(ws.getString(14).equals("0")))  //for Refer
						{
							/*isRefer="1";
							jw.print("<tr><td align='Right' class='LABEL'>Is Refered</td>");
							jw.print("<td >Yes</td> ");
							
							jw.print("<td align='Right'>Refered No.</td>");
							jw.print("<td> ");
							jw.print("<font color='red'>"+ws.getString(14)+"</font></td>");
							jw.print("</tr>");*/
							
							/* jw.print("<div class='form-row'>");
							 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Is Refered:</label>&nbsp;&nbsp;Yes");
			                 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Refered No:</label>nbsp;&nbsp&;"+ws.getString(14)+"");
							 jw.print("</div>");
			                 jw.print("</div>");*/
							
						}else
						{/*
							jw.print("<tr><td align='Right' class='LABEL'>Is Refered</td>");
							jw.print("<td>No</td> <td></td> <td></td>");
							jw.print("</tr>");*/
							
							/* jw.print("<div class='form-row'>");
							 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Is Refered:</label>&nbsp;&nbsp;No");
			                 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("</div>");*/
							
						}
						if(isAddress())
						{
							/*jw.print("<tr>");
							jw.print("<td width='25%' class='LABEL'>Address</td>");
							jw.print("<td colspan='3' class='CONTROL'>");
							jw.print(strAddress);
							jw.print("</td></tr>");*/
						}
						jw.print("<input type='hidden' name='strIsBPL' value='"+isBPL+"'>");
						jw.print("<input type='hidden' name='strBPLNo' value='"+ws.getString(13)+"'>");
						jw.print("<input type='hidden' name='strIsMLC' value='"+isMLC+"'>");
						jw.print("<input type='hidden' name='strMLCNo' value='"+ws.getString(9)+"'>");
						jw.print("<input type='hidden' name='strIsRefer' value='"+isRefer+"'>");
						jw.print("<input type='hidden' name='strReferNo' value='"+ws.getString(14)+"'>");
						jw.print("<input type='hidden' name='strIsNewBorn' value='"+isNewBorn+"'>");
						jw.print("<input type='hidden' name='strMotherDtl' value='"+strMotherDtl+"'>");
						jw.print("<input type='hidden' name='strEmailId' value='"+strEmailId+"'>");
						jw.print("<input type='hidden' name='strpack' value='"+ws.getString(16)+"'>");
						
						//jw.print("</tbody>");

						//jw.print("</table>");
						
						
						 /*jw.print("</article>\n");*/
						/* jw.print("</div>\n");
						 jw.print("</div>\n");
						 jw.print("</div>\n");
						 jw.print("</div>\n");*/

					}
				} catch (Exception e) {
					new Exception(e.getMessage()); 
				}
			}
			else
			{
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
			voObj.setStrMsgString("Error while getting patient detail");
			new HisException("IPD Transaction","PatientDetail Tag.doStartTag() -->",e.getMessage());
		}
		finally {
			try {
				jw.print("<input type='hidden' name='strGlbErrMsgTLD' value='"+voObj.getStrMsgString()+"'>");
				ws.close();
			}catch(Exception e) {}
			ws = null;
			voObj = null;
		}
		return EVAL_BODY_INCLUDE;
	}

	public Tag getParent() {
		return null;
	}

	public void release() {
	}

	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	public static PageContext getPageContext() 
	{
		return pageContext;
	}
	
	public void setParent(Tag tag) {
	}
	
	public static UserVO getUserVO(HttpServletRequest request)
	{
		UserVO userVO=null;
		try
		{
			userVO = (UserVO) request.getSession().getAttribute(USER_VO);			
			HospitalMstVO objHospitalMstVO=(HospitalMstVO)request.getSession().getAttribute(HOSPITAL_VO);
			userVO.setStrHospitalMstVo(objHospitalMstVO);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userVO;

	}

    public WebRowSet getPatientDtlsWs(IpdVO voObj)throws Exception{
		
		WebRowSet ws = null;
		IpdBO boObj = new IpdBO();
		if(!this.getCrNo().equals("")){
		voObj.setStrValue1(this.getCrNo());
		boObj.getPatientDetails(voObj);
		}
		else{
			ws = null;
		}
		ws = voObj.getGblWs1();
		return ws;
}
    
    
    public   String retrieveJsonByCrNo(String crNo , String Hosp_code) 
	{
    	JSONObject obj=null;
		WebRowSet rs = null;
		HisDAO daoObj = null;
		String strProcName = "{call pkg_reg_view_railtel.PROC_PATIENT_DETAIL_WITH_CRNO_JSON(?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String Result = null;
		String strErr="",strMode = "0";
		try 
		{
			daoObj = new HisDAO("HISGlobal","PatientDetailNew");
			nProcIndex = daoObj.setProcedure(strProcName);
			//if(objPatientVO_p.getOtherHospitalFlag()!=null && objPatientVO_p.getOtherHospitalFlag().equals("1"))
			//	strMode="1";
			////System.out.println(crNo+ "                  "+Hosp_code);
			////System.out.println("objPatientVO_p.getStrHospCode()::::::::::::  "+objPatientVO_p.getStrHospCode());
			daoObj.setProcInValue(nProcIndex, "p_mode", strMode,1);
			daoObj.setProcInValue(nProcIndex, "p_hosp_code",Hosp_code ,2);
			daoObj.setProcInValue(nProcIndex, "p_crno", crNo,3);
			daoObj.setProcInValue(nProcIndex, "p_isvalid","1",4);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");
			rs = daoObj.getWebRowSet(nProcIndex, "resultset");
			
			////System.out.println("patient details tile ws size"+rs.size());
	
			strErr = daoObj.getString(nProcIndex, "err");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		try 
		{
			
				rs.beforeFirst();
				while(rs.next()) {
				//	//System.out.println(rs.getString(1).toString());
					////System.out.println("result result result result result ");
					Result = rs.getString(1);
					////System.out.println("ResultResultResultResultResultResult"+Result);
				}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
		return Result;
	}
}
