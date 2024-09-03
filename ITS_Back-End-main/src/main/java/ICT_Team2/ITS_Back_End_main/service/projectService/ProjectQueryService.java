package ICT_Team2.ITS_Back_End_main.service.projectService;

import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.domain.Project;

import java.util.List;

public interface ProjectQueryService {
    public Project getProjectById(Long id);
    public List<Project> getMyProjects(Long id);
    public List<Member> findProjectMember(Long projectId);
}
