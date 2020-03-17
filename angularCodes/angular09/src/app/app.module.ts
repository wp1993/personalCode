import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
//引入HttpClientModule模块
import {HttpClientModule} from '@angular/common/http';
import {FormsModule}   from '@angular/forms';

import { AppComponent } from './app.component';
import { GetsComponent } from './components/gets/gets.component';
import { PostsComponent } from './components/posts/posts.component';

@NgModule({
  declarations: [
    AppComponent,
    GetsComponent,
    PostsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
