package lt.sdacademy.university.tasks.fundamentals;

public class BTask {

    /**
     * Method actions:
     *  get the message
     *  pass it to process
     *  return processed message as a result
     */
    public String printMessage() {
        getMessage();
        return process(null);
    }

    // TODO: bonus - overload printMessage with int number which shows how many times call process method

    private String getMessage() {
        return "Message from the method";
    }

    private String process(String messageToProcess) {
        return "Processed message: " + messageToProcess.toUpperCase();
    }
}
