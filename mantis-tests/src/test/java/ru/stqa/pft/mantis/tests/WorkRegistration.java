package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class WorkRegistration extends TestBase{


    @BeforeMethod
    public void startMailServer(){
        app.mail().start();
    }

    @Test
    public void testRegistration() throws IOException, MessagingException {

        long now = System.currentTimeMillis();
        app.registration().adminEnter("Administrator", "root");
        app.registration().goToUserPage();
        app.registration().ResetPassword("user1642247492520", "user1642247492520@localhost");
        String email = String.format("user1642247492520@localhost", now);
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        String confirmationLink = findConfirmationLink(mailMessages, email);
        String user = String.format("user1642247492520", now);
        String password = "password";
        app.registration().finish(confirmationLink, password);
        app.registration().userEnter(user, password);
        assertTrue(app.newSession().login(user, password));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex  = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        app.mail().stop();
    }
}
