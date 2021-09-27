package ru.skillbox;

public class Dimensions {
    private final double height;
    private final double width;
    private final double length;

    public Dimensions(double height, double width, double length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    /* public Dimensions setDimensios(double height, double width, double length)
       {
         return new Dimensions(getHeight(),getWidth(),getLength());
       }
    */
    public double getHeight() {return height;}
    public double getWidth() {return width;}
    public double getLength() {return length;}

    public Dimensions setHeight(double height) {
        return new Dimensions(height,width,length);
    }
    public Dimensions setWidth(double width) {
        return new Dimensions(height,width,length);
    }
    public Dimensions setLength(double length) {
        return new Dimensions(height,width,length);
    }
    public double calculationOfDimensions()
    {
        return getHeight() * getWidth() * getLength();
    }
}
