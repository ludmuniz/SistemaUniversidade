package main.java.br.edu.amazonia.utils.csv;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {

    public static List<String> lerLinhas(File arquivo) throws IOException {
        if (!arquivo.exists()) {
            // Se não existe, retornamos lista vazia
            return new ArrayList<>();
        }
        return Files.readAllLines(arquivo.toPath());
    }

    public static void escreverLinhas(File arquivo, List<String> linhas) throws IOException {
        Files.write(arquivo.toPath(), linhas, StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING);
    }
}

