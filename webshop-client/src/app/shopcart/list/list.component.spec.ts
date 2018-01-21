import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopcartListComponent } from './list.component';

describe('ShopcartListComponent', () => {
  let component: ShopcartListComponent;
  let fixture: ComponentFixture<ShopcartListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShopcartListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShopcartListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
