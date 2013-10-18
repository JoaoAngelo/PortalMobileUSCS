package br.edu.uscs.portalmobile.adapter;

import java.util.ArrayList;

import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NotasArrayAdapter extends BaseAdapter {
	private final Context context;
	private final ArrayList<String[]> values;

	public NotasArrayAdapter(Context context, ArrayList<String[]> values) {
		super();
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.notas_item_layout, parent, false);

		// Adiciona nome da disciplina
		TextView txtDisciplina = (TextView) rowView.findViewById(R.notas.txtDisciplina);
		txtDisciplina.setText(values.get(position)[0]);

		// Adiciona nota aproveitamento
		TextView txtAproveitamento = (TextView) rowView.findViewById(R.notas.aproveitamentoNota);
		txtAproveitamento.setText(values.get(position)[1]);

		// Adiciona nota prova
		TextView txtProva = (TextView) rowView.findViewById(R.notas.provaNota);
		txtProva.setText(values.get(position)[2]);

		// Adiciona nota substutiva
		TextView txtSubstutiva = (TextView) rowView.findViewById(R.notas.substutivaNota);
		txtSubstutiva.setText(values.get(position)[3]);

		// Adiciona nota totalPontos
		TextView txtTotalPontos = (TextView) rowView.findViewById(R.notas.totalPontosNota);
		txtTotalPontos.setText(values.get(position)[4]);

		// Adiciona nota reavaliacao
		TextView txtReavaliacao = (TextView) rowView.findViewById(R.notas.reavaliacaoNota);
		txtReavaliacao.setText(values.get(position)[5]);

		// Adiciona nota mediaFinal
		TextView txtMediaFinal = (TextView) rowView.findViewById(R.notas.mediaFinalNota);
		txtMediaFinal.setText(values.get(position)[6]);

		// Adiciona nota resultadoFinal
		TextView txtResultadoFinal = (TextView) rowView.findViewById(R.notas.resultadoFinalNota);
		txtResultadoFinal.setText(values.get(position)[7]);

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