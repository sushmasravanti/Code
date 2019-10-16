
public class JSONStringTest {	
	public void writeValues() throws Exception {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put((Object)null);

        StringWriter writer = new StringWriter();
        try {
            String output = jsonArray.write(writer).toString();
            assertTrue("String values should be equal", "[null]".equals(output));
    
            jsonArray = new JSONArray();
            jsonArray.put(JSONObject.NULL);
        } finally {
            writer.close();
        }
		
	 
	 
		writer = new StringWriter();
        try {
            String output = jsonArray.write(writer).toString();
            assertTrue("String values should be equal", "[{\"key1\":\"value1\"}]".equals(output));
    
            jsonArray = new JSONArray();
            List<?> singleList = Collections.singletonList("entry1");
            jsonArray.put((Object)singleList);
        } finally {
            writer.close();
        }
		
		}
		
		
		@Test
    public void valuesToString() throws Exception {

        String output = JSONObject.valueToString(null);
        assertTrue("String values should be equal", "null".equals(output));
		
		    Map<?,?> singleMap = Collections.singletonMap("key1", "value1");
        output = JSONObject.valueToString(singleMap);
        assertTrue("String values should be equal", "{\"key1\":\"value1\"}".equals(output));
		
	}
}
	 