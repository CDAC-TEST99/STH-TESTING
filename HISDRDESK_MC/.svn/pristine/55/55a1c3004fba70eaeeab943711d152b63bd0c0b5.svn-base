package jcs;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.apache.jcs.JCS;
import org.apache.jcs.admin.CacheElementInfo;
import org.apache.jcs.admin.JCSAdminBean;
public class UnregisteredDrugDataManager
{
private static UnregisteredDrugDataManager instance;
private static int checkedOut = 0;
private static JCS UnregisteredDrugListCache;

private UnregisteredDrugDataManager()
{
try
{
	JCS jcs = JCS.getInstance( "UnregisteredDrugListCache" );
	UnregisteredDrugListCache = jcs;
}
catch (Exception e)
{
	e.printStackTrace();
// Handle cache region initialization failure
}
// Do other initialization that may be necessary, such as getting
// references to any data access classes we may need to populate
// value objects later
}
/**
* Singleton access point to the manager.
*/
public static UnregisteredDrugDataManager getInstance()
{
synchronized (UnregisteredDrugDataManager.class)
{
if (instance == null)
{
instance = new UnregisteredDrugDataManager();
}
}
synchronized (instance)
{
instance.checkedOut++;
}
return instance;
}

public DrugData getDrugDataObj(String  id)
{
    DrugData vObj = null;

    // First, if requested, attempt to load from cache
        vObj = (DrugData) UnregisteredDrugListCache.get(id);
       // if(vObj!=null)
        //	//System.out.println("UnregisteredDrugDataManager Getting data from cache id===" + id);
    
    return  vObj;
}




public DrugData loadDrugDataObj(String  id,List lstData)
{
    DrugData vObj = new DrugData();
    try
    {
    	vObj.lstData =lstData;
    	UnregisteredDrugListCache.put(id, vObj);
    	
    }
    catch (Exception e)
    {
        // Handle failure putting object to cache
    }

    return vObj;
}

/* function for clearing cache  from masters*/
public void removeDrugDataObj(String keyStart)
{
	DrugData vObj = new DrugData();
	
	
	try {
		  JCSAdminBean admin = new JCSAdminBean();
		  LinkedList linkedList = admin.buildElementInfo("UnregisteredDrugListCache");
		  ListIterator iterator = linkedList.listIterator();
		 
		  while (iterator.hasNext()) {
		    CacheElementInfo info = (CacheElementInfo)iterator.next();
		    //System.out.println("Key: " + info.getKey());
		    String key=info.getKey();
		  //  //System.out.println("inside UnregisteredDrugDataManager removed Key: " + key);
		    String []arr=key.split("_");
		    if(arr[0].equals(keyStart)){
		    	try
			    {
				    vObj = (DrugData) UnregisteredDrugListCache.get(key);
				   // //System.out.println("remove data from chache=================================");
				    if (vObj != null)
				    {
				    	UnregisteredDrugListCache.remove(key);        
				    }
			    }
			    catch (Exception e)
			    {
			        // Handle failure putting object to cache
			    }
		    }
		    
		    linkedList=null;
			iterator=null;
		  }
		} catch (Exception e) {
		}
	
}


/* function for clearing all cache items  */
public void removeAllFromDrugDataObj()
{
	DrugData vObj = new DrugData();
	try
    {
		UnregisteredDrugListCache.clear();
		UnregisteredDrugListCache.dispose();		    
    }catch (Exception e)
	 {
	        // Handle failure putting object to cache
	 }	
}


}
