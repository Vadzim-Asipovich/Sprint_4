package pageObjectModel;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class OrderUserInfoPageScooter {
    private WebDriver driver;
    private By firstNameInputField = By.xpath("//input[@placeholder='* Имя']");
    private By lastNameInputField = By.xpath("//input[@placeholder='* Фамилия']");
    private By addressInputField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private By subwayInputField = By.xpath("//input[@placeholder='* Станция метро']");
    private By phoneNumberInputField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By orderNextButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public OrderUserInfoPageScooter(WebDriver driver) {
        this.driver = driver;
    }
    private void fillFirstNameInputField(String firstName){
        driver.findElement(firstNameInputField).sendKeys(firstName);
    }
    private void fillLastNameInputField(String lastName){
        driver.findElement(lastNameInputField).sendKeys(lastName);
    }
    private void fillAddressInputField(String address){
        driver.findElement(addressInputField).sendKeys(address);
    }
    private void fillSubwayInputField(){
        driver.findElement(subwayInputField).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }
    private void fillPhoneNumberInputField(String phoneNumber){
        driver.findElement(phoneNumberInputField).sendKeys(phoneNumber);
    }
    public void proceedWithOrder(){
        driver.findElement(orderNextButton).click();
    }
    public void fillUserInfo(){
        fillFirstNameInputField("Вадим");
        fillLastNameInputField("Осипович");
        fillAddressInputField("Улица Московская дом 1");
        fillSubwayInputField();
        fillPhoneNumberInputField("48515335911");

    }

}
