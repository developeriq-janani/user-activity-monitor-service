package developerIQ.useractivitymonitorservice.service;


import developerIQ.useractivitymonitorservice.dto.GitHubActivityDetailsDto;
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

    @Override
    public GitHubActivityDetailsDto getAllIssuesByUserName(String userName){
        List<GitHubActivity> gitHubIssues = this.gitHubActivityRepository.findAllByUserName(userName.trim());
        return GitHubActivityDetailsDto.builder().issueCount(gitHubIssues.size()).userIssues(gitHubIssues).build();

    }

    private GitHubActivity generateGitHubActivityObject(GitHubActivityDto githubActivityDto) {
        return GitHubActivity.builder()
                .userName(githubActivityDto.getUserDto().getUserName())
                .userID(githubActivityDto.getUserDto().getUserId())
                .userType(githubActivityDto.getUserDto().getUserType())
                .issueTitle(githubActivityDto.getIssueTitle())
                .createdAt(githubActivityDto.getCreatedAt())
                .updatedAt(githubActivityDto.getUpdatedAt())
                .build();
    }

}
