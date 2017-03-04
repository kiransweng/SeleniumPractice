package com.remoteWbd.practice.main;

import com.remoteWbd.practice.constants.GlobalConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Main {

    public  static RemoteWebDriver driver = null;
    public static String browserType = "FF";
    public static DesiredCapabilities capabilities = null;
    public static GlobalConstants globalConstants = null;

   // public static String browserType = "Chrome";
    //public static String browserType = "IE";
    //public static String browserType = "Safari";

    public static void main(String[] args) throws  Exception{
	// write your code here
        capabilities = new DesiredCapabilities();
        globalConstants = new GlobalConstants();

        switch (browserType.toUpperCase()){

            case "FF":
                /* driver = new FirefoxDriver(); */
                capabilities.setBrowserName("firefox");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
                break;
            case "CHROME":
                System.setProperty("Dwebdriver.chrome.driver", "D://KIRAN-ALLSTUFF//EXTERNAL-TRAININGS//SELENIUM//DRIVERS//" +
                        "chromedriver_win32//chromedriver.exe");
                //driver = new ChromeDriver();
                capabilities.setBrowserName("chrome");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
                break;
            case "IE":
                System.setProperty("webdriver.ie.driver", "D://KIRAN-ALLSTUFF//EXTERNAL-TRAININGS//SELENIUM//DRIVERS//" +
                        "IEDriverServer_Win32_2.53.1//IEDriverServer.exe");
                //driver = new InternetExplorerDriver();
                capabilities.setBrowserName("internet explorer");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);

                break;
            case "SAFARI":
                driver = new SafariDriver();
            default:
                driver = new FirefoxDriver();
                break;

        }


        driver.get(globalConstants.url);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@name=\"userName\"]")).sendKeys("mercury");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("mercury");
        driver.findElementByXPath("//input[@name=\"login\"]").click();

        if(driver.findElement(By.xpath("//select[@name=\"fromPort\"]")).isDisplayed()) {
            System.out.println("Sign In is successful");
        }else{
           System.out.println("Sign In is successful");
        }

        //this is for example
        //this is sample


        driver.close();

    }
}
