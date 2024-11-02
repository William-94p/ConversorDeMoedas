import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConversorDeMoedas {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/4fec4e59ef5321f89431ef79/latest/BRL";
    private static Map<String, Double> taxasCambio = new HashMap<>();

    public static void main(String[] args) {
        if (carregarTaxasCambio()) {
            Scanner scanner = new Scanner(System.in);
            int opcao;

            do {
                System.out.println("=== Conversor de Moedas ===");
                System.out.println("Escolha uma opção:");
                System.out.println("1. Real para Dólar");
                System.out.println("2. Real para Euro");
                System.out.println("3. Real para Peso argentino");
                System.out.println("4. Real para Iene");
                System.out.println("5. Iene para Euro");
                System.out.println("6. Peso argentino para Dólar");
                System.out.println("7. Sair");

                System.out.print("Opção: ");
                opcao = scanner.nextInt();

                if (opcao >= 1 && opcao <= 6) {
                    System.out.print("Digite o valor a ser convertido: ");
                    double valor = scanner.nextDouble();
                    String moedaOrigem = getMoedaOrigem(opcao);
                    String moedaDestino = getMoedaDestino(opcao);

                    double taxaOrigemParaBRL = moedaOrigem.equals("BRL") ? 1.0 : 1.0 / taxasCambio.getOrDefault(moedaOrigem, 0.0);
                    double taxaDestinoParaBRL = moedaDestino.equals("BRL") ? 1.0 : 1.0 / taxasCambio.getOrDefault(moedaDestino, 0.0);

                    double valorConvertido = valor * taxaOrigemParaBRL / taxaDestinoParaBRL;
                    System.out.printf("Valor convertido: %.2f %s\n", valorConvertido, moedaDestino);
                } else if (opcao == 7) {
                    System.out.println("Saindo do programa... Obrigado peça visita...");
                } else {
                    System.out.println("Opção inválida.");
                }
            } while (opcao != 7);

            scanner.close();
        } else {
            System.out.println("Erro ao carregar taxas de câmbio.");
        }
    }

    private static boolean carregarTaxasCambio() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonResponse = response.body();

            // Parse JSON response to get exchange rates
            taxasCambio = parseTaxasCambio(jsonResponse);
            return true;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static Map<String, Double> parseTaxasCambio(String jsonResponse) {
        Map<String, Double> taxas = new HashMap<>();
        if (jsonResponse.contains("\"conversion_rates\":")) {
            int start = jsonResponse.indexOf("\"conversion_rates\":") + 19;
            int end = jsonResponse.indexOf("}", start);
            String taxasStr = jsonResponse.substring(start, end);

            String[] paresTaxas = taxasStr.split(",");
            for (String par : paresTaxas) {
                String[] keyValue = par.replaceAll("\"", "").split(":");
                taxas.put(keyValue[0].trim(), Double.parseDouble(keyValue[1].trim()));
            }
        }
        return taxas;
    }

    private static String getMoedaOrigem(int opcao) {
        switch (opcao) {
            case 1: case 2: case 3: case 4: return "BRL";
            case 5: return "JPY";
            case 6: return "ARS";
            default: return "";
        }
    }

    private static String getMoedaDestino(int opcao) {
        switch (opcao) {
            case 1: return "USD";
            case 2: return "EUR";
            case 3: return "ARS";
            case 4: return "JPY";
            case 5: return "EUR";
            case 6: return "USD";
            default: return "";
        }
    }
}
