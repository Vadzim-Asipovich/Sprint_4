package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderInfoPageScooter {
    private WebDriver driver;
    private By dateInputField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private By durationInputField = By.className("Dropdown-control");
    private By durationDropdownOneDayOption = By.xpath("//div[text()='сутки']");
    private By colorCheckbox = By.id("black");
    private By commentaryInputField = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private By orderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By confirmOrderButton = By.xpath("//button[text()='Да']");
    private By orderConfirmedHeader = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']");

    public OrderInfoPageScooter(WebDriver driver) {
        this.driver = driver;
    }
    private void fillDateInputField(){
        waitOrderInfo();
        driver.findElement(dateInputField).sendKeys(Keys.TAB, Keys.ARROW_RIGHT, Keys.ENTER);
    }
    private void fillDurationInputField(){
        driver.findElement(durationInputField).click();
        driver.findElement(durationDropdownOneDayOption).click();
    }
    private void selectColor(){
        driver.findElement(colorCheckbox).click();
    }
    private void fillCommentaryInputField(){
        driver.findElement(commentaryInputField).sendKeys("commentary");
    }
    public void order(){
        driver.findElement(orderButton).click();
    }
    public void confirmOrder(){
        waitConfirmOrderButton();
        driver.findElement(confirmOrderButton).click();
    }

    private void waitOrderInfo(){
        Duration duration = Duration.ofSeconds(3);
        new WebDriverWait(driver, duration)
                .until(ExpectedConditions.presenceOfElementLocated(dateInputField));
    }
    private void waitConfirmOrderButton(){
        Duration duration = Duration.ofSeconds(3);
        new WebDriverWait(driver, duration)
                .until(ExpectedConditions.presenceOfElementLocated(confirmOrderButton));
    }
    private void waitOrderStatus(){
        Duration duration = Duration.ofSeconds(3);
        new WebDriverWait(driver, duration)
                .until(ExpectedConditions.presenceOfElementLocated(orderConfirmedHeader));
    }

    public String getOrderStatus(){
        waitOrderStatus();
        return driver.findElement(orderConfirmedHeader).getText();
    }

    public void fillOrderInfo(){
        fillDateInputField(); //select the next day
        fillDurationInputField(); //select one day duration
        selectColor(); //select black pearl color
        fillCommentaryInputField(); //sends "commentary" string
    }

}
