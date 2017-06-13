package Model;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import Model.Order;


public class OrderTest {
	
	Order sut;
	
	@Before
	public void initializeSUT(){
		Color[] colors = new Color[] {Color.BLUE, Color.RED, Color.GREEN, Color.CYAN};
		sut = new Order(colors.length, colors);
	}

	@Test
	public void shouldCreateOrderByConstructorWithTwoParameters() {
		//given
		Color[] colors = new Color[] {Color.BLUE, Color.RED, Color.GREEN, Color.CYAN};
		Order expected = new Order();
		expected.setColumnsNumber(4);
		expected.setOrder(colors);
		//when
		Order actual = new Order(colors.length, colors);
		//then
		assertEquals(expected.getColumnsNumber(), actual.getColumnsNumber());
		assertEquals(expected.getOrder(), actual.getOrder());
	}
	
	@Test
	public void shouldCreateRandomizedTableOfColorsWithoutRepetition() {
		//given
		int columns = 8;
		Color[] colorsTable = new Color[columns];
		Order order = new Order();
		//when
		colorsTable = order.randomFromColorsWithoutRepetition(columns);
		//then
		for(int i = 0; i < colorsTable.length; i++){
			for(int j = 0; j < colorsTable.length; j++){
				if(i != j) assertNotEquals(colorsTable[i], colorsTable[j]);
			}
		}
	}
	
	@Test
	public void shouldCorrectCompareTwoOrders() {
		//given
		Color[] colors = new Color[] {Color.BLUE, Color.RED, Color.GREEN, Color.CYAN};
		//when
		//then
		assertEquals(true, sut.compareWith(colors));
	}
	
	@Test
	public void shouldFailComparingTwoOrders() {
		//given
		Color[] colors = new Color[] {Color.BLACK, Color.BLUE, Color.GREEN, Color.CYAN};
		//when
		//then
		assertEquals(false, sut.compareWith(colors));
	}
	
	@Test
	public void shouldCheckHowManyColorsAreRight() {
		//given
		Color[] colors1 = new Color[] {Color.BLUE, Color.RED, Color.GREEN, Color.CYAN};
		Order first = new Order(4, colors1);
		Color[] colors2 = new Color[] {Color.RED, Color.GREEN, Color.BLUE, Color.BLACK};
		Order second = new Order(4, colors2);
		int expected = 3;
		//when
		int actual = sut.checkForRightColors(first, second);
		//then
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldCheckHowManyColorsAreOnRightSpot() {
		//given
		Color[] colors1 = new Color[] {Color.BLUE, Color.RED, Color.GREEN, Color.CYAN};
		Order first = new Order(4, colors1);
		Color[] colors2 = new Color[] {Color.RED, Color.GREEN, Color.BLUE, Color.CYAN};
		Order second = new Order(4, colors2);
		boolean[] expecteds = {false,false,false,true};
		//when
		boolean[] actuals = sut.checkForRightSpots(first, second);
		//then
		for(int i = 0; i < actuals.length; i++){
			assertEquals(expecteds[i], actuals[i]);
		}
	}
	
	@Test
	public void shouldReturnFailWhileCheckingIfColorsAreUnique() {
		//given
		boolean expected = false;
		Color[] colors = new Color[] {Color.BLUE, Color.RED, Color.GREEN, Color.CYAN, Color.BLUE};
		Order order = new Order(4, colors);
		//when
		boolean actual = order.areColorsUnique();
		//then
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnTrueWhileCheckingIfColorsAreUnique() {
		//given
		boolean expected = true;
		Color[] colors = new Color[] {Color.BLUE, Color.RED, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.ORANGE, Color.YELLOW, Color.PINK};
		Order order = new Order(4, colors);
		//when
		boolean actual = order.areColorsUnique();
		//then
		assertEquals(expected, actual);
	}
}
