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
package ksiegarnia.rest;

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

import ksiegarnia.dao.*;

import ksiegarnia.model.*;

@Path("/")
public class UserRest extends AbstractRest {

	@EJB
	private UserDao userFacade;

	@GET
	@Path("/User/registerUser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerUser(@QueryParam("login") String login,
			@QueryParam("password") String password,
			@QueryParam("password2") String password2,
			@QueryParam("eMail") String eMail,
			@Context HttpServletRequest request) {

		HttpSession httpSession = request.getSession();
		if (httpSession == null) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();
		}

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
		} catch (Exception e) {

			logger.severe(e.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();

		}

		return Response.ok(id, MediaType.APPLICATION_JSON).build();
	}

}
