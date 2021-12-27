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
        File photo = new File("src/test/resources/stru.png");
        list.add(new Object[] {new ContactData().withFirstname("test1").withLastname("lastName1").withGroup("[none]").withPhoto(photo)});
        list.add(new Object[] {new ContactData().withFirstname("test2").withLastname("lastName2").withGroup("[none]").withPhoto(photo)});
        list.add(new Object[] {new ContactData().withFirstname("test3").withLastname("lastName3").withGroup("[none]").withPhoto(photo)});
        return list.iterator();
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