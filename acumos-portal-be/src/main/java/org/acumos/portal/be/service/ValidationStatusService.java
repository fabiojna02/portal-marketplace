/*-
 * ===============LICENSE_START=======================================================
 * Acumos
 * ===================================================================================
 * Copyright (C) 2017 AT&T Intellectual Property & Tech Mahindra. All rights reserved.
 * ===================================================================================
 * This Acumos software file is distributed by AT&T and Tech Mahindra
 * under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * This file is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ===============LICENSE_END=========================================================
 */

/**
 * 
 */
package org.acumos.portal.be.service;

import org.acumos.portal.be.transport.MLModelValidationCheck;
import org.acumos.portal.be.transport.MLModelValidationStatus;

public interface ValidationStatusService {
	
	/**
	 * Updates a validation status for specific task in the Database
	 * 
	 * @param taskId
	 * @param mlModelValidationStatus
	 * @return
	 */
	boolean updateValidationTaskStatus(String taskId, MLModelValidationStatus mlModelValidationStatus);
	
	
	/**
	 * Gets the validation status update for a given SolutionId and RevisionId
	 * @param userId
	 * @param solutionId
	 * @param revisionId
	 * @return
	 */
	MLModelValidationCheck getValidationTaskStatus(String solutionId, String revisionId);


	MLModelValidationCheck getSolutionValidationTaskStatus(String solutionId, String revisionId);
}
