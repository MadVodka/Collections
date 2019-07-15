package services;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class TextServiceImpl implements TextService {
    @Override
    public Map<String, Long> countEveryWord(String text) {
        Pattern pattern = Pattern.compile("[^а-яА-яa-zA-Z]+");
        String[] words = pattern.split(text);
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
    public Set<String> getUniqueWords(Map<String, ?> words) {
        return words.keySet();
    }

    @Override
    public Map<String, Long> sortWords(Map<String, Long> words) {
        return new TreeMap<>(words);
    }
}
