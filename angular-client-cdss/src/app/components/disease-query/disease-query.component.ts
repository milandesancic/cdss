import { Component, OnInit } from '@angular/core';
import { QueryResultsService } from '../../service/query-results.service';

@Component({
  selector: 'app-disease-query',
  templateUrl: './disease-query.component.html',
  styleUrls: ['./disease-query.component.css']
})
export class DiseaseQueryComponent implements OnInit {

  data;

  constructor(private queryData:QueryResultsService) { }

  ngOnInit() {
    this.data = this.queryData.getData();
  }

}
