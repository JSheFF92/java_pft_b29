package re.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.ContactData;
import re.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModifictionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws IOException {

        Properties properties = new Properties();
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        if (app.db().contacts().size() == 0) {
            app.goTo().ContactMDPage();
            app.contact().create(new ContactData().withFirstname(properties.getProperty("C.FirstName")).withGroup(1));
        }
    }

    @Test
    public void testContactModification() throws IOException {
        Properties properties = new Properties();
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        Contacts before = app.db().contacts();
        ContactData modifyedContact = before.iterator().next();
        ContactData contact = new ContactData().
                withId(modifyedContact.getId()).withFirstname(properties.getProperty("C.FirstName")).withLastname(properties.getProperty("C.LastName"))
                .withAddress(properties.getProperty("C.Address"));
        app.goTo().ContactMDPage();
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.withOut(modifyedContact).withAdded(contact)));
        verifyContactListInUI();
    }
}