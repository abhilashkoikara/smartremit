package in.smartremit.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmartRemitRestController {

    @RequestMapping("/rate")
    public ForexRate getForexRate(@RequestParam(value="name", defaultValue="ALL") String name) {
    	ForexRate fxRate = null;
    	
    	if (name.equalsIgnoreCase("SBI"))
    	{
        	RateRetriever sbiRateRetriever = new SBIRateRetriever();
    		//String sbiRate = sbiRateRetriever.getRate();
        	fxRate = sbiRateRetriever.getForexRate();      		
    	}
    	else if (name.equalsIgnoreCase("BOI"))
    	{
    		RateRetriever boiRateRetriever = new BOIRateRetriever();
    		//String boiRate = boiRateRetriever.getRate();
    		fxRate = boiRateRetriever.getForexRate();  
    	}
    	else
    	{
    		fxRate = new ForexRate();
    	}
    	
    	return fxRate;
    }
}
