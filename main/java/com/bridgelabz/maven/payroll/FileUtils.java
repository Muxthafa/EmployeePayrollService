package com.bridgelabz.maven.payroll;

import java.io.File;

/**
 * FileUtils class to delete files recursively
 * @author mohammad.musthafa_ym
 *
 */
public class FileUtils {
	
	public static boolean deleteFiles(File contentsToDelete) {
		File[] allContents = contentsToDelete.listFiles();
		if(allContents != null) {
			for(File file : allContents) {
				deleteFiles(file);
			}
		}
		return contentsToDelete.delete();
	}
}
