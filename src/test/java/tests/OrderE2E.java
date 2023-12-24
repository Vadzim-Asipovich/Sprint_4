package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageObjectModel.HomePageScooter;
import pageObjectModel.OrderInfoPageScooter;
import pageObjectModel.OrderUserInfoPageScooter;

import static org.hamcrest.CoreMatchers.startsWith;


public class OrderE2E {
    private WebDriver driver;
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void orderHeaderButtonChrome(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.acceptCookie();
        objHomePage.clickHeaderOrder();
        OrderUserInfoPageScooter userInfoPageObj = new OrderUserInfoPageScooter(driver);
        userInfoPageObj.fillUserInfo();
        userInfoPageObj.proceedWithOrder();
        OrderInfoPageScooter orderInfoPageObj = new OrderInfoPageScooter(driver);
        orderInfoPageObj.fillOrderInfo();
        orderInfoPageObj.order();
        orderInfoPageObj.confirmOrder();
        String status = orderInfoPageObj.getOrderStatus();
        Assert.assertEquals("answer begins with the wrong text ", "Заказ оформлен", status);
    }
    @Test
    public void orderMiddleButtonChrome(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.acceptCookie();
        objHomePage.clickMiddleOrder();
        OrderUserInfoPageScooter userInfoPageObj = new OrderUserInfoPageScooter(driver);
        userInfoPageObj.fillUserInfo();
        userInfoPageObj.proceedWithOrder();
        OrderInfoPageScooter orderInfoPageObj = new OrderInfoPageScooter(driver);
        orderInfoPageObj.fillOrderInfo();
        orderInfoPageObj.order();
        orderInfoPageObj.confirmOrder();
        String status = orderInfoPageObj.getOrderStatus();
        Assert.assertEquals("answer begins with the wrong text ", "Заказ оформлен", status);
    }
    @Test
    public void orderHeaderButtonMozilla(){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.acceptCookie();
        objHomePage.clickHeaderOrder();
        OrderUserInfoPageScooter userInfoPageObj = new OrderUserInfoPageScooter(driver);
        userInfoPageObj.fillUserInfo();
        userInfoPageObj.proceedWithOrder();
        OrderInfoPageScooter orderInfoPageObj = new OrderInfoPageScooter(driver);
        orderInfoPageObj.fillOrderInfo();
        orderInfoPageObj.order();
        orderInfoPageObj.confirmOrder();
        String status = orderInfoPageObj.getOrderStatus();
        Assert.assertThat("status begins with the wrong text ",status, startsWith("Заказ оформлен"));
    }
    @Test
    public void orderMiddleButtonMozilla(){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.acceptCookie();
        objHomePage.clickMiddleOrder();
        OrderUserInfoPageScooter userInfoPageObj = new OrderUserInfoPageScooter(driver);
        userInfoPageObj.fillUserInfo();
        userInfoPageObj.proceedWithOrder();
        OrderInfoPageScooter orderInfoPageObj = new OrderInfoPageScooter(driver);
        orderInfoPageObj.fillOrderInfo();
        orderInfoPageObj.order();
        orderInfoPageObj.confirmOrder();
        String status = orderInfoPageObj.getOrderStatus();
        Assert.assertThat("status begins with the wrong text ",status, startsWith("Заказ оформлен"));
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
