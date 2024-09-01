package ICT_Team2.ITS_Back_End_main.converter;

import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.domain.Member;
import ICT_Team2.ITS_Back_End_main.domain.Project;
import ICT_Team2.ITS_Back_End_main.domain.mapping.AssigneeMember;
import ICT_Team2.ITS_Back_End_main.domain.mapping.ProjectMembership;

import java.util.List;
import java.util.stream.Collectors;

public class AssigneeMemberConverter {
    public static List<Member> toMembers(List<AssigneeMember> AssigneeMembers) {
        if (AssigneeMembers == null)
            return null;
        return AssigneeMembers.stream().map(AssigneeMember::getMember)
                .collect(Collectors.toList());
    }

    public static AssigneeMember toAssigneeMember(Member member, Issue issue) {
        return AssigneeMember.builder()
                .member(member)
                .issue(issue)
                .build();
    }
}
