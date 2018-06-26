package anttask;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.apache.tools.ant.Task;
import org.apache.tools.ant.taskdefs.Copy;
import org.apache.tools.ant.types.FilterSet;

public class CreateJnlpFromJavaSource extends Task {

    private File jnlpDestinationDir;
    private String srcFile;
    private String srcDir;
    private File jnlpTemplate;

    @Override
    public void execute() {
	String javaWebStartFileName = null;
	String webStartArguments = null;

	try (Scanner s = new Scanner(new File(srcDir, srcFile))) {
	    s.useDelimiter("#jws#").next();
	    javaWebStartFileName = s.next().trim();
	    s.useDelimiter("#args#").next();
	    webStartArguments = s.next().trim();
	}
	catch(FileNotFoundException e) {
	    e.printStackTrace();
	}
	catch (NoSuchElementException e) {
	    return;
	}
	if (javaWebStartFileName.isEmpty() || webStartArguments.isEmpty())
	    return;

	String jnlpFileName = srcFile.substring(0, srcFile.length() - 4).replace('/', '.');
	jnlpFileName += "jnlp";
	System.err.println("created: " + jnlpFileName);

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

    /**
     * @param srcDir the srcDir to set
     */
    public void setSrcDir(String srcDir) {
	this.srcDir = srcDir;
    }

}
