
package thirdpartyservices.bharatkosh.client.req;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element ref="{}CartDetails"/>
 *         &lt;element ref="{}PaymentMethodMask"/>
 *         &lt;element ref="{}Shopper"/>
 *         &lt;element ref="{}ShippingAddress"/>
 *         &lt;element ref="{}BillingAddress"/>
 *         &lt;element ref="{}StatementNarrative"/>
 *         &lt;element ref="{}Remarks"/>
 *       &lt;/sequence>
 *       &lt;attribute name="InstallationId" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="OrderCode" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cartDetails",
    "paymentMethodMask",
    "shopper",
    "shippingAddress",
    "billingAddress",
    "statementNarrative",
    "remarks"
})
@XmlRootElement(name = "Order")
@Data
public class Order {

    @XmlElement(name = "CartDetails", required = true)
    protected CartDetails cartDetails;
    @XmlElement(name = "PaymentMethodMask", required = true)
    protected PaymentMethodMask paymentMethodMask;
    @XmlElement(name = "Shopper", required = true)
    protected Shopper shopper;
    @XmlElement(name = "ShippingAddress", required = true)
    protected ShippingAddress shippingAddress;
    @XmlElement(name = "BillingAddress", required = true)
    protected BillingAddress billingAddress;
    @XmlElement(name = "StatementNarrative", required = true)
    protected StatementNarrative statementNarrative;
    @XmlElement(name = "Remarks", required = true)
    protected Remarks remarks;
    @XmlAttribute(name = "InstallationId", required = true)
    protected BigInteger installationId;
    @XmlAttribute(name = "OrderCode", required = true)
    protected String orderCode;

    /**
     * Gets the value of the cartDetails property.
     * 
     * @return
     *     possible object is
     *     {@link CartDetails }
     *     
     */
    public CartDetails getCartDetails() {
        return cartDetails;
    }

    /**
     * Sets the value of the cartDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link CartDetails }
     *     
     */
    public void setCartDetails(CartDetails value) {
        this.cartDetails = value;
    }

    /**
     * Gets the value of the paymentMethodMask property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentMethodMask }
     *     
     */
    public PaymentMethodMask getPaymentMethodMask() {
        return paymentMethodMask;
    }

    /**
     * Sets the value of the paymentMethodMask property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMethodMask }
     *     
     */
    public void setPaymentMethodMask(PaymentMethodMask value) {
        this.paymentMethodMask = value;
    }

    /**
     * Gets the value of the shopper property.
     * 
     * @return
     *     possible object is
     *     {@link Shopper }
     *     
     */
    public Shopper getShopper() {
        return shopper;
    }

    /**
     * Sets the value of the shopper property.
     * 
     * @param value
     *     allowed object is
     *     {@link Shopper }
     *     
     */
    public void setShopper(Shopper value) {
        this.shopper = value;
    }

    /**
     * Gets the value of the shippingAddress property.
     * 
     * @return
     *     possible object is
     *     {@link ShippingAddress }
     *     
     */
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Sets the value of the shippingAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingAddress }
     *     
     */
    public void setShippingAddress(ShippingAddress value) {
        this.shippingAddress = value;
    }

    /**
     * Gets the value of the billingAddress property.
     * 
     * @return
     *     possible object is
     *     {@link BillingAddress }
     *     
     */
    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    /**
     * Sets the value of the billingAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link BillingAddress }
     *     
     */
    public void setBillingAddress(BillingAddress value) {
        this.billingAddress = value;
    }

    /**
     * Gets the value of the statementNarrative property.
     * 
     * @return
     *     possible object is
     *     {@link StatementNarrative }
     *     
     */
    public StatementNarrative getStatementNarrative() {
        return statementNarrative;
    }

    /**
     * Sets the value of the statementNarrative property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatementNarrative }
     *     
     */
    public void setStatementNarrative(StatementNarrative value) {
        this.statementNarrative = value;
    }

    /**
     * Gets the value of the remarks property.
     * 
     * @return
     *     possible object is
     *     {@link Remarks }
     *     
     */
    public Remarks getRemarks() {
        return remarks;
    }

    /**
     * Sets the value of the remarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Remarks }
     *     
     */
    public void setRemarks(Remarks value) {
        this.remarks = value;
    }

    /**
     * Gets the value of the installationId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getInstallationId() {
        return installationId;
    }

    /**
     * Sets the value of the installationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setInstallationId(BigInteger value) {
        this.installationId = value;
    }

    /**
     * Gets the value of the orderCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * Sets the value of the orderCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderCode(String value) {
        this.orderCode = value;
    }

}
