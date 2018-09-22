import { Component, OnInit } from '@angular/core';
import { SymptomService } from '../../service/symptom.service';

@Component({
  selector: 'app-diagnose',
  templateUrl: './diagnose.component.html',
  styleUrls: ['./diagnose.component.css']
})
export class DiagnoseComponent implements OnInit {

  allSymptoms;
  patientSymptoms: Array<any>=[];

  constructor(private symptomService: SymptomService) { }

  ngOnInit() {
    this.symptomService.getAll().subscribe(
      data => {
        this.allSymptoms = data;
      }
    )
  }

  onChange(name: string, isChecked: boolean) {
    if (isChecked) {
      this.patientSymptoms.push(name);
    } else {
      let index = this.patientSymptoms.indexOf(name);
      this.patientSymptoms.splice(index, 1);
    }
  }

  test(){
    console.log(this.patientSymptoms);
  }

}
