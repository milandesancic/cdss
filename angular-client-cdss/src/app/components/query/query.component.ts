import { Component, OnInit } from '@angular/core';
import { DiseaseService } from '../../service/disease.service';
import { SymptomService } from '../../service/symptom.service';
import { Router } from '@angular/router';
import { QueryResultsService } from '../../service/query-results.service';

@Component({
  selector: 'app-query',
  templateUrl: './query.component.html',
  styleUrls: ['./query.component.css']
})
export class QueryComponent implements OnInit {

  classDisease = {
    'nav-link': true,
    'active': true
  };
  classSymptom = {
    'nav-link': true,
    'active': false
  };
  show = 'disease';

  allDisease;
  selectedDisease;

  allSymptoms;
  selectedSymptoms: Array<any> = [];

  constructor(private diseaseService: DiseaseService, private symptomService: SymptomService,
    private router: Router, private queryResults: QueryResultsService) { }

  ngOnInit() {
    this.selectedDisease = 1;
    this.diseaseService.getAll().subscribe(
      data => {
        this.allDisease = data;
      }
    )
    this.symptomService.getAll().subscribe(
      data => {
        this.allSymptoms = data;
      }
    )
  }


  onChange(name: string, isChecked: boolean) {
    if (isChecked) {
      this.selectedSymptoms.push(name);
    } else {
      let index = this.selectedSymptoms.indexOf(name);
      this.selectedSymptoms.splice(index, 1);
    }
  }

  getSymptoms() {
    this.symptomService.getByDisease(this.selectedDisease).subscribe(
      data => {
        this.queryResults.setData(data,{'disease':this.allDisease[this.selectedDisease].name});
        console.log(data);
        this.router.navigate(['/query/symptoms']);
      }
    );
  }

  getDiseases() {
    let requestData = [];
    for (let s of this.selectedSymptoms) {
      requestData.push({ 'name': s });
    }
    this.diseaseService.getBySymptoms(requestData).subscribe(
      data => {
        this.queryResults.setData(data,{"symptoms":this.selectedSymptoms});
        console.log(data);
        this.router.navigate(['/query/disease'])
      }
    );
  }

  colNum(i) {
    if (i % 2 == 0)
      return true;
    else
      return false;
  }

  toggleQuery(queryType) {
    if (queryType == 'disease') {
      this.show = queryType;
      this.classDisease = {
        'nav-link': true,
        'active': true
      };
      this.classSymptom = {
        'nav-link': true,
        'active': false
      };
    } else {
      this.show = queryType;
      this.classDisease = {
        'nav-link': true,
        'active': false
      };
      this.classSymptom = {
        'nav-link': true,
        'active': true
      };
    }
  }

}
