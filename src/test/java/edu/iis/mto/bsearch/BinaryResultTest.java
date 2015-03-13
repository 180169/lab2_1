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
 *  In all tests :
 * key is a number we are looking for
 * seq is a sequence in which we are looking for
 * expectedOnPosition is a position on which the hey should apear
 * @author Godzio
 */
public class BinaryResultTest {

    @Test
    public void binarySearch_searchResult_oneElementOnInput_expectedTrue() {
        int key = 5;
        int seq[] = {5};

        assertTrue(BinarySearch.search(key, seq).isFound());
    }

    @Test
    public void binarySearch_searchResult_oneElementOnInput_expectedFalse() {
        int key = 5;
        int seq[] = {2};

        assertFalse(BinarySearch.search(key, seq).isFound());
    }

    @Test
    public void binarySearch_searchResult_moreElementsOnInput_expectedFoundAsFirstElement() {
        int key = 5;
        int seq[] = {5, 6, 7, 8, 9};
        int expectedOnPosition = 1;
        
        assertTrue(BinarySearch.search(key, seq).isFound());
        assertThat( expectedOnPosition, is(BinarySearch.search(key, seq).getPosition()) );
    }
    @Test
    public void binarySearch_searchResult_moreElementsOnInput_expectedFoundAsLastElement() {
        int key = 9;
        int seq[] = {5, 6, 7, 8, 9};
        int expectedOnPosition = seq.length;
        
        assertTrue(BinarySearch.search(key, seq).isFound());
        assertThat( expectedOnPosition, is(BinarySearch.search(key, seq).getPosition()) );
    }
    @Test
    public void binarySearch_searchResult_moreElementsOnInput_expectedFoundAsMiddleElement() {
        int key = 7;
        int seq[] = {5, 6, 7, 8, 9};
        int expectedOnPosition = 3 ;
        
        assertTrue(BinarySearch.search(key, seq).isFound());
        assertThat( expectedOnPosition, is(BinarySearch.search(key, seq).getPosition()) );
    }
    @Test
    public void binarySearch_searchResult_moreElementsOnInput_expectedNotFound() {
        int key = 1;
        int seq[] = {5, 6, 7, 8, 9};
        int expectedOnPosition = -1 ;
        
        assertFalse(BinarySearch.search(key, seq).isFound());
        assertThat( expectedOnPosition, is(BinarySearch.search(key, seq).getPosition()) );
    }
}
