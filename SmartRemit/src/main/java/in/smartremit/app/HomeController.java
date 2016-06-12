package in.smartremit.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/rateview", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		RateRetriever ocbcRateRetriever = new OCBCRateRetriever();
		String ocbcRate = ocbcRateRetriever.getRate();
		//String boiRate = "46.12";
		System.out.println("OCBC Rate"+ocbcRate);
		model.addAttribute("ocbcRate", ocbcRate);

		RateRetriever boiRateRetriever = new BOIRateRetriever();
		String boiRate = boiRateRetriever.getRate();
		//String boiRate = "46.12";
		System.out.println("BOI Rate"+boiRate);
		model.addAttribute("boiRate", boiRate);

		RateRetriever sbiRateRetriever = new SBIRateRetriever();
		String sbiRate = sbiRateRetriever.getRate();
		//String sbiRate = "46.00";
		System.out.println("SBI Rate"+sbiRate);
		model.addAttribute("sbiRate", sbiRate);

		RateRetriever mustafaRateRetriever = new MustafaRateRetriever();
		String mustafaRate = mustafaRateRetriever.getRate();
		//String sbiRate = "46.00";
		System.out.println("Mustafa Rate"+mustafaRate);
		model.addAttribute("mustafaRate", mustafaRate);

		
		
		return "home";
	}
	

	
}
