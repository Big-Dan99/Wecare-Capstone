import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserHomepComponent } from './user-homep.component';

describe('UserHomepComponent', () => {
  let component: UserHomepComponent;
  let fixture: ComponentFixture<UserHomepComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserHomepComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserHomepComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
