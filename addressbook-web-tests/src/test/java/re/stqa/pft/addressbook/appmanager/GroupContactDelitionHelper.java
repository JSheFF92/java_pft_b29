package re.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import re.stqa.pft.addressbook.model.ContactData;
import re.stqa.pft.addressbook.model.GroupData;

public class GroupContactDelitionHelper extends HelperBase {

    public GroupContactDelitionHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("groups"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void initContactCreation() {
        click(By.name("firstname"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void fillGroupForm(ContactData homeWorkData) {
        type(By.name("firstname"), homeWorkData.getName());
        type(By.name("lastname"), homeWorkData.getLastname());
        type(By.name("address"), homeWorkData.getAddress());
        type(By.name("mobile"), homeWorkData.getMobile());
        type(By.name("email"), homeWorkData.getEmail());
    }


}
