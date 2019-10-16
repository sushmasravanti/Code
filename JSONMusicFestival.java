import java.io.FileReader; 
import java.util.Iterator; 
import java.util.Map; 
  
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*; 
  
public class JSONMusicFestival
{ 
    public static void main(String[] args) throws Exception  
    { 
        // parsing file "MusicFestival.json" 
        Object obj = new JSONParser().parse(new FileReader("MusicFestival.json")); 
          
        // typecasting obj to JSONObject 
        JSONObject jo = (JSONObject) obj; 
          
        // getting Name 
        String name = (String) jo.get("name"); 
        
          
        System.out.println(name); 
 
          
        // getting unsorted bands 
        Map bands = ((Map)jo.get("bands")); 
		
		// by giving the Tree map we can sorting in ascending
		
		Map<String, String> sortedMapBands = new TreeMap<String, String>(bands);
		
		// if we wanted to do this java 8 by stream api mean we can folow below things
		
		    LinkedHashMap<String, String> sortedMapBands = new LinkedHashMap<>();
        bands.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> sortedMapBands.put(x.getKey(), x.getValue()));
          
        // iterating bands Map 
        Iterator<Map.Entry> itr1 = sortedMapBands.entrySet().iterator(); 
        while (itr1.hasNext()) { 
            Map.Entry pair = itr1.next(); 
            System.out.println(pair.getKey() + " : " + pair.getValue()); 
        } 
          
        
          
        
    } 
} 
