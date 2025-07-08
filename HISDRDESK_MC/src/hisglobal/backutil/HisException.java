
/**
	Purpose --> This HisException class logs the error/DAO status into log file. 
	
	Path for Property File have been defined in hisPath.properties file that has been kept into
	WEB-INF\classes\ folder.
	
	Path for log file has been defined in property file
	
	Recommendations --> put configuration file into WEB-INF/hisConfig folder. sothat while making war file
	these files automatically include in the WAR 
*/

package hisglobal.backutil;

public class HisException extends Exception {

	private static final long serialVersionUID = 1L;

	/*
	 * constructor. Developer will throw HisException rather than Exception e.g.
	 * throw new
	 * HisException("Store","Indent Register.getIndentNo()","Null Pointer Exception"
	 * )
	 */
	public HisException(String moduleName, String fileName, String msgtest) {

	}

}
