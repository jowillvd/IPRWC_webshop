import { TestBed, inject } from '@angular/core/testing';

import { BioscoopService } from './bioscoop.service';

describe('BioscoopService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BioscoopService]
    });
  });

  it('should be created', inject([BioscoopService], (service: BioscoopService) => {
    expect(service).toBeTruthy();
  }));
});
