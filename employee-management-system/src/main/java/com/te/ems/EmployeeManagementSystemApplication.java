package com.te.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.te.ems.utils.PDFGenarator;

@SpringBootApplication
@ComponentScan("com.te.ems")
public class EmployeeManagementSystemApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(EmployeeManagementSystemApplication.class, args);
		PDFGenarator pdfGenarator = run.getBean(PDFGenarator.class);
		pdfGenarator.generatePDFReport();
	}

}
