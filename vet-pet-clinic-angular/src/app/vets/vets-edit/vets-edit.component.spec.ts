import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VetsEditComponent } from './vets-edit.component';

describe('VetsEditComponent', () => {
  let component: VetsEditComponent;
  let fixture: ComponentFixture<VetsEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VetsEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VetsEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
