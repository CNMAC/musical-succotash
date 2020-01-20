package com.mooyle.guava.utilities;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Auther marse
 * @Date 2020/1/16 11:34
 */
public class JoinerTest {

    @Test
    public void testJoinOnJoin() {
        List<String> stringList = Arrays.asList("Guava", "Java", "Scala");
        String result = Joiner.on("#").join(stringList);
        Assert.assertEquals("Guava#Java#Scala", result);
    }

    @Test(expected = NullPointerException.class)
    public void testJoinOnJoinWithNullValue() {
        List<String> stringListWithNullValue = Arrays.asList("Guava", "Java", "Scala", null);
        String result = Joiner.on("#").join(stringListWithNullValue);
    }

    @Test
    public void testJoinOnJoinWithNullValueSkip() {
        List<String> stringListWithNullValue = Arrays.asList("Guava", "Java", "Scala", null);
        String result = Joiner.on("#").skipNulls().join(stringListWithNullValue);
        Assert.assertEquals("Guava#Java#Scala", result);
    }

    @Test
    public void testJoinOnJoinWithNullValueUseDefault() {
        List<String> stringListWithNullValue = Arrays.asList("Guava", "Java", "Scala", null);
        String result = Joiner.on("#").useForNull("DEFAULT").join(stringListWithNullValue);
        Assert.assertEquals("Guava#Java#Scala#DEFAULT", result);
    }

    @Test
    public void testJoinOnJoinAppendStringBuilder() {
        final StringBuilder builder = new StringBuilder();
        List<String> stringListWithNullValue = Arrays.asList("Guava", "Java", "Scala", null);
        StringBuilder resultBuilder = Joiner.on("#").useForNull("DEFAULT").appendTo(builder, stringListWithNullValue);
        Assert.assertEquals(resultBuilder, builder);
    }

    @Test
    public void testJoinOnJoinAppendToWriter() {
        List<String> stringListWithNullValue = Arrays.asList("Guava", "Java", "Scala", null);
        try (FileWriter writer = new FileWriter(new File("guava-joiner.txt"))) {
            Joiner.on("#").useForNull("DEFAULT").appendTo(writer, stringListWithNullValue);
            Assert.assertEquals(true, Files.isFile().test(new File("guava-joiner.txt")));
        } catch (IOException e) {
            Assert.fail("append to the writer occur fetal error.");
        }
        new File("guava-joiner.txt").delete();
    }

    @Test
    public void testJoinByStreamSkipNullValues() {
        List<String> stringListWithNullValue = Arrays.asList("Guava", "Java", "Scala", null);
        String result = stringListWithNullValue.stream().filter(item -> item != null && !item.isEmpty()).collect(Collectors.joining("#"));
        Assert.assertEquals("Guava#Java#Scala", result);
    }

    @Test
    public void testJoinByStreamWithDefaultValue() {
        List<String> stringListWithNullValue = Arrays.asList("Guava", "Java", "Scala", null);
        String result = stringListWithNullValue.stream()
                .map(item -> item == null || item.isEmpty() ? "DEFAULT" : item)
                .collect(Collectors.joining("#"));
        Assert.assertEquals("Guava#Java#Scala#DEFAULT", result);
    }

    @Test
    public void testJoinOnWithMap() {
        Map<String, String> stringMap = ImmutableMap.of("hello", "guava", "java","scala");
        String result = Joiner.on("#").withKeyValueSeparator("=").join(stringMap);
        Assert.assertEquals("hello=guava#java=scala", result);
    }

}
