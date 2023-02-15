package com.thebookStore.app;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thebookStore.app.entity.Cart;
import com.thebookStore.app.exception.BooksException;
import com.thebookStore.app.exception.CartException;
import com.thebookStore.app.exception.UsersException;
import com.thebookStore.app.service.CartService;

@SpringBootTest
public class CartServiceTest {
	
	@Autowired
	 private CartService cartService;

	 

	 @Test
	 void addBookToCartByUserIdTest() throws CartException, BooksException, UsersException{
		 assertNotNull(cartService.addBookToCartByUserId(2,1));

	 }

	 @Test
	 void updatecartTest() throws CartException{
		 assertNotNull(cartService.updateCart(new Cart(1,100.0f,null)));

	 }

	 @Test
	 void updatecartTestException() {
		 assertThrows(CartException.class,()->cartService.getCartById(500));

	 }

	 @Test
	 void getCartByIdTest() throws CartException{
	     assertNotNull(cartService.getCartById(1));

	 }

	 @Test
	 void getCartByIdTestException() {
		 assertThrows(CartException.class,()->cartService.getCartById(500));
	 }
	 
	 @Test
	 void deleteCartByIdTest() throws CartException{
	 assertNotNull(cartService.deleteCartById(1));
	 }

	 @Test
	 void deleteCartByIdTestException() {
	 assertThrows(CartException.class,()->cartService.deleteCartById(1));
	 }

	 @Test

	 void removeBookfromCartByIdsTest() throws CartException{
	 assertNotNull(cartService.removeBookfromCartByIds(12, 14));
	 }

	 @Test
	 void removeBookfromCartByIdsTestException() {
	 assertThrows(CartException.class,()->cartService.removeBookfromCartByIds(500,600));

	 }

	 

	 

	

}
