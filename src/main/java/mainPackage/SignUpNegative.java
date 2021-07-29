package mainPackage;
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

public class SignUpNegative {
/*
    public boolean signUpNegativetest() {
        WebElement xpath = driver.findElement(By.xpath(loginFieldXpath));
        xpath.clear();

        System.out.println(newLogin);
        xpath.sendKeys(newLogin);
        driver.findElement(By.xpath(nameFieldXpath)).sendKeys("New user");
        driver.findElement(By.xpath(surnameFieldXpath)).sendKeys("surname");
        driver.findElement(By.xpath(telFieldXpath)).sendKeys("0671231212");
        driver.findElement(By.xpath(birthdayFieldXpath)).clear();
        driver.findElement(By.xpath(birthdayFieldXpath)).sendKeys("01" + "." + "01" + "." + "9");
        driver.findElement(By.xpath(passwordFieldXpath)).sendKeys("11111111");
        driver.findElement(By.xpath(confirmpasswordFieldXpath)).sendKeys("11111111");
        driver.findElement(By.xpath(iagreeboxFieldXpath)).click();
        driver.findElement(By.xpath(submitFieldXpath)).click();

        boolean result = false;
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(1)))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(pushNotificationDivId)));

        if (!element.isDisplayed()) {
            result = false;
        } else {
            result = true;
            System.out.println("OK");

        }
        assertTrue(result);
        return result;
    }*/
}
