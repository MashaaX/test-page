import java.util.Scanner;
class EmployeeSalary{
    public static void main(String[] args) {
        
        int salary,salarytotal;
        int healthInsurance = 200000;

        Scanner sc = new Scanner(System.in);

        System.out.print("Input Salary:\t");
        salary = sc.nextInt();
        
        int tax = (salary*10/100);

        salarytotal = salary-tax-healthInsurance;

        System.out.println("Salary total:\t" + salarytotal);
    }
}