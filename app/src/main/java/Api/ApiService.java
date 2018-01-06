package Api;

import Model.ContactList;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Tech on 12/30/2017.
 */

public interface ApiService {

    /*
    Retrofit get annotation with our URL
    And our method that will return us the List of ContactList
    */
    @GET("/json_data.json")
    Call<ContactList> getMyJSON();
}