package in.smartremit.app;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MustafaRateRetriever implements RateRetriever {

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
			Document doc = Jsoup.connect("http://www.mustafa.com.sg/frmForexNew.aspx")
					  .data("query", "Java")
					  .userAgent("Mozilla")
					  .cookie("auth", "token")
					  .timeout(3000)
					  .post();
			//#CBE1FD
			Elements elements = doc.getElementsByAttributeValue("style", "background-color:#FFFFFF;");
			for (Element element : elements) {
				//System.out.println("SBI "+element.html());
				//Elements siblings = element.getElementsByAttributeValue("bgcolor", "#FFFFFF");
				Elements siblings = element.getAllElements();
				for (Element sibling : siblings) {
					System.out.println("Mustafa >>"+sibling.html());
					System.out.println("Mustafa >>"+sibling.text());
					if (sibling.text().contains("INR Indian Rupees"))
					{
						rate = rate +" "+ sibling.text();
						String sellRateStr = sibling.text().substring(30);
						System.out.println("sellRate"+sellRateStr);

						Float sellRate = Float.parseFloat(sellRateStr);
						System.out.println("sellRate"+sellRate);

						float sellRateRupees = 100/sellRate;
						System.out.println("sellRateRupees "+sellRateRupees);

						rate = rate + " " + sellRateRupees;

						break;
					}
					//rate = rate +" "+ sibling.text();
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
