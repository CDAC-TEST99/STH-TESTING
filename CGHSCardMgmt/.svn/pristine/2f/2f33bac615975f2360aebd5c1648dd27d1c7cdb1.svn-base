package thirdpartyservices.apisetu.digilocker.client.resp;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="ResponseStatus">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>unsignedByte">
 *                 &lt;attribute name="Status" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" />
 *                 &lt;attribute name="ts" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *                 &lt;attribute name="txn" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DocDetails">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="IssuedTo">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Persons">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Person" maxOccurs="unbounded">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence minOccurs="0">
 *                                                 &lt;element name="Photo">
 *                                                   &lt;complexType>
 *                                                     &lt;simpleContent>
 *                                                       &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                                         &lt;attribute name="format" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                                       &lt;/extension>
 *                                                     &lt;/simpleContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                               &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="dob" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="gender" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="phone" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" />
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="URI" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="DocContent" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="DataContent" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
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
    "responseStatus",
    "docDetails"
})
@XmlRootElement(name = "PullURIResponse")
public class PullURIResponse {

    @XmlElement(name = "ResponseStatus", required = true)
    protected PullURIResponse.ResponseStatus responseStatus;
    @XmlElement(name = "DocDetails", required = true)
    protected PullURIResponse.DocDetails docDetails;

    /**
     * Gets the value of the responseStatus property.
     * 
     * @return
     *     possible object is
     *     {@link PullURIResponse.ResponseStatus }
     *     
     */
    public PullURIResponse.ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    /**
     * Sets the value of the responseStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link PullURIResponse.ResponseStatus }
     *     
     */
    public void setResponseStatus(PullURIResponse.ResponseStatus value) {
        this.responseStatus = value;
    }

    /**
     * Gets the value of the docDetails property.
     * 
     * @return
     *     possible object is
     *     {@link PullURIResponse.DocDetails }
     *     
     */
    public PullURIResponse.DocDetails getDocDetails() {
        return docDetails;
    }

