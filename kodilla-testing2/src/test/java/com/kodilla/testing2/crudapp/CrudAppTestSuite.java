package com.kodilla.testing2.crudapp;
import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import java.util.Base64;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://mrlemoncoffee.github.io";
    private WebDriver driver;
    private Random generator;
    @BeforeEach
    void initTests(){
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }
    @AfterEach
    void cleanUpAfterTests() {
        driver.close();
    }
    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action, \"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action, \"createTask\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";
        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);
        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);
        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);
        return taskName;
    }
    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();
        while(!driver.findElement(By.xpath("//select[1]")).isDisplayed());
        driver.findElements(
                        By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")).getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);
                    WebElement buttonCreateCard = theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }
    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);
        driverTrello.findElement(By.id("user")).sendKeys("grzkry1@wp.pl");
        driverTrello.findElement(By.id("password")).sendKeys("Kodilla_Pass123");
        WebElement el = driverTrello.findElement(By.id("login"));
        el.submit();
        Thread.sleep(4000);
        driverTrello.findElement(By.id("password")).sendKeys("Kodilla_Pass123");
        driverTrello.findElement(By.id("login-submit")).submit();
        Thread.sleep(4000);
        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//div[@title=\"Kodilla Application\"]")).size() > 0)
                .forEach(WebElement::click);
        Thread.sleep(4000);
        result = driverTrello.findElements(By.xpath("//span")).stream()
                .anyMatch(theSpan -> theSpan.getText().equals(taskName));
        driverTrello.close();
        return result;
    }

    void deleteTaskFromCrudApp(String taskName) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(task -> task.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")).getText().equals(taskName))
                .forEach(theTask -> {
                    WebElement deleteButton = theTask.findElement(By.xpath(".//button[4]"));
                    deleteButton.click();
                });

    }

    boolean checkTaskExistsInCrudApp(String taskName) throws InterruptedException {
        Thread.sleep(2000);
        return driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .noneMatch(task -> task.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")).getText().equals(taskName));
    }

    @Test
    void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
        deleteTaskFromCrudApp(taskName);
        assertTrue(checkTaskExistsInCrudApp(taskName));
    }
}