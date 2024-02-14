import { Component, OnInit } from '@angular/core';
import { StoreService } from '../store.service';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  form!: FormGroup;

  constructor(
    public postService: StoreService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.form = new FormGroup({
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
    this.postService.create(this.form.value).subscribe(res => {
      this.router.navigateByUrl('store/index');
    })
  }

}