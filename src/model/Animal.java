package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table // Chỉ định đây là một Bảng
@Entity // Chỉ định đây là một Thực thể
public class Animal {
	
	@Id // Đánh dấu Primary Key
	@GeneratedValue(strategy=GenerationType.IDENTITY) // IDENTITY(1,1)
	private Long id;
	
	@Column(nullable=false, length=100) // NOT NULL
	private String name;
	
	@Column(nullable=true) // NULL
	private Float weight;
	
	@Column(nullable=false)
	private Boolean gender;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	
}
