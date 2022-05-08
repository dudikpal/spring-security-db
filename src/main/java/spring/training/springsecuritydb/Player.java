package spring.training.springsecuritydb;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "players")
public class Player implements UserDetails {

    @Id
    private String email;

    private String name;

    private String password;

    @Column(name = "is_enabled")
    private boolean enabled;

    @ElementCollection
    @CollectionTable(name = "authorities",
    joinColumns = @JoinColumn(name = "email"))
    @Column(name = "authority")
    private List <String> roles;

    @Override
    public Collection <? extends GrantedAuthority> getAuthorities() {

        return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .toList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
