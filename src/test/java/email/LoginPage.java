package email;


import java.time.Clock;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import PageObject.PageObject;



public class LoginPage extends PageObject{
	
private static final String URL_LOGIN = "https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=13&ct=1637089048&rver=7.0.6737.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26RpsCsrfState%3d2e23c3a8-3811-50f4-e7dd-889c925b8653&id=292841&aadredir=1&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=90015";
private static final String URL_CAIXA_DE_ENTRADA = "https://outlook.live.com/mail/0/inbox";	
	
	public LoginPage() {
		super(null);
		browser.get(URL_LOGIN);
		
	}
	

	public void preencheFormularioDeLogin(String email, String senha) throws InterruptedException {
		
		this.browser.findElement(By.name("loginfmt")).sendKeys(email);
		this.browser.findElement(By.id("idSIButton9")).click();
	    this.browser.findElement(By.name("passwd")).sendKeys(senha);
//	 exemplo de xpath com valor do campo    entrar = this.browser.findElement(By.xpath("//input[@value='Entrar']"));
	   
//	    this.browser.findElement(By.id("idSIButton9")).click();
	    System.out.println(this.browser.findElement(By.id("idSIButton9")).isDisplayed());
	    elementoIdIsVisible("idSIButton9");
       this.browser.findElement(By.id("idSIButton9")).click();
       System.out.println(this.browser.findElement(By.id("idBtn_Back")).isDisplayed());
       elementoIdIsVisible("idBtn_Back");
	   this.browser.findElement(By.id("idBtn_Back")).click();
	   
	    
	}


	public boolean seLogou() {
		return this.browser.getCurrentUrl().equals("https://outlook.live.com/mail/0/inbox");
	}
	
	public boolean elementoIdIsVisible(String id) throws InterruptedException {

		int maxIntervalos = 3 /* se não achar o elemento, aguardar até 2,5 segundos */ ;
		int intervalo = this.browser.findElement(By.id(id)).isDisplayed() ? maxIntervalos
				: 0;
		if(intervalo != maxIntervalos) {
			Thread.sleep(1000); /* tempo em milisegundos*/
		}

		try {
			while (this.browser.findElement(By.id(id)).isDisplayed() && intervalo < maxIntervalos) {
				intervalo++;
				Thread.sleep(500);
			}
			return true;
		} catch (Exception e) {
			return false;
		}

	}
}
