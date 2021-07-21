package mainPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SignInTest {
    String baseurl="https://bpla.mpsdevelopment.com";

    public class ThreadSleep {
        public void main(String[] args) throws InterruptedException {
            long start = System.currentTimeMillis();
            Thread.sleep(2000);
            System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));

        }
    }

    @Test
    public void SignInOk() //throws InterruptedException
    {

        System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Alex\\Desktop\\MyProject\\AutoTests\\src\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get(baseurl+"/start");
        String url = "//button[@ng-reflect-router-link=\'/sign-in\']";
        WebElement webElement = driver.findElement(By.xpath(url));
        assertTrue((webElement.isDisplayed()));
        driver.get(baseurl+"/sign-in");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("1test"+ "1" + "@mpsdevelopment.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("m90dfsdf253tsgfspsdfdsg2342dfs");
        WebElement xpath=driver.findElement(By.xpath("/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-in/div/div[1]/app-content-container/div/div/form/button"));
        xpath.click();
        //WebDriverWait firstResult = new WebDriverWait(driver, Duration.ofSeconds(1));
        assertTrue(xpath.isDisplayed());

        driver.close();
    }
    @Test
    public void SignInNegative1() //throws InterruptedException
    {
// Login - incorrect
        {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alex\\Desktop\\MyProject\\AutoTests\\src\\WebDriver\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            //driver.manage().window().maximize();
            driver.get(baseurl + "/start");
            String url = "//button[@ng-reflect-router-link=\'/sign-in\']";
            WebElement webElement = driver.findElement(By.xpath(url));
            assertTrue((webElement.isDisplayed()));
            driver.get(baseurl + "/sign-in");
            driver.findElement(By.id("login")).clear();
            driver.findElement(By.id("login")).sendKeys("1test" + "13462t" + "@mpsdevelopment.com");
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys("");
            driver.findElement(By.xpath("/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-in/div/div[1]/app-content-container/div/div/form/button")).click();
            //System.out.println(driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[2]/a")));
            WebElement elem=driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[2]/a"));
            assertTrue(elem.isEnabled());
            driver.close();

        }
    }

    @Test
    public void SignInNegative2()
    //throws InterruptedException
    {
//Login empty
        System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Alex\\Desktop\\MyProject\\AutoTests\\src\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://bpla.mpsdevelopment.com/start");
        String url = "//button[@ng-reflect-router-link=\'/sign-in\']";
        WebElement webElement = driver.findElement(By.xpath(url));
        assertTrue((webElement.isDisplayed()));
        driver.get("https://bpla.mpsdevelopment.com/sign-in");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("m90dfsdf253tsgfspsdfdsg2342dfs");
        driver.findElement(By.xpath("/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-in/div/div[1]/app-content-container/div/div/form/button")).click();
        WebElement xpath=driver.findElement(By.xpath("//*[@id=\"header-greetings\"]/div[1]"));
        assertFalse(xpath.isDisplayed());
        driver.close();
    }

    @Test
    public void testEnter2() //throws InterruptedException
    {
        //Wrong pw

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alex\\Desktop\\MyProject\\AutoTests\\src\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://bpla.mpsdevelopment.com/start");
        String url = "//button[@ng-reflect-router-link=\'/sign-in\']";
        WebElement webElement = driver.findElement(By.xpath(url));
        assertTrue((webElement.isDisplayed()));
        //Ok login ok pw
        driver.get("https://bpla.mpsdevelopment.com/sign-in");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("1test" + "134563562" + "@mpsdevelopment.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("m90dfsdf253tsgfspsdfdsg2342dfs");
        driver.findElement(By.xpath("/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-in/div/div[1]/app-content-container/div/div/form/button")).click();
        int flag = 0;
        try {
            driver.findElement(By.xpath("//*[@id=\"header-greetings\"]/div[1]"));
        } catch (Exception e) {
            flag = 1;
        }
        assertEquals(flag, 1);
        driver.close();
    }


    @Test
    public void testTryCatch() {

        String expectedResult = "not valid password";

        //start open page
        //...


        // enter creeds
        //....


        //get error message
        // ....
        String actualResult = null;
        assertEquals(expectedResult, actualResult);


        //initialise element WebElement

        try {
            // find element
        } catch (Exception e) {
            // element = null value
        }

        //verify AssertNull(actual, )
        //verify уникальный елемент на странице
    }
















    @Test
    public void testSidnIn() //throws InterruptedException
    {


        System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Alex\\Desktop\\MyProject\\AutoTests\\src\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://bpla.mpsdevelopment.com/start");
        String url = "//button[@ng-reflect-router-link=\'/sign-in\']";
        WebElement webElement = driver.findElement(By.xpath(url));
        assertTrue((webElement.isDisplayed()));
        //Ok login ok pw
        driver.get("https://bpla.mpsdevelopment.com/sign-in");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("1test"+ "12" + "@mpsdevelopment.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("m90dfsdf253tsgfspsdfdsg2342dfs");
        driver.findElement(By.xpath("/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-in/div/div[1]/app-content-container/div/div/form/button")).click();
        assertTrue(driver.findElement(By.xpath("//*[@id=\"header-greetings\"]/div[1]")).isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[3]/button")).click();
        driver.findElement(By.xpath(url)).click();

        //Wrong login wrong pw
        driver.get("https://bpla.mpsdevelopment.com/sign-in");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("test"+ "410" + "@mpsdevelopment.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("m90dfsdf253tsgfspsdfdsg2342dfs");
        driver.findElement(By.xpath("/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-in/div/div[1]/app-content-container/div/div/form/button")).click();
        assertFalse(driver.findElement(By.xpath("//*[@id=\"header-greetings\"]/div[1]")).isDisplayed());

        //NO login Ok pw
        driver.get("https://bpla.mpsdevelopment.com/sign-in");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("1111111");
        driver.findElement(By.xpath("/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-in/div/div[1]/app-content-container/div/div/form/button")).click();
        //WebElement xpath = driver.findElement(By.xpath("//*[@id=\"header-greetings\"]/div[1]"));
        //assertFalse((xpath.isDisplayed()));

        //Ok login wrong pw
        driver.get("https://bpla.mpsdevelopment.com/sign-in");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("test"+ "410" + "@mpsdevelopment.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("1111111suidhklh");
        driver.findElement(By.xpath("/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-in/div/div[1]/app-content-container/div/div/form/button")).click();
        // WebElement xpath = driver.findElement(By.xpath("//*[@id=\"header-greetings\"]/div[1]"));
        //assertFalse((xpath.isDisplayed()));

        //Ok login wrong pw
        driver.get("https://bpla.mpsdevelopment.com/sign-in");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("test"+ "410" + "@mpsdevelopment.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("1111111suidhklh");
        driver.findElement(By.xpath("/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-in/div/div[1]/app-content-container/div/div/form/button")).click();
        //WebElement xpath = driver.findElement(By.xpath("//*[@id=\"header-greetings\"]/div[1]"));
        //assertFalse((xpath.isDisplayed()));



        //Ok login OK pw
        driver.get("https://bpla.mpsdevelopment.com/sign-in");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("test"+ "410" + "@mpsdevelopment.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("1111111");
        driver.findElement(By.xpath("/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-in/div/div[1]/app-content-container/div/div/form/button")).click();
        //WebElement xpath = driver.findElement(By.xpath("//*[@id=\"header-greetings\"]/div[1]"));
        //assertFalse((xpath.isDisplayed()));








        //positive case
        //driver.get("https://bpla.mpsdevelopment.com/sign-in");
        // WebElement elementLogin = driver.findElement(By.id("login"));
        //  elementLogin.clear();
        //int randomNum= (int)(Math.random()*10000);
        // String userlogin="1test"+ "12" + "@mpsdevelopment.com";
        // elementLogin.sendKeys(userlogin);
        // WebElement elementPw = driver.findElement(By.id("password"));
        // elementPw.clear();
        // String userpw="m90dfsdf253tsgfspsdfdsg2342dfs";
        //elementPw.sendKeys(userpw);
        // driver.findElement(By.xpath("/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-sign-in/div/div[1]/app-content-container/div/div/form/button")).click();



        //Wrong login pw wrong
        //browser.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
        //WebElement firstResult = new WebDriverWait(browser,10)
        //   .until(ExpectedConditions .elementToBeClickable(By.xpath("//a/h3")));
        //browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //public abstract WebDriver.Timeouts implicitlyWait(10, TimeUnit.SECONDS)
        driver.close();
    }



    @Test
    public void testSignUp() {
        System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Alex\\Desktop\\MyProject\\AutoTests\\src\\WebDriver\\chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://bpla.mpsdevelopment.com/start");
        //String url = "//button[@ng-reflect-router-link=\'/sign-up\']";
        String url="/html/body/app-root/app-content-layout/div/div/div/div/div[2]/app-start/div/div[1]/app-content-container/div/div/div[2]/button[2]";
        WebElement href = browser.findElement(By.xpath(url));
        href.click();
        assertTrue((href.isDisplayed()));
        browser.close();
    }
    @Test
    public void testSystemPreview() {
        System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Alex\\Desktop\\MyProject\\AutoTests\\src\\WebDriver\\chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://bpla.mpsdevelopment.com/start");
        String url = "//button[@ng-reflect-router-link=\"/dashboard\"]";
        WebElement href = browser.findElement(By.xpath(url));
        assertTrue((href.isDisplayed()));
        browser.close();
    }
    @Test
    public void testOverviewVideo() {
        System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Alex\\Desktop\\MyProject\\AutoTests\\src\\WebDriver\\chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://bpla.mpsdevelopment.com/start");
        String url = "//a[@href=\"https://www.youtube.com/watch?v=xUyaurwGQOQ\"]";
        WebElement href = browser.findElement(By.xpath(url));
        assertTrue((href.isDisplayed()));
        browser.close();
    }
    @Test
    public void testPublicInfo() {
        System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Alex\\Desktop\\MyProject\\AutoTests\\src\\WebDriver\\chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://bpla.mpsdevelopment.com/start");
        String url = "//a[@href=\"https://e-transport.gov.ua\"]";
        WebElement href = browser.findElement(By.xpath(url));
        assertTrue((href.isDisplayed()));
        browser.close();
    }
    @Test
    public void testContacts() {
        System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Alex\\Desktop\\MyProject\\AutoTests\\src\\WebDriver\\chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://bpla.mpsdevelopment.com/start");
        String url = "//a[@href=\"/contacts\"]";
        WebElement href = browser.findElement(By.xpath(url));
        assertTrue((href.isDisplayed()));
        browser.close();
    }


}


