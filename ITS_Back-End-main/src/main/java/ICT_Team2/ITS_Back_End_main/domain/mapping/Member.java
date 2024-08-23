package ICT_Team2.ITS_Back_End_main.domain.mapping;


import ICT_Team2.ITS_Back_End_main.domain.Project;

import ICT_Team2.ITS_Back_End_main.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectId")
    private Project project=new Project();

    public void setProject(Project project) {
        this.project=project;
    }

}
