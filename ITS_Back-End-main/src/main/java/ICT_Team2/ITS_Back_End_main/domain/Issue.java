package ICT_Team2.ITS_Back_End_main.domain;

//import ICT_Team2.ITS_Back_End_main.domain.common.BaseEntity;
//import ICT_Team2.ITS_Back_End_main.domain.enums.Priority;
//import ICT_Team2.ITS_Back_End_main.domain.enums.Status;
import ICT_Team2.ITS_Back_End_main.domain.common.BaseEntity;
import ICT_Team2.ITS_Back_End_main.domain.enums.Priority;
import ICT_Team2.ITS_Back_End_main.domain.enums.Status;
import ICT_Team2.ITS_Back_End_main.domain.mapping.AssigneeMember;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Issue extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;


    @ManyToOne
    @JoinColumn(name = "fixer_id")
    private User fixer;

    @ManyToOne
    @JoinColumn(name = "reporter_id")
    private User reporter;

    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL)
    private List<AssigneeMember> assigneeMemberList = new ArrayList<>();

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20)")
    private Status status;

    private LocalDate reportedDate;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20)")
    private Priority priority;

    @Column(nullable = true, length = 20)
    private String category;

    private Long score;

//    private LocalDate inactiveDate;

    private boolean isDeleted;
}
