package re.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.ContactData;

public class ContactModifictionTests extends TestBase{
    @Test
    public void testContactModification (){
        app.getNavigationHelper().gotoContactModificate();
        app.getContactGroupHelper().initContactModification();
        app.getContactGroupHelper().fillGroupForm(new ContactData("aaa", "bbb", "zzz", "7877", "mail@list.ru"));
        app.getContactGroupHelper().submitContactModification();
        app.getContactGroupHelper().returnToGroupPage();
    }
}