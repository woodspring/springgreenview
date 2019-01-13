package woodspring.springgreenview.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

import woodspring.springgreenview.utils.GreenviewConstant;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "woodspring.springgreenview.config")
public class SpringGoodviewMongoConfiguration extends AbstractReactiveMongoConfiguration {

	@Override
	public MongoClient reactiveMongoClient() {
		// TODO Auto-generated method stub
		return  MongoClients.create( GreenviewConstant.MongoDBUrl); //, GreenviewConstant.MongoDBPort);
	}

	@Override
	protected String getDatabaseName() {
		
		return GreenviewConstant.DatabaseName;
	}

}
