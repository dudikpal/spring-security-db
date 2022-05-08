package spring.training.springsecuritydb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, String> {

    @Query("select distinct p from Player p left join fetch p.roles where p.email = :email")
    Optional <Player> findUserByEmail(String email);
}
