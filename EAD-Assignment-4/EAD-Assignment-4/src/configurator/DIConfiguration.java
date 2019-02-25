package configurator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.messageService.EmailService;
import com.metacube.messageService.TwitterService;


@Configuration
public class DIConfiguration {


	//creates the object of email service
	@Bean
	public EmailService email()
	{
		return (new EmailService());
	}
	
	//creates the object of twitter service
	@Bean
	public TwitterService twitter()
	{
		return (new TwitterService());
	}
}
