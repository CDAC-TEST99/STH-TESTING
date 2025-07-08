package hisglobal.exceptions;

public class HisNoSuchObjectException extends HisException
{

	public HisNoSuchObjectException()
	{
		super("HIS_MC No Such Object Exception");

	}

	public HisNoSuchObjectException(String _msg)
	{
		super(_msg);
	}

}
