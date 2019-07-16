package services;

import comparators.StringLengthComparator;
import holders.TextHolder;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

public class DemoServiceImpl implements DemoService {
    private String text = TextHolder.TEXT1;
    private TextService textService;
    private String demoName;

    public DemoServiceImpl(TextService textService, String demoName) {
        this.textService = textService;
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
        Map<String, Long> countOfWords = textService.countEveryWord(text);
        countOfWords.forEach((word, aLong) -> System.out.printf("%s - %d%n", word, aLong));
        System.out.println();
    }

    private void showUniqueWords() {
        System.out.printf("------ Unique words (%s) ------%n", demoName);
        Set<String> words = textService.getUniqueWords(text);
        words.forEach(System.out::println);
        System.out.println();
    }

    private void showSortedWords() {
        System.out.printf("------ Sorted words (%s) ------%n", demoName);
        System.out.println("ALPHABETICALLY");
        Set<String> sorted = textService.getSortedWords(text);
        sorted.forEach(System.out::println);
        System.out.println();

        System.out.println("BY LENGTH");
        Comparator<String> comparator = new StringLengthComparator();
        Set<String> sortedByLength = textService.getSortedWords(text, comparator);
        sortedByLength.forEach(System.out::println);
        System.out.println();
    }
}
