package hisglobal.exceptions;

import java.util.Map;

public class HISRecordNotFoundException extends HISException
{
	private static final long serialVersionUID = 0106L;

	private Map essentialMap;

	public HISRecordNotFoundException()
	{
		super("HIS Record Not Found Exception");
		this.errorId = "0106";
	}

	public HISRecordNotFoundException(String strMsg)
	{
		super("HIS Record Not Found Exception::" + strMsg);
	}

	public Map getEssentialMap()
	{
		return essentialMap;
	}

	public void setEssentialMap(Map essentialMap)
	{
		this.essentialMap = essentialMap;
	}

	public HISRecordNotFoundException(String strMsg, Map essentialMap)
	{
		super(strMsg);
		this.essentialMap = essentialMap;
	}
}
