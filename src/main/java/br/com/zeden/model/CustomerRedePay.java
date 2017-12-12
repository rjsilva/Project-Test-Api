
package br.com.zeden.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "identToken",
    "type",
    "links"
})
public class CustomerRedePay {

    @JsonProperty("identToken")
    private String identToken;
    @JsonProperty("type")
    private String type;
    @JsonProperty("links")
    private List<Object> links = null;

    @JsonProperty("identToken")
    public String getIdentToken() {
        return identToken;
    }

    @JsonProperty("identToken")
    public void setIdentToken(String identToken) {
        this.identToken = identToken;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("links")
    public List<Object> getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(List<Object> links) {
        this.links = links;
    }

	@Override
	public String toString() {
		return "CustomerRedePay [identToken=" + identToken + ", type=" + type + ", links=" + links + "]";
	}

}
