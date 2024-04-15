package treinamentoINMSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;



public class TestePortal {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://practice.automationtesting.in/my-account/");
		
		driver.findElement(By.name("username")).sendKeys("larissa.silva@teste.com");
		
		driver.findElement(By.id("password")).sendKeys("escandinava1234");
		
		driver.findElement(By.name("login")).click();
		
		//driver.quit();

	}
}
