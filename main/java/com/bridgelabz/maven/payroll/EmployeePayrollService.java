package com.bridgelabz.maven.payroll;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * EmployeePayrollService class to read and write employee payroll to console
 * 
 * @author Mohammad Musthafa
 */
public class EmployeePayrollService {
	public enum IOService {
		CONSOLE_IO, FIlE_IO, DB_IO, REST_IO
	}

	private List<EmployeePayrollData> employeePayrollList;

	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	/**
	 * @method to write the Payroll into the file
	 */
	public void writeEmployeePayrollData(IOService ioService) {
		if (ioService.equals(IOService.CONSOLE_IO)) {
			System.out.println("\nWriting Employee Payroll roaster to console\n" + employeePayrollList);
		} else if (ioService.equals(IOService.FIlE_IO)) {
			new EmployeePayrollFileIOService().writeData(employeePayrollList);
		}
	}

	public long countEntries(IOService ioService) {
		return new EmployeePayrollFileIOService().countEntries();
	}

//	/**
//	 * @method to read the data from the Console
//	 * @param consoleInputReader console input reader
//	 */
//	private void readEmployeePayrollData(Scanner consoleInputReader) {
//		System.out.println("Enter Employee Id:");
//		int id = consoleInputReader.nextInt();
//		System.out.println("Enter Employee Name:");
//		String name = consoleInputReader.next();
//		System.out.println("Enter Employee Salary:");
//		double salary = consoleInputReader.nextDouble();
//		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
//	}
//
//	public static void main(String[] args) {
//		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();
//		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
//		Scanner consoleInputReader = new Scanner(System.in);
//		employeePayrollService.readEmployeePayrollData(consoleInputReader);
//		employeePayrollService.writeEmployeePayrollData(IOService.FIlE_IO);
//	}

}
