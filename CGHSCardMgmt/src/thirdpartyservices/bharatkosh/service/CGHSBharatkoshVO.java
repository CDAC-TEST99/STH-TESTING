package thirdpartyservices.bharatkosh.service;

import java.util.Calendar;

import lombok.Data;

@Data
public class CGHSBharatkoshVO {

	//Database
	private String DepartmentCode = "017";
	private String InstallationId = "11137";
	private String PaymentTypeId = "0";
	private String PAOCode = "021029";
	private String DDOCode = "221030";
	private String OrderContent = "23093";
	private String Description = "CGHS Contribution - Civil Pensioners";
	
	String timestamp = String.valueOf(Calendar.getInstance().getTimeInMillis());
	
	//Runtime Generate UID
	private String OrderCode = timestamp;
	private String merchantBatchCode = timestamp;

	//static constants
	private String Version = "1.0";
	private String CurrencyCode = "INR";
	private String Transactions = "1";
	private String PaymentMaskCode_OFFLINE = "OffLine";
	private String PaymentMaskCode_ONLINE = "Online";
	
	//Request Object
	private String TotalAmount = "1";
	private String AmountValue = "1";
	private String AmountExponent = "0";
	private String emailId = "abc@gmail.com";
	private String FirstName = "WWWWW";
	private String LastName = "XXXXXX";
	private String Address1 = "NOT GIVEN";
	private String Address2 = "";
	private String PostalCode = "00000";
	private String City = "Daman";
	private String StageRegion = "Delhi";
	private String State = "Delhi";
	private String CountryCode = "India";
	private String MobileNumber = "9911111111";
	public String getDepartmentCode() {
		return DepartmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		DepartmentCode = departmentCode;
	}
	public String getInstallationId() {
		return InstallationId;
	}
	public void setInstallationId(String installationId) {
		InstallationId = installationId;
	}
	public String getPaymentTypeId() {
		return PaymentTypeId;
	}
	public void setPaymentTypeId(String paymentTypeId) {
		PaymentTypeId = paymentTypeId;
	}
	public String getPAOCode() {
		return PAOCode;
	}
	public void setPAOCode(String pAOCode) {
		PAOCode = pAOCode;
	}
	public String getDDOCode() {
		return DDOCode;
	}
	public void setDDOCode(String dDOCode) {
		DDOCode = dDOCode;
	}
	public String getOrderContent() {
		return OrderContent;
	}
	public void setOrderContent(String orderContent) {
		OrderContent = orderContent;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getOrderCode() {
		return OrderCode;
	}
	public void setOrderCode(String orderCode) {
		OrderCode = orderCode;
	}
	public String getMerchantBatchCode() {
		return merchantBatchCode;
	}
	public void setMerchantBatchCode(String merchantBatchCode) {
		this.merchantBatchCode = merchantBatchCode;
	}
	public String getVersion() {
		return Version;
	}
	public void setVersion(String version) {
		Version = version;
	}
	public String getCurrencyCode() {
		return CurrencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		CurrencyCode = currencyCode;
	}
	public String getTransactions() {
		return Transactions;
	}
	public void setTransactions(String transactions) {
		Transactions = transactions;
	}
	public void setPaymentMaskCodeOffline(String paymentMaskCode) {
		PaymentMaskCode_OFFLINE = paymentMaskCode;
	}
	public String getPaymentTypeOffline() {
		return PaymentMaskCode_OFFLINE;
	}
	public void setPaymentMaskCodeOnline(String paymentMaskCode) {
		PaymentMaskCode_ONLINE = paymentMaskCode;
	}
	public String getPaymentTypeOnline() {
		return PaymentMaskCode_ONLINE;
	}
	public String getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		TotalAmount = totalAmount;
	}
	public String getAmountValue() {
		return AmountValue;
	}
	public void setAmountValue(String amountValue) {
		AmountValue = amountValue;
	}
	public String getAmountExponent() {
		return AmountExponent;
	}
	public void setAmountExponent(String amountExponent) {
		AmountExponent = amountExponent;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getAddress1() {
		return Address1;
	}
	public void setAddress1(String address1) {
		Address1 = address1;
	}
	public String getAddress2() {
		return Address2;
	}
	public void setAddress2(String address2) {
		Address2 = address2;
	}
	public String getPostalCode() {
		return PostalCode;
	}
	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getStageRegion() {
		return StageRegion;
	}
	public void setStageRegion(String stageRegion) {
		StageRegion = stageRegion;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	public String getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}
	
	
	
	
}
