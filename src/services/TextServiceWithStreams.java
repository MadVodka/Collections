package services;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextServiceWithStreams implements TextService {
    @Override
    public Map<String, Long> countEveryWord(String text) {
        String[] words = getWordsFromText(text);
        return Arrays.stream(words)
                .map(String::toLowerCase)
                .collect(Collectors.toMap(
                        Function.identity(),
                        i -> 1L,
                        (a, b) -> a + 1
                ));
    }

    @Override
    public Set<String> getUniqueWords(String text) {
        String[] words = getWordsFromText(text);
        return Arrays.stream(words)
                .map(String::toLowerCase)
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public Set<String> getSortedWords(String text) {
        String[] words = getWordsFromText(text);
        return Arrays.stream(words)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    @Override
    public Set<String> getSortedWords(String text, Comparator<String> comparator) {
        String[] words = getWordsFromText(text);
        return Arrays.stream(words)
                .sorted()
                .sorted(comparator)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private String[] getWordsFromText(String text) {
        Pattern pattern = Pattern.compile("[^а-яА-яa-zA-Z]+");
        return pattern.split(text);
    }
}
