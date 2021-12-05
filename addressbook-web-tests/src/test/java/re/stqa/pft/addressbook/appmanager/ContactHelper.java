package re.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import re.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void initContactCreation() {
        click(By.name("firstname"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type1(By.name("firstname"), contactData.getName());
        type1(By.name("lastname"), contactData.getLastname());
        type1(By.name("address"), contactData.getAddress());
        type1(By.name("mobile"), contactData.getMobile());
        type1(By.name("email"), contactData.getEmail());


        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void selectContact() {
        click(By.xpath("//table[@id='maintable']//input"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void returnToGroupPage() {
        click(By.linkText("home"));
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void closeAlert() {
        wd.switchTo().alert().accept();
    }
}