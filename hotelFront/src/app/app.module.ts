import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListComponent } from './list/list.component';
import { Routes, RouterModule } from '@angular/router';
import { SearchComponent } from './search/search.component';
import { SearchPipe } from './search.pipe';
import { FormsModule } from '@angular/forms';
const appRoutes: Routes =[
  {
    path: '',
    component: ListComponent
  }

]
@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    SearchComponent,
    SearchPipe,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [

    SearchPipe,
],
  

})
export class AppModule { }
