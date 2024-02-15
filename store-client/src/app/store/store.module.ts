import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StoreRoutingModule } from './store-routing.module';
import { IndexComponent } from './index/index.component';
import { ViewComponent } from './view/view.component';
import { CreateComponent } from './create/create.component';
import { EditComponent } from './edit/edit.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import { FilterPipe } from '../filter.pipe';


@NgModule({
  declarations: [
    IndexComponent,
    ViewComponent,
    CreateComponent,
    EditComponent,
    FilterPipe
  ],
  imports: [
    CommonModule,
    StoreRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgxPaginationModule
  ]
})
export class StoreModule { }
