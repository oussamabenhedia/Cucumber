package stepsdefinition;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginSteps {
	WebDriver driver = new FirefoxDriver();

		

	@Given("^user connect to expertest website$")
	public void user_connect_to_expertest_website() throws Throwable {
		
			driver.get("http://expertest.tn");
			driver.manage().window().maximize();
			System.out.println("je suis bien sur le site expertest");

	}

	@Given("^user survol the Espace abonné button$")
	public void user_survol_the_Espace_abonné_button() throws Throwable {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[@class='active']"))).perform();	
		System.out.println("survol réussi");

	}

	@Given("^user click on the Mon compte button$")
	public void user_click_on_the_Mon_compte_button() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='http://www.expertest.tn/mon-compte/']")).click();
		System.out.println("un clic sur le bouton mon compte est réussi");

	}

	@Given("^user enters a valid email adress$")
	public void user_enters_a_valid_email_adress() throws Throwable {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("saida.ayari.me@gmail.com");
		System.out.println("mon email est bien saisi");

	}

	@Given("^user enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("soft.2019");
		System.out.println("mon mot de passe est bien saisi");

	}

	@When("^user click on the Identification button$")
	public void user_click_on_the_Identification_button() throws Throwable {
		driver.findElement(By.xpath("//button[@value='Identification']")).click();
		System.out.println("un clic bien réussi");
        
	}

	@Then("^user should be taken to the successful login page$")
	public void user_should_be_taken_to_the_successful_login_page() throws Throwable {
		Thread.sleep(3000);
	    WebElement TableauDeBord = driver.findElement(By.xpath("//a[contains(text(),'Tableau de bord')]"));
	    Assert.assertEquals(true, TableauDeBord.isDisplayed());
		System.out.println("je suis connecté à mon espace");
		driver.quit();
	}

}
