package kuis1;

public class Main {
    public static void main(String[] args) {
      Motorcycle honda = new Motorcycle("Vario", "Honda");
        System.out.println(honda.getMotorcycleBrand());
        System.out.println(honda.getEngineBrand());
        honda.increaseMotorcycleSpeed();
        honda.increaseMotorcycleSpeed();
        honda.increaseMotorcycleSpeed();
        honda.increaseMotorcycleSpeed();
        honda.increaseMotorcycleSpeed();
        honda.increaseMotorcycleSpeed();
        honda.increaseMotorcycleSpeed();
        honda.increaseMotorcycleSpeed();
        honda.increaseMotorcycleSpeed();
        honda.increaseMotorcycleSpeed();
        honda.increaseMotorcycleSpeed();
        honda.reduceMotorcycleSpeed();
        honda.increaseMotorcycleSpeed();
        
        System.out.println("");
        
        Motorcycle yamaha = new Motorcycle("nMax", "Yamaha");
        System.out.println(yamaha.getMotorcycleBrand());
        System.out.println(yamaha.getEngineBrand());
        yamaha.increaseMotorcycleSpeed();
        yamaha.increaseMotorcycleSpeed();
        yamaha.increaseMotorcycleSpeed();
        yamaha.increaseMotorcycleSpeed();
        yamaha.increaseMotorcycleSpeed();
        yamaha.increaseMotorcycleSpeed();
        yamaha.increaseMotorcycleSpeed();
        yamaha.increaseMotorcycleSpeed();
        yamaha.increaseMotorcycleSpeed();
        yamaha.reduceMotorcycleSpeed();
        yamaha.increaseMotorcycleSpeed();   
    }
}
