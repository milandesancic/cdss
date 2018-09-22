import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class QueryResultsService {

  data ={}
  constructor() {
  }

  public setData(data,infoData) {
    this.data['info'] = infoData;
    this.data['data'] = data;
  }

  public getData() {
    return this.data;
  }
}
