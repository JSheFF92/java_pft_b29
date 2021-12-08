package re.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testDeletionContact() {
        if (! app.getContactHelper().isThereAContactDel()){
            app.getContactHelper().createContact(new ContactData("aaa", "bbb", "zzz", "7877", "mail@list.ru", "[none]"), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().closeAlert();
        app.getNavigationHelper().gotoContactModificate();
    }
}