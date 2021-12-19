package re.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactModifictionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().ContactMDPage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withName("bbb").withGroup("[none]"));
        }
    }

    @Test
    public void testContactModification() {
        Set<ContactData> before = app.contact().all();
        ContactData modifyedContact = before.iterator().next();
        ContactData contact = new ContactData().
                withId(modifyedContact.getId()).withName("aaa").withLastname("bbb");
        app.contact().modify(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifyedContact);
        before.add(contact);
        Assert.assertEquals(before, after);
    }


}