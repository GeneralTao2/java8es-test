import java.util.ArrayList;
import java.util.Arrays;

interface Person {
    void who();
}

class Man implements Person {
    public static void heyIamStatic() {

    }
    public void who() {
        System.out.println("I am a man");
    }
    final void youCantChangeMe() {

    }
    static abstract class YeAbstaractClass {
        abstract void implementMe(int a, int b);
        public static void callMe() {

        }
    }
    final static class YouCannotSubclassMe extends YeAbstaractClass {
        int yeah = 0;

        void implementMe(int a, int b) {

        }
    }
    public Man() {
        youCantChangeMe();
        YouCannotSubclassMe right = new YouCannotSubclassMe();
        YeAbstaractClass.callMe();
    }
}

class Me extends Man {
    final static int age = 10;
    final static int _age = 10;
    final static int a$ge = 10;
    long creditCardNumber = 1234_5678_9012_3456L;
    short sh = 1;
    char b;


    public static void heyIamStatic() {

    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }


    private String a;

    public void whoo(String a, String b, String c) {
        this.a = a;
        System.out.println("I am Artiom, and I am "+Integer.toString(age)+" years old");
        System.out.println(Integer.class);

    }
    public void array(final int length){
        char k='1';
        System.out.println(b);
        System.out.println(k);
        double[] arr = new double[length];
        final char[][] symbols = {
                {'*', '+'},
                {'$', '&'}
        };
        for(int i=0; i<length; i++) {
            arr[i] = Math.exp(i);
            System.out.printf("%f %c ", arr[i], symbols[i%2][(i>length/2) ? ((i/2)%2) : i%2]);
        }
        System.out.println();
        char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'a', 't', 'e', 'd' };
        char[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 2, 9);
        for(int i=0; i<copyTo.length; i++) {
            copyTo[i] = (char) (copyTo[i] + 10);
        }
        java.util.Arrays.sort(copyFrom);
        Arrays.parallelSort(copyTo);
        System.out.println(new String(copyTo));
        System.out.println(java.util.Arrays.binarySearch(copyFrom, 'e'));
        java.util.Arrays.fill(copyFrom, 'e');
        System.out.println(java.util.Arrays.equals(copyFrom, copyTo));
        boolean[] boolArr = new boolean[10];
        System.out.println(java.util.Arrays.equals(copyFrom, copyTo));
        int i = 10;
        System.out.println(i++);
        System.out.println(++i);
        System.out.println(i);
        int n = (++i)%5;
        System.out.println(n);
    }
}

class Woman implements Person {
    public void who() {
        System.out.println("I am a woman");
    }
}

interface Vihecle {
    int getSpeed();
    void setSpeed(int speed);
}

class Bicecle {
    private int speed;
    public Bicecle(int speed) {
        this.setSpeed(speed);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

class MountainBike extends Bicecle {
    private int heigh;
    public static int a;
    public static int b;
    public static class Wheel {
        int radius;
        public Wheel(int radius) {
            this.radius = radius;
            MountainBike.a = 1;
        }
    }
    static {
        a=11;
        b=10;
        System.out.println("Wow, I am from static block");
    }

    public static int c = initializeInstanceVariable();

    protected static final int initializeInstanceVariable() {
        System.out.println("Wow, I am from... Where I am?");
        return 12;
    }

    public MountainBike(int heigh, int speed) {
        super(speed);
        this.heigh = heigh;
    }

    public int getHeigh() {
        return heigh;
    }

    public void setHeigh(int heigh) {
        this.heigh = heigh;
    }
    public void printThese(String... strings) {
        for (String string : strings) {
            System.out.printf("I have: %s\n", string);
        }
    }
    public void printFields() {
        System.out.printf("Height: %s\n", getHeigh());
        System.out.printf("Speed: %s\n", super.getSpeed());
    }
}

class WhatIsIt extends MountainBike implements Vihecle {
    public WhatIsIt(int height, int speed) {
        super(height, speed);
    }
    public int getHeigh() {
        return super.getHeigh();
    }

    public void setHeigh(int heigh) {
        super.setHeigh(heigh);
    }
    public void setHeigh(String heigh) {
    }
    public void setHeigh(float heigh) {
    }
}

class WowHow extends WhatIsIt {

    public WowHow(int height, int speed) {
        super(height, speed);
    }
}

class main {
    public static MountainBike setMountainBike(MountainBike bike, int heigh, int speed) {
        bike.setHeigh(heigh);
        bike.setSpeed(speed);
        bike = new MountainBike(3, 4);
        return bike;
    }
    public static void main(String[] args) {
        Man man = new Man();
        Woman women = new Woman();
        Me artiom = new Me();
        artiom.whoo("1","2","3");
        artiom.array(10);
        man.who();
        women.who();
        MountainBike bicecle = new MountainBike(8,10);
        MountainBike bicecle2 = new MountainBike(8,10);
        bicecle.printThese("one", "two", "three");
        MountainBike newBicecle = setMountainBike(bicecle, 1, 2);
        bicecle.printFields();
        System.out.println(MountainBike.a + MountainBike.b + MountainBike.c);
        MountainBike.Wheel wheel = new MountainBike.Wheel(1);
        LocalClassExample.main();
        HelloWorldAnonymousClasses.main();
        Lambda.main();
        LambdaScopeTest.main();
        DataStructure.main();
        //Planet.main(new String[]{"1"});
        try {
            ArrayListExample.main(new String[]{"1"});
        } catch (Exception e) {
            e.printStackTrace();
        }
        BackWord.main();
        System.out.println(Integer.valueOf(1));
        System.out.format("%saaa","A"); //printf
        DecimalFormatDemo.main();
    }
}