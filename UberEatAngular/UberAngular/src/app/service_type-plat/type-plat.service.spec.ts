import { TestBed } from '@angular/core/testing';

import { TypePlatService } from './type-plat.service';

describe('TypePlatService', () => {
  let service: TypePlatService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TypePlatService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
