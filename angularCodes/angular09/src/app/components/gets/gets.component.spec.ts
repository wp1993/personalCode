import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetsComponent } from './gets.component';

describe('GetsComponent', () => {
  let component: GetsComponent;
  let fixture: ComponentFixture<GetsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
