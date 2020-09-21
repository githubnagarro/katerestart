package checkrestart;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class RunRestartTests {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "D:\\Kronos\\KATERestart\\geckodriver-v0.27.0-win64\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(false);
		WebDriver driver= new FirefoxDriver(options);
		
		driver.manage().window().maximize();
		driver.get("http://tap-sqkatelinux.int.kronos.com:8080");
		System.out.println("Here");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='log in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("j_username")).sendKeys("rahul.jaiswal@kronos.com");
		driver.findElement(By.name("j_password")).sendKeys("kronos@2020");
		driver.findElement(By.name("Submit")).click();
		driver.findElement(By.id("search-box")).sendKeys("ActiveThreads");
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(6000);
		Boolean check=driver.findElement(By.linkText("Configure")).isDisplayed();
		if(check==true)
			System.out.println("Job Configure Link is available");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//table[@class='pane stripped']//tr[@class='build-row multi-line overflow-checked'][1]//a")).click();
		Thread.sleep(5000);
		Boolean check2=driver.findElement(By.linkText("Environment Variables")).isDisplayed();
		if(check2==true)
			System.out.println("Environment Variables is available for the builds");
		
		Boolean check3=driver.findElement(By.linkText("Parameters")).isDisplayed();
		if(check3==true)
			System.out.println("Parameters is available for the builds");
		
			
	
		
		
		
		
		
		
		
		
		

	}

}
