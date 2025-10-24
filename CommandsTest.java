import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommandsTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement enableButton = driver.findElement(By.xpath("//*[@id='input-example']/button"));
        enableButton.click();

        WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        if(inputField.isEnabled() && message.getText().equals("It's enabled!")){
            System.out.println("Input field is enabled and text is visible");
        }

        WebElement button = driver.findElement(By.xpath("//*[@id='input-example']/button"));
        if(button.getText().equals("Disable")) {
            System.out.println("Button text changed successfully!");
        }

        inputField.sendKeys("Bootcamp");
        inputField.clear();

        driver.get("http://the-internet.herokuapp.com/drag_and_drop");

        WebElement columnA = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("column-a")));
        WebElement columnB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("column-b")));

        if(columnA.getLocation().getY() == columnB.getLocation().getY()) {
            System.out.println("Columns A and B are aligned successfully");
        }

        driver.quit();
    }
}
