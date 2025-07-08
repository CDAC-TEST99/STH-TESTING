package hisglobal;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.actions.DispatchAction;

//TODO: Auto-generated Javadoc
/**
* The Class TokenConfig.
*/
public class TokenConfig extends DispatchAction {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts.action.Action#generateToken(javax.servlet.http.
	 * HttpServletRequest)
	 */
	public String generateToken(HttpServletRequest request) 
	{
		//System.out.println("Indie Token Config---->"+request.getSession().getAttribute("LANGUAGE"));
	 
			request.getSession().setAttribute(Globals.LOCALE_KEY, Locale.ENGLISH);
		  
		saveToken(request);
		return "1";
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
	public String validateToken(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String retVal = "0";
		try {
			if (isTokenValid(request))
				retVal = "1";
			else
				retVal = "0";
		} catch (Exception e) {
			e.printStackTrace();
			retVal = "0";
		}
       //System.out.println("--T/F-->"+retVal);
		freeToken(request);

		if (retVal.equals("0")) {
			response.sendRedirect("/HISInvestigationG5/app_token_error.jsp");
			throw new Exception("Token not validated !!");
		}
		return retVal;
	}

	/**
	 * Free token.
	 * 
	 * @param request
	 *            the request
	 * @return the string
	 */
	public String freeToken(HttpServletRequest request) {

		resetToken(request);
		return "1";
	}
	
	/**
	 * Generate secure random number.
	 * 
	 * @param request
	 *            the request
	 * @return the string
	 */
	public static String GenerateSecureRandomNumber(HttpServletRequest request) {
		String tokenNo = "";
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
			request.getSession().setAttribute("UNIQUE_ID", tokenNo);
		} catch (NoSuchAlgorithmException ex) {
			System.err.println(ex);
		}
		return tokenNo;
	}

	/**
	 * Generate secure random number.
	 * 
	 * @param request
	 *            the request
	 * @return the string
	 */
	public static String GenerateSecureRandomCaptche() {
		String tokenNo = "";
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
		 
		} catch (NoSuchAlgorithmException ex) {
			System.err.println(ex);
		}
		return tokenNo;
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
