package ICT_Team2.ITS_Back_End_main.web.dto;

import ICT_Team2.ITS_Back_End_main.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

public class ProjectRequestDTO {

    @Getter
    public static class ProjectMemberAddRequestDto {
        private Long addMemberId;
    }

    @Getter
    public static class ProjectMemberRemoveRequestDto {
        private Long removeMemberId;
    }

    @Getter
    public static class ProjectCreateRequestDto {
        private String name;
        private List<Long> memberIds;
    }

}