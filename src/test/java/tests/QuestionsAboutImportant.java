package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjectModel.HomePageScooter;

import static org.hamcrest.CoreMatchers.startsWith;

@RunWith(Parameterized.class)
public class QuestionsAboutImportant {
    private final int questionNumber;
    private final String expectedAnswer;

    private WebDriver driver;

    public QuestionsAboutImportant(int questionNumber, String expectedAnswer) {
        this.questionNumber = questionNumber;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestionData() {
        return new Object[][] {
                { 0, "Сутки — 400 рублей."},
                { 1, "Пока что у нас так:"},
                { 2, "Допустим, вы оформляете заказ"},
                { 3, "Только начиная с завтрашнего дня."},
                { 4, "Пока что нет!"},
                { 5, "Самокат приезжает к вам с полной зарядкой."},
                { 6, "Да, пока самокат не привезли."},
                { 7, "Да, обязательно."},
        };
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void checkAnswers(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.acceptCookie();
        objHomePage.clickQuestion(questionNumber);
        String answer = objHomePage.getAnswer(questionNumber);
        Assert.assertThat("answer begins with the wrong text ",answer, startsWith(expectedAnswer));
        System.out.println(answer);
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
