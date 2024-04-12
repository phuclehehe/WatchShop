package com.example.WatchProject.Service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WatchProject.Entity.CartEntity;
import com.example.WatchProject.Repository.CartRepository;
import com.example.WatchProject.Service.ICartService;

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

	@Override
	public Boolean delProductCart(int account_id) {
		try {
			return this.cartRepository.delProductCart(account_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<CartEntity> listCart(int account_id) {
		return this.cartRepository.listCart(account_id);
	}

	@Override
	public int totalCart(int account_id) {
		return this.cartRepository.Total(account_id);
	}

}
