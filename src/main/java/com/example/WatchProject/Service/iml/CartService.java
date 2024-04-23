package com.example.WatchProject.Service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WatchProject.Entity.CartEntity;
import com.example.WatchProject.Repository.CartRepository;
import com.example.WatchProject.Service.ICartService;

import jakarta.transaction.Transactional;

@Service
public class CartService implements ICartService{
	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public Boolean addProductToCart(CartEntity cartEntity) {
		try {
			this.cartRepository.save(cartEntity);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Transactional
	@Override
	public void delProductCart(int account_id) {
		
			 this.cartRepository.delProductCart(account_id);
		
	}

	@Override
	public List<CartEntity> listCart(int account_id) {
		return this.cartRepository.listCart(account_id);
	}

	@Override
	public int totalCart(int account_id) {
		if(!this.cartRepository.listCart(account_id).isEmpty()) {
			return this.cartRepository.Total(account_id);
		}
		return 0;
	}
	@Transactional
	@Override
	public void updateProductCart(int quantity, int product_id) {
		
			this.cartRepository.updateProductCart(quantity, product_id);
			
		
		
	}

	@Override
	public CartEntity findProductFromCart(int product_id, int account_id) {
		return this.cartRepository.findProductFromCart(product_id, account_id);
	}
	@Transactional
	@Override
	public void delOneProductCart(int account_id, int product_id) {
		
			this.cartRepository.delOneProductCart(account_id, product_id);
			
		
}
}
