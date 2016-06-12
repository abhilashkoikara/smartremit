
package in.smartremit.ocbc.json;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


//"bankBuyingRateTT": 0,
//"bankSellingRate": 0.9694,
//"fromCurrency": "SGD",
//"toCurrency": "LKR",
//"unit": 100


@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "bankBuyingRateTT",
    "bankSellingRate",
    "fromCurrency",
    "toCurrency",
    "unit",
})
public class ForexRate {

    @JsonProperty("bankBuyingRateTT")
    private String bankBuyingRateTT;
    @JsonProperty("bankSellingRate")
    private String bankSellingRate;
    @JsonProperty("fromCurrency")
    private String fromCurrency;
    @JsonProperty("toCurrency")
    private String toCurrency;
    @JsonProperty("unit")
    private String unit;
  
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The bankBuyingRateTT
     */
    @JsonProperty("bankBuyingRateTT")
    public String getBankBuyingRateTT() {
        return bankBuyingRateTT;
    }

    /**
     * 
     * @param bankBuyingRateTT
     *     The bankBuyingRateTT
     */
    @JsonProperty("bankBuyingRateTT")
    public void setBankBuyingRateTT(String bankBuyingRateTT) {
        this.bankBuyingRateTT = bankBuyingRateTT;
    }

    /**
     * 
     * @return
     *     The bankSellingRate
     */
    @JsonProperty("bankSellingRate")
    public String getBankSellingRate() {
        return bankSellingRate;
    }

    /**
     * 
     * @param bankSellingRate
     *     The bankSellingRate
     */
    @JsonProperty("bankSellingRate")
    public void setBankSellingRate(String bankSellingRate) {
        this.bankSellingRate = bankSellingRate;
    }

    /**
     * 
     * @return
     *     The fromCurrency
     */
    @JsonProperty("fromCurrency")
    public String getFromCurrency() {
        return fromCurrency;
    }

    /**
     * 
     * @param fromCurrency
     *     The fromCurrency
     */
    @JsonProperty("fromCurrency")
    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    /**
     * 
     * @return
     *     The toCurrency
     */
    @JsonProperty("toCurrency")
    public String getToCurrency() {
        return toCurrency;
    }

    /**
     * 
     * @param toCurrency
     *     The toCurrency
     */
    @JsonProperty("toCurrency")
    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    /**
     * 
     * @return
     *     The unit
     */
    @JsonProperty("unit")
    public String getUnit() {
        return unit;
    }

    /**
     * 
     * @param unit
     *     The unit
     */
    @JsonProperty("unit")
    public void setUnit(String unit) {
        this.unit = unit;
    }

  

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
