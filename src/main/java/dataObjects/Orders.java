package dataObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

class Orders extends DataAccessObject{
	
	private List<Order> orders = new ArrayList<Order>();
	
	@Override
	public DataAccessObject convertJSONtoDAO(String jsonStr) throws ParseException {

		JsonObject jObject = new JsonParser().parse(jsonStr).getAsJsonObject();
		for (Map.Entry<String,JsonElement> entry : jObject.entrySet()) {
		    orders.add(Order.JsontoPOJO(entry.getKey(), (JsonElement) entry.getValue()));
		}
		return this;
	}

	@Override
	public String convertDAOtoJSON(DataAccessObject dao) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Orders [" + orders + "]";
	}
	
}

class Order{
	
	private long orderId;
	private String uom;
	private int amount;

	public static Order JsontoPOJO(String orderId, JsonElement jsonElement) throws ParseException {
		Order o = null;
		JSONObject orderJSONObject = (JSONObject) new JSONParser().parse(jsonElement.toString());
		if(orderJSONObject!=null && orderJSONObject.size()>0){
			Gson gson = new Gson();
			o = gson.fromJson(jsonElement, Order.class);
			o.orderId = Integer.parseInt(orderId);
		}
		return o;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "\nOrder [orderId=" + orderId + ",\n uom=" + uom + ",\n amount=" + amount + "]";
	}
}
