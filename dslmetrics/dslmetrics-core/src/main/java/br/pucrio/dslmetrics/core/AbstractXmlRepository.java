package br.pucrio.dslmetrics.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;

import br.pucrio.dslmetrics.core.rules.XmlRepositoryException;

public abstract class AbstractXmlRepository<T, U> {

	protected Map<String, U> identityMap = new HashMap<String, U>();
	protected File file;

	public AbstractXmlRepository(String filename) throws XmlRepositoryException {
		file = new File(filename);
	}

	protected T createDocument() throws XmlRepositoryException {
		Map<String, String> namespaces = new HashMap<String, String>();
		putNamespaces(namespaces);

		LinkedList<XmlError> errors = new LinkedList<XmlError>();
		XmlOptions options = new XmlOptions().setLoadLineNumbers()
				.setLoadSubstituteNamespaces(namespaces).setErrorListener(
						errors);

		T document;

		try {
			document = parseFile(options);
		} catch (XmlException e) {
			throw new XmlRepositoryException(e.getError(), file);
		} catch (FileNotFoundException e) {
			throw new XmlRepositoryException("File not found.", e, file);
		} catch (IOException e) {
			throw new XmlRepositoryException("Unexpected error reading file",
					e, file);
		}

		if (!validateDocument(document, options))
			throw new XmlRepositoryException(errors.getFirst(), file);

		return document;
	}

	protected abstract boolean validateDocument(T document, XmlOptions options);

	protected abstract void putNamespaces(Map<String, String> namespaces);

	protected abstract T parseFile(XmlOptions options) throws XmlException,
			IOException;

}
