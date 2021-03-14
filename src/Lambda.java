import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
interface Card extends Comparable<Card> {
    public enum s {
        a (1);
        private final int b;
        s(int i) {
            this.b = i;
        }
    }
}

interface interf {
    void first();
    void second();
    default void thrid() {
        List<String> str = new ArrayList<String>();
        String[] p = str.toArray(new String[0]); //ctrl+shift+space
    }
}

public class Lambda {
    public static <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function<X, Y> mapper,
            Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
    DEST transferElements(
            SOURCE sourceCollection,
            Supplier<DEST> collectionFactory) {

        DEST result = collectionFactory.get();
        result.addAll(sourceCollection);
        return result;
    }

    public static <T extends Number> Integer IamRestrictedGenericMethod(T t) {
        return t.intValue() + 10;
    }

    public static <X> void printMe(X something) {
        System.out.println(something);
    }

    static <T> T pick(T a1, T a2) { return a2; }
    Serializable s = pick("d", new ArrayList<String>());

    public static double sumOfList(List<? extends Number> list) {   // less restricted generic method
        double s = 0.0;                                             // upper bounded wildcard
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    public static String sumOfListStrings(List<?> list) {   // much less restricted generic method
        StringBuilder s = new StringBuilder();        // upper bounded wildcard
        for (Object n : list)
            s.append(n);;
        return s.toString();
    }

    public static void addNumbers(List<? super Integer> list) { // less restricted, but accepts Integer
        for (int i = 1; i <= 10; i++) {                         //superclasses. Lower bounded wildcard
            list.add(i);
        }
    }

    public static void main() {
        LocalDate a = LocalDate.of(1999, 5, 29);
        int year = LocalDate.now().getYear() - a.getYear();
        List<Human> roster = new ArrayList<Human>();
        roster.add(new Human("111", LocalDate.of(2005, 5, 29), Human.Sex.MALE, "mail1"));
        roster.add(new Human("111", LocalDate.of(2005, 5, 29), Human.Sex.MALE, "mail1"));
        roster.add(new Human("112", LocalDate.of(1999, 5, 29), Human.Sex.FEMALE, "mail2"));
        roster.add(new Human("113", LocalDate.of(1998, 5, 29), Human.Sex.MALE, "mail3"));
        roster.add(new Human("114", LocalDate.of(1997, 5, 29), Human.Sex.FEMALE, "mail4"));
        roster.add(new Human("115", LocalDate.of(1999, 5, 29), Human.Sex.MALE, "mail5"));
        processElements(
                roster,
                p -> p.getGender() == Human.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                Human::getEmailAddress,
                System.out::println
        );
        Set<Human> rosterSetLambda =
                transferElements(roster, HashSet::new);
        printMe(rosterSetLambda);
        List<Human> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        Integer int1 = 1;

        roster.sort(Comparator
                .comparing(Human::getAge)
                .thenComparing(Human::getEmailAddress));

        class Book {}
        List<Book> booksDia = new ArrayList<>(); // diamond
        List<? super Book> books = new ArrayList<>(); // permanently empty
        books.add(new Book()); // illegal

        Integer a_ = IamRestrictedGenericMethod(10);

        List<Integer> li = Arrays.asList(1, 2, 3);
        System.out.println("sum = " + sumOfList(li));
        System.out.println("sum = " + sumOfListStrings(li));
        List<Number> superclass = new ArrayList<>();
        addNumbers(superclass);
        List<? extends Integer> intList = new ArrayList<>();
        List<? extends Number>  numList = intList;  // OK. List<? extends Integer> is a subtype of List<? extends Number>

    }
}

class Human {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public Human(){

    }

    public Human(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setBirthday(int y, int m, int d) {
        birthday = LocalDate.of(y, m, d);
    }
    public int getAge() {
        return LocalDate.now().getYear() - birthday.getYear();
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public Sex getGender() {
        return gender;
    }

}