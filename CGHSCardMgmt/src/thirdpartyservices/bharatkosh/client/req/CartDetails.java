
package thirdpartyservices.bharatkosh.client.req;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;


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
 *         &lt;element ref="{}Description"/>
 *         &lt;element ref="{}Amount"/>
 *         &lt;element ref="{}OrderContent"/>
 *         &lt;element ref="{}PaymentTypeId"/>
 *         &lt;element ref="{}PAOCode"/>
 *         &lt;element ref="{}DDOCode"/>
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
    "description",
    "amount",
    "orderContent",
    "paymentTypeId",
    "paoCode",
    "ddoCode"
})
@XmlRootElement(name = "CartDetails")
@Data
public class CartDetails {

    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "Amount", required = true)
    protected Amount amount;
    @XmlElement(name = "OrderContent", required = true)
    protected BigInteger orderContent;
    @XmlElement(name = "PaymentTypeId", required = true)
    protected String paymentTypeId;
    @XmlElement(name = "PAOCode", required = true)
    protected String paoCode;
    @XmlElement(name = "DDOCode", required = true)
    protected String ddoCode;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link Amount }
     *     
     */
    public Amount getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Amount }
     *     
     */
    public void setAmount(Amount value) {
        this.amount = value;
    }

    /**
     * Gets the value of the orderContent property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOrderContent() {
        return orderContent;
    }

    /**
     * Sets the value of the orderContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOrderContent(BigInteger value) {
        this.orderContent = value;
    }

    /**
     * Gets the value of the paymentTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentTypeId() {
        return paymentTypeId;
    }

    /**
     * Sets the value of the paymentTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentTypeId(String value) {
        this.paymentTypeId = value;
    }

    /**
     * Gets the value of the paoCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAOCode() {
        return paoCode;
    }

    /**
     * Sets the value of the paoCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAOCode(String value) {
        this.paoCode = value;
    }

    /**
     * Gets the value of the ddoCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDDOCode() {
        return ddoCode;
    }

    /**
     * Sets the value of the ddoCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDDOCode(String value) {
        this.ddoCode = value;
    }

}
