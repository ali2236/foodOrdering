package aligator.models;

public class Meal extends Food {

    private Integer servingSize;

    public Meal(String name, Double price, Integer amount,Boolean servedHot,Integer servingSize) {
        super(name, price, amount,servedHot);
        this.servingSize = servingSize;
    }

    public String getServingSize() {
        if (servingSize!=-1){
            return servingSize.toString();
        } else {
            return "-";
        }
    }

    public void setServingSize(Integer servingSize) {
        if (servingSize>0){
            this.servingSize = servingSize;
        } else {
            this.servingSize = -1;
        }
    }
}
