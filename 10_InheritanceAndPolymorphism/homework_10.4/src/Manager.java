import java.util.Random;

public class Manager implements Employee{
    private int  fixedSalary;
    public int getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(int fixedSalary) {
        this.fixedSalary = fixedSalary;
    }


    @Override
    public int getMonthSalary() {
        fixedSalary =(int)Math.round(Math.random()*15_000 + 30_000);
        int scale = (int)Math.pow(10,1);
        return (int)(fixedSalary + (((Math.ceil(((Math.random()*(140_000-115_000))+115_000)*scale))/scale))*0.05);
    }


}
