package week10;
public class Zombie implements Destroyable{
    protected int health;
    protected int level;
    
    public void heal(){
        System.out.println("Healing for everyone");
    }
    
    public void destroyed(){
        System.out.println("Duaarrr");
    }
    
    public String getZombieInfo(){
        return "Health = " + health + " \nLevel = " + level;
    }
}

class WalkingZombie extends Zombie{
    public WalkingZombie(int health, int level) {
        this.health = health;
        this.level = level;
    }

    @Override
    public void heal() {
        switch(level){
            case 1 : health = (int) (health + 0.2*health); break;
            case 2 : health = (int) (health + 0.3*health); break;
            case 3 : health = (int) (health + 0.4*health); break;
        }
    }

    @Override
    public void destroyed() {
        health = (int) (health - 0.02 *health);
    }

    @Override
    public String getZombieInfo() {
        String info = "Walking Zombie Data = \n";
        info += super.getZombieInfo() + "\n";
        return info;
    }
}

class JumpingZombie extends Zombie{

    public JumpingZombie(int health, int level) {
        this.health = health;
        this.level = level;
    }

    @Override
    public void heal() {
        switch(level){
            case 1 : health = (int) (health + 0.3*health); break;
            case 2 : health = (int) (health + 0.4*health); break;
            case 3 : health = (int) (health + 0.5*health); break;
        }
    }
    @Override
    public void destroyed() {
        health = (int) (health - 0.01*health);
    }

    @Override
    public String getZombieInfo() {
        String info = "Jumping Zombie Data = \n";
        info += super.getZombieInfo() + "\n";
        return info;
    }
}

class Barrier implements Destroyable{
    private int strength;

    public Barrier(int strength) {
        this.strength = strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public void destroyed() {
        strength -= 9;
    }
    
    public String getBarrierInfo(){
        return "Barrier Strength = " + strength;
    }
}

class Plant{
    public void doDestroy(Destroyable d){
        if(d instanceof WalkingZombie){
            WalkingZombie wz = (WalkingZombie) d;
            wz.destroyed();
        }else if (d instanceof JumpingZombie){
            JumpingZombie jz = (JumpingZombie) d;
            jz.destroyed();
        }else if (d instanceof Barrier){
            Barrier b = (Barrier) d;
            b.destroyed();
        }
    }
}

class Tester{
    public static void main(String[] args) {
        WalkingZombie wz = new WalkingZombie(100, 1);
        JumpingZombie jz = new JumpingZombie(100, 2);
        Barrier b = new Barrier(100);
        Plant p = new Plant();
        System.out.println(""+wz.getZombieInfo());
        System.out.println(""+jz.getZombieInfo());
        System.out.println(""+b.getBarrierInfo());
        System.out.println("------------------------");
        for(int i = 0; i <4; i++){
            p.doDestroy(wz);
            p.doDestroy(jz);
            p.doDestroy(b);
        }
        System.out.println(""+wz.getZombieInfo());
        System.out.println(""+jz.getZombieInfo());
        System.out.println(""+b.getBarrierInfo());
    }
}