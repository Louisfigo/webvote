package redis.webvote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
       ConfigurableApplicationContext applicationContext =  SpringApplication.run(RedisConfig.class);

       RedisService redisService = applicationContext.getBean(RedisService.class);

       Article article = new Article();

       article.setTitle("RCT-972");
       article.setLink("http://javload");
       article.setPoster("Jack");
       article.setTime(new Date());
       article.setVotes(1L);
       redisService.postArticle(article);

    }
}
