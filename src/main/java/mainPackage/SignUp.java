package mainPackage;

import mainPackage.drivers.CustomWebDriver;
import mainPackage.drivers.CustomWebDriver2;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SignUp {

    public final String tempMailUrl = "https://temp-mail.org/en/?__cf_chl_jschl_tk__=pmd_5e683695b38b33a9119627ea12d4357c10f97660-1626940660-0-gqNtZGzNAg2jcnBszQti";


    private WebDriver driverTempMail;
    private WebDriver driver;
    private String tempMail;
    private final String loginFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[1]/div/div/input";
    private final String nameFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[2]/div/div/input";
    private final String surnameFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[3]/div/div/input";
    private final String telFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[4]/div/div/input";
    private final String birthdayFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[5]/div/div/app-date-time/div/input";
    private final String passwordFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[9]/div/div/input";
    private final String confirmpasswordFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[10]/div/div/input";
    private final String iagreeboxFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[11]/div/div/div[2]/label";
    private final String submitFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/button";
    private final String urlSignedUp="https://bpla.mpsdevelopment.com/sign-in";

    @BeforeClass
    public void initPropsWebDriver() {
        driverTempMail.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }

    /*public void webInit(WebDriver driverTempMail, WebDriver driver) {
        this.driverTempMail = driverTempMail;
        //this.driver = driver;
    }*/
    public SignUp(WebDriver driver) {
        this.driver = driver;
    }

    public String getTempMailUrl() {
        driverTempMail= new ChromeDriver();
        driverTempMail.get(tempMailUrl);
        tempMail = driverTempMail.findElement(By.id("mail")).getText();
        System.out.println(tempMail);
        return tempMail;
    }


    public boolean signUpOk() throws InterruptedException {
        System.out.println("inside");
        WebElement xpath=driver.findElement(By.xpath(loginFieldXpath));
        xpath.clear();
        xpath.sendKeys("lilipyt22342335426788@gmeil.com");
        driver.findElement(By.xpath(nameFieldXpath)).sendKeys("New user");
        driver.findElement(By.xpath(surnameFieldXpath)).sendKeys("surname");
        driver.findElement(By.xpath(telFieldXpath)).sendKeys("0671231212");
        driver.findElement(By.xpath(birthdayFieldXpath)).clear();
        driver.findElement(By.xpath(birthdayFieldXpath)).sendKeys("01"+"."+"01"+"."+"9");
        driver.findElement(By.xpath(passwordFieldXpath)).sendKeys("11111111");
        driver.findElement(By.xpath(confirmpasswordFieldXpath)).sendKeys("11111111");
        driver.findElement(By.xpath(iagreeboxFieldXpath)).click();
        driver.findElement(By.xpath(submitFieldXpath)).click();

        System.out.println(driver.getCurrentUrl());
        Thread.sleep(5000);
        if (driver.getCurrentUrl()==(urlSignedUp)){
           return (true);
        }
        else {return (false);}

    }


    @AfterClass
    public void closeBrowser() {
        driverTempMail.close();
    }

}
