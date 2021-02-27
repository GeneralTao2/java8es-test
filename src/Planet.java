import java.lang.annotation.Documented;
import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Planet {
    MERCURY (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);

    private final double mass;   // in kilograms
    private final double radius; // in meters
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
    private double mass() { return mass; }
    private double radius() { return radius; }

    // universal gravitational constant  (m3 kg-1 s-2)
    public static final double G = 6.67300E-11;

    double surfaceGravity() {
        return G * mass / (radius * radius);
    }
    /**
     * @deprecated
     * explanation of why it was deprecated
     */
    @SuppressWarnings({"unchecked", "deprecation"})
    @ClassPreamble (
            author = "John Doe",
            date = "3/17/2002",
            currentRevision = 6,
            lastModified = "4/12/2004",
            lastModifiedBy = "Jane Doe",
            // Note array notation
            reviewers = {"Alice", "Bob", "Cindy"}
    )
    double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }

    @SafeVarargs // Not actually safe!
    static void m(List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> tmpList = Collections.singletonList(42);
        array[0] = tmpList; // Semantically invalid, but compiles without warnings
        String s = stringLists[0].get(0); // Oh no, ClassCastException at runtime!
    }

    @Author(
            name = "Benjamin Franklin",
            date = "3/27/2003"
    )
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Planet <earth_weight>");
            System.exit(-1);
        }
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight/EARTH.surfaceGravity();
        for (Planet p : Planet.values())
            System.out.printf("Your weight on %s is %f%n",
                    p, p.surfaceWeight(mass));
        m(new ArrayList<String>(){{add("1"); add("2");}});
    }
}