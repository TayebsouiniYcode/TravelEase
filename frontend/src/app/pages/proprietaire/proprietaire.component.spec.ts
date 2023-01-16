import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProprietaireComponent } from './proprietaire.component';

describe('ProprietaireComponent', () => {
  let component: ProprietaireComponent;
  let fixture: ComponentFixture<ProprietaireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProprietaireComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProprietaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
