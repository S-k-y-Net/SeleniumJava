package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DataSource {
    public static String URL = "http://egov.kz/cms/ru";
    public static String enter = "/html/body/div[2]/div[2]/div[1]/div[2]/div[2]/div/a[1]";
    public static String ecp = "/html/body/div[9]/div[7]/div/div/div[2]/div[1]/a[2]";
    public static  String chooseSertificate = "#buttonSelectCert";
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

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\rasulzodam\\Desktop\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rasulzodam\\Desktop\\chromedriver_win32\\chromedriver.exe");
        //WebDriver driver = new FirefoxDriver();

        WebDriver driver = new ChromeDriver();
        return  driver;
    }


    public String OpenSite(WebDriver driver){
        driver.get(URL);
        return  URL;
    }

    public void mainSuite(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,30);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(enter)));
            WebElement result = driver.findElement(By.xpath(enter));
            result.click();

        } catch (Exception e) {
            throw e;
        }

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ecp)));
            WebElement entertwo =  driver.findElement(By.xpath(ecp));
            entertwo.click();
        } catch (Exception e) {
            throw e;
        }
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(chooseSertificate)));
            WebElement certChoose = driver.findElement(By.cssSelector(chooseSertificate));
            certChoose.click();
        } catch (Exception e) {
            throw e;
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
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //WebElement enterPass = driver.findElement(By.xpath(enterPassword));
        //enterPass.sendKeys(password);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(enterPassword)));
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
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(enterThree)));
            WebElement enterT = driver.findElement(By.xpath(enterThree));
            enterT.click();
        } catch (Exception e) {
           throw e;
        }

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(addressBook)));
            WebElement address = driver.findElement(By.cssSelector(addressBook));
            address.click();
        } catch (Exception e) {
            throw e;
        }

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(searchButton)));
            WebElement search = driver.findElement(By.cssSelector(searchButton));
            search.click();
        } catch (Exception e) {
            throw e;
        }

        driver.navigate().to(UrlForService);

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(getOnlineService)));
            WebElement service = driver.findElement(By.cssSelector(getOnlineService));
            service.click();

        } catch (Exception e) {
            throw e;
        }
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(getOnlineService)));
            WebElement order = driver.findElement(By.cssSelector(orderService));
            order.click();

        } catch (Exception e) {
            throw e;
        }

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(ecpOrder)));
            WebElement ecp = driver.findElement(By.cssSelector(ecpOrder));
            ecp.click();
        } catch (Exception e) {
            throw e;
        }

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(usbClick)));
            WebElement usb = driver.findElement(By.cssSelector(usbClick));
            usb.click();
        } catch (Exception e) {
            throw e;
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
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(passEnd)));
            WebElement endInd = driver.findElement(By.cssSelector(passEnd));
            endInd.click();
            endInd.sendKeys(secondPass);
        } catch (Exception e) {
            throw e;
        }
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(nextButton)));
            WebElement next = driver.findElement(By.cssSelector(nextButton));
            next.click();
        } catch (Exception e) {
            throw e;
        }

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(sign)));
            WebElement signButton = driver.findElement(By.className(sign));
            signButton.click();
        } catch (Exception e) {
            throw e;
        }

    }

}
