package ch2;
import java.util.Scanner;

class Planet{
    public Planet(double distance, String name) {
    }
}

public class ArrayExplore {

    public static void objectAccess() {
//        String fieldOfInterest = "mass";
//        Planet p = new Planet(6e24, "earth");
//        double mass = p[fieldOfInterest];
    }

    public static void objectAccessMember() {
//        String fieldOfInterest = "mass";
//        Planet p = new Planet(6e24, "earth");
//        double mass = p.fieldOfInterest;
    }

    public static void arrayAccess() {
        int indexOfInterest = askUserForInteger();
        int[] x = {100, 101, 102, 103};
        int k = x[indexOfInterest];
        System.out.println(k);
    }
    public static int askUserForInteger() {
        System.out.println("What index do you want?");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        scanner.close();
        return index;
    }
    public static void main(String[] args) {
        arrayAccess();
    }
}
