import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TutorialsListComponent } from './components/tutorials-list/tutorials-list.component';
import { TutorialDetailsComponent } from './components/tutorial-details/tutorial-details.component';
import { TutorialTableComponent } from './components/tutorial-table/tutorial-table.component';
import { AddTutorialComponent } from './components/add-tutorial/add-tutorial.component';
import {About3Component  } from './components/about3/about3.component';

const routes: Routes = [
  { path: '', redirectTo: 'items', pathMatch: 'full' },
  { path: 'items2', component: TutorialTableComponent },
  { path: 'items', component: TutorialsListComponent },
  { path: 'items/:id', component: TutorialDetailsComponent },
  { path: 'add', component: AddTutorialComponent },
  { path: 'about3', component: About3Component }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
