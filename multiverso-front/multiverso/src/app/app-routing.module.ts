import { NavComponent } from './components/nav/nav.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ListaLivrosComponent } from './components/livro/lista-livros/lista-livros.component';
import { NewLivroComponent } from './components/livro/new-livro/new-livro.component';

const routes: Routes = [
  {
    path: '', component: NavComponent, children: [
      { path: 'home', component: HomeComponent },
      { path: 'new-livro', component: NewLivroComponent},
      { path: 'lista-livros', component: ListaLivrosComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
