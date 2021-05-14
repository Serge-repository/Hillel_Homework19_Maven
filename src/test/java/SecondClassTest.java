import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.PropertiesReaderClassLoader;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class SecondClassTest extends ParentClass {

    SecondClass secondClass = new SecondClass();

    @Test
    public void testNullObject() {
        assertNull(secondClass.nullObject(null));
    }

    @Test
    public void test2NullObject() {
        assertNull(secondClass.nullObject("This is my String"), "String object is not null");
    }

    @Parameters({"parameter_three"})
    @Test
    public void testDivision(int expectedResult) {
        assertEquals(secondClass.division(6,3), expectedResult);
    }

    @Test(description = "This test designed to pass")
    public void testTestWhile() {
        assertTrue(secondClass.testWhile("ABC"));
    }

    @Test(description = "This test designed to fail")
    public void test2TestWhile() {
        assertTrue(secondClass.testWhile("AB"));
    }

    @Test(dataProvider = "dataProvider")
    public void testTestSwitch(String monthName, String result) {
        assertEquals(secondClass.testSwitch(monthName), result);
    }

    @DataProvider
    public static Object[][] dataProvider() {
        return new Object[][]{
                {"January", "It`s winter"},
                {"May", "It`s not winter month"},
                {"February", "It`s winter"}
        };
    }

    @Test
    public void test1NameOfCity() {
        ArrayList<String> myList = secondClass.nameOfCity();
        assertEquals(secondClass.nameOfCity(),myList);
    }

    @Test(dependsOnMethods = {"test1NameOfCity"})
    public void test2NameOfCity() {
        ArrayList<String> myList = (ArrayList<String>) secondClass.nameOfCity().stream()
                .filter(s -> s.startsWith("K"))
                .collect(Collectors.toList());
        assertEquals(secondClass.nameOfCity(),myList, "This lists are not equal due to different size");
    }

    @Test(dependsOnMethods = {"test2NameOfCity"})
    public void test3NameOfCity() {
        ArrayList<String> myList = secondClass.nameOfCity();
        myList.set(1, "Kaniv");
        assertEquals(secondClass.nameOfCity(),myList, "This lists are not equal due to different element names");
    }

    @Test(dependsOnMethods = {"test3NameOfCity"})
    public void test4NameOfCity() {
        ArrayList<String> myList = secondClass.nameOfCity();
        myList.set(0, "Kiev");
        myList.set(1, "Paris");
        assertEquals(secondClass.nameOfCity(),myList, "This lists are not equal due to different element positioning");
    }

    @Test
    public void testCountriesCities() {
        Object[] myObjArray =  new Object[3];
        myObjArray[0] = "technology";
        myObjArray[1] = false;
        myObjArray[2] = 1;
        assertEqualsNoOrder(secondClass.objectArray(), myObjArray);
    }

    @Test
    public void test2CountriesCities() {
        Object[] myObjArray = new Object[3];
        myObjArray[0] = "technology";
        myObjArray[1] = true;
        myObjArray[2] = 0;
        assertEqualsNoOrder(secondClass.objectArray(), myObjArray, "Object arrays are not equal");
    }

    @Test
    public void test2() {
        String baseUrl = PropertiesReaderClassLoader.getInstance().getValueFromProperty( "baseUrl");
        String defaultTimeoutValue = PropertiesReaderClassLoader.getInstance().getValueFromProperty( "defaultTimeout");
        System.out.println("baseUrl = " + baseUrl);
        System.out.println("defaultTimeoutValue = " + defaultTimeoutValue);
    }
}