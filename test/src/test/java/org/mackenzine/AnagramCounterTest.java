package org.mackenzine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramCounterTest {

	private AnagramCounter counter;
	private List<String> wordList;

	@BeforeEach
	public void setUp() {
		counter = new AnagramCounter();
		wordList = new ArrayList<String>();
		wordList.add("cat");
		wordList.add("cat");
		wordList.add("rat");
		wordList.add("tar");
		wordList.add("art");
		wordList.add("trap");
		wordList.add("rapt");
		wordList.add("univision");
		wordList.add("act");
		wordList.add("part");
		wordList.add("trap");
		wordList.add("part");
		wordList.add("tarp");
		wordList.add("rat");
		wordList.add("face");
		wordList.add("cafe");
	}

	@Test
	public void shouldDetectAnagramBetweenTwoWords() {
		assertFalse(counter.isAnagramOf("cactus", "act"));
		assertFalse(counter.isAnagramOf("rat", "act"));
		assertTrue(counter.isAnagramOf("cat", "act"));
	}

	@Test
	public void shouldDetectAnagramClass() {
		List<String> anagramClass = counter.detectAnagramClass(wordList, "cat");

		assertEquals(3, anagramClass.size());
		assertTrue(anagramClass.contains("cat"));
		assertTrue(anagramClass.contains("act"));
	}

	@Test
	public void shouldCountAnagrams() {
		Map<String, Integer> count = counter.count(wordList);

		assertEquals(3, count.get("cat").intValue());
		assertEquals(4, count.get("rat").intValue());
		assertEquals(6, count.get("trap").intValue());
		assertEquals(1, count.get("univision").intValue());
		assertEquals(2, count.get("face").intValue());
	}
}
