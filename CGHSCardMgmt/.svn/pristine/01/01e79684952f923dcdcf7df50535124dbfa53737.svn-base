package thirdpartyservices.digilocker.vo;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "PullURIResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class PullURIResponse {

    @XmlElement(name = "ResponseStatus")
    private ResponseStatus responseStatus;

    @XmlElement(name = "DocDetails")
    private DocDetailsURI docDetails;

    // Getters and Setters
    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

  

   
    

    public DocDetailsURI getDocDetails() {
		return docDetails;
	}

	public void setDocDetails(DocDetailsURI docDetails) {
		this.docDetails = docDetails;
	}






	@XmlAccessorType(XmlAccessType.FIELD)
    public static class IssuedTo {

        @XmlElement(name = "Persons")
        private Persons persons;

        // Getters and Setters
        public Persons getPersons() {
            return persons;
        }

        public void setPersons(Persons persons) {
            this.persons = persons;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Persons {

        @XmlElement(name = "Person")
        private List<Person> personList;

        // Getters and Setters
        public List<Person> getPersonList() {
            return personList;
        }

        public void setPersonList(List<Person> personList) {
            this.personList = personList;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Person {

        @XmlAttribute(name = "name")
        private String name;

        @XmlAttribute(name = "dob")
        private String dateOfBirth;

        @XmlAttribute(name = "gender")
        private String gender;

        @XmlAttribute(name = "phone")
        private String phone;

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
