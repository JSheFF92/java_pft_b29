package re.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.GroupData;


public class GroupDelitionTests extends TestBase {

    @Test
    public void testGroupDelition() {
        app.getNavigationHelper().gotoGroupPage();
            if (! app.getGroupHelper().isThereAGroup()){
                app.getGroupHelper().createGroup(new GroupData("test1", null, null));
            }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToHomeGroupPage();
    }
}