package br.pucrio.dslmetrics.core.rules;

import java.io.File;

import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlLineNumber;
import org.apache.xmlbeans.XmlObject;

public class XmlRepositoryException extends Exception {

	private static final long serialVersionUID = 4446224619741435528L;

	private final int line;
	private final int column;
	private final File file;

	public XmlRepositoryException(XmlError error, File file) {
		super(error.getMessage());
		line = error.getLine();
		column = error.getColumn();
		this.file = file;
	}
	
	public XmlRepositoryException(XmlException cause, File file) {
		super(cause.getError().getMessage(),cause);
		line = cause.getError().getLine();
		column = cause.getError().getColumn();
		
		this.file = file;
	}
	
	public XmlRepositoryException(String message, Exception cause, File file) {
		super(message,cause);
		line = -1;
		column = -1;
		
		this.file = file;
	}

	public XmlRepositoryException(String message, int line, int column,
			File file) {
		super(message);
		this.line = line;
		this.column = column;
		this.file = file;
	}

	public XmlRepositoryException(String message, XmlObject xmlObject, File file) {
		super(message);
		XmlLineNumber bookmark = (XmlLineNumber) xmlObject.newCursor()
				.getBookmark(XmlLineNumber.class);
		this.line = bookmark.getLine();
		this.column = bookmark.getColumn();
		this.file = file;

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

}
