package com.example.QLBDH1.Service;

import java.util.List;

import com.example.QLBDH1.Entity.CartEntity;

public interface ICartService {
	Boolean addProductToCart(CartEntity cartEntity);
	Boolean delProductCart(int account_id);
	List<CartEntity> listCart(int account_id);
	int totalCart(int account_id);
}
