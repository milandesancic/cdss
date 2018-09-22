import { Component, OnInit } from '@angular/core';
import { MedicineService } from '../../service/medicine.service';
import { MedicineComponentService } from '../../service/medicine-component.service';
import { forEach } from '@angular/router/src/utils/collection';
import { PatientService } from '../../service/patient.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {


  allMedicine;
  allMedicineComponent;

  firstName;
  lastName;

  patientMedicineAllergies: Array<any> = [];
  patientMedicineComponentAllergies: Array<any> = [];
  constructor(private medicineService: MedicineService, private medicineComponentService: MedicineComponentService,
    private patientService: PatientService, private router: Router) { }

  ngOnInit() {
    this.medicineService.getAll().subscribe(
      data => { this.allMedicine = data; }
    );

    this.medicineComponentService.getAll().subscribe(
      data => { this.allMedicineComponent = data; }
    );
  }


  onChangeMedicine(name: string, isChecked: boolean) {
    if (isChecked) {
      this.patientMedicineAllergies.push(name);
    } else {
      let index = this.patientMedicineAllergies.indexOf(name);
      this.patientMedicineAllergies.splice(index, 1);
    }
  }


  onChangeMedicineComponent(name: string, isChecked: boolean) {
    if (isChecked) {
      this.patientMedicineComponentAllergies.push(name);
    } else {
      let index = this.patientMedicineComponentAllergies.indexOf(name);
      this.patientMedicineComponentAllergies.splice(index, 1);
    }
  }

  collectData() {
    // console.log(this.firstName);
    // console.log(this.lastName);
    // console.log(this.patientMedicineComponentAllergies);
    // console.log(this.patientMedicineAllergies);
    let patientData = {};
    patientData['firstName'] = this.firstName;
    patientData['lastName'] = this.lastName;
    patientData['medicineAllergies'] = [];
    for (let s of this.patientMedicineAllergies) {
      patientData['medicineAllergies'].push({ 'name': s });
    }
    patientData['componentAllergies'] = [];
    for (let s of this.patientMedicineComponentAllergies) {
      patientData['componentAllergies'].push({ 'name': s });
    }
    // console.log(patientData);

    this.patientService.savePatient(patientData).subscribe(
      data => {
        console.log(data);
        this.router.navigate(['/home']);
      }
    )

  }

}
