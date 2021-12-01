package re.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.GroupData;

public class GroupCreatedTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }
}