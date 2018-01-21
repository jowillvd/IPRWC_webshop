import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BioscoopListComponent } from './list.component';

describe('BioscoopListComponent', () => {
  let component: BioscoopListComponent;
  let fixture: ComponentFixture<BioscoopListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BioscoopListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BioscoopListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
