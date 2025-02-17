import { Component, OnInit } from '@angular/core';
import { QueryResultsService } from '../../service/query-results.service';

@Component({
  selector: 'app-report-details',
  templateUrl: './report-details.component.html',
  styleUrls: ['./report-details.component.css']
})
export class ReportDetailsComponent implements OnInit {

  data
  constructor(private queryData:QueryResultsService) { }

  ngOnInit() {
    this.data = this.queryData.getData();
  }

}
