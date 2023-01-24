import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecipeTest {

	private DatabaseQueries db = new DatabaseQueries();
    @Test
    void getName() {

        Recipe test = new Recipe(db);
        test.setName("name test");
        assertEquals("name test", test.getName());
    }

    @Test
    void getDirections() {

        Recipe test = new Recipe(db);
        test.setDirections("directions test");
        assertEquals("directions test", test.getDirections());
    }

    @Test
    void getTimeToCook() {

        Recipe test = new Recipe(db);
        test.setTimeToCook(100);
        assertEquals(100, test.getTimeToCook());
    }

    @Test
    void getNumServings() {

        Recipe test = new Recipe(db);
        test.setNumServings(200);
        assertEquals(200, test.getNumServings());
    }

    @Test
    void getCalories() {

        Recipe test = new Recipe(db);
        test.setCalories(300);
        assertEquals(300, test.getCalories());
    }

    @Test
    void getCarbs() {

        Recipe test = new Recipe(db);
        test.setCarbs(400);
        assertEquals(400, test.getCarbs());
    }

    @Test
    void getProtein() {

        Recipe test = new Recipe(db);
        test.setProtein(400);
        assertEquals(400, test.getProtein());
    }

    @Test
    void getFat() {

        Recipe test = new Recipe(db);
        test.setFat(500);
        assertEquals(500, test.getFat());
    }

    @Test
    void isBFast() {

        Recipe test = new Recipe(db);
        test.setBfast(true);
        assertEquals(true, test.isBfast());
    }

    @Test
    void isLunch() {

        Recipe test = new Recipe(db);
        test.setLunch(true);
        assertEquals(true, test.isLunch());
    }

    @Test
    void isDinner() {

        Recipe test = new Recipe(db);
        test.setDinner(true);
        assertEquals(true, test.isDinner());
    }

    @Test
    void isSnack() {

        Recipe test = new Recipe(db);
        test.setSnack(true);
        assertEquals(true, test.isSnack());
    }

    @Test
    void isVegan() {

        Recipe test = new Recipe(db);
        test.setVegan(true);
        assertEquals(true, test.isVegan());
    }

    @Test
    void isGlutenFree() {
		
		Recipe test = new Recipe(db);
        test.setGlutenFree(true);
        assertEquals(true,test.isGlutenFree());
	}

    @Test
    void setName() {

        Recipe test = new Recipe(db);
        test.setName("name test");
        assertEquals("name test", test.getName());
    }

    @Test
    void setDirections() {

        Recipe test = new Recipe(db);
        test.setDirections("directions test");
        assertEquals("directions test", test.getDirections());
    }

    @Test
    void setTimeToCook() {

        Recipe test = new Recipe(db);
        test.setTimeToCook(100);
        assertEquals(100, test.getTimeToCook());
    }

    @Test
    void setNumServings() {

        Recipe test = new Recipe(db);
        test.setNumServings(200);
        assertEquals(200, test.getNumServings());
    }

    @Test
    void setCalories() {

        Recipe test = new Recipe(db);
        test.setCalories(300);
        assertEquals(300, test.getCalories());
    }

    @Test
    void setCarbs() {

        Recipe test = new Recipe(db);
        test.setCarbs(400);
        assertEquals(400, test.getCarbs());
    }

    @Test
    void setProtein() {

        Recipe test = new Recipe(db);
        test.setProtein(400);
        assertEquals(400, test.getProtein());
    }

    @Test
    void setFat() {

        Recipe test = new Recipe(db);
        test.setFat(500);
        assertEquals(500, test.getFat());
    }

    @Test
    void setBFast() {

        Recipe test = new Recipe(db);
        test.setBfast(true);
        assertEquals(true, test.isBfast());
    }

    @Test
    void setLunch() {

        Recipe test = new Recipe(db);
        test.setLunch(true);
        assertEquals(true, test.isLunch());
    }

    @Test
    void setDinner() {

        Recipe test = new Recipe(db);
        test.setDinner(true);
        assertEquals(true, test.isDinner());
    }

    @Test
    void setSnack() {

        Recipe test = new Recipe(db);
        test.setSnack(true);
        assertEquals(true, test.isSnack());
    }

    @Test
    void setVegan() {

        Recipe test = new Recipe(db);
        test.setVegan(true);
        assertEquals(true, test.isVegan());
    }

    @Test
    void setGlutenFree() {
		
		Recipe test = new Recipe(db);
        test.setGlutenFree(true);
        assertEquals(true,test.isGlutenFree());
	}

}