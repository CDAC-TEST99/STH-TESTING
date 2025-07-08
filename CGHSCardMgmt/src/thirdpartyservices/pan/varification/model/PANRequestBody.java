package thirdpartyservices.pan.varification.model;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PANRequestBody  implements Serializable{

	private static final long serialVersionUID = 1L;
	private ArrayList<PANRequestData> inputData;
	private String signature;

}
