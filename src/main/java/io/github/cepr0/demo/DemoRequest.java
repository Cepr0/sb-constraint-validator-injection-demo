package io.github.cepr0.demo;

import lombok.Value;

import static io.github.cepr0.demo.CheckCase.CaseMode.LOWER;
import static io.github.cepr0.demo.CheckCase.CaseMode.UPPER;

@Value
public class DemoRequest {
    @CheckCase(LOWER) String lowerText;
    @CheckCase(UPPER) String upperText;
}
