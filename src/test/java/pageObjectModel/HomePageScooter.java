package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageScooter {
    private WebDriver driver;
    private By acceptCookieButton = By.id("rcc-confirm-button");
    private By headerOrderButton = By.xpath("//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    private By thirdPartOrderButton = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }
    public void clickQuestion(int questionNumber){
        By question = By.id("accordion__heading-" + questionNumber);
        driver.findElement(question).click();
    }
    public String getAnswer(int questionNumber){
        By answer = By.id("accordion__panel-" + questionNumber);
        waitForAnswer(answer);
        return driver.findElement(answer).getText();
    }
    public void acceptCookie(){
        driver.findElement(acceptCookieButton).click();
    }
    private void waitForAnswer(By question){
        Duration duration = Duration.ofSeconds(1);
        new WebDriverWait(driver, duration)
                .until(ExpectedConditions.presenceOfElementLocated(question));
    }
    private void waitForMiddleOrderButton(){
        Duration duration = Duration.ofSeconds(30);
        new WebDriverWait(driver, duration)
                .until(ExpectedConditions.elementToBeClickable(thirdPartOrderButton));
    }
    public void clickHeaderOrder(){
        driver.findElement(headerOrderButton).click();
    }
    public void clickMiddleOrder(){
        driver.findElement(thirdPartOrderButton).click();
    }
}

