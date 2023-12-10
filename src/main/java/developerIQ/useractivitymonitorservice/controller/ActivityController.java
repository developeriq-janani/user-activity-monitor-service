package developerIQ.useractivitymonitorservice.controller;

import developerIQ.useractivitymonitorservice.model.GitHubActivity;
import developerIQ.useractivitymonitorservice.service.GitHubActivityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/git-hub")

public class ActivityController {
    private GitHubActivityService gitHubActivityService;

    @GetMapping("/activities")
    public ResponseEntity<List<GitHubActivity>> getGithubActivity() {
        return ResponseEntity.ok(this.gitHubActivityService.getGithubActivity());
    }

    @GetMapping("/activities/get-all")
    public ResponseEntity<List<GitHubActivity>> getAllActivities() {
        return ResponseEntity.ok(this.gitHubActivityService.getAllActivities());
    }
}