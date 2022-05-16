package com.skillsoft.MocksProject14;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.atLeastOnce;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(MockitoExtension.class)
public class WeeklyReportsJobTest {
	
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
		
		
		when(resourceProvisionerMock.setupSingleMachine("Linux", "Spark")).thenReturn(true).thenReturn(true).thenReturn(false);
		when(emailSenderMock.sendEmail(
		"john@infomoto.com",
		"The Sales weekly report has been generated")).thenReturn(true);
		batchJob.initializeReportGenerationConfig(4,"Linux", "Spark");
		batchJob.generateWeeklyReport("Sales", "john@infomoto.com");
		// verify(resourceProvisionerMock,times(4)).setupMachine("Linux", "Spark");
		verify(resourceProvisionerMock,atLeast(2)).setupSingleMachine("Linux", "Spark");
		verify(resourceProvisionerMock,atMost(4)).setupSingleMachine("Linux", "Spark");
		verify(emailSenderMock,only())
		.sendEmail("john@infomoto.com","The Sales weekly report has been generated");
		verify(emailSenderMock,never())
		.sendEmailWithAttachment("john@infomoto.com","The Sales weekly report has been generated","someString".getBytes());
		}


	 
	
}
