package re.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.ContactData;
import re.stqa.pft.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        File photo = new File("src/test/resources/stru.png");
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
        String xml = "";
        String line = reader.readLine();
        while (line != null){
            xml += line;
            line = reader.readLine();
        }
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
        return contacts.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();
    }

    @Test(dataProvider = "validContacts")
    public void testContactCreated(ContactData contact) {
            app.goTo().ContactMDPage();
            Contacts before = app.contact().all();
            app.goTo().ContactPage();
            app.contact().create(contact);
            assertThat(app.contact().count(), equalTo(before.size() + 1));
            Contacts after = app.contact().all();
            assertThat(after, equalTo(
                    before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

    @Test(enabled = false)
    public void testBadContactCreated() {
        app.goTo().ContactMDPage();
        Contacts before = app.contact().all();
        app.goTo().ContactPage();
        ContactData contact = new ContactData().withFirstname("aaa'").withLastname("bbb").withGroup("[none]");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }
}