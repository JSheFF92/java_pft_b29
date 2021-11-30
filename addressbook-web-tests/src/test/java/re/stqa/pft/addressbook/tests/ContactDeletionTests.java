package re.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testDeletionContact() {
        app.getContactGroupHelper().deleteSelectedContacts();
        app.getContactGroupHelper().closeAlert();
        app.getNavigationHelper().gotoContactModificate();
    }
}