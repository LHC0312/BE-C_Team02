package ICT_Team2.ITS_Back_End_main.converter;

import org.springframework.stereotype.Component;

import ICT_Team2.ITS_Back_End_main.web.dto.ProjectRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.ProjectResponseDTO;

@Component
public class ProjectConverter {

    public ProjectResponseDTO toResponseDto(Project project) {
        return new ProjectResponseDTO(
                project.getId(),
                project.getName(),
                project.getIsCreated(),
                project.getStatus(),
                project.getCreatedAt(),
                project.getInactiveDate(),
                project.getIsDeleted(),
                project.getUpdatedAt()
        );
    }

    public Project toEntity(ProjectRequestDTO projectRequestDTO) {
        Project project = new Project();
        project.setName(projectRequestDTO.getName());
        project.setIsCreated(projectRequestDTO.getIsCreated());
        project.setStatus(projectRequestDTO.getStatus());
        project.setCreatedAt(projectRequestDTO.getCreatedAt());
        project.setInactiveDate(projectRequestDTO.getInactiveDate());
        project.setIsDeleted(projectRequestDTO.getIsDeleted());
        project.setUpdatedAt(projectRequestDTO.getUpdatedAt());
        return project;
    }
}

