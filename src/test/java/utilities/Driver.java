package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    /*
    POM'da Driver icin TestBase Class'ına extends etmek yerine
    Driver Class'ından static method'lar kullanarak driver olusturup,
    ilgili ayarlarin yapilmasi ve en sonda driver'İn kapatilmasi
    tercih edilmistir(Neden Diye sormayin:))!!)

    POM'da Driver class'indaki getDriver()'in obje olusturularak kullanilmasini engellemek icin
    Singleton pattern kullanimi benimsenmistir.

    Singleton Pattern: tekli kullanim, bir class'in farkli class'lardan
    obje olusturarak kullanimini engellemek icin  kullanilir

    Bunu saglamak icin yapmamiz gerekn sey oldukca basittir.
    obje olusturmak icin kullanilan constructor'ı private yaptiginizda
    baska class'larda Driver class'indan obje olusturulmasi mumkun OLAMAZ.


     */

    private Driver(){
    }

    static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getProperty("browser")) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;


                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }



        }
        return driver;

    }

    public static void closeDriver() {
        if (driver != null) {//driver'a deger atanmıssa
            driver.close();
        }
        driver = null;
    }


}
