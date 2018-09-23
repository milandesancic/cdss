import { Component, OnInit } from '@angular/core';
import { SymptomService } from '../../service/symptom.service';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { DiseaseService } from '../../service/disease.service';
import { MedicineService } from '../../service/medicine.service';
import { all } from 'q';
import { Router } from '@angular/router';

@Component({
  selector: 'app-diagnose',
  templateUrl: './diagnose.component.html',
  styleUrls: ['./diagnose.component.css']
})
export class DiagnoseComponent implements OnInit {

  patientID;
  allSymptoms;
  patientSymptoms: Array<any> = [];
  tempVal;
  closeResult: string;
  allDisease;
  selectedDiseaseIndex;
  isDiseaseSelected;
  selectedDisease
  allMedicine
  pickedMedicine: Array<any> = [];
  constructor(private symptomService: SymptomService, private modalService: NgbModal,
    private diseaseService: DiseaseService, private medicieService: MedicineService, private router: Router) { }

  ngOnInit() {
    this.selectedDiseaseIndex = 1;
    this.symptomService.getAll().subscribe(
      data => {
        this.allSymptoms = data;
      }
    );
    this.diseaseService.getAll().subscribe(
      data => {
        this.allDisease = data;
      }
    );
    this.medicieService.getAll().subscribe(
      data => {
        this.allMedicine = data;
      }
    );
  }

  onChangeS(name: string, isChecked: boolean) {
    if (isChecked) {
      this.patientSymptoms.push(name);
    } else {
      let index = this.patientSymptoms.indexOf(name);
      this.patientSymptoms.splice(index, 1);
    }
  }
  onChangeMedicine(name: string, isChecked: boolean) {
    if (isChecked) {
      this.pickedMedicine.push(name);
    } else {
      let index = this.pickedMedicine.indexOf(name);
      this.pickedMedicine.splice(index, 1);
    }
  }

  getDisease() {
    let reqData = []
    console.log(this.patientID);
    for (let p of this.patientSymptoms) {
      if (p == "Temperatura") {
        reqData.push({ 'name': p, 'value': this.tempVal });
      } else {
        reqData.push({ 'name': p });
      }
    }
    this.diseaseService.getPossibleDisease(this.patientID, reqData).subscribe(
      data => {
        console.log(data);
        this.selectedDisease = data;
        this.isDiseaseSelected = true;
      },
      error => {
        alert('Bolest nije pronadjena, probajte odabrati drugacije simptome!');
      }
    )
  }

  open(content) {
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
      if (this.closeResult == "Closed with: Pick click") {
        this.selectedDisease = this.allDisease[this.selectedDiseaseIndex];
        this.isDiseaseSelected = true;
      }
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  makeDiagnose() {
    console.log(this.patientID);
    console.log(this.selectedDisease);
    let symptoms = [];
    for (let p of this.patientSymptoms) {
      if (p == "Temperatura") {
        symptoms.push({ 'name': p, 'value': this.tempVal });
      } else {
        symptoms.push({ 'name': p });
      }
    }
    let medicine = [];
    for (let m of this.pickedMedicine) {
      medicine.push(m);
    }

    console.log(symptoms);
    console.log(medicine);
    let reqData = {};
    reqData['disease'] = this.selectedDisease;
    reqData['medicnie'] = medicine;
    reqData['symptoms'] = symptoms;
    console.log(reqData);

    this.diseaseService.makeDiagnose(this.patientID, reqData).subscribe(
      data => {
        if (data['succes']) {
          this.router.navigate(['/home']);
        } else {
          let string = '';
          for (let s of data['allergies']) {
            string = string + s + '\n';
          }
          alert('Pacijent alergican na:\n' + string);
        }
      }
    )

  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

}
