package thirdpartyservices.digilocker.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "PullDocResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class PullDocResponse {

    @XmlElement(name = "ResponseStatus")
    private ResponseStatus responseStatus;

    @XmlElement(name = "DocDetails")
    private DocDetailsDoc docDetails;

    // Getters and Setters
    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public DocDetailsDoc getDocDetails() {
        return docDetails;
    }

    public void setDocDetails(DocDetailsDoc docDetails) {
        this.docDetails = docDetails;
    }
}
