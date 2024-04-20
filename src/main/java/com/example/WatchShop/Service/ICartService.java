package com.example.WatchShop.Service;

import java.util.List;

import com.example.WatchShop.Entity.CartEntity;

public interface ICartService {
	Boolean addProductToCart(CartEntity cartEntity);
	Boolean delProductCart(int account_id);
	Boolean updateProductCart(int quantity,int product_id);
	Boolean delOneProductCart(int account_id,int product_id);
	List<CartEntity> listCart(int account_id);
	CartEntity findProductFromCart(int product_id,int account_id);
	int totalCart(int account_id);
}
