import java.text.DecimalFormat;
import java.util.Scanner;
class VolumeOfCylinder{
    public static void main(String[] args) {
        
        int radius, height;
        float volume, cylinder, halfSphere;
        float PHI = 3.14f;

        Scanner sc = new Scanner(System.in);

        System.out.print("Input Radius:\t");
        radius = sc.nextInt();

        System.out.print("Input Height :\t");
        height = sc.nextInt();

        cylinder = PHI*radius*radius*height;

        halfSphere = 4*(PHI*radius*radius*radius)/6;

        volume = cylinder + halfSphere;

        System.out.println("Cylinder Volume:\t" + cylinder + "\nhalfSphere Volume:\t" + halfSphere + "\nVolume total:\t\t" + volume);


        
    }
}