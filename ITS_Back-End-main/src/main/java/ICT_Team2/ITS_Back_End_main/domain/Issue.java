package ICT_Team2.ITS_Back_End_main.domain;

//import ICT_Team2.ITS_Back_End_main.domain.common.BaseEntity;
//import ICT_Team2.ITS_Back_End_main.domain.enums.Priority;
//import ICT_Team2.ITS_Back_End_main.domain.enums.Status;
import ICT_Team2.ITS_Back_End_main.domain.common.BaseEntity;
import ICT_Team2.ITS_Back_End_main.domain.enums.Priority;
import ICT_Team2.ITS_Back_End_main.domain.enums.Status;
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

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "project_id")
//    private Long projectId;

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    private Long fixer;
//
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    private Long repoter;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Long> assigneeId = new ArrayList<>();;

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
