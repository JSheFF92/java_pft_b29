package re.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Browser;


public class ApplicationManager {

    public WebDriver wd;

    private SessionHelper sessionHelper;

    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private Browser browser;

    public ApplicationManager(Browser browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(Browser.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(Browser.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(Browser.EDGE)) {
            wd = new InternetExplorerDriver();
        } else if (browser.equals(Browser.IE)) {
            wd = new InternetExplorerDriver();
        }

        wd.get("http://localhost/addressbook");
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }


    public void stop() {
        wd.quit();
    }


    public GroupHelper group() {
        return groupHelper;
    }

    public ContactHelper contact() {
        return contactHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }
}