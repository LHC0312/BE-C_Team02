package ICT_Team2.ITS_Back_End_main.converter;

import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.domain.Project;

import ICT_Team2.ITS_Back_End_main.web.dto.MemberResponseDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.ProjectRequestDTO;
import ICT_Team2.ITS_Back_End_main.web.dto.ProjectResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectConverter {

    public static ProjectResponseDTO.ProjectResponeDto toResponseDto(Project project) {
        List<Member> members = ProjectMembershipConverter.toMembers(project.getProjectMembershipList());

        return ProjectResponseDTO.ProjectResponeDto.builder()
                .id(project.getId())
                .name(project.getName())
                .members(MemberConverter.toUserDTO(members))
                .issues(IssueConverter.toResultDTO(project.getIssueList()))
                .build();
    }

    public static List<ProjectResponseDTO.ProjectResponeDto> toResponseDto(List<Project> project) {
        return project.stream()
                .map(ProjectConverter::toResponseDto)
                .collect(Collectors.toList());
    }

    public Project toEntity(ProjectRequestDTO.ProjectCreateRequestDto request) {
        return Project.builder()
                .name(request.getName())
                .build();
    }
}

