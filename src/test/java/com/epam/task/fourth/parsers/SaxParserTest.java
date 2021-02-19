package com.epam.task.fourth.parsers;

import com.epam.task.fourth.AbstractParserTests;

public class SaxParserTest extends AbstractParserTests {

    @Override
    protected Parser setParser() {
        return new SaxParser();
    }

}
