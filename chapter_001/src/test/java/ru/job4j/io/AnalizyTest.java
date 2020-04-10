package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class AnalizyTest {

    @Test
    public void unavaibleTest() {
        new Analizy().unavailable("./data/unavailable.csv", "./data/res.csv");
        try (BufferedReader read = new BufferedReader(new FileReader("./data/res.csv"))
        ) {
            assertThat(read.readLine(), is("10:57:01 ; 10:59:01"));
            assertThat(read.readLine(), is("11:01:02 ; 11:02:02"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}