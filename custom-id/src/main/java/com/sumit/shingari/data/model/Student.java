package com.sumit.shingari.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student {
	
	
	
	@Id
    @GeneratedValue(generator = "sequence-generator")
	 @GenericGenerator(name = "sequence-generator", 
	 parameters = @Parameter(name = "prefix", value = "SUMIT"), 
	 strategy = "com.sumit.shingari.custom.generator.MyGenerator")
	@Column(name = "id_student")
	private Long idStudent;

	@Column(name = "school")
	private String school;

	@Lob
	@Column(name = "student_name")
	private String studentName;
}
