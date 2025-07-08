package hisglobal.exceptions;

public class HISTransactionException extends HISException
{
	private static final long serialVersionUID = 0104L;

	public HISTransactionException()
	{
		super("HIS Transaction Exception");
		this.errorId = "0104";
	}

	public HISTransactionException(String strMsg)
	{
		super("HIS Transaction Exception::" + strMsg);
	}
}