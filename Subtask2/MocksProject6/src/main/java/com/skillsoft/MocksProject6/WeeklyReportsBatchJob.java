package com.skillsoft.MocksProject6;

public class WeeklyReportsBatchJob {
	
	private EmailSender emailSender;
	
	public WeeklyReportsBatchJob(EmailSender emailSender) {
		this.emailSender = emailSender;
	}
	
	public boolean generateWeeklyReport(String reportType, String emailRecipient) {
		
		//NOTE: Assume that this runs some kind of batch job to prepaRE AND GENERATE
		//weekly reports and then sends an update to the email recipient that the 
		//weekly report has been generated
		
		return emailSender.sendEmail(emailRecipient, String.format("The %s weekly report has been generated", reportType));
	}
	
    public boolean generateWeeklyReport1(String reportType, String[] emailRecipient) {
		
		//NOTE: Assume that this runs some kind of batch job to prepare AND GENERATE
		//weekly reports and then sends a copy of the weekly report to multiple email recipients
    	
    	String reportCopy = "Sales have been going up!";
		
		return emailSender.sendEmailToMultipleRecipients(emailRecipient, 
				String.format("The %s weekly report has been generated", reportType));
	}
	
      public boolean sendWeeklyReport(String reportType, String emailRecipient) {
		
		//NOTE: Assume that this runs some kind of batch job to prepare AND GENERATE
		//weekly reports and then sends a copy of the weekly report to the email recipient
    	
    	String reportCopy = "Sales have been going up!";
		
		return emailSender.sendEmailWithAttachment(emailRecipient, String.format("The %s weekly report has been generated", reportType),
				reportCopy.getBytes());
	}
	
	

}
