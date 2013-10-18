package br.edu.uscs.portalmobile.activitys;

import java.util.Date;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import br.edu.uscs.portalmobile.Estudante;
import br.edu.uscs.portalmobile.R;
import br.edu.uscs.portalmobile.libs.FuncoesData;
import br.edu.uscs.portalmobile.libs.Mensagem;
import br.edu.uscs.portalmobile.libs.ORMLiteHelper;
import br.edu.uscs.portalmobile.libs.UserFunctions;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.j256.ormlite.dao.RuntimeExceptionDao;

public class MenuActivity extends SherlockActivity {

	// Quantidade de dias que os dados são considerados válidos.
	private static int DIAS_VALIDADE = 3;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Instância do DAO para estudante
		RuntimeExceptionDao<Estudante, Integer> estudanteDao = ORMLiteHelper.getInstance(getApplicationContext()).getEstudanteRuntimeDao();

		// Consulta estudante no banco de dados pelo id
		Estudante estudante = estudanteDao.queryForId(UserFunctions.getIdentificacaoDoEstudante());

		// Obtem diferença de dias entre data do ultimo acesso e a data de logon
		double diferenca = FuncoesData.DiferencaDias(new Date(), estudante.getDataAcesso());

		// Se dados ainda estão validos(menos de 3 dias), mostrar menu
		if (diferenca < DIAS_VALIDADE) {
			setContentView(R.layout.dashboard_layout);

			StringBuilder data_acesso = new StringBuilder("Último acesso online: ");

			data_acesso.append(FuncoesData.DateTOString(estudante.getDataAcesso()));

			/**
			 * Criando as instancias dos botoes
			 * */

			// Botao notas
			Button btn_notas = (Button) findViewById(R.id.btn_notas);

			// Botao faltas
			Button btn_faltas = (Button) findViewById(R.id.btn_faltas);

			// Botao grade
			Button btn_grade = (Button) findViewById(R.id.btn_grade);

			// Botao turma
			Button btn_turma = (Button) findViewById(R.id.btn_turma);

			// Botao professores
			Button btn_professores = (Button) findViewById(R.id.btn_professores);

			// Botao downloads
			Button btn_downloads = (Button) findViewById(R.id.btn_downloads);

			// Botoa links
			Button btn_links = (Button) findViewById(R.id.btn_links);

			// Botao sobre
			Button btn_sobre = (Button) findViewById(R.id.btn_sobre);

			TextView mensagemAlerta = (TextView) findViewById(R.id.mensagemAlerta);

			mensagemAlerta.setText(data_acesso.toString());

			/**
			 * Eventos de click dos botoes
			 * */

			// Listening to News Feed button click
			btn_notas.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View view) {
					// Launching News Feed Screen
					Intent i = new Intent(getApplicationContext(), NotasActivity.class);
					startActivity(i);
					overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
				}
			});

			// Listening Friends button click
			btn_faltas.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View view) {
					// Launching News Feed Screen
					Intent i = new Intent(getApplicationContext(), FaltasActivity.class);
					startActivity(i);
					overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
				}
			});

			// Listening to Photos button click
			btn_grade.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View view) {
					// Launching News Feed Screen
					Intent i = new Intent(getApplicationContext(), HorariosActivity.class);
					startActivity(i);
					overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
				}
			});

			// Listening Messages button click
			btn_turma.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View view) {
					// Launching News Feed Screen
					Intent i = new Intent(getApplicationContext(), TurmaActivity.class);
					startActivity(i);
					overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
				}
			});

			// Listening to Events button click
			btn_professores.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View view) {
					// Launching News Feed Screen
					Intent i = new Intent(getApplicationContext(), ProfessoresActivity.class);
					startActivity(i);
					overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
				}
			});

			// Listening to Places button click
			btn_downloads.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View view) {
					// Launching News Feed Screen
					Intent i = new Intent(getApplicationContext(), DownloadActivity.class);
					startActivity(i);
					overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
				}
			});

			// Listening to Events button click
			btn_links.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View view) {
					// Launching News Feed Screen
					Intent i = new Intent(getApplicationContext(), LinksActivity.class);
					startActivity(i);
					overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
				}
			});

			// Listening to Places button click
			btn_sobre.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View view) {

					Intent i = new Intent(getApplicationContext(), SobreActivity.class);
					startActivity(i);
					overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
				}
			});
		} else {

			/**
			 * Caso expirou dados de acesso, exibir tela de login novamente
			 */

			// mensagem expirou acesso
			Mensagem.expirou(MenuActivity.this, "Seu login expirou.", "Conecte-se novamente.");

			// Executa rotina para limpar todos os dados atuais, preparando
			// banco de dados para um novo logon
			UserFunctions.fazerLogout(getApplicationContext());
			Intent login = new Intent(getApplicationContext(), LoginActivity.class);
			login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(login);
			overridePendingTransition(R.anim.fadein, R.anim.fadeout);
			finish();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuInflater menuInflater = this.getSupportMenuInflater();
		menuInflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		System.out.println(item.getItemId());
		switch (item.getItemId()) {
		case R.id.action_logout:

			UserFunctions.fazerLogout(getApplicationContext());
			Intent login = new Intent(getApplicationContext(), LoginActivity.class);
			login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(login);

			finish();

			return true;
		case R.id.action_quit:
			System.exit(0);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onBackPressed() {
		Mensagem.saindo(MenuActivity.this, "Saindo...", "Deseja realmente sair?");
	}
}
