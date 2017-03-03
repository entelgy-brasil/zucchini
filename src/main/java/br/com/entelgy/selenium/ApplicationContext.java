package br.com.entelgy.selenium;

public class ApplicationContext {

	private String serverUrl = "";
	private String username = "";
	private String password = "";

	public String getServerUrl() {
		return serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void clear() {
		this.username = "";
		this.password = "";
	}

}
