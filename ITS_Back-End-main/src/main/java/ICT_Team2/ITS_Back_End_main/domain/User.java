package ICT_Team2.ITS_Back_End_main.domain;

import ICT_Team2.ITS_Back_End_main.domain.common.BaseEntity;
import ICT_Team2.ITS_Back_End_main.domain.enums.Role;
import ICT_Team2.ITS_Back_End_main.domain.enums.Status;
import ICT_Team2.ITS_Back_End_main.domain.mapping.AssigneeMember;
import ICT_Team2.ITS_Back_End_main.domain.mapping.Member;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String signId;
    private String password;
    private String name;
    private LocalDate inactiveDate;
    private boolean isDeleted;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Member> memberList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<AssigneeMember> assigneeMemberList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();

    public void setRole(Role role) {
        this.role=role;
    }

    public void setStatus(Status status) {
        this.status=status;

    }
}
