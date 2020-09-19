package lt.sdacademy.university.tasks.fundamentals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BTaskTest {

    private BTask bTask;

    @BeforeEach
    void setUp() {
        bTask = new BTask();
    }

    @Test
    void printMessage() {
        String expectedResult = "Processed message: MESSAGE FROM THE METHOD";

        String result = bTask.printMessage();

        assertEquals(expectedResult, result);
    }
}
