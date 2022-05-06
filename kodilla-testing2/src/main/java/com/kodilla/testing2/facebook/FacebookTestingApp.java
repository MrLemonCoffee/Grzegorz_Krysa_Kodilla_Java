package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FacebookTestingApp {
    public static final String XPATH_COOKIES = "//button[@class=\"_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy\"]";
    public static final String XPATH_ACCOUNT = "//a[contains(@class, \"_4jy0 _6lti _4jy6 _4jy2 selected _51sy\")]";
    public static final String XPATH_FILL_DAY = "//select[contains(@name, \"birthday_day\")]";
    public static final String XPATH_FILL_MONTH = "//select[contains(@name, \"birthday_month\")]";
    public static final String XPATH_FILL_YEAR = "//select[contains(@name, \"birthday_year\")]";



    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement acceptCookies = driver.findElement(By.xpath(XPATH_COOKIES));
        acceptCookies.click();

        WebElement createAccount = driver.findElement(By.xpath(XPATH_ACCOUNT));
        createAccount.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement selectDayComboBox = driver.findElement(By.xpath(XPATH_FILL_DAY));
        Select selectDay = new Select(selectDayComboBox);
        selectDay.selectByVisibleText("30");

        WebElement selectMonthComboBox = driver.findElement(By.xpath(XPATH_FILL_MONTH));
        Select selectMonth = new Select(selectMonthComboBox);
        selectMonth.selectByVisibleText("cze");

        WebElement selectYearComboBox = driver.findElement(By.xpath(XPATH_FILL_YEAR));
        Select selectYear = new Select(selectYearComboBox);
        selectYear.selectByVisibleText("1991");
    }
}