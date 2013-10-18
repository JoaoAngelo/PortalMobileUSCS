package br.edu.uscs.portalmobile.activitys;

import java.sql.SQLException;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import br.edu.uscs.portalmobile.Estudante;
import br.edu.uscs.portalmobile.R;
import br.edu.uscs.portalmobile.libs.ORMLiteHelper;
import br.edu.uscs.portalmobile.libs.UserFunctions;

import com.actionbarsherlock.app.SherlockActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

public class SplashScreen extends SherlockActivity {

	// Splash screen timer
	private static int SPLASH_TIME_OUT = 2000;

	Button btnLogar;

	@Override
	public void onBackPressed() {
		this.finish();
		overridePendingTransition(R.anim.fadein, R.anim.fadeout);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Se existe dados do último logon, irá carregar o id do estudante

		List<Estudante> estudante = null;
		try {
			RuntimeExceptionDao<Estudante, Integer> estudanteDao = ORMLiteHelper.getInstance(getApplicationContext()).getEstudanteRuntimeDao();

			QueryBuilder<Estudante, Integer> queryBuilder = estudanteDao.queryBuilder();

			PreparedQuery<Estudante> preparedQuery = null;
			// Adiciona condições na consulta
			queryBuilder.where().eq("sta_logado", "S");

			// prepara o sql para ser executado
			preparedQuery = queryBuilder.prepare();

			estudante = estudanteDao.query(preparedQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (!estudante.isEmpty()) {
			Log.i("identificacao_estudante", "Encontrou identificação do entudante.");
			UserFunctions.setIdentificacaoDoEstudante(estudante.get(0).getIdEstudante());
		}

		if (UserFunctions.estaLogado(SplashScreen.this)) {
			setContentView(R.layout.splashscreen_layout);

			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {

					Intent i = new Intent(SplashScreen.this, MenuActivity.class);
					startActivity(i);
					overridePendingTransition(R.anim.fadein, R.anim.fadeout);
					finish();
				}
			}, SPLASH_TIME_OUT);
		} else {
			setContentView(R.layout.splashscreen_logar_layout);

			btnLogar = (Button) findViewById(R.id.btnLogar);

			btnLogar.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					Intent i = new Intent(SplashScreen.this, LoginActivity.class);
					startActivity(i);
					overridePendingTransition(R.anim.fadein, R.anim.fadeout);
					finish();
				}
			});
		}

	}
}