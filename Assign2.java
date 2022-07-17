package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Assignment 2:Duplicate Lead*
                1. Launch URL "http://leaftaps.com/opentaps/control/login"
			    2. Enter UserName and Password Using Id Locator
			    3. Click on Login Button using Class Locator
			    4. Click on CRM/SFA Link
			    5. Click on Leads Button
			    6. Click on Create Lead 
			    7. Enter CompanyName Field Using id Locator
			    8. Enter FirstName Field Using id Locator
			    9. Enter LastName Field Using id Locator
			    10. Enter FirstName(Local) Field Using id Locator
			    11. Enter Department Field Using any Locator of Your Choice
			    12. Enter Description Field Using any Locator of your choice 
			    13. Enter your email in the E-mail address Field using the locator of your choice
			    14. Select State/Province as NewYork Using Visible Text
			    15. Click on Create Button
                16. Get the Title of Resulting Page(refer the video)  using driver.getTitle()
                17. Click on Duplicate button
                18. Clear the CompanyName Field using .clear() And Enter new CompanyName
                19.Clear the FirstName Field using .clear() And Enter new FirstName
                20.Click on Create Lead Button
                21. Get the Title of Resulting Page(refer the video)  using driver.getTitle() */
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Alti");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Hema");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("G");
		WebElement formdrodown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select select = new Select(formdrodown);
		select.selectByVisibleText("Self Generated");	
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Info Tech");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Creating lead");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("hemaabinaya18@gmali.com");
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select selectState = new Select(state); 
		selectState.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		String title = driver.getTitle();
//		System.out.println(title);
		if(title.equals("View Lead | opentaps CRM"))
		System.out.println("Page title verified successfully and the title is" +title );
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Google");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Abinaya");
		driver.findElement(By.className("smallSubmit")).click();
		String title2 = driver.getTitle();
		if(title2.equals("View Lead | opentaps CRM"))
		System.out.println("Page title verified successfully post duplicate Lead and teh title is" +title );
	}
}
