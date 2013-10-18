package br.edu.uscs.portalmobile.activitys;

import java.util.ArrayList;

import android.R;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import br.edu.uscs.portalmobile.Disciplina;
import br.edu.uscs.portalmobile.DisciplinaProfessor;
import br.edu.uscs.portalmobile.Falta;
import br.edu.uscs.portalmobile.adapter.FaltasArrayAdapter;
import br.edu.uscs.portalmobile.libs.ORMLiteHelper;

import com.actionbarsherlock.app.SherlockActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

public class FaltasActivity extends SherlockActivity {

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

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_layout);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		Log.i("faltas", "Carregar dados de faltas.");

		// Popular este array list com os dados do banco de dados
		ArrayList<String[]> values = new ArrayList<String[]>();

		RuntimeExceptionDao<Falta, Integer> faltaDao = ORMLiteHelper.getInstance(getApplicationContext()).getFaltaRuntimeDao();
		RuntimeExceptionDao<Disciplina, Integer> disciplinaDao = ORMLiteHelper.getInstance(getApplicationContext()).getDisciplinaRuntimeDao();
		RuntimeExceptionDao<DisciplinaProfessor, Integer> disciplinaProfessorDao = ORMLiteHelper.getInstance(getApplicationContext()).getDisciplinaProfessorRuntimeDao();

		for (Falta falta : faltaDao.queryForAll()) {

			disciplinaProfessorDao.refresh(falta.getDisciplinaProfessor());
			disciplinaDao.refresh(falta.getDisciplinaProfessor().getDisciplina());

			// Nome da Disciplina, Faltas, Limite de Faltas
			values.add(new String[] { falta.getDisciplinaProfessor().getDisciplina().getNomeDisciplina(), Integer.toString(falta.getQtdFaltas()), Integer.toString(falta.getLimiteFaltas()) });

		}
		Log.i("faltas", "Dados de faltas carregados com sucesso.");

		ListView lstw = (ListView) findViewById(R.id.list_layout);

		FaltasArrayAdapter adapter = new FaltasArrayAdapter(this, values);

		lstw.setAdapter(adapter);

	}

	@Override
	public void onBackPressed() {
		this.finish();
		overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
	}
}
