import org.testng.annotations.*;

import static org.testng.Assert.*;

public class FirstClassTest extends ParentClass {

    FirstClass firstClass = new FirstClass();

    @Test(priority = 2)
    public void testMessage() {
        String expectedResult = "Samsung S6";
        assertEquals(firstClass.message("Samsung ", "S6"), expectedResult);
    }

    @Test(priority = 1)
    public void test2Message() {
        String expectedResult = "Samsung S6";
        assertEquals(firstClass.message("iPhone ", "6"), expectedResult, "This is different phone");

    }

    @Test
    public void test3Message() {
        String expectedResult = "Samsung S6";
        assertEquals(firstClass.message("Samsung", "S6"), expectedResult, "Space is missing");
    }

    @Parameters({"parameter_one", "parameter_two"})
    @Test
    public void testExactInteger(int expectedResult, String type) {
        assertEquals(firstClass.exactInteger(0), expectedResult);
        System.out.println(expectedResult + " is required " + type);
    }

    @Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void test2ExactInteger() {
        assertEquals(firstClass.exactInteger(10), 3, "Array out of bounds");
    }

    @Test(timeOut = 2000)
    public void testNameAndAge() {
        assertEquals(firstClass.nameAndAge("Marcus"), 12);
    }

    @Ignore
    @Test(timeOut = 2000)
    public void test2NameAndAge() {
        assertEquals(firstClass.nameAndAge("Marcus"), 13);
    }

    @Test
    public void testTrueOrFalse() {
        assertTrue(firstClass.trueOrFalse("Car"));
    }

    @Test
    public void test2TrueOrFalse() {
        assertFalse(firstClass.trueOrFalse("Boat"));
    }

    @Test
    public void testTypeChanger() {
        assertEquals(firstClass.typeChanger(2, 1.1), 2.2);
    }

    @Test(dataProvider = "data")
    public void test2TypeChanger(int a, double b, double c) {
        assertEquals(firstClass.typeChanger(a, b), c);
    }

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {3, 0.0, 0.0},
                {5, 2.5, 12.5},
                {9, 6.44, 57.96}
        };
    }
}