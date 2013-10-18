package br.edu.uscs.portalmobile.libs;

import android.R;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.Toast;

public class Mensagem {

	private static AlertDialog alerta;
	private static ProgressDialog progressDialog;

	public static void alerta(Context context, String titulo, String mensagem) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		if (titulo != null) {
			builder.setTitle(titulo);
		}
		if (mensagem != null) {
			builder.setMessage(mensagem);
		}
		builder.setIcon(R.drawable.alert);
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {

			}
		});
		alerta = builder.create();
		alerta.show();
	}

	public static void erro(Context context, String titulo, String mensagem) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		if (titulo != null) {
			builder.setTitle(titulo);
		}
		if (mensagem != null) {
			builder.setMessage(mensagem);
		}
		builder.setIcon(R.drawable.erro);
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {

			}
		});
		alerta = builder.create();
		alerta.show();
	}

	public static void expirou(Context context, String titulo, String mensagem) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		if (titulo != null) {
			builder.setTitle(titulo);
		}
		if (mensagem != null) {
			builder.setMessage(mensagem);
		}
		builder.setIcon(R.drawable.info);
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {

			}
		});
		alerta = builder.create();
		alerta.show();
	}

	public static void saindo(Context context, String titulo, String mensagem) {

		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		if (titulo != null) {
			builder.setTitle(titulo);
		}
		if (mensagem != null) {
			builder.setMessage(mensagem);
		}
		builder.setIcon(R.drawable.alert);

		builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				System.exit(0);
			}
		});

		builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {

			}
		});
		alerta = builder.create();
		alerta.show();
	}

	@SuppressWarnings("rawtypes")
	public static void conectando(final Context context, String titulo, String mensagem, final AsyncTask minhaTask, long segundos) {

		progressDialog = new ProgressDialog(context);
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progressDialog.setTitle(titulo);
		progressDialog.setMessage(mensagem);
		progressDialog.setIcon(R.drawable.alert);
		progressDialog.setCancelable(false);
		progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancelar", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int arg1) {
				if (progressDialog.isShowing()) {

					minhaTask.cancel(true);
					progressDialog.cancel();
					Mensagem.toastLong(context, "Login cancelado.");
				}
			}
		});
		progressDialog.setIndeterminate(true);
		progressDialog.setMax(100);
		progressDialog.setProgress(0);
		progressDialog.show();
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				if (progressDialog.isShowing()) {
					progressDialog.setMessage("Conexão com a internet lenta.");
				}
			}
		}, 10 * 1000);
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				if (progressDialog.isShowing()) {

					minhaTask.cancel(true);
					progressDialog.cancel();
					Mensagem.toastLong(context, "Não foi possível conectar ao servidor.");
				}
			}
		}, segundos * 1000);
	}

	public static void conectandoDismiss() {
		progressDialog.dismiss();
	}

	public static void toastLong(Context context, String mensagem) {
		Toast.makeText(context, mensagem, Toast.LENGTH_LONG).show();
	}
}
