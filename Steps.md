# Steps

List of all predefined steps

## Liferay Steps

* Given user "{email}" is logged in liferay
* Then login as "{email}" in liferay
* Then go to control panel
* Then go to "{uri}"
* Then logout in liferay
* Then I navigate to preferences of portlet "{[contains(@id)}"
* Then I come back to portlet

## Navigation Steps

* Then I navigate to "{url}"
* Then I navigate back
* Then I navigate forward
* Then I refresh page
* Then I maximize browser window
* Then I maximize browser window
* Then I scroll to element having (id|name|class|xpath|css) "{element}"
* Then I hover over element having (id|name|class|xpath|css) "{element}"
* Then I scroll up

## Click Steps

* When I click on element having (id|name|class|xpath|css) "{element}"
* When I click on link having text "{text}"
* When I double click on element having (id|name|class|xpath|css) "{element}"
* When I click on element having (id|name|class|xpath|css) "{element}" and text "{text}"
* When I click on element having (id|name|class|xpath|css) "{element}" on row containing "{text}" at table with (id|name|class|xpath|css) "{element}"

## Assertion Steps

* Then element having (id|name|class|xpath|css) "{element}" should have text as "{text}"
* Then element having (id|name|class|xpath|css) "{element}" should not have text as "{text}"
* Then element having (id|name|class|xpath|css) "{element}" should have partial text as "{text}"
* Then element having (id|name|class|xpath|css) "{element}" should not have partial text as "{text}"
* Then element having (id|name|class|xpath|css) "{element}" should have attribute "{attribute}" witch value "{value}"
* Then element having (id|name|class|xpath|css) "{element}" should have attribute "{attribute}" witch partial value "{value}"
* Then element having (id|name|class|xpath|css) "{element}" should not have attribute "{attribute}" witch value "{value}"
* Then element having (id|name|class|xpath|css) "{element}" should not have attribute "{attribute}" witch partial value "{value}"
* Then element having (id|name|class|xpath|css) "{element}" should be enabled
* Then element having (id|name|class|xpath|css) "{element}" should be disabled
* Then element having (id|name|class|xpath|css) "{element}" should be present
* Then element having (id|name|class|xpath|css) "{element}" should not be present
* Then element having (id|name|class|xpath|css) "{element}" should be checked
* Then element having (id|name|class|xpath|css) "{element}" should be unchecked
* Then option "{option}" by text from dropdown having (id|name|class|xpath|css) "{element}" should be selected
* Then option "{option}" by value from dropdown having (id|name|class|xpath|css) "{element}" should be selected
* Then option "{option}" by text from dropdown having (id|name|class|xpath|css) "{element}" should be unselected
* Then option "{option}" by value from dropdown having (id|name|class|xpath|css) "{element}" should be unselected
* Then radio button having (id|name|class|xpath|css) "{element}" should be selected
* Then radio button having (id|name|class|xpath|css) "{element}" should be unselected
* Then option "{option}" by text from radio button group having (id|name|class|xpath|css) "{element}" should be selected
* Then option "{option}" by value from radio button group having (id|name|class|xpath|css) "{element}" should be selected
* Then link having text (id|name|class|xpath|css) "{element}" should be present
* Then link having partial text (id|name|class|xpath|css) "{element}" should be present
* Then link having text (id|name|class|xpath|css) "{element}" should not be present
* Then link having partial text (id|name|class|xpath|css) "{element}" should not be present
* Then I expect to see "{text}" on page
* Then I expect to see a table with (id|name|class|xpath|css) "{element}" and row containing "{text}"

## Input Steps

* Then I enter "{value}" into input field having (id|name|class|xpath|css) "{element}"
* Then I clear "{value}" into input field having (id|name|class|xpath|css) "{element}"
* Then I input field having (id|name|class|xpath|css) "{element}" contains error
* Then I input field having (id|name|class|xpath|css) "{element}" is required

## Screenshot Steps

* Then I take screenshot
* Then I take screenshot with name "{name}"

## Select Steps

* Then I select "{value}" value on element having (id|name|class|xpath|css) "{element}"
* Then I select "{text}" text on element having (id|name|class|xpath|css) "{element}"
    
## Wait Steps

* Then I wait "{number}" seconds an element having (id|name|class|xpath|css) "{element}" to be clickable