package com.cts.cartservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.cartservice.dao.CartDaoImpl;
import com.cts.cartservice.exception.CartNotFoundException;
import com.cts.cartservice.exception.MenuItemNotFoundException;
import com.cts.cartservice.model.Cart;
import com.cts.cartservice.model.MenuItem;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartDaoImpl cartDaoImpl;

	@Override
	public void addCartItem(int userId, Cart cart) throws MenuItemNotFoundException {

		cartDaoImpl.addCartItem(userId, cart);

	}

	@Override
	public ArrayList<MenuItem> getAllCartItems(int userId) throws CartNotFoundException{

		return cartDaoImpl.getAllCartItems(userId);
	}

	@Override
	public void deleteCartItem(int userId, Cart cart) throws MenuItemNotFoundException{

		cartDaoImpl.deleteCartItem(userId, cart);
	}

}