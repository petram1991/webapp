package org.example.domain;

import lombok.*;
import org.example.util.PasswordUtils;

import javax.persistence.*;




@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u ORDER BY u.username DESC"),
        @NamedQuery(name = User.FIND_BY_USERNAME_PASSWORD, query = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
})
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User {
    public static final String FIND_BY_USERNAME_PASSWORD = "User.findByUsernameAndPassword";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String email;
    private String password;

    @PrePersist
    private void setUUID() {
        password = PasswordUtils.digestPassword(password);
    }
}
