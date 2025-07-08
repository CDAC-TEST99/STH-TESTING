package redisCache;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import redis.clients.jedis.Jedis;

public class RedisUnregisteredDrug {

	

	public static void putUnregisteredDrug( JSONObject JsonData) {
		// Validate key and queue data inputs
		/*
		 * if (key == null || key.trim().isEmpty()) {
		 * System.err.println("Invalid Redis key."); return; } if (JsonData == null) {
		 * System.err.println("Invalid JsonData"); return; }
		 */

		try (Jedis jedis = RedisConnectionPool.getConnection()) { // Use try-with-resources for automatic resource
																	// cleanup
			storeDrugData(jedis, JsonData);

		} catch (Exception e) {
			// Log error message for better debugging
			System.err.println("Error storing data in Redis: " + e.getMessage());
		}
	}

	// Stores drug JSON data using drugId as key
	private static void storeDrugData(Jedis jedis, JSONObject drugJson) throws JSONException {

		jedis.set("drug:" + drugJson.getString("drugId"), drugJson.toString());

		//System.out.println("Drug data stored successfully in Redis.");
	}

	// Creates an index for drugId, drugName, and drugStatus
	public static void createIndex() {

		try (Jedis jedis = RedisConnectionPool.getConnection()) { // Use try-with-resources to ensure resource cleanup

			jedis.sendCommand(redis.clients.jedis.Protocol.Command.valueOf("FT.CREATE"), "drug_idx", "ON", "JSON",
					"PREFIX", "1", "drug:", "SCHEMA", "$.drugId", "AS", "drugId", "TEXT", "$.drugName", "AS",
					"drugName", "TEXT", "$.hospitalType", "AS", "hospitalType", "NUMERIC");

			System.out.println("Index drug_idx created successfully!");

		} catch (Exception e) {
			// Log error message for better debugging
			System.err.println("Index drug_idx from Redis: " + e.getMessage());
		}

	}

	// Searches for drugs by keyword while filtering `drugStatus = 0`
	public static JSONArray searchDrugByKeyword( String searchTerm, String hospitalType)
			throws JSONException {
		String searchQuery = "@drugName:*" + searchTerm + "* @hospitalType:[" + hospitalType + " " + hospitalType + "]"; // Wildcard
		JSONArray jsonArray = new JSONArray();																													// search
																															// +
		try (Jedis jedis = RedisConnectionPool.getConnection()) { // 																													// filter

		// Execute FT.SEARCH using raw Redis commands
		@SuppressWarnings("unchecked")
		List<String> rawResults = (List<String>) jedis
				.sendCommand(redis.clients.jedis.Protocol.Command.valueOf("FT.SEARCH"), "drug_idx", searchQuery);

		
		
		for (String result : rawResults) {
			JSONObject jsonObject = new JSONObject(jedis.get(result));
			jsonArray.put(jsonObject);
		}
		} catch (Exception e) {
			// Log error message for better debugging
			System.err.println("Error getting data in Redis: " + e.getMessage());
		}

		return jsonArray;
	}

}