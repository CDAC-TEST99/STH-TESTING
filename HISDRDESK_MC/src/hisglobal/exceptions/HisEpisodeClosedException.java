package hisglobal.exceptions;

public class HisEpisodeClosedException extends HisException
{
	public HisEpisodeClosedException()
	{
		super("HIS_MC Episode Closed Exception");
	}

	public HisEpisodeClosedException(String _msg)
	{
		super(_msg);
	}
}
