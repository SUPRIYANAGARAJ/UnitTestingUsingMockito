package com.skillsoft.Mocks_Project8;

public class ResourceProvisioner {
	
	//2 member variables
		private String cloudPlatform;
		private String authenticationkey;
		
		
		public ResourceProvisioner(String cloudPlatform, String authenticationkey) {
			super();
			this.cloudPlatform = cloudPlatform;
			this.authenticationkey = authenticationkey;
		}

		public boolean setupSingleMachine(String operatingSystem, String framework) {
			
			//Note: Assume this makes the right calls to set up a single machine, installs the
			//operating system, and installs the software packages on the machine
			
			return true;
		}
		
		public boolean setupCluster(int numMachines, String operatingSystem, String framework) {
			
			//NOTE: Assume this makes the right calls to set up a cluster of machines, configures
			//networking, installs the operating system, and installs the software packages on the machine
			return true;
		}

}
