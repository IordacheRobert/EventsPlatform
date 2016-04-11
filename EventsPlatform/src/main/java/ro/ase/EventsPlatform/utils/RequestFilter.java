package ro.ase.EventsPlatform.utils;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class RequestFilter implements ContainerRequestFilter{

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		HibernateUtils hibernate=HibernateUtils.getInstance();
		hibernate.openSession();
		System.out.println("------------------- Request ----------------");

	}

}
