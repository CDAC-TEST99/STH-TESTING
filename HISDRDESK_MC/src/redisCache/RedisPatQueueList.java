package redisCache;

import redis.clients.jedis.Jedis;

public class RedisPatQueueList {

	public static String getPatientQueueList(String key) {

		// Validate key input
		if (key == null || key.trim().isEmpty()) {
			return "";
		}

		String queueJsonData = "";
		try (Jedis jedis = RedisConnectionPool.getConnection()) { // Use try-with-resources to ensure resource cleanup
			queueJsonData = jedis.get(key);
		} catch (Exception e) {
			// Log error message for better debugging
			System.err.println("Error fetching data from Redis: " + e.getMessage());
		}
		return queueJsonData;
	}

	public static void putPatientQueueList(String key, String queueJsonData) {
		// Validate key and queue data inputs
		if (key == null || key.trim().isEmpty()) {
			System.err.println("Invalid Redis key.");
			return;
		}
		if (queueJsonData == null || queueJsonData.trim().length() <= 1) {
			System.err.println("Invalid queue data.");
			return;
		}

		try (Jedis jedis = RedisConnectionPool.getConnection()) { // Use try-with-resources for automatic resource
																	// cleanup
			jedis.set(key, queueJsonData);
		} catch (Exception e) {
			// Log error message for better debugging
			System.err.println("Error storing data in Redis: " + e.getMessage());
		}
	}
}