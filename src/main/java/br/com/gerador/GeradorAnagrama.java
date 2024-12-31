package br.com.gerador;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilitária para gerar anagramas de um conjunto dado de letras distintas.
 */
public class GeradorAnagrama {
    public static void main(String[] args) {
        // Example usage
        try {
            char[] input = {'a', 'b', 'c'};
            List<String> anagramas = generateAnagrams(input);
            System.out.println("Generated anagrams: " + anagramas);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Gera todos os possíveis anagramas de um conjunto dado de letras distintas.
     *
     * @param input  array de caracteres distintos.
     * @return lista de todos os possíveis anagramas.
     * @throws IllegalArgumentException se a entrada for nula, vazia ou contiver caracteres inválidos.
     */
    public static List<String> generateAnagrams(char[] input) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("A entrada não pode nula ou vazia.");
        }

        for (char c : input) {
            if (!Character.isLetter(c)) {
                throw new IllegalArgumentException("A entrada deve conter apenas letras.");
            }
        }

        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), input, new boolean[input.length]);
        return result;
    }

    /**
     * Método auxiliar para retroceder e gerar anagramas.
     *
     * @param result Lista para armazenar os anagramas gerados.
     * @param current Anagrama atual sendo construído.
     * @param input Array de entrada de caracteres.
     * @param used Array booleano para rastrear os caracteres usados.
     */
    private static void backtrack(List<String> result, StringBuilder current, char[] input, boolean[] used) {
        if (current.length() == input.length) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            current.append(input[i]);
            backtrack(result, current, input, used);
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }
}