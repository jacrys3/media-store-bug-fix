import Problem3.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem3Test {
    @Test
    public void catchTheBugInBook() {
        BookFiction b1;
        b1 = new BookFiction("t1", "a1", "g1");
        Book b2 = new BookFiction(b1);
        assertTrue(b1.equals(b2));

    }

    @Test
    public void catchTheBugInMovie() {
        // quiz
    }

    // DO NOT REMOVE OR CHANGE ANYTHING BELOW THIS!
    @Test
    public void testMovieActionEquals() {
        MovieAction m = new MovieAction("PG13", "ti1");
        MovieAction mc = new MovieAction(m);
        assertTrue(m.equals(mc));
        mc = new MovieAction("PG13", "ti1");
        assertFalse(m.equals(mc));
    }

    @Test
    public void testMovieComedyEquals() {
        MovieComedy m = new MovieComedy("G", "ti2");
        MovieComedy mc = new MovieComedy(m);
        assertTrue(m.equals(mc));
        mc = new MovieComedy("G", "ti2");
        assertFalse(m.equals(mc));
    }

    @Test
    public void testMovieEquals() {
        Movie m = new MovieAction("PG13", "au2");
        Movie mc = new MovieComedy("r1", "t1");
        assertFalse(m.equals(mc));
    }

    @Test
    public void testBookFictionEquals() {
        BookFiction f = new BookFiction("t1", "au1", "g1");
        BookFiction fc = new BookFiction(f);
        assertTrue(f.equals(fc));
        fc = new BookFiction("t1", "au1", "g2");
        assertFalse(f.equals(fc));
    }

    @Test
    public void testBookRomanceEquals() {
        BookRomance f = new BookRomance("t1", "au1");
        BookRomance fc = new BookRomance(f);
        assertTrue(f.equals(fc));
        fc = new BookRomance("t1", "au1");
        assertFalse(f.equals(fc));
    }

    @Test
    public void testBookEquals() {
        Book f = new BookFiction("t1", "au1", "g1");
        Book br = new BookRomance("t1", "a1");
        assertFalse(f.equals(br));
    }

    @Test
    public void testBookFictionCalcLateFees() {
        Book bookFiction = new BookFiction("t1", "au1", "g1");

        for (int i = -5; i < 5; i++) {
            int fees = bookFiction.calcLateFees(i);
            assertEquals(fees, Math.max(i, 0) * bookFiction.getLateFeeInDollar());
        }
    }

    @Test
    public void testBookRomanceCalcLateFees() {
        Book bookRomance = new BookRomance("t2", "au2");

        for (int i = -5; i < 5; i++) {
            int fees = bookRomance.calcLateFees(i);
            assertEquals(fees, Math.max(i, 0) * bookRomance.getLateFeeInDollar());
        }
    }

    @Test
    public void testMovieActionCalcLateFees() {
        Movie movieAction = new MovieAction("r1", "t1");

        for (int i = -5; i < 5; i++) {
            int fees = movieAction.calcLateFees(i);
            assertEquals(fees, Math.max(i, 0) * movieAction.getLateFeeInDollar());
        }

        for (int i = 5; i <= 10; i++) {
            int fees = movieAction.calcLateFees(i);
            assertEquals(fees, 2 * i * movieAction.getLateFeeInDollar());
        }
    }

    @Test
    public void testMovieComedyCalcLateFees() {
        Movie movieComedy = new MovieComedy("r1", "t1");

        for (int i = -5; i < 10; i++) {
            int fees = movieComedy.calcLateFees(i);
            assertEquals(fees, Math.max(i, 0) * movieComedy.getLateFeeInDollar());
        }
    }

    @Test
    public void testStoreMediaCalcLateFees() {
        StoreMediaOperations[] s = new StoreMediaOperations[4];

        s[0] = new BookFiction("t1", "au1", "g1");
        s[1] = new BookRomance("t2", "au2");
        s[2] = new MovieAction("r1", "t1");
        s[3] = new MovieComedy("r2", "t2");

        int dayMissed = 10;

        int fees = 0;
        for (StoreMediaOperations storeMediaOperations : s) {
            fees += storeMediaOperations.calcLateFees(dayMissed);
        }

        int expect = 0;
        for (StoreMediaOperations storeMediaOperations : s) {
            int factor = (storeMediaOperations instanceof MovieAction) ? 2 : 1;
            expect += storeMediaOperations.getLateFeeInDollar() * dayMissed * factor;
        }
        assertEquals(expect, fees);
    }

}