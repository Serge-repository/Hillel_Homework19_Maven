import java.util.HashMap;

public class FirstClass {

    public String message(String model, String number){
        return model + number;
    }

    public int exactInteger(int i){
        int[] arr = {3,4,55,43,1};
        return arr[i];
    }

    public int nameAndAge(String name) {
        HashMap<String, Integer> nameAndAgeMap = new HashMap<>();
        nameAndAgeMap.put("Marcus", 12);
        nameAndAgeMap.put("Jane", 25);
        nameAndAgeMap.put("Jack", 31);
        return nameAndAgeMap.get(name);
    }

    public boolean trueOrFalse(String vehicle){
        if (vehicle.equals("Car")) {
            return true;
        } else {
            return false;
        }
    }

    public double typeChanger(int thisIsInt, double thisIsDouble) {
        return thisIsInt * thisIsDouble;
    }
}
