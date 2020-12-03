package com.cts.cartservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "user_carts")
@Data
@Slf4j
@NoArgsConstructor
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Min(value = 1,message = "{user_id.message}")
	@Column(name = "user_id")
	private int user_id;
	
	@Min(value = 1,message = "{item_id.message}")
	@Column(name = "item_id")
	private int item_id;
	
	//constructor
	public Cart(int user_id,int item_id){
		this.user_id=user_id;
		this.item_id=item_id;
		log.info("Cart object created.");
	}
}