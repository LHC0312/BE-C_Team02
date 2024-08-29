package ICT_Team2.ITS_Back_End_main.repository;

import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.domain.mapping.AssigneeMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssigneeMemberRepository extends JpaRepository<AssigneeMember, Long> {
    public Optional<AssigneeMember> findByMemberIdAndIssueId(Long memberId, Long issueId);
}
