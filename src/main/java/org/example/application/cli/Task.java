package org.example.application.cli;

/**
 * Represents a single to-do task with a description and completion status.
 */
public class Task {
    /**
     * The description of the task.
     */
    private String description;
    /**
     * Whether the task has been completed.
     */
    private boolean completed;

    /**
     * Constructs a new Task with the given description.
     *
     * @param description the description of the task
     */
    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    /**
     * Returns the description of the task.
     *
     * @return the task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns whether the task is completed.
     *
     * @return true if the task is completed, false otherwise
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Marks the task as completed.
     */
    public void markCompleted() {
        this.completed = true;
    }
}