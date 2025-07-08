package hisglobal.exceptions;

public class HisNoOpenEpisodeFoundException extends HisException
{
	public HisNoOpenEpisodeFoundException()
	{
		super("HIS_MC No open episode found");
	}

	public HisNoOpenEpisodeFoundException(String _msg)
	{
		super(_msg);
	}
}
