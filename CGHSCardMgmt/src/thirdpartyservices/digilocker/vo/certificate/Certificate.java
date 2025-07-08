package thirdpartyservices.digilocker.vo.certificate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Certificate")
@XmlAccessorType(XmlAccessType.FIELD)
public class Certificate {

    @XmlAttribute
    private String language;

    @XmlAttribute
    private String name;

    @XmlAttribute
    private String type;

    @XmlAttribute
    private String number;

    @XmlAttribute
    private String prevNumber;

    @XmlAttribute
    private String expiryDate;

    @XmlAttribute
    private String issuedAt;

    @XmlAttribute
    private String issueDate;

    @XmlAttribute
    private String status;

    @XmlElement(name = "IssuedBy")
    private IssuedBy issuedBy;

    @XmlElement(name = "IssuedTo")
    private IssuedTo issuedTo;

    @XmlElement(name = "CertificateData")
    private CertificateData certificateData;

    @XmlElement(name = "Signature")
    private Signature signature;
    
    

    // Getters and setters omitted for brevity

    public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPrevNumber() {
		return prevNumber;
	}

	public void setPrevNumber(String prevNumber) {
		this.prevNumber = prevNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getIssuedAt() {
		return issuedAt;
	}

	public void setIssuedAt(String issuedAt) {
		this.issuedAt = issuedAt;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public IssuedBy getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(IssuedBy issuedBy) {
		this.issuedBy = issuedBy;
	}

	public IssuedTo getIssuedTo() {
		return issuedTo;
	}

	public void setIssuedTo(IssuedTo issuedTo) {
		this.issuedTo = issuedTo;
	}

	public CertificateData getCertificateData() {
		return certificateData;
	}

	public void setCertificateData(CertificateData certificateData) {
		this.certificateData = certificateData;
	}

	public Signature getSignature() {
		return signature;
	}

	public void setSignature(Signature signature) {
		this.signature = signature;
	}

	
    
   

       
   
   
      
}
