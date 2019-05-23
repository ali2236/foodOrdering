package aligator.models;

public abstract class Food extends Product {

    private Boolean servedHot;
    private Integer calories;

    public Food(String name,Float price,Integer amount,Boolean servedHot){
        super(name,price,"بدون توضیحات",amount);
        this.servedHot = servedHot;
    }

    public Boolean getServedHot() {
        return servedHot;
    }

    public String getCalories() {
        if (calories!=-1){
            return calories.toString();
        } else {
            return "-";
        }
    }

    public void setCalories(Integer calories) {
        if (calories > 0){
            this.calories = calories;
        } else {
            this.calories = -1;
        }
    }
}
