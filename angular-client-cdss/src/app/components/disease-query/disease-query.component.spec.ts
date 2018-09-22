import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiseaseQueryComponent } from './disease-query.component';

describe('DiseaseQueryComponent', () => {
  let component: DiseaseQueryComponent;
  let fixture: ComponentFixture<DiseaseQueryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiseaseQueryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiseaseQueryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
