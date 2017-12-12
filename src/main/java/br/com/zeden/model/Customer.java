
package br.com.zeden.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cpf",
    "rg",
    "name",
    "email",
    "phone",
    "address",
    "accountCredentials"
})
public class Customer {

    @JsonProperty("cpf")
    private String cpf;
    @JsonProperty("rg")
    private String rg;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("accountCredentials")
    private AccountCredentials accountCredentials;

    @JsonProperty("cpf")
    public String getCpf() {
        return cpf;
    }

    @JsonProperty("cpf")
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @JsonProperty("rg")
    public String getRg() {
        return rg;
    }

    @JsonProperty("rg")
    public void setRg(String rg) {
        this.rg = rg;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonProperty("accountCredentials")
    public AccountCredentials getAccountCredentials() {
        return accountCredentials;
    }

    @JsonProperty("accountCredentials")
    public void setAccountCredentials(AccountCredentials accountCredentials) {
        this.accountCredentials = accountCredentials;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("cpf", cpf).append("rg", rg).append("name", name).append("email", email).append("phone", phone).append("address", address).append("accountCredentials", accountCredentials).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(phone).append(address).append(email).append(accountCredentials).append(name).append(rg).append(cpf).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Customer) == false) {
            return false;
        }
        Customer rhs = ((Customer) other);
        return new EqualsBuilder().append(phone, rhs.phone).append(address, rhs.address).append(email, rhs.email).append(accountCredentials, rhs.accountCredentials).append(name, rhs.name).append(rg, rhs.rg).append(cpf, rhs.cpf).isEquals();
    }

}
