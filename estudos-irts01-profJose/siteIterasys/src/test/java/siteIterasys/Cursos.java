// 1 - Package++.
package siteIterasys;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
//2 - Libraries
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// 3 - Classes
public class Cursos {
	// 3.1  Characteristics called Attributes
	String url; //adress site
	WebDriver driver; //adress selenium webdriver
	
	// 3.2 Methods and Functions
	@BeforeEach
public void iniciar() {
	url = "https://www.iterasys.com.br";
	System.setProperty("webdriver.chrome.driver",
	"C:\\Users\\BRAINIAC\\estudos-irts01\\siteIterasys\\drivers\\chrome\\83\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
	driver.manage().window().maximize();

	
	}
	
	@AfterEach
	public void finalizar() {
		driver.quit();
	}
	
	@Test
	public void consultarCurso() {
		// Home
		driver.get(url);	//Open browser url
		driver.findElement(By.id("searchtext")).clear();
		driver.findElement(By.id("searchtext")).sendKeys(Keys.chord("Mantis"));
		// Screenshot
		driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
		// Menu courses result
		driver.findElement(By.cssSelector("span.comprar")).click();
		
		// Shopping Cart
		// Espected result
		String titulo = "Mantis";
		String preco = "R$ 49,99";
		
		//assertEquals(resultadoEsperado, resultadoAtual)
		assertEquals(titulo, driver.findElement(By.cssSelector("span.item-title")).getText());
		asserEquals(preco, driver.findElement(By.cssSelector("span.new-price")).getText());
	
	}

	private void asserEquals(String preco, String text) {
		// TODO Auto-generated method stub
		
	}


}

