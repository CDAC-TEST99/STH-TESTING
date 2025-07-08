package hissso.validation.credentails.authorization;

import hissso.config.HISSSOConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.internal.xr.ValueObject;

import vo.usermgmt.MenuMasterVO;

@XmlRootElement
public class AuthorizationCredentials extends ValueObject
{
	protected Map mapMenusHirarchy;
	protected Map<String, List<MenuMasterVO>> mapContextMenus;
	protected List<MenuMasterVO> lstUserMenus;

	protected List<String> lstContextMenusURL;

	private AuthorizationCredentials()
	{
		// Do Nothing
	}

	public AuthorizationCredentials(List<MenuMasterVO> lstMenu)
	{
		setMenusMap(lstMenu);
	}

	private boolean setMenusMap(List<MenuMasterVO> lstMenu)
	{
		if (lstMenu != null && lstMenu.size() > 0)
		{
			this.lstUserMenus = new ArrayList<MenuMasterVO>();
			this.mapContextMenus = new HashMap<String, List<MenuMasterVO>>();

			Map mp = new LinkedHashMap();
			for (MenuMasterVO voMenu : lstMenu)
			{
				String arrMenu[] = voMenu.getVarMenuName().split("#");

				Map mpMenuBase = mp;
				for (int i = 0; i < (arrMenu.length - 1); i++)
				{
					String menuName = arrMenu[i];
					Object obj = mpMenuBase.get(menuName);
					if (obj == null)
					{
						mpMenuBase.put(menuName, new LinkedHashMap());
						mpMenuBase = (Map) mpMenuBase.get(menuName);
					}
					else if (obj instanceof Map)
					{
						mpMenuBase = (Map) obj;
					}
					else if (obj instanceof String)
					{
						String menuURL = (String) obj;
						mpMenuBase.put(menuName, new LinkedHashMap());
						mpMenuBase = (Map) mpMenuBase.get(menuName);
						mpMenuBase.put(menuName, menuURL);
					}
				}

				mpMenuBase.put(arrMenu[arrMenu.length - 1], voMenu.getVarURL());

				// Adding to Menu List
				MenuMasterVO voMenuComplete = new MenuMasterVO();
				voMenuComplete.setVarMenuId(voMenu.getVarMenuId());
				voMenuComplete.setVarMenuName(arrMenu[arrMenu.length - 1]);
				voMenuComplete.setVarURL(voMenu.getVarURL());
				voMenuComplete.setVarModuleName(arrMenu[0]);
				voMenuComplete.setVarMenuContext(getContext(voMenu.getVarURL()));
				voMenuComplete.setVarMenuLevel(Integer.toString(arrMenu.length));
				this.lstUserMenus.add(voMenuComplete);

				// Adding to Context Wise Menu Map
				if (this.mapContextMenus.get(voMenuComplete.getVarMenuContext()) == null)
					this.mapContextMenus.put(voMenuComplete.getVarMenuContext(), new ArrayList<MenuMasterVO>());
				this.mapContextMenus.get(voMenuComplete.getVarMenuContext()).add(voMenuComplete);
			}

			if (mp.size() > 0)
			{
				this.mapMenusHirarchy = mp;
				return true;
			}
			else return false;
		}
		else return false;
	}

	private String getContext(String strURI)
	{
		String strContext = null;
		if(strURI!=null || strURI!="")
		strContext = strURI.substring(0, strURI.indexOf("/", 2));
		return strContext;
	}

	public AuthorizationCredentials extractContextWiseAuthority(String strContext)
	{
		AuthorizationCredentials objAuthority = new AuthorizationCredentials();
		if (this.mapContextMenus != null && this.mapContextMenus.get(strContext) != null) objAuthority.lstUserMenus = this.mapContextMenus.get(strContext);

		objAuthority.mapContextMenus = new HashMap<String, List<MenuMasterVO>>();
		objAuthority.mapContextMenus.put(strContext, objAuthority.lstUserMenus);

		List<String> lstMenuURL = new ArrayList<String>();
		for (MenuMasterVO vo : objAuthority.lstUserMenus)
			lstMenuURL.add(vo.getVarURL());
		objAuthority.setLstContextMenusURL(lstMenuURL);

		return objAuthority;
	}

	public Map getContextMenusMap()
	{
		return mapContextMenus;
	}

	public Map getMenusHirarchyMap()
	{
		return mapMenusHirarchy;
	}

	public List<MenuMasterVO> getMenuList()
	{
		return lstUserMenus;
	}

	public boolean isAuthorizedURL(String strURL)
	{
		boolean flg = false;
		try
		{
			if (HISSSOConfig.AUTHORIZATION_URL_LEVEL_AT_APPLICATION_STATUS == HISSSOConfig.AUTHORIZATION_URL_LEVEL_AT_APPLICATION_ON)
			{
				if (strURL == null || strURL.trim().equals("") || strURL.endsWith(".js") || strURL.endsWith(".css")) return true;

				if (lstContextMenusURL == null || lstContextMenusURL.size() == 0) return false;

				if (lstContextMenusURL.contains(strURL)) return true;

				for (String menuURL : lstContextMenusURL)
				{
					if (strURL.startsWith(menuURL)) return true;

					String url = menuURL.substring(0, menuURL.lastIndexOf("/")+1) + "[a-zA-Z_]*" + menuURL.substring(menuURL.lastIndexOf("/")+1);
					if (strURL.matches(url)) { return true; }
				}
			}
			else
			{
				flg = true;
			}
		}
		catch (Exception e)
		{
			flg = false;
		}
		return flg;
	}

	public List<String> getLstContextMenusURL()
	{
		return lstContextMenusURL;
	}

	public void setLstContextMenusURL(List<String> lstContextMenusURL)
	{
		this.lstContextMenusURL = lstContextMenusURL;
	}
}
