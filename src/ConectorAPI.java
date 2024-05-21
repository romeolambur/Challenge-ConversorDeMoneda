import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConectorAPI {

    public Moneda buscaMoneda(String tipoDeMoneda, String monedaConversion, Double cantidadConversion){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/491057c8181abbf0c8a9b7f1/pair/" + tipoDeMoneda + "/" + monedaConversion + "/" + cantidadConversion);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré ese tipo de Moneda.");

        }
    }
}
