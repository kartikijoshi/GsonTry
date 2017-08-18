package dataObjects;
import java.util.List;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

public class BranchInventory {
	Pattern pattern = Pattern.compile("\\d+");
	@SerializedName("198")
	private Branch branchId198;
	
	@SerializedName("796")
	private Branch branchId796;
	
	@SerializedName("705")
	private Branch branchId705;

	public static BranchInventory fromJSONString(String string) {
		BranchInventory b = new BranchInventory();
		Gson gson = new Gson();
//		 jsonValue = gson.toJson(string);
//		new Gson().fromJson(string, BranchInventory);
		return b;
	}
	
	@Override
	public String toString() {
		return "\n[branchId198=" +branchId198.toString() +"\nbranchId705=" +branchId705.toString() +"\nbranchId796=" +branchId796.toString();
	}

}

class Branch{
	
	private int cases;
	
	private int units;
	
	private int remainingUnits;
	
	private Orders orders;

	@Override
	public String toString() {
		return "Branch [cases=" + cases + ", units=" + units + ", remainingUnits=" + remainingUnits + ", orders="
				+ orders + "]";
	}
}



class Orders{
	
	private List<Order> orders;
	
}

class Order{
	
	private long orderId;
	
	private String uom;
	
	private int amount;
}
