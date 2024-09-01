package ICT_Team2.ITS_Back_End_main.repository;

import ICT_Team2.ITS_Back_End_main.domain.Comment;
import ICT_Team2.ITS_Back_End_main.domain.Issue;
import ICT_Team2.ITS_Back_End_main.domain.enums.Status;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
  // 특정 이슈에 대한 모든 댓글을 조회
  Optional<List<Comment>> findByIssue(Issue issue);

  // 특정 사용자가 작성한 모든 댓글을 조회
  Optional<List<Comment>> findByWriterId(Long writerId);

  // 댓글이 특정 상태(Status)를 가진 댓글만 조회
  Optional<List<Comment>> findByStatus(Status status);
}
