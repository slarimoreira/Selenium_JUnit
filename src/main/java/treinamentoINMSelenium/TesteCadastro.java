package treinamentoINMSelenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TesteCadastro {

	public WebDriver driver;

	@Before
	public void site() {
		driver = new ChromeDriver();

		driver.get("https://practice.automationtesting.in/my-account/");
	}

	@Test
    public void validaLoginOk() {

        driver.findElement(By.name("username")).sendKeys("weswes@teste.com");
        driver.findElement(By.id("password")).sendKeys("_teste_1234");
        driver.findElement(By.name("login")).click();

        Assert.assertEquals("Sign out",
                driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a")).getText());
    }

	@Test
	public void passwordError() {

		driver.findElement(By.name("username")).sendKeys("weswes@teste.com");
		driver.findElement(By.id("password")).sendKeys("teste_1234");
		driver.findElement(By.name("login")).click();

		Assert.assertTrue(driver.findElement(By.className("woocommerce-error")).getText()
				.contains(" The password you entered for the username "));
	}

	@Test
	public void emailError() {

		driver.findElement(By.name("username")).sendKeys("wesws@teste.com");
		driver.findElement(By.id("password")).sendKeys("teste_1234");
		driver.findElement(By.name("login")).click();

		Assert.assertTrue(driver.findElement(By.className("woocommerce-error")).getText()
				.contains(" A user could not be found with this email address."));
	}

	@After
	public void exit() {
		driver.quit();
	}
}