package in.smartremit.app;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OCBCRatePair {

	String fromCurrency;
	String toCurrency;
	String rate;
	String unit;
	
	public String getFromCurrency() {
		return fromCurrency;
	}
	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}
	public String getToCurrency() {
		return toCurrency;
	}
	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}

	
	@Override
    public String toString() {
        return "OCBCRatePair{" +
                "fromCurrency='" + fromCurrency + '\'' +
                ", toCurrency=" + toCurrency + '\'' +
                ", rate=" + rate + '\'' +
                ", unit=" + unit +
                '}';
    }
	
}
