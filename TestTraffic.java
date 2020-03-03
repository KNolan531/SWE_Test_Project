import static org.junit.Assert.*;

// testing to see if this comment is added
/*  This test class will test out the verification test suites included in our Word Document
 *
 */

import org.junit.Test;

import java.util.List;

public class TestTraffic {


    //Global variables
    List traffic;


    //Test to see if File is CSV file or not. Tested through running the same test as a
    //testRetrieveTrafficInfo. If this test passes we know it is a csv. If it fails, it is
    //not a csv file
    @Test
    public void testFileType()
    {
        TrafficData t = new TrafficData();
        t.connect();
        t.retrieveTrafficInfo();
        String name = t.file.getName();
        int len = name.length();
        int i = name.length()-1;
        String last3 = name.substring(i, i - 3);
        String wanted = "csv";

        assertEquals(last3, wanted);

    }

    //Test to see if file isEmpty
    @Test
    public void testFileEmpty()
    {
        Traffic t = new Traffic();
        t.setLocation("Atlanta");
        boolean actual = t.isFileEmpty();
        assertEquals(false, actual);
    }

    //Test to see if trafficLocations list contains all Traffic information for a specific location
    @Test
    public void testTrafficList()
    {
        TrafficData td = new TrafficData("Atlanta", traffic);
        td.connect();
        td.setTime();
        td.setDate();
        td.setWeather();
        td.setObstructions();
        assertTrue(traffic.equals(td.locationTraffic));
    }
}
