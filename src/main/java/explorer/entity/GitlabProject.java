package explorer.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author : Andrei Shlykov
 * @since : 17/08/2018
 */
public class GitlabProject {

    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("default_branch")
    private String defaultBrunch;
    private String description;
    @SerializedName("forks_count")
    private int forksCount;
    @SerializedName("http_url_to_repo")
    private String httpUrlToRepo;
    private int id;
    @SerializedName("last_activity_at")
    private String lastActivityAt;
    private String name;
    @SerializedName("name_with_namespace")
    private String name_with_namespace;
//  namespace           : {
//        full_path : PrimitiveString
//        id        : PrimitiveDouble
//        kind      : PrimitiveString
//        name      : PrimitiveString
//        parent_id : PrimitiveDouble
//        path      : PrimitiveString
//    }
    private String path;
    @SerializedName("path_with_namespace")
    private String pathWithNamespace;
    @SerializedName("readme_url")
    private String readmeUrl;
    @SerializedName("ssh_url_to_repo")
    private String sshUrlToRepo;
    @SerializedName("star_count")
    private int startCount;
    @SerializedName("tag_list")
    private List<String> tags;
    @SerializedName("web_url")
    private String webUrl;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDefaultBrunch() {
        return defaultBrunch;
    }

    public void setDefaultBrunch(String defaultBrunch) {
        this.defaultBrunch = defaultBrunch;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getForksCount() {
        return forksCount;
    }

    public void setForksCount(int forksCount) {
        this.forksCount = forksCount;
    }

    public String getHttpUrlToRepo() {
        return httpUrlToRepo;
    }

    public void setHttpUrlToRepo(String httpUrlToRepo) {
        this.httpUrlToRepo = httpUrlToRepo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastActivityAt() {
        return lastActivityAt;
    }

    public void setLastActivityAt(String lastActivityAt) {
        this.lastActivityAt = lastActivityAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_with_namespace() {
        return name_with_namespace;
    }

    public void setName_with_namespace(String name_with_namespace) {
        this.name_with_namespace = name_with_namespace;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPathWithNamespace() {
        return pathWithNamespace;
    }

    public void setPathWithNamespace(String pathWithNamespace) {
        this.pathWithNamespace = pathWithNamespace;
    }

    public String getReadmeUrl() {
        return readmeUrl;
    }

    public void setReadmeUrl(String readmeUrl) {
        this.readmeUrl = readmeUrl;
    }

    public String getSshUrlToRepo() {
        return sshUrlToRepo;
    }

    public void setSshUrlToRepo(String sshUrlToRepo) {
        this.sshUrlToRepo = sshUrlToRepo;
    }

    public int getStartCount() {
        return startCount;
    }

    public void setStartCount(int startCount) {
        this.startCount = startCount;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }
}
