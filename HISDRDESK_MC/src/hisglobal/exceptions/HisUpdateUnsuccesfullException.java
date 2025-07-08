package hisglobal.exceptions;

public class HisUpdateUnsuccesfullException extends HisException
{
	public HisUpdateUnsuccesfullException(String str)
	{
		super(str);
	}

	public HisUpdateUnsuccesfullException()
	{
		super("HIS_MC Update Unsuccesfull");
	}

}
