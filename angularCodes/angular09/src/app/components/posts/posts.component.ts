import { Component, OnInit } from '@angular/core';
//需要使用到模块，HttpClient HttpHeaders
import {HttpClient,HttpHeaders} from '@angular/common/http'

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {

  userInfo:any={username:'请输入姓名',age:'0'}
  url="http://127.0.0.1:3000/doLogin";

  constructor(public http:HttpClient) { }

  ngOnInit(): void {
  }

  doPost(){
      let options ={ 
        headers: new HttpHeaders({'Content-Type':'application/json'})
      } ;
        console.log("doPost start...");
      //post方法 
      //url：
      //body:是客户端提交的数据
      //options:headers属性是必须传值的
      let body = {username:this.userInfo.username,age:this.userInfo.age};
      this.http.post(this.url,body,options).subscribe(response=>{
        console.log(response);
      });
  }


  doJsonp(){
    console.log("jsonp start..") 
    this.url="http://a.itying.com/api/productlist";
    this.http.jsonp(this.url,"callback").subscribe((respose)=>{
      console.log(respose)
    })
 }
}
