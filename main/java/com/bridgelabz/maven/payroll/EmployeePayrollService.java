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

	public EmployeePayrollService() {
		
	}
	
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

	/**
	 * @method to count entries in the file
	 * @param ioService
	 * @return
	 */
	public long countEntries(IOService ioService) {
		return new EmployeePayrollFileIOService().countEntries();
	}
	
	/**
	 * @method to print data from the file
	 */
	public void printData() {
		new EmployeePayrollFileIOService().printData();
	}
	
	/**
	 * @method to read the data from file
	 * @return
	 */
	public long readEmployeePayrollData() {
		this.employeePayrollList = new EmployeePayrollFileIOService().readData();
		return this.employeePayrollList.size();
	}

}
