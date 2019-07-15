package services;

import java.util.Map;
import java.util.Set;

public interface TextService {
    Map<String, Long> countEveryWord(String text);

    Set<String> getUniqueWords(Map<String, ?> words);

    Map<String, Long> sortWords(Map<String, Long> words);
}
