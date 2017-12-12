package br.com.zeden.model;

public class CustomerObject {
	
	private String email;
	
    private Long fingerprint;

	public Long getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(Long fingerprint) {
		this.fingerprint = fingerprint;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
