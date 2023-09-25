package com.ti.uitesting;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class primerScript {
    static WebDriver driver;
    static String URL = "http://uitestingplayground.com/home";
    static String actResult = "";
    static String expResult = "UI Test Automation Playground";

    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);

        actResult = driver.getTitle();

        //imprimir el titulo
        System.out.println(actResult.contains(expResult)?"Primera prueba aprobada, el titulo es "+actResult:"El test falló");

        driver.quit();
    }
}
