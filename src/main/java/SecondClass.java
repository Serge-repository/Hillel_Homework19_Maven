import java.util.ArrayList;

public class SecondClass {
    public String nullObject(String toTest) {
        return toTest;
    }

    public int division(int a, int b) {
        return a / b;
    }

    public boolean testWhile(String testString) {
        while (testString.equals("ABC")) {
            return true;
        }
        return false;
    }

    public String testSwitch(String monthName) {
        switch (monthName) {
            case "December":
            case "January":
            case "February":
                return "It`s winter";
            default:
                return "It`s not winter month";
        }
    }

    public ArrayList<String> nameOfCity() {

        ArrayList<String> nameOfCity = new ArrayList<>();
        nameOfCity.add("Paris");
        nameOfCity.add("Kiev");
        nameOfCity.add("Koln");
        return nameOfCity;
    }

    public Object[] objectArray() {
        Object[] objArray = new Object[3];
        objArray[0] = 1;
        objArray[1] = "technology";
        objArray[2] = false;

        return objArray;
    }
}
