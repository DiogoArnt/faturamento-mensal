import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class FaturamentoDistribuidora {
    
    public static void main(String[] args) {
        // Exemplo de dados em JSON
        String jsonData = "[{\"dia\": 1, \"valor\": 200.5}, {\"dia\": 2, \"valor\": 0.0}, {\"dia\": 3, \"valor\": 320.75}, {\"dia\": 4, \"valor\": 0.0}, {\"dia\": 5, \"valor\": 150.0}, {\"dia\": 6, \"valor\": 0.0}, {\"dia\": 7, \"valor\": 540.3}]";

        // Parseando os dados JSON
        JSONArray jsonArray = new JSONArray(jsonData);

        // Variáveis para armazenar o menor e o maior valor de faturamento
        double menorValor = Double.MAX_VALUE;
        double maiorValor = Double.MIN_VALUE;
        double somaValores = 0;
        int diasComFaturamento = 0;

        // Lista para armazenar os valores de faturamento para calcular a média
        List<Double> valores = new ArrayList<>();

        // Processando os dados
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject dia = jsonArray.getJSONObject(i);
            double valor = dia.getDouble("valor");

            if (valor > 0) {  // Ignorando dias sem faturamento 
                valores.add(valor);
                somaValores += valor;
                diasComFaturamento++;

                if (valor < menorValor) {
                    menorValor = valor;
                }
                if (valor > maiorValor) {
                    maiorValor = valor;
                }
            }
        }

        // Calculando a média mensal
        double mediaMensal = somaValores / diasComFaturamento;

        // Contando quantos dias tiveram faturamento acima da média
        int diasAcimaDaMedia = 0;
        for (double valor : valores) {
            if (valor > mediaMensal) {
                diasAcimaDaMedia++;
            }
        }

        // Exibindo os resultados
        System.out.println("Menor valor de faturamento: " + menorValor);
        System.out.println("Maior valor de faturamento: " + maiorValor);
        System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);
    }
}