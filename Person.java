/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package People;

/**
 *
 * @author osboxes
 */
public class Person {

    private String name;
    private double money;
    
    public Person() {
        this.name="N/A";
        this.money=0.00;
    }

    /*public Person(String pname, double pmoney) {
        this.name = pname;
        this.money = pmoney;
    }   Was not specified in the assignment */
    
    public String walk()
    {
        return this.name + " is walking";
    }
    
    public void spendMoney(double moneda){
        this.money-= moneda;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", money=" + money + '}';
    }
}
