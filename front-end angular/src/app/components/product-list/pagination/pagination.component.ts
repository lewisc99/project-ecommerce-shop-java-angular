import { Component, OnInit, Output,EventEmitter } from '@angular/core';


@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.css']
})
export class PaginationComponent implements OnInit {

  constructor() { }

  @Output() indexPagination = new EventEmitter<number>();

  ngOnInit(): void {
  }

  Pagination(event:number)
  {
    
    this.indexPagination.emit(event);
    console.log(event)
  }
}
