package com.tasks.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

public class EntityManagerConfig {

	
	@Configuration
	@EnableTransactionManagement
	public class TransadtionConfig implements TransactionManagementConfigurer {

	    @PersistenceUnit
	    private EntityManagerFactory emf;

	    public PlatformTransactionManager annotationDrivenTransactionManager() {
	        JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(emf);
	        return transactionManager;
	    }
	}
}



