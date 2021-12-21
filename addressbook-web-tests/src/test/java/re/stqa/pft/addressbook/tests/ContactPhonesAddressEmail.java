package re.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.ContactData;

public class ContactPhonesAddressEmail extends TestBase{

    @Test
    public void testContactPhonesAddressEmail(){
        app.goTo().ContactMDPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    }
}