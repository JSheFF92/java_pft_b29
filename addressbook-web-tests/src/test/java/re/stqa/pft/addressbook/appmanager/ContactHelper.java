package re.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    public void fillContactForm(ContactData homeWorkData) {
        type(By.name("firstname"), homeWorkData.getName());
        type(By.name("lastname"), homeWorkData.getLastname());
        type(By.name("address"), homeWorkData.getAddress());
        type(By.name("mobile"), homeWorkData.getMobile());
        type(By.name("email"), homeWorkData.getEmail());
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