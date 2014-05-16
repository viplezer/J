/**
 * Created by plezerv on 2013.05.17..
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class J {

    public static JSONObject getList(String[] keys, Object[] values) throws JSONException {
        if (keys.length != values.length) {
            throw new JSONException("Keys and values array size must be equal");
        }
        JSONObject result = new JSONObject();
        for (int i = 0; i < keys.length; ++i) {
		if(values[i] == null) result.put(keys[i], JSONObject.NULL);
		else result.put(keys[i], values[i]);
        }
        return result;
    }

    public static JSONArray getArray(Object[] objects) throws JSONException {
        JSONArray result = new JSONArray();
        for (int i = 0; i < objects.length; ++i) {
                if(objects[i] == null) result.put(i, JSONObject.NULL);
		else result.put(i, objects[i]);
        }
        return result;
    }

    public static JSONArray getArray(JSONObject object) throws JSONException {
        JSONArray result = new JSONArray();
        result.put(0, object);
        return result;
    }

    public static JSONObject insertIntoObject(JSONObject obj, String[] keys, Object[] values) throws JSONException {
        if (keys.length != values.length) {
            throw new JSONException("Keys and values array size must be equal");
        }
        for (int i = 0; i < keys.length; ++i) {
		if(values[i] == null) obj.put(keys[i], JSONObject.NULL);
		else obj.put(keys[i], values[i]);
        }
        return obj;
    }

    public static int getZeroOrInt(JSONObject object, String tag) {
        if (object == null) return 0;
        if (object.has(tag)) {
            try {
                return object.getInt(tag);
            } catch (JSONException e) {
            }
        }
        return 0;
    }

    public static String getStringOrNull(JSONObject object, String tag) {
        if (object == null) return null;
        if (object.has(tag)) {
            try {
                String str = object.getString(tag);
                if (str == null || str.equals("null") || str.length() == 0) return null;
                return str;
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public static boolean getBoolean(JSONObject object, String tag, boolean defaultValue) {
        if (object == null) return defaultValue;
        if (object.has(tag)) {
            try {
                return object.getBoolean(tag);
            } catch (JSONException e) {
            }
        }
        return defaultValue;
    }

}
