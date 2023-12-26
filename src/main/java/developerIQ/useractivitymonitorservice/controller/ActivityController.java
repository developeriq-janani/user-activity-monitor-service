package developerIQ.useractivitymonitorservice.controller;

import developerIQ.useractivitymonitorservice.dto.GitHubActivityDetailsDto;
import developerIQ.useractivitymonitorservice.model.GitHubActivity;
import developerIQ.useractivitymonitorservice.service.GitHubActivityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/git-hub")

public class ActivityController {
    private GitHubActivityService gitHubActivityService;

    @GetMapping("/issues")
    public ResponseEntity<List<GitHubActivity>> getGithubActivity() {
        return ResponseEntity.ok(this.gitHubActivityService.getGithubActivity());
    }

    @GetMapping("/issues/get-all")
    public ResponseEntity<List<GitHubActivity>> getAllActivities() {
        return ResponseEntity.ok(this.gitHubActivityService.getAllActivities());
    }

    @GetMapping("/issues/by-user-name")
    public ResponseEntity<GitHubActivityDetailsDto> getAllIssuesByUserName(@RequestParam String userName) {
        return ResponseEntity.ok(this.gitHubActivityService.getAllIssuesByUserName(userName));
    }
}