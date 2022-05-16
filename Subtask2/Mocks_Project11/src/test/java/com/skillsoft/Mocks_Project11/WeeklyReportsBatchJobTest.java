package com.skillsoft.Mocks_Project11;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
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
	public void testInitialize() {
		batchJob.initialize();
		
		verify(resourceProvisionerMock).initialize();
		verify(dataPreparerMock).initialize();
		verifyNoInteractions(emailSenderMock);
		
		//it will fail because the interaction has been reported
		//verifyNoInteractions(dataPreparerMock);//
		
	}
	
	@Test
	public void testGenerateWeeklyReport() {
		
		    when(resourceProvisionerMock.setupCluster(4, "Linux", "Spark")).thenReturn(true);
			
			when(dataPreparerMock.prepareRawData()).thenReturn(true);
			
			when(emailSenderMock.sendEmail("john@infomoto.com",
					"The Sales weekly report has been generated")).thenReturn(true);
			
			batchJob.initialize();
			batchJob.initializeReportGenerationConfig(4, "Linux", "Spark");
			batchJob.generateWeeklyReport("Sales","john@infomoto.com");
			
			verify(resourceProvisionerMock).initialize();
			verify(resourceProvisionerMock).setupCluster(4, "Linux", "Spark");
			verify(dataPreparerMock).initialize();
			verify(dataPreparerMock).prepareRawData();
			
			verify(emailSenderMock).sendEmail("john@infomoto.com", "The Sales weekly report has been generated");
			
	}

}
