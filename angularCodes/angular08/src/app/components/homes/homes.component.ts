import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-homes',
  templateUrl: './homes.component.html',
  styleUrls: ['./homes.component.css']
})
export class HomesComponent implements OnInit {

  constructor() { }
  //父组件通过调用子组件定义的title属性绑定一个值
  title='我是父组件home给我的title信息';

  ngOnInit(): void {
    
  }

}
