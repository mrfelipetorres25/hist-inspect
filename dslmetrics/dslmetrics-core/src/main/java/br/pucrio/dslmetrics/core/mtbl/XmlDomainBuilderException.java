package br.pucrio.dslmetrics.core.mtbl;

import java.io.File;

import br.pucrio.dslmetrics.core.domain.ProjectBuilderException;

public class XmlDomainBuilderException extends ProjectBuilderException {

	private static final long serialVersionUID = -1531224192334634786L;
	
	private File file;
	private int column;
	private int line;

	public XmlDomainBuilderException() {
		super();
	}

	public XmlDomainBuilderException(String message, Throwable cause) {
		super(message, cause);
	}

	public XmlDomainBuilderException(String message) {
		super(message);
	}

	public XmlDomainBuilderException(Throwable cause) {
		super(cause);
	}

	public File getFile() {
		return file;
	}

	public int getColumn() {
		return column;
	}

	public int getLine() {
		return line;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public void setLine(int line) {
		this.line = line;
	}

}
