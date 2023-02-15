package com.thebookStore.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thebookStore.app.entity.Books;
import com.thebookStore.app.entity.Cart;
import com.thebookStore.app.exception.BooksException;
import com.thebookStore.app.exception.CartException;
import com.thebookStore.app.exception.UsersException;
import com.thebookStore.app.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	private CartService cartService;

	@PostMapping("/cart/{userid}/{bookid}")
	public Cart registerCarts(@PathVariable("userid") Integer userId,@PathVariable("bookid") Integer bookId )throws BooksException, CartException, UsersException {

		return cartService.addBookToCartByUserId(bookId, userId);
	}

	@PutMapping("/cart")
	public Cart CartServiceUpdate(@Valid @RequestBody Cart cart) throws CartException{
		
		return cartService.updateCart(cart);
	}
	
	@DeleteMapping("/cart/{cartId}")
	public Cart cartServiceDelete(@PathVariable("cartId") Integer cartsId) throws CartException {
		
	return cartService.deleteCartById(cartsId);
	}

	@GetMapping("/booksincart/{cartId}")
	public Cart getshowAllBookItems(@PathVariable("cartId") Integer customerId) throws CartException  {

		return cartService.getCartById(customerId);
	}
	
	@GetMapping("/carts")
	public List<Cart> getAllCarts(){
		return cartService.getAllCarts();
	}

	@DeleteMapping("/book/{id}/{cartid}")
	public Books removeBookfromCartByIds(@PathVariable("id") Integer bookId, Integer cartId) throws CartException{

		return cartService.removeBookfromCartByIds(bookId, cartId);
	}
}
