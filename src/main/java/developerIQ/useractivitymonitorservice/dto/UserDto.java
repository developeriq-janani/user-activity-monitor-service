package developerIQ.useractivitymonitorservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @JsonProperty("login")
    private String userName;

    @JsonProperty("id")
    private String userId;

    @JsonProperty("type")
    private String UserType;
}
