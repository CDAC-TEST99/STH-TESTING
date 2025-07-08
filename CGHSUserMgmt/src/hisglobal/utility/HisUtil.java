package hisglobal.utility;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public final class HisUtil {

	private boolean retValue = false;
	private String moduleName = "";
	private String fileName = "";
	// used for error messages
	private String errMsg = "";
private static final Map<String, String> hisPathMap = new HashMap<String, String>();
	
	static {

		fetchHisPathToMap();

	}
	

private static void fetchHisPathToMap() {

		
		DocumentBuilderFactory dbf = null;
		DocumentBuilder db = null;
		Document doc = null;
		String filename="config.Configuration";
		try {

			String filePath = "";
			String osType = System.getProperties().getProperty("os.name");
			 
			if (osType.startsWith("Win")) {

				filePath =  Usefulmethods.getQuery(filename, "HISPATH_WINDOWS");
			} else {
				filePath = Usefulmethods.getQuery(filename, "HISPATH_LINUX");

			}
			

			  dbf = DocumentBuilderFactory.newInstance();
			  db = dbf.newDocumentBuilder();
			  doc = db.parse(filePath);
			NodeList nodeList = doc.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node textChild = nodeList.item(i);
				NodeList childNodes = textChild.getChildNodes();
				for (int j = 0; j < childNodes.getLength(); j++) {
					Node grantChild = childNodes.item(j);
					NodeList grantChildNodes = grantChild.getChildNodes();
					for (int k = 0; k < grantChildNodes.getLength(); k++) {
						if (grantChildNodes.item(k).getTextContent() != null
								&& grantChildNodes.item(k).getTextContent()
										.trim().length() > 0) {

							hisPathMap.put(grantChildNodes.item(k).getNodeName(),
									grantChildNodes.item(k).getTextContent());
							// System.out.println(map);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			doc = null;
			db = null;
			dbf = null;
		 
			
		}

	}

public static String getParameterFromHisPathXML(String _Param){
	
	//System.out.println("HISUTIL::getParameterFromHisPathXML");
	String osType = null;
	String paramValue=null;
	try{
		osType = System.getProperties().getProperty("os.name");
		if(osType.startsWith("Win")){
			_Param += "_WIN";
			//paramValue = getParameterFromXML("c:/RAOL/AHIMS/hisPath.xml", _Param);
			paramValue = hisPathMap.get(_Param);
		}else{
			_Param += "_LIN";
	    	paramValue = hisPathMap.get(_Param);
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	return paramValue;
}
public static String getParameterFromXML(String _XMLpath,String _Param){
	String strResult="";
	//System.out.println("_XMLpath---" + _XMLpath);
	try{
		SaxHandler sax = new SaxHandler();
		strResult= sax.getParameter(_XMLpath, _Param);
	}catch(Exception e){
		e.printStackTrace();	
	}
	return strResult;
}

}