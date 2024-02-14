import { Component, OnInit } from '@angular/core';
import { StoreService } from '../store.service';
import { ActivatedRoute } from '@angular/router';
import { Store } from '../store';
  
@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {
   
  id!: number;
  store!: Store;
   
  constructor(
    public storeService: StoreService,
    private route: ActivatedRoute
   ) { }
  
  ngOnInit(): void {
    this.id = this.route.snapshot.params['storeId'];
      
    this.storeService.find(this.id).subscribe((data: any)=>{
      const filteredList = data.data.filter((i: { key: string; }) => i.key === 'STORE_OBJECT');
      this.store = filteredList[0]['value'];
    });
  }
  
}