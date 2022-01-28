package nl.capite.cunsel.Helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.capite.cunsel.models.*;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import com.fasterxml.jackson.core.JsonParseException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class iexHelper {
    private final String apikey;

    private final String base = "https://cloud.iexapis.com";
    private final OkHttpClient client = new OkHttpClient();

    private final ObjectMapper mapper = new ObjectMapper();

    public iexHelper(String apikey) {
        this.apikey=apikey;
    }

    private HttpUrl urlBuilder(String path, HashMap<String,String> urlParams) {
        HttpUrl.Builder url = HttpUrl.parse(base+path).newBuilder();
        url.addQueryParameter("token",apikey);
        if (urlParams!=null) {
            for (Map.Entry<String, String> entry : urlParams.entrySet()) {
                url.addQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        return  url.build();
    }

    public List<refSymbol> getSymbols() throws IOException {
        HttpUrl url = urlBuilder("/stable/ref-data/symbols",null);

        Request req = new Request.Builder()
                .url(url)
                .build();

        Response res = client.newCall(req).execute();
        String bodyStr = res.body().string();

        refSymbol[] ls =  mapper.readValue(bodyStr,refSymbol[].class);

        return Arrays.asList(ls);
    }

    public Company getCompany(String ticker) throws IOException {
        HttpUrl url = urlBuilder("/stable/stock/" + ticker +"/company",null);

        Request req = new Request.Builder()
                .url(url)
                .build();

        Response res = client.newCall(req).execute();
        String bodyStr = res.body().string();

        Company cp = mapper.readValue(bodyStr,Company.class);
        return cp;
    }

    public List<Company> aSyncGetCompanies(List<String> tickers) {
        List<String> bodies = new ArrayList<String>();
        List<Request> reqs = new ArrayList<Request>();
        List<Company> comps = new ArrayList<Company>();

        tickers.forEach(n -> {
            HttpUrl url = urlBuilder("/stable/stock/" + n +"/company",null);
            Request req = new Request.Builder()
                    .url(url)
                    .build();
            reqs.add(req);
        });

        AtomicInteger c= new AtomicInteger();
        reqs.forEach(n -> {
            c.getAndIncrement();
            Call call = client.newCall(n);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    c.getAndDecrement();
                    System.out.println("Failed");
                    return;
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    c.getAndDecrement();
                    bodies.add(response.body().string());
                    System.out.println("Done " + n.url().url().getPath());
                    return;
                }
            });
            System.out.println("Call Made " + n.url().url().getPath());
        });

        while (c.get() !=0){

        }

        bodies.forEach(n -> {
            try {
                var temp = mapper.readValue(n,Company.class);
                comps.add(temp);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });

        comps.forEach(n -> System.out.println(n.getSymbol()));

        return comps;
    }

    public List<Company> getCompanies(List<String> tickers) throws IOException {
        List<Company> comps = new ArrayList<Company>();

        for(String x:tickers) {
            HttpUrl url = urlBuilder("/stable/stock/" + x +"/company",null);
            System.out.println(url.url().getPath());
             Request req = new Request.Builder()
                     .url(url)
                     .build();
             Response res = client.newCall(req).execute();
             var bodStr = res.body().string();

             try {
                 var t = mapper.readValue(bodStr,Company.class);
                 comps.add(t);
             } catch (JsonParseException E) {
                 continue;
             }
        }
        return comps;

    }

    public List<Logo> getLogos(List<String> tickers) throws IOException {
        List<Logo> logos = new ArrayList<>();

        for(String x:tickers) {
            HttpUrl url = urlBuilder("/stable/stock/" + x +"/logo",null);
            System.out.println(url.url().getPath());
            Request req = new Request.Builder()
                    .url(url)
                    .build();
            Response res = client.newCall(req).execute();
            var bodStr = res.body().string();

            try {
                var t = mapper.readValue(bodStr,Logo.class);
                t.setTicker(x);
                logos.add(t);
            } catch (JsonParseException E) {
                continue;
            }
        }
        return logos;

    }

    public List<StatsBasic> getStatsBasic(List<String> tickers) throws IOException {
        List<StatsBasic> stats = new ArrayList<>();

        for (String x:tickers) {
            HttpUrl url = urlBuilder("/stable/stock/" + x +"/stats",null);
            System.out.println(url.url().getPath());
            Request req = new Request.Builder()
                    .url(url)
                    .build();
            Response res = client.newCall(req).execute();
            var bodStr = res.body().string();

            try {
                var t = mapper.readValue(bodStr,StatsBasic.class);
                t.setTicker(x);
                stats.add(t);
            } catch (JsonParseException E) {
                continue;
            }

        }
        return stats;
    }

    public Quote getQuote(String ticker) throws IOException {
        HttpUrl url = urlBuilder("/stable/stock/" + ticker +"/quote",null);
        System.out.println(url.url().getPath());
        Request req = new Request.Builder()
                .url(url)
                .build();
        Response res = client.newCall(req).execute();
        var bodStr = res.body().string();
        var t = mapper.readValue(bodStr,Quote.class);
        return t;
    }

    public List<BatchQuote> getBatchQuotes(List<String> tickers) throws IOException {
        HashMap<String,String> urlParams = new HashMap<>();
        urlParams.put("symbols",tickers.stream().collect(Collectors.joining(",")));
        urlParams.put("types","quote");

        HttpUrl url = urlBuilder("/stable/stock/market/batch",urlParams);
        System.out.println(url.url().getPath());
        Request req = new Request.Builder()
                .url(url)
                .build();
        Response res = client.newCall(req).execute();
        var bodStr = res.body().string();

        ObjectMapper mapper = new ObjectMapper();
        var t = mapper.readValue(bodStr, new TypeReference<Map<String,BatchQuoteNode>>() {});
        List<BatchQuote> ls = new ArrayList<>();
        t.entrySet().forEach(n -> ls.add(new BatchQuote(n.getKey(),n.getValue().getQuote())));


        return ls;
    }

}
