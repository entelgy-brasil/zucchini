# Zucchini

<img style="float: center;" src="images/zucchini.jpg">

Zucchini (zo͞oˈkēnē), a.k.a Abobrinha, is a testing tool based on [Cucumber](https://cucumber.io/) with many predefined steps.

## Usage

```xml
<dependency>
    <groupId>br.com.entelgy</groupId>
    <artifactId>zucchini</artifactId>
    <version>1.1.1</version>
    <scope>test</scope>
</dependency>

```

## Setup

```java
@RunWith(Cucumber.class)
@CucumberOptions(
	format = {
		"pretty",
		"html:target/cucumber-reports/html"
	},
	monochrome = false,
	features = { "src/test/resources/features/" },
	glue = { "br.com.entelgy","your.awesome.package.with.custom.steps" },
	tags = { "@setup,@it" }
)
public class ZucchiniFeaturesRunner {

	private static WebDriver driver;

	@BeforeClass
	public static void setup() {
		driver = SeleniumDriver.getDriver(DriverEnum.CHROME); //Setup Browser
		GenericDriver.getApplicationContext().setServerUrl("http://localhost:8080/"); //Setup base url
	}

	@AfterClass
	public static void cleanup() {
		driver.quit();
	}
}
```

Suported Drivers:

+ SeleniumDriver.getDriver(DriverEnum.CHROME);
+ SeleniumDriver.getDriver(DriverEnum.FIREFOX);
+ SeleniumDriver.getDriver(DriverEnum.PHANTOMJS);

## Conventions

Sorting your `features` using directory hierarchy.

![Convention](images/convention.png)

- Tag all `.features` with `@it`

- Tag `Setup.feature` file with `@setup`

### Base URL

If you want to set up the base URL for all scenarios, we recomend that use `GenericDriver` on `@BeforeClass` like below.

```java
GenericDriver.getApplicationContext().setServerUrl("http://localhost:8080/")
```
This makes the Navigate Step more semantic.
```
Then I navigate to "user/create/"
```

If not, you can set up the full url on step.
```
Then I navigate to "http://localhost:8080/user/create/"
```

## Steps

This section contains a list with all predefined steps.

[Full List](STEPS.md)

## Examples

```cucumber
#language: en

@it
Feature: Search on Google

  Scenario: Search Zucchini by Entelgy Brazil
    Then I navigate to "https://www.google.com.br/"
    Then I enter "Entelgy Zucchini" into input field having name "q"
    Then I click on element having name "btnG"
    Then I wait "10" seconds an element having class "rc" to be clickable
    Then I expect to see "entelgy-brasil/zucchini" on page
```

## Troubleshooting

We use WebDriverManager from [Boni Garcia](https://github.com/bonigarcia/webdrivermanager), that makes webdrivers binaries up to date, but, sometimes
your Web Browser don't follow updates.

Then, you have to use a specific webdriver like below:

```java
driver = SeleniumDriver.getInstance(DriverEnum.CHROME, "/path/to/your/chromedriver");
```
