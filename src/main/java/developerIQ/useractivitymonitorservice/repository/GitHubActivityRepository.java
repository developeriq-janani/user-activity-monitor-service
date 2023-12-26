package developerIQ.useractivitymonitorservice.repository;

import developerIQ.useractivitymonitorservice.model.GitHubActivity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GitHubActivityRepository extends MongoRepository<GitHubActivity, String> {

    List<GitHubActivity> findAllByUserName(String userName);

}