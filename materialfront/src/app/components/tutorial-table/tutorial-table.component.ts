import { Component, OnInit } from '@angular/core';
import { Material } from '../../models/material.model';
import { TutorialService } from '../../services/tutorial.service';
import {MatTableDataSource} from '@angular/material/table';


export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

@Component({
  selector: 'app-tutorial-table',
  templateUrl: './tutorial-table.component.html',
  styleUrl: './tutorial-table.component.css'
})


export class TutorialTableComponent {
  tutorials?: Material[];
  currentTutorial: Material = {};
  currentIndex = -1;
  title = '';

  displayedColumns: string[] = ['nombre', 'descripcion','tipo','estado','precio','fechaCompra','fechaVenta','ciudad'];
  dataSource2 = new MatTableDataSource(this.tutorials);

  constructor(private tutorialService: TutorialService) {}

  ngOnInit(): void {
    this.retrieveTutorials();


    this.dataSource2 = new MatTableDataSource(this.tutorials);
  }

  retrieveTutorials(): void {
    console.log('qqqq : getall')
    this.tutorialService.getAll().subscribe({
      next: (data) => {
        this.tutorials = data;
        this.dataSource2 = new MatTableDataSource(this.tutorials);
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

  refreshList(): void {
    this.retrieveTutorials();
    this.currentTutorial = {};
    this.currentIndex = -1;
  }

  setActiveTutorial(tutorial: Material, index: number): void {
    this.currentTutorial = tutorial;
    this.currentIndex = index;
  }

  removeAllTutorials(): void {
    this.tutorialService.deleteAll().subscribe({
      next: (res) => {
        console.log(res);
        this.refreshList();
      },
      error: (e) => console.error(e)
    });
  }

  searchTitle(): void {
    console.log('xxxxxxxxxxxx  search')
    this.currentTutorial = {};
    this.currentIndex = -1;
    this.tutorialService.findByTitle(this.title).subscribe({
      next: (data) => {
        this.tutorials = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }




}
