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
    //TODO Configurar actionbar: poner navigationIcon
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        user = (User)getIntent().getSerializableExtra(KEY_USER);

        setActionBarSettings();

        Log.i("---Datos usuario","Nombre: " + user.getName() + "\nApellidos: " + user.getLastname() + "\nEdad:" + user.getAgeGroup());
    }

    private void setActionBarSettings() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.home_title));
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);
    }
}