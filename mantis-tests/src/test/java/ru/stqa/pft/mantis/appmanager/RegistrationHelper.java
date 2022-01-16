package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class RegistrationHelper extends HelperBase{

    public RegistrationHelper(ApplicationManager app) {
        super(app);
    }

    public void start(String username, String email) {
        wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
        type(By.name("username"), username);
        type(By.name("email"), email);
        click(By.cssSelector("input[value='Зарегистрироваться']"));
    }

    public void finish(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("input[value='Изменить учетную запись']"));
    }

    public void adminEnter(String username, String password){
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.name("username"), username);
        type(By.name("password"), password);
        click(By.cssSelector("input[value='Войти']"));
    }

    public void goToUserPage(){
        wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
        click(By.xpath("//*[@id=\"menu-items\"]/li[6]/a"));
        click(By.xpath("//*[@id=\"manage-menu\"]/ul/li[1]/a"));
        click(By.xpath("//a[@href='manage_user_edit_page.php?user_id=2']"));
    }

    public void ResetPassword(){
        wd.get(app.getProperty("web.baseUrl") + "/manage_user_edit_page.php?user_id=2");
        click(By.xpath("//input[@value='Сбросить пароль']"));
    }

}