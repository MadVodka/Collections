package services;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TextServiceImpl implements TextService {
    @Override
    public Map<String, Long> countEveryWord(String text) {
        String[] words = getWordsFromText(text);
        Map<String, Long> countOfWords = new HashMap<>();
        for (String word : words) {
            String wordInLowerCase = word.toLowerCase();
            if (countOfWords.containsKey(wordInLowerCase)) {
                Long value = countOfWords.get(wordInLowerCase);
                countOfWords.put(wordInLowerCase, value + 1);
            } else {
                countOfWords.put(wordInLowerCase, (long) 1);
            }
        }
        return countOfWords;
    }

    @Override
    public Set<String> getUniqueWords(String text) {
        String[] words = getWordsFromText(text);
        return new HashSet<>(Arrays.asList(words));
    }

    @Override
    public Set<String> sortedWords(String text) {
        String[] words = getWordsFromText(text);
        return new TreeSet<>(Arrays.asList(words));
    }

    private String[] getWordsFromText(String text) {
        Pattern pattern = Pattern.compile("[^а-яА-яa-zA-Z]+");
        return pattern.split(text);
    }
}
