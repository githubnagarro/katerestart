package checkrestart;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

public class RunRestartTests {
	
	private WebDriver driver = null;
    @BeforeTest
	public void setUp() throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "/usr/local/geckodriver");
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
		 driver= new FirefoxDriver(options);
		
		 
		driver.manage().window().maximize();
		driver.get("http://tap-sqkatelinux.int.kronos.com:8080");
		System.out.println("Here");
		Thread.sleep(5000);
		
		
	}
    
    @Test
    public void runTests() throws InterruptedException, AWTException {
    	System.out.println("In Test");
		driver.findElement(By.xpath("//*[text()='log in']")).click();
		System.out.println("Login CLicked");
		Thread.sleep(2000);
		driver.findElement(By.id("j_username")).sendKeys("rahul.jaiswal@kronos.com");
		System.out.println("User Name entered");
		driver.findElement(By.name("j_password")).sendKeys("kronos@2020");
		System.out.println("Password Entered");
		driver.findElement(By.name("Submit")).click();
		System.out.println("Submit btn clicked");
		Thread.sleep(4000);
		WebElement ele=driver.findElement(By.id("search-box"));
	        ele.sendKeys("ActiveThreads");
		System.out.println("Search box key entered");
		//Robot robo = new Robot();
		//robo.keyPress(KeyEvent.VK_ENTER);
		//robo.keyRelease(KeyEvent.VK_ENTER);
	    ele.sendKeys("[Enter]");
	    ele.sendKeys("[Enter]");
		
		System.out.println("Enter Pressed");
		
		
		Thread.sleep(6000);
		
		WebElement check=driver.findElements(By.xpath("//a[@class='task-link']")).get(6);
		if(check!=null)
			System.out.println("Job Configure Link is available");
		Thread.sleep(2000);
		
		
		
		//driver.findElements(By.xpath("//table[@class='pane stripped']//tr[@class='build-row multi-line overflow-checked']//a")).get(0).click();
		driver.navigate().refresh();
	    Thread.sleep(15000);
	    
		WebElement eleBuild=driver.findElement(By.xpath("//a[text()='#11030']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(eleBuild);
		actions.perform();
		eleBuild.click();
		System.out.println("Build Number CLicked");
		Thread.sleep(5000);
		WebElement check2=driver.findElement(By.xpath("//a[@class='task-link' and @title='Environment Variables']"));
		if(check2!=null)
			System.out.println("Environment Variables is available for the builds");
		
		WebElement check3=driver.findElement(By.xpath("//a[@class='task-link' and @title='Parameters']"));
		if(check3!=null)
			System.out.println("Parameters is available for the builds");
		
    }
		
			
	
		
		
		
		
		
		
		
		
		

	}


