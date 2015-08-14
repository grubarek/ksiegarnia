/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.ksiegarnia.rest.resource;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pl.ksiegarnia.dao.UserDao;
import pl.ksiegarnia.dao.exception.DaoException;
import pl.ksiegarnia.jpa.User;
import pl.ksiegarnia.rest.model.AbstractRest;

@Path("/")
public class UserRest extends AbstractRest {

	@EJB
	private UserDao userFacade;

	@GET
	@Path("/registerUser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerUser(@QueryParam("login") String login,
			@QueryParam("password") String password,
			@QueryParam("password2") String password2,
			@QueryParam("eMail") String eMail,
			@Context HttpServletRequest request) {
		//TODO "pawel" stworzyc nowa klase AssignAccount/Accunt paramety login, pass,pass2 i email. i obiet tej metody przekazywac do request-a
		HttpSession httpSession = request.getSession();
		if (httpSession == null) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();
		}
		//FIXME stworzyc clase UserManager, tam przeniesc wszystko zwiazane z userem i tutaj tyko wywolac metode userManager.account(Account usergit 
		if (login == null || password == null || password2 == null
				|| eMail == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		if (password.equals(password2) == false) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		User user = new User(login, password, eMail);
		Long id = new Long(0);
		try {
			id = userFacade.createUser(user);
		} catch (DaoException e) {

			logger.severe(e.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();

		}

		return Response.ok(id, MediaType.APPLICATION_JSON).build();
	}

	//TODO do przeanalizowania
/*@POST
	@Path("authorize")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public Response authorize(MultivaluedMap<String, String> params, @Context HttpServletRequest request) {
		logger.info(String.format("UserResource::authorize invoked. params: %s, url: %s, JBOSS_HOME: %s", params, request.getRequestURL().toString(), System.getenv("JBOSS_HOME")));
		String login = "", password = "", salesforceLogin = null, salesforcePassword = null;
		if (!params.containsKey("login")) {
			logger.info("No login provided...");
			return ResponseHelper.badRequest();
		}
		login = (String) ((List) params.get("login")).get(0);
		if (!params.containsKey("password")) {
			logger.info("No password provided...");
			return ResponseHelper.badRequest();
		}
		password = (String) ((List) params.get("password")).get(0);
		if (!params.containsKey("deviceId")) {
			logger.info("No deviceId provided...");
			return ResponseHelper.badRequest();
		}
		String deviceId = (String) ((List) params.get("deviceId")).get(0);

		HttpSession httpSession = request.getSession();
		AuthorizeResponse response = new AuthorizeResponse();

		try {
			if (httpSession == null) {
				logger.severe("No http session found");
				return ResponseHelper.internalServerError();
			}
			Account account = accountDao.authorize(login, password);
			if (account == null) {
				logger.info("User is not authorized");
				return ResponseHelper.forbidden();
			} else if (account.getStatus() == Account.STATUS_REMOVED) {
				logger.info("Account was removed: user is not authorized");
				return ResponseHelper.forbidden();
			} else if (account.getStatus() == Account.STATUS_BLOCKED) {
				logger.info("Account was blocked: user is blocked");
				response = new AuthorizeResponse(Confirmation.STATUS_REMOVE_APPLICATION_DATA);
				return ResponseHelper.ok(response);
			} else if (account.getStatus() == Account.STATUS_ACTIVE) {
				Device device = deviceDao.getAccountDevice(account.getId(), deviceId);
				if (device == null) {
					//dodajemy nowe aktywne
					String deviceModel = null, devicePlatform = null;
					if ( (deviceModel = checkDeviceModel(params)) == null ) return ResponseHelper.badRequest();
					if ( (devicePlatform = checkDevicePlatform(params)) == null ) return ResponseHelper.badRequest();
					if (!params.containsKey("deviceVendor")) {
						logger.info("No deviceVendor provided...");
						return ResponseHelper.badRequest();
					}
					String deviceVendor = (String) ((List) params.get("deviceVendor")).get(0);
					if (!params.containsKey("osVersion")) {
						logger.info("No osVersion provided...");
						return ResponseHelper.badRequest();
					}
					String osVersion = (String) ((List) params.get("osVersion")).get(0);
					device = newDevice(account, deviceId, devicePlatform, deviceModel, deviceVendor, osVersion);
					deviceDao.createDevice(device);
					logger.info("New device created");
				} else if (device.getStatus() == Device.STATUS_BLOCKED) {
					logger.info(String.format("The device was blocked %s", deviceId));
					return ResponseHelper.forbidden();
				} else if (device.getStatus() == Device.STATUS_REMOVED) {
					logger.info(String.format("The device was removed %s adding...", deviceId));
					device.setStatus(Device.STATUS_ACTIVE);
					deviceDao.updateDevice(device);
					logger.info("Device recreated");
				}
				account.setCurrentLoginDate(); //data aktualna
				//zaktualizuj login/hasło salesforce
				if (params.containsKey("salesforceLogin")) {
					salesforceLogin = (String) ((List) params.get("salesforceLogin")).get(0);
					account.setSalesforceLogin(salesforceLogin);
				}
				if (params.containsKey("salesforcePassword")) {
					salesforcePassword = (String) ((List) params.get("salesforcePassword")).get(0);
					account.setSalesforcePassword(salesforcePassword);
				}
				accountDao.updateAccount(account);
	            response.setAccount(account);
	            InitialContext ic = new InitialContext();
	            //zapisz deviceId zalogowanego usera
				account.setDeviceId(deviceId);
	            //zapisz w sesji dane konta i uprawnień
	            httpSession.setAttribute(sessionCookieUser, account);
				httpSession.setAttribute(sessionCookieAuthorization, AUTHORIZATION_PASSWORD); //informacja o autoryzacji hasłem
	            List<Role> roles = roleDao.getAccountRoles(account.getId());
	            if (roles.size() == 0) {
		            logger.warning("User has no roles");
	            } else {
		            logger.info(String.format("User roles: %s", roles));
		            httpSession.setAttribute(sessionCookieRoles, roles);
		            for (Role r : roles) {
			            response.addRoleName(r.getName());
		            }
	            }
	            response.setDocuments(documentDao.getDocumentsByAccount(account.getId()));
				//asynchronicznie wywołaj synchronizacja z SF
				salesforceApi.synchronizeMeetings(account.getSalesforceLogin(), account.getSalesforcePassword());
            }
			logger.info("User is authorized.");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "UserResource::authorize exception: " + e, e);
			return ResponseHelper.internalServerError();

		}

		return ResponseHelper.ok(response);
	}

* */
}
