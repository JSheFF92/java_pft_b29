package re.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import re.stqa.pft.addressbook.model.GroupData;
import re.stqa.pft.addressbook.model.Groups;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModifictionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.db().groups().size() == 0){
            app.goTo().GroupPage();
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification() throws IOException {
        Properties properties = new Properties();
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        Groups before = app.db().groups();
        GroupData modifyedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifyedGroup.getId()).withName(properties.getProperty("G.Name")).withHeader(properties.getProperty("G.Header")).withFooter(properties.getProperty("G.Footer"));
        app.goTo().GroupPage();
        app.group().modify(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.withOut(modifyedGroup).withAdded(group)));
    }
}