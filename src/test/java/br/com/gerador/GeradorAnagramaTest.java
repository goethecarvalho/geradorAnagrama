package br.com.gerador;

import java.util.List;

public class GeradorAnagramaTest {

    public static void runTests() {
        testValidInput();
        testSingleCharacterInput();
        testEmptyInput();
        testInvalidCharacterInput();
    }

    private static void testValidInput() {
        char[] input = {'a', 'b', 'c'};
        List<String> result = GeradorAnagrama.generateAnagrams(input);
        assert result.size() == 6 : "Expected 6 anagrams, got " + result.size();
        assert result.contains("abc") : "Missing anagram: abc";
        assert result.contains("acb") : "Missing anagram: acb";
        assert result.contains("bac") : "Missing anagram: bac";
        assert result.contains("bca") : "Missing anagram: bca";
        assert result.contains("cab") : "Missing anagram: cab";
        assert result.contains("cba") : "Missing anagram: cba";
    }

    private static void testSingleCharacterInput() {
        char[] input = {'x'};
        List<String> result = GeradorAnagrama.generateAnagrams(input);
        assert result.size() == 1 : "Expected 1 anagram, got " + result.size();
        assert result.contains("x") : "Missing anagram: x";
    }

    private static void testEmptyInput() {
        try {
            char[] input = {};
            GeradorAnagrama.generateAnagrams(input);
            assert false : "Expected IllegalArgumentException for empty input";
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("Input cannot be null or empty.") : "Unexpected error message: " + e.getMessage();
        }
    }

    private static void testInvalidCharacterInput() {
        try {
            char[] input = {'a', '1', 'c'};
            GeradorAnagrama.generateAnagrams(input);
            assert false : "Expected IllegalArgumentException for invalid input";
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("Input must contain only letters.") : "Unexpected error message: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        runTests();
        System.out.println("All tests passed.");
    }
}
