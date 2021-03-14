import java.lang.CharSequence;
public class BackWord implements CharSequence {
    String array;

    public BackWord(String s) {
        this.array = s;
    }

    public int length() {
        return array.length();
    }

    public char charAt(int i) {
        if(i<0 || i>= array.length()) {
            throw new StringIndexOutOfBoundsException(i);
        }
        return array.charAt(array.length() - i - 1);
    }

    public CharSequence subSequence(int i, int i1) {
        if(i<0) {
            throw new StringIndexOutOfBoundsException(i);
        }
        if(i1>=array.length()) {
            throw new StringIndexOutOfBoundsException(i1);
        }
        if(i>i1) {
            throw new StringIndexOutOfBoundsException(i-i1);
        }
        StringBuilder part = new StringBuilder(array.subSequence(i, i1));
        return part.reverse();
    }

    public String toString() {
        StringBuilder tmp = new StringBuilder(this.array);
        return tmp.reverse().toString();
    }

    public static void main() {
        BackWord backWord = new BackWord("Suppose that you have written a time server, which periodically notifies its clients of the current date and time. Write an interface that the server could use to enforce a particular protocol on its clients.");

        System.out.println(backWord.toString());
        System.out.println(backWord.subSequence(10, 20));
        System.out.println(backWord.charAt(40));
    }
}

class Horse {
    public String identifyMyself() {
        return "I am a horse.";
    }
}

interface Flyer {
    default public String identifyMyself() {
        return "I am able to fly.";
    }
}

interface Mythical {
    default public String identifyMyself() {
        return "I am a mythical creature.";
    }
}

class Pegasus extends Horse implements Flyer, Mythical {
    public static void main(String... args) {
        Pegasus myApp = new Pegasus();
        System.out.println(myApp.identifyMyself());
    }
}
