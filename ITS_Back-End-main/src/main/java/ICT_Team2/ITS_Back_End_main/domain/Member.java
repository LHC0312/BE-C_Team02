package ICT_Team2.ITS_Back_End_main.domain;

import ICT_Team2.ITS_Back_End_main.domain.common.BaseEntity;

import ICT_Team2.ITS_Back_End_main.domain.enums.Role;
import ICT_Team2.ITS_Back_End_main.domain.enums.Status;
import ICT_Team2.ITS_Back_End_main.domain.mapping.ProjectMembership;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String signId;
    private String password;
    private String name;
    private boolean isDeleted;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<ProjectMembership> projectMembershipList = new ArrayList<>();

    @OneToMany(mappedBy = "assignee", cascade = CascadeType.ALL)
    private List<Issue> assigneeList = new ArrayList<>();

    @OneToMany(mappedBy = "writer", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "fixer", cascade = CascadeType.ALL)
    private List<Issue> fixedIssueList = new ArrayList<>();

    @OneToMany(mappedBy = "reporter", cascade = CascadeType.ALL)
    private List<Issue> reportedIssueList = new ArrayList<>();

    public void setRole(Role role) {
        this.role=role;
    }

    public void setStatus(Status status) {
        this.status=status;

    }
}
