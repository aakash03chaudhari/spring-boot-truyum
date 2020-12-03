package com.cts.menuitemservice.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="menuitem")
public class MenuItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int menuItemId;

	@NotNull(message = "{menuItemName.message}")
	@Size(min = 3 ,max = 30,message = "{menuItemName.message}")
	private String menuItemName;
	
	@NotNull(message = "{menuItemCategory.message}")
	@Size(min = 3 ,max = 30,message = "{menuItemCategory.message}")
	private String menuItemCategory;
	
	@NotNull(message = "{menuItemDateOfLaunch.message}")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private Date menuItemDateOfLaunch;
	
	@NotNull(message = "{menuItemPrice.message}")
	@Min(value = 10,message = "{menuItemPrice.message}")
	private float menuItemPrice;
	
	private boolean menuItemActive;
	
	private boolean menuItemFreeDelivery;

}
