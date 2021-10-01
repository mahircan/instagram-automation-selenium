import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {

    WebDriver driver;

    String Base_Url = "https://www.instagram.com/";

    By userNameLocator = new By.ByCssSelector("input[name='username']");
    By passwordLocator = new By.ByCssSelector("input[name='password']");
    By submitButtonLocator = new By.ByCssSelector("button[type='submit']");
    By instagramLogoLocator = By.className("s4Iyt");
    By profileNameLocator = By.className("nZSzr");
    By postLocator = By.className("_9AhH0");

    By htmlTag = By.tagName("html");
    By likeButtonLocator = new By.ByCssSelector("span.fr66n");
    By postCountLocator =By.className("g47SY");

    public App(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(Base_Url);
        driver.manage().window().maximize();
    }

    public void loginWith(String userName, String password){
        waitFor(userNameLocator); // username 'a basabilmeyi 5 saniye bekle
        driver.findElement(userNameLocator).sendKeys(userName);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(submitButtonLocator).click();

    }
    public void navigateToProfile(String profileName){
         waitFor(instagramLogoLocator);
        driver.navigate().to(Base_Url.concat(profileName)); //profile gitmesi için kullanıyoruz

    }
    public void clickFirstPost(){
        waitFor(profileNameLocator);
        driver.findElements(postLocator).get(0).click();
    }

    public void likeAllPost(){
        int count = getPostCount();

        while (count > 0){
            waitFor(likeButtonLocator);
            driver.findElement(likeButtonLocator).click();
            driver.findElement(htmlTag).sendKeys(Keys.ARROW_RIGHT);
            count --;
        }

    }
    private int getPostCount(){
        String count = driver.findElement(postCountLocator).getText();
        return Integer.parseInt(count);
    }


    public void waitFor(By locator){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}
