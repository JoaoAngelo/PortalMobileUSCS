package br.edu.uscs.portalmobile.activitys;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import br.edu.uscs.portalmobile.R;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

/**
 * Created by Joao on 02/07/13.
 */
public class SobreActivity extends SherlockActivity {

	@Override
	public void onBackPressed() {
		this.finish();
		overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exemplo_layout);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
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
