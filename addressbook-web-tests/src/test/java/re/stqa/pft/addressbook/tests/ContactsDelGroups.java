package re.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.ContactData;
import re.stqa.pft.addressbook.model.Contacts;
import re.stqa.pft.addressbook.model.GroupData;
import re.stqa.pft.addressbook.model.Groups;

import java.util.HashSet;

public class ContactsDelGroups extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().GroupPage();
            app.group().create(new GroupData().withName("test1"));
        }
        if (app.db().contacts().size() == 0) {
            app.goTo().ContactMDPage();
            app.contact().create(new ContactData().withFirstname("C.FirstName").withLastname("C.LastName"));
        }
    }

    @Test
    public void testContactDelGroups() {
        Groups groups = app.db().groups();
        GroupData deletedContact = groups.iterator().next();
        ContactData modifyedContact = deletedContact();
        Contacts before = app.db().contacts();

        app.group().ContactDeletedGroup(deletedContact);
        app.contact().ContactDeletedGroup(modifyedContact.delGroup(groups.iterator().next()));
        Contacts after = app.db().contacts();

        int max = 0;
        for (ContactData c : after){
            if (c.getId() > max){
                max = c.getId();
            }
        }
        modifyedContact.setId(max);
        before.add(modifyedContact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

    public ContactData deletedContact() {
        Contacts contacts = app.db().contacts();
        Groups groups = app.db().groups();
        for (ContactData contact : contacts) {
            if (contact.getGroups().size() == groups.size()) {
                selectedContact();
                ContactData modifyedContact = selectedContact();
                app.contact().ContactInGroup(modifyedContact.inGroup(groups.iterator().next()));
                return contact;
            } else if (contact.getGroups().size() < groups.size()) {
                Contacts contacts2 = app.db().contacts();
                for (ContactData contact2 : contacts2) {
                    selectedContact();
                    ContactData modifyedContact = selectedContact();
                    app.contact().ContactInGroup(modifyedContact.inGroup(groups.iterator().next()));
                    return contact2;
                }
            }
        }
        return contacts.iterator().next();
    }

    public ContactData selectedContact() {
        Contacts contacts = app.db().contacts();
        Groups groups = app.db().groups();
        for (ContactData contact : contacts) {
            if (contact.getGroups().size() < groups.size()) {
                return contact;
            }
        }
        return contacts.iterator().next();
    }
}