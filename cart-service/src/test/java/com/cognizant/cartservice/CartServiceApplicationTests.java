package com.cognizant.cartservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.cts.cartservice.dao.CartDaoImpl;
import com.cts.cartservice.exception.CartNotFoundException;
import com.cts.cartservice.exception.MenuItemNotFoundException;
import com.cts.cartservice.model.MenuItem;
import com.cts.cartservice.service.CartServiceImpl;

@ContextConfiguration
class CartServiceApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	@Mock
	CartDaoImpl cartDaoImpl;
	@InjectMocks
	CartServiceImpl cartServiceImpl;
	@Before(value = "")
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
//	@Test
//	public void addCartItemTest() throws Exception
//	{
//		cartServiceImpl.addCartItem(1,1);
//		verify(cartDaoImpl,times(1)).addCartItem((int)1,(int)1);
//	}
//	@Test
//	public void getAllCartItemsTest() throws CartNotFoundException
//	{
//		List<MenuItem>cartItemList=new ArrayList<MenuItem>();
//		MenuItem sweetItem1 = new MenuItem(1,"Jalebi","Sweet Item",new Date(01/01/2020),(float)120,true,true);
//		MenuItem sweetItem2 = new MenuItem(2,"Pavbhaji","Lunch",new Date(01/11/2020),(float)125,true,true);
//		MenuItem sweetItem3 = new MenuItem(3,"Pizza","Dinner",new Date(01/02/2020),(float)399,true,true);
//		cartItemList.add(sweetItem1);
//		cartItemList.add(sweetItem2);
//		cartItemList.add(sweetItem3);
//		when(cartDaoImpl.getAllCartItems(1)).thenReturn((ArrayList<MenuItem>) cartItemList);
//	List<MenuItem> menuItemList = cartServiceImpl.getAllCartItems(1);
//		
//		assertEquals(3, menuItemList.size());
//		verify(cartDaoImpl,times(1)).getAllCartItems(1);
//	}
}
