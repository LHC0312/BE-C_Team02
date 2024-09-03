package ICT_Team2.ITS_Back_End_main.repository;

import ICT_Team2.ITS_Back_End_main.domain.mapping.ProjectMembership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectMembershipRepository extends JpaRepository<ProjectMembership, Long> {
    Optional<List<ProjectMembership>> findByMemberId(Long memberId);
    Optional<List<ProjectMembership>> findByProjectId(Long projectId);
    Optional<ProjectMembership> findByMemberIdAndProjectId(Long MemberId, Long projectId);
}
