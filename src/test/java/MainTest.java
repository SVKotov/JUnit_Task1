import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MainTest {

    private static long suiteStartTime;
    private long testStartTime;

    private String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
    private String csvFileName = "data.csv";
    private String csvJsonActualFileName = "data.json";
    private String csvJsonExpectedFileName = "dataExpected.json";

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
    @DisplayName("Test \"parceCSV()\" static method")
    public void parseCSVTest(TestInfo parseCSVTestInfo) {

        List<Employee> expected = Arrays.asList(
                new Employee(1, "John", "Smith", "USA", 25),
                new Employee(2, "Inav", "Petrov", "RU", 23)
        );

        List<Employee> actual = Main.parseCSV(columnMapping, csvFileName);

        Assertions.assertEquals(expected, actual, parseCSVTestInfo.getDisplayName() + " NO complete!");
        System.out.println(parseCSVTestInfo.getDisplayName() + " complete!");
    }

    @Test
    @DisplayName("Test \"listToJson()\" static method")
    public void listToJsonTest(TestInfo listToJsonTestInfo) {

        String expected = "[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"firstName\": \"John\",\n" +
                "    \"lastName\": \"Smith\",\n" +
                "    \"country\": \"USA\",\n" +
                "    \"age\": 25\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 2,\n" +
                "    \"firstName\": \"Inav\",\n" +
                "    \"lastName\": \"Petrov\",\n" +
                "    \"country\": \"RU\",\n" +
                "    \"age\": 23\n" +
                "  }\n" +
                "]";
        List<Employee> listFromCSV = Main.parseCSV(columnMapping, csvFileName);
        String actual = (String) Main.listToJson(listFromCSV);

        Assertions.assertEquals(expected, actual, listToJsonTestInfo.getDisplayName() + " NO complete!");
        System.out.println(listToJsonTestInfo.getDisplayName() + " complete!");
    }

    @Test
    @DisplayName("Test \"writeString()\" static method")
    public void writeStringTest(TestInfo writeStringTestInfo) {

        // CSV --> Json

        System.out.println("Starting csv -> json convertation...");

        List<Employee> listFromCSV = Main.parseCSV(columnMapping, csvFileName);
        String jsonFromCSV = (String) Main.listToJson(listFromCSV);
        Main.writeString(jsonFromCSV, csvJsonActualFileName);

        System.out.println("End csv -> json convertation");

        // read expected file csvJsonExpectedFileName

        System.out.println("Reading \"" + csvJsonExpectedFileName + "\" file...");

        String s;
        StringBuilder sbExpectedString = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(csvJsonExpectedFileName))) {
            while ((s = br.readLine()) != null) {
                sbExpectedString.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String expected = sbExpectedString.toString();

        // read actual file csvJsonActualFileName

        System.out.println("Reading \"" + csvJsonActualFileName + "\" file...");

        StringBuilder sbActualString = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(csvJsonActualFileName))) {
            while ((s = br.readLine()) != null) {
                sbActualString.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String actual = sbActualString.toString();

        // run assertion

        Assertions.assertEquals(expected, actual, writeStringTestInfo.getDisplayName() + " NO complete!");
        System.out.println(writeStringTestInfo.getDisplayName() + " complete!");

    }


}
