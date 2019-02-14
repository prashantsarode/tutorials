package com.sampleprograms.spring.boot.zuul.gateway.server.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulCustomHeaderFilter extends ZuulFilter {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		if ((RequestContext.getCurrentContext().getRequest().getRequestURI().contains("currency-conversion-service"))) {
			RequestContext request = RequestContext.getCurrentContext();
			request.addZuulRequestHeader("Accept", "application/json");
			LOGGER.info("Request {}", request);
		}
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
