package Project1.UberX.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Project1.UberX.entity.Users;
import Project1.UberX.entity.Wallet;

@Repository
public interface WalletRepo extends JpaRepository<Wallet, Long>{

	Wallet findByUser(Users user);

}
