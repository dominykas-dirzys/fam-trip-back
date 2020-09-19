package lt.sdacademy.university.tasks;

public class ATask {

    private static boolean isOk() {
        System.out.println("isOk");
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isOk() & isOk() ? "true" : "false");
    }
}
