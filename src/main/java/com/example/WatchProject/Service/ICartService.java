package com.example.WatchProject.Service;

import java.util.List;

import com.example.WatchProject.Entity.CartEntity;

public interface ICartService {
	Boolean addProductToCart(CartEntity cartEntity);
	void delProductCart(int account_id);
	void updateProductCart(int quantity,int product_id);
	void delOneProductCart(int account_id,int product_id);
	List<CartEntity> listCart(int account_id);
	CartEntity findProductFromCart(int product_id,int account_id);
	int totalCart(int account_id);
}
