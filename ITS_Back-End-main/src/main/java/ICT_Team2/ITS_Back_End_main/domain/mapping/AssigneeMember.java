package ICT_Team2.ITS_Back_End_main.domain.mapping;

import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.domain.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AssigneeMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "issue_id")
    private Issue issue;
}
