package com.exampleSqlIntergation.demoSql.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleSqlIntergation.demoSql.models.HospitalEntity;

public interface HospitalRepo extends JpaRepository<HospitalEntity,Integer>{

	
	
	
}
