package explorer.app;

import explorer.entity.GitLabProject;
import explorer.repository.GitLabProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.IOException;

/**
 * @author : Andrei Shlykov
 * @since : 17/08/2018
 */
@ShellComponent
public class GitLabShell {

    private final GitLabController gitLabController;

    private final GitLabProjectRepository projectRepository;

    @Autowired
    public GitLabShell(GitLabController gitLabController, GitLabProjectRepository projectRepository) {
        this.gitLabController = gitLabController;
        this.projectRepository = projectRepository;
    }

    @ShellMethod("Show your projects")
    public void projects() {
        try {
            gitLabController.projects()
                    .stream()
                    .map(GitLabProject::getPathWithNamespace)
                    .sorted()
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ShellMethod("Store your projects")
    public void load() {
        try {
            var projects = gitLabController.projects();
            projectRepository.saveAll(projects);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ShellMethod("Show stored projects")
    public void show() {
        projectRepository.findAll()
                .stream()
                .map(GitLabProject::getPathWithNamespace)
                .sorted()
                .forEach(System.out::println);
    }

}
