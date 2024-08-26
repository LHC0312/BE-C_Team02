package ICT_Team2.ITS_Back_End_main.service;

import ICT_Team2.ITS_Back_End_main.domain.Project;
import ICT_Team2.ITS_Back_End_main.domain.mapping.ProjectMembership;
import ICT_Team2.ITS_Back_End_main.repository.MemberRepository;
import ICT_Team2.ITS_Back_End_main.repository.ProjectRepository;
import ICT_Team2.ITS_Back_End_main.web.dto.ProjectRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.ProjectResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectCommandServiceImpl implements ProjectCommandService{
    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;

    @Override
    public ProjectResponseDTO.ProjectResponseDto createProject(ProjectRequestDTO.ProjectCreateDto projectCreateDto) {
        // 프로젝트 생성 로직
        Project project = Project.builder()
                .name(projectCreateDto.getName())
                .build();
        projectRepository.save(project);

        // 멤버들과 프로젝트 연결
        for (Long memberId : projectCreateDto.getMemberIds()) {
            ProjectMembership projectMembership = memberRepository.findById(memberId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid memberId: " + memberId));
            projectMembership.setProject(project);
            memberRepository.save(projectMembership);
        }

        return ProjectResponseDTO.ProjectResponseDto.builder()
                .id(project.getId())
                .name(project.getName())
                .members(project.getMemberList())
                .issues(project.getIssueList())
                .leaderId(project.getLeaderId())
                .build();
    }

    @Override
    public ProjectResponseDTO.ProjectResponseDto addMember(ProjectRequestDTO.MemberAddDto memberAddDto) {
        Project project = projectRepository.findById(memberAddDto.getAddMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid projectId: " + memberAddDto.getAddMemberId()));

        ProjectMembership projectMembership = memberRepository.findById(memberAddDto.getAddMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid memberId: " + memberAddDto.getAddMemberId()));

        projectMembership.setProject(project);
        memberRepository.save(projectMembership);

        return ProjectResponseDTO.ProjectResponseDto.builder()
                .id(project.getId())
                .name(project.getName())
                .members(project.getMemberList())
                .issues(project.getIssueList())
                .leaderId(project.getLeaderId())
                .build();
    }

    @Override
    public ProjectResponseDTO.ProjectResponseDto removeMember(ProjectRequestDTO.MemberRemoveDto memberRemoveDto) {
        Project project = projectRepository.findById(memberRemoveDto.getRemoveMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid projectId: " + memberRemoveDto.getRemoveMemberId()));

        ProjectMembership projectMembership = memberRepository.findById(memberRemoveDto.getRemoveMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid memberId: " + memberRemoveDto.getRemoveMemberId()));

        projectMembership.setProject(null);  // 프로젝트와의 연결 해제
        memberRepository.save(projectMembership);

        return ProjectResponseDTO.ProjectResponseDto.builder()
                .id(project.getId())
                .name(project.getName())
                .members(project.getMemberList())
                .issues(project.getIssueList())
                .leaderId(project.getLeaderId())
                .build();
    }
}
