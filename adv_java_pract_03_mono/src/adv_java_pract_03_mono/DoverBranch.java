package adv_java_pract_03_mono;

import java.math.BigDecimal;

/**
 * Bank branch for the residental district of Dover.
 * <p>
 * This branch has the following avaliable loans:<br>
 * 1. Student<br>
 * 2. Home
 * 
 * @author Angeline Tan
 */
public class DoverBranch {
    /**
     * Name of the branch
     */
    private String name;
    
    /**
     * Constructor for the branch
     */
    public DoverBranch() {
        this.name = "Dover Branch";
    }
    
    /**
     * Creates a new Student loan
     * @param principle the amount loaned
     * @param downPayment amount payable to offset principle amount
     * @param termMths length of the loan repayment period in months
     * @return new Student Loan
     */
    public StudentLoan applyForStudentLoan(double principle, double downPayment, int termMths) {
        return new StudentLoan(new BigDecimal(principle).subtract(new BigDecimal(downPayment)),
                        new BigDecimal(2), termMths, this.name);
        
    }
    
    /**
     * Creates a new Home loan
     * @param principle the amount loaned
     * @param downPayment amount payable to offset principle amount
     * @param termMths length of the loan repayment period in months
     * @return new Home Loan
     */
    public HomeLoan applyForHomeLoan(double principle, double downPayment, int termMths) {
        return new HomeLoan(new BigDecimal(principle).subtract(new BigDecimal(downPayment)),
                        new BigDecimal(5), termMths, this.name);
        
    }
}
