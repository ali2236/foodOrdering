package aligator.models;

import javafx.scene.paint.Color;

public class Drink extends Food {

    private double volume;
    private Color color;

    public Drink(String name, Long price, Integer amount,Boolean servedHot,double volume) {
        super(name, price, amount, servedHot);
        setVolume(volume);
    }


    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        if (volume >= 0f){
            this.volume = volume;
        }
    }

    public Color getColor() {
        return color;
    }
}
