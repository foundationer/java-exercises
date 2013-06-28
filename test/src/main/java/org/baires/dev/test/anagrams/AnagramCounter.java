package org.baires.dev.test.anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Anagram counter.
 * @author Lucas Godoy
 *
 */
public class AnagramCounter {

	/**
	 * This method can tell if two words are anagrams.
	 * @param word1 first word
	 * @param word2 second word
	 * @return true is the two words are anagrams.
	 */
	public boolean isAnagramOf(final String word1, final String word2) {
		if(word1.length() == word2.length()) {
			char[] word1Chars = word1.toCharArray();
			boolean result = true;
			for (char c : word1Chars) {
				result &= (word2.indexOf(c) != -1);
			}
			return result;
		} else {
			return false;
		}
	}

	/**
	 * Being a anagram is a equivalence relation. So each group of anagrams are a partition of the original list.
	 * This method detects the whole partition belonging to the word passed as a parameter.
	 * @param wordList list of words to look for the partition
	 * @param main a member of the equivalence class to be detected
	 * @return A sublist containing words that are anagrams of the first word in the original list.
	 */
	public List<String> detectAnagramClass(final List<String> wordList, final String main) {
		List<String> anagramClass = new ArrayList<String>();
		for (String word : wordList) {
			if(isAnagramOf(word, main)) {
				anagramClass.add(word);
			}
		}
		return anagramClass;
	}

	/**
	 * Returns a map with the number of anagrams for each anagram class. The key for each class is the first word in appearance order.
	 * @param wordList List of words to look for anagrams
	 * @return a map with the number of anagrams for each anagram class.
	 */
	public Map<String, Integer> count(final List<String> wordList) {
		Map<String, Integer> result = new HashMap<String, Integer>();

		while(!wordList.isEmpty()) {
			String firstWord = wordList.get(0);
			List<String> anagramClass = detectAnagramClass(wordList, firstWord);
			result.put(firstWord, anagramClass.size());
			wordList.removeAll(anagramClass);
		}
		return result;
	}
}
