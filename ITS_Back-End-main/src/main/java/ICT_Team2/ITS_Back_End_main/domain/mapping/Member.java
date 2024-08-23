package ICT_Team2.ITS_Back_End_main.domain.mapping;

<<<<<<< HEAD
import ICT_Team2.ITS_Back_End_main.domain.Project;

import ICT_Team2.ITS_Back_End_main.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Getter
@NoArgsConstructor
=======
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
>>>>>>> 8146e61ea944e080fbdeaf825f8c0674470a7e53
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
<<<<<<< HEAD
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
=======
>>>>>>> 8146e61ea944e080fbdeaf825f8c0674470a7e53
}
