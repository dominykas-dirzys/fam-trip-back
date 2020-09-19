package lt.sdacademy.university.tasks.fundamentals;

public class CTask {

    public String processString(String str) {
        // TODO: call StringProcessor process method passing str param and return the result
        return null;
    }
}

class StringProcessor {

    public String process(String str) {
        return str.trim().toUpperCase().replace(" ", "_");
    }
}
