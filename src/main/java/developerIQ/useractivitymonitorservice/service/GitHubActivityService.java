package developerIQ.useractivitymonitorservice.service;


import developerIQ.useractivitymonitorservice.dto.GitHubActivityDetailsDto;
import developerIQ.useractivitymonitorservice.model.GitHubActivity;

import java.util.List;

public interface GitHubActivityService {
    List<GitHubActivity> getGithubActivity();

    List<GitHubActivity> getAllActivities();

    GitHubActivityDetailsDto getAllIssuesByUserName(String userName);
}