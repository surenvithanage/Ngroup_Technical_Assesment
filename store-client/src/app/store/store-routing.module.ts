import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IndexComponent } from './index/index.component';
import { ViewComponent } from './view/view.component';
import { CreateComponent } from './create/create.component';
import { EditComponent } from './edit/edit.component';

const routes: Routes = [
  { path: '', redirectTo: 'store/index', pathMatch: 'full'},
  { path: 'store/index', component: IndexComponent },
  { path: 'store/:storeId/view', component: ViewComponent },
  { path: 'store/create', component: CreateComponent },
  { path: 'store/:storeId/edit', component: EditComponent } 
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StoreRoutingModule { }
