package Project1.UberX.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Project1.UberX.entity.Users;

@Repository
public interface UsersRepo  extends JpaRepository<Users, Long>{

}
