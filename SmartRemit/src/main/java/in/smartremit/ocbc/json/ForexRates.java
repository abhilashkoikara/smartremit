
package in.smartremit.ocbc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "ForexRates"
})
public class ForexRates {

    @JsonProperty("ForexRates")
    private List<ForexRate> ForexRates = new ArrayList<ForexRate>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The ForexRates
     */
    @JsonProperty("ForexRates")
    public List<ForexRate> getForexRates() {
        return ForexRates;
    }

    /**
     * 
     * @param ForexRates
     *     The ForexRates
     */
    @JsonProperty("ForexRates")
    public void setForexRates(List<ForexRate> ForexRates) {
        this.ForexRates = ForexRates;
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
