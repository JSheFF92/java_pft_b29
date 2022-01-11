package re.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.ContactData;
import re.stqa.pft.addressbook.model.Contacts;
import re.stqa.pft.addressbook.model.GroupData;
import re.stqa.pft.addressbook.model.Groups;

import java.util.HashSet;

public class ContactsInGroups extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().GroupPage();
            app.group().create(new GroupData().withName("test1"));
        }
        if (app.db().contacts().size() == 0) {
            app.goTo().ContactMDPage();
            app.contact().create(new ContactData().withFirstname("C.FirstName").withLastname("C.LastName")
                    .withFirstname("C.Address"));
        }
    }

    @Test
    public void testContactInGroups() {
        Contacts before = app.db().contacts();
        Groups groups = app.db().groups();
        ContactData modifyedContact = selectedContact();
        app.contact().ContactInGroup(modifyedContact.inGroup(groups.iterator().next()));
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




/*        Groups before = app.db().groups();
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.db().groups();
        assertThat(after, equalTo(before));*/
    }

    public ContactData selectedContact() {
        Contacts contacts = app.db().contacts();
        Groups groups = app.db().groups();
        for (ContactData contact : contacts) {
            if (contact.getGroups().size() < groups.size()) {
                return contact;
            } else if (contact.getGroups().size() > groups.size()) {
                Contacts contacts2 = app.db().contacts();
                for (ContactData contact2 : contacts2) {
                    selectedContact();
                    ContactData modifyedContact = selectedContact();
                    app.contact().ContactInGroup(modifyedContact.inGroup(groups.iterator().next()));
                    return contact2;
                }
            } else if ((contact.getGroups().size() == groups.size())) {
                app.goTo().GroupPage();
                app.group().create(new GroupData().withName("G.Name").withHeader("G.Header").withFooter("G.Footer"));
                app.goTo().ContactMDPage();
                selectedContact();
                ContactData modifyedContact = selectedContact();
                app.contact().ContactInGroup(modifyedContact.inGroup(groups.iterator().next()));
            }
        }
        return contacts.iterator().next();
    }
}