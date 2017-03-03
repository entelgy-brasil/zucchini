# Zicchini

![zucchini](https://freshproducegroup.us/wp-content/uploads/2016/08/Zucchini-Fresh-Produce-US.jpg)

Zicchini é nossa ferramente com steps predefinidos ṕara testes automatizados baseados em [Cucumber](https://cucumber.io/).


```xml
<dependency>
    <groupId>br.com.entelgy</groupId>
    <artifactId>zucchini</artifactId>
    <version>1.0.0</version>
    <scope>test</scope>
</dependency>

```


```
# language: en
Feature: Setup Tests
  Sets up the required connections
  
  @setup
  Scenario: Setup
    Given setup url "http://localhost:8080/"
```