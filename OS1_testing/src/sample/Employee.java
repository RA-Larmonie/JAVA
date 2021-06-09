package sample;

public class Employee extends person {
    String JOB_FUNCTION;

    public Employee(String name, int age, String function){
        super(name, age);
        this.JOB_FUNCTION = function;
    }
}
