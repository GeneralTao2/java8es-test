import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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

    public static <X> void printMe(X something) {
        System.out.println(something);
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
        List<Human> list1 = new ArrayList<Human>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        Integer int1 = 1;

        class Book {}
        List<? super Book> books = new ArrayList<>(); // permanently empty
        books.add(new Book()); // illegal
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