package thirdpartyservices.nha.eligibility.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "nhaid", "hhid", "hhdtype", "eligible", "grade", "sourceId", "sourceType", "bankName", "accountHolderName", "bankAccountNumber", "ifscCode", "errorCode", "errorMessage", "deathDate", "expiryDate" })
public class NHAEliResponse{
	private String sourceId;
	private String errorMessage;
	private String hhdtype;
	private String errorCode;
	private String bankName;
	private String hhid;
	private String accountHolderName;
	private String expiryDate;
	private String sourceType;
	private String eligible;
	private String grade;
	private String deathDate;
	private String bankAccountNumber;
	private String nhaid;
	private String ifscCode;

	public String getSourceId(){
		return sourceId;
	}

	public String getErrorMessage(){
		return errorMessage;
	}

	public String getHhdtype(){
		return hhdtype;
	}

	public String getErrorCode(){
		return errorCode;
	}

	public String getBankName(){
		return bankName;
	}

	public String getHhid(){
		return hhid;
	}

	public String getAccountHolderName(){
		return accountHolderName;
	}

	public String getExpiryDate(){
		return expiryDate;
	}

	public String getSourceType(){
		return sourceType;
	}

	public String getEligible(){
		return eligible;
	}

	public String getGrade(){
		return grade;
	}

	public String getDeathDate(){
		return deathDate;
	}

	public String getBankAccountNumber(){
		return bankAccountNumber;
	}

	public String getNhaid(){
		return nhaid;
	}
		
	public String getIfscCode(){
		return ifscCode;
	}
}
