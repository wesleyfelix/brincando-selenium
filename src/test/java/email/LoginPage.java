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
		
//	--- este timeout ainda não funcionou	this.browser.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		this.browser.findElement(By.name("loginfmt")).sendKeys(email);
		   
		this.browser.findElement(By.id("idSIButton9")).click();
	    this.browser.findElement(By.name("passwd")).sendKeys(senha);
//	    entrar = this.browser.findElement(By.xpath("//input[@value='Entrar']"));
	   
//	    WebElement teste = new WebDriverWait(browser, 200).until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9")));
//	    teste.click();
	    
	    
	    
	    Thread.sleep(5000);
	    
	    
	    
	    
	    
	    this.browser.findElement(By.id("idSIButton9")).click();
	    this.browser.findElement(By.id("idBtn_Back")).click();

	}


	public boolean seLogou() {
		return this.browser.getCurrentUrl().equals("https://outlook.live.com/mail/0/inbox");
	}
	
	
}
