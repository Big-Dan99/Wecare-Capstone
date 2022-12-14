import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoachRegistrationComponent } from './coach-registration.component';

describe('CoachRegistrationComponent', () => {
  let component: CoachRegistrationComponent;
  let fixture: ComponentFixture<CoachRegistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoachRegistrationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CoachRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
