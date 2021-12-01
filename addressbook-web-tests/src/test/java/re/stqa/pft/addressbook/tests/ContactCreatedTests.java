package re.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.ContactData;

public class ContactCreatedTests extends TestBase {

    @Test
    public void testContactCreated() {
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("aaa", "bbb", "zzz", "7877", "mail@list.ru"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToGroupPage();
    }
}