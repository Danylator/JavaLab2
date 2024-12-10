import java.util.Scanner;

public class LetrRemover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Введіть текст:");
        String inputText = scanner.nextLine();


        System.out.println("Введіть довжину слова для видалення:");
        int wordLength = scanner.nextInt();
        scanner.nextLine();

       
        StringBuilder textBuilder = new StringBuilder(inputText);


        String[] words = textBuilder.toString().split("\\s+");

       
        StringBuilder resultBuilder = new StringBuilder();
        for (String word : words) {
            
            String cleanedWord = word.replaceAll("[^a-zA-Z]", "");
            if (!shouldRemove(cleanedWord, wordLength)) {
                resultBuilder.append(word).append(" ");
            }
        }

 
        if (resultBuilder.length() > 0) {
            resultBuilder.setLength(resultBuilder.length() - 1);
        }


        System.out.println("Результат:");
        System.out.println(resultBuilder.toString());
    }


    private static boolean shouldRemove(String word, int length) {
        if (word.length() != length) {
            return false;
        }

        if (word.isEmpty()) {
            return false;
        }

        char firstChar = Character.toLowerCase(word.charAt(0));
        return isConsonant(firstChar);
    }


    private static boolean isConsonant(char c) {
        return "bcdfghjklmnpqrstvwxyz".indexOf(c) >= 0;
    }
}
