package re.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhonesAddressEmail extends TestBase {

    @Test
    public void testContactPhonesAddressEmail() {
        app.goTo().ContactMDPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));

        assertThat(contact.getAllEmails(), equalTo(mergeMails(contactInfoFromEditForm)));

        assertThat(contact.getAddress(), equalTo(mergeAddress(contactInfoFromEditForm)));
    }


    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(), contact.getSecondPhone())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactPhonesAddressEmail::cleanedPhone)
                .collect(Collectors.joining("\n"));
    }

    private String mergeMails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactPhonesAddressEmail::cleanedEmail)
                .collect(Collectors.joining("\n"));
    }

    private String mergeAddress(ContactData contact) {
        return Arrays.asList(contact.getAddress())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactPhonesAddressEmail::cleanedAddress)
                .collect(Collectors.joining("\n"));
    }


    public static String cleanedPhone(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[- ()] ", "");
    }

    public static String cleanedEmail(String email) {
        return email.trim().replaceAll(" +", " ");
    }

    public static String cleanedAddress(String address) {
        return address.trim().replaceAll(" +", " ");
    }
}