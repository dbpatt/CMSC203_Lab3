import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 * Starter JUnit 5 test class for GradeBook.
 */
public class GradeBookTest {

	// Test fixtures: shared objects used in multiple tests
    private GradeBook g1;
    private GradeBook g2;

    /**
     * setUp runs BEFORE each @Test method.
     * Use it to create fresh GradeBook objects for every test.
     */
    @BeforeEach
    public void setUp() {
    	// Initialize g1 and g2 with capacity 5
    	// and add several scores to each using addScore
        g1 = new GradeBook(5);
        g1.addScore(50.0);
        g1.addScore(75.0);

        g2 = new GradeBook(5);
        g2.addScore(90.0);
        g2.addScore(85.0);
        g2.addScore(70.0);
    }

    /**
     * tearDown runs AFTER each @Test method.
     * Cleans up GradeBook objects after each test.
     */
    @AfterEach
    public void tearDown() {
        g1 = null;
        g2 = null;
    }

    /**
     * Test addScore and toString.
     * 
     * Goal:
     *  - Verify that the scores are stored correctly.
     *  - Verify that toString returns the expected string
     *    (each score followed by a space, in the order added).
     */
    @Test
    public void testAddScoreAndToString() {
        assertEquals("50.0 75.0 ", g1.toString());
        assertEquals("90.0 85.0 70.0 ", g2.toString());
    }
 // Write assertions that compare g1.toString() and g2.toString()
    // to the expected strings, for example:
    //
    // assertEquals("50.0 75.0 ", g1.toString());
    // assertEquals("90.0 85.0 70.0 ", g2.toString());

    /**
     * Test getScoreSize.
     * 
     * Goal:
     *  - Verify that getScoreSize returns the number of scores
     *    actually added to each GradeBook.
     */
    @Test
    public void testGetScoreSize() {
        assertEquals(2, g1.getScoreSize());
        assertEquals(3, g2.getScoreSize());
    }

    /**
     * Test sum.
     * 
     * Goal:
     *  - Verify that sum() returns the correct total of all scores.
     */
    @Test
    public void testSum() {
        assertEquals(125.0, g1.sum(), 0.0001);
        assertEquals(245.0, g2.sum(), 0.0001);
    }

    /**
     * Test minimum.
     * 
     * Goal:
     *  - Verify that minimum() returns the smallest score.
     *  - Optionally test behavior when there are no scores.
     */
    //Write assertions for minimum values in g1 and g2
    // Example:
    // assertEquals(50.0, g1.minimum(), 0.0001);
    // assertEquals(70.0, g2.minimum(), 0.0001);

    // Optional: create a local empty GradeBook and test minimum() == 0
    // GradeBook empty = new GradeBook(5);
    // assertEquals(0.0, empty.minimum(), 0.0001);
    @Test
    public void testMinimum() {
        assertEquals(50.0, g1.minimum(), 0.0001);
        assertEquals(70.0, g2.minimum(), 0.0001);

        // Edge case: empty GradeBook should return 0
        GradeBook empty = new GradeBook(5);
        assertEquals(0.0, empty.minimum(), 0.0001);
    }

    /**
     * Test finalScore.
     * 
     * Goal:
     *  - Verify that finalScore() drops the lowest score
     *    when there are at least two scores.
     *  - Verify behavior when there is exactly one score
     *    and when there are no scores.
     */
    @Test
    public void testFinalScore() {
        // 2+ scores: drops lowest (drops 50.0, returns 75.0)
        assertEquals(75.0, g1.finalScore(), 0.0001);
        // 2+ scores: drops lowest (drops 70.0, returns 90.0 + 85.0 = 175.0)
        assertEquals(175.0, g2.finalScore(), 0.0001);

        // Edge case: exactly one score
        GradeBook single = new GradeBook(5);
        single.addScore(100.0);
        assertEquals(100.0, single.finalScore(), 0.0001);

        // Edge case: no scores
        GradeBook empty = new GradeBook(5);
        assertEquals(0.0, empty.finalScore(), 0.0001);
    }
}