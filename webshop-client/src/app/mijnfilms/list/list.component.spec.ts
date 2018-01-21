import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MijnfilmsListComponent } from './list.component';

describe('ListComponent', () => {
  let component: MijnfilmsListComponent;
  let fixture: ComponentFixture<MijnfilmsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MijnfilmsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MijnfilmsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
