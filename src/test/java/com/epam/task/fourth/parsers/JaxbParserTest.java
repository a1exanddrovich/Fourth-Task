package com.epam.task.fourth.parsers;

import com.epam.task.fourth.AbstractParserTests;

public class JaxbParserTest extends AbstractParserTests {

    @Override
    protected Parser setParser() {
        return new JaxbParser();
    }

}
