package ICT_Team2.ITS_Back_End_main.apiPayLoad.exception;

import ICT_Team2.ITS_Back_End_main.apiPayLoad.code.BaseErrorCode;
import ICT_Team2.ITS_Back_End_main.apiPayLoad.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {
    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }

}
