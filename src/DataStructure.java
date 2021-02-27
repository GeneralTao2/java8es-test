import java.util.Iterator;

public class DataStructure {

    // Create an array
    private final static int SIZE = 15;
    private int[] arrayOfInts = new int[SIZE];

    public DataStructure() {
        // fill the array with ascending integer values
        for (int i = 0; i < SIZE; i++) {
            arrayOfInts[i] = i;
        }
    }

    public int[] getArrayOfInts() {
        return arrayOfInts;
    }

    public void printEven() {

        // Print out values of even indices of the array
        DataStructureIterator iterator = this.new EvenIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    interface DataStructureIterator extends java.util.Iterator<Integer> { }

    // Inner class implements the DataStructureIterator interface,
    // which extends the Iterator<Integer> interface

    public class EvenIterator implements DataStructureIterator {

        // Start stepping through the array from the beginning
        private int nextIndex = 0;

        public boolean hasNext() {

            // Check if the current element is the last in the array
            return (nextIndex <= SIZE - 1);
        }

        public Integer next() {

            // Record a value of an even index of the array
            Integer retValue = arrayOfInts[nextIndex];

            // Get the next even element
            nextIndex += 2;
            return retValue;
        }
    }
    public void print(DataStructureIterator iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public void print(java.util.function.Function<Integer, Boolean> function) {
        for (int i = 0; i < SIZE; i++) {
            if (function.apply(i)) {
                System.out.print(arrayOfInts[i] + " ");
            }
        }
        System.out.println();
    }
    public static boolean isEvenIndex(int i) {
        return i%2 == 0;
    }
    public static boolean isOddIndex(int i) {
        return i%2 == 1;
    }

    public static void main() {

        // Fill the array with integer values and print out only
        // values of even indices
        DataStructure ds = new DataStructure();
        ds.printEven();

        ds.print(new DataStructure.DataStructureIterator() {
            private int nextIndex = 1;

            public boolean hasNext() {
                return (nextIndex <= SIZE - 1);
            }

            public Integer next() {
                Integer retValue = ds.getArrayOfInts()[nextIndex];
                nextIndex += 2;
                return retValue;
            }
        });

        ds.print(i -> i%2 == 0);
        ds.print(i -> i%2 == 1);

        ds.print(DataStructure::isEvenIndex);
        ds.print(DataStructure::isOddIndex);

        //ds.print();
    }
}