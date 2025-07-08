package hisglobal.exceptions;

public class HISServiceLocatorException extends HISException
{
	private static final long serialVersionUID = 0103L;

	public HISServiceLocatorException()
	{
		super("HIS Service Locator Exception");
		this.errorId = "0103";
	}

	public HISServiceLocatorException(String strMsg)
	{
		super("HIS Service Locator Exception::" + strMsg);
	}
}