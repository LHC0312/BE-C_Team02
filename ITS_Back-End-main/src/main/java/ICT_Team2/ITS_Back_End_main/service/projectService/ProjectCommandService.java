package ICT_Team2.ITS_Back_End_main.service.projectService;

import ICT_Team2.ITS_Back_End_main.web.dto.ProjectRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.ProjectResponseDTO;

public interface ProjectCommandService {
    ProjectResponseDTO createProject(ProjectRequestDTO projectRequestDTO);
    ProjectResponseDTO updateProject(Long id, ProjectRequestDTO projectRequestDTO);
    void deleteProject(Long id);
}
