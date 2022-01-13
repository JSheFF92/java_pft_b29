package ru.stqa.pft.mantis.appmanager;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.tests.TestBase;

public class RegistrationTests extends TestBase {

    @Test

    public void testRegistration(){
        app.registration().start("user1", "user1@localhost.localdomain");
    }
}
