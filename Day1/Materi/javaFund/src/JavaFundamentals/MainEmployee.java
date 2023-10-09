package JavaFundamentals;

public class MainEmployee {
    public static void main(String[] args) {
        RegularEmployee emp1 = new RegularEmployee(11, "Ryan", 2500000,1000000);
        ContractEmployee emp2 = new ContractEmployee(12, "Kurnia", 250000, "5 Years");
        System.out.println("Nama Employee Pertama : "+ emp1.getName() + " (Id = "+emp1.getId()+")");
        System.out.println("Nama Employee Kedua : "+ emp2.getName() + " (Id = "+emp2.getId()+")");
        System.out.println(emp2.toString());
        emp2.work();
    }
}
