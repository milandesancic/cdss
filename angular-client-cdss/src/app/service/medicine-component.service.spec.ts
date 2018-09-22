import { TestBed, inject } from '@angular/core/testing';

import { MedicineComponentService } from './medicine-component.service';

describe('MedicineComponentService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MedicineComponentService]
    });
  });

  it('should be created', inject([MedicineComponentService], (service: MedicineComponentService) => {
    expect(service).toBeTruthy();
  }));
});
