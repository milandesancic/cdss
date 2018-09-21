export class LoggedUtils {
    static getId() {
      if (this.isEmpty()) {
        return null;
      }
      return JSON.parse(localStorage.getItem('loggedUser')).id;
    }
  
    static getToken() {
      if (this.isEmpty()) {
        return '';
      }
      return JSON.parse(localStorage.getItem('loggedUser')).token;
    }
  
    static getRole() {
      if (this.isEmpty()) {
        return null;
      }
      return JSON.parse(localStorage.getItem('loggedUser')).role;
    }
  
    static clearLocalStorage() {
      localStorage.clear();
    }
  
    static isEmpty() {
      return localStorage.getItem('loggedUser') === null;
    }
  
    static getUsername() {
      return JSON.parse(localStorage.getItem('loggedUser')).username;
    }
  
    static getUser() {
      return JSON.parse(localStorage.getItem('loggedUser'));
    }
  
    static getLoggedUser() {
      return localStorage.getItem('loggedUser');
  
    }
  
  }
  