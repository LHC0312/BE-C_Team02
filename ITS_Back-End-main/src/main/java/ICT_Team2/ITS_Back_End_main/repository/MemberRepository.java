package ICT_Team2.ITS_Back_End_main.repository;

import ICT_Team2.ITS_Back_End_main.domain.mapping.ProjectMembership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<ProjectMembership, Long> {
    List<ProjectMembership> findByUserId(long userId);
}
