package dataObjects;
import java.util.Date;
import java.util.List;

public class Inventory
{
    private String id;
    
    private long lineNumber;

    private String startDate;
    
    private String endDate;
    
    private int caseSize;

    private int totalCases;

    private int remainingCases;
    
    private BranchInventory branchInventory;

	@Override
	public String toString() {
		return "Inventory [id=" + id + ",\n lineNumber=" + lineNumber + ",\n startDate=" + startDate + ",\n endDate="
				+ endDate + ",\n caseSize=" + caseSize + ",\n totalCases=" + totalCases + ",\n remainingCases="
				+ remainingCases + ",\n branchInventory=" + branchInventory + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(long lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getCaseSize() {
		return caseSize;
	}

	public void setCaseSize(int caseSize) {
		this.caseSize = caseSize;
	}

	public int getTotalCases() {
		return totalCases;
	}

	public void setTotalCases(int totalCases) {
		this.totalCases = totalCases;
	}

	public int getRemainingCases() {
		return remainingCases;
	}

	public void setRemainingCases(int remainingCases) {
		this.remainingCases = remainingCases;
	}

	public BranchInventory getBranchInventory() {
		return branchInventory;
	}

	public void setBranchInventory(BranchInventory branchInventory) {
		this.branchInventory = branchInventory;
	}

}