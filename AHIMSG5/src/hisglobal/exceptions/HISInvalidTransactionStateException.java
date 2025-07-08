package hisglobal.exceptions;

public class HISInvalidTransactionStateException extends HISTransactionException
{
	private static final long serialVersionUID = 0105L;

	public HISInvalidTransactionStateException()
	{
		super("HIS Invalid Transaction State Exception");
		this.errorId = "0105";
	}

	public HISInvalidTransactionStateException(String strMsg)
	{
		super("HIS Invalid Transaction State Exception::" + strMsg);
	}
}
