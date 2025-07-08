package redisCache;
import hisglobal.utility.HisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConnectionPool {
    private static JedisPool jedisPool;

    static {
        try {
            JedisPoolConfig poolConfig = new JedisPoolConfig();
            poolConfig.setMaxTotal(200); // Maximum number of connections
            poolConfig.setMaxIdle(50); // Maximum idle connections
            poolConfig.setMinIdle(8);  // Minimum idle connections
            poolConfig.setTestOnBorrow(true); // Test connection before borrowing
            poolConfig.setTestOnReturn(true); // Test connection before returning
            poolConfig.setTestWhileIdle(true); // Periodically test idle connections

            String ip= HisUtil.getParameterFromHisPathXML("HIS_REDIS_SERVER_IP");
            int port = Integer.parseInt(HisUtil.getParameterFromHisPathXML("HIS_REDIS_SERVER_PORT"));
            // Initialize the pool (replace "localhost" and "6379" with your Redis host and port)
            jedisPool = new JedisPool(poolConfig, ip, port);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize Redis connection pool", e);
        }
    }

    public static Jedis getConnection() {
        return jedisPool.getResource();
    }

    public static void closePool() {
        if (jedisPool != null) {
            jedisPool.close();
        }
    }
    
    
}