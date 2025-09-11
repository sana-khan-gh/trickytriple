package org.example.application.cli;

import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class TodoListAppTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void testAddAndMarkDone() {
        String simulatedUserInput = String.join(System.lineSeparator(),
                "1", "Test task", // Add task
                "2", "1",         // Mark as done
                "4"               // Exit
        ) + System.lineSeparator();
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

        TodoListApp.main(new String[]{});

        String output = outContent.toString();
        assertTrue(output.contains("Test task"));
        assertTrue(output.contains("[X] Test task"));
        assertTrue(output.contains("Goodbye!"));
    }
}