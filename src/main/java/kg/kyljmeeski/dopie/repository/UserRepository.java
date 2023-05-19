package kg.kyljmeeski.dopie.repository;

import kg.kyljmeeski.dopie.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
