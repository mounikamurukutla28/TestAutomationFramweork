package com.automationByMounika.Components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementFindBy {
    WebDriver driver;
    public ElementFindBy(WebDriver driver) {
        this.driver = driver;
    }

    public By findBy(String element) throws Exception{
        By by;
        RepositoryLoader loader = new RepositoryLoader();
        loader.loadProperties();
       String elementValue =  loader.getProperty(element);
       String findBy = elementValue.split(":")[0]; //id,xpath....
       String findByValue = elementValue.split(":")[1]; // eg: //input[@id='txtUsername']
       if (findBy.equalsIgnoreCase("xpath")) {
           by = By.xpath(findByValue);
       } else if (findBy.equalsIgnoreCase("id")) {
           by = By.id(findByValue);
       } else if(findBy.equalsIgnoreCase("name")) {
           by = By.name(findByValue);
       } else if (findBy.equalsIgnoreCase("classname")) {
           by = By.className(findByValue);
       } else if (findBy.equalsIgnoreCase("cssselector")) {
           by = By.cssSelector(findByValue);
       } else if (findBy.equalsIgnoreCase("linktext")) {
           by= By.linkText(findByValue);
       } else if (findBy.equalsIgnoreCase("partiallinktext")) {
           by= By.partialLinkText(findByValue);
       } else {
           throw new Exception("Invalid locator/type in [" + element + "].pls check in OR.Repository file ");
       }
       return by;
    }
    public WebElement findElementBy(String element) throws Exception {
       By by = findBy(element);
       return driver.findElement(by);
    }

}
