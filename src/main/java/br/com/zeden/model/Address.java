package br.com.zeden.model;



import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "street",
    "number",
    "complement",
    "area",
    "cep",
    "city",
    "state"
})
public class Address {

    @JsonProperty("street")
    private String street;
    @JsonProperty("number")
    private long number;
    @JsonProperty("complement")
    private String complement;
    @JsonProperty("area")
    private String area;
    @JsonProperty("cep")
    private String cep;
    @JsonProperty("city")
    private String city;
    @JsonProperty("state")
    private String state;

    @JsonProperty("street")
    public String getStreet() {
        return street;
    }

    @JsonProperty("street")
    public void setStreet(String street) {
        this.street = street;
    }

    @JsonProperty("number")
    public long getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(long number) {
        this.number = number;
    }

    @JsonProperty("complement")
    public String getComplement() {
        return complement;
    }

    @JsonProperty("complement")
    public void setComplement(String complement) {
        this.complement = complement;
    }

    @JsonProperty("area")
    public String getArea() {
        return area;
    }

    @JsonProperty("area")
    public void setArea(String area) {
        this.area = area;
    }

    @JsonProperty("cep")
    public String getCep() {
        return cep;
    }

    @JsonProperty("cep")
    public void setCep(String cep) {
        this.cep = cep;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("street", street).append("number", number).append("complement", complement).append("area", area).append("cep", cep).append("city", city).append("state", state).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(complement).append(cep).append(area).append(street).append(state).append(number).append(city).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Address) == false) {
            return false;
        }
        Address rhs = ((Address) other);
        return new EqualsBuilder().append(complement, rhs.complement).append(cep, rhs.cep).append(area, rhs.area).append(street, rhs.street).append(state, rhs.state).append(number, rhs.number).append(city, rhs.city).isEquals();
    }

}
