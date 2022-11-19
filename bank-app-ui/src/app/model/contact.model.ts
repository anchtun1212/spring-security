
export class Contact {

  public id: string;
  public name: string;
  public email: string;
  public subject: string;
  public message: string;
  
  constructor(contactId?: string,contactName?: string,contactEmail?: string,
    subject?: string,message?: string){
        this.id = contactId || '';
        this.name = contactName || '';
        this.email = contactEmail || '';
        this.subject = subject || '';
        this.message = message || '';
        
  }

}
