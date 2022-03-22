package response;

import com.devagit.springbootstudy.request.user.CheckTokenRequest;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CheckTokenResponseEntity {
    private String token;

    public CheckTokenResponseEntity(String token) {
        this.token = token;
    }

    public static CheckTokenResponseEntity from(String token){
        return new CheckTokenResponseEntity(token);
    }
}
