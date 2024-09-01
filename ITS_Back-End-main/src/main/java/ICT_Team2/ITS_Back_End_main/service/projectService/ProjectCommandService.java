package ICT_Team2.ITS_Back_End_main.service.projectService;

import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.domain.Project;
import ICT_Team2.ITS_Back_End_main.web.dto.ProjectRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.ProjectResponseDTO;

public interface ProjectCommandService {
    public Project createProject(ProjectRequestDTO.ProjectCreateRequestDto projectRequestDTO);

    public Project addMember (Long projectId, ProjectRequestDTO.ProjectMemberAddRequestDto request);
    public Project addMember (Project project, Member member);
    public Project deleteMember (Long projectId, ProjectRequestDTO.ProjectMemberRemoveRequestDto request);
    public Project deleteProject(Long projectId);

}
