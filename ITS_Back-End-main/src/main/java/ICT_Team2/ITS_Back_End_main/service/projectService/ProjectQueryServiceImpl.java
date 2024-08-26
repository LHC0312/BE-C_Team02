package ICT_Team2.ITS_Back_End_main.service.projectService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

import ICT_Team2.ITS_Back_End_main.web.dto.ProjectResponseDTO;

public interface ProjectQueryService {
    ProjectResponseDTO getProjectById(Long id);
    List<ProjectResponseDTO> getAllProjects();
}
