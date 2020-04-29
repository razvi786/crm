package com.cts.crm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cts.crm.model.Subscription;

public interface SubscriptionRepo extends JpaRepository<Subscription, Integer> {
	
	@Query("FROM Subscription sub WHERE sub.customerId.id=?1 AND sub.active=TRUE")
	public List<Subscription> viewActiveSubscriptions(int customerId);
	
	@Transactional
	@Modifying
	@Query("UPDATE Subscription sub SET sub.active=FALSE WHERE sub.id=?1")
	public void inactiveSubscription(int id);

}
