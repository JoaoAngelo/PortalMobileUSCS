package br.edu.uscs.portalmobile.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.edu.uscs.portalmobile.R;

public class DownloadArrayAdapter extends BaseAdapter {
	private final Context context;
	private final ArrayList<String[]> values;

	public DownloadArrayAdapter(Context context, ArrayList<String[]> values) {
		super();
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.download_item_layout, parent, false);

		// Adiciona Descrição do download.
		TextView txtDescricao = (TextView) rowView.findViewById(R.download.txtDescricao);
		txtDescricao.setText(values.get(position)[0]);

		// Adiciona data do Download
		TextView txtData = (TextView) rowView.findViewById(R.download.txtData);
		txtData.setText(values.get(position)[1]);

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