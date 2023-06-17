import java.util.Scanner;


public class HangmanGame {
    private static String[] words = {"автомобиль", "дом", "здание", "карандаш", "компьютер"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        while (true) {
            System.out.print("Начать новую игру (1) или выйти из приложения (0): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Игра \"Виселица\" началась!");

                break;
            } else if (choice == 0) {
                System.out.println("Выход из приложения...");
                System.exit(0);
            } else {
                System.out.println("такого нет, иди нахуй");
            }
        }




                String word = getRandomWord();
                int attempts = 7;
                boolean[] guessedLetters = new boolean[word.length()];


                while (attempts > 0 && !isWordGuessed(guessedLetters)) {
                    System.out.println("Угадайте букву или слово (осталось попыток: " + attempts + "): ");
                    String input = scanner.nextLine().toLowerCase();

                    if (input.length() == 1) {
                        char letter = input.charAt(0);
                        boolean words = false;

                        for (int i = 0; i < word.length(); i++) {
                            if (word.charAt(i) == letter) {
                                guessedLetters[i] = true;
                                words = true;
                            }
                        }

                        if (words) {
                            System.out.println("Вы угадали букву!");
                        } else {
                            System.out.println("Такой буквы нет в слове");
                            attempts--;
                        }
                    } else {
                        if (input.equals(word)) {
                            for (int i = 0; i < guessedLetters.length; i++) {
                                guessedLetters[i] = true;
                            }
                            System.out.println("Вы угадали слово!");
                        } else {
                            System.out.println("Неверное слово!");
                            attempts--;
                        }
                    }
                }

                if (attempts == 0) {
                    System.out.println("Вы проиграли. Загаданное слово было: " + word);
                    System.out.println("Вы проебали хату :(");
                } else {
                    System.out.println("Вы выиграли. Загаданное слово было: " + word);
                    System.out.println("Вы выиграли хату :)");
                }

                System.out.println("Игра \"Виселица\" закончена!");
                scanner.close();
            }

            private static boolean isWordGuessed(boolean[] guessedLetters) {
                for (boolean isGuessed : guessedLetters) {
                    if (!isGuessed) {
                        return false;
                    }
                }
                return true;
            }

            private static String getRandomWord() {
                int index = (int) (Math.random() * words.length);
                return words[index];
            }
        }
