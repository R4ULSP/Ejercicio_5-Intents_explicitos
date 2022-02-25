package es.travelworld.ejercicio5_intentsexplicitos;

import static es.travelworld.ejercicio5_intentsexplicitos.tools.References.KEY_USER;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import es.travelworld.ejercicio5_intentsexplicitos.databinding.ActivityLoginBinding;
import es.travelworld.ejercicio5_intentsexplicitos.tools.User;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityLoginBinding binding;
    private User user;
    private final ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result ->{
        if(result.getResultCode() == Activity.RESULT_OK){
            if(result.getData() != null){
                user = (User)result.getData().getSerializableExtra(KEY_USER);
                binding.loginButton.setEnabled(true);
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setListeners();
        user = new User();
    }

    private void setListeners() {
        binding.loginForgotPasswordButton.setOnClickListener(this);
        binding.loginNewAccountButton.setOnClickListener(this);
        binding.loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (binding.loginForgotPasswordButton.equals(view)) {
            Snackbar.make(binding.getRoot(), R.string.wip_feature, Snackbar.LENGTH_LONG).show();
        }
        else if (binding.loginNewAccountButton.equals(view)){
            Intent intent = new Intent(this,RegisterActivity.class);
            intent.putExtra(KEY_USER, user);
            activityResultLauncher.launch(intent);
        }
        else if (binding.loginButton.equals(view)){
            checkLoginData();
        }
    }

    private void checkLoginData() {
        if(binding.loginPassword.getText().toString().equals(user.getPassword()) && binding.loginUser.getText().toString().equals(user.getName())){
            Intent intent = new Intent(this,HomeActivity.class);
            intent.putExtra(KEY_USER, user);
            startActivity(intent);
        }
        else{
            Snackbar.make(binding.getRoot(), R.string.login_error, Snackbar.LENGTH_LONG).show();
        }
    }
}