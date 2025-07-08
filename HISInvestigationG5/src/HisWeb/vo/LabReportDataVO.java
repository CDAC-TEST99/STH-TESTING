package HisWeb.vo;

public class LabReportDataVO {
	 public String testCode;
	    public String reportFileName;
	    //@JsonProperty("TestDate") 
	    public String testDate;
	    public String laboratoryName;
	    public String requisitionNo;
	    public String crno;
	  //  @JsonProperty("LabCode") 
	    public String labCode;
	    public String testName;
	    
	    
	    
		public String getTestCode() {
			return testCode;
		}
		public void setTestCode(String testCode) {
			this.testCode = testCode;
		}
		public String getReportFileName() {
			return reportFileName;
		}
		public void setReportFileName(String reportFileName) {
			this.reportFileName = reportFileName;
		}
		public String getTestDate() {
			return testDate;
		}
		public void setTestDate(String testDate) {
			this.testDate = testDate;
		}
		public String getLaboratoryName() {
			return laboratoryName;
		}
		public void setLaboratoryName(String laboratoryName) {
			this.laboratoryName = laboratoryName;
		}
		public String getRequisitionNo() {
			return requisitionNo;
		}
		public void setRequisitionNo(String requisitionNo) {
			this.requisitionNo = requisitionNo;
		}
		public String getCrno() {
			return crno;
		}
		public void setCrno(String crno) {
			this.crno = crno;
		}
		public String getLabCode() {
			return labCode;
		}
		public void setLabCode(String labCode) {
			this.labCode = labCode;
		}
		public String getTestName() {
			return testName;
		}
		public void setTestName(String testName) {
			this.testName = testName;
		}

	    
	    
}
