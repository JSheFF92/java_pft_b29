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


public class GroupDelitionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws IOException {
        Properties properties = new Properties();
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        app.goTo().GroupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName(properties.getProperty("G.Name")));
        }
    }

    @Test
    public void testGroupDelition() {
        Groups before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        assertThat(app.group().count(), equalTo(before.size() - 1));
        Groups after = app.group().all();
        assertThat(after, equalTo(before.withOut(deletedGroup)));
    }


}