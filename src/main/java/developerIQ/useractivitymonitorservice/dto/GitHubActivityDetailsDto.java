package developerIQ.useractivitymonitorservice.dto;

import developerIQ.useractivitymonitorservice.model.GitHubActivity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GitHubActivityDetailsDto {
    private int issueCount;

    private List<GitHubActivity> userIssues;
}
