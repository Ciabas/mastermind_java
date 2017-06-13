package Model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Model.Difficulty;

public class DifficultyTest {
	
	private Difficulty sut;

	@Before
	public void initializeSUT(){
		sut = new Difficulty();
	}
	
	@Test
	public void shouldCreateEasyDifficultyWithEightAttemps() {
		//given
		int column = 8;
		int expected = 8;
		//when
		sut.Easy(column);
		int actual = sut.getAttempts();
		//then
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldCreateEasyDifficultyWithTimeSixtySec() {
		//given
		int column = 2;
		int expected = 60;
		//when
		sut.Easy(column);
		int actual = sut.getTime();
		//then
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldCreateEasyDifficultyWithSixColumns() {
		//given
		int column = 6;
		int expected = 6;
		//when
		sut.Easy(column);
		int actual = sut.getColumnsNumber();
		//then
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldCreateNormalDifficultyWithSevenAttemps() {
		//given
		int column = 8;
		int expected = 7;
		//when
		sut.Normal(column);
		int actual = sut.getAttempts();
		//then
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldCreateNormalDifficultyWithTimeEightySec() {
		//given
		int column = 4;
		int expected = 80;
		//when
		sut.Normal(column);
		int actual = sut.getTime();
		//then
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldCreateNormalDifficultyWithTwoColumns() {
		//given
		int column = 2;
		int expected = 2;
		//when
		sut.Normal(column);
		int actual = sut.getColumnsNumber();
		//then
		assertEquals(expected, actual);
	}

	@Test
	public void shouldCreateHardDifficultyWithSixAttemps() {
		//given
		int column = 8;
		int expected = 6;
		//when
		sut.Hard(column);
		int actual = sut.getAttempts();
		//then
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldCreateHardDifficultyWithTimeFourtySec() {
		//given
		int column = 4;
		int expected = 40;
		//when
		sut.Hard(column);
		int actual = sut.getTime();
		//then
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldCreateHardDifficultyWithThreeColumns() {
		//given
		int column = 3;
		int expected = 3;
		//when
		sut.Hard(column);
		int actual = sut.getColumnsNumber();
		//then
		assertEquals(expected, actual);
	}
}
