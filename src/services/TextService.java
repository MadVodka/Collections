package services;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

public interface TextService {
    Map<String, Long> countEveryWord(String text);

    Set<String> getUniqueWords(String text);

    Set<String> getSortedWords(String text);

    Set<String> getSortedWords(String text, Comparator<String> comparator);
}
