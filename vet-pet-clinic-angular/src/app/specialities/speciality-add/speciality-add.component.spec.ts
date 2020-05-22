import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecialityAddComponent } from './speciality-add.component';

describe('SpecialityAddComponent', () => {
  let component: SpecialityAddComponent;
  let fixture: ComponentFixture<SpecialityAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpecialityAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpecialityAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
