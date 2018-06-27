package anttask;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.taskdefs.Copy;
import org.apache.tools.ant.types.FilterSet;

public class CreateJnlpFromJavaSource extends Task {

    private File jnlpDestinationDir;
    private String srcFile;
    private File jnlpTemplate;

    /* 
     * #jws# alone is just for creating a button in the html file
     * 
     * #jws# + #args# is about creating a corresponding jnlp file
     * 
     * @see org.apache.tools.ant.Task#execute()
     */
    @Override
    public void execute() {
	String javaWebStartFileName = null;
	String webStartArguments = null;

	String srcRoot = getProject().getProperty("src.dir");
	String tutoDir = getProject().getProperty("tuto.src.dir");
	Path tutoSrcFile = Paths.get(tutoDir, srcFile);
	Path tutoFilePath = Paths.get(srcRoot, tutoDir, srcFile);

	try (Scanner s = new Scanner(tutoFilePath)) {
	    try {
		s.useDelimiter("#jws#").next();
		javaWebStartFileName = s.next().trim()+".jnlp";
	    }
	    catch(NoSuchElementException e) {
		return; //no jnlp config at all
	    }
	    try {
		s.useDelimiter("#args#").next();
		webStartArguments = s.next().trim();
	    }
	    catch(NoSuchElementException e) {
		return;//not a config for creating a jnlp
	    }
	}
	catch(IOException e) {
	    log(e,Level.SEVERE.intValue());
	}
	if (javaWebStartFileName == null || javaWebStartFileName.isEmpty() || webStartArguments == null || webStartArguments.isEmpty()) {
	    throw new BuildException(tutoFilePath.toString()+" does not contain a valid jnlp config !");
	}

	log("creating " + javaWebStartFileName);

	Copy copyTask = new Copy();
	copyTask.setProject(getProject());
	copyTask.setFile(jnlpTemplate);
	copyTask.setTofile(new File(jnlpDestinationDir, javaWebStartFileName));
	FilterSet filters = copyTask.createFilterSet();
	filters.addFilter("#jnlp.file.name#", javaWebStartFileName);
	filters.addFilter("#jnlp.arguments#", webStartArguments);
	copyTask.setOverwrite(true);
	copyTask.execute();
    }

    public void setSrcFile(String javaSrcFile) {
	srcFile = javaSrcFile;
    }

    public void setJnlpTemplate(final File template) {
	this.jnlpTemplate = template;
    }

    /**
     * @param jnlpDestinationDir
     *            the jnlpDestinationDir to set
     */
    public void setDestDir(File jnlpDestinationDir) {
	this.jnlpDestinationDir = jnlpDestinationDir;
    }

}
