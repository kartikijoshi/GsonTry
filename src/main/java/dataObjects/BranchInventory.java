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

public class BranchInventory extends DataAccessObject{
	
	private List<Branch> branches = new ArrayList<Branch>();

	@Override
	public DataAccessObject convertJSONtoDAO(String jsonStr) throws ParseException {
		
		JsonObject jObject = new JsonParser().parse(jsonStr).getAsJsonObject();
		for (Map.Entry<String,JsonElement> entry : jObject.entrySet()) {
		    branches.add(Branch.JsontoPOJO(entry.getKey(), (JsonElement) entry.getValue()));
		}
		return this;
	}

	@Override
	public String convertDAOtoJSON(DataAccessObject dao) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	@Override
	public String toString() {
		return "BranchInventory [branches=\n" + branches + "]";
	}

}

class Branch{
	
	private int branchId;
	private int cases;
	private int units;
	private int remainingUnits;
	private Orders orders;
	
	public static Branch JsontoPOJO(String branchId, JsonElement jsonElement) throws ParseException{
		Gson gson = new Gson();
		Branch b = null;
		JSONObject branchJSONObject = (JSONObject) new JSONParser().parse(jsonElement.toString());
		if(branchJSONObject!=null && branchJSONObject.size()>0){
			b = gson.fromJson(jsonElement, Branch.class);
			b.branchId = Integer.parseInt(branchId);
			JSONObject ordersJSONObject = (JSONObject) branchJSONObject.get("orders");
			if(ordersJSONObject!=null && ordersJSONObject.size()>0){
				b.orders = (Orders) b.orders.convertJSONtoDAO(ordersJSONObject.toString());
			}
		}
		return b;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getCases() {
		return cases;
	}

	public void setCases(int cases) {
		this.cases = cases;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public int getRemainingUnits() {
		return remainingUnits;
	}

	public void setRemainingUnits(int remainingUnits) {
		this.remainingUnits = remainingUnits;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "\n[branchId=" + branchId + ",\n cases=" + cases + ",\n units=" + units + ",\n remainingUnits="
				+ remainingUnits + ",\n orders=" + orders + "]\n";
	}
}