package lab4.ex2;

public class Student {
    private String name;
    private double mathematics;
    private double programming;
    private double DSA1;
    private double avg;
    public Student(){}
    public Student(String name, double Mathematics, double Programming, double DSA1){
        this.name = name;
        this.mathematics = Mathematics;
        this.programming = Programming;
        this.DSA1 = DSA1;
    }
    public String getName() {
        return name;
    }
    public double getAvg() {
        return (getMathematics() + getProgramming()+getDSA1()) /3;
    }
    public void setAvg(double avg) {
        this.avg = avg;
    }
    public double getDSA1() {
        return DSA1;
    }
    public void setDSA1(double dSA1) {
        this.DSA1 = dSA1;
    }
    public double getProgramming() {
        return programming;
    }
    public void setProgramming(double programming) {
        this.programming = programming;
    }
    public double getMathematics() {
        return mathematics;
    }
    public void setMathematics(double mathematics) {
        this.mathematics = mathematics;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "[" + getName() + "," + getMathematics()+"," + getProgramming() + "," + getDSA1() +"," + getAvg()+"]";
    }
}
