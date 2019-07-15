package services;

import holders.TextHolder;

import java.util.Map;
import java.util.Set;

public class DemoServiceImpl implements DemoService {
    private String text = TextHolder.TEXT1;
    private TextService textService;
    private Map<String, Long> countOfWords;
    private String demoName;

    public DemoServiceImpl(TextService textService, String demoName) {
        this.textService = textService;
        countOfWords = textService.countEveryWord(text);
        this.demoName = demoName;
    }

    @Override
    public void run() {
        System.out.printf("------ Start of collections demo (%s) ------%n", demoName);

        System.out.println(text);
        System.out.println();

        showWords();
        showUniqueWords();
        showSortedWords();

        System.out.printf("------ End of collections demo (%s)------%n%n", demoName);
    }

    private void showWords() {
        System.out.printf("------ Every word with counter (%s) ------%n", demoName);
        countOfWords.forEach((word, aLong) -> System.out.printf("%s - %d%n", word, aLong));
        System.out.println();
    }

    private void showUniqueWords() {
        System.out.printf("------ Unique words (%s) ------%n", demoName);
        Set<String> words = countOfWords.keySet();
        words.forEach(System.out::println);
        System.out.println();
    }

    private void showSortedWords() {
        System.out.printf("------ Sorted words (%s) ------%n", demoName);
        Set<String> sorted = textService.sortedWords(text);
        sorted.forEach(System.out::println);
        System.out.println();
    }
}
