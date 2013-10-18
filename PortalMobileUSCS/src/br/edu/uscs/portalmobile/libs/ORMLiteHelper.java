package br.edu.uscs.portalmobile.libs;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
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

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

/**
 * ORMLiteHelper usada para manipular a criação e atualização do banco de dados.
 * Esta classe provê acesso as DAOs que fornece acesso aos dados de nossa
 * entidades.
 */
public class ORMLiteHelper extends OrmLiteSqliteOpenHelper {

	// Nome do banco de dados
	private static final String DATABASE_NAME = "portal.db";

	// Versão do banco de dados.
	private static final int DATABASE_VERSION = 1;

	// Caso você queria ter apenas uma instancia da base de dados.
	private static ORMLiteHelper mInstance = null;

	// Declaração dos Objetos DAO ( usando RuntimeException não será necessário
	// implementar o blobo try/catch )
	private RuntimeExceptionDao<Estudante, Integer> estudanteRuntimeDao = null;
	private RuntimeExceptionDao<Pessoa, Integer> pessoaRuntimeDao = null;
	private RuntimeExceptionDao<Professor, Integer> professorRuntimeDao = null;
	private RuntimeExceptionDao<Turma, Integer> turmaRuntimeDao = null;
	private RuntimeExceptionDao<TurmaEstudante, Integer> turmaEstudanteRuntimeDao = null;
	private RuntimeExceptionDao<Aacc, Integer> aaccRuntimeDao = null;
	private RuntimeExceptionDao<Curso, Integer> cursoRuntimeDao = null;
	private RuntimeExceptionDao<Disciplina, Integer> disciplinaRuntimeDao = null;
	private RuntimeExceptionDao<CursoDisciplina, Integer> cursoDisciplinaRuntimeDao = null;
	private RuntimeExceptionDao<DisciplinaProfessor, Integer> disciplinaProfessorRuntimeDao = null;
	private RuntimeExceptionDao<Falta, Integer> faltaRuntimeDao = null;
	private RuntimeExceptionDao<GradeHoraria, Integer> gradeHorariaRuntimeDao = null;
	private RuntimeExceptionDao<Nota, Integer> notaRuntimeDao = null;
	private RuntimeExceptionDao<Link, Integer> linkRuntimeDao = null;
	private RuntimeExceptionDao<Download, Integer> downloadRuntimeDao = null;

