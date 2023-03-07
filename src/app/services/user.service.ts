import { Injectable } from '@angular/core';
import { AlertService } from './alert.service';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(
    private api: ApiService,
    private alert: AlertService
  ) { }

  addToCart(bookid: any) {
    const userid = sessionStorage.getItem("SESSION_USER_ID");
    this.api.post(`/cart/${userid}/${bookid}`, {}).subscribe((res: any) => {
      this.alert.success(res?.message || 'Book added to cart')
    }, this.alert.apiFail);
  }
  placeOrder(data: any) {
    const userid = sessionStorage.getItem("SESSION_USER_ID");
    this.api.post('/addPayment', data.payment).subscribe((pmt: any) => {
      this.api.post(`/order/${userid}`, { ...data, payment: pmt }).subscribe((res: any) => {
        this.alert.success(res?.message || 'Book order placed');

      }, this.alert.apiFail);
    })

  }

  deleteCart(cartId: any) {
    const userid = sessionStorage.getItem("SESSION_USER_ID");
    this.api.delete(`/cart/${cartId}`).subscribe((res: any) => {
      this.alert.success(res?.message || 'Cart Empty')
    }, this.alert.apiFail);
  }



  //  {
  //   payment: {
  //     paymentId: this.user.genRandomId(),
  //       mode: this.paymentMode
  //   },
  // }

  getMyCart() {
    const userid = sessionStorage.getItem("SESSION_USER_ID");
    return this.api.get(`/booksincart/${userid}`);
  }
  getUseInfo() {
    const userid = sessionStorage.getItem("SESSION_USER_ID");
    return this.api.get(`/User/${userid}`);
  }
  getAllCategories() {
    return this.api.get(`/categories`);
  }
  getBooksByName(bookName: any) {
    return this.api.get(`/bookname/${bookName}`);
  }
  getBooksByAuthor(author: any) {
    return this.api.get(`/books/${author}`);
  }


  //RAMDON
  genRandomId() {
    return Math.floor(Math.random() * 100000);
  }
}
