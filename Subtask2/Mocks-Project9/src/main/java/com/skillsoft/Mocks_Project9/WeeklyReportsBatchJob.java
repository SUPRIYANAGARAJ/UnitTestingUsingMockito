package com.skillsoft.Mocks_Project9;

public class WeeklyReportsBatchJob {
	
	//member variables
		private ResourceProvisioner resourceProvisioner;
		private DataPreparer dataPreparer;
		private EmailSender emailSender;
		
		//default constructor(private field injection)
		public WeeklyReportsBatchJob() {
			super();
		}

		//setter methods
		public void setResourceProvisioner(ResourceProvisioner resourceProvisioner) {
			this.resourceProvisioner = resourceProvisioner;
		}

		public void setDataPreparer(DataPreparer dataPreparer) {
			this.dataPreparer = dataPreparer;
		}

		public void setEmailSender(EmailSender emailSender) {
			this.emailSender = emailSender;
		}
		
      public boolean generateWeeklyReport(String reportType, String emailRecipient) {
			
			//NOTE: Assume that this runs some kind of batch job to prepaRE AND GENERATE
			//weekly reports and then sends an update to the email recipient that the 
			//weekly report has been generated
			
			if (resourceProvisioner.setupCluster(3, "Linux","Spark") && dataPreparer.prepareRawData()) {
			return emailSender.sendEmail(emailRecipient, String.format("The %s weekly report has been generated", reportType));
		}
			return false;
	}
		
	
	     public boolean sendWeeklyReport(String reportType, String emailRecipient) {
			
			//NOTE: Assume that this runs some kind of batch job to prepare AND GENERATE
			//weekly reports and then sends a copy of the weekly report to the email recipient
	    	  
	    	  if (resourceProvisioner.setupSingleMachine( "Linux","Java") && dataPreparer.prepareRawData()) {
	  			
	    	String reportCopy = "Sales have been going up!";
			
			return emailSender.sendEmailWithAttachment(emailRecipient, String.format("The %s weekly report has been generated", reportType),
					reportCopy.getBytes());
		}
	    	  
	    	  return false;
	      }
		
		
		
		
		

}
