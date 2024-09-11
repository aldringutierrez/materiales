import { Component } from '@angular/core';
import { Material } from '../../models/material.model';
import { TutorialService } from '../../services/tutorial.service';

@Component({
  selector: 'app-add-tutorial',
  templateUrl: './add-tutorial.component.html',
  styleUrls: ['./add-tutorial.component.css'],
})
export class AddTutorialComponent {
  tutorial: Material = {
    nombre: '',
    descripcion: '',
    tipo: ''
  };
  submitted = false;

  constructor(private tutorialService: TutorialService) {}

  saveTutorial(): void {
    console.log('saveTutorial() '+this.tutorial.nombre+'   '+this.tutorial.descripcion);
    const data = {
      //id:88,
      nombre: this.tutorial.nombre,
      descripcion: this.tutorial.descripcion
    };

    this.tutorialService.create(data).subscribe({
      next: (res) => {
        console.log('xxxxxxxxxxxxxxxxxxx  :'+res);
        this.submitted = true;
      },
      error: (e) => console.error(e)
    });

  }

  newTutorial(): void {
    this.submitted = false;
    this.tutorial = {
      nombre: '',
      descripcion: '',
      tipo: ''
    };
  }
}
