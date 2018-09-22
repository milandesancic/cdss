import { TestBed, inject } from '@angular/core/testing';

import { QueryResultsService } from './query-results.service';

describe('QueryResultsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [QueryResultsService]
    });
  });

  it('should be created', inject([QueryResultsService], (service: QueryResultsService) => {
    expect(service).toBeTruthy();
  }));
});
