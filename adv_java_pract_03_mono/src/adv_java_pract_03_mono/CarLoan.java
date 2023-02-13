package adv_java_pract_03_mono;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Class to calculate the optimum repayment amount with interest for the car loan.<br>
 * It also calculates the total amount of interest payable for the repayment period.
 * 
 * @author Angeline Tan
 */
public class CarLoan {
    /**
     * Annual percentage rate, aka interest rate
     */
    private BigDecimal annualRates;
    /**
     * Initial loan amount, down payment already subtracted from this amount
     */
    private BigDecimal principle;
    /**
     * Length of the loan period in months/ total number of payments, assuming monthly repayments
     */
    private int termInMonths;
    /**
     * Type of loan
     */
    private String loanType;
    
    /**
     * Constructor for the Car loan
     * 
     * @param principle Initial loan amount, down payment already subtracted from this amount
     * @param apr Annual percentage rate, aka interest rate
     * @param mths Length of the loan period in months
     * @param branch Bank branch name
     */
    public CarLoan(BigDecimal principle, BigDecimal apr, int mths, String branch) {
        if (mths < 0) mths = 0;
        
        this.principle = principle;
        // Rounds up the annual percentage rates to the nearest whole number then divide by 100
        this.annualRates = apr.setScale(0, RoundingMode.UP).divide(
                                new BigDecimal(100), 6, RoundingMode.UP);
        this.termInMonths = mths;
        this.loanType = "Car" + " ("+branch+")";
    }
    
    
    /**
     * Calculates the optimum repayment amount with interest and the total interest payable
     * for the principle amount, interest rates and loan period. <br> 
     * It returns an array of size 2:<br>
     * 1. optimum repayment amount <br>
     * 2. total interest payable
     * 
     * @return An array of BigDecimal
     */
    public BigDecimal[] optimumRepaymentWithInterest() {
        BigDecimal[] results = new BigDecimal[2];
        
        // Convert to some weird Monthly interest rate (divide by 9)
        BigDecimal mthInterestRate = this.annualRates.divide(new BigDecimal(9),
                                            6, RoundingMode.UP);
        // exponent calculation
        BigDecimal temp = new BigDecimal(1);
        for (int i=0; i<this.termInMonths; i++) {
            temp = temp.multiply((new BigDecimal(1)).add(mthInterestRate))
                    .setScale(6, RoundingMode.UP);
        }
        BigDecimal numerator = mthInterestRate.multiply(temp);
        BigDecimal denominator = temp.subtract(new BigDecimal(1));
        
        // optimum repayment amount
        results[0] = this.principle.multiply(numerator)
                        .divide(denominator, 6, RoundingMode.UP)
                        .setScale(2, RoundingMode.UP);
        
        // total interest
        results[1] = results[0].multiply(BigDecimal.valueOf(this.termInMonths))
                        .subtract(principle);
        
        return results;
    }
    
    /**
     * Overridden toString method from Object class.
     */
    @Override
    public String toString() {
        return String.format("""
                Loan type: %s
                Principle: $%.2f
                Annual Percentage Rate: %.2f%%
                Term (in months): %d
                """,
                this.loanType,
                this.principle.doubleValue(),
                this.annualRates.multiply(new BigDecimal(100)),
                this.termInMonths);
    }
}
