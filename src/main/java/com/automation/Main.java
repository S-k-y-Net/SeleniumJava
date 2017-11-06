package com.automation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException, NullPointerException  {

        DataSource data = new DataSource();
        WebDriver browser = data.RunDriver();
        data.OpenSite(browser);
        data.mainSuite(browser);
        FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\src\\data.properties");
        Properties prop = new Properties();
        try {
        prop.load(objfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String diagBox = prop.getProperty("diagBox");
        String pathOne = prop.getProperty("pathForKeyOne");
        String pathTwo = prop.getProperty("pathForKeyTwo");
        Process autoitFirstCall = new ProcessBuilder(diagBox, pathOne).start();

        data.middleEntering(browser);
        Process autoitSecondCall = new ProcessBuilder(diagBox, pathTwo).start();
        data.endScenario(browser);

    }
}
