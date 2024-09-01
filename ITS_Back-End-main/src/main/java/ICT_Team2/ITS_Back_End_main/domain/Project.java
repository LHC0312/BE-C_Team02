package ICT_Team2.ITS_Back_End_main.domain;

import ICT_Team2.ITS_Back_End_main.domain.common.BaseEntity;
import ICT_Team2.ITS_Back_End_main.domain.enums.Status;

import ICT_Team2.ITS_Back_End_main.domain.mapping.AssigneeMember;
import ICT_Team2.ITS_Back_End_main.domain.mapping.ProjectMembership;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Project extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;


    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<ProjectMembership> projectMembershipList = new ArrayList<>();

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Issue> IssueList = new ArrayList<>();

}

