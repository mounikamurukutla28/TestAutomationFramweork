package com.automationByMounika.Components;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class WebLibrary {
    WebDriver driver;

    public WebLibrary(WebDriver driver) {
        this.driver = driver;
    }

    public void clickIt(String element) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement ele = findObj.findElementBy(element);
        } catch (Exception e) {
        }
    }

    public void typeInto(String element, String valuetoEnter) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement ele = findObj.findElementBy(element);
            ele.click();
            ele.clear();
            ele.sendKeys(valuetoEnter);
        } catch (Exception e) {
        }
    }

    public String getTextFromElement(String element) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement ele = findObj.findElementBy(element);
            return ele.getText();
        } catch (Exception e) {
            return null;
        }
    }

    public String getAttributeForElement(String element, String attributeType) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement ele = findObj.findElementBy(element);
            return ele.getAttribute(attributeType);
        } catch (Exception e) {
            return null;
        }
    }

    public void selectValueFromDropdown(String element, String selectBy, String valToSelect) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement ele = findObj.findElementBy(element);
            Select select = new Select(ele);
            if (selectBy.equalsIgnoreCase("value")) {
                select.selectByValue(valToSelect);
            } else if (selectBy.equalsIgnoreCase("visibletext")) {
                select.selectByVisibleText(valToSelect);
            } else if (selectBy.equalsIgnoreCase("index")) {
                int index = Integer.parseInt(valToSelect);
                select.selectByIndex(index);
            }
        } catch (Exception e) {

        }
    }

    public void switchToSecondWindow() {
        try {
            driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
        } catch (Exception e) {

        }

    }

    public void switchToLastWindow() {
        try {
            List<String> windows = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(windows.get(windows.size() - 1));


        } catch (Exception e) {

        }
    }

    public void hitEnter(String element) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement ele = findObj.findElementBy(element);
            ele.sendKeys(Keys.ENTER);
        } catch (Exception e) {

        }
    }

    public void hitTab(String element) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement ele = findObj.findElementBy(element);
            ele.sendKeys(Keys.TAB);
        } catch (Exception e) {

        }
    }

    public void launchUrl(String Url) {
        try {
            driver.get(Url);
        } catch (Exception e) {
        }
    }

    public void refreshPage(String Url) {
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.F5);
        }

    }

    public void switchToAlertAndAccept() {
        try {
            driver.switchTo().alert().accept();

        } catch (Exception e) {

        }
    }

    public void switchToAlertAndDismiss() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (Exception e) {

        }
    }

    public void switchToFrame(String element) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement ele = findObj.findElementBy(element);
            driver.switchTo().frame(ele);
        } catch (Exception e) {

        }
    }

    public void switchToOriginalPageFromIFrame(String element) {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {

        }
    }

    public void scrollToAnElement(WebElement element) {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true);", element);

        } catch (Exception e) {

        }
    }

    public void scrollToTop() {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollTo(0, -document.body.scrollHeight");


        } catch (Exception e) {

        }
    }

    public void scrollToBottom() {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollTo(0,document.body.scrollHeight");
        } catch (Exception e) {

        }
    }

    public void hoverOnTo(String element) {
        try {
            ElementFindBy findBy = new ElementFindBy(driver);
            WebElement ele = findBy.findElementBy(element);
            Actions actions = new Actions(driver);
            actions.moveToElement(ele).build().perform();
        } catch (Exception e) {

        }
    }

    public void dragAndDrop(String element1, String element2) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement ele1 = findObj.findElementBy(element1);
            WebElement ele2 = findObj.findElementBy(element2);
            Actions actions = new Actions(driver);
            actions.dragAndDrop(ele1, ele2).build().perform();
        } catch (Exception e) {

        }

    }

    public void rightClickOnElement(String element) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement ele = findObj.findElementBy(element);
            new Actions(driver).contextClick().build().perform();

        } catch (Exception e) {

        }
    }

    public boolean isEnabled(String element) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement ele = findObj.findElementBy(element);
            return ele.isEnabled();
        } catch (Exception e) {

        }
        return false;
    }
    public boolean isDisplayed(String element) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement ele = findObj.findElementBy(element);
            return ele.isDisplayed();
        } catch(Exception e) {
            return false;
        }


    }



}












