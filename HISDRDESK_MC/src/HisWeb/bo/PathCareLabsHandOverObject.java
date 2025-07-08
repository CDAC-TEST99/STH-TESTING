package HisWeb.bo;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PathCareLabsHandOverObject {

	@SerializedName("patientData")
	@Expose
	public List<PatientDataHandOverObject> patientHandOverData;
	
	public List<PatientDataHandOverObject> getPatientHandOverData() {
	return patientHandOverData;
	}
	
	public void setPatientHandOverData(List<PatientDataHandOverObject> patientHandOverData) {
	this.patientHandOverData = patientHandOverData;
	}
	
		//Inner Class
	public static  class PatientDataHandOverObject {
		
			@SerializedName("crNo")
			@Expose
			private String crNo;
			
			@SerializedName("patName")
			@Expose
			private String patName;
			
			@SerializedName("gender")
			@Expose
			private String gender;
			
			@SerializedName("age")
			@Expose
			private String age;
			
			@SerializedName("facilityId")
			@Expose
			private String facilityId;
			
			@SerializedName("mohallaClinicName")
			@Expose
			private String mohallaClinicName;
			
			@SerializedName("episodeCode")
			@Expose
			private String episodeCode;
			
			@SerializedName("mobNo")
			@Expose
			private String mobNo;
			
			@SerializedName("handOverTo")
			@Expose
			private String handOverTo;
			
			@SerializedName("handOverDateTime")
			@Expose
			private String handOverDateTime;
			
			@SerializedName("handOverPersonMobile")
			@Expose
			private String handOverPersonMobile;
			
			@SerializedName("testCode_arr")
			@Expose
			private List<InvestigationTestWiseHandOverDetailsObject> testCodeArr;
			
			public PatientDataHandOverObject(String crNo, String patName, String gender, String age, String facilityId,
					String mohallaClinicName, String episodeCode, String mobNo, String handOverTo,
					String handOverDateTime, String handOverPersonMobile,
					List<InvestigationTestWiseHandOverDetailsObject> testCodeArr) {
				super();
				this.crNo = crNo;
				this.patName = patName;
				this.gender = gender;
				this.age = age;
				this.facilityId = facilityId;
				this.mohallaClinicName = mohallaClinicName;
				this.episodeCode = episodeCode;
				this.mobNo = mobNo;
				this.handOverTo = handOverTo;
				this.handOverDateTime = handOverDateTime;
				this.handOverPersonMobile = handOverPersonMobile;
				this.testCodeArr = testCodeArr;
			}

			//methods
			public String getCrNo() {
			return crNo;
			}
			
			public void setCrNo(String crNo) {
			this.crNo = crNo;
			}
			
			public String getPatName() {
			return patName;
			}
			
			public void setPatName(String patName) {
			this.patName = patName;
			}
			
			public String getGender() {
			return gender;
			}
			
			public void setGender(String gender) {
			this.gender = gender;
			}
			
			public String getAge() {
			return age;
			}
			
			public void setAge(String age) {
			this.age = age;
			}
			
			public String getFacilityId() {
			return facilityId;
			}
			
			public void setFacilityId(String facilityId) {
			this.facilityId = facilityId;
			}
			
			public String getMohallaClinicName() {
			return mohallaClinicName;
			}
			
			public void setMohallaClinicName(String mohallaClinicName) {
			this.mohallaClinicName = mohallaClinicName;
			}
			
			public String getEpisodeCode() {
			return episodeCode;
			}
			
			public void setEpisodeCode(String episodeCode) {
			this.episodeCode = episodeCode;
			}
			
			public String getMobNo() {
				return mobNo;
			}

			public void setMobNo(String mobNo) {
				this.mobNo = mobNo;
			}

			public String getHandOverTo() {
				return handOverTo;
			}

			public void setHandOverTo(String handOverTo) {
				this.handOverTo = handOverTo;
			}

			public String getHandOverDateTime() {
				return handOverDateTime;
			}

			public void setHandOverDateTime(String handOverDateTime) {
				this.handOverDateTime = handOverDateTime;
			}

			public String getHandOverPersonMobile() {
				return handOverPersonMobile;
			}

			public void setHandOverPersonMobile(String handOverPersonMobile) {
				this.handOverPersonMobile = handOverPersonMobile;
			}
			
			public List<InvestigationTestWiseHandOverDetailsObject> getTestCodeArr() {
			return testCodeArr;
			}
			
			public void setTestCodeArr(List<InvestigationTestWiseHandOverDetailsObject> testCodeArr) {
			this.testCodeArr = testCodeArr;
			}
			
							//Inner(Inner Class)
							public static class InvestigationTestWiseHandOverDetailsObject {
								
								@SerializedName("reqNo")
								@Expose
								private String reqNo;
								
								@SerializedName("reqDate")
								@Expose
								private String reqDate;								
				
								@SerializedName("testCode")
								@Expose
								private String testCode;
								
								@SerializedName("testName")
								@Expose
								private String testName;
								
								@SerializedName("vialNo")
								@Expose
								private String vialNo;
								
								public String getReqNo() {
								return reqNo;
								}
								
								public void setReqNo(String reqNo) {
								this.reqNo = reqNo;
								}
									
								public String getReqDate() {
								return reqDate;
								}
								
								public void setReqDate(String reqDate) {
								this.reqDate = reqDate;
								}
				
								public String getVialNo() {
									return vialNo;
								}

								public void setVialNo(String vialNo) {
									this.vialNo = vialNo;
								}

								public String getTestCode() {
								return testCode;
								}
				
								public void setTestCode(String testCode) {
								this.testCode = testCode;
								}
				
								public String getTestName() {
								return testName;
								}
				
								public void setTestName(String testName) {
								this.testName = testName;
								}
								
								
								public InvestigationTestWiseHandOverDetailsObject(String reqNo, String reqDate, String testCode, String testName,String vialNo)
								{
									this.reqNo = reqNo;
									this.reqDate = reqDate;
									this.testCode = testCode;
									this.testName = testName;
									this.vialNo = vialNo;
								}
				
							}
			
			}

}


//-----------------------------------com.example.TestCodeArr.java-----------------------------------
/*
 * package com.example;
 * 
 * import javax.annotation.Generated; import com.google.gson.annotations.Expose;
 * import com.google.gson.annotations.SerializedName;
 * 
 * @Generated("jsonschema2pojo") public class TestCodeArr {
 * 
 * @SerializedName("testCode")
 * 
 * @Expose private String testCode;
 * 
 * @SerializedName("testName")
 * 
 * @Expose private String testName;
 * 
 * public String getTestCode() { return testCode; }
 * 
 * public void setTestCode(String testCode) { this.testCode = testCode; }
 * 
 * public String getTestName() { return testName; }
 * 
 * public void setTestName(String testName) { this.testName = testName; }
 * 
 * }
 */