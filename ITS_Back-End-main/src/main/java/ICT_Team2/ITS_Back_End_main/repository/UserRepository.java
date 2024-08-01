package ICT_Team2.ITS_Back_End_main.repository;

import ICT_Team2.ITS_Back_End_main.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
