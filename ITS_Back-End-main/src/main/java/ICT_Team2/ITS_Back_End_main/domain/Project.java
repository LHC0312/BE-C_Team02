package ICT_Team2.ITS_Back_End_main.domain;

import ICT_Team2.ITS_Back_End_main.domain.common.BaseEntity;
import ICT_Team2.ITS_Back_End_main.domain.enums.Status;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

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
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
}

