package HisWeb.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DataVO
{
	protected List<String> dataHeading ;	
	protected List<String[]> dataValue;
	protected List<String> dataType;
	protected String msg;
	protected String printQuery;
	protected String errorCode;
	protected String key;
	protected String reportViewed;
	private String queryLabel;
	private String tableDataDisplay;
	private String isMultiRowDataTable;
	
	
	
	public List<String> getDataHeading() {
		return dataHeading;
	}
	public void setDataHeading(List<String> dataHeading) {
		this.dataHeading = dataHeading;
	}
	public List<String[]> getDataValue() {
		return dataValue;
	}
	public void setDataValue(List<String[]> dataValue) {
		this.dataValue = dataValue;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getPrintQuery() {
		return printQuery;
	}
	public void setPrintQuery(String printQuery) {
		this.printQuery = printQuery;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public List<String> getDataType() {
		return dataType;
	}
	public void setDataType(List<String> dataType) {
		this.dataType = dataType;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getReportViewed() {
		return reportViewed;
	}
	public void setReportViewed(String reportViewed) {
		this.reportViewed = reportViewed;
	}
	public String getQueryLabel() {
		return queryLabel;
	}
	public void setQueryLabel(String queryLabel) {
		this.queryLabel = queryLabel;
	}
	public String getTableDataDisplay() {
		return tableDataDisplay;
	}
	public void setTableDataDisplay(String tableDataDisplay) {
		this.tableDataDisplay = tableDataDisplay;
	}
	public String getIsMultiRowDataTable() {
		return isMultiRowDataTable;
	}
	public void setIsMultiRowDataTable(String isMultiRowDataTable) {
		this.isMultiRowDataTable = isMultiRowDataTable;
	}
	
	
}
