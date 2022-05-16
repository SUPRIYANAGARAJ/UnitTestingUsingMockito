package com.skillsoft.Mocks_Project7;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
public class WeeklyReportsBatchJobTest {
	
	@Mock
	private EmailSender emailSenderMock;
	
	@InjectMocks
	WeeklyReportsBatchJob batchJob;
	
	@Test
	public void testGenerateWeeklyReport_singleRecipient() {
		
		when(emailSenderMock.sendEmail("john@infomoto.com",
				"The Sales weekly report has been generated")).thenReturn(true);
		
		assertTrue(batchJob.generateWeeklyReport("Sales","john@infomoto.com"));
	}
	
	@Test
	public void testGenerateWeeklyReport_multipleRecipient() {
		
		
		when(emailSenderMock.sendEmailToMultipleRecipients(new String[] {"john@infomoto.com", "julia@infomoto.com"},
				"The Revenues weekly report has been generated")).thenReturn(true);
		
		assertTrue(batchJob.generateWeeklyReport1("Revenues", new String[] {"john@infomoto.com", "julia@infomoto.com"}));
	}
	
	@Test
	public void sendWeeklyReport_withAttachment() {
		
		
		when(emailSenderMock.sendEmailWithAttachment("john@infomoto.com",
				"The Profits weekly report has been generated", "Sales have been going up!".getBytes())).thenReturn(true);
		
		assertTrue(batchJob.sendWeeklyReport("Profits","john@infomoto.com"));
	}
	
	

}
