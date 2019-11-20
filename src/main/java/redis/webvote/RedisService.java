package redis.webvote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {


    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    public void postArticle(Article article)
    {
        Long acId = redisTemplate.opsForValue().increment("articleId",1);

        redisTemplate.opsForHash().putIfAbsent("articleStore",acId.toString(),article);


    }
}
