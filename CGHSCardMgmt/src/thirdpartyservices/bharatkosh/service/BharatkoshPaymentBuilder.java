package thirdpartyservices.bharatkosh.service;

import java.math.BigDecimal;
import java.math.BigInteger;

import thirdpartyservices.bharatkosh.client.req.Address;
import thirdpartyservices.bharatkosh.client.req.Amount;
import thirdpartyservices.bharatkosh.client.req.BharatKoshPayment;
import thirdpartyservices.bharatkosh.client.req.BillingAddress;
import thirdpartyservices.bharatkosh.client.req.CartDetails;
import thirdpartyservices.bharatkosh.client.req.Include;
import thirdpartyservices.bharatkosh.client.req.Order;
import thirdpartyservices.bharatkosh.client.req.OrderBatch;
import thirdpartyservices.bharatkosh.client.req.PaymentMethodMask;
import thirdpartyservices.bharatkosh.client.req.Remarks;
import thirdpartyservices.bharatkosh.client.req.ShippingAddress;
import thirdpartyservices.bharatkosh.client.req.Shopper;
import thirdpartyservices.bharatkosh.client.req.StatementNarrative;
import thirdpartyservices.bharatkosh.client.req.Submit;

public class BharatkoshPaymentBuilder {
	
	private CGHSBharatkoshVO cghsBharatKoshVO;
	
	public BharatkoshPaymentBuilder(CGHSBharatkoshVO cghsBharatKoshVO) {
		this.cghsBharatKoshVO = cghsBharatKoshVO;
	}
	
	
	public BharatKoshPayment build(String paymentMaskCode) {
		BharatKoshPayment payment = new BharatKoshPayment();
		payment.setVersion(cghsBharatKoshVO.getVersion());
		payment.setDepartmentCode(cghsBharatKoshVO.getDepartmentCode());
		
		payment.setSubmit(new Submit());
		payment.getSubmit().setOrderBatch(new OrderBatch());
		payment.getSubmit().getOrderBatch().setMerchantBatchCode(new String(cghsBharatKoshVO.getMerchantBatchCode()));
		payment.getSubmit().getOrderBatch().setTransactions(new BigInteger(cghsBharatKoshVO.getTransactions()));
		payment.getSubmit().getOrderBatch().setTotalAmount(new BigDecimal(cghsBharatKoshVO.getTotalAmount()));
		
		payment.getSubmit().getOrderBatch().setOrder(new Order());
		payment.getSubmit().getOrderBatch().getOrder().setInstallationId(new BigInteger(cghsBharatKoshVO.getInstallationId()));
		payment.getSubmit().getOrderBatch().getOrder().setOrderCode(new String(cghsBharatKoshVO.getOrderCode()));
		
		payment.getSubmit().getOrderBatch().getOrder().setCartDetails(new CartDetails());
		payment.getSubmit().getOrderBatch().getOrder().getCartDetails().setDescription("");
		
		payment.getSubmit().getOrderBatch().getOrder().getCartDetails().setAmount(new Amount());
		payment.getSubmit().getOrderBatch().getOrder().getCartDetails().getAmount().setCurrencyCode(cghsBharatKoshVO.getCurrencyCode());
		payment.getSubmit().getOrderBatch().getOrder().getCartDetails().getAmount().setExponent(new BigInteger(cghsBharatKoshVO.getAmountExponent()));
		payment.getSubmit().getOrderBatch().getOrder().getCartDetails().getAmount().setValue(new BigInteger(cghsBharatKoshVO.getAmountValue()));
		
		payment.getSubmit().getOrderBatch().getOrder().getCartDetails().setDescription(cghsBharatKoshVO.getDescription());
		payment.getSubmit().getOrderBatch().getOrder().getCartDetails().setOrderContent(new BigInteger(cghsBharatKoshVO.getOrderContent()));
		payment.getSubmit().getOrderBatch().getOrder().getCartDetails().setPaymentTypeId(cghsBharatKoshVO.getPaymentTypeId());
		payment.getSubmit().getOrderBatch().getOrder().getCartDetails().setPAOCode(cghsBharatKoshVO.getPAOCode());
		payment.getSubmit().getOrderBatch().getOrder().getCartDetails().setDDOCode(cghsBharatKoshVO.getDDOCode());
		
		payment.getSubmit().getOrderBatch().getOrder().setPaymentMethodMask(new PaymentMethodMask());
		payment.getSubmit().getOrderBatch().getOrder().getPaymentMethodMask().setInclude(new Include());
		payment.getSubmit().getOrderBatch().getOrder().getPaymentMethodMask().getInclude().setCode(paymentMaskCode);
		
		payment.getSubmit().getOrderBatch().getOrder().setShopper(new Shopper());
		payment.getSubmit().getOrderBatch().getOrder().getShopper().setShopperEmailAddress(cghsBharatKoshVO.getEmailId());

		Address address = new Address();
		address.setFirstName(cghsBharatKoshVO.getFirstName());
		address.setLastName(cghsBharatKoshVO.getLastName());
		address.setAddress1(cghsBharatKoshVO.getAddress1());
		address.setAddress2(cghsBharatKoshVO.getAddress2());
		address.setCity(cghsBharatKoshVO.getCity());
		address.setStateRegion(cghsBharatKoshVO.getStageRegion());
		address.setState(cghsBharatKoshVO.getState());
		address.setPostalCode(cghsBharatKoshVO.getPostalCode());
		address.setCountryCode(cghsBharatKoshVO.getCountryCode());
		address.setMobileNumber(new BigInteger(cghsBharatKoshVO.getMobileNumber()));

		payment.getSubmit().getOrderBatch().getOrder().setShippingAddress(new ShippingAddress());		
		payment.getSubmit().getOrderBatch().getOrder().getShippingAddress().getContent().add(address);
		
		payment.getSubmit().getOrderBatch().getOrder().setBillingAddress(new BillingAddress());
		payment.getSubmit().getOrderBatch().getOrder().getBillingAddress().setAddress(address);
		
		payment.getSubmit().getOrderBatch().getOrder().setStatementNarrative(new StatementNarrative());
		payment.getSubmit().getOrderBatch().getOrder().setRemarks(new Remarks());
		
		
		
		return payment;
	}

}
