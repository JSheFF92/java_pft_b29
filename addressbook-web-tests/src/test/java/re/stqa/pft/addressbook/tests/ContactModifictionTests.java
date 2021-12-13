package re.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactModifictionTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoContactModificate();
        if (!app.getContactHelper().isThereAContactModif()) {
            app.getContactHelper().createContact(new ContactData("aaa", "bbb", "zzz", "7877", "mail@list.ru", "[none]"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size()-1);
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData(null, null, null, null, null, null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomeContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
    }
}