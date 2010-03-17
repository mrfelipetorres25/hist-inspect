package br.pucrio.dslmetrics.reports.precisionrecall;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

public abstract class Report {

	private String templateName = "delta";
	private String templatesDir = "templates";

	private VelocityEngine engine;
	private VelocityContext context;
	
	private File currentTemplateDir;
	private File outputDir;

	public Report() throws IOException,
			Exception {
		configure();
		updateCurrentTemplateDir();
		createVelocityStuff();
	}

	public void generateReport(File file) throws ResourceNotFoundException,
			ParseErrorException, ReportException, Exception {
		evaluate();
		writeReport(file);
	}

	private void copyTemplateDirectory(File source, File destination)
			throws IOException {
		String[] filesToCopy = source.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return new File(dir, name).isDirectory()
						|| !name.endsWith(".vm");
			}
		});
		for (String fileName : filesToCopy) {
			File file = new File(source, fileName);
			if (file.isDirectory()) {
				File newDestinationDir = new File(destination, fileName);
				newDestinationDir.mkdir();
				copyTemplateDirectory(file, newDestinationDir);
			} else
				copyFile(file, new File(destination, fileName));
		}
	}

	private void copyFile(File source, File dest) throws IOException {
		FileChannel inChannel = new FileInputStream(source).getChannel();
		FileChannel outChannel = new FileOutputStream(dest).getChannel();
		try {
			inChannel.transferTo(0, inChannel.size(), outChannel);
		} finally {
			if (inChannel != null)
				inChannel.close();

			if (outChannel != null)
				outChannel.close();
		}

	}

	private void writeReport(File outputDir) throws ResourceNotFoundException,
			ParseErrorException, Exception, IOException {

		this.outputDir = outputDir;

		outputDir.mkdir();

		processTemplates();

		URL resource = ClassLoader.getSystemResource(currentTemplateDir
				.getPath());
		if (resource != null)
			currentTemplateDir = new File(resource.getFile());

		copyTemplateDirectory(currentTemplateDir, outputDir);
	}

	private void updateCurrentTemplateDir() {
		currentTemplateDir = new File(new File(templatesDir), templateName);
	}

	protected void processTemplate(String in, String out) throws IOException, Exception {
		processTemplate(in, out, context);
	}
	
	protected void processTemplate(String in, String out, VelocityContext context) throws IOException,
			Exception {
		BufferedWriter writer = null;
		try {

			writer = new BufferedWriter(new FileWriter(new File(outputDir, out)));

			File currentTemplate = new File(currentTemplateDir, in);

			Template t = engine.getTemplate(currentTemplate.getPath(), "UTF-8");
			
			t.merge(context, writer);

		} finally {
			if (writer != null)
				writer.close();
		}
	}

	private void createVelocityStuff() throws IOException, Exception {
		Properties p = new Properties();
		p.load(Report.class.getClassLoader().getResourceAsStream(
				"velocity.properties"));

		engine = new VelocityEngine(p);

		context = new VelocityContext();
		context.put("report", this);
	}
	
	protected VelocityEngine getEngine() {
		return engine;
	}

	protected VelocityContext getContext() {
		return context;
	}
	
	public String getTemplatesDir() {
		return templatesDir;
	}

	public void setTemplatesDir(String templatesDir) {
		this.templatesDir = templatesDir;
		updateCurrentTemplateDir();
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
		updateCurrentTemplateDir();
	}

	protected void configure() {

	}

	protected abstract void processTemplates() throws IOException, Exception;

	protected abstract void evaluate() throws ReportException;
}
