package developerIQ.useractivitymonitorservice.service.external;


import developerIQ.useractivitymonitorservice.dto.GitHubActivityDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
public class GitHubExternalClient {

    private final RestTemplate restTemplate;

    @Value("${github.activity-detail-url}")
    private String gitHubActivityDetailsUrl;

    public GitHubExternalClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GitHubActivityDto> getActivityDetails() {
        ResponseEntity<List<GitHubActivityDto>> response = restTemplate.exchange(gitHubActivityDetailsUrl, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        return response.getBody();
    }


}