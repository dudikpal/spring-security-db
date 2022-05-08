package spring.training.springsecuritydb;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PlayerService implements UserDetailsService {

    private PlayerRepository playerRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        log.info("Load player by playername");

        return playerRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Player not found"));
    }
}
