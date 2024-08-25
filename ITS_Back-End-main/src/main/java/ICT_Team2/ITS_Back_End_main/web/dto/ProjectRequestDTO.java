package ICT_Team2.ITS_Back_End_main.web.dto;

import lombok.Getter;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class ProjectRequestDTO {

    @NotBlank(message = "Project name is required")
    @Size(max = 20, message = "Project name must be less than 20 characters")
    private String name;

    @NotNull(message = "Project creation status is required")
    private Boolean isCreated;

    @NotBlank(message = "Status is required")
    @Size(max = 10, message = "Status must be less than 10 characters")
    private String status;

    @NotNull(message = "Creation date is required")
    private LocalDateTime createdAt;

    private LocalDateTime inactiveDate;
    private Boolean isDeleted;
    private LocalDateTime updatedAt;

    // 생성자랑 게터 세터 넣을 것.

    public ProjectRequestDTO() {}

    public ProjectRequestDTO(String name, Boolean isCreated, String status, LocalDateTime createdAt, LocalDateTime inactiveDate, Boolean isDeleted, LocalDateTime updatedAt) {
        this.name = name;
        this.isCreated = isCreated;
        this.status = status;
        this.createdAt = createdAt;
        this.inactiveDate = inactiveDate;
        this.isDeleted = isDeleted;
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsCreated() {
        return isCreated;
    }

    public void setIsCreated(Boolean isCreated) {
        this.isCreated = isCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(LocalDateTime inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
