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
package org.acumos.be.test.controller;

import org.acumos.cds.domain.MLPRole;
import org.acumos.cds.domain.MLPUser;
import org.acumos.portal.be.common.JsonRequest;
import org.acumos.portal.be.common.JsonResponse;
import org.acumos.portal.be.common.exception.UserServiceException;
import org.acumos.portal.be.controller.UserServiceController;
import org.acumos.portal.be.transport.PasswordDTO;
import org.acumos.portal.be.transport.User;
import org.acumos.portal.be.util.EELFLoggerDelegate;
import org.acumos.portal.be.util.PortalUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceControllerTest {

	private static final EELFLoggerDelegate logger = EELFLoggerDelegate.getLogger(UserServiceControllerTest.class);
    final HttpServletResponse response = new MockHttpServletResponse();
	final HttpServletRequest request = new MockHttpServletRequest();


	@Mock
	UserServiceController userServiceController = new UserServiceController();

	@Test
	public void createUserTest() {
		try {
			User user = new User();
			user.setUserId("8cbeccd0-ed84-42c3-8d9a-06d5629dc7bb");
			user.setFirstName("UserFirstName");
			user.setLastName("UserLastName");
			user.setUsername("User1");
			user.setEmailId("user1@emial.com");
			user.setActive("Y");
			user.setPassword("password");

			JsonRequest<User> userReq = new JsonRequest<User>();
			userReq.setBody(user);
			userReq.getBody();

			

			JsonResponse<Object> value = new JsonResponse<>();
			value.setResponseBody(userReq);

			Mockito.when(userServiceController.createUser(request, userReq, response)).thenReturn(value);
			logger.info("successfully  created user ");
			Assert.assertNotNull(value);
		} catch (Exception | UserServiceException e) {
			
			logger.debug("Error while creating user profile ", e);
		}
	}

	@Test
	public void updateUserTest() {
		try {
			User user = new User();
			user.setUserId("8cbeccd0-ed84-42c3-8d9a-06d5629dc7bb");
			user.setFirstName("UpdatedFirstName");
			user.setLastName("UpdatedLastName");
			user.setUsername("User1Updated");
			user.setEmailId("user1Updated@emial.com");
			user.setActive("Y");
			user.setPassword("password");

			JsonRequest<User> userReq = new JsonRequest<User>();
			userReq.setBody(user);
			userReq.getBody();

			JsonResponse<Object> value = new JsonResponse<>();
			value.setResponseBody(userReq);

			Mockito.when(userServiceController.updateUser(request, userReq, response)).thenReturn(value);
			logger.info("successfully  updated  user details");
			Assert.assertNotNull(value);
		} catch (Exception e) {
			
			logger.debug("Error while updating user profile ", e);
		}
	}

	@Test
	public void forgetPasswordTest() {
		try {
			User user = new User();
			user.setUserId("8cbeccd0-ed84-42c3-8d9a-06d5629dc7bb");
			user.setFirstName("UpdatedFirstName");
			user.setLastName("UpdatedLastName");
			user.setUsername("User1Updated");
			user.setEmailId("user1Updated@emial.com");
			user.setActive("Y");
			user.setPassword("password");
			Assert.assertNotNull(user);
			JsonRequest<User> userReq = new JsonRequest<User>();
			userReq.setBody(user);
			userReq.getBody();
			Assert.assertNotNull(userReq);

			JsonResponse<Object> value = new JsonResponse<>();
			value.setResponseBody(userReq);
			Mockito.when(userServiceController.forgetPassword(request, userReq, response)).thenReturn(value);
			logger.info("forgetPasswordTest");
			Assert.assertNotNull(value);
		} catch (Exception e) {
			
			logger.debug("Error while changing the password ", e);
		}
	}

	@Test
	public void changeUserPasswordTest() {
		try {
			User user = new User();
			user.setUserId("8cbeccd0-ed84-42c3-8d9a-06d5629dc7bb");
			user.setFirstName("UpdatedFirstName");
			user.setLastName("UpdatedLastName");
			user.setUsername("User1Updated");
			user.setEmailId("user1Updated@emial.com");
			user.setActive("Y");
			user.setPassword("oldpassword");

			JsonRequest<User> userReq = new JsonRequest<User>();
			userReq.setBody(user);
			userReq.getBody();
			Assert.assertNotNull(userReq);
			PasswordDTO passwordDTO = new PasswordDTO();
			passwordDTO.setNewPassword("newPassword");
			passwordDTO.setOldPassword("oldpassword");
			passwordDTO.setUserId(user.getUserId());

			JsonResponse<Object> valuepass = new JsonResponse<>();
			valuepass.setResponseBody(passwordDTO);

			Mockito.when(userServiceController.changeUserPassword(request, passwordDTO, response)).thenReturn(valuepass);
			logger.info("Successfully changed user profile password");
			Assert.assertNotNull(valuepass);
		} catch (Exception e) {
			
			logger.debug("Error while changeUserPasswordTest ", e);
		}
	}

	@Test
	public void getUserAccountDetailsTest() {
		try {

			User user = new User();
			user.setUserId("8cbeccd0-ed84-42c3-8d9a-06d5629dc7bb");
			user.setFirstName("FirstName");
			user.setLastName("LastName");
			user.setUsername("User1");
			user.setEmailId("user1@emial.com");
			user.setActive("Y");
			user.setPassword("oldpassword");
			Assert.assertNotNull(user);
			JsonRequest<User> userReq = new JsonRequest<User>();
			userReq.setBody(user);
			userReq.getBody();
			Assert.assertNotNull(userReq);
			
			MLPUser mlpUser = PortalUtils.convertToMLPUserForUpdate(user);
			Assert.assertNotNull(mlpUser);
			JsonResponse<MLPUser> value = new JsonResponse<>();
			value.setResponseBody(mlpUser);

			Mockito.when(userServiceController.getUserAccountDetails(userReq)).thenReturn(value);
			logger.info("Successfully fectched user details ");
			Assert.assertNotNull(value);
		} catch (Exception e) {
			
			logger.debug("Error while getUserAccountDetailsTest : ", e);
		}
	}

	@Test
	public void getAllUsersTest() {
		try {
			User user = new User();
			user.setUserId("8cbeccd0-ed84-42c3-8d9a-06d5629dc7bb");
			user.setFirstName("FirstName");
			user.setLastName("LastName");
			user.setUsername("User1");
			user.setEmailId("user1@emial.com");
			user.setActive("Y");
			user.setPassword("oldpassword");
			Assert.assertNotNull(user);
			JsonResponse<List<User>> userList = new JsonResponse<List<User>>();
			List<User> responseBody = new ArrayList<User>();
			responseBody.add(user);
			userList.setResponseBody(responseBody);
			userList.getResponseBody();
			Assert.assertNotNull(userList);
			Mockito.when(userServiceController.getAllUsers(request, response)).thenReturn(userList);
			logger.info("Successfully fectched list of user details ");
			Assert.assertNotNull(responseBody);
		} catch (Exception e) {
			logger.debug("Error while getAllUsersTest : ", e);
		}

	}

	@Test
	public void getUserRoleTest() {
		try {
			MLPRole mlRole = new MLPRole();
			mlRole.setName("Admin");
			Date created = new Date();
			mlRole.setCreated(created);
			mlRole.setRoleId("12345678-abcd-90ab-cdef-1234567890ab");
			Assert.assertNotNull(mlRole);
			
			User user = new User();
			user.setUserId("8cbeccd0-ed84-42c3-8d9a-06d5629dc7bb");
			user.setFirstName("FirstName");
			user.setLastName("LastName");
			user.setUsername("User1");
			user.setEmailId("user1@emial.com");
			user.setActive("Y");
			user.setPassword("oldpassword");
			user.setRole(mlRole.getName());
			user.setRoleId(mlRole.getRoleId());

			String userId = user.getUserId();
			
			Assert.assertEquals(userId, user.getUserId());
			
			List<MLPRole> mlprolelist = new ArrayList<MLPRole>();
			mlprolelist.add(mlRole);
			Assert.assertNotNull(mlprolelist);
			JsonResponse<List<MLPRole>> responseBody = new JsonResponse<>();
			responseBody.setResponseBody(mlprolelist);
			Mockito.when(userServiceController.getUserRole(userId, request, response)).thenReturn(responseBody);
			logger.info("Successfully fectched list of user details according user roles : ",
					responseBody.getResponseBody().toString());
			Assert.assertNotNull(responseBody);
		} catch (Exception e) {
			logger.debug("Error while getUserRoleTest : ", e);
		}
	}

}
