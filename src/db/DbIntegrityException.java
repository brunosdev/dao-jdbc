package db;

public class DbIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DbIntegrityException(String msg) { // exceção personalizada (Caso haja funcionários no departamento, não poderei deletá-lo devido à coesão referencial, um funcionário não pode ficar sem departamento.
		super(msg);
	}

}
