//导入Input
import { Component, OnInit ,Input} from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor() { }
  //引入父组件传递过来的信息，用变量receivedMsg接收
  @Input('forChile') receivedMsg:any;
  //引入方法
  @Input('method') gotMethod:any;
  ngOnInit(): void {
  }

  execute(){
    //执行方法
    this.gotMethod() ;
  }

}
