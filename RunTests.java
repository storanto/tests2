package com.devops.autotests.storanto.assignment;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class RunTests {

	public static void main(String[] args) throws Exception {
		
    	//String binaryPath = "C:\\Users\\Anton\\AppData\\Local\\Mozilla Firefox\\firefox.exe";
    	String binaryPath = "";
    	
    	if(args.length > 0) {
    		binaryPath = args[0];
        	System.setProperty("binaryPath", binaryPath);
    	}else {
    		throw new Exception("No binary path given.");
    	}

    	System.setProperty("binaryPath", binaryPath);
    	
    	Result result = JUnitCore.runClasses(LoginTest.class, LoginWrongPassTest.class, FlowTest.class, LockedUserTest.class);
    	
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        
        System.out.println("Tests run: " + result.getRunCount() +
                ", Failures: " + result.getFailureCount() +
                ", Ignored: " + result.getIgnoreCount() +
                ", Time elapsed: " + result.getRunTime() + " ms");
		
	}
	
}
