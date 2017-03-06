# Zucchini

![zucchini](https://upload.wikimedia.org/wikipedia/commons/thumb/9/92/CSA-Striped-Zucchini.jpg/250px-CSA-Striped-Zucchini.jpg)

Zucchini é nossa ferramente de automação de testes baseada em [Cucumber](https://cucumber.io/) com diversos steps predefinidos.

[Lista completa com os Steps predefinidos](Steps.md)


```xml
<dependency>
    <groupId>br.com.entelgy</groupId>
    <artifactId>zucchini</artifactId>
    <version>1.0.0</version>
    <scope>test</scope>
</dependency>

```


```cucumber
# language: en
Feature: Setup Tests
  Sets up the required connections
  
  @setup
  Scenario: Setup
    Given setup url "http://localhost:8080/"
```