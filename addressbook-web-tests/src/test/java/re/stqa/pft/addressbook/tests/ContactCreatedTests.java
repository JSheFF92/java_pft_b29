package re.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.ContactData;

public class ContactCreatedTests extends TestBase {


    @Test
    public void testCaseHomeWork() throws Exception {
        app.getNavigationHelper().gotoGroupPageContact();
        app.getGroupHelper().initGroupCreation("firstname");
        app.getGroupHelper().fillGroupForm(new ContactData("aaa", "bbb", "zzz", "7877", "mail@list.ru"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }
}