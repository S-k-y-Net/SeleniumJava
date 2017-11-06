package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DataSource {
    public static String URL = "http://egov.kz/cms/ru";
    public static String enter = "/html/body/div[2]/div[2]/div[1]/div[2]/div[2]/div/a[1]";
    public static String ecp = "/html/body/div[9]/div[7]/div/div/div[2]/div[1]/a[2]";
    public static  String chooseSertificate = "//*[@id=\"buttonSelectCert\"]";
    public static String enterPassword = "//*[@id=\"signNCAPassword\"]";
    public static String enterXPath = "//*[@id=\"NCApassModal\"]/div[2]/input[1]";
    public static String enterThree = "//*[@id=\"loginButton\"]";
    public static String addressBook = ".search-form-example > a:nth-child(1) > span:nth-child(1)";
    public static String searchButton = ".search-form-box > button:nth-child(1)";
    public static String UrlForService = "http://egov.kz/cms/ru/services/housing_relations/013pass_mvd";
    public static String getOnlineService = "a.hidden-print:nth-child(1)";
    public static String orderService = "#searchSignButton";
    public static String ecpOrder = "button.button-type:nth-child(2)";
    public static String usbClick = "div.type-item:nth-child(2) > figure:nth-child(1) > figcaption:nth-child(2) > a:nth-child(1)";
    public static String passEnd = "#pin";
    public static String nextButton = "#sign > div > div > div > div:nth-child(2) > eds > div > div > div.actions-pad > table > tbody > tr > td.td-right > button";
    public static String sign = "button-type button-action ng-scope ng-binding";

    public WebDriver RunDriver(){
        WebDriver driver = new FirefoxDriver();
        return  driver;
    }


    public String OpenSite(WebDriver driver){
        driver.get(URL);
        return  URL;
    }

    public void mainSuite(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException {

        try {
            WebElement result = driver.findElement(By.xpath(enter));
            if (result == null) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else {
                result.click();
            }
        } catch (Exception e) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        try {
            WebElement entertwo =  driver.findElement(By.xpath(ecp));
            if (entertwo == null) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else {
                entertwo.click();
            }
        } catch (Exception e) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        try {
            WebElement certChoose = driver.findElement(By.xpath(chooseSertificate));
            if (certChoose == null) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else {
                certChoose.click();
            }
        } catch (Exception e) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }


    }
    public void middleEntering(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,30);
        FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\src\\data.properties");
        Properties prop = new Properties();
        try {
            prop.load(objfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String password = prop.getProperty("pass");
        Thread.sleep(4000);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //WebElement enterPass = driver.findElement(By.xpath(enterPassword));
        //enterPass.sendKeys(password);
        try {
            WebElement enterPass = driver.findElement(By.xpath(enterPassword));
            if (enterPass == null) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else {
                enterPass.sendKeys(password);
            }
        } catch (Exception e) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        try {
            WebElement entering = driver.findElement(By.xpath(enterXPath));
            if (entering == null) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }else {
                entering.click();
            }
        } catch (Exception e) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        try {
            WebElement enterT = driver.findElement(By.xpath(enterThree));
            if (enterT == null) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }else {
                enterT.click();
            }
        } catch (Exception e) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        Thread.sleep(4000);
        try {
            WebElement address = driver.findElement(By.cssSelector(addressBook));
            if (address == null) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }else {
                address.click();
            }
        } catch (Exception e) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement address = driver.findElement(By.cssSelector(addressBook));
            address.click();
        }

        try {
            WebElement search = driver.findElement(By.cssSelector(searchButton));
            if (search == null) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }else {
                search.click();
            }
        } catch (Exception e) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement search = driver.findElement(By.cssSelector(searchButton));
            search.click();
        }
        driver.navigate().to(UrlForService);

        try {
            WebElement service = driver.findElement(By.cssSelector(getOnlineService));
            if (service == null) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }else {
                service.click();
            }
        } catch (Exception e) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement service = driver.findElement(By.cssSelector(getOnlineService));
            service.click();
        }
        try {
            WebElement order = driver.findElement(By.cssSelector(orderService));
            if (order == null) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }else {
                order.click();
            }
        } catch (Exception e) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement order = driver.findElement(By.cssSelector(orderService));
            order.click();
        }
        Thread.sleep(2500);
        try {
            WebElement ecp = driver.findElement(By.cssSelector(ecpOrder));
            if (ecp == null) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }else {
                ecp.click();
            }
        } catch (Exception e) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement ecp = driver.findElement(By.cssSelector(ecpOrder));
            ecp.click();
        }
        Thread.sleep(2500);
        try {
            WebElement usb = driver.findElement(By.cssSelector(usbClick));
            if (usb == null) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }else {
                usb.click();
            }
        } catch (Exception e) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement usb = driver.findElement(By.cssSelector(usbClick));
            usb.click();
        }
    }
    public void endScenario(WebDriver driver)throws FileNotFoundException, IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,30);
        FileInputStream objfileTwo = new FileInputStream(System.getProperty("user.dir") + "\\src\\data.properties");
        Properties prop = new Properties();
        try {
            prop.load(objfileTwo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String secondPass = prop.getProperty("passTwo");
        try {
            WebElement endInd = driver.findElement(By.cssSelector(passEnd));
            if (endInd == null) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }else {
                endInd.click();
                endInd.sendKeys(secondPass);
            }
        } catch (Exception e) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement endInd = driver.findElement(By.cssSelector(passEnd));
            endInd.click();
            endInd.sendKeys(secondPass);
        }
        try {
            WebElement next = driver.findElement(By.cssSelector(nextButton));
            if (next == null) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }else {
                next.click();
            }
        } catch (Exception e) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement next= driver.findElement(By.cssSelector(nextButton));
            next.click();
        }
        try {
            WebElement next = driver.findElement(By.cssSelector(nextButton));
            if (next == null) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }else {
                next.click();
            }
        } catch (Exception e) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement next= driver.findElement(By.cssSelector(nextButton));
            next.click();
        }
        try {
            WebElement signButton = driver.findElement(By.className(sign));
            if (signButton == null) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }else {
                signButton.click();
            }
        } catch (Exception e) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement signButton= driver.findElement(By.className(sign));
            signButton.click();
        }


    }

}
