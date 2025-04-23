import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class PracticeProblemTest {

    private Class<?> campbellClass;
    
    @BeforeEach
    public void setUp() {
        try {
            campbellClass = Class.forName("CampbellClass");
        } catch (Exception e) {
            // Class not found
            // Tests will be skipped but not crash
        }
    }
    
    @Test
    public void testClassIsUtility() {
        if (campbellClass == null) {
            fail("CampbellClass not found");
            return;
        }
        
        // Check if all constructors are private
        boolean hasPrivateConstructor = false;
        try {
            hasPrivateConstructor = campbellClass.getDeclaredConstructors().length > 0 && 
                                   Modifier.isPrivate(campbellClass.getDeclaredConstructors()[0].getModifiers());
        } catch (Exception e) {
            fail("Error checking constructor accessibility: " + e.getMessage());
        }
        
        assertTrue(hasPrivateConstructor, "A utility class should have a private constructor");
    }
    
    @Test
    public void testConvertStringWithInt() {
        if (campbellClass == null) {
            fail("CampbellClass not found");
            return;
        }
        
        try {
            Method method = campbellClass.getMethod("convertString", int.class);
            assertTrue(Modifier.isStatic(method.getModifiers()), "convertString(int) should be static");
            
            // Check return type is String
            assertEquals(String.class, method.getReturnType(), "convertString(int) should return String");
            
            String result = (String) method.invoke(null, 42);
            assertEquals("42", result);
        } catch (Exception e) {
            fail("convertString(int) method failed: " + e.getMessage());
        }
    }
    
    @Test
    public void testConvertStringWithDouble() {
        if (campbellClass == null) {
            fail("CampbellClass not found");
            return;
        }
        
        try {
            Method method = campbellClass.getMethod("convertString", double.class);
            assertTrue(Modifier.isStatic(method.getModifiers()), "convertString(double) should be static");
            
            // Check return type is String
            assertEquals(String.class, method.getReturnType(), "convertString(double) should return String");
            
            String result = (String) method.invoke(null, 3.14);
            assertEquals("3.14", result);
        } catch (Exception e) {
            fail("convertString(double) method failed: " + e.getMessage());
        }
    }
    
    @Test
    public void testConvertStringWithChar() {
        if (campbellClass == null) {
            fail("CampbellClass not found");
            return;
        }
        
        try {
            Method method = campbellClass.getMethod("convertString", char.class);
            assertTrue(Modifier.isStatic(method.getModifiers()), "convertString(char) should be static");
            
            // Check return type is String
            assertEquals(String.class, method.getReturnType(), "convertString(char) should return String");
            
            String result = (String) method.invoke(null, 'A');
            assertEquals("A", result);
        } catch (Exception e) {
            fail("convertString(char) method failed: " + e.getMessage());
        }
    }
    
    @Test
    public void testConvertStringWithBoolean() {
        if (campbellClass == null) {
            fail("CampbellClass not found");
            return;
        }
        
        try {
            Method method = campbellClass.getMethod("convertString", boolean.class);
            assertTrue(Modifier.isStatic(method.getModifiers()), "convertString(boolean) should be static");
            
            // Check return type is String
            assertEquals(String.class, method.getReturnType(), "convertString(boolean) should return String");
            
            String result = (String) method.invoke(null, true);
            assertEquals("true", result);
            
            result = (String) method.invoke(null, false);
            assertEquals("false", result);
        } catch (Exception e) {
            fail("convertString(boolean) method failed: " + e.getMessage());
        }
    }
    
    @Test
    public void testConvertMetersToCentiWithInt() {
        if (campbellClass == null) {
            fail("CampbellClass not found");
            return;
        }
        
        try {
            Method method = campbellClass.getMethod("convertMetersToCenti", int.class);
            assertTrue(Modifier.isStatic(method.getModifiers()), "convertMetersToCenti(int) should be static");
            
            // Check return type is int (should return same type as input)
            assertEquals(int.class, method.getReturnType(), 
                    "convertMetersToCenti(int) should return int to match input type");
            
            Object result = method.invoke(null, 5);
            assertTrue(result instanceof Integer, "Result should be an Integer");
            assertEquals(500, ((Integer)result).intValue());
            
            result = method.invoke(null, 0);
            assertTrue(result instanceof Integer, "Result should be an Integer");
            assertEquals(0, ((Integer)result).intValue());
        } catch (Exception e) {
            fail("convertMetersToCenti(int) method failed: " + e.getMessage());
        }
    }
    
    @Test
    public void testConvertMetersToCentiWithDouble() {
        if (campbellClass == null) {
            fail("CampbellClass not found");
            return;
        }
        
        try {
            Method method = campbellClass.getMethod("convertMetersToCenti", double.class);
            assertTrue(Modifier.isStatic(method.getModifiers()), "convertMetersToCenti(double) should be static");
            
            // Check return type is double (should return same type as input)
            assertEquals(double.class, method.getReturnType(), 
                    "convertMetersToCenti(double) should return double to match input type");
            
            Object result = method.invoke(null, 2.5);
            assertTrue(result instanceof Double, "Result should be a Double");
            assertEquals(250.0, ((Double)result).doubleValue(), 0.001);
            
            result = method.invoke(null, 0.01);
            assertTrue(result instanceof Double, "Result should be a Double");
            assertEquals(1.0, ((Double)result).doubleValue(), 0.001);
        } catch (Exception e) {
            fail("convertMetersToCenti(double) method failed: " + e.getMessage());
        }
    }
    
    @Test
    public void testRemoveNonAlphaBasic() {
        if (campbellClass == null) {
            fail("CampbellClass not found");
            return;
        }
        
        try {
            Method method = campbellClass.getMethod("removeNonAlpha", String.class);
            assertTrue(Modifier.isStatic(method.getModifiers()), "removeNonAlpha(String) should be static");
            
            // Check return type is String
            assertEquals(String.class, method.getReturnType(), "removeNonAlpha(String) should return String");
            
            Object result = method.invoke(null, "Hello123World!");
            assertTrue(result instanceof String, "Result should be a String");
            assertEquals("HelloWorld", result);
            
            result = method.invoke(null, "a1b2c3");
            assertTrue(result instanceof String, "Result should be a String");
            assertEquals("abc", result);
            
            result = method.invoke(null, "!@#$%");
            assertTrue(result instanceof String, "Result should be a String");
            assertEquals("", result);
        } catch (Exception e) {
            fail("removeNonAlpha(String) method failed: " + e.getMessage());
        }
    }
    
    @Test
    public void testRemoveNonAlphaWithCase() {
        if (campbellClass == null) {
            fail("CampbellClass not found");
            return;
        }
        
        try {
            Method method = campbellClass.getMethod("removeNonAlpha", String.class, boolean.class);
            assertTrue(Modifier.isStatic(method.getModifiers()), "removeNonAlpha(String, boolean) should be static");
            
            // Check return type is String
            assertEquals(String.class, method.getReturnType(), "removeNonAlpha(String, boolean) should return String");
            
            // Test uppercase conversion
            Object result = method.invoke(null, "Hello123World!", true);
            assertTrue(result instanceof String, "Result should be a String");
            assertEquals("HELLOWORLD", result);
            
            // Test lowercase conversion
            result = method.invoke(null, "Hello123World!", false);
            assertTrue(result instanceof String, "Result should be a String");
            assertEquals("helloworld", result);
            
            // Test with empty result
            result = method.invoke(null, "123!@#", true);
            assertTrue(result instanceof String, "Result should be a String");
            assertEquals("", result);
        } catch (Exception e) {
            fail("removeNonAlpha(String, boolean) method failed: " + e.getMessage());
        }
    }
    
    @Test
    public void testRemoveNonAlphaWithEmptyString() {
        if (campbellClass == null) {
            fail("CampbellClass not found");
            return;
        }
        
        try {
            Method method = campbellClass.getMethod("removeNonAlpha", String.class);
            Object result = method.invoke(null, "");
            assertTrue(result instanceof String, "Result should be a String");
            assertEquals("", result);
            
            Method methodWithCase = campbellClass.getMethod("removeNonAlpha", String.class, boolean.class);
            result = methodWithCase.invoke(null, "", true);
            assertTrue(result instanceof String, "Result should be a String");
            assertEquals("", result);
        } catch (Exception e) {
            fail("removeNonAlpha with empty string failed: " + e.getMessage());
        }
    }
    
    @Test
    public void testConvertStringWithEdgeCases() {
        if (campbellClass == null) {
            fail("CampbellClass not found");
            return;
        }
        
        try {
            Method intMethod = campbellClass.getMethod("convertString", int.class);
            Object result = intMethod.invoke(null, Integer.MAX_VALUE);
            assertTrue(result instanceof String, "Result should be a String");
            assertEquals(String.valueOf(Integer.MAX_VALUE), result);
            
            Method doubleMethod = campbellClass.getMethod("convertString", double.class);
            result = doubleMethod.invoke(null, 0.0);
            assertTrue(result instanceof String, "Result should be a String");
            assertEquals("0.0", result);
            
            Method charMethod = campbellClass.getMethod("convertString", char.class);
            result = charMethod.invoke(null, ' ');
            assertTrue(result instanceof String, "Result should be a String");
            assertEquals(" ", result);
        } catch (Exception e) {
            fail("convertString edge cases failed: " + e.getMessage());
        }
    }
}
