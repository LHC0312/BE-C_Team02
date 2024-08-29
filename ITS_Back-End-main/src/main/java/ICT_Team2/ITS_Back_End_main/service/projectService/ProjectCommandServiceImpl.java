package ICT_Team2.ITS_Back_End_main.service.projectService;

import ICT_Team2.ITS_Back_End_main.converter.ProjectMembershipConverter;
import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.domain.Project;
import ICT_Team2.ITS_Back_End_main.repository.ProjectMembershipRepository;
import ICT_Team2.ITS_Back_End_main.repository.ProjectRepository;
import ICT_Team2.ITS_Back_End_main.service.memberService.MemberQueryService;
import ICT_Team2.ITS_Back_End_main.web.dto.ProjectRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectCommandServiceImpl implements ProjectCommandService {
    private final ProjectRepository projectRepository;
    private final ProjectMembershipRepository projectMembershipRepository;
    private final MemberQueryService memberQueryService;
    private final ProjectQueryService projectQueryService;

    @Override
    public Project createProject(ProjectRequestDTO.ProjectCreateRequestDto request) {
        // 프로젝트 생성 로직
        Project project = Project.builder()
                .name(request.getName())
                .build();
        projectRepository.save(project);

        // 멤버들과 프로젝트 연결
        for (Long memberId : request.getMemberIds()) {
            Member member = memberQueryService.findByMemberId(memberId);
            addMember(project, member);
        }

        return project;
    }

    @Override
    public Project addMember (Long projectId, ProjectRequestDTO.ProjectMemberAddRequestDto request) {
        Project project = projectQueryService.getProjectById(projectId);
        Member member = memberQueryService.findByMemberId(request.getAddMemberId());

        projectMembershipRepository.save(ProjectMembershipConverter.toProjectMemberShip(member, project));

        return project;
    }

    @Override
    public Project addMember (Project project, Member member) {
        projectMembershipRepository.save(ProjectMembershipConverter.toProjectMemberShip(member, project));

        return project;
    }

    @Override
    public Project deleteMember (Long projectId, ProjectRequestDTO.ProjectMemberRemoveRequestDto request) {
        Project project = projectQueryService.getProjectById(projectId);
        Member member = memberQueryService.findByMemberId(request.getRemoveMemberId());

        projectMembershipRepository.delete(ProjectMembershipConverter.toProjectMemberShip(member, project));

        return project;
    }
}