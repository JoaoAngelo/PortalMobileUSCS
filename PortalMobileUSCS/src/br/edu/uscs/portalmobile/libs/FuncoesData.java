package br.edu.uscs.portalmobile.libs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FuncoesData {

	public static String DateTOString(Date data) {
		String string = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		string = sdf.format(data);
		return string;
	}

	public static double DiferencaDias(Date dataMaior, Date dataMenor) {
		double diferenca = (dataMaior.getTime() - dataMenor.getTime());
		double dias = diferenca / 86400000;
		return dias;
	}

	public static String StringHoje() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String hoje = sdf.format(new Date());
		return hoje;
	}

	public static Date StringTODate(String string) {
		Date data = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {
			data = sdf.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return data;
	}

	public static int diaSemana() {
		return new GregorianCalendar().get(Calendar.DAY_OF_WEEK);
	}
}
