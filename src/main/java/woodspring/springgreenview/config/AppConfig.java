package woodspring.springgreenview.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;

import woodspring.springgreenview.utils.GreenviewConstant;

@Configuration
public class AppConfig {

	@Bean
	public  MongoClientFactoryBean mongo() {
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        mongo.setHost(GreenviewConstant.MongoIP);
        return mongo;
   }
	
}
