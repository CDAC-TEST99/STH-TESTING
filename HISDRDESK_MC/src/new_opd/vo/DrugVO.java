package new_opd.vo;
public class DrugVO {
    private String drugId;
    private String drugBrandId;
    private String drugName;
    private String drugForm;
    private String isQuantityCalculated;
    private String drugStatus;
    private String drugBrandName;
    private String programId;
    private String programName;
    private String color;
    private String drugQuan;
    private String programDisplayName;
    private String quantityDisplay;
    private String itemTypeId;
    private String drugBrandNameForDisplay;
    private String packSize;
    private String maxCapQty;

    
    public String getMaxCapQty() {
		return maxCapQty;
	}


	public void setMaxCapQty(String maxCapQty) {
		this.maxCapQty = maxCapQty;
	}


	public String getPackSize() {
		return packSize;
	}


	public void setPackSize(String packSize) {
		this.packSize = packSize;
	}


	public String getDrugId() {
		return drugId;
	}


	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}


	public String getDrugBrandId() {
		return drugBrandId;
	}


	public void setDrugBrandId(String drugBrandId) {
		this.drugBrandId = drugBrandId;
	}


	public String getDrugName() {
		return drugName;
	}


	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}


	public String getDrugForm() {
		return drugForm;
	}


	public void setDrugForm(String drugForm) {
		this.drugForm = drugForm;
	}


	public String getIsQuantityCalculated() {
		return isQuantityCalculated;
	}


	public void setIsQuantityCalculated(String isQuantityCalculated) {
		this.isQuantityCalculated = isQuantityCalculated;
	}


	public String getDrugStatus() {
		return drugStatus;
	}


	public void setDrugStatus(String drugStatus) {
		this.drugStatus = drugStatus;
	}


	public String getDrugBrandName() {
		return drugBrandName;
	}


	public void setDrugBrandName(String drugBrandName) {
		this.drugBrandName = drugBrandName;
	}


	public String getProgramId() {
		return programId;
	}


	public void setProgramId(String programId) {
		this.programId = programId;
	}


	public String getProgramName() {
		return programName;
	}


	public void setProgramName(String programName) {
		this.programName = programName;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getDrugQuan() {
		return drugQuan;
	}


	public void setDrugQuan(String drugQuan) {
		this.drugQuan = drugQuan;
	}


	public String getProgramDisplayName() {
		return programDisplayName;
	}


	public void setProgramDisplayName(String programDisplayName) {
		this.programDisplayName = programDisplayName;
	}


	public String getQuantityDisplay() {
		return quantityDisplay;
	}


	public void setQuantityDisplay(String quantityDisplay) {
		this.quantityDisplay = quantityDisplay;
	}


	public String getItemTypeId() {
		return itemTypeId;
	}


	public void setItemTypeId(String itemTypeId) {
		this.itemTypeId = itemTypeId;
	}


	public String getDrugBrandNameForDisplay() {
		return drugBrandNameForDisplay;
	}


	public void setDrugBrandNameForDisplay(String drugBrandNameForDisplay) {
		this.drugBrandNameForDisplay = drugBrandNameForDisplay;
	}

	public DrugVO() {
		
	}
	// ✅ Copy Constructor
    public DrugVO(DrugVO drug) {
        this.drugId = drug.drugId;
        this.drugBrandId = drug.drugBrandId;
        this.drugName = drug.drugName;
        this.drugForm = drug.drugForm;
        this.isQuantityCalculated = drug.isQuantityCalculated;
        this.drugStatus = drug.drugStatus;
        this.drugBrandName = drug.drugBrandName;
        this.programId = drug.programId;
        this.programName = drug.programName;
        this.color = drug.color;
        this.drugQuan = drug.drugQuan;
        this.programDisplayName = drug.programDisplayName;
        this.quantityDisplay = drug.quantityDisplay;
        this.itemTypeId = drug.itemTypeId;
        this.drugBrandNameForDisplay = drug.drugBrandNameForDisplay;
    }
}