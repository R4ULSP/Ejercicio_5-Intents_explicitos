package es.travelworld.ejercicio5_intentsexplicitos;

import static es.travelworld.ejercicio5_intentsexplicitos.tools.References.KEY_USER;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import es.travelworld.ejercicio5_intentsexplicitos.databinding.ActivityHomeBinding;
import es.travelworld.ejercicio5_intentsexplicitos.tools.User;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private User user;

    @Override
    //TODO Configurar actionbar
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        setContentView(binding.getRoot());

        user = (User)getIntent().getSerializableExtra(KEY_USER);

        Log.i("---Datos usuario","\nNombre: " + user.getName() + "\nApellidos: " + user.getLastname() + "\nEdad: " + user.getAgeGroup());
    }
}