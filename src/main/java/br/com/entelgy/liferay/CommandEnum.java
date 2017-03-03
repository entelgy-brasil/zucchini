package br.com.entelgy.liferay;

public enum CommandEnum {

	DEACTIVATE("deactivate"),
	DELETE("delete");

	private String value;

	CommandEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
