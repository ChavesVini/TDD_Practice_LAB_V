package br.edu.fatec.sjc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NumberAscOrderTest {

    @Mock
    private CustomStack<Integer> mockStack;

    @Test
    void testSortWith6Numbers() {
        try {
            when(mockStack.isEmpty()).thenReturn(false, false, false, false, false, false, true);
            when(mockStack.pop()).thenReturn(23, 7, 45, 12, 3, 19);

            NumberAscOrder<Integer> sorter = new NumberAscOrder<>(mockStack);

            List<Integer> sortedList = sorter.sort();

            assertEquals(Arrays.asList(3, 7, 12, 19, 23, 45), sortedList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSortWithEmptyStack() {
        when(mockStack.isEmpty()).thenReturn(true);

        NumberAscOrder<Integer> sorter = new NumberAscOrder<>(mockStack);

        List<Integer> sortedList = sorter.sort();

        assertTrue(sortedList.isEmpty());
    }
}