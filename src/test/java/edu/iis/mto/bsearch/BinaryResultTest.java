/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iis.mto.bsearch;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * In all tests : key is a number we are looking for seq is a sequence in which
 * we are looking for expectedOnPosition is a position on which the hey should
 * apear
 *
 * @author Godzio
 */
public class BinaryResultTest {

    @Test
    public void binarySearch_search_oneElementOnInput_expectedTrue() {
        int key = 5;
        int seq[] = {5};

        assertTrue(BinarySearch.search(key, seq).isFound());
    }

    @Test
    public void binarySearch_search_oneElementOnInput_expectedFalse() {
        int key = 5;
        int seq[] = {2};

        assertFalse(BinarySearch.search(key, seq).isFound());
    }

    @Test
    public void binarySearch_search_moreElementsOnInput_expectedFoundAsFirstElement() {
        int key = 5;
        int seq[] = {5, 6, 7, 8, 9};
        int expectedOnPosition = 1;
        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertThat(expectedOnPosition, is(result.getPosition()));
    }

    @Test
    public void binarySearch_search_moreElementsOnInput_expectedFoundAsLastElement() {
        int key = 9;
        int seq[] = {5, 6, 7, 8, 9};
        int expectedOnPosition = seq.length;
        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertThat(expectedOnPosition, is(result.getPosition()));
    }

    @Test
    public void binarySearch_search_moreElementsOnInput_expectedFoundAsMiddleElement() {
        int key = 7;
        int seq[] = {5, 6, 7, 8, 9};
        int expectedOnPosition = 3;
        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertThat(expectedOnPosition, is(result.getPosition()));
    }

    @Test
    public void binarySearch_search_moreElementsOnInput_expectedNotFound() {
        int key = 1;
        int seq[] = {5, 6, 7, 8, 9};
        int expectedOnPosition = -1;
        SearchResult result = BinarySearch.search(key, seq);
        
        assertFalse(result.isFound());
        assertThat(expectedOnPosition, is(result.getPosition()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void binarySearch_search_zeroElementOnInput_expectedIllegalArgumentException() {
        int key = 3;
        int seq[] = {};

        BinarySearch.search(key, seq);
    }

    @Test
    public void binarySearch_search_fiveIdenticalElements_expectedFoundOnMiddleElements() {
        int key = 5;
        int seq[] = {5, 5, 5, 5, 5};
        int expectedOnPosition = 3;
        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertThat(3, is(result.getPosition()));
    }
}
