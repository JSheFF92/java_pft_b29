package re.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhonesAddressEmail extends TestBase{

    @Test
    public void testContactPhonesAddressEmail(){
        app.goTo().ContactMDPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getHomePhone(), equalTo(cleanedPhone(contactInfoFromEditForm.getHomePhone())));
        assertThat(contact.getMobilePhone(), equalTo(cleanedPhone(contactInfoFromEditForm.getMobilePhone())));
        assertThat(contact.getWorkPhone(), equalTo(cleanedPhone(contactInfoFromEditForm.getWorkPhone())));

/*
        assertThat(contact.getEmail(), equalTo(cleanedEmail(contactInfoFromEditForm.getEmail())));
        assertThat(contact.getEmail2(), equalTo(cleanedEmail(contactInfoFromEditForm.getEmail2())));
        assertThat(contact.getEmail3(), equalTo(cleanedEmail(contactInfoFromEditForm.getEmail3())));
*/

        assertThat(contact.getAddress(), equalTo(cleanedAddress(contactInfoFromEditForm.getAddress())));
    }
    public String cleanedPhone (String phone){
        return phone.replaceAll("\\s","").replaceAll("[- ()] ","");
    }

    public String cleanedEmail (String email){
        return email.replaceAll("\\s","").replaceAll("","");
    }

    public String cleanedAddress (String address){
        return address.replaceAll("\\s","");
    }
}