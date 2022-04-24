package com.exampleSqlIntergation.demoSql.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BModel {

	int id;
	String name;
	String authorName;
	int price;
	String publisher;
	long editionNo;

}