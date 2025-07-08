package thirdpartyservices.digilocker.vo.certificate;

import javax.xml.bind.annotation.XmlElement;

public class IssuedBy {
	  
      private Organization organization;

      @XmlElement(name = "Organization")
      public Organization getOrganization() {
			return organization;
		}

		public void setOrganization(Organization organization) {
			this.organization = organization;
		}
}
