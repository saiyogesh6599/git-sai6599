package Project1.UberX.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Project1.UberX.entity.Driver;

@Repository
public interface DriverRepo extends JpaRepository<Driver,Long>{
	

}
