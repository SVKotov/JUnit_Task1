import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class EmployeeTest {

    private static long suiteStartTime;
    private long testStartTime;

    Employee employee = new Employee(5, "Sergei", "Kotov", "RU", 39);

    @BeforeAll
    public static void initSuite() {
        System.out.println("Running 'EmployeeTest' for methods of class \"Employee\"");
        suiteStartTime = System.nanoTime();
    }

    @AfterAll
    public static void completeSuite() {
        System.out.println("The 'EmployeeTest' complete: " + (System.nanoTime() - suiteStartTime));
    }

    @BeforeEach
    public void initTest() {
        System.out.println("Starting new test");
        testStartTime = System.nanoTime();
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("Test complete: " + (System.nanoTime() - testStartTime));
    }

    @Test
    @DisplayName("Test \"Employee\" class constructor")
    public void validEmployeeTest(TestInfo validEmployeeTestInfo) {
        Assertions.assertNotNull(employee, validEmployeeTestInfo.getDisplayName() + " is NO complete!");
        System.out.println(validEmployeeTestInfo.getDisplayName() + " complete!");
    }

    @Test
    @DisplayName("Test \"getId()\" method")
    public void getIdTest(TestInfo getIdTestInfo) {
        Assertions.assertEquals(5, employee.getId(), getIdTestInfo.getDisplayName() + " is NO complete!");
        System.out.println(getIdTestInfo.getDisplayName() + " complete!");
    }

    @ParameterizedTest
    @DisplayName("Test \"setId()\" method")
    @ValueSource(longs = {-526, 0, 128, 102458})
    public void setIdParametrizedTest(long id) {
        employee.setId(id);
        Assertions.assertEquals(id, employee.getId(), " is NO complete!");
        System.out.println("Test \"setId(" + id + ")\" method complete!");
    }

    @Test
    @DisplayName("Test \"getFirstName()\" method")
    public void getFirstNameTest(TestInfo getFirstNameTestInfo) {
        Assertions.assertEquals("Sergei", employee.getFirstName(), getFirstNameTestInfo.getDisplayName() + " is NO complete!");
        System.out.println(getFirstNameTestInfo.getDisplayName() + " complete!");
    }

    @ParameterizedTest
    @DisplayName("Test \"setFirstName()\" method")
    @ValueSource(strings = {"Filipp", "IUri", "Valeriy"})
    public void setFirstNameParametrizedTest(String firstName) {
        employee.setFirstName(firstName);
        Assertions.assertEquals(firstName, employee.getFirstName());
        System.out.println("Test \"setFirstName(" + firstName + ")\" method complete!");
    }

    @Test
    @DisplayName("Test \"getLastName()\" method")
    public void getLastNameTest(TestInfo testInfo) {
        Assertions.assertEquals("Kotov", employee.getLastName(), testInfo.getDisplayName() + " is NO complete!");
        System.out.println(testInfo.getDisplayName() + " complete!");
    }

    @ParameterizedTest
    @DisplayName("Test \"setLastName()\" method")
    @ValueSource(strings = {"Dyatlov", "Gavrilov", "Galustyan"})
    public void setLastNameParametrizedTest(String lastName) {
        employee.setLastName(lastName);
        Assertions.assertEquals(lastName, employee.getLastName());
        System.out.println("Test \"setFirstName(" + lastName + ")\" method complete!");
    }

    @Test
    @DisplayName("Test \"getCountry()\" method")
    public void getCountryTest(TestInfo testInfo) {
        Assertions.assertEquals("RU", employee.getCountry(), testInfo.getDisplayName() + " is NO complete!");
        System.out.println(testInfo.getDisplayName() + " complete!");
    }

    @ParameterizedTest
    @DisplayName("Test \"setCountry()\" method")
    @ValueSource(strings = {"US", "GB", "FR"})
    public void setCountryParameterizedTest(String country) {
        employee.setCountry(country);
        Assertions.assertEquals(country, employee.getCountry());
        System.out.println("Test \"setCountry(" + country + ")\" method complete!");
    }

    @Test
    @DisplayName("Test \"getAge()\" method")
    public void getAgeTest(TestInfo getAgeTestInfo) {
        Assertions.assertEquals(39, employee.getAge(), getAgeTestInfo.getDisplayName() + " is NO complete!");
        System.out.println(getAgeTestInfo.getDisplayName() + " complete!");
    }

    @ParameterizedTest
    @DisplayName("Test \"setAge()\" method for correct values")
    @ValueSource(ints = {1, 256, 10, 33})
    public void setAgeCorrectValuesParameterizedTest(int age) {
        employee.setAge(age);
        Assertions.assertEquals(age, employee.getAge());
        System.out.println("Test \"setAge(" + age + ")\" method complete!");
    }

    @ParameterizedTest
    @DisplayName("Test \"setAge()\" method for incorrect values")
    @ValueSource(ints = {-50, -2, 0})
    void setAgeIncorrectValuesParameterizedTest(int age) {
        employee.setAge(age);
        Assertions.assertEquals("Incorrect value '" + age + "' of 'age' !", "Incorrect value '" + age + "' of 'age' !");
        System.out.println("Test \"setAge(" + age + ")\" method complete!");
    }

    @Test
    @DisplayName("Test \"toString()\" method")
    public void toStringTest(TestInfo toStringTestInfo) {
        String employeeToString = employee.toString();
        Assertions.assertEquals(employeeToString, employee.toString(), toStringTestInfo.getDisplayName() + " is NO complete!");
        System.out.println(toStringTestInfo.getDisplayName() + " complete!");
    }
}
