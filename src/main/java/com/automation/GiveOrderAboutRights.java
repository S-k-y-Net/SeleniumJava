package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GiveOrderAboutRights {
    private String TextForOrder = "Получение справок о зарегистрированных правах (обременениях)";
    private String SearchResultLink = "a[href*='/cms/ru/services/buy_sale/pass076_mu']";
    private String searchFieldSelector = "#edit-query";
    private String orderXpath = "//*[@id=\"sticky-wrapper\"]/div/div/a";
    private String orderSelector = "#sticky-wrapper > div > div > a";
    private String objectTypeComboBoxSelector = "#search > div > div > div > div:nth-child(1) > div > div > div > div > span";
    private String objectTypeXpath= "//*[@id=\"search\"]/div/div/div/div[1]/div/div/div/div/span";
    private String firstGarageSelector = "body > div:nth-child(12) > div.popup-type > div > div.ng-scope > article > div > div > div > div > ul > li:nth-child(3)";
    private String firstGarageXpath = "/html/body/div[4]/div[1]/div/div[1]/article/div/div/div/div/ul/li[3]";
    private String addressSelector = "#search > div > div > div > div.ng-scope > div > div > textarea";
    private String addressXpath = "//*[@id=\"search\"]/div/div/div/div[3]/div/div/textarea";
    private String chooseAddressSelector = "body > div:nth-child(14) > div.popup-type > div > div.ng-scope.popup-container > article > div.ng-isolate-scope > div > div > div > div > div > div > span";
    private String chooseAddressXpath = "/html/body/div[6]/div[1]/div/div[1]/article/div[1]/div/div/div/div/div/div/span";
    private String selectComboBoxSelector = "body > div:nth-child(15) > div.popup-type > div > div.ng-scope > article > div:nth-child(1) > div > div > div.list-wrapper > ul > li:nth-child(7)";
    private String selectComboBoxXpath = "/html/body/div[7]/div[1]/div/div[1]/article/div[1]/div/div/div[1]/ul/li[7]";
    private String clickToSecondComboSelector = "body > div:nth-child(14) > div.popup-type > div > div.ng-scope.popup-container > article > div.ng-isolate-scope > div:nth-child(2) > div > div > div > div > div > span";
    private String clickToSecondComboXpath = "/html/body/div[6]/div[1]/div/div[1]/article/div[1]/div[2]/div/div/div/div/div/span";
    private String selectOblastSelector = "body > div:nth-child(16) > div.popup-type > div > div.ng-scope > article > div > div > div > div > ul > li:nth-child(2)";
    private String selectOblastXpath = "/html/body/div[9]/div[1]/div/div[1]/article/div/div/div/div/ul/li[2]";
    private String clickToThirdComboSelector = "body > div:nth-child(14) > div.popup-type > div > div.ng-scope.popup-container > article > div.ng-isolate-scope > div:nth-child(3) > div > div > div > div > div > span";
    private String streetSelector = "body > div:nth-child(17) > div.popup-type > div > div.ng-scope > article > div:nth-child(1) > div > div > div.list-wrapper > ul > li:nth-child(7)";
    private String saveSelector = "body > div:nth-child(14) > div.popup-type > div > footer > div.right-buttons > button";
    private String homeSelector = "#search > div > div > div > div.ng-scope > fieldset > table > tbody > tr > td:nth-child(1) > div > input";
    private String signatureSelector = "#searchSignButton";

    public static String enterPassword = "//*[@id=\"signNCAPassword\"]";
    public static String enterXPath = "//*[@id=\"NCApassModal\"]/div[2]/input[1]";
    public static String enterThree = "//*[@id=\"loginButton\"]";
    public static String searchButtonOne = "//*[@id=\"edit-submit\"]";
    public static String searchButtonTwo = "/html/body/div[3]/header/div[3]/form/fieldset/div[1]/button";
    public static String bodyXpath = "//*[@id=\"query\"]";
    public static String ecpOrder = "//*[@id=\"sign\"]/div/div/div/div[1]/div/button[2]";
    public static String usbClick = "div.type-item:nth-child(2) > figure:nth-child(1) > figcaption:nth-child(2) > a:nth-child(1)";


    public void SearchTextForOrder(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(bodyXpath)));
        driver.get("https://egov.kz/cms/ru/information/help/instrukcii");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(searchFieldSelector)));
        WebElement searchField = driver.findElement(By.cssSelector(searchFieldSelector));
        searchField.click();
        searchField.sendKeys(TextForOrder);

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchButtonOne)));
            WebElement search = driver.findElement(By.xpath(searchButtonOne));
            search.click();

        } catch (Exception e) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(searchButtonTwo)));
            WebElement search = driver.findElement(By.cssSelector(searchButtonTwo));
            search.click();
        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SearchResultLink)));
            WebElement searchResult = driver.findElement(By.cssSelector((SearchResultLink)));
            searchResult.click();
        } catch (Exception e) {
            throw e;
        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(orderXpath)));
            WebElement orderLink = driver.findElement(By.xpath(orderXpath));
            orderLink.click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(orderSelector)));
            WebElement orderLink = driver.findElement(By.cssSelector(orderSelector));
            orderLink.click();
        }
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(objectTypeComboBoxSelector)));
            WebElement objectType= driver.findElement(By.cssSelector(objectTypeComboBoxSelector));
            objectType.click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectTypeXpath)));
            WebElement objectType = driver.findElement(By.xpath(objectTypeXpath));
            objectType.click();
        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(firstGarageSelector)));
            WebElement firstGarage= driver.findElement(By.cssSelector(firstGarageSelector));
            firstGarage.click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstGarageXpath)));
            WebElement firstGarage = driver.findElement(By.xpath(firstGarageXpath));
            firstGarage.click();
        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(addressSelector)));
            WebElement address= driver.findElement(By.cssSelector(addressSelector));
            address.click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addressXpath)));
            WebElement address = driver.findElement(By.xpath(addressXpath));
            address.click();
        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(chooseAddressSelector)));
            WebElement chooseAddress= driver.findElement(By.cssSelector(chooseAddressSelector));
            JavascriptExecutor js = (JavascriptExecutor)driver;
            //js.executeScript("arguments[0].click());", chooseAddress);
            js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", chooseAddress);
            chooseAddress.click();
            //Actions action = new Actions(driver);
            //action.moveToElement(chooseAddress).click().perform();
        } catch (Exception e) {

        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selectComboBoxSelector)));
            WebElement selectComboBox= driver.findElement(By.cssSelector(selectComboBoxSelector));
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", selectComboBox);
        } catch (Exception e) {

        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(clickToSecondComboSelector)));
            WebElement clickToSecondCombo= driver.findElement(By.cssSelector(clickToSecondComboSelector));
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", clickToSecondCombo);

        } catch (Exception e) {

        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selectOblastSelector)));
            WebElement selectOblast= driver.findElement(By.cssSelector(selectOblastSelector));
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", selectOblast);

        } catch (Exception e) {

        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(clickToThirdComboSelector)));
            WebElement clickThirdCombo= driver.findElement(By.cssSelector(clickToThirdComboSelector));
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", clickThirdCombo);

        } catch (Exception e) {

        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(streetSelector)));
            WebElement street= driver.findElement(By.cssSelector(streetSelector));
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", street);

        } catch (Exception e) {

        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(saveSelector)));
            WebElement save= driver.findElement(By.cssSelector(saveSelector));
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", save);

        } catch (Exception e) {

        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(homeSelector)));
            WebElement home= driver.findElement(By.cssSelector(homeSelector));
            home.sendKeys("2b");
        } catch (Exception e) {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(homeSelector)));
            WebElement home= driver.findElement(By.cssSelector(homeSelector));
            home.sendKeys("2b");
        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(signatureSelector)));
            WebElement signature= driver.findElement(By.cssSelector(signatureSelector));
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", signature);

        } catch (Exception e) {

        }

        try {
            Thread.sleep(3000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ecpOrder)));
            WebElement ecp = driver.findElement(By.xpath(ecpOrder));
            ecp.click();

        } catch (Exception e) {
            throw e;
        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(usbClick)));
            WebElement usb = driver.findElement(By.cssSelector(usbClick));
            usb.click();
        } catch (Exception e) {
            throw e;
        }


    }
    public void enterPassword(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,30);
        FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\src\\data.properties");
        Properties prop = new Properties();
        try {
            prop.load(objfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String password = prop.getProperty("pass");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //WebElement enterPass = driver.findElement(By.xpath(enterPassword));
        //enterPass.sendKeys(password);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(enterPassword)));
            WebElement enterPass = driver.findElement(By.xpath(enterPassword));
            enterPass.click();
            enterPass.sendKeys(password);
        } catch (Exception e) {
            throw  e;
        }
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(enterXPath)));
            WebElement entering = driver.findElement(By.xpath(enterXPath));
            entering.click();
        } catch (Exception e) {
            throw e;
        }
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(enterThree)));
            WebElement enterT = driver.findElement(By.xpath(enterThree));
            enterT.click();
        } catch (Exception e) {
            throw e;
        }

    }
}
