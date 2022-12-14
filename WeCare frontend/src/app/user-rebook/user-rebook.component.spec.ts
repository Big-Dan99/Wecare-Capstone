import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserRebookComponent } from './user-rebook.component';

describe('UserRebookComponent', () => {
  let component: UserRebookComponent;
  let fixture: ComponentFixture<UserRebookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserRebookComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserRebookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
