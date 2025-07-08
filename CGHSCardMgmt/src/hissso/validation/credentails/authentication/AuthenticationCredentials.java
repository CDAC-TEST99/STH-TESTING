package hissso.validation.credentails.authentication;

import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.internal.xr.ValueObject;

import vo.usermgmt.HospitalMasterVO;
import vo.usermgmt.UserLoginLogVO;
import vo.usermgmt.UserMasterVO;

@XmlRootElement
public class AuthenticationCredentials extends ValueObject
{
	protected String varUserId;
	protected String varUserSeatId;
	protected String varUserLoginSessionId;

	protected String varUsrName;
	protected String varAccessURL;

	protected UserMasterVO voUser;
	protected HospitalMasterVO voHostpital;
	protected UserLoginLogVO voUserLog;

	public String getVarUserId()
	{
		return varUserId;
	}

	public void setVarUserId(String varUserId)
	{
		this.varUserId = varUserId;
	}

	public String getVarUserSeatId()
	{
		return varUserSeatId;
	}

	public void setVarUserSeatId(String varUserSeatId)
	{
		this.varUserSeatId = varUserSeatId;
	}

	public String getVarUserLoginSessionId()
	{
		return varUserLoginSessionId;
	}

	public void setVarUserLoginSessionId(String varUserLoginSessionId)
	{
		this.varUserLoginSessionId = varUserLoginSessionId;
	}

	public String getVarUsrName()
	{
		return varUsrName;
	}

	public void setVarUsrName(String varUsrName)
	{
		this.varUsrName = varUsrName;
	}

	public String getVarAccessURL()
	{
		return varAccessURL;
	}

	public void setVarAccessURL(String varAccessURL)
	{
		this.varAccessURL = varAccessURL;
	}

	public UserMasterVO getVoUser()
	{
		return voUser;
	}

	public void setVoUser(UserMasterVO voUser)
	{
		this.voUser = voUser;
	}

	public HospitalMasterVO getVoHostpital()
	{
		return voHostpital;
	}

	public void setVoHostpital(HospitalMasterVO voHostpital)
	{
		this.voHostpital = voHostpital;
	}

	public UserLoginLogVO getVoUserLog()
	{
		return voUserLog;
	}

	public void setVoUserLog(UserLoginLogVO voUserLog)
	{
		this.voUserLog = voUserLog;
	}

}
