package ICT_Team2.ITS_Back_End_main.apiPayLoad.code.status;

import ICT_Team2.ITS_Back_End_main.apiPayLoad.code.BaseErrorCode;
import ICT_Team2.ITS_Back_End_main.apiPayLoad.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),
<<<<<<< HEAD
    // Member 관련 에러
    _SIGNUP_ERROR(HttpStatus.BAD_REQUEST, "MEMBER4001", "기입되지 않은 항목이 있습니다."),
    _SIGNID_ERROR(HttpStatus.BAD_REQUEST,"MEMBER4002","중복된 아이디 입니다."),
    _INVALID_PASSWORD(HttpStatus.NOT_FOUND,"MEMBER4003","비밀번호가 일치하지 않습니다."),
    _MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER4004", "회원 정보를 찾을 수 없습니다.");
=======
    ;
>>>>>>> 8146e61ea944e080fbdeaf825f8c0674470a7e53

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
