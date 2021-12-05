package re.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }
    public void login(String username, String password) {
        type1(By.name("user"), username);
        type1(By.name("pass"), password);
        click(By.xpath("//input[@value='Login']"));
    }
}