	public ORMLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Método chamado quando banco de dados não existe.
	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		try {
			Log.i(ORMLiteHelper.class.getName(), "onCreate");

			// Cria tabelas no banco de dados.
			TableUtils.createTable(connectionSource, Turma.class);
			TableUtils.createTable(connectionSource, Pessoa.class);
			TableUtils.createTable(connectionSource, Estudante.class);
			TableUtils.createTable(connectionSource, Professor.class);
			TableUtils.createTable(connectionSource, TurmaEstudante.class);
			TableUtils.createTable(connectionSource, Aacc.class);
			TableUtils.createTable(connectionSource, Curso.class);
			TableUtils.createTable(connectionSource, Disciplina.class);
			TableUtils.createTable(connectionSource, CursoDisciplina.class);
			TableUtils.createTable(connectionSource, DisciplinaProfessor.class);
			TableUtils.createTable(connectionSource, Falta.class);
			TableUtils.createTable(connectionSource, GradeHoraria.class);
			TableUtils.createTable(connectionSource, Nota.class);
			TableUtils.createTable(connectionSource, Link.class);
			TableUtils.createTable(connectionSource, Download.class);

		} catch (SQLException e) {
			Log.e(ORMLiteHelper.class.getName(), "Erro: Não foi possivel criar o banco de dados.", e);
			throw new RuntimeException(e);
		}

	}

	// Método chamado quando a aplicação é atualizada e a versão do banco de
	// dados foi alterar.
	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
		try {
			Log.i(ORMLiteHelper.class.getName(), "onUpgrade");

			// Drop tabelas do banco de dados
			TableUtils.dropTable(connectionSource, Turma.class, true);
			TableUtils.dropTable(connectionSource, Estudante.class, true);
			TableUtils.dropTable(connectionSource, Pessoa.class, true);
			TableUtils.dropTable(connectionSource, Professor.class, true);
			TableUtils.dropTable(connectionSource, TurmaEstudante.class, true);
			TableUtils.dropTable(connectionSource, Aacc.class, true);
			TableUtils.dropTable(connectionSource, Curso.class, true);
			TableUtils.dropTable(connectionSource, Disciplina.class, true);
			TableUtils.dropTable(connectionSource, CursoDisciplina.class, true);
			TableUtils.dropTable(connectionSource, DisciplinaProfessor.class, true);
			TableUtils.dropTable(connectionSource, Falta.class, true);
			TableUtils.dropTable(connectionSource, GradeHoraria.class, true);
			TableUtils.dropTable(connectionSource, Nota.class, true);
			TableUtils.dropTable(connectionSource, Link.class, true);
			TableUtils.dropTable(connectionSource, Download.class, true);

			// Podemos chamar o método onCreate e criar o banco de dados com a
			// nova estrutura,
			// pois se a versão foi atualizada, significa que o desenvolvedor
			// atualizou o onCreate.
			// Não é obrigatório, é só uma das formas possiveis de atualização.
			onCreate(db, connectionSource);

		} catch (SQLException e) {
			Log.e(ORMLiteHelper.class.getName(), "Erro: Não foi possivel atualizar o banco de dados.", e);
			throw new RuntimeException(e);
		}
	}

	public static ORMLiteHelper getInstance(Context context) {
		if (mInstance == null) {
			mInstance = new ORMLiteHelper(context.getApplicationContext());
		}
		return mInstance;
	}

	// Retorna DAO (Database Access Object) para classe Estudante.
	public RuntimeExceptionDao<Estudante, Integer> getEstudanteRuntimeDao() {
		if (estudanteRuntimeDao == null) {
			estudanteRuntimeDao = getRuntimeExceptionDao(Estudante.class);
		}
		return estudanteRuntimeDao;
	}

	// Retorna DAO (Database Access Object) para classe Pessoa.
	public RuntimeExceptionDao<Pessoa, Integer> getPessoaRuntimeDao() {
		if (pessoaRuntimeDao == null) {
			pessoaRuntimeDao = getRuntimeExceptionDao(Pessoa.class);
		}
		return pessoaRuntimeDao;
	}

	// Retorna DAO (Database Access Object) para classe Professor.
	public RuntimeExceptionDao<Professor, Integer> getProfessorRuntimeDao() {
		if (professorRuntimeDao == null) {
			professorRuntimeDao = getRuntimeExceptionDao(Professor.class);
		}
		return professorRuntimeDao;
	}

	// Retorna DAO (Database Access Object) para classe Turma.
	public RuntimeExceptionDao<Turma, Integer> getTurmaRuntimeDao() {
		if (turmaRuntimeDao == null) {
			turmaRuntimeDao = getRuntimeExceptionDao(Turma.class);
		}
		return turmaRuntimeDao;
	}

	// Retorna DAO (Database Access Object) para classe TurmaEstudante.
	public RuntimeExceptionDao<TurmaEstudante, Integer> getTurmaEstudanteRuntimeDao() {
		if (turmaEstudanteRuntimeDao == null) {
			turmaEstudanteRuntimeDao = getRuntimeExceptionDao(TurmaEstudante.class);
		}
		return turmaEstudanteRuntimeDao;
	}

	// Retorna DAO (Database Access Object) para classe Aacc.
	public RuntimeExceptionDao<Aacc, Integer> getAaccRuntimeDao() {
		if (aaccRuntimeDao == null) {
			aaccRuntimeDao = getRuntimeExceptionDao(Aacc.class);
		}
		return aaccRuntimeDao;
	}

	// Retorna DAO (Database Access Object) para classe Curso.
	public RuntimeExceptionDao<Curso, Integer> getCursoRuntimeDao() {
		if (cursoRuntimeDao == null) {
			cursoRuntimeDao = getRuntimeExceptionDao(Curso.class);
		}
		return cursoRuntimeDao;
	}

	// Retorna DAO (Database Access Object) para classe Disciplina.
	public RuntimeExceptionDao<Disciplina, Integer> getDisciplinaRuntimeDao() {
		if (disciplinaRuntimeDao == null) {
			disciplinaRuntimeDao = getRuntimeExceptionDao(Disciplina.class);
		}
		return disciplinaRuntimeDao;
	}

	// Retorna DAO (Database Access Object) para classe CursoDisciplina.
	public RuntimeExceptionDao<CursoDisciplina, Integer> getCursoDisciplinaRuntimeDao() {
		if (cursoDisciplinaRuntimeDao == null) {
			cursoDisciplinaRuntimeDao = getRuntimeExceptionDao(CursoDisciplina.class);
		}
		return cursoDisciplinaRuntimeDao;
	}

	// Retorna DAO (Database Access Object) para classe DisciplinaProfessor.
	public RuntimeExceptionDao<DisciplinaProfessor, Integer> getDisciplinaProfessorRuntimeDao() {
		if (disciplinaProfessorRuntimeDao == null) {
			disciplinaProfessorRuntimeDao = getRuntimeExceptionDao(DisciplinaProfessor.class);
		}
		return disciplinaProfessorRuntimeDao;
	}

	// Retorna DAO (Database Access Object) para classe Falta.
	public RuntimeExceptionDao<Falta, Integer> getFaltaRuntimeDao() {
		if (faltaRuntimeDao == null) {
			faltaRuntimeDao = getRuntimeExceptionDao(Falta.class);
		}
		return faltaRuntimeDao;
	}

	// Retorna DAO (Database Access Object) para classe GradeHoraria.
	public RuntimeExceptionDao<GradeHoraria, Integer> getGradeHorariaRuntimeDao() {
		if (gradeHorariaRuntimeDao == null) {
			gradeHorariaRuntimeDao = getRuntimeExceptionDao(GradeHoraria.class);
		}
		return gradeHorariaRuntimeDao;
	}

	// Retorna DAO (Database Access Object) para classe Nota.
	public RuntimeExceptionDao<Nota, Integer> getNotaRuntimeDao() {
		if (notaRuntimeDao == null) {
			notaRuntimeDao = getRuntimeExceptionDao(Nota.class);
		}
		return notaRuntimeDao;
	}

	// Retorna DAO (Database Access Object) para classe Link.
	public RuntimeExceptionDao<Link, Integer> getLinkRuntimeDao() {
		if (linkRuntimeDao == null) {
			linkRuntimeDao = getRuntimeExceptionDao(Link.class);
		}
		return linkRuntimeDao;
	}

	// Retorna DAO (Database Access Object) para classe Download.
	public RuntimeExceptionDao<Download, Integer> getDownloadRuntimeDao() {
		if (downloadRuntimeDao == null) {
			downloadRuntimeDao = getRuntimeExceptionDao(Download.class);
		}
		return downloadRuntimeDao;
	}

	// Reseta tabelas( usado no logout ).
	public void resetTables() {

		// Limpa dados de todas tabelas no banco de dados
		try {
			TableUtils.clearTable(connectionSource, Turma.class);
			TableUtils.clearTable(connectionSource, Pessoa.class);
			TableUtils.clearTable(connectionSource, Estudante.class);
			TableUtils.clearTable(connectionSource, Professor.class);
			TableUtils.clearTable(connectionSource, TurmaEstudante.class);
			TableUtils.clearTable(connectionSource, Aacc.class);
			TableUtils.clearTable(connectionSource, Curso.class);
			TableUtils.clearTable(connectionSource, Disciplina.class);
			TableUtils.clearTable(connectionSource, CursoDisciplina.class);
			TableUtils.clearTable(connectionSource, DisciplinaProfessor.class);
			TableUtils.clearTable(connectionSource, Falta.class);
			TableUtils.clearTable(connectionSource, GradeHoraria.class);
			TableUtils.clearTable(connectionSource, Nota.class);
			TableUtils.clearTable(connectionSource, Link.class);
			TableUtils.clearTable(connectionSource, Download.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Limpa qualquer referencia/cache de DAOs (Database Access Object)
		estudanteRuntimeDao = null;
		pessoaRuntimeDao = null;
		professorRuntimeDao = null;
		turmaRuntimeDao = null;
		turmaEstudanteRuntimeDao = null;
		aaccRuntimeDao = null;
		cursoRuntimeDao = null;
		disciplinaRuntimeDao = null;
		cursoDisciplinaRuntimeDao = null;
		disciplinaProfessorRuntimeDao = null;
		faltaRuntimeDao = null;
		gradeHorariaRuntimeDao = null;
		notaRuntimeDao = null;
		linkRuntimeDao = null;
		downloadRuntimeDao = null;
	}

	// Fecha conexão com banco de dados e limpa qualquer cache DAOs.
	@Override
	public void close() {
		super.close();
		estudanteRuntimeDao = null;
		pessoaRuntimeDao = null;
		professorRuntimeDao = null;
		turmaRuntimeDao = null;
		turmaEstudanteRuntimeDao = null;
		aaccRuntimeDao = null;
		cursoRuntimeDao = null;
		disciplinaRuntimeDao = null;
		cursoDisciplinaRuntimeDao = null;
		disciplinaProfessorRuntimeDao = null;
		faltaRuntimeDao = null;
		gradeHorariaRuntimeDao = null;
		notaRuntimeDao = null;
		linkRuntimeDao = null;
		downloadRuntimeDao = null;
	}
}