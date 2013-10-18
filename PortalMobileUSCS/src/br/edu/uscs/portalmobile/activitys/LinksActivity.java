package br.edu.uscs.portalmobile.activitys;

/**
 * Created by Joao on 01/07/13.
 */

import java.util.ArrayList;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import br.edu.uscs.portalmobile.Link;
import br.edu.uscs.portalmobile.R;
import br.edu.uscs.portalmobile.adapter.LinkArrayAdapter;
import br.edu.uscs.portalmobile.libs.ORMLiteHelper;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.j256.ormlite.dao.RuntimeExceptionDao;

public class LinksActivity extends SherlockActivity {

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

		Log.i("faltas", "Carregar dados de links.");

		// Popular este array list com os dados do banco de dados
		ArrayList<String[]> values = new ArrayList<String[]>();

		RuntimeExceptionDao<Link, Integer> linkDao = ORMLiteHelper.getInstance(getApplicationContext()).getLinkRuntimeDao();
		
		for (Link link : linkDao.queryForAll()) {

			// Nome do estudante, email do estudante
			values.add(new String[] { link.getDescricao_link(), link.getUrl() });

		}

		ListView lstw = (ListView) findViewById(R.id.list_layout);

		LinkArrayAdapter adapter = new LinkArrayAdapter(this, values);

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
