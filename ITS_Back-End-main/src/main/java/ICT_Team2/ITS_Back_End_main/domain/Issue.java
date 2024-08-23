package ICT_Team2.ITS_Back_End_main.domain;

import ICT_Team2.ITS_Back_End_main.domain.common.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import ICT_Team2.ITS_Back_End_main.domain.enums.Priority;
import ICT_Team2.ITS_Back_End_main.domain.enums.Status;
import ICT_Team2.ITS_Back_End_main.domain.mapping.AssigneeMember;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Issue extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, length = 20)
  private String title;

  @Column(nullable = false)
  private String description;

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "VARCHAR(20)")
  private Status status;

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "VARCHAR(20)")
  private Priority priority;

  @Column(nullable = true, length = 20)
  private String category;

  @Column
  private Long score;

  @Column
  @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL)
  private List<Comment> commentList = new ArrayList<>();

  @JoinColumn
  @ManyToOne(fetch = FetchType.LAZY)
  private Project project = new Project();

}
