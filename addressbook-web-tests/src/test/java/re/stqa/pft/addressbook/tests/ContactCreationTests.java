package re.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.ContactData;
import re.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreated() {
        app.goTo().ContactMDPage();
        Contacts before = app.contact().all();
        app.goTo().ContactPage();
        File photo = new File("src/test/resources/stru.png");
        ContactData contact = new ContactData().withFirstname("aaa").withLastname("bbb").withGroup("[none]").withPhoto(photo);
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