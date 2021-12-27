package re.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.ContactData;
import re.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts(){
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {"test1", "lastName 1"});
        list.add(new Object[] {"test2", "lastName 2"});
        list.add(new Object[] {"test3", "lastName 3"});
        return list.iterator();
    }

    @Test(dataProvider = "validContacts")
    public void testContactCreated(String firstName, String lastName) {
            File photo = new File("src/test/resources/stru.png");
            ContactData contact = new ContactData().withFirstname(firstName).withLastname(lastName).withGroup("[none]").withPhoto(photo);
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