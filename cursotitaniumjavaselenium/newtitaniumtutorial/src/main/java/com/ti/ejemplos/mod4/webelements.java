package com.ti.ejemplos.mod4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webelements {
    static WebDriver driver;
    static String URL = "http://uitestingplayground.com/home";
    static String sendText = "your peanut butter and your tears";
    static String actualResult = "";
    static String actualResult2 = "";

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);

        WebElement textinput = driver.findElement(By.xpath("//*[@href='/textinput']"));
        textinput.click();

        WebElement textbox = driver.findElement(By.id("newButtonName"));
        textbox.clear();
        textbox.sendKeys(sendText);

        WebElement updatingButton = driver.findElement(By.id("updatingButton"));
        updatingButton.click();

        WebElement updatedButton = driver.findElement(By.id("updatingButton"));
        actualResult = updatedButton.getText();
        System.out.println(actualResult.contains(sendText)?"Button was clicking and text is the expected": "FAILED! text is "+actualResult);

        textbox.clear();
        textbox.sendKeys("a different thing to sendText");

        updatingButton.click();
        actualResult2 = updatingButton.getText();
        System.out.println(actualResult2.contains("a different thing to sendText")?"Button was clicking and text is the expected": "FAILED! text is "+actualResult2);


        driver.quit();
    }
}
