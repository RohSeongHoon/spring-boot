package response;

import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@NoArgsConstructor
public class LoginResponseEntity {
    private String token;
    private String refreshToken;

    public LoginResponseEntity(String token,@Nullable String refreshToken) {
        this.token = token;
        this.refreshToken = refreshToken;
    }

    public static LoginResponseEntity from(String token,@Nullable String refreshToken){
        return new LoginResponseEntity(token,refreshToken);
    }
}
