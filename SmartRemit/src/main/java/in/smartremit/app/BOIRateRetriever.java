package in.smartremit.app;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BOIRateRetriever implements RateRetriever {

	public ForexRate getForexRate()
	{
		ForexRate fxRate = new ForexRate();
		fxRate.setSgd2inr(this.getRate());
		return fxRate;	
	}
	
	public String getRate() {
		String rate = "";
		try
		{
			//https://www.sbising.com/exchange-rates.asp			
			Document doc = Jsoup.connect("http://boi.com.sg/")
					  .data("query", "Java")
					  .userAgent("Mozilla")
					  .cookie("auth", "token")
					  .timeout(3000)
					  .post();
			
			//web_content_text
			Elements links = doc.getElementsByClass("web_content_text");
			int counter = 4;
			float sellRate = 0;
			
			for (Element link : links) {
				  //String linkHref = link.attr("href");
				  String linkText = link.text();
				  if (linkText.startsWith("INR"))
				  {
					  //printFlag = true;
					  counter = 0;
				  }
				  if (counter < 4)
				  {
					  System.out.println(linkText);
					  rate = rate + " " + linkText;
					  if (counter == 3)
					  {
						  sellRate = Float.parseFloat(linkText);
						  System.out.println("sellRate"+sellRate);

						  float sellRateRupees = 100/sellRate;
						  System.out.println("sellRateRupees "+sellRateRupees);

						  rate = rate + " " + sellRateRupees;
					  }
					  counter++;

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
