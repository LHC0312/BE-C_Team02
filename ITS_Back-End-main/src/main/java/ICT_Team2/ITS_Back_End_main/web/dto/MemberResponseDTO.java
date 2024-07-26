package ICT_Team2.ITS_Back_End_main.web.dto;

import lombok.Getter;

public class MemberResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponseDto {
        private int id;
        private String signId;
        private String password;
        private String role;
        private String name;
        private boolean isDeleted;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponseExceptionDTO{

    }
}
