package com.cts.cartservice.service;

import java.util.ArrayList;

import com.cts.cartservice.exception.CartNotFoundException;
import com.cts.cartservice.exception.MenuItemNotFoundException;
import com.cts.cartservice.model.Cart;
import com.cts.cartservice.model.MenuItem;

public interface CartService {

	// to add item in given user cart
	void addCartItem(int userId, Cart cart) throws MenuItemNotFoundException;

	// fetch all items in given user cart
	ArrayList<MenuItem> getAllCartItems(int userId) throws CartNotFoundException;

	// delete item from given user and cart
	void deleteCartItem(int userId, Cart cart) throws MenuItemNotFoundException;
}
