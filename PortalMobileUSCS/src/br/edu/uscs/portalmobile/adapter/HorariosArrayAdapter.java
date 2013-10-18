package br.edu.uscs.portalmobile.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.edu.uscs.portalmobile.R;

public class HorariosArrayAdapter extends BaseAdapter {
	private final Context context;
	private final ArrayList<String[]> values;

	public HorariosArrayAdapter(Context context, ArrayList<String[]> values) {
		super();
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.horarios_item_layout, parent, false);

		TextView txtHrDisciplina = (TextView) rowView.findViewById(R.id.txtHrDisciplina);
		txtHrDisciplina.setText(values.get(position)[0]);

		TextView txtProfessor = (TextView) rowView.findViewById(R.id.txtHrProfessor);
		txtProfessor.setText(values.get(position)[1]);

		TextView txtHrInicio = (TextView) rowView.findViewById(R.id.txtHrInicio);
		txtHrInicio.setText(values.get(position)[2]);

		TextView txtHrFim = (TextView) rowView.findViewById(R.id.txtHrFim);
		txtHrFim.setText(values.get(position)[3]);

		return rowView;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return values.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
}