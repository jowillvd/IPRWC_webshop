import { TestBed, inject } from '@angular/core/testing';

import { MijnfilmsService } from './mijnfilms.service';

describe('MijnfilmsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MijnfilmsService]
    });
  });

  it('should be created', inject([MijnfilmsService], (service: MijnfilmsService) => {
    expect(service).toBeTruthy();
  }));
});
