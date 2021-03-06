package ro.ase.EventsPlatform.utils;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;


@Provider
public class ResponseFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {

		HibernateUtils hibernate=HibernateUtils.getInstance();
		hibernate.closeSession();
		System.out.println("------------------- Response ----------------");
	}

}
