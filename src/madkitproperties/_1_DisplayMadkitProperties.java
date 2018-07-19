/**
 * READ ME
 * 
 * This tutorial enlighten MaDKit properties : what is a property and how to use it.
 * As MaDKit is a Java API, you may already be familiar with Java Property.
 * If you are not and you want to get used to it before starting this tutorial, you may
 * have a look here in the official documentation or with the following tutorial.
 * 
 * Documentation : https://docs.oracle.com/javase/7/docs/api/java/util/Properties.html
 * Tutorial : https://docs.oracle.com/javase/tutorial/essential/environment/properties.html
 * 
 * The following exercises introduce how to have a look at the different properties owned by
 * MaDKit how to add or modify them and finally, how to store them. 
 * 
 * This tutorial is strongly linked with the MaDKit Options tutorial. Indeed, if this
 * tutorial presents globally the use of properties, in the Options one, we have a focus on
 * each of the default properties that are part of MaDKit configuration.
 */

package madkitproperties;

import madkit.kernel.Madkit;
import madkit.kernel.Madkit.LevelOption;

/**
 * A Property is a distinctive feature that may be used for every MaDKit project.
 * MaDKit has a configuration which is stored in its internal properties file.
 *  
 * We here present how to display the properties of a MaDKit run at startup.
 * 
 * #jws# madkitproperties._1_DisplayMadkitProperties #jws#
 * #args# #args#
 */
public class _1_DisplayMadkitProperties {

	public static void main(String[] args) {

		/**
		 * Here we launch a new MaDKit with the option madkitLogLevel activated. 
		 * This property allows all the logs concerning MaDKit to be displayed, these
		 * logs include MaDKit options. Logs can be seen in the console.
		 */
		new Madkit(
			LevelOption.madkitLogLevel.toString(),"FINER");
	}
}
