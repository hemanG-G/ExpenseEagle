package authservice.repository;

import authservice.entities.RefreshToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Repositories in spring boot are used to interact with the database

@Repository
public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Integer>  // built in CRUD interface in java spring boot
{
    Optional<RefreshToken> findByToken(String token); // this is equivalent to the sql query : select * from refresh_token where token = token
    //optionals in java are used to avoid null pointer exceptions
}
