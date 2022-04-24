package com.exampleSqlIntergation.demoSql.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
//@Table(name = "my_hospital")
@Data
public class HospitalEntity extends JpaRepository{

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	int id;
	String name;
	String address;
	int age;
	String doctorName;
	@CreationTimestamp
	Date createdOn;
	
	
	//jakarta persistence api ----@Id, @Column, @Table
	//jpa - find(), save(),deleted();
	//hibernate core - it is implementaion of ORM framwork for spring data jpa

}
