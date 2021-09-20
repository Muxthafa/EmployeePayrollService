package com.bridgelabz.maven.payroll;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class NIOFileAPITest
 * @author Mohammad Musthafa
 */
public class NIOFileAPITest 
{
    private static String HOME = System.getProperty("user.home");
    private static String PLAY_WITH_NIO = "TempPlayGround";
    @Test
    public void givenPathWhenCheckedThenConfirm() throws IOException {
    	//check File exists
    	Path homePath = Paths.get(HOME);
    	Assert.assertTrue(Files.exists(homePath));
    	
    	//delete file and check file not exists
    	Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
		if(Files.exists(playPath)) {
			FileUtils.deleteFiles(playPath.toFile());
			System.out.println("Existing Files deleted\ncreate new files");
		}
			
		Assert.assertTrue(Files.notExists(playPath));
		
		//create directory
		Files.createDirectories(playPath);
		Assert.assertTrue(Files.exists(playPath));
		
		//create file
		IntStream.range(1,10).forEach(cntr -> {
			Path tempFile = Paths.get(playPath + "/temp" + cntr);
			Assert.assertTrue(Files.notExists(tempFile));
			try {
				Files.createFile(tempFile);
			}catch(IOException e) {
			}
			Assert.assertTrue(Files.exists(tempFile));
		});
		
		//List files ,directories as well as files with extension
		Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
		Files.newDirectoryStream(playPath).forEach(System.out::println);
		Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp")).forEach(System.out::println);
    }
}
