package developerIQ.useractivitymonitorservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "github_activity")

public class GitHubActivity {

    @Id
    private String id;

    private String userName;

    private String userID;

    private String userType;

    private String issueTitle;

    private String createdAt;

    private String updatedAt;

}