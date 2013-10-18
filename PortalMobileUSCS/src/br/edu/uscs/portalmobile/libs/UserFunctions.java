package br.edu.uscs.portalmobile.libs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;
import br.edu.uscs.portalmobile.Aacc;
import br.edu.uscs.portalmobile.Curso;
import br.edu.uscs.portalmobile.CursoDisciplina;
import br.edu.uscs.portalmobile.Disciplina;
import br.edu.uscs.portalmobile.DisciplinaProfessor;
import br.edu.uscs.portalmobile.Download;
import br.edu.uscs.portalmobile.Estudante;
import br.edu.uscs.portalmobile.Falta;
import br.edu.uscs.portalmobile.GradeHoraria;
import br.edu.uscs.portalmobile.Link;
import br.edu.uscs.portalmobile.Nota;
import br.edu.uscs.portalmobile.Pessoa;
import br.edu.uscs.portalmobile.Professor;
import br.edu.uscs.portalmobile.Turma;
import br.edu.uscs.portalmobile.TurmaEstudante;

import com.j256.ormlite.dao.RuntimeExceptionDao;

public class UserFunctions {

	private static String userError = "";

	private static JSONObject json_aacc; // ok
	private static JSONObject json_curso; // ok
	private static JSONArray json_curso_disciplina; // ok
	private static JSONArray json_disciplina; // ok
	private static JSONArray json_disciplina_professor; // ok
	private static JSONArray json_estudante; // ok
	private static JSONArray json_falta; // ok
	private static JSONArray json_grade_horaria; // ok
	/*
	 * Não é necessário importar esta tabela, pois os dados da grade horária do
	 * estudante já vem filtrada. private static JSONArray
	 * json_grade_horaria_estudante;
	 */
	private static JSONArray json_nota; // ok
	private static JSONArray json_pessoa; // ok
	private static JSONArray json_professor; // ok
	private static JSONObject json_turma; // ok
	private static JSONArray json_turma_estudante; // ok
	private static JSONArray json_link; // ok
	private static JSONArray json_download; // ok

	// id_estudante no banco de dados, para efetuar consultas no banco de dados.
	private static int identificacaoDoEstudante;

	// Get identificacaoDoEstudante
	public static int getIdentificacaoDoEstudante() {
		return identificacaoDoEstudante;
	}

	// Set identificacaoDoEstudante
	public static void setIdentificacaoDoEstudante(int pIdentificacaoDoEstudante) {
		identificacaoDoEstudante = pIdentificacaoDoEstudante;
	}

	// constructor
	public UserFunctions() {

	}

	public static String getUserError() {
		return userError;
	}

	// Método para verificar se estudante está logado na aplicação. Usado quando
	// estudante reabre a aplicação.
	public static boolean estaLogado(Context context) {

		// Instância do DAO para estudante
		RuntimeExceptionDao<Estudante, Integer> estudanteDao = ORMLiteHelper.getInstance(context).getEstudanteRuntimeDao();

		// Consulta se existe dados do estudante no banco de dados
		if (estudanteDao.idExists(UserFunctions.getIdentificacaoDoEstudante())) {
			return true;
		}
		return false;
	}

