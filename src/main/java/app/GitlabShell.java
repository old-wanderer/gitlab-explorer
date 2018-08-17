package app;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.IOException;

/**
 * @author : Andrei Shlykov
 * @since : 17/08/2018
 */
@ShellComponent
public class GitlabShell {

    private final OkHttpClient client;

    @Autowired
    public GitlabShell(OkHttpClient client) {
        this.client = client;
    }

    @ShellMethod("Get your projects")
    public void projects() {
        var url = new HttpUrl.Builder()
                .scheme("https")
                .host("gitlab.com")
                .addPathSegment("api").addPathSegments("v4").addPathSegment("projects")
                .addQueryParameter("visibility", "private")
                .addQueryParameter("private_token", "vt3tJ2XaveYsmMZ2wp_b")
                .build();
        var request = new Request.Builder()
                .url(url)
//                .addHeader("Private-Token", "vt3tJ2XaveYsmMZ2wp_b")
                .build();
        try {
            System.out.println(url.toString());
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

}
