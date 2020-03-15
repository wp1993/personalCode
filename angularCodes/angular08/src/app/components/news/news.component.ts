import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

//父组件定义的方法
  run(){
    alert('我是父组件的方法，被子组件执行了');
  }
}
