package ICT_Team2.ITS_Back_End_main.service.projectService;

import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.domain.Project;
import ICT_Team2.ITS_Back_End_main.domain.mapping.ProjectMembership;
import ICT_Team2.ITS_Back_End_main.repository.ProjectMembershipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import ICT_Team2.ITS_Back_End_main.repository.ProjectRepository;
import ICT_Team2.ITS_Back_End_main.converter.ProjectConverter;


@Service
@RequiredArgsConstructor
public class ProjectQueryServiceImpl implements ProjectQueryService {

    private final ProjectRepository projectRepository;
    private final ProjectMembershipRepository projectMembershipRepository;

    @Override
    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project not found with id " + id));
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public List<Member> findProjectMember(Long projectId) {
       List<ProjectMembership> projectMemberships = projectMembershipRepository.findByProjectId(projectId)
               .orElseThrow(() -> new IllegalArgumentException("Invaild projectId"));

        return projectMemberships.stream()
                .map(ProjectMembership::getMember).toList();
    }
}
