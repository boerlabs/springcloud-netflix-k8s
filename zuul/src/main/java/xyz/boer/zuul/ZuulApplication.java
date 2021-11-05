package xyz.boer.zuul;

import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.repository.RateLimiterErrorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author boer
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

}

class BoerRateLimiterErrorHandler implements RateLimiterErrorHandler {

    @Override
    public void handleSaveError(String key, Exception e) {
    }

    @Override
    public void handleFetchError(String key, Exception e) {
    }

    @Override
    public void handleError(String msg, Exception e) {
    }
}
