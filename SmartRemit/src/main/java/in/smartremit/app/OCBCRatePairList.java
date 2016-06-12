package in.smartremit.app;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OCBCRatePairList {

	List <OCBCRatePair> ocbcRatePairList;
	
}
