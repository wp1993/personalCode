import { Component, OnInit } from '@angular/core';

import  {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-gets',
  templateUrl: './gets.component.html',
  styleUrls: ['./gets.component.css']
})
export class GetsComponent implements OnInit {

  getResult:any=[];
  //加载对象
  constructor(public http:HttpClient) { }

  ngOnInit(): void {
  }

  doGet(){
    var url="http://a.itying.com/api/productlist";
    //get() 像服务器发送请求
    this.http.get(url).subscribe((response)=>{
      this.getResult = response;
      console.log(response);
    });
  }
}
