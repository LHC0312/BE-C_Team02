package ICT_Team2.ITS_Back_End_main.apiPayLoad.exception.handler;

import ICT_Team2.ITS_Back_End_main.apiPayLoad.code.BaseErrorCode;
import ICT_Team2.ITS_Back_End_main.apiPayLoad.exception.GeneralException;

public class MemberHandler extends GeneralException {

    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
