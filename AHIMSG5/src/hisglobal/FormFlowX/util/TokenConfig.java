
package hisglobal.FormFlowX.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



// TODO: Auto-generated Javadoc
/**
 * The Class TokenConfig.
 */
public class TokenConfig  {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts.action.Action#generateToken(javax.servlet.http.
	 * HttpServletRequest)
	 */
	private static String redirectFileName="/ABDM_QMS/application/jsp/invalidToken_error.jsp";
	
	public static String GenerateSecureRandomNumber(HttpServletRequest request,String processName) {
		String tokenNo = "";
		String uniqueId="UNIQUE_ID_"+ processName;
		request.getSession().removeAttribute(uniqueId);
		try {
			// Initialize SecureRandom
			// This is a lengthy operation, to be done only upon
			// initialization of the application
			SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
			// generate a random number
			String randomNum = new Integer(prng.nextInt()).toString();
			// get its digest
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] result = sha.digest(randomNum.getBytes());

			tokenNo = hexEncode(result);
			//System.out.println(uniqueId +" == tokenNo=========="+ tokenNo);
			request.getSession().setAttribute(uniqueId, tokenNo);
		} catch (NoSuchAlgorithmException ex) {
			System.err.println(ex);
		}
		return tokenNo;
	}
	
	/**
	 * Validate token.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the string
	 * @throws Exception
	 *             the exception
	 */
	public static  String validateTokenForSecureRandomNumber(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		String retVal = "0";
		try {
			String tid=request.getParameter("tid") ;
			String processName=request.getParameter("processName") ;
			String uniqueId="UNIQUE_ID_"+ processName;
			String tokenNo=(String)request.getSession().getAttribute(uniqueId);
			/*System.out.println("tid==="+ tid);
			System.out.println("processName==="+ processName);
			System.out.println("tokenNo==="+ tokenNo);
			*/
			if(tid!=null && tokenNo!=null){
				if(tid.equals(tokenNo))
					retVal = "1";
				else
					retVal = "0";
			}
		} catch (Exception e) {
			e.printStackTrace();
			retVal = "0";
		}

		if (retVal.equals("0")) {
			response.sendRedirect(redirectFileName);
			//System.out.println("Token not validated !!"); 
			//throw new Exception("Token not validated !!");
		}
		return retVal;
	}
	
	

	/**
	 * Hex encode.
	 * 
	 * @param aInput
	 *            the a input
	 * @return the string
	 */
	private static String hexEncode(byte[] aInput) {
		StringBuilder result = new StringBuilder();
		char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		for (int idx = 0; idx < aInput.length; ++idx) {
			byte b = aInput[idx];
			result.append(digits[(b & 0xf0) >> 4]);
			result.append(digits[b & 0x0f]);
		}
		return result.toString();
	}

}
