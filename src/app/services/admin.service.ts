import { Injectable } from '@angular/core';
import { AlertService } from './alert.service';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(
    private api: ApiService,
    private alert: AlertService
  ) { }



  getAllOrders() {
    return this.api.get(`/orders`);
  }
  getAllCustomers() {
    return this.api.get(`/api/users`);
  }

  getAllPayments() {
    return this.api.get(`/payment/show-payment`);
  }

  // BOOKS
  addBook(data: any) {
    this.api.post('/book', data).subscribe((res: any) => {
      this.alert.success(res?.message || 'Book registration successful.')
    }, this.alert.apiFail);
  }
  getAllBooks() {
    return this.api.get(`/books`);
  }

  updateOrder(data: any) {
    this.api.put(`/order`, data).subscribe((res: any) => {
      this.alert.success(res?.message || 'Order Updated')
    }, this.alert.apiFail);
  }

  //RANDOM
  genRandomId() {
    return Math.floor(Math.random() * 100000);
  }
  addCategory(data: any) {
    this.api.post('/category', data).subscribe((res: any) => {
      this.alert.success(res?.message || 'Category registration successful.')
    }, this.alert.apiFail);
  }
}
