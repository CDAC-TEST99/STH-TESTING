package hisglobal.persistence;


import javax.sql.rowset.WebRowSet;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import hisglobal.exceptions.HISRecordNotFoundException;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.helper.HelperMethods;
import hisglobal.vo.HospitalMstVO;
 

public class GlobalEssentialDAO extends DataAccessObject
{
	Logger log;
	public GlobalEssentialDAO(TransactionContext _tx)
	{
		super(_tx);
		log = LogManager.getLogger(this.getClass());
	}
	
	


	public HospitalMstVO getHospitalDetail(String hospitalCode) {
		
		HospitalMstVO hospitalMstVo=new HospitalMstVO();
		WebRowSet webRs = null;
		HisDAO daoObj = null;
		String strProcName = "{call pkg_clinical_util_view.PROC_GBLT_HOSPITAL_MST(?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		try 
		{
			daoObj = new HisDAO("Registration","EssentialDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "p_modeVal", "1",1);
			daoObj.setProcInValue(nProcIndex, "p_hospCode", hospitalCode,2);
			daoObj.setProcOutValue(nProcIndex, "err", 1,3);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,4);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			webRs = daoObj.getWebRowSet(nProcIndex, "resultset");
			webRs.beforeFirst();
			HelperMethods.populateVOfrmRS(hospitalMstVo, webRs);
		} 
		catch (Exception e) 
		{
			if (e.getClass() == HISRecordNotFoundException.class) 
			{
				throw new HISRecordNotFoundException(e.getMessage());
			} 
			else
				throw new HISRecordNotFoundException("GlobalDAO:getHospitalDetail:HelperMethods :: " + e);
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}		
		return hospitalMstVo;
	}

	
}
