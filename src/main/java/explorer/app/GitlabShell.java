package explorer.app;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import explorer.entity.GitLabProject;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.IOException;
import java.util.List;

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
                .addQueryParameter("membership", "true")
                .addQueryParameter("per_page", "100")
                .addQueryParameter("simple", "true")
                .addQueryParameter("private_token", "vt3tJ2XaveYsmMZ2wp_b")
                .build();
        var request = new Request.Builder()
                .url(url)
                .build();
        try {
            System.out.println(url.toString());
            Response response = client.newCall(request).execute();
            if (response.body() != null) {
                System.out.println(response.headers());
                var type = new TypeToken<List<GitLabProject>>(){}.getType();
                List<GitLabProject> projects = new Gson().fromJson(response.body().charStream(), type);
                projects.stream().map(GitLabProject::getPathWithNamespace).sorted().forEach(System.out::println);
            }
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

}
