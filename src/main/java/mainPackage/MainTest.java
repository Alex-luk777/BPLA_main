package mainPackage;

import lombok.extern.slf4j.Slf4j;
import mainPackage.drivers.CustomWebDriver;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class MainTest {

    private final String login = "1test13@mpsdevelopment.com";
    private final String password = "m90dfsdf253tsgfspsdfdsg2342dfs";
    private final String wronglogin = "1test1314214@mpsdevelopment.com";
    private final String wrongpassword = "m90dfsdf253tsdxghdthgfspsdfdsg2342dfs";
    private final String emptylogin = "";
    private final String emptypassword = "";
    private final String urlPrefix = "https://bpla.mpsdevelopment.com";
    private final String urlStart = "https://bpla.mpsdevelopment.com/start";
    //private final String urlSignedUp="https://bpla.mpsdevelopment.com/sign-in";


    private WebDriver instance = CustomWebDriver.getInstance();

  /*  {
        instance.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }*/


    @Before
    public void initPropsWebDriver() {
        instance.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @AfterClass
    public static void destroyWebDriver() {
        CustomWebDriver.destroyDriver();
        log.info("Driver closed");
    }
    @Test
    //Login - OK, PW - OK
    public void testloginPositive() throws Exception {
        LoginTest loginTest = new LoginTest(instance);
        boolean result = loginTest.loginTest(login, password);
        if (!result) {
            log.error("testloginNegative1 is negative expected value is FALSE . actual is = %s", result);
            System.out.println("Login-OK,PW-OK - FAILED");
        }
        assertTrue(result);
    }

    @Test
    //Login - wrong, PW - OK
    public void testloginNegative1() throws Exception {
        LoginTest loginTest = new LoginTest(instance);
        boolean result = loginTest.loginTest(wronglogin, password);
        if (result) {
            log.error("testloginNegative1 is negative expected value is FALSE . actual is = %s", result);
            System.out.println("Login-wrong,PW-OK - FAILED");
        }
        assertFalse(result);
    }

    @Test
    //Login - wrong, PW - wrong
    public void testloginNegative2() throws Exception {
        LoginTest loginTest = new LoginTest(instance);
        boolean result = loginTest.loginTest(wronglogin, wrongpassword);
        if (result) {
            log.error("testloginNegative2 is negative expected value is FALSE . actual is = %s", result);
            System.out.println("Login-wrong,PW-wrong - FAILED");
        }
        assertFalse(result);

    }

    @Test
    //Login - OK, PW - wrong
    public void testloginNegative3() throws Exception {
        LoginTest loginTest = new LoginTest(instance);
        boolean result = loginTest.loginTest(login, wrongpassword);
        if (result) {
            log.error("testloginNegative3 is negative expected value is FALSE . actual is = %s", result);
            System.out.println("Login-OK,PW-wrong - FAILED");
        }
        assertFalse(result);
    }

    @Test
    //Login - OK, PW - empty
    public void testloginNegative4() throws Exception {
        LoginTest loginTest = new LoginTest(instance);
        boolean result = loginTest.loginTest(login, emptypassword);
        if (result) {
            log.error("testloginNegative4 is negative expected value is FALSE . actual is = %s", result);
            System.out.println("Login-OK,PW-empty- FAILED");
        }
        assertFalse(result);
    }

    @Test
    //Login - empty, PW - OK
    public void testloginNegative5() throws Exception {
        LoginTest loginTest = new LoginTest(instance);
        boolean result = loginTest.loginTest(emptylogin, password);
        if (result) {
            log.error("testloginNegative5 is negative expected value is FALSE . actual is = %s", result);
            System.out.println("Login-empty,PW-OK - FAILED");
        }
        assertFalse(result);
    }

    @Test
    //Login - empty, PW - empty
    public void testloginNegative6() throws Exception {
        LoginTest loginTest = new LoginTest(instance);
        boolean result = loginTest.loginTest(emptylogin, emptypassword);
        if (result) {
            log.error("testloginNegative6 is negative expected value is FALSE . actual is = %s", result);
            System.out.println("Login-empty,PW-empty - FAILED");
        }
        assertFalse(result);
    }

    @Test
    public void testSignIn() throws Exception {
        instance.get(urlStart);
        WebElement href = instance.findElement(By.id("signIn"));
        assertTrue((href.isDisplayed()));

    }

    @Test
    public void testSignUp() throws Exception {
        instance.get(urlStart);
        WebElement href = instance.findElement(By.id("signUp"));
        href.click();
        //System.out.println(SignUp.signUpOk());
        assertTrue(new SignUp(instance).signUpOk());


    }

    @Test
    public void testSystemPreview() throws Exception {
        instance.get(urlStart);
        WebElement href = instance.findElement(By.id("dashboard"));
        assertTrue((href.isDisplayed()));

    }

    @Test
    public void testOverviewVideo() throws Exception {
        instance.get(urlStart);
        WebElement href = instance.findElement(By.id("overviewVideo"));
        System.out.println("overview is OK");
        assertTrue((href.isDisplayed()));

    }

    @Test
    public void testPublicInfo() throws Exception {
        instance.get(urlStart);
        WebElement href = instance.findElement(By.id("publicInfo"));
        assertTrue((href.isDisplayed()));

    }

    @Test
    public void testContacts() throws Exception {
        instance.get(urlStart);
        WebElement href = instance.findElement(By.id("contacts"));
        assertTrue((href.isDisplayed()));

    }


}

