package in.smartremit.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.smartremit.ocbc.json.*;

public class OCBCRateRetriever implements RateRetriever {

	public ForexRate getForexRate()
	{
		ForexRate fxRate = new ForexRate();
		fxRate.setSgd2inr(this.getRate());
		return fxRate;	
	}
	
	public String getRate() {
		String rate = "";
		//Connect to OCBC API
		System.out.println("Connect to OCBC API");
		  try {
			  
			  	URL url = new URL("https://api.ocbc.com:8243/Forex/1.0");
			  	//URL url = new URL("https://google.com");
			    HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
			    con.setRequestMethod("GET");
				con.setRequestProperty("Accept", "application/json");
				con.setRequestProperty("Authorization", "Bearer e27c1e029fe91c959311dd8dd5055079");
			    
				if (con.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ con.getResponseCode());
				}


				BufferedReader br = new BufferedReader(
		                         new InputStreamReader((con.getInputStream())));

				String output;
				String jsonString = "";
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
					jsonString = jsonString.concat(output);
				}

				System.out.println("JSON from API "+output+" <>");
				
				System.out.println("jsonString "+jsonString.trim()+" <>");

				jsonString = jsonString.trim();
				
				ObjectMapper mapper = new ObjectMapper();
				
				//String sampleJson = "{\"ForexRates\":[{\"Description\":\"\",\"FromCurrency\":\"SGD\",\"OriginalRate\":\"0.965\",\"OriginalSellingRate\":\"0.0\",\"Rate\":\"0.965\",\"SellingRate\":\"0.0\",\"ToCurrency\":\"LKR\",\"Unit\":\"100\",\"ValueDate\":\"\"}]}";
				//{"ForexRates":[{"bankBuyingRateTT":0,"bankSellingRate":0.9694,"fromCurrency":"SGD","toCurrency":"LKR","unit":100},{"bankBuyingRateTT":20.5753,"bankSellingRate":21.2272,"fromCurrency":"SGD","toCurrency":"DKK","unit":100},{"bankBuyingRateTT":0,"bankSellingRate":0.0107,"fromCurrency":"SGD","toCurrency":"IDR","unit":100},{"bankBuyingRateTT":0,"bankSellingRate":2.0855,"fromCurrency":"SGD","toCurrency":"INR","unit":100},{"bankBuyingRateTT":1.3713,"bankSellingRate":1.3948,"fromCurrency":"SGD","toCurrency":"USD","unit":1},{"bankBuyingRateTT":17.5759,"bankSellingRate":17.9959,"fromCurrency":"SGD","toCurrency":"HKD","unit":100},{"bankBuyingRateTT":0.9839,"bankSellingRate":1.0175,"fromCurrency":"SGD","toCurrency":"AUD","unit":1},{"bankBuyingRateTT":16.3996,"bankSellingRate":16.8723,"fromCurrency":"SGD","toCurrency":"NOK","unit":100},{"bankBuyingRateTT":1.5346,"bankSellingRate":1.5707,"fromCurrency":"SGD","toCurrency":"EUR","unit":1},{"bankBuyingRateTT":16.4017,"bankSellingRate":16.8929,"fromCurrency":"SGD","toCurrency":"SEK","unit":100},{"bankBuyingRateTT":3.7683,"bankSellingRate":3.9749,"fromCurrency":"SGD","toCurrency":"THB","unit":100},{"bankBuyingRateTT":137.8191,"bankSellingRate":141.748,"fromCurrency":"SGD","toCurrency":"CHF","unit":100},{"bankBuyingRateTT":0.9218,"bankSellingRate":0.9543,"fromCurrency":"SGD","toCurrency":"NZD","unit":1},{"bankBuyingRateTT":1.9863,"bankSellingRate":2.0329,"fromCurrency":"SGD","toCurrency":"GBP","unit":1},{"bankBuyingRateTT":1.2352,"bankSellingRate":1.262,"fromCurrency":"SGD","toCurrency":"JPY","unit":100},{"bankBuyingRateTT":1.041,"bankSellingRate":1.0651,"fromCurrency":"SGD","toCurrency":"CAD","unit":1},{"bankBuyingRateTT":20.7623,"bankSellingRate":21.4423,"fromCurrency":"SGD","toCurrency":"CNH","unit":100}]}

				
				in.smartremit.ocbc.json.ForexRates ocbcRates = mapper.readValue(jsonString, in.smartremit.ocbc.json.ForexRates.class);
				
				
				List<in.smartremit.ocbc.json.ForexRate> ratePairs = ocbcRates.getForexRates();
				
				for (int i=0;i<ratePairs.size();i++)
				{
					System.out.println("from currency "+ ratePairs.get(i).getFromCurrency());
					System.out.println("to currency "+ ratePairs.get(i).getToCurrency());
					System.out.println("rate "+ ratePairs.get(i).getBankSellingRate());
					System.out.println("unit "+ ratePairs.get(i).getUnit());
					if (ratePairs.get(i).getToCurrency().equalsIgnoreCase("INR"))
					{
						rate = "SGD to INR: "+" rate: "+ ratePairs.get(i).getBankSellingRate()+" unit:"+ratePairs.get(i).getUnit();;
						break;
					}
				}
				
				con.disconnect();
				
			  } catch (ClientProtocolException e) {
			
				e.printStackTrace();

			  } catch (IOException e) {
			
				e.printStackTrace();
			  }
		return rate;		
	}

}
