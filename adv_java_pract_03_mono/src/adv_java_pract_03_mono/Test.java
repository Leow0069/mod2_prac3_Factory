package adv_java_pract_03_mono;

import java.math.BigDecimal;

/**
 * Driver class
 * 
 * @author Angeline Tan
 */
public class Test {
    
    /**
     * Main method
     * @param args commandline arguments (not used)
     */
    public static void main(String[] args) {
        DoverBranch dover01 = new DoverBranch();
        StudentLoan s1 = dover01.applyForStudentLoan(20_000, 0, 10);
        System.out.print(s1);
        BigDecimal[] stat = s1.optimumRepaymentWithInterest();
        System.out.printf("Optimum Repayment Amount: $%.2f\n", stat[0].doubleValue());
        System.out.printf("Total Interest: $%.2f\n\n", stat[1].doubleValue());
        
        
        DoverBranch dover02 = new DoverBranch();
        HomeLoan h1 = dover02.applyForHomeLoan(350_000, 25_000, 300);
        System.out.print(h1);
        BigDecimal[] stat2 = h1.optimumRepaymentWithInterest();
        System.out.printf("Optimum Repayment Amount: $%.2f\n", stat2[0].doubleValue());
        System.out.printf("Total Interest: $%.2f\n\n", stat2[1].doubleValue());
        
        
        BukitTimahBranch bt02 = new BukitTimahBranch();
        StudentLoan s2 = bt02.applyForStudentLoan(50_000, 0, 48);
        System.out.print(s2);
        BigDecimal[] stat4 = s2.optimumRepaymentWithInterest();
        System.out.printf("Optimum Repayment Amount: $%.2f\n", stat4[0].doubleValue());
        System.out.printf("Total Interest: $%.2f\n\n", stat4[1].doubleValue());
        
        
        BukitTimahBranch bt01 = new BukitTimahBranch();
        HomeLoan h2 = bt01.applyForHomeLoan(1550_000, 100_000, 360);
        System.out.print(h2);
        BigDecimal[] stat3 = h2.optimumRepaymentWithInterest();
        System.out.printf("Optimum Repayment Amount: $%.2f\n", stat3[0].doubleValue());
        System.out.printf("Total Interest: $%.2f\n\n", stat3[1].doubleValue());
        
        
        BukitTimahBranch bt03 = new BukitTimahBranch();
        CarLoan c1 = bt03.applyForCarLoan(80_000, 5_000, 60);
        System.out.print(c1);
        BigDecimal[] stat5 = c1.optimumRepaymentWithInterest();
        System.out.printf("Optimum Repayment Amount: $%.2f\n", stat5[0].doubleValue());
        System.out.printf("Total Interest: $%.2f\n\n", stat5[1].doubleValue());
    }

}
