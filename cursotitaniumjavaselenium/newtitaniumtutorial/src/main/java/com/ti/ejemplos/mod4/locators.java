package com.ti.ejemplos.mod4;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators {
    static WebDriver driver;
    static String URL = "http://uitestingplayground.com/home";
    static String sendText = "your peanut butter and your tears";
    static String actualResult = "";
    static String actualResult2 = "";

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);

        driver.findElement(By.xpath("//*[@href = '/textinput']")).click();
        driver.findElement(By.id("newButtonName")).sendKeys(sendText);
        driver.findElement(By.id("updatingButton")).click();

        actualResult = driver.findElement(By.id("updatingButton")).getText();
        System.out.println(actualResult.contains(sendText)?"Button was clicking and text is the expected": "FAILED! text is "+actualResult);

        driver.findElement(By.id("newButtonName")).clear();
        driver.findElement(By.id("newButtonName")).sendKeys("a different thing to sendText");
        driver.findElement(By.id("updatingButton")).click();
        actualResult2 = driver.findElement(By.id("updatingButton")).getText();
        System.out.println(actualResult2.contains("a different thing to sendText")?"Button was clicking and text is the expected": "FAILED! text is "+actualResult2);


        driver.quit();
    }
}
