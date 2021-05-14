import org.testng.annotations.*;

public class ParentClass {
    @BeforeClass
    public void textBeforeClass(){
        System.out.println("New test class executes here");
    }

    @AfterClass
    public void textAfterClass(){
        System.out.println("Test class execution ends here");
    }

    @BeforeMethod
    public void textBeforeMethod(){
        System.out.println("New method starts here");
    }

    @AfterMethod
    public void textAfterMethod(){
        System.out.println("Method ends here");
    }

    @AfterSuite(alwaysRun = true)
    public void textAfterSuite(){
        System.out.println("Method ends here");
    }
}
