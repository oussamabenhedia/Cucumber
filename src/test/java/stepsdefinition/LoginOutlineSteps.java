package stepsdefinition;


import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginOutlineSteps {
WebDriver driver= new FirefoxDriver();
	

	@Given("^user navigates to expertest website$")
	public void user_navigates_to_expertest_website() throws Throwable {
	  driver.get("https://www.expertest.tn/");
	  driver.manage().window().maximize();
	 
	  System.out.println("la page est bien affichée");
	}

	@Given("^user fly over on the Espace abonné button$")
	public void user_fly_over_on_the_Espace_abonné_button() throws Throwable {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[@class='active']"))).perform();
		System.out.println("Un survole bien réussie");

	}

	@Given("^user clicks on the Mon compte button$")
	public void user_clicks_on_the_Mon_compte_button() throws Throwable {
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[@href='http://www.expertest.tn/mon-compte/']")).click();
		System.out.println("le bouton Mon compte est très bien cliqué");

	}

	@Given("^user enters an \"([^\"]*)\" adress$")
	public void user_enters_an_adress(String email) throws Throwable {
		for (String windHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windHandle);
		}
		//send email keys
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(email);
		
		System.out.println("l'adrese email est bien saisie" + email);
		
	}

	@Given("^user enters a \"([^\"]*)\"$")
	public void user_enters_a(String password) throws Throwable {
		for (String windHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windHandle);
		}
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);;
		System.out.println("le mot de passe est bien saisi" + password);
	}

	@When("^user clicks on the Identification button$")
	public void user_clicks_on_the_Identification_button() throws Throwable {
	  driver.findElement(By.xpath("//button[@value='Identification']")).click();
	  
	  System.out.println("le bouton identification est bien cliqué");
	}
	
	@Then("^user should receive a message \"([^\"]*)\"$")
	public void user_should_receive_a_message(String message) throws Throwable {
		
		
		System.out.println("Message" + message);
		System.out.println("is Present" + isTextOnPagePresent (message));
		AssertJUnit.assertEquals(true, isTextOnPagePresent (message)); 
		     
		driver.quit();
		
	}
	
	public boolean isTextOnPagePresent(String text) {
		
	    WebElement body = driver.findElement(By.tagName("body"));
	    String bodyText = body.getText();
	    System.out.println("bodyText"  + bodyText);
	    
	    return bodyText.contains(text);
	    
		
	}
	
}
