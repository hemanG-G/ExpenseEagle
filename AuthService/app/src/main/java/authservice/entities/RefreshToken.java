package authservice.entities;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Table(name = "tokens")
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // basically type of auto increment
    private int id;

    private String token;

    private Instant expiryDate;


    // the ONE - ONE relationship in ER diagram b/w users table's U_name & roles table's Token
    // 1 user id has 1 role id
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "user_id") // map current table's token id to user id ( one to one )
    private UserInfo userInfo; // no need to create new table , stored withing this UserInfo Table itself
}
