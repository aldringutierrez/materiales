import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TutorialTableComponent } from './tutorial-table.component';

describe('TutorialTableComponent', () => {
  let component: TutorialTableComponent;
  let fixture: ComponentFixture<TutorialTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TutorialTableComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TutorialTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
