package com.in28minutes.unittesting.unit_testing.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class AssertJTest {

    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12,15,45);



//        assertThat(numbers, hasSize(3));
//        assertThat(numbers, hasItems(12,45));
//        assertThat(numbers, everyItem(greaterThan(10)));
//        assertThat(numbers, everyItem(lessThan(100)));

        assertThat(numbers).hasSize(3)
                .contains(12,15)
                .allMatch(x -> x>10)
                .allMatch(x -> x<100)
                .noneMatch(x -> x<0);

//        assertThat("", isEmptyString());
//        assertThat("", is(emptyString()));
//        assertThat("ABCDE", containsString("BCD"));
//        assertThat("ABCDE", startsWith("ABC"));
//        assertThat("ABCDE", endsWith("CDE"));

        assertThat("").isEmpty();
        assertThat("ABCDE").contains("BCD")
                .startsWith("ABC")
                .endsWith("CDE");

    }

}
