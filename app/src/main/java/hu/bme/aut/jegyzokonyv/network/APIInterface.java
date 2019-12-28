package hu.bme.aut.jegyzokonyv.network;

import java.util.List;

import hu.bme.aut.jegyzokonyv.data.Round;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("round")
    Call<List<Round>> getAllRounds();
}
