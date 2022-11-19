
export class Account {

  public customerId: number;
  public number: number;
  public type: string;
  public branchAddress: string;
  

  constructor(customerId?: number,accountNumber?: number,accountType?: string, branchAddress?: string){
        this.customerId = customerId || 0;
        this.number = accountNumber || 0;
        this.type = accountType || '';
        this.branchAddress = branchAddress || '';
  }

}
