package kuis1;

public class Engine {
    private String brand;
    private double speed;

    public Engine() {
    }
    
    public void setBrand(String Enginebrand){
        this.brand = Enginebrand;
    } 
    public String getBrand(){
        return brand;
    }
    public void increaseSpeed(){
        if(brand.equalsIgnoreCase("Honda")){
            if(speed < 100){
             speed = speed + 10;
             if(speed > 100){
                 speed = 100;
             }
            }
        }else if (brand.equalsIgnoreCase("Yamaha")){
            if(speed < 120){
                speed = speed + 15;
                if (speed > 120) {
                    speed = 120;
                }
            }
        }
    }
    public void reduceSpeed(){
        if(speed != 0){
            if(brand.equalsIgnoreCase("Honda")){
                speed = speed - 5;
            }else{
                speed = speed - 10;
            }   
        }else{
            speed = 0;
        }
    }
    public double getSpeed(){
    return speed;
    }
}
