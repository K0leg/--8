package company;

public class BoxPrinter {
    public static void print(String content) {
        int length = content.length();
        String border = "+" + "-".repeat(length + 4) + "+";

        System.out.println(border);
        System.out.println("|  " + content + "  |");
        System.out.println(border);
    }
}