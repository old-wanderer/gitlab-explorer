package explorer.app;

import explorer.entity.GitLabProject;
import explorer.repository.GitLabProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.IOException;
import java.util.List;

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
    public void projects(@ShellOption(value = {"-u", "--update"}, defaultValue = "false") boolean update) {
        try {
            List<GitLabProject> projects;
            if (update) {
                projects = gitLabController.projects();
                projectRepository.saveAll(projects);
            } else {
                projects = projectRepository.findAll();
            }

            projects.stream()
                    .map(GitLabProject::getPathWithNamespace)
                    .sorted()
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
