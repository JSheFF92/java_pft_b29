package re.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.ContactData;

public class ContactModifictionTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoContactModificate();
        if (! app.getContactHelper().isThereAContactModif()){
            app.getContactHelper().createContact(new ContactData("aaa", "bbb", "zzz", "7877", "mail@list.ru", "[none]"), true);
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData(null, null, null, null, null, null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomeContactPage();
    }
}