import { Component, OnInit } from '@angular/core';
import { StoreService } from '../store.service';
import { Store } from '../store';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  stores: any = [];
  searchText!: string;
  p: number = 1;

  constructor(public storeService: StoreService) { }

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.storeService.getAll().subscribe((data: any) => {
      const filteredList = data.data.filter((i: { key: string; }) => i.key === 'STORE_LIST');
      this.stores = filteredList[0]['value'];
    })
  }

  deleteStore(id: any) {
    this.storeService.delete(id).subscribe(res => {
      this.list();
    })
  }

}