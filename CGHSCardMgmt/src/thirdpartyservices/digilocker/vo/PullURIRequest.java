package thirdpartyservices.digilocker.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PullURIRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class PullURIRequest {

    @XmlAttribute(name = "ver")
    private String version;

    @XmlAttribute(name = "ts")
    private String timestamp;

    @XmlAttribute(name = "txn")
    private String transactionId;

    @XmlAttribute(name = "orgId")
    private String organizationId;

    @XmlAttribute(name = "keyhash")
    private String keyHash;

    @XmlAttribute(name = "format")
    private String format;

    @XmlElement(name = "DocDetails")
    private DocDetails docDetails;

    // Getters and Setters
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getKeyHash() {
        return keyHash;
    }

    public void setKeyHash(String keyHash) {
        this.keyHash = keyHash;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public DocDetails getDocDetails() {
        return docDetails;
    }

    public void setDocDetails(DocDetails docDetails) {
        this.docDetails = docDetails;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class DocDetails {

        @XmlElement(name = "DocType")
        private String docType;

        @XmlElement(name = "DigiLockerId")
        private String digiLockerId;

        @XmlElement(name = "benId")
        private String beneficiaryId;

        @XmlElement(name = "DOB")
        private String dateOfBirth;

        // Getters and Setters
        public String getDocType() {
            return docType;
        }

        public void setDocType(String docType) {
            this.docType = docType;
        }

        public String getDigiLockerId() {
            return digiLockerId;
        }

        public void setDigiLockerId(String digiLockerId) {
            this.digiLockerId = digiLockerId;
        }

        public String getBeneficiaryId() {
            return beneficiaryId;
        }

        public void setBeneficiaryId(String beneficiaryId) {
            this.beneficiaryId = beneficiaryId;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }
    }
}
