package thirdpartyservices.nha.eligibility.model;

import lombok.Data;

@Data
public class NHAEliRequest {
    public String nhaid;
    public String yearOfBirth;
    public String hhid;
    public String member_id;
    public String hhdtype;
    public Address address;
    public String gender;
    public String memberName;
    public String mobileNumber;
    public String photo;
    public String fatherName;
    
    @Data
    public static class Address{
        public String pinCode;
        public String statelgdCode;
        public String address;
        public String subdistrictlgdCode;
        public String districtlgdCode;
        public String ruralUrban;
        public String village_townlgdCode;
    }
}
