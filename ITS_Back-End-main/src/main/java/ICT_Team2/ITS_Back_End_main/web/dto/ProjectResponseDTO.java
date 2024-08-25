package ICT_Team2.ITS_Back_End_main.web.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Getter
@Setter
public class ProjectResponseDTO {

    private Long id;

    private String name;
    private Boolean isCreated;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime inactiveDate;
    private Boolean isDeleted;
    private LocalDateTime updatedAt;

    // 생성자랑 게터 세터 넣을 것.

    public ProjectResponseDTO() {}

    public ProjectResponseDTO(Long id, String name, Boolean isCreated, String status, LocalDateTime createdAt, LocalDateTime inactiveDate, Boolean isDeleted, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.isCreated = isCreated;
        this.status = status;
        this.createdAt = createdAt;
        this.inactiveDate = inactiveDate;
        this.isDeleted = isDeleted;
        this.updatedAt = updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsCreated(Boolean isCreated) {
        this.isCreated = isCreated;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setInactiveDate(LocalDateTime inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
