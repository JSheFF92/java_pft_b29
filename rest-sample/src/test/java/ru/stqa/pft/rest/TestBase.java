package ru.stqa.pft.rest;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.SkipException;

import java.io.IOException;

public class TestBase  {


   public boolean isIssueOpen(int issueId) throws IOException {
       String json = getExecutor().execute(Request.Get("https://bugify.stqa.ru/api/issues.json"))
               .returnContent().asString();
       JsonElement parsed = new JsonParser().parse(json);
       JsonElement Status = parsed.getAsJsonObject().getAsJsonArray("issues");

       if ((Status.getAsJsonObject().get(String.valueOf(issueId))).equals("closed"))


       /*RestAssured.get(String.valueOf(issueId)).equals("Open"))*/{
            return false;
        }
        else {
            return true;
        }
    }

    public void skipIfNotFixed(int issueId) throws IOException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    private Executor getExecutor() {
        return Executor.newInstance().auth("288f44776e7bec4bf44fdfeb1e646490", "");
    }
}