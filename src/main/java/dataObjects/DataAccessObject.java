package dataObjects;

import org.json.simple.parser.ParseException;

public abstract class DataAccessObject {
	
	public abstract DataAccessObject convertJSONtoDAO(String jsonStr) throws ParseException;
	
	public abstract String convertDAOtoJSON(DataAccessObject dao);

}
