import { Component, OnInit } from '@angular/core';
import {users} from '../mockUsers' ;
@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
//getting the users list from the mockUsers.ts file
userArray = users;
  constructor() { }

  ngOnInit() {
  }

}
