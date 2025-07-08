package thirdpartyservices.apisetu.digilocker.client.xmldata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IssuedBy">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Organization">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="tin" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="uid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Address">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="line1" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="line2" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="house" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="landmark" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="locality" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="vtc" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="district" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="pin" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="state" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="country" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="IssuedTo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Person">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="uid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="title" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="dob" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="age" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="swd" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="swdIndicator" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="motherName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="maritalStatus" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="relationWithHof" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="disabilityStatus" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="category" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="religion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="email" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="gender" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="phone" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Address">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="line1" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="line2" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="house" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="landmark" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="locality" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="vtc" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="district" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="pin" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="state" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="country" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CertificateData">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CghsCard">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="number" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="place" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="date" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Signature" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="language" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="number" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="prevNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="expiryDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="validFromDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="issuedAt" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="issueDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="status" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "issuedBy",
    "issuedTo",
    "certificateData",
    "signature"
})
@XmlRootElement(name = "Certificate")
public class Certificate {

    @XmlElement(name = "IssuedBy", required = true)
    protected Certificate.IssuedBy issuedBy;
    @XmlElement(name = "IssuedTo", required = true)
    protected Certificate.IssuedTo issuedTo;
    @XmlElement(name = "CertificateData", required = true)
    protected Certificate.CertificateData certificateData;
    @XmlElement(name = "Signature", required = true)
    protected String signature;
    @XmlAttribute(name = "language")
    protected String language;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "type")
    protected String type;
    @XmlAttribute(name = "number")
    protected String number;
    @XmlAttribute(name = "prevNumber")
    protected String prevNumber;
    @XmlAttribute(name = "expiryDate")
    protected String expiryDate;
    @XmlAttribute(name = "validFromDate")
    protected String validFromDate;
    @XmlAttribute(name = "issuedAt")
    protected String issuedAt;
    @XmlAttribute(name = "issueDate")
    protected String issueDate;
    @XmlAttribute(name = "status")
    protected String status;

    /**
     * Gets the value of the issuedBy property.
     * 
     * @return
     *     possible object is
     *     {@link Certificate.IssuedBy }
     *     
     */
    public Certificate.IssuedBy getIssuedBy() {
        return issuedBy;
    }

    /**
     * Sets the value of the issuedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Certificate.IssuedBy }
     *     
     */
    public void setIssuedBy(Certificate.IssuedBy value) {
        this.issuedBy = value;
    }

    /**
     * Gets the value of the issuedTo property.
     * 
     * @return
     *     possible object is
     *     {@link Certificate.IssuedTo }
     *     
     */
    public Certificate.IssuedTo getIssuedTo() {
        return issuedTo;
    }

    /**
     * Sets the value of the issuedTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Certificate.IssuedTo }
     *     
     */
    public void setIssuedTo(Certificate.IssuedTo value) {
        this.issuedTo = value;
    }

    /**
     * Gets the value of the certificateData property.
     * 
     * @return
     *     possible object is
     *     {@link Certificate.CertificateData }
     *     
     */
    public Certificate.CertificateData getCertificateData() {
        return certificateData;
    }

    /**
     * Sets the value of the certificateData property.
     * 
     * @param value
     *     allowed object is
     *     {@link Certificate.CertificateData }
     *     
     */
    public void setCertificateData(Certificate.CertificateData value) {
        this.certificateData = value;
    }

    /**
     * Gets the value of the signature property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignature(String value) {
        this.signature = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the prevNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrevNumber() {
        return prevNumber;
    }

    /**
     * Sets the value of the prevNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrevNumber(String value) {
        this.prevNumber = value;
    }

    /**
     * Gets the value of the expiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the value of the expiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiryDate(String value) {
        this.expiryDate = value;
    }

    /**
     * Gets the value of the validFromDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidFromDate() {
        return validFromDate;
    }

    /**
     * Sets the value of the validFromDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidFromDate(String value) {
        this.validFromDate = value;
    }

    /**
     * Gets the value of the issuedAt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuedAt() {
        return issuedAt;
    }

    /**
     * Sets the value of the issuedAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuedAt(String value) {
        this.issuedAt = value;
    }

    /**
     * Gets the value of the issueDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssueDate() {
        return issueDate;
    }

    /**
     * Sets the value of the issueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssueDate(String value) {
        this.issueDate = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="CghsCard">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="number" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="place" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="date" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "cghsCard"
    })
    public static class CertificateData {

        @XmlElement(name = "CghsCard", required = true)
        protected Certificate.CertificateData.CghsCard cghsCard;

        /**
         * Gets the value of the cghsCard property.
         * 
         * @return
         *     possible object is
         *     {@link Certificate.CertificateData.CghsCard }
         *     
         */
        public Certificate.CertificateData.CghsCard getCghsCard() {
            return cghsCard;
        }

        /**
         * Sets the value of the cghsCard property.
         * 
         * @param value
         *     allowed object is
         *     {@link Certificate.CertificateData.CghsCard }
         *     
         */
        public void setCghsCard(Certificate.CertificateData.CghsCard value) {
            this.cghsCard = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="number" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="place" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="date" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class CghsCard {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "name")
            protected String name;
            @XmlAttribute(name = "number")
            protected String number;
            @XmlAttribute(name = "place")
            protected String place;
            @XmlAttribute(name = "date")
            protected String date;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the number property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNumber() {
                return number;
            }

            /**
             * Sets the value of the number property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNumber(String value) {
                this.number = value;
            }

            /**
             * Gets the value of the place property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPlace() {
                return place;
            }

            /**
             * Sets the value of the place property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPlace(String value) {
                this.place = value;
            }

            /**
             * Gets the value of the date property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDate() {
                return date;
            }

            /**
             * Sets the value of the date property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDate(String value) {
                this.date = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Organization">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="tin" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="uid" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Address">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="line1" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="line2" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="house" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="landmark" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="locality" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="vtc" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="district" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="pin" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="state" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="country" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "organization",
        "address"
    })
    public static class IssuedBy {

        @XmlElement(name = "Organization", required = true)
        protected Certificate.IssuedBy.Organization organization;
        @XmlElement(name = "Address", required = true)
        protected Certificate.IssuedBy.Address address;

        /**
         * Gets the value of the organization property.
         * 
         * @return
         *     possible object is
         *     {@link Certificate.IssuedBy.Organization }
         *     
         */
        public Certificate.IssuedBy.Organization getOrganization() {
            return organization;
        }

        /**
         * Sets the value of the organization property.
         * 
         * @param value
         *     allowed object is
         *     {@link Certificate.IssuedBy.Organization }
         *     
         */
        public void setOrganization(Certificate.IssuedBy.Organization value) {
            this.organization = value;
        }

        /**
         * Gets the value of the address property.
         * 
         * @return
         *     possible object is
         *     {@link Certificate.IssuedBy.Address }
         *     
         */
        public Certificate.IssuedBy.Address getAddress() {
            return address;
        }

        /**
         * Sets the value of the address property.
         * 
         * @param value
         *     allowed object is
         *     {@link Certificate.IssuedBy.Address }
         *     
         */
        public void setAddress(Certificate.IssuedBy.Address value) {
            this.address = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="line1" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="line2" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="house" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="landmark" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="locality" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="vtc" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="district" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="pin" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="state" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="country" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Address {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "type")
            protected String type;
            @XmlAttribute(name = "line1")
            protected String line1;
            @XmlAttribute(name = "line2")
            protected String line2;
            @XmlAttribute(name = "house")
            protected String house;
            @XmlAttribute(name = "landmark")
            protected String landmark;
            @XmlAttribute(name = "locality")
            protected String locality;
            @XmlAttribute(name = "vtc")
            protected String vtc;
            @XmlAttribute(name = "district")
            protected String district;
            @XmlAttribute(name = "pin")
            protected String pin;
            @XmlAttribute(name = "state")
            protected String state;
            @XmlAttribute(name = "country")
            protected String country;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the type property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getType() {
                return type;
            }

            /**
             * Sets the value of the type property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setType(String value) {
                this.type = value;
            }

            /**
             * Gets the value of the line1 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLine1() {
                return line1;
            }

            /**
             * Sets the value of the line1 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLine1(String value) {
                this.line1 = value;
            }

            /**
             * Gets the value of the line2 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLine2() {
                return line2;
            }

            /**
             * Sets the value of the line2 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLine2(String value) {
                this.line2 = value;
            }

            /**
             * Gets the value of the house property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHouse() {
                return house;
            }

            /**
             * Sets the value of the house property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHouse(String value) {
                this.house = value;
            }

            /**
             * Gets the value of the landmark property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLandmark() {
                return landmark;
            }

            /**
             * Sets the value of the landmark property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLandmark(String value) {
                this.landmark = value;
            }

            /**
             * Gets the value of the locality property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLocality() {
                return locality;
            }

            /**
             * Sets the value of the locality property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLocality(String value) {
                this.locality = value;
            }

            /**
             * Gets the value of the vtc property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVtc() {
                return vtc;
            }

            /**
             * Sets the value of the vtc property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVtc(String value) {
                this.vtc = value;
            }

            /**
             * Gets the value of the district property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDistrict() {
                return district;
            }

            /**
             * Sets the value of the district property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDistrict(String value) {
                this.district = value;
            }

            /**
             * Gets the value of the pin property.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public String getPin() {
                return pin;
            }

            /**
             * Sets the value of the pin property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPin(String value) {
                this.pin = value;
            }

            /**
             * Gets the value of the state property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getState() {
                return state;
            }

            /**
             * Sets the value of the state property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setState(String value) {
                this.state = value;
            }

            /**
             * Gets the value of the country property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCountry() {
                return country;
            }

            /**
             * Sets the value of the country property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCountry(String value) {
                this.country = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="tin" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="uid" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Organization {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "name")
            protected String name;
            @XmlAttribute(name = "code")
            protected String code;
            @XmlAttribute(name = "tin")
            protected String tin;
            @XmlAttribute(name = "uid")
            protected String uid;
            @XmlAttribute(name = "type")
            protected String type;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the code property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCode() {
                return code;
            }

            /**
             * Sets the value of the code property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCode(String value) {
                this.code = value;
            }

            /**
             * Gets the value of the tin property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTin() {
                return tin;
            }

            /**
             * Sets the value of the tin property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTin(String value) {
                this.tin = value;
            }

            /**
             * Gets the value of the uid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUid() {
                return uid;
            }

            /**
             * Sets the value of the uid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUid(String value) {
                this.uid = value;
            }

            /**
             * Gets the value of the type property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getType() {
                return type;
            }

            /**
             * Sets the value of the type property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setType(String value) {
                this.type = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Person">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="uid" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="title" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="dob" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="age" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="swd" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="swdIndicator" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="motherName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="maritalStatus" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="relationWithHof" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="disabilityStatus" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="category" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="religion" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="email" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="gender" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="phone" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Address">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="line1" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="line2" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="house" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="landmark" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="locality" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="vtc" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="district" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="pin" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="state" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="country" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "person",
        "address"
    })
    public static class IssuedTo {

        @XmlElement(name = "Person", required = true)
        protected Certificate.IssuedTo.Person person;
        @XmlElement(name = "Address", required = true)
        protected Certificate.IssuedTo.Address address;

        /**
         * Gets the value of the person property.
         * 
         * @return
         *     possible object is
         *     {@link Certificate.IssuedTo.Person }
         *     
         */
        public Certificate.IssuedTo.Person getPerson() {
            return person;
        }

        /**
         * Sets the value of the person property.
         * 
         * @param value
         *     allowed object is
         *     {@link Certificate.IssuedTo.Person }
         *     
         */
        public void setPerson(Certificate.IssuedTo.Person value) {
            this.person = value;
        }

        /**
         * Gets the value of the address property.
         * 
         * @return
         *     possible object is
         *     {@link Certificate.IssuedTo.Address }
         *     
         */
        public Certificate.IssuedTo.Address getAddress() {
            return address;
        }

        /**
         * Sets the value of the address property.
         * 
         * @param value
         *     allowed object is
         *     {@link Certificate.IssuedTo.Address }
         *     
         */
        public void setAddress(Certificate.IssuedTo.Address value) {
            this.address = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="line1" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="line2" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="house" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="landmark" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="locality" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="vtc" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="district" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="pin" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="state" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="country" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Address {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "type")
            protected String type;
            @XmlAttribute(name = "line1")
            protected String line1;
            @XmlAttribute(name = "line2")
            protected String line2;
            @XmlAttribute(name = "house")
            protected String house;
            @XmlAttribute(name = "landmark")
            protected String landmark;
            @XmlAttribute(name = "locality")
            protected String locality;
            @XmlAttribute(name = "vtc")
            protected String vtc;
            @XmlAttribute(name = "district")
            protected String district;
            @XmlAttribute(name = "pin")
            protected String pin;
            @XmlAttribute(name = "state")
            protected String state;
            @XmlAttribute(name = "country")
            protected String country;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the type property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getType() {
                return type;
            }

            /**
             * Sets the value of the type property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setType(String value) {
                this.type = value;
            }

            /**
             * Gets the value of the line1 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLine1() {
                return line1;
            }

            /**
             * Sets the value of the line1 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLine1(String value) {
                this.line1 = value;
            }

            /**
             * Gets the value of the line2 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLine2() {
                return line2;
            }

            /**
             * Sets the value of the line2 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLine2(String value) {
                this.line2 = value;
            }

            /**
             * Gets the value of the house property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHouse() {
                return house;
            }

            /**
             * Sets the value of the house property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHouse(String value) {
                this.house = value;
            }

            /**
             * Gets the value of the landmark property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLandmark() {
                return landmark;
            }

            /**
             * Sets the value of the landmark property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLandmark(String value) {
                this.landmark = value;
            }

            /**
             * Gets the value of the locality property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLocality() {
                return locality;
            }

            /**
             * Sets the value of the locality property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLocality(String value) {
                this.locality = value;
            }

            /**
             * Gets the value of the vtc property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVtc() {
                return vtc;
            }

            /**
             * Sets the value of the vtc property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVtc(String value) {
                this.vtc = value;
            }

            /**
             * Gets the value of the district property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDistrict() {
                return district;
            }

            /**
             * Sets the value of the district property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDistrict(String value) {
                this.district = value;
            }

            /**
             * Gets the value of the pin property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPin() {
                return pin;
            }

            /**
             * Sets the value of the pin property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPin(String value) {
                this.pin = value;
            }

            /**
             * Gets the value of the state property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getState() {
                return state;
            }

            /**
             * Sets the value of the state property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setState(String value) {
                this.state = value;
            }

            /**
             * Gets the value of the country property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCountry() {
                return country;
            }

            /**
             * Sets the value of the country property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCountry(String value) {
                this.country = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="uid" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="title" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="dob" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="age" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="swd" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="swdIndicator" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="motherName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="maritalStatus" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="relationWithHof" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="disabilityStatus" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="category" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="religion" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="email" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="gender" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="phone" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Person {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "uid")
            protected String uid;
            @XmlAttribute(name = "title")
            protected String title;
            @XmlAttribute(name = "name")
            protected String name;
            @XmlAttribute(name = "dob")
            protected String dob;
            @XmlAttribute(name = "age")
            protected String age;
            @XmlAttribute(name = "swd")
            protected String swd;
            @XmlAttribute(name = "swdIndicator")
            protected String swdIndicator;
            @XmlAttribute(name = "motherName")
            protected String motherName;
            @XmlAttribute(name = "maritalStatus")
            protected String maritalStatus;
            @XmlAttribute(name = "relationWithHof")
            protected String relationWithHof;
            @XmlAttribute(name = "disabilityStatus")
            protected String disabilityStatus;
            @XmlAttribute(name = "category")
            protected String category;
            @XmlAttribute(name = "religion")
            protected String religion;
            @XmlAttribute(name = "email")
            protected String email;
            @XmlAttribute(name = "gender")
            protected String gender;
            @XmlAttribute(name = "phone")
            protected String phone;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the uid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUid() {
                return uid;
            }

            /**
             * Sets the value of the uid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUid(String value) {
                this.uid = value;
            }

            /**
             * Gets the value of the title property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTitle() {
                return title;
            }

            /**
             * Sets the value of the title property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTitle(String value) {
                this.title = value;
            }

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the dob property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDob() {
                return dob;
            }

            /**
             * Sets the value of the dob property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDob(String value) {
                this.dob = value;
            }

            /**
             * Gets the value of the age property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAge() {
                return age;
            }

            /**
             * Sets the value of the age property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAge(String value) {
                this.age = value;
            }

            /**
             * Gets the value of the swd property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSwd() {
                return swd;
            }

            /**
             * Sets the value of the swd property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSwd(String value) {
                this.swd = value;
            }

            /**
             * Gets the value of the swdIndicator property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSwdIndicator() {
                return swdIndicator;
            }

            /**
             * Sets the value of the swdIndicator property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSwdIndicator(String value) {
                this.swdIndicator = value;
            }

            /**
             * Gets the value of the motherName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMotherName() {
                return motherName;
            }

            /**
             * Sets the value of the motherName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMotherName(String value) {
                this.motherName = value;
            }

            /**
             * Gets the value of the maritalStatus property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMaritalStatus() {
                return maritalStatus;
            }

            /**
             * Sets the value of the maritalStatus property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMaritalStatus(String value) {
                this.maritalStatus = value;
            }

            /**
             * Gets the value of the relationWithHof property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRelationWithHof() {
                return relationWithHof;
            }

            /**
             * Sets the value of the relationWithHof property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRelationWithHof(String value) {
                this.relationWithHof = value;
            }

            /**
             * Gets the value of the disabilityStatus property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDisabilityStatus() {
                return disabilityStatus;
            }

            /**
             * Sets the value of the disabilityStatus property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDisabilityStatus(String value) {
                this.disabilityStatus = value;
            }

            /**
             * Gets the value of the category property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCategory() {
                return category;
            }

            /**
             * Sets the value of the category property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCategory(String value) {
                this.category = value;
            }

            /**
             * Gets the value of the religion property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getReligion() {
                return religion;
            }

            /**
             * Sets the value of the religion property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setReligion(String value) {
                this.religion = value;
            }

            /**
             * Gets the value of the email property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEmail() {
                return email;
            }

            /**
             * Sets the value of the email property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEmail(String value) {
                this.email = value;
            }

            /**
             * Gets the value of the gender property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGender() {
                return gender;
            }

            /**
             * Sets the value of the gender property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGender(String value) {
                this.gender = value;
            }

            /**
             * Gets the value of the phone property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPhone() {
                return phone;
            }

            /**
             * Sets the value of the phone property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPhone(String value) {
                this.phone = value;
            }

        }

    }

}
