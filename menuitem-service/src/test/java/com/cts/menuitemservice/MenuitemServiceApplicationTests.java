package com.cts.menuitemservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.cts.menuitemservice.dao.MenuItemDaoImpl;
import com.cts.menuitemservice.model.MenuItem;
import com.cts.menuitemservice.service.MenuItemServiceImpl;

@SpringBootTest
class MenuitemServiceApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	@Mock
	MenuItemDaoImpl menuItemDaoImpl;
	@InjectMocks
	MenuItemServiceImpl menuItemServiceImpl;
	@Before(value = "")
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void addMenuItemAdminTest()
	{
		MenuItem sweetItem1 = new MenuItem(1,"Jalebi","Sweet Item",new Date(01/01/2020),(float)120,true,true);
		menuItemServiceImpl.addMenuItem(sweetItem1);
		verify(menuItemDaoImpl,times(1)).addMenuItem(sweetItem1);
	}
	
	@Test
	public void getMenuItemListAdminTest()
	{
		
		List<MenuItem> menuItemListAdmin = new ArrayList<MenuItem>();
		MenuItem sweetItem1 = new MenuItem(1,"Jalebi","Sweet Item",new Date(01/01/2020),(float)120,true,true);
		MenuItem sweetItem2 = new MenuItem(2,"Pavbhaji","Lunch",new Date(01/11/2020),(float)125,true,true);
		MenuItem sweetItem3 = new MenuItem(3,"Pizza","Dinner",new Date(01/02/2020),(float)399,true,true);
		
		menuItemListAdmin.add(sweetItem1);
		menuItemListAdmin.add(sweetItem2);
		menuItemListAdmin.add(sweetItem3);
		
		when(menuItemDaoImpl.getMenuItemListAdmin()).thenReturn(menuItemListAdmin);
		
		//test
		List<MenuItem> menuItemList = menuItemServiceImpl.getMenuItemListAdmin();
		
		assertEquals(3, menuItemList.size());
		verify(menuItemDaoImpl,times(1)).getMenuItemListAdmin();
	}
	
	@Test
	public void getSweetItemListCustomerTest()
	{
	List<MenuItem> menuItemListCustomer= new ArrayList<MenuItem>();
	MenuItem sweetItem1 = new MenuItem(1,"Jalebi","Sweet Item",new Date(01/01/2020),(float)120,true,true);
	MenuItem sweetItem2 = new MenuItem(2,"Pavbhaji","Lunch",new Date(01/11/2020),(float)125,true,true);
	MenuItem sweetItem3 = new MenuItem(3,"Pizza","Dinner",new Date(01/02/2020),(float)399,true,true);
		menuItemListCustomer.add(sweetItem1);
		menuItemListCustomer.add(sweetItem2);
		menuItemListCustomer.add(sweetItem3);
		
		when(menuItemDaoImpl.getMenuItemListCustomer()).thenReturn(menuItemListCustomer);
		
		//test
		List<MenuItem> sweetItemList = menuItemServiceImpl.getMenuItemListCustomer();
		
		assertEquals(3, sweetItemList.size());
		verify(menuItemDaoImpl,times(1)).getMenuItemListCustomer();
	}
//	
	@Test
	public void getSweetItemTest()
	{
	MenuItem sweetItem1 = new MenuItem(3,"Pizza","Dinner",new Date(01/02/2020),(float)456,true,true);
	when(menuItemDaoImpl.getMenuItem(1)).thenReturn(sweetItem1);
	MenuItem expected = menuItemServiceImpl.modifyMenuItem(1, sweetItem1);
	assertThat(expected).isNotNull();
	}
//	
	@Test
	public void removeSweetItemTest()
	{
	MenuItem sweetItem1 = new MenuItem(3,"Pizza","Dinner",new Date(01/02/2020),(float)399,true,true);
	when(menuItemDaoImpl.removeMenuItem(1)).thenReturn(sweetItem1);
	MenuItem expected = menuItemServiceImpl.modifyMenuItem(1, sweetItem1);
	assertThat(expected).isNotNull();
	}
//	
	@Test
	public void modifySweetItemTest()
	{
		MenuItem sweetItem1 = new MenuItem(3,"Pizza","Dinner",new Date(01/02/2020),(float)399,true,true);
		when(menuItemDaoImpl.modifyMenuItem(1, sweetItem1)).thenReturn(sweetItem1);
		MenuItem expected = menuItemServiceImpl.modifyMenuItem(1, sweetItem1);
		assertThat(expected).isNotNull();
	}

}