    /**
     * Sets the value of the docDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link PullURIResponse.DocDetails }
     *     
     */
    public void setDocDetails(PullURIResponse.DocDetails value) {
        this.docDetails = value;
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
     *         &lt;element name="IssuedTo">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Persons">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Person" maxOccurs="unbounded">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence minOccurs="0">
     *                                       &lt;element name="Photo">
     *                                         &lt;complexType>
     *                                           &lt;simpleContent>
     *                                             &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                                               &lt;attribute name="format" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                             &lt;/extension>
     *                                           &lt;/simpleContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                     &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="dob" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="gender" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="phone" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" />
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="URI" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="DocContent" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="DataContent" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "issuedTo",
        "uri",
        "docContent",
        "dataContent"
    })
    public static class DocDetails {

        @XmlElement(name = "IssuedTo", required = true)
        protected PullURIResponse.DocDetails.IssuedTo issuedTo;
        @XmlElement(name = "URI", required = true)
        protected String uri;
        @XmlElement(name = "DocContent", required = true)
        protected String docContent;
        @XmlElement(name = "DataContent", required = true)
        protected String dataContent;

        /**
         * Gets the value of the issuedTo property.
         * 
         * @return
         *     possible object is
         *     {@link PullURIResponse.DocDetails.IssuedTo }
         *     
         */
        public PullURIResponse.DocDetails.IssuedTo getIssuedTo() {
            return issuedTo;
        }

        /**
         * Sets the value of the issuedTo property.
         * 
         * @param value
         *     allowed object is
         *     {@link PullURIResponse.DocDetails.IssuedTo }
         *     
         */
        public void setIssuedTo(PullURIResponse.DocDetails.IssuedTo value) {
            this.issuedTo = value;
        }

        /**
         * Gets the value of the uri property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getURI() {
            return uri;
        }

        /**
         * Sets the value of the uri property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setURI(String value) {
            this.uri = value;
        }

        /**
         * Gets the value of the docContent property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDocContent() {
            return docContent;
        }

        /**
         * Sets the value of the docContent property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDocContent(String value) {
            this.docContent = value;
        }

        /**
         * Gets the value of the dataContent property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDataContent() {
            return dataContent;
        }

        /**
         * Sets the value of the dataContent property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDataContent(String value) {
            this.dataContent = value;
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
         *         &lt;element name="Persons">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Person" maxOccurs="unbounded">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence minOccurs="0">
         *                             &lt;element name="Photo">
         *                               &lt;complexType>
         *                                 &lt;simpleContent>
         *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                                     &lt;attribute name="format" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                                   &lt;/extension>
         *                                 &lt;/simpleContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                           &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="dob" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="gender" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="phone" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" />
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
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
            "persons"
        })
        public static class IssuedTo {

            @XmlElement(name = "Persons", required = true)
            protected PullURIResponse.DocDetails.IssuedTo.Persons persons;

            /**
             * Gets the value of the persons property.
             * 
             * @return
             *     possible object is
             *     {@link PullURIResponse.DocDetails.IssuedTo.Persons }
             *     
             */
            public PullURIResponse.DocDetails.IssuedTo.Persons getPersons() {
                return persons;
            }

            /**
             * Sets the value of the persons property.
             * 
             * @param value
             *     allowed object is
             *     {@link PullURIResponse.DocDetails.IssuedTo.Persons }
             *     
             */
            public void setPersons(PullURIResponse.DocDetails.IssuedTo.Persons value) {
                this.persons = value;
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
             *         &lt;element name="Person" maxOccurs="unbounded">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence minOccurs="0">
             *                   &lt;element name="Photo">
             *                     &lt;complexType>
             *                       &lt;simpleContent>
             *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *                           &lt;attribute name="format" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                         &lt;/extension>
             *                       &lt;/simpleContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="dob" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="gender" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="phone" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" />
             *               &lt;/restriction>
             *             &lt;/complexContent>
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
                "person"
            })
            public static class Persons {

                @XmlElement(name = "Person", required = true)
                protected List<PullURIResponse.DocDetails.IssuedTo.Persons.Person> person;

                /**
                 * Gets the value of the person property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the person property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getPerson().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link PullURIResponse.DocDetails.IssuedTo.Persons.Person }
                 * 
                 * 
                 */
                public List<PullURIResponse.DocDetails.IssuedTo.Persons.Person> getPerson() {
                    if (person == null) {
                        person = new ArrayList<PullURIResponse.DocDetails.IssuedTo.Persons.Person>();
                    }
                    return this.person;
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
                 *       &lt;sequence minOccurs="0">
                 *         &lt;element name="Photo">
                 *           &lt;complexType>
                 *             &lt;simpleContent>
                 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
                 *                 &lt;attribute name="format" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *               &lt;/extension>
                 *             &lt;/simpleContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="dob" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="gender" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="phone" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" />
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "photo"
                })
                public static class Person {

                    @XmlElement(name = "Photo")
                    protected PullURIResponse.DocDetails.IssuedTo.Persons.Person.Photo photo;
                    @XmlAttribute(name = "name", required = true)
                    protected String name;
                    @XmlAttribute(name = "dob", required = true)
                    protected String dob;
                    @XmlAttribute(name = "gender", required = true)
                    protected String gender;
                    @XmlAttribute(name = "phone", required = true)
                    @XmlSchemaType(name = "unsignedLong")
                    protected String phone;

                    /**
                     * Gets the value of the photo property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link PullURIResponse.DocDetails.IssuedTo.Persons.Person.Photo }
                     *     
                     */
                    public PullURIResponse.DocDetails.IssuedTo.Persons.Person.Photo getPhoto() {
                        return photo;
                    }

                    /**
                     * Sets the value of the photo property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link PullURIResponse.DocDetails.IssuedTo.Persons.Person.Photo }
                     *     
                     */
                    public void setPhoto(PullURIResponse.DocDetails.IssuedTo.Persons.Person.Photo value) {
                        this.photo = value;
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
                     *     {@link BigInteger }
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


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;simpleContent>
                     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
                     *       &lt;attribute name="format" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
                    public static class Photo {

                        @XmlValue
                        protected String value;
                        @XmlAttribute(name = "format", required = true)
                        protected String format;

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
                         * Gets the value of the format property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getFormat() {
                            return format;
                        }

                        /**
                         * Sets the value of the format property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setFormat(String value) {
                            this.format = value;
                        }

                    }

                }

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
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>unsignedByte">
     *       &lt;attribute name="Status" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" />
     *       &lt;attribute name="ts" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
     *       &lt;attribute name="txn" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
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
    public static class ResponseStatus {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "Status", required = true)
        protected String status;
        @XmlAttribute(name = "ts", required = true)
        protected String ts;
        @XmlAttribute(name = "txn", required = true)
        protected String txn;

        /**
         * Gets the value of the value property.
         * 
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the status property.
         * 
         */
        public String getStatus() {
            return status;
        }

        /**
         * Sets the value of the status property.
         * 
         */
        public void setStatus(String value) {
            this.status = value;
        }

        /**
         * Gets the value of the ts property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public String getTs() {
            return ts;
        }

        /**
         * Sets the value of the ts property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTs(String value) {
            this.ts = value;
        }

        /**
         * Gets the value of the txn property.
         * 
         */
        public String getTxn() {
            return txn;
        }

        /**
         * Sets the value of the txn property.
         * 
         */
        public void setTxn(String value) {
            this.txn = value;
        }

    }

}
