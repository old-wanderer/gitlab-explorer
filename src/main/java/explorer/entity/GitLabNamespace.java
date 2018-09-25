package explorer.entity;

import com.google.gson.annotations.SerializedName;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * @author : Andrei Shlykov
 * @since : 2018-09-09
 */
@Entity
public class GitLabNamespace {

    @Id
    private String id;

    @SerializedName("full_path")
    private String fullPath;
    private String kind;
    private String name;
    @SerializedName("parent_id")
    private Integer parentId;
    private String path;
    @OneToMany
    private Set<GitLabProject> project;

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Set<GitLabProject> getProject() {
        return project;
    }

    public void setProject(Set<GitLabProject> project) {
        this.project = project;
    }
}
