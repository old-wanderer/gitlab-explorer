package explorer.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author : Andrei Shlykov
 * @since : 2018-09-09
 */
public class GitLabNamespace {

    @SerializedName("full_path")
    private String fullPath;
    private String id;
    private String kind;
    private String name;
    @SerializedName("parent_id")
    private Integer parentId;
    private String path;

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
}
