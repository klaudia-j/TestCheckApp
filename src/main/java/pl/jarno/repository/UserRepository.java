package pl.jarno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.jarno.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
