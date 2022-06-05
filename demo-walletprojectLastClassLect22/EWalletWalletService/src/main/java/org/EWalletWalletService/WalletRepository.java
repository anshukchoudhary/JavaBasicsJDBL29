package org.EWalletWalletService;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {

	Wallet findByUserId(int userId);
	
	@Modifying
	@Transactional
	@Query("update Wallet w set w.balance = w.balance + ?2 where w.userId =?1")
	void updateWallet(int userId, Double amount);

}
