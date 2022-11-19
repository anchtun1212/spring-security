
export class Loans {

  public number: number;
  public customerId: number;
  public startDate: Date;
  public type: string;
  public totalLoan: number;
  public amountPaid: number;
  public outstandingAmount: number;
  
  constructor(loanNumber?: number,customerId?: number,startDt?: Date, loanType?: string,
    totalLoan?: number,amountPaid?: number, outstandingAmount?: number){
        this.number = loanNumber || 0;
        this.customerId = customerId || 0;
        this.startDate = startDt!;
        this.type = loanType || "";
        this.totalLoan = totalLoan || 0;
        this.amountPaid = amountPaid || 0;
        this.outstandingAmount = outstandingAmount || 0;
  }

}
