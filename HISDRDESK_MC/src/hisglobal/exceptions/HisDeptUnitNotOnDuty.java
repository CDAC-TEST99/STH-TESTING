package hisglobal.exceptions;

public class HisDeptUnitNotOnDuty extends HisException
{
	public HisDeptUnitNotOnDuty()
	{
		super("HIS_MC dept Unit Not On Duty");
	}

	public HisDeptUnitNotOnDuty(String _msg)
	{
		super(_msg);
	}

}
