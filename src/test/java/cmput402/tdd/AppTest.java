package cmput402.tdd;

import cmput402.tdd.service.Search;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    Utility util = new Utility();
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testCountAverageScore() {
        Search mockSearch = mock(Search.class);
        HashMap<String, ArrayList<Integer>> fakeMap = new HashMap<String, ArrayList<Integer>>();
        ArrayList<Integer> messi = new ArrayList<Integer>();
        messi.add(100);
        messi.add(200);
        ArrayList<Integer> ronaldo = new ArrayList<Integer>();
        ronaldo.add(80);
        ronaldo.add(150);
        ArrayList<Integer> neymar = new ArrayList<Integer>();
        neymar.add(50);
        neymar.add(80);
        fakeMap.put("messi", messi);
        fakeMap.put("ronaldo", ronaldo);
        fakeMap.put("neymar", neymar);

        when(mockSearch.returnAll()).thenReturn(fakeMap);

        HashMap<String, Float> results = util.countAverageScore(mockSearch);

        assert(2f == results.get("messi"));
        assert(1.875f == results.get("ronaldo"));
        assert(1.6f == results.get("neymar"));
    }

    public void testFindTopScorer() {
        Search mockSearch = mock(Search.class);
        HashMap<String, ArrayList<Integer>> fakeMap = new HashMap<String, ArrayList<Integer>>();
        ArrayList<Integer> messi = new ArrayList<Integer>();
        messi.add(100);
        messi.add(200);
        ArrayList<Integer> ronaldo = new ArrayList<Integer>();
        ronaldo.add(80);
        ronaldo.add(150);
        ArrayList<Integer> neymar = new ArrayList<Integer>();
        neymar.add(50);
        neymar.add(80);
        fakeMap.put("messi", messi);
        fakeMap.put("ronaldo", ronaldo);
        fakeMap.put("neymar", neymar);

        when(mockSearch.returnAll()).thenReturn(fakeMap);

        HashMap<String, Integer> results = util.findTopScorer(mockSearch);

        assert(results.keySet().iterator().next().equals("messi"));
        assert(results.get("messi") == 200);
    }
}
