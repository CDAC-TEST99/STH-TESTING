package hisglobal.exceptions;

public class HisApplicationExecutionException extends HisException
{

	public HisApplicationExecutionException()
	{
		super("HIS_MC Application Execution Exception");
	}

	public HisApplicationExecutionException(String _msg)
	{
		super(_msg);
	}

}
