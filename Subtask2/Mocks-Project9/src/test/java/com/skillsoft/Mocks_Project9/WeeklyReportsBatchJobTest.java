package com.skillsoft.Mocks_Project9;

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
	
	@Mock
	private ResourceProvisioner resourceProvisionerMock;
	
	@Mock
	private DataPreparer dataPreparerMock;
	
	@InjectMocks
	WeeklyReportsBatchJob batchJob;
	
	@Test
	public void testGenerateWeeklyReport() {
		
		when(resourceProvisionerMock.setupCluster(3, "Linux", "Spark")).thenReturn(true);
		
		when(dataPreparerMock.prepareRawData()).thenReturn(true);
		
		when(emailSenderMock.sendEmail("john@infomoto.com",
				"The Sales weekly report has been generated")).thenReturn(true);
		
		assertTrue(batchJob.generateWeeklyReport("Sales","john@infomoto.com"));
	}
	
	@Test
	public void sendWeeklyReport_withAttachment() {
		
		when(resourceProvisionerMock.setupSingleMachine("Linux", "Java")).thenReturn(true);
		
		when(dataPreparerMock.prepareRawData()).thenReturn(true);
		
		when(emailSenderMock.sendEmailWithAttachment("john@infomoto.com",
				"The Profits weekly report has been generated", "Sales have been going up!".getBytes())).thenReturn(true);
		
		assertTrue(batchJob.sendWeeklyReport("Profits","john@infomoto.com"));
	}
	

}
