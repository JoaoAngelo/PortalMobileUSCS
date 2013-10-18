package br.edu.uscs.portalmobile.libs;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class ValidaCampo {

	public static boolean validaData(View pView, String pFormato, String pMessagem) {
		if (pView instanceof EditText) {
			EditText edText = (EditText) pView;
			Editable text = edText.getText();
			if (text != null) {
				String strText = text.toString();
				if (!TextUtils.isEmpty(strText)) {
					SimpleDateFormat format = new SimpleDateFormat(pFormato);
					try {
						format.parse(strText);
						return true;
					} catch (ParseException pe) {

					}
				}
			}
			// em qualquer outra condição é gerado um erro
			edText.setError(pMessagem);
			edText.setFocusable(true);
			edText.requestFocus();
			return false;
		}
		return false;
	}

	public static boolean validaNulo(View pView, String pMessagem) {
		if (pView instanceof EditText) {
			EditText edText = (EditText) pView;
			Editable text = edText.getText();
			if (text != null) {
				String strText = text.toString();
				if (!TextUtils.isEmpty(strText)) {
					return true;
				}
			}
			// em qualquer outra condição é gerado um erro
			edText.setError(pMessagem);
			edText.setFocusable(true);
			edText.requestFocus();
			return false;
		}
		return false;
	}
}
