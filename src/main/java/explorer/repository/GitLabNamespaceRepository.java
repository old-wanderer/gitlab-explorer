package explorer.repository;

import explorer.entity.GitLabNamespace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Andrei Shlykov
 * @since : 2018-09-10
 */
@Repository
public interface GitLabNamespaceRepository extends JpaRepository<GitLabNamespace, String> {
}
