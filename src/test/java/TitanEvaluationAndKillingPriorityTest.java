import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TitanEvaluationAndKillingPriorityTest {

    @Test
    void testEvaluateDangerRisk() {
        Queue<String> data = getTestData();
        assertNotNull(data);

        assertEquals(Arrays.asList(19, 13, 15), TitanEvaluationAndKillingPriority.evaluateDangerRisk(data.poll()));
        assertEquals(Arrays.asList(19, 15), TitanEvaluationAndKillingPriority.evaluateDangerRisk(data.poll()));
        assertEquals(List.of(19), TitanEvaluationAndKillingPriority.evaluateDangerRisk(data.poll()));
        assertEquals(List.of(15), TitanEvaluationAndKillingPriority.evaluateDangerRisk(data.poll()));
        assertEquals(List.of(8), TitanEvaluationAndKillingPriority.evaluateDangerRisk(data.poll()));
        assertEquals(Arrays.asList(15, 10), TitanEvaluationAndKillingPriority.evaluateDangerRisk(data.poll()));
        assertEquals(Arrays.asList(15, 5, 12), TitanEvaluationAndKillingPriority.evaluateDangerRisk(data.poll()));
    }

    private Queue<String> getTestData() {
        Queue<String> data = new ArrayDeque<>();
        try (Scanner input = new Scanner(new FileInputStream("src/test/resources/test-data/evaluateDangerRiskTest.txt"))) {
            while (input.hasNextLine()) {
                int noOfTitans = input.nextInt();
                input.nextLine();
                for (int i = 0; i < noOfTitans; i++) {
                    String titan = input.nextLine();
                    data.offer(titan);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("evaluateDangerRisk: Test data file is not found!");
            return null;
        }
        return data;
    }

}