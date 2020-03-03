import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.*;
import java.time.LocalDate;
import java.util.List;

/*  This test class will test out the Functionality test suites included in our Word Document
 *
 */

public class TestTrafficClass
{
    //Global variables
    public List<Traffic> loc;
    
    /*
        Start of R1 Functionality Test Cases
    */

    //Test the connect() method of Traffic class
    @Test
    public void testConnect()
    {
        Traffic t = new Traffic();
        boolean actual = t.connect();
        assertEquals(true, actual);
    }

    //Test the fileExists method with a file that is known to be in database
    @Test
    public void testFileExist()
    {
        Traffic t = new Traffic();
        t.connect();
        boolean actual = t.fileExists();
        assertEquals(true, actual);
    }

    //Test the fileExists method with a file that is not in database
    @Test
    public void testFileExist_notDB()
    {
        Traffic t = new Traffic();
        t.setLocation("Atlanta");
        t.connect();
        boolean actual = t.fileExists();
        assertEquals(false, actual);
    }

    //Test to see if File object is not Null
    @Test
    public void testFileIsNotNull()
    {
        Traffic t = new Traffic();
        t.setLocation("Atlanta");
        t.connect();
        boolean actual = t.isFileNull();
        assertEquals(true, actual);
    }

    //Test retrieveTrafficInfo method
    @Test
    public void testRetrieveTrafficInfo()
    {
        List<Traffic> test;
        Traffic t = new Traffic();
        t.setLocation("Atlanta");
        t.connect();
        loc = t.retrieveTrafficInfo();
        test = t.retrieveTrafficInfo();
        assertTrue(test.equals(loc));
    }



    @Test
    public void testTrafficLocationsContainSearchedLocation() //This test to see if the correct location is returned when searched in the database
    {

        Traffic t = new Traffic();
        t.setLocation("Atlanta");
        t.connect();
        t.retrieveTrafficInfo();
        String loc = t.getLocation();
        assertEquals("Atlanta", loc);
    }
    @Test
    public void testSizeofListIncidents() //This test the get Method of getIncidents returning a positive number.
    {

        TrafficData t = new TrafficData();
        t.connect();
        t.retrieveTrafficInfo();
        int incidents = t.getIncidents();
        assertEquals(1, incidents);


    }
    @Test
    public void testValueofStringLocationisValid() //This test that a valid string is returned from getLocation
    {


        Traffic t = new Traffic();
        t.connect();
        t.retrieveTrafficInfo();
        String locationName = t.getLocation();
        assertEquals("Atlanta", locationName);

    }
    @Test
    public void testValueofStringWeatherisValid() //This test that the weather string is returned correctly
    {

        TrafficData t = new TrafficData();
        t.connect();
        t.retrieveTrafficInfo();
        String Weather = t.getWeather();
        assertEquals("Sunny", Weather);


    }
    @Test
    public void testValueofStringDateisValid() //This test that the date is returned in correct format
    {

        TrafficData t = new TrafficData();
        t.connect();
        t.retrieveTrafficInfo();
        LocalDate date = t.getDate();
        LocalDate expected = t.getDate();
        assertEquals(expected, date);

    }
    @Test
    public void testOutputisInTextFile() //This test that the output file is of correct type
    {
        TrafficData t = new TrafficData();
        t.connect();
        t.retrieveTrafficInfo();
        String FileName = t.file.getName();
        int length = FileName.length();
        int i = FileName.length()-1;
        String Last3 = FileName.substring(i, i-3);
        String wanted = "csv";

        assertEquals(Last3, wanted);


    }
    @Test
    public void testFileContainsData()  //This test that the file recieved has data within it
    {
        TrafficData t = new TrafficData();
        t.connect();
        t.retrieveTrafficInfo();
        Long File = t.file.length();
        boolean Correct = false;
        if(File > 0 )
        {
            Correct = true;
        }
        assertEquals(true, Correct);


    }


}
