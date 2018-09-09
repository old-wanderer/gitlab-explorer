package explorer.app;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import explorer.entity.GitLabProject;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @author : Andrei Shlykov
 * @since : 2018-09-09
 */
@Component
public class GitLabController {

    private final OkHttpClient client;

    @Autowired
    public GitLabController(OkHttpClient client) {
        this.client = client;
    }

    public List<GitLabProject> projects() throws IOException {
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

        System.out.println(url.toString());
        Response response = client.newCall(request).execute();
        if (response.body() != null) {
            System.out.println(response.headers());
            var type = new TypeToken<List<GitLabProject>>(){}.getType();
            return new Gson().fromJson(response.body().charStream(), type);
        } else {
            return Collections.emptyList();
        }
    }

}
