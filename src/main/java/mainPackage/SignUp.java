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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SignUp {

    private final String loginFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[1]/div/div/input";
    private final String nameFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[2]/div/div/input";
    private final String surnameFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[3]/div/div/input";
    private final String telFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[4]/div/div/input";
    private final String birthdayFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[5]/div/div/app-date-time/div/input";
    private final String passwordFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[9]/div/div/input";
    private final String confirmpasswordFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[10]/div/div/input";
    private final String iagreeboxFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/app-form-control[11]/div/div/div[2]/label";
    private final String submitFieldXpath = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-up/div/div[1]/app-content-container/div/div/form/button";
   // private final String newLogin="li" + new Random().nextInt() + "@gmeil.com";
    public final String pushNotificationDivId = "toast-container";
    //todo need to check pushnotific text

    /* public final String tempMailUrl = "https://temp-mail.org/en/?__cf_chl_jschl_tk__=pmd_5e683695b38b33a9119627ea12d4357c10f97660-1626940660-0-gqNtZGzNAg2jcnBszQti";
    private WebDriver driverTempMail;
    private String tempMail;

    @BeforeClass
    public void initPropsWebDriver() {
        driverTempMail.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

    public String getTempMailUrl() {
        driverTempMail = new ChromeDriver();
        driverTempMail.get(tempMailUrl);
        tempMail = driverTempMail.findElement(By.id("mail")).getText();
        System.out.println(tempMail);
        return tempMail;
    }
    @AfterClass
    public void closeBrowser() {
        driverTempMail.close();
    }*/
    private WebDriver driver;

    public SignUp(WebDriver driver) {
       this.driver = driver;
    }

    public boolean signUpOk(String newLogin, String name, String surname, String phone, String birthDate, String password, String confirmpassword) {
        WebElement xpath = driver.findElement(By.xpath(loginFieldXpath));
        xpath.clear();

        System.out.println(newLogin);
        xpath.sendKeys(newLogin);
        driver.findElement(By.xpath(nameFieldXpath)).sendKeys(name);
        driver.findElement(By.xpath(surnameFieldXpath)).sendKeys(surname);
        driver.findElement(By.xpath(telFieldXpath)).sendKeys(phone);
        driver.findElement(By.xpath(birthdayFieldXpath)).clear();
        driver.findElement(By.xpath(birthdayFieldXpath)).sendKeys(birthDate);
        driver.findElement(By.xpath(passwordFieldXpath)).sendKeys(password);
        driver.findElement(By.xpath(confirmpasswordFieldXpath)).sendKeys(confirmpassword);
        driver.findElement(By.xpath(iagreeboxFieldXpath)).click();
        driver.findElement(By.xpath(submitFieldXpath)).click();

        boolean result = true;

        try{ driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
            WebElement element = driver.findElement(By.id(pushNotificationDivId));}
        catch (Exception e){
            result = false;
            assertFalse(result);
            return result;
        }

        assertTrue(result);
        return result;
    }





}
