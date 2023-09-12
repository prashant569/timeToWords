package com.example.time;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class TimeConverterTest {

    @Mock
    private ITimeConverterService timeConverterService;

    @Test
    public void testConvertToWordsValidTime() {
        String timeStr = "14:30";
        String expected = "It's two thirty";
        String actual = timeConverterService.convertToWords(timeStr);
        assertEquals(expected, actual);
    }

    @Test
    public void testConvertToWordsInvalidTime() {
        String timeStr = "25:00";
        assertThrows(IllegalArgumentException.class, () -> timeConverterService.convertToWords(timeStr));
    }
}
