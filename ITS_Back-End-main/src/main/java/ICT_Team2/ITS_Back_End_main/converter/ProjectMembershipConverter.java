package ICT_Team2.ITS_Back_End_main.converter;

import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.domain.Project;
import ICT_Team2.ITS_Back_End_main.domain.mapping.ProjectMembership;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectMembershipConverter {
    public static List<Member> toMembers(List<ProjectMembership> projectMemberships) {
        if (projectMemberships == null)
            return null;
        return projectMemberships.stream().map(ProjectMembership::getMember)
                .collect(Collectors.toList());
    }

    public static ProjectMembership toProjectMemberShip(Member member, Project project) {
        return ProjectMembership.builder()
                .member(member)
                .project(project)
                .build();
    }
}
