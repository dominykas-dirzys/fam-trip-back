package lt.sdacademy.university.tasks.fundamentals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ATaskTest {

    private ATask aTask;

    @BeforeEach
    void setUp() {
        aTask = new ATask();
    }

    @Test
    public void printAndGetMessage() {
        String expectedResult = "Message from the method";

        String result = aTask.printAndGetMessage();

        assertEquals(expectedResult, result);
    }
}
