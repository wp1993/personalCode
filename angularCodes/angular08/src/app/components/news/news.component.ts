//从外部导入其他接口使用
import { Component, OnInit } from '@angular/core';
//声明这是一个组件
// selector 组件名称
// templateUrl 视图地址
// 样式地址
//
@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
//导出组件模块，组件最终是需要被其他模块引入并使用的
export class NewsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

//父组件定义的方法
  run(){
    alert('我是父组件的方法，被子组件执行了');
  }
}
