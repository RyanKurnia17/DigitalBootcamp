package JavaFundamentals;
public class ContractEmployee extends Employee {
    private float payPerHour;
    private String contractPeriod;

    public ContractEmployee() {
    }

    public ContractEmployee(float payPerHour, String contractPeriod){
        this.payPerHour = payPerHour;
        this.contractPeriod = contractPeriod;
    }

    public  ContractEmployee(int id, String name, float payPerHour, String contractPeriod){
        super(id,name);
        this.payPerHour = payPerHour;
        this.contractPeriod = contractPeriod;
    }

    public float getPayPerHour() {
        return payPerHour;
    }

    public void setPayPerHour(float payPerHour) {
        this.payPerHour = payPerHour;
    }

    public String getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(String contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    @Override
    public String toString() {
        return "ContractEmployee{" +
                "payPerHour=" + payPerHour +
                ", contractPeriod='" + contractPeriod + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void work() {
        System.out.println("Tugas Kontrak Employee");
    }
}
