package com.cts.crm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.crm.model.Subscription;

public interface SubscriptionDao extends JpaRepository<Subscription,Integer>{

}
