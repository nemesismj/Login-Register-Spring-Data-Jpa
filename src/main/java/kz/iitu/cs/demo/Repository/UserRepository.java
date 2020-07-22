package kz.iitu.cs.demo.Repository;

import kz.iitu.cs.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
   //List<User> findByUserName(String username);
}
