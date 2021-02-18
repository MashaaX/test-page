package kuis1;

public class Motorcycle {
    private Engine engine;
    private String motorcycleBrand;

    public Motorcycle(String motorcycleBrand, String brandEngine) {
        this.motorcycleBrand = motorcycleBrand;
        this.engine = new Engine();
        engine.setBrand(brandEngine);
    }
    public void setMotorcycleBrand(String motorcycleBrand){
        this.motorcycleBrand = motorcycleBrand;
    }
    public String getMotorcycleBrand(){
        return motorcycleBrand;
    }
    public String getEngineBrand(){
        return engine.getBrand();
    }
    public void increaseMotorcycleSpeed(){
        this.engine.increaseSpeed();
        System.out.println(engine.getSpeed() + " Km/Jam");
    }
    public void reduceMotorcycleSpeed(){
        this.engine.reduceSpeed();
        System.out.println(engine.getSpeed() + " Km/Jam");
    }
    
    
}
