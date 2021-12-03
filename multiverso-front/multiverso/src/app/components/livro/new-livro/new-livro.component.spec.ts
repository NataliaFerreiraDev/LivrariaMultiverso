import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewLivroComponent } from './new-livro.component';

describe('NewLivroComponent', () => {
  let component: NewLivroComponent;
  let fixture: ComponentFixture<NewLivroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewLivroComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewLivroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
