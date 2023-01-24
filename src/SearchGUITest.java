import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class SearchGUITest {
	
	private DatabaseQueries db = new DatabaseQueries();
	
	@Test
	void checkTableColsTest() {
		SearchGUI sut = new SearchGUI(db);
		sut.buildSearch();
		sut.createTable();
		String result = sut.getColName(0);
		
		assertEquals("ID", result);
	}
	
	@Test
	void setMealTest() {
		SearchGUI sut = new SearchGUI(db);
		sut.setMeal("test");
		assertEquals("test", sut.getMeal());
	}
}
