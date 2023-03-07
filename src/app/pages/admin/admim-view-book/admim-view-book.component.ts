import { Component } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admim-view-book',
  templateUrl: './admim-view-book.component.html',
  styleUrls: ['./admim-view-book.component.css']
})
export class AdmimViewBookComponent {
  bookList: any[] = [];
  constructor(private admin: AdminService) { }
  ngOnInit() {
    this.admin.getAllBooks().subscribe(res => {
      this.bookList = res as any[];
    });
  }
}
