package re.stqa.pft.addressbook.tests;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;
import re.stqa.pft.addressbook.appmanager.ApplicationManager;
import re.stqa.pft.addressbook.model.ContactData;
import re.stqa.pft.addressbook.model.Contacts;
import re.stqa.pft.addressbook.model.GroupData;
import re.stqa.pft.addressbook.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@Listeners(MyTestListener.class)
public class TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);


    protected static final ApplicationManager app
            = new ApplicationManager (System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite(alwaysRun = true)
    public void setUp(ITestContext context) throws Exception {
        app.init();
        context.setAttribute("app", app);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

    public boolean isAlertPresent() {
        try {
            WebDriver wd = null;
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @BeforeMethod
    public void logTestStart(Method m, Object[] p){
        logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m){
        logger.info("Stop test " + m.getName());
    }


    public void verifyContactListInUI() {
        if (Boolean.getBoolean("cVerifyUI")) {
            Contacts dbContacts = app.db().contacts();
            Contacts uiContacts = app.contact().all();
            assertThat(uiContacts, equalTo(dbContacts.stream()
                    .map((c) -> new ContactData().withId(c.getId()).withFirstname(c.getFirstname())
                            .withLastname(c.getLastname()))
                    .collect(Collectors.toSet())));
        }
    }

    public void verifyGroupListInUI() {
        if (Boolean.getBoolean("gVerifyUI")){
            Groups dbGroups = app.db().groups();
            Groups uiGroups = app.group().all();
            assertThat(uiGroups, equalTo(dbGroups.stream()
                    .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
                    .collect(Collectors.toSet())));
        }
    }
}