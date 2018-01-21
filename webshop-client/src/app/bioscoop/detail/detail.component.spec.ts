import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BioscoopDetailComponent } from './detail.component';

describe('BioscoopDetailComponent', () => {
  let component: BioscoopDetailComponent;
  let fixture: ComponentFixture<BioscoopDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BioscoopDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BioscoopDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
