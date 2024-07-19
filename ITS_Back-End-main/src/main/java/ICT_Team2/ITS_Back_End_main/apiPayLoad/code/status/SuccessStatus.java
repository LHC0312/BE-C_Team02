package ICT_Team2.ITS_Back_End_main.apiPayLoad.code.status;

import ICT_Team2.ITS_Back_End_main.apiPayLoad.code.BaseCode;
import ICT_Team2.ITS_Back_End_main.apiPayLoad.code.ReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {
    _OK(HttpStatus.OK, "COMMON200", "요청이 처리되었습니다."),
    _CREATED(HttpStatus.CREATED, "COMMON201", "새로운 리소스를 만들었습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build();
    }
}
