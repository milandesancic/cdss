import { Component, OnInit } from '@angular/core';
import { ReportServiceService } from '../../service/report-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  selectedReport;
  reportData;
  showTable = false;
  constructor(private reportService: ReportServiceService, private router: Router) {
    this.reportData = [];
  }

  ngOnInit() {
    this.selectedReport = 1;
    this.reportService.clearReportData();
    this.reportData = [];
  }

  getReport() {
    console.log(this.selectedReport);
    this.reportService.clearReportData();

    if (this.selectedReport == 1) {
      console.log("chronic");
      this.reportService.getReport('/api/patients/with_chronic').subscribe(
        data => {
          this.reportData = data;
          this.showTable = this.haveReport();
          console.log(this.showTable);
          console.log(data);
        }
      );
    }

    if (this.selectedReport == 2) {
      console.log("addicts");
      this.reportService.getReport('/api/patients/addicts').subscribe(
        data => {
          this.reportData = data;
          this.showTable = this.haveReport();
          console.log(this.showTable);
          console.log(data);
        }
      );
    }

    if (this.selectedReport == 3) {
      console.log("immunity");
      this.reportService.getReport('/api/patients/weak_immunity').subscribe(
        data => {
          this.reportData = data;
          this.showTable = this.haveReport();
          console.log(this.showTable);
          console.log(data);
        }
      );
    }
  }

  haveReport() {
    console.log(this.reportData);
    if (this.reportData.length>=1) {
      return true;
    }
    return false;
  }

}
