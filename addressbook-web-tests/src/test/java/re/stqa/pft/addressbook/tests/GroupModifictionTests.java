package re.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.GroupData;

public class GroupModifictionTests extends TestBase{
    @Test
    public void testGroupModification (){
        app.getNavigationHelper().gotoGroupPage();
        app.getContactGroupHelper().selectGroup();
        app.getContactGroupHelper().initGroupModification();
        app.getContactGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
        app.getContactGroupHelper().submitGroupModification();
        app.getContactGroupHelper().returnToGroupPage();
    }
}
