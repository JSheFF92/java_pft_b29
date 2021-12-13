package re.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreated() {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().createContact(new ContactData("aaa", "bbb", "zzz", "7877", "mail@list.ru", "[none]"));
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }
}