package br.edu.uscs.portalmobile.activitys;

/**
 * Created by Joao on 01/07/13.
 */

import java.util.ArrayList;

import android.R;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import br.edu.uscs.portalmobile.Estudante;
import br.edu.uscs.portalmobile.Pessoa;
import br.edu.uscs.portalmobile.TurmaEstudante;
import br.edu.uscs.portalmobile.adapter.TurmaArrayAdapter;
import br.edu.uscs.portalmobile.libs.ORMLiteHelper;

import com.actionbarsherlock.app.SherlockActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

public class TurmaActivity extends SherlockActivity {

	@Override
	public void onBackPressed() {
		this.finish();
		overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_layout);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		Log.i("faltas", "Carregar dados de faltas.");

		// Popular este array list com os dados do banco de dados
		ArrayList<String[]> values = new ArrayList<String[]>();

		RuntimeExceptionDao<TurmaEstudante, Integer> turmaEstudanteDao = ORMLiteHelper.getInstance(getApplicationContext()).getTurmaEstudanteRuntimeDao();
		RuntimeExceptionDao<Estudante, Integer> estudanteDao = ORMLiteHelper.getInstance(getApplicationContext()).getEstudanteRuntimeDao();
		RuntimeExceptionDao<Pessoa, Integer> pessoaDao = ORMLiteHelper.getInstance(getApplicationContext()).getPessoaRuntimeDao();

		for (TurmaEstudante turmaEstudante : turmaEstudanteDao.queryForAll()) {

			estudanteDao.refresh(turmaEstudante.getEstudante());
			pessoaDao.refresh(turmaEstudante.getEstudante().getPessoa());

			// Nome do estudante, email do estudante
			values.add(new String[] { turmaEstudante.getEstudante().getPessoa().getNomePessoa(), turmaEstudante.getEstudante().getPessoa().getEmail() });

		}

		ListView lstw = (ListView) findViewById(R.id.list_layout);

		TurmaArrayAdapter adapter = new TurmaArrayAdapter(this, values);

		lstw.setAdapter(adapter);

	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		System.out.println(item.getItemId());
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
