package mainPackage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

    private final String xpathButtonSignIn = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-in/div/div[1]/app-content-container/div/div/form/button";

    private final String xpathForButtonSubmit = "/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-in/div/div[1]/app-content-container/div/div/form/button";

    private final String xpathForVerifyResult = "/html/body/app-root/app-full-layout/div/app-header/div/div/div[1]";

    private final String xpathForLogout="/html/body/app-root/app-full-layout/div/app-header/nav/div[2]/ul[2]/li[3]/button";

    private final String xpathErrorPwWrong="/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-in/div/div[1]/app-content-container/div/div/form/app-form-control[2]/div/div/app-error/div";

    private final String xpathErrorLoginWrong="/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-in/div/div[1]/app-content-container/div/div/form/app-form-control[1]/div/div/app-error/div";

    private WebDriver driver;

    public LoginTest(WebDriver driver) {
        this.driver = driver;
    }

    @Given("open logInpage (.*)")
    public void openLoginPage(String arg){
        open(arg);
    }

    @When("type to input login text: (.*)")
    public void fillInLogin(String arg){
        WebElement webElementLogin = driver.findElement(By.id("login"));
        webElementLogin.clear();
        webElementLogin.sendKeys(arg);
    }
    @And("type to input with name password text:(.*)")
    public void fillInPassword(String arg){
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(arg);
        }
    @And("press element with value Submit")
    public void submit(){
        driver.findElement(By.xpath(xpathForButtonSubmit)).click();
    }
    @Then("The element with tag Welcome should exist")
    public boolean checkWelcomeExist() throws InterruptedException {
        boolean flag=true;

        try {
            driver.findElement(By.xpath(xpathErrorPwWrong));
            driver.findElement(By.xpath(xpathErrorLoginWrong));
        } catch (Exception e){
            flag=true;
            System.out.println("Error" );
        }
        try {
            driver.findElement(By.xpath(xpathForVerifyResult));
            driver.findElement(By.xpath(xpathForLogout));
        } catch (Exception e) {
            flag = false;
        }

        if (flag) {
            driver.findElement(By.xpath(xpathForLogout)).click();
            Thread.sleep(500);
            System.out.println("logout" );
        }

        return flag;
    }

    /*public boolean loginTest(String login, String password, String mainUrl) throws Exception {

        this.driver.get(mainUrl);
        WebElement webElement;

        try {
           webElement = driver.findElement(By.xpath(xpathButtonSignIn));

        } catch (RuntimeException e) {
            throw new Exception("Web element is not found");
        }

        if (!webElement.isDisplayed()) {
            throw new InterruptedException("web element is not displayed");
        }

        WebElement webElementLogin = driver.findElement(By.id("login"));
        webElementLogin.clear();
        webElementLogin.sendKeys(login);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath(xpathForButtonSubmit)).click();

        boolean flag=true;

        try {
            driver.findElement(By.xpath(xpathErrorPwWrong));
            driver.findElement(By.xpath(xpathErrorLoginWrong));
        } catch (Exception e){
            flag=true;
            System.out.println("Error" );
        }
        try {
            driver.findElement(By.xpath(xpathForVerifyResult));
            driver.findElement(By.xpath(xpathForLogout));
        } catch (Exception e) {
            flag = false;
        }

        if (flag) {
            driver.findElement(By.xpath(xpathForLogout)).click();
            Thread.sleep(500);
            System.out.println("logout" );
        }

        return flag;


    }*/

}
