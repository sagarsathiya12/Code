package sagar.retrofitex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Api.ApiService;
import Api.RetroClient;
import Model.Contact;
import Model.ContactList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class MainActivity extends AppCompatActivity {

    private TextView tv;
    public List<Contact> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.abc);

        ApiService api = RetroClient.getApiService();

        /**
         * Calling JSON
         */
        Call<ContactList> call = api.getMyJSON();

        call.enqueue(new Callback<ContactList>() {
            @Override
            public void onResponse(Call<ContactList> call, Response<ContactList> response) {
                Log.e("response >>>>>>",response.body().toString());

                list = response.body().getContacts();
                tv.setText(list.get(0).getName());
            }

            @Override
            public void onFailure(Call<ContactList> call, Throwable t) {

                Log.e("fail >>>>>>", t.toString());
            }
        });
    }
}
