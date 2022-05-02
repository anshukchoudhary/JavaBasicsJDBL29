package com.example.minor.project.demominorproject1may;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;

	private String name;

	private int cost;

	@Enumerated(value = EnumType.STRING)
	private Category category;

	private String isbn;

	@ManyToOne
	@JoinColumn
	private Author author;

	@CreationTimestamp
	private Date createdOn;

	@UpdateTimestamp
	private Date updatedOne;
	
	@ManyToOne
	@JoinColumn
	private Student student;
	
	
	

}

// ManyToOne
// ManyToMany
// OneToOne
// OneToMany
