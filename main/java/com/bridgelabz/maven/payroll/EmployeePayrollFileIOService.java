package com.bridgelabz.maven.payroll;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollFileIOService {
	public static final String PAYROLL_FILE_NAME = "C:\\Users\\mohammad.musthafa_ym\\eclipse-workspace\\payroll\\src\\main\\java\\com\\bridgelabz\\maven\\payroll\\payroll-file.txt";

	public void writeData(List<EmployeePayrollData> employeePayrollList) {
		StringBuffer empBuffer = new StringBuffer();
		employeePayrollList.forEach(employee -> {
			String emloyeeDataString = employee.toString().concat("\n");
			empBuffer.append(emloyeeDataString);
		});
		try {
			Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @method to count employee payroll in the file
	 * @return
	 */
	public long countEntries() {
		long entries = 0;
		try {
			entries = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entries;
	}
	
	/**
	 * prints the data from the file
	 */
	public void printData() {
		try {
			Files.lines(new File(PAYROLL_FILE_NAME).toPath())
			.forEach(System.out::println);   
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * @method to copy payroll data from file and store in a list
	 * @return list of payroll data
	 */
	public List<EmployeePayrollData> readData() {
		List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		try {
			Files.lines((new File(PAYROLL_FILE_NAME).toPath()))
				.map(line -> line.trim()).forEach(line -> {
					String[] s = line.split(",", 3);
					employeePayrollList
						.add(new EmployeePayrollData(Integer.parseInt(s[0]), s[1], Double.parseDouble(s[2])));
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employeePayrollList;
	}
}
