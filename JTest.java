import org.json.JSONException;
import org.json.JSONObject;

public class JTest {

	public static void main(String[] args) {
		try {
			JSONObject object = J.getList(new String[] {"json"}, new Object[] {
				J.getArray(
					J.getList(
						new String[] {
							"first_key",
							"second_key", 
							"third_key",
							"fourth key",
							"fifth key",
							"sixth key",
							"seventh key"
						},
						new Object[] {
							true,
							"egy",
							42,
							3.14f,
							'c',
							null,
							false
						}
					)
				)
			});
			System.out.println(object.toString());
		} catch (JSONException jsonex) {
			jsonex.printStackTrace();
		}
	}
}
