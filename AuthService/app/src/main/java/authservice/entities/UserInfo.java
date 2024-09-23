package authservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserInfo {

    @Id
    @Column(name = "user_id")
    private String userId;

    private String username;

    private String password;


    // That table which is created for each many to many relationship b/w users table ka user_id and roles table ka role_id
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles", // name of that separate  table for this many to many relationship
            joinColumns = @JoinColumn(name = "user_id"), // join this column to
            inverseJoinColumns = @JoinColumn(name = "role_id")  // join with this column
    )
    // one id has multiple roles
    private Set<UserRole> roles = new HashSet<>();

}
