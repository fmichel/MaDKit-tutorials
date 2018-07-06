/**
 * READ ME
 * 
 * This tutorial enlighten MaDKit properties : what is a property and how to use it.
 * As MaDKit is an Java API, you may already be familiar with Java Property.
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

/**
 * A Property is a distinctive feature that may be used for every MaDKit project.
 * Thus MaDKit configuration is stored in the madkit.kernel.madkit.properties file.
 *  
 * Now we will present you how to display default properties in MaDKit.
 * 
 * BALISES JWS ?
 */
public class _1_DisplayMadkitProperties {

	public static void main(String[] args) {

		/**
		 * Here we launch a new MaDKit with the option madkitLogLevel set to true. 
		 * This property allows all the logs concerning MaDKit to be displayed, these
		 * logs include MaDKit options.
		 */
		new Madkit(Madkit.LevelOption.madkitLogLevel.toString());
	}
}
