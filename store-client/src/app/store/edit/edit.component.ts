import { Component, OnInit } from '@angular/core';
import { StoreService } from '../store.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Store } from '../store';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  id!: number;
  store!: Store;
  form!: FormGroup;

  constructor(
    public storeService: StoreService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['storeId'];
    this.storeService.find(this.id).subscribe((data: any) => {
      const filteredList = data.data.filter((i: { key: string; }) => i.key === 'STORE_OBJECT');
      this.store = filteredList[0]['value'];
    });

    this.form = new FormGroup({
      id: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required]),
      category: new FormControl('', Validators.required),
      address: new FormControl('', [Validators.required]),
      geolocation: new FormControl('', Validators.required),
      image: new FormControl('', [Validators.required]),
      description: new FormControl('', Validators.required)
    });
  }

  get f() {
    return this.form.controls;
  }

  submit() {
    this.storeService.update(this.form.value).subscribe(res => {
      this.router.navigateByUrl('store/index');
    })
  }

}