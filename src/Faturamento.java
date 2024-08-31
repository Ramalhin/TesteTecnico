

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Faturamento {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Jaozinn\\IdeaProjects\\TesteTecnico\\src\\dadosFatura.json";

        try {
            List<Double> faturamentos = readFaturamentoFromFile(filePath);
            processarFaturamento(faturamentos);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    private static List<Double> readFaturamentoFromFile(String filePath) throws IOException {
        List<Double> faturamentos = new ArrayList<>();
        StringBuilder jsonContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }
        }


        String json = jsonContent.toString();
        json = json.replace("[", "").replace("]", "").replace("{", "").replace("}", "");
        String[] entries = json.split(",\\s*");

        for (String entry : entries) {
            if (entry.contains("faturamento")) {
                String[] parts = entry.split(":\\s*");
                double faturamento = Double.parseDouble(parts[1]);
                faturamentos.add(faturamento);
            }
        }

        return faturamentos;
    }

    private static void processarFaturamento(List<Double> faturamentos) {
        double menorFaturamento = Double.MAX_VALUE;
        double maiorFaturamento = Double.MIN_VALUE;
        double somaFaturamento = 0.0;
        int diasComFaturamento = 0;

        for (double valor : faturamentos) {
            if (valor > 0) {
                if (valor < menorFaturamento) {
                    menorFaturamento = valor;
                }
                if (valor > maiorFaturamento) {
                    maiorFaturamento = valor;
                }
                somaFaturamento += valor;
                diasComFaturamento++;
            }
        }

        if (diasComFaturamento == 0) {
            System.out.println("Nenhum dia com faturamento registrado.");
            return;
        }

        double mediaFaturamento = somaFaturamento / diasComFaturamento;

        int diasAcimaMedia = 0;
        for (double valor : faturamentos) {
            if (valor > mediaFaturamento) {
                diasAcimaMedia++;
            }
        }

        System.out.println("Menor valor de faturamento: " + menorFaturamento);
        System.out.println("Maior valor de faturamento: " + maiorFaturamento);
        System.out.println("Número de dias com faturamento acima da média: " + diasAcimaMedia);
    }
}