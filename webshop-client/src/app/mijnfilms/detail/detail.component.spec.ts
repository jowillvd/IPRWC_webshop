import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MijnfilmsDetailComponent } from './detail.component';

describe('DetailComponent', () => {
  let component: MijnfilmsDetailComponent;
  let fixture: ComponentFixture<MijnfilmsDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MijnfilmsDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MijnfilmsDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
