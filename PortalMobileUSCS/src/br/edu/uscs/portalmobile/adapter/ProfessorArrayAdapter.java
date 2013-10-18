package br.edu.uscs.portalmobile.adapter;

import java.util.ArrayList;

import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ProfessorArrayAdapter extends BaseAdapter {
	private final Context context;
	private final ArrayList<String[]> values;

	public ProfessorArrayAdapter(Context context, ArrayList<String[]> values) {
		super();
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.professor_item_layout, parent, false);

		// Adiciona nome do professor na lista
		TextView txtDisciplina = (TextView) rowView.findViewById(R.professor.txtProfessor);
		txtDisciplina.setText(values.get(position)[0]);

		// Adiciona materia do professor na lista
		TextView txtFaltas = (TextView) rowView.findViewById(R.professor.txtMateria);
		txtFaltas.setText(values.get(position)[1]);

		return rowView;
	}

	@Override
	public int getCount() {
		return values.size();
	}

	@Override
	public Object getItem(int arg0) {
		return 0;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}
}