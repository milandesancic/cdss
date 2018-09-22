import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SymptomQueryComponent } from './symptom-query.component';

describe('SymptomQueryComponent', () => {
  let component: SymptomQueryComponent;
  let fixture: ComponentFixture<SymptomQueryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SymptomQueryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SymptomQueryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
