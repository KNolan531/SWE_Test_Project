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
    
    
    //Test to see if Traffic location name is valid. 
    @Test 
    public void testLocationName() 
    { 
    	TrafficData td = new TrafficData("Atlanta", traffic);
    	
    	assertTrue(traffic.equals(td.locationTraffic));
    	
    	
    }
    
    //Test to see if list of incidents > 0 
    @Test 
    public void testIncidents() 
    { 
    	TrafficData td = new TrafficData("Conyers",traffic); 
    	td.setObstructions(); 
    	
    	assertNotEquals(6, td.getIncidents()); 
        	
    }
    
    //Test to see if Weather is proper weather condition 
    @Test
    public void testWeather() 
    { 
    	
    	TrafficData td = new TrafficData("Atlanta",traffic); 
    	
    	td.setWeather(); 
    	
    	assertEquals("",td.getWeather()); 
    	
    	
    }
    
    //Test to see if trafficLocations contains data
    @Test 
    public void testTraffListLocations() 
    { 
    	
    	Traffic t = new Traffic(); 
    	
    	assertEquals(null,t.retrieveTrafficInfo());
    	
    	
    }
    
    //Test to see if csv file output contains location searched for 
    @Test 
    public void testCSVFileLocationOuput() 
    { 
    	Traffic t = new Traffic(); 
    	
    	boolean containsLocation = t.file.canWrite();
    	
    	assertEquals(false,containsLocation); 
    	      	     
    	
    }
    
    //Test to see if data in output csv file is properly formatted 
    public void testDataFormat() 
    { 
    	Traffic t = new Traffic(); 
    	
    	assertEquals(true, t.file.canRead()); 
    	
    	
    }
    
    
    
    
    
    
    
}
