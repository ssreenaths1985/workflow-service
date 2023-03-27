package org.sunbird.workflow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sunbird.workflow.config.Configuration;
import org.sunbird.workflow.config.Constants;
import org.sunbird.workflow.core.WFLogger;
import org.sunbird.workflow.models.WfRequest;
import org.sunbird.workflow.postgres.entity.WfStatusEntity;
import org.sunbird.workflow.postgres.repo.WfStatusRepo;
import org.sunbird.workflow.producer.Producer;
import org.sunbird.workflow.service.UserRegistrationWfService;

@Service
public class UserRegistrationWfServiceImpl implements UserRegistrationWfService {

	private WFLogger logger = new WFLogger(getClass().getName());

	@Autowired
	private WfStatusRepo wfStatusRepo;

	@Autowired
	private Configuration configuration;

	@Autowired
	private Producer producer;

	@Override
	public void processMessage(WfRequest wfRequest) {
		logger.info("Received process message event for appId :: " + wfRequest.getApplicationId());
		WfStatusEntity wfStatusEntity = wfStatusRepo.findByApplicationIdAndWfId(wfRequest.getApplicationId(),
				wfRequest.getWfId());
		logger.info("WF Status Object Status :: " + wfStatusEntity.getCurrentStatus());
		if (Constants.USER_REGISTRATION_SERVICE_NAME.equals(wfRequest.getServiceName())
				&& Constants.WF_APPROVED_STATE.equals(wfStatusEntity.getCurrentStatus())) {
			producer.push(configuration.getWorkflowCreateUserTopic(), wfRequest);
		}
	}
}
