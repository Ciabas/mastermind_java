package Model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


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
        sut.easy(column);
        int actual = sut.getAttempts();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateEasyDifficultyWithTimeEightySec() {
        //given
        int column = 2;
        int expected = 80;
        //when
        sut.easy(column);
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
        sut.easy(column);
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
        sut.normal(column);
        int actual = sut.getAttempts();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateNormalDifficultyWithTimeHundredTwentySec() {
        //given
        int column = 4;
        int expected = 120;
        //when
        sut.normal(column);
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
        sut.normal(column);
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
        sut.hard(column);
        int actual = sut.getAttempts();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateHardDifficultyWithTimeEightySec() {
        //given
        int column = 4;
        int expected = 80;
        //when
        sut.hard(column);
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
        sut.hard(column);
        int actual = sut.getColumnsNumber();
        //then
        assertEquals(expected, actual);
    }
}
