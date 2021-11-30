package re.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.ContactData;

public class ContactCreatedTests extends TestBase {

    @Test
    public void testContactCreated() {
        app.getNavigationHelper().gotoContactPage();
        app.getContactGroupHelper().initContactCreation();
        app.getContactGroupHelper().fillGroupForm(new ContactData("aaa", "bbb", "zzz", "7877", "mail@list.ru"));
        app.getContactGroupHelper().submitGroupCreation();
        app.getContactGroupHelper().returnToGroupPage();
    }
}