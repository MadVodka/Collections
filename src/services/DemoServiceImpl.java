package services;

import holders.TextHolder;

import java.util.Map;
import java.util.Set;

public class DemoServiceImpl implements DemoService {
    private String text = TextHolder.TEXT1;
    private TextService textService;
    private Map<String, Long> countOfWords;

    public DemoServiceImpl() {
        textService = new TextServiceImpl();
        countOfWords = textService.countEveryWord(text);
    }

    @Override
    public void run() {
        System.out.println("------ Start of Collections demo ------");

        System.out.println(text);
        System.out.println();

        showWords();
        showUniqueWords();
        showSortedWords();

        System.out.println("------ End of collections demo ------");
    }

    private void showWords() {
        System.out.println("------ Every word with counter ------");
        countOfWords.forEach((word, aLong) -> System.out.printf("%s - %d%n", word, aLong));
        System.out.println();
    }

    private void showUniqueWords() {
        System.out.println("------ Unique words ------");
        Set<String> words = countOfWords.keySet();
        words.forEach(System.out::println);
        System.out.println();
    }

    private void showSortedWords() {
        System.out.println("------ Sorted words ------");
        Map<String, Long> sorted = textService.sortWords(countOfWords);
        sorted.forEach((word, aLong) -> System.out.println(word));
        System.out.println();
    }
}
