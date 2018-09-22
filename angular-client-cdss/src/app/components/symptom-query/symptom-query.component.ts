import { Component, OnInit } from '@angular/core';
import { QueryResultsService } from '../../service/query-results.service';

@Component({
  selector: 'app-symptom-query',
  templateUrl: './symptom-query.component.html',
  styleUrls: ['./symptom-query.component.css']
})
export class SymptomQueryComponent implements OnInit {

  data;
  constructor(private queryData:QueryResultsService) { }

  ngOnInit() {
    this.data = this.queryData.getData();
  }

}
