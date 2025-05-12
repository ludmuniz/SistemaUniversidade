package main.java.br.edu.amazonia.utils.validation;

public class ValidadorUtils {
    public static void validarNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido.");
        }
    }
}