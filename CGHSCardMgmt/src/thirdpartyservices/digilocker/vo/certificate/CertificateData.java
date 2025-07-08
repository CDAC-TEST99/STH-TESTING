package thirdpartyservices.digilocker.vo.certificate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public  class CertificateData {

    @XmlElement(name = "CghsCard")
    private CghsCard cghsCard;

	public CghsCard getCghsCard() {
		return cghsCard;
	}

	public void setCghsCard(CghsCard cghsCard) {
		this.cghsCard = cghsCard;
	}

    
}
