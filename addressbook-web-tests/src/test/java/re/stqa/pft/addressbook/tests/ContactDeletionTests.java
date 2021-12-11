package re.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testDeletionContact() {
        app.getNavigationHelper().gotoContactModificate();
        if (!app.getContactHelper().isThereAContactDel()) {
            app.getContactHelper().createContact(new ContactData("aaa", "bbb", "zzz", "7877", "mail@list.ru", "[none]"));
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact(before-1);
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().closeAlert();
        app.getNavigationHelper().gotoContactModificate();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);
    }
}