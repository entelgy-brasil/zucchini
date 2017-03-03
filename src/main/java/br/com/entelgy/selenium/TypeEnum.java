package br.com.entelgy.selenium;

import org.openqa.selenium.By;

import java.security.InvalidParameterException;

public enum TypeEnum {

	ID("id"), NAME("name"), CLASS("class"), XPATH("xpath"), CSS("css"),

	LINK_TEXT("linkText"), PARTIAL_LINK_TEXT("partialLinkText")	;

	private String value;

	TypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static By getBy(String value, String element) throws InvalidParameterException {

		for (TypeEnum b : TypeEnum.values()) {
			if (b.getValue().equals(value)) {
				return b.by(element);
			}
		}

		throw new InvalidParameterException();
	}

	public By by(String element) {

		switch (this) {

		case NAME:
			return By.name(element);

		case CLASS:
			return By.className(element);

		case XPATH:
			return By.xpath(element);

		case CSS:
			return By.cssSelector(element);

		case LINK_TEXT:
			return By.linkText(element);

		case PARTIAL_LINK_TEXT:
			return By.partialLinkText(element);

		case ID:
		default:
			return By.id(element);
		}

	}

}
