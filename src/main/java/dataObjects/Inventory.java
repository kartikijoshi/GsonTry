package dataObjects;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

public class Inventory extends DataAccessObject
{
    private String id;
    
    private long lineNumber;

    private String startDate;
    
    private String endDate;
    
    private int caseSize;

    private int totalCases;

    private int remainingCases;

    private BranchInventory branchInventory;

	public String getId() {
		return id;
	}

	public long getLineNumber() {
		return lineNumber;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public int getCaseSize() {
		return caseSize;
	}

	public int getTotalCases() {
		return totalCases;
	}

	public int getRemainingCases() {
		return remainingCases;
	}

	public BranchInventory getBranchInventory() {
		return branchInventory;
	}

	@Override
	public DataAccessObject convertJSONtoDAO(String jsonStr) throws ParseException {
		Gson gson = new Gson();
		Inventory inventory = null ;
		JSONObject inventoryJSONObject = (JSONObject) new JSONParser().parse(jsonStr);
		if(inventoryJSONObject!=null){
			inventory = gson.fromJson(jsonStr, Inventory.class);
			JSONObject branchJSONObject = (JSONObject) inventoryJSONObject.get("branchInventory");
			if(branchJSONObject!=null && branchJSONObject.size()>0){
				inventory.branchInventory = (BranchInventory) inventory.branchInventory.convertJSONtoDAO(branchJSONObject.toJSONString());
			}
			System.out.println("DAO of inventory: \n" +inventory);
		}
		
		return inventory;
	}

	@Override
	public String convertDAOtoJSON(DataAccessObject dao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ",\n lineNumber=" + lineNumber + ",\n startDate=" + startDate + ",\n endDate="
				+ endDate + ",\n caseSize=" + caseSize + ",\n totalCases=" + totalCases + ",\n remainingCases="
				+ remainingCases + ",\n branchInventory=" + branchInventory + "]";
	}

}