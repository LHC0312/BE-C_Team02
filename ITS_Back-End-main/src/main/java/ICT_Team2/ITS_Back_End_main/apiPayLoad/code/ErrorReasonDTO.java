package ICT_Team2.ITS_Back_End_main.apiPayLoad.code;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class ErrorReasonDTO {
    private final Boolean isSuccess;
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
