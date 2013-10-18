package br.edu.uscs.portalmobile.adapter;

import java.util.ArrayList;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class LinkArrayAdapter extends BaseAdapter {
	private final Context context;
	private final ArrayList<String[]> values;

	public LinkArrayAdapter(Context context, ArrayList<String[]> values) {
		super();
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.link_item_layout, parent, false);

		// Adiciona nome do estudante na lista
		TextView txtDescricao = (TextView) rowView.findViewById(R.link.txtDescricao);
		txtDescricao.setText(values.get(position)[0]);

		// Adiciona email do estudante na lista
		TextView txtURL = (TextView) rowView.findViewById(R.link.txtURL);
		txtURL.setText(values.get(position)[1]);
		rowView.setFocusableInTouchMode(true);
		rowView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(values.get(position)[1]));
				context.startActivity(i);

				Log.e("OnClick do Link mano", "ID: " + values.get(position)[0] + " Position: " + values.get(position)[1]);

			}
		});

		return rowView;
	}

	@Override
	public int getCount() {
		return values.size();
	}

	@Override
	public Object getItem(int position) {

		return values.get(position)[1];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

}