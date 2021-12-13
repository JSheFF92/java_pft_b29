package re.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testDeletionContact() {
        app.getNavigationHelper().gotoContactModificate();
        if (!app.getContactHelper().isThereAContactDel()) {
            app.getContactHelper().createContact(new ContactData("aaa", "bbb", "zzz", "7877", "mail@list.ru", "[none]"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size()-1);
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().closeAlert();
        app.getNavigationHelper().gotoContactModificate();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }
}