package thirdpartyservices.apisetu.digilocker.client.resp;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.digilocker.resp package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.digilocker.resp
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PullURIResponse }
     * 
     */
    public PullURIResponse createPullURIResponse() {
        return new PullURIResponse();
    }

    /**
     * Create an instance of {@link PullURIResponse.DocDetails }
     * 
     */
    public PullURIResponse.DocDetails createPullURIResponseDocDetails() {
        return new PullURIResponse.DocDetails();
    }

    /**
     * Create an instance of {@link PullURIResponse.DocDetails.IssuedTo }
     * 
     */
    public PullURIResponse.DocDetails.IssuedTo createPullURIResponseDocDetailsIssuedTo() {
        return new PullURIResponse.DocDetails.IssuedTo();
    }

    /**
     * Create an instance of {@link PullURIResponse.DocDetails.IssuedTo.Persons }
     * 
     */
    public PullURIResponse.DocDetails.IssuedTo.Persons createPullURIResponseDocDetailsIssuedToPersons() {
        return new PullURIResponse.DocDetails.IssuedTo.Persons();
    }

    /**
     * Create an instance of {@link PullURIResponse.DocDetails.IssuedTo.Persons.Person }
     * 
     */
    public PullURIResponse.DocDetails.IssuedTo.Persons.Person createPullURIResponseDocDetailsIssuedToPersonsPerson() {
        return new PullURIResponse.DocDetails.IssuedTo.Persons.Person();
    }

    /**
     * Create an instance of {@link PullURIResponse.ResponseStatus }
     * 
     */
    public PullURIResponse.ResponseStatus createPullURIResponseResponseStatus() {
        return new PullURIResponse.ResponseStatus();
    }

    /**
     * Create an instance of {@link PullURIResponse.DocDetails.IssuedTo.Persons.Person.Photo }
     * 
     */
    public PullURIResponse.DocDetails.IssuedTo.Persons.Person.Photo createPullURIResponseDocDetailsIssuedToPersonsPersonPhoto() {
        return new PullURIResponse.DocDetails.IssuedTo.Persons.Person.Photo();
    }

}
