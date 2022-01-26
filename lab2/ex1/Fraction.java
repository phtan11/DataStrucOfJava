package lab2.ex1;

public class Fraction {
    private int number;
    private int denom;
    public Fraction(){
        setNumber(0);
        setDenom(1);
    }
    public Fraction(int x, int y){
        this.setNumber(x);
        this.setDenom(y);
    }
    // public Fraction(Fraction f){
        
    // }
    public int getDenom() {
        return denom;
    }
    public void setDenom(int denom) {
        this.denom = denom;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    private static int gcd(int a,int b){
        int rem;
        while(b>0){
            rem = a%b;
            a=b;
            b = rem;
        }
        return a;
    }
    public Fraction simplify(){
        int number = this.getNumber();
        int denom = this.getDenom();
        int gcd =gcd(Math.abs(number),denom);
        return new Fraction(number/gcd,denom/gcd);
    }
    public String toString(){
        return "(" +this.getNumber() + "," + this.getDenom() +")";
    }
    public boolean equals(Object o){
        if(o instanceof Fraction){
            Fraction f1 = (Fraction)o;
            f1=f1.simplify();
            Fraction f2 = this.simplify();
            return f1.getNumber() == f2.getNumber() && f1.getDenom() == f2.getDenom();
        }
        else return false;
    }
}
