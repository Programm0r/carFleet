package model;

public class Car {
    private String brandName;
    private String modelName;
    private double modelPrice;
    private String modelYear;
    private double rangeDriven;
    private boolean damages;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public double getModelPrice() {
        return modelPrice;
    }

    public void setModelPrice(double modelPrice) {
        this.modelPrice = modelPrice;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public double getRangeDriven() {
        return rangeDriven;
    }

    public void setRangeDriven(double rangeDriven) {
        this.rangeDriven = rangeDriven;
    }

    public boolean isDamages() {
        return damages;
    }

    public void setDamages(boolean damages) {
        this.damages = damages;
    }
}
