package in.smartremit.app;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SBIRateRetriever implements RateRetriever {

	public ForexRate getForexRate()
	{
		ForexRate fxRate = new ForexRate();
		fxRate.setSgd2inr(this.getRate());
		return fxRate;	
	}
	
	@Override
	public String getRate() {
		String rate = "";
		try
		{
			Document doc = Jsoup.connect("https://www.sbising.com/exchange-rates.asp")
					  .data("query", "Java")
					  .userAgent("Mozilla")
					  .cookie("auth", "token")
					  .timeout(3000)
					  .post();
			//#CBE1FD
			Elements elements = doc.getElementsByAttributeValue("bgcolor", "#CBE1FD");
			for (Element element : elements) {
				//System.out.println("SBI "+element.html());
				Elements siblings = element.getElementsByAttributeValue("bgcolor", "#FFFFFF");
				for (Element sibling : siblings) {
					System.out.println(">>>"+sibling.text());
					rate = rate +" "+ sibling.text();
				}
			}			
			
		}
		catch (IOException e)
		{
			System.out.println("Exception "+e.getMessage());
		}
	
		return rate;		
	}

}
