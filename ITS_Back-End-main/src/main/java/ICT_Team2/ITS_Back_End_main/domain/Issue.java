package ICT_Team2.ITS_Back_End_main.domain;

import ICT_Team2.ITS_Back_End_main.converter.MemberConverter;
import ICT_Team2.ITS_Back_End_main.domain.common.BaseEntity;

import ICT_Team2.ITS_Back_End_main.domain.enums.Priority;
import ICT_Team2.ITS_Back_End_main.domain.enums.Status;
import ICT_Team2.ITS_Back_End_main.domain.mapping.AssigneeMember;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
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
    private Member fixer;

    @ManyToOne
    @JoinColumn(name = "reporter_id")
    private Member reporter;

    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL)
    private List<AssigneeMember> assigneeMemberList = new ArrayList<>();

    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20)")
    private Status status;

    @CreatedDate
    private LocalDateTime reportedDate;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20)")
    private Priority priority;

    @Column(nullable = true, length = 20)
    private String category;

    private Long score;

    public void updateFixer(Member fixer) {
        this.fixer = fixer;
    }
}
