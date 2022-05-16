package com.skillsoft.Mocks_Project4;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Note: Assume that this is a proxy, that uses a URL to connect to another machine
//and allows us to perform operations on the other machine
public class RemoteMachineProxy {
	
	private final String remoteUrl;
	private Iterator<String> remoteFileIterator;
	
	public RemoteMachineProxy(String remoteUrl) {
		this.remoteUrl = remoteUrl;
	}
	
	private void connect() {
		//Note: Assume this connects to the remote machine and initializes
		//an iterator to get the list of records stored in the remote machine
		
	}
	
	//Note: This method exists only for the purposes of testing, which is why it has default access,
	//i.e. can only be accessed by other classes in same package. Test classes for this class will 
	//be in the same package as the class itself
	
	void setTestIterator(Iterator<String> testIterator) {//setter method
		this.remoteFileIterator = testIterator;
	}
	
	public String getNextFile() {
		if(remoteFileIterator.hasNext()) {
			String record = remoteFileIterator.next();
			
			Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+")
					.matcher(record);

			
			if (m.find()) {
				return m.group();
			}
			
			return remoteFileIterator.next();
		}
		
		return null;
		
	}
	
	

}
