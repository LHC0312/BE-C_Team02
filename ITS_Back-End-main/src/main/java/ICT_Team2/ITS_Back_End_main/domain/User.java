package ICT_Team2.ITS_Back_End_main.domain;

import ICT_Team2.ITS_Back_End_main.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "fixer", cascade = CascadeType.ALL)
    private List<Issue> FixerList;

    @OneToMany(mappedBy = "reporter", cascade = CascadeType.ALL)
    private List<Issue> reporterList;
}
