import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VetsAddComponent } from './vets-add.component';

describe('VetsAddComponent', () => {
  let component: VetsAddComponent;
  let fixture: ComponentFixture<VetsAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VetsAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VetsAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
