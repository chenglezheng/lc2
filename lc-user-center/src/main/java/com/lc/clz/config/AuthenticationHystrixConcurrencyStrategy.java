package com.lc.clz.config;

import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.concurrent.Callable;

@Component
public class AuthenticationHystrixConcurrencyStrategy extends HystrixConcurrencyStrategy {

    private static final Log log = LogFactory.getLog(AuthenticationHystrixConcurrencyStrategy.class);

    public AuthenticationHystrixConcurrencyStrategy() {
        HystrixPlugins.reset();
        HystrixPlugins.getInstance().registerConcurrencyStrategy(this);
    }

    @Override
    public <T> Callable<T> wrapCallable(Callable<T> callable) {
        /*RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();*/
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        return new WrappedCallable<>(callable, authentication);
    }

    static class WrappedCallable<T> implements Callable<T> {

        private final Callable<T> target;
        private final Authentication authentication;

        public WrappedCallable(Callable<T> target, Authentication authentication) {
            this.target = target;
            this.authentication = authentication;
        }

        @Override
        public T call() throws Exception {
            try {
                SecurityContextHolder.getContext().setAuthentication(authentication);
                return target.call();
            } finally {
                RequestContextHolder.resetRequestAttributes();
            }
        }
    }
}