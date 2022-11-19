
export class Cards {

  public number: string;
  public customerId: number;
  public type: string;
  public totalLimit: number;
  public amountUsed: number;
  public availableAmount: number;
  
  constructor(cardNumber?: string,customerId?: number,cardType?: string,
    totalLimit?: number,amountUsed?: number, availableAmount?: number){
        this.number = cardNumber || "";
        this.customerId = customerId || 0;
        this.type = cardType || "";
        this.totalLimit = totalLimit || 0;
        this.amountUsed = amountUsed || 0;
        this.availableAmount = availableAmount || 0;
  }

}
