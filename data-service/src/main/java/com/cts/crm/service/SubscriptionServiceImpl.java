package com.cts.crm.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cts.crm.config.PropertiesConfig;
import com.cts.crm.model.Subscription;
import com.cts.crm.repo.SubscriptionRepo;

@Service
@Repository
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	SubscriptionRepo subscriptionRepo;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	PropertiesConfig properties;
	
	@Override
	public Subscription getSubscriptionById(int id) {
		Optional<Subscription> subscription = subscriptionRepo.findById(id);
		return subscription.orElse(null);
	}
	
	@Override
	public List<Subscription> getAllSubscriptions() {
		return subscriptionRepo.findAll();
	}
	
	@Override
	public List<Subscription> viewActiveSubscriptions(int customerId) {
		return subscriptionRepo.viewActiveSubscriptions(customerId);
	}

	@Override
	public void inactiveSubscription(int id) {
		subscriptionRepo.inactiveSubscription(id);
	}

	@Override
	public Subscription createSubscription(Subscription subscription) {
		return subscriptionRepo.save(subscription);
	}

	@Override
	public List<Subscription> getAllSubscriptionsOfToday() {
		return subscriptionRepo.findAllSubscriptionsOfToday();
	}

//	https://mkyong.com/spring/spring-jdbctemplate-batchupdate-example/
//	https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/jdbc.html
	@Override
	public void batchInactiveSubscription(List<Subscription> subscriptions) {

		String query=properties.getSubscriptionUpdateQuery();
		
		//Without Batch Size
//		BatchPreparedStatementSetter batchPreparedStatementSetter = new BatchPreparedStatementSetter() {
//			
//			@Override
//			public void setValues(PreparedStatement ps, int i) throws SQLException {
//				ps.setInt(1, subscriptions.get(i).getId());				
//			}
//			
//			@Override
//			public int getBatchSize() {
//				return subscriptions.size();
//			}
//		};
//		jdbcTemplate.batchUpdate(query,batchPreparedStatementSetter);
		
		//With Batch Size
		int batchSize=100;
//		ParameterizedPreparedStatementSetter<Subscription> parameterizedPreparedStatementSetter = new ParameterizedPreparedStatementSetter<Subscription>() {
//
//			@Override
//			public void setValues(PreparedStatement ps, Subscription argument) throws SQLException {
//				ps.setInt(1, argument.getId());
//			}
//			
//		};
		ParameterizedPreparedStatementSetter<Subscription> parameterizedPreparedStatementSetter = (ps,sub) -> {ps.setInt(1, sub.getId());};
		jdbcTemplate.batchUpdate(query, subscriptions, batchSize, parameterizedPreparedStatementSetter);
		
	}

	

}
