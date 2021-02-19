package com.epam.task.fourth.parsers;

import com.epam.task.fourth.entities.Flower;

import java.util.List;

public interface Parser {

    List<Flower> parse(String fileName);

}
