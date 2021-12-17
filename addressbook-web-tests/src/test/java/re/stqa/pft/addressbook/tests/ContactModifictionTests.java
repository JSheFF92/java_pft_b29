package re.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModifictionTests extends TestBase {

    @Test(enabled = false)
    public void testContactModification() {
        app.getNavigationHelper().gotoContactModificate();
        if (!app.getContactHelper().isThereAContactModif()) {
            app.getContactHelper().createContact(new ContactData("aaa", "bbb", "zzz", "7877", "mail@list.ru", "[none]"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().initContactModification();
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "aaa", "bbb", null, null, null, null);
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomeContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}