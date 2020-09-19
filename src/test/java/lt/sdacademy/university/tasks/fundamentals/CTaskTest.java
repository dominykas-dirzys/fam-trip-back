package lt.sdacademy.university.tasks.fundamentals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CTaskTest {

    private CTask cTask;

    @BeforeEach
    void setUp() {
        cTask = new CTask();
    }

    @Test
    void processString() {
        String str = "  this is a Message to BECOME processed  ";
        String expectedResult = "THIS_IS_A_MESSAGE_TO_BECOME_PROCESSED";

        String result = cTask.processString(str);

        assertEquals(expectedResult, result);
    }
}