	// Método para efetuar logon o estudante
	public static void fazerLogon(Context context, JSONObject json) {

		String nomePessoaLogada = "";
		String error = "";
		try {

			Log.i("insere_json", "Começando a Inserir dados json nas tabelas.");

			RuntimeExceptionDao<Estudante, Integer> estudanteRuntimeDao = ORMLiteHelper.getInstance(context).getEstudanteRuntimeDao();
			RuntimeExceptionDao<Pessoa, Integer> pessoaRuntimeDao = ORMLiteHelper.getInstance(context).getPessoaRuntimeDao();
			RuntimeExceptionDao<Professor, Integer> professorRuntimeDao = ORMLiteHelper.getInstance(context).getProfessorRuntimeDao();
			RuntimeExceptionDao<Turma, Integer> turmaRuntimeDao = ORMLiteHelper.getInstance(context).getTurmaRuntimeDao();
			RuntimeExceptionDao<TurmaEstudante, Integer> turmaEstudanteRuntimeDao = ORMLiteHelper.getInstance(context).getTurmaEstudanteRuntimeDao();
			RuntimeExceptionDao<Aacc, Integer> aaccRuntimeDao = ORMLiteHelper.getInstance(context).getAaccRuntimeDao();
			RuntimeExceptionDao<Curso, Integer> cursoRuntimeDao = ORMLiteHelper.getInstance(context).getCursoRuntimeDao();
			RuntimeExceptionDao<Disciplina, Integer> disciplinaRuntimeDao = ORMLiteHelper.getInstance(context).getDisciplinaRuntimeDao();
			RuntimeExceptionDao<CursoDisciplina, Integer> cursoDisciplinaRuntimeDao = ORMLiteHelper.getInstance(context).getCursoDisciplinaRuntimeDao();
			RuntimeExceptionDao<DisciplinaProfessor, Integer> disciplinaProfessorRuntimeDao = ORMLiteHelper.getInstance(context).getDisciplinaProfessorRuntimeDao();
			RuntimeExceptionDao<Falta, Integer> faltaRuntimeDao = ORMLiteHelper.getInstance(context).getFaltaRuntimeDao();
			RuntimeExceptionDao<GradeHoraria, Integer> gradeHorariaRuntimeDao = ORMLiteHelper.getInstance(context).getGradeHorariaRuntimeDao();
			RuntimeExceptionDao<Nota, Integer> notaRuntimeDao = ORMLiteHelper.getInstance(context).getNotaRuntimeDao();
			RuntimeExceptionDao<Link, Integer> linkRuntimeDao = ORMLiteHelper.getInstance(context).getLinkRuntimeDao();
			RuntimeExceptionDao<Download, Integer> downloadRuntimeDao = ORMLiteHelper.getInstance(context).getDownloadRuntimeDao();

			json_turma = json.getJSONObject("turma");
			json_pessoa = json.getJSONArray("pessoa");
			json_estudante = json.getJSONArray("estudante");
			json_professor = json.getJSONArray("professor");
			json_turma_estudante = json.getJSONArray("turma_estudante");
			json_aacc = json.getJSONObject("aacc");
			json_curso = json.getJSONObject("curso");
			json_disciplina = json.getJSONArray("disciplina");
			json_curso_disciplina = json.getJSONArray("curso_disciplina");
			json_disciplina_professor = json.getJSONArray("disciplina_professor");
			json_falta = json.getJSONArray("falta");
			json_grade_horaria = json.getJSONArray("grade_horaria");
			json_nota = json.getJSONArray("nota");
			json_link = json.getJSONArray("link");
			json_download = json.getJSONArray("download");

			Pessoa pessoa;
			Professor professor;
			Estudante estudante;
			Turma turma;
			TurmaEstudante turma_estudante;
			Aacc aacc;
			Curso curso;
			Disciplina disciplina;
			CursoDisciplina curso_disciplina;
			DisciplinaProfessor disciplina_professor;
			Falta falta;
			GradeHoraria gradeHoraria;
			Nota nota;
			Link link;
			Download download;

			// Importando curso.......
			// Cria instância à ser inserida no banco de dados pela DAO
			curso = new Curso(json_curso.getInt("id_curso"), json_curso.getString("nome_curso"));
			// Insere no banco de dados
			cursoRuntimeDao.create(curso);

			// Importando turma.......
			// Cria instância à ser inserida no banco de dados pela DAO
			turma = new Turma(json_turma.getInt("id_turma"), json_turma.getString("codigo_turma"), json_turma.getInt("numero_sala"));
			// Insere no banco de dados
			turmaRuntimeDao.create(turma);

			// Importando pessoas.......
			for (int i = 0; i < json_pessoa.length(); i++) {

				// Cria instância à ser inserida no banco de dados pela DAO
				pessoa = new Pessoa(json_pessoa.getJSONObject(i).getInt("id_pessoa"), json_pessoa.getJSONObject(i).getString("nome_pessoa"), json_pessoa.getJSONObject(i).getString("email"));

				// Insere no banco de dados
				pessoaRuntimeDao.create(pessoa);

			}

			// Importando estudante.....
			for (int es = 0; es < json_estudante.length(); es++) {

				pessoa = pessoaRuntimeDao.queryForId(json_estudante.getJSONObject(es).getInt("id_pessoa"));

				// Identificação do estudante logado
				if (json_estudante.getJSONObject(es).getString("sta_logado").equals("S")) {
					UserFunctions.identificacaoDoEstudante = json_estudante.getJSONObject(es).getInt("id_estudante");
					nomePessoaLogada = pessoa.getNomePessoa();
				}

				// Cria instância à ser inserida no banco de dados pela DAO
				estudante = new Estudante(json_estudante.getJSONObject(es).getInt("id_estudante"), pessoa, json_estudante.getJSONObject(es).getString("sta_logado"));

				// Insere no banco de dados
				estudanteRuntimeDao.create(estudante);

			}

			// Importar turma x estudante
			for (int te = 0; te < json_turma_estudante.length(); te++) {

				estudante = estudanteRuntimeDao.queryForId(json_turma_estudante.getJSONObject(te).getInt("id_estudante"));

				// Cria instância à ser inserida no banco de dados pela DAO
				turma_estudante = new TurmaEstudante(json_turma_estudante.getJSONObject(te).getInt("id_turma_estudante"), turma, estudante);

				// Insere no banco de dados
				turmaEstudanteRuntimeDao.create(turma_estudante);

			}

			// Importando aacc.......
			estudante = estudanteRuntimeDao.queryForId(json_aacc.getInt("id_estudante"));

			// Cria instância à ser inserida no banco de dados pela DAO
			aacc = new Aacc(json_aacc.getInt("id_aacc"), estudante, json_aacc.getInt("qtd_horas"));

			// Insere no banco de dados
			aaccRuntimeDao.create(aacc);

			// Importando professor.......
			for (int j = 0; j < json_professor.length(); j++) {

				pessoa = pessoaRuntimeDao.queryForId(json_professor.getJSONObject(j).getInt("id_pessoa"));

				// Cria instância à ser inserida no banco de dados pela DAO
				professor = new Professor(json_professor.getJSONObject(j).getInt("id_professor"), pessoa);

				// Insere no banco de dados
				professorRuntimeDao.create(professor);

			}

			// Importando disciplinas.......
			for (int i = 0; i < json_disciplina.length(); i++) {

				// Cria instância à ser inserida no banco de dados pela DAO
				disciplina = new Disciplina(json_disciplina.getJSONObject(i).getInt("id_disciplina"), json_disciplina.getJSONObject(i).getString("nome_disciplina"), json_disciplina.getJSONObject(i).getString("sta_presencial"));
				// Insere no banco de dados
				disciplinaRuntimeDao.create(disciplina);

			}

			// Importar curso x disciplina
			for (int d = 0; d < json_curso_disciplina.length(); d++) {

				disciplina = disciplinaRuntimeDao.queryForId(json_disciplina_professor.getJSONObject(d).getInt("id_disciplina"));

				// Cria instância à ser inserida no banco de dados pela DAO
				curso_disciplina = new CursoDisciplina(json_curso_disciplina.getJSONObject(d).getInt("id_curso_disciplina"), curso, disciplina);
				// Insere no banco de dados
				cursoDisciplinaRuntimeDao.create(curso_disciplina);

			}

			// Importar disciplina x professor
			for (int d = 0; d < json_disciplina_professor.length(); d++) {

				professor = professorRuntimeDao.queryForId(json_disciplina_professor.getJSONObject(d).getInt("id_professor"));
				disciplina = disciplinaRuntimeDao.queryForId(json_disciplina_professor.getJSONObject(d).getInt("id_disciplina"));

				// Cria instância à ser inserida no banco de dados pela DAO
				disciplina_professor = new DisciplinaProfessor(json_disciplina_professor.getJSONObject(d).getInt("id_disciplina_professor"), disciplina, professor);
				// Insere no banco de dados
				disciplinaProfessorRuntimeDao.create(disciplina_professor);

			}

			// Importar faltas
			for (int d = 0; d < json_falta.length(); d++) {

				disciplina_professor = disciplinaProfessorRuntimeDao.queryForId(json_falta.getJSONObject(d).getInt("id_disciplina_professor"));
				estudante = estudanteRuntimeDao.queryForId(json_falta.getJSONObject(d).getInt("id_estudante"));

				// Cria instância à ser inserida no banco de dados pela DAO
				falta = new Falta(json_falta.getJSONObject(d).getInt("id_falta"), disciplina_professor, estudante, json_falta.getJSONObject(d).getInt("qtd_faltas"), json_falta.getJSONObject(d).getInt("limite_faltas"));
				// Insere no banco de dados
				faltaRuntimeDao.create(falta);

			}

			// Importar grade horaria
			for (int d = 0; d < json_grade_horaria.length(); d++) {

				disciplina_professor = disciplinaProfessorRuntimeDao.queryForId(json_grade_horaria.getJSONObject(d).getInt("id_disciplina_professor"));

				// Cria instância à ser inserida no banco de dados pela DAO
				gradeHoraria = new GradeHoraria(json_grade_horaria.getJSONObject(d).getInt("id_grade_horaria"), disciplina_professor, json_grade_horaria.getJSONObject(d).getInt("dia_semana"), json_grade_horaria.getJSONObject(d).getString("hora_inicio"), json_grade_horaria.getJSONObject(d).getString("hora_fim"));
				// Insere no banco de dados
				gradeHorariaRuntimeDao.create(gradeHoraria);

			}

			// Importar notas
			for (int d = 0; d < json_nota.length(); d++) {

				curso_disciplina = cursoDisciplinaRuntimeDao.queryForId(json_nota.getJSONObject(d).getInt("id_curso_disciplina"));
				estudante = estudanteRuntimeDao.queryForId(json_nota.getJSONObject(d).getInt("id_estudante"));

				// Cria instância à ser inserida no banco de dados pela DAO
				nota = new Nota(json_nota.getJSONObject(d).getInt("id_nota"), curso_disciplina, estudante, json_nota.getJSONObject(d).getDouble("aproveitamento"), json_nota.getJSONObject(d).getDouble("prova"), json_nota.getJSONObject(d).getDouble("substitutiva"), json_nota.getJSONObject(d).getDouble("total_pontos"), json_nota.getJSONObject(d).getDouble("reavaliacao"), json_nota.getJSONObject(d).getDouble("media_final"), json_nota.getJSONObject(d).getString("resultado_final"));
				// Insere no banco de dados
				notaRuntimeDao.create(nota);

			}

			// Importar link
			for (int d = 0; d < json_link.length(); d++) {

				// Cria instância à ser inserida no banco de dados pela DAO
				link = new Link(json_link.getJSONObject(d).getInt("id_link"), json_link.getJSONObject(d).getString("descricao_link"), json_link.getJSONObject(d).getString("url"));
				// Insere no banco de dados
				linkRuntimeDao.create(link);

			}

			// Importar download
			for (int d = 0; d < json_download.length(); d++) {

				disciplina_professor = disciplinaProfessorRuntimeDao.queryForId(json_download.getJSONObject(d).getInt("id_disciplina_professor"));
				
				// Cria instância à ser inserida no banco de dados pela DAO
				download = new Download(
							json_download.getJSONObject(d).getInt("id_download"),
							disciplina_professor,
							json_download.getJSONObject(d).getString("descricao_download"),
							json_download.getJSONObject(d).getString("url"),
							json_download.getJSONObject(d).getString("data_insercao")							
							);
				// Insere no banco de dados
				downloadRuntimeDao.create(download);

			}
			Log.i("insere_json", "Dados importados, Usuario logado com sucesso.");

			// Exibe mensagem de Bem vindo ao estudante.
			Mensagem.toastLong(context, "Bem vindo(a), " + nomePessoaLogada + ".");

		} catch (JSONException e) {
			error = "JSONException - Erro 007 " + e.toString();
		}
		Log.e("error", error);
		userError = error;
	}

	// Método para efetuar logout(Apagar todos os dados do estudante na
	// aplicação).
	public static boolean fazerLogout(Context context) {
		ORMLiteHelper.getInstance(context).resetTables();
		return true;
	}

}
