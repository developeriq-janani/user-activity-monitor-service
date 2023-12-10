package developerIQ.useractivitymonitorservice.service;


import developerIQ.useractivitymonitorservice.dto.GitHubActivityDto;
import developerIQ.useractivitymonitorservice.model.GitHubActivity;
import developerIQ.useractivitymonitorservice.repository.GitHubActivityRepository;
import developerIQ.useractivitymonitorservice.service.external.GitHubExternalClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GitHubActivityServiceImpl implements GitHubActivityService {

    private final GitHubExternalClient githubExternalClient;
    private final GitHubActivityRepository gitHubActivityRepository;

    @Override
    public List<GitHubActivity> getGithubActivity() {
        List<GitHubActivity> githubActivities = new ArrayList<>();

        List<GitHubActivityDto> githubActivityDtoList = this.githubExternalClient.getActivityDetails();
        githubActivityDtoList.forEach(githubActivityDto -> {
            GitHubActivity gitHubActivity = this.generateGitHubActivityObject(githubActivityDto);
            githubActivities.add(gitHubActivity);
        });

        this.gitHubActivityRepository.saveAll(githubActivities);

        return githubActivities;


    }

    @Override
    public List<GitHubActivity> getAllActivities() {
        return this.gitHubActivityRepository.findAll();
    }

    private GitHubActivity generateGitHubActivityObject(GitHubActivityDto githubActivityDto) {
        return GitHubActivity.builder()
                .gitHubId(githubActivityDto.getId())
                .login(githubActivityDto.getLogin())
                .contributions(githubActivityDto.getContributions())
                .type(githubActivityDto.getType())
                .siteAdmin(githubActivityDto.isSiteAdmin())
                .reposUrl(githubActivityDto.getReposUrl())
                .nodeId(githubActivityDto.getNodeId())
                .build();
    }

}
