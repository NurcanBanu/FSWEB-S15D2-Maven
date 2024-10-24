package org.example;

import org.example.entity.Priority;
import org.example.entity.Status;
import org.example.entity.Task;
import org.example.entity.TaskData;

import java.util.HashSet;
import java.util.Set;

import static org.example.entity.StringSet.findUniqueWords;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Task task1 = new Task("ProjectA", "Fix bug", "Ann", Status.ASSIGNED, Priority.HIGH);
        Task task2 = new Task("ProjectB", "Develop feature", "Bob", Status.IN_PROGRESS, Priority.MED);
        Task task3 = new Task("ProjectC", "Code review", "Carol" , Status.IN_QUEUE, Priority.LOW);
        Task task4 = new Task("ProjectD", "Update documentation", null, Status.IN_QUEUE, Priority.LOW);

        Set<Task> annsTasks = new HashSet<>();
        annsTasks.add(task1);

        Set<Task> bobsTasks = new HashSet<>();
        bobsTasks.add(task2);

        Set<Task> carolsTasks = new HashSet<>();
        carolsTasks.add(task3);

        Set<Task> unassignedTasks = new HashSet<>();
        unassignedTasks.add(task4);

        TaskData taskData = new TaskData(annsTasks, bobsTasks, carolsTasks, unassignedTasks);

        Set<Task> allTasks = taskData.getTasks("all");
        System.out.println("All tasks: " + allTasks);

        Set<Task> anns = taskData.getTasks("ann");
        System.out.println("Ann's tasks: " + anns);

        Set<Task> bobs = taskData.getTasks("bob");
        System.out.println("Bob's tasks: " + bobs);

        Set<Task> carols = taskData.getTasks("carol");
        System.out.println("Carol's tasks: " + carols);

        System.out.println("Unassigned tasks: " + taskData.getTasks("none"));

        Set<Task> intersect = taskData.getIntersection(annsTasks, bobsTasks);
        System.out.println("Intersecting tasks: " + intersect);

        Set<String> uniqueWords = findUniqueWords();
        System.out.println("Unique kelimeler:");
        uniqueWords.forEach(System.out::println);
    }
}