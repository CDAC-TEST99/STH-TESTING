package hisglobal.exceptions;

public class HisDeptUnitAlreadyVisited extends HisException
{
	public HisDeptUnitAlreadyVisited()
	{
		super("HIS_MC Dept Unit Already Visited");
	}

	public HisDeptUnitAlreadyVisited(String _msg)
	{
		super(_msg);
	}

}
