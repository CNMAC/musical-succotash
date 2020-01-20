package com.mooyle.guava.utilities;

import com.google.common.base.Splitter;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @Auther marse
 * @Date 2020/1/16 16:48
 */
public class SplitterTest {

    @Test
    public void testSplitOnSplit() {
        List<String> result = Splitter.on("|").splitToList("hello|world");
        Assert.assertEquals(2, result.size());
        Assert.assertEquals("hello", result.get(0));
        Assert.assertEquals("world", result.get(1));
    }

    @Test
    public void testSplitOnSplitOmitEmpty() {
        List<String> result = Splitter.on("|").splitToList("hello|world|||");
        Assert.assertNotNull(result);
        Assert.assertEquals(5, result.size());
        List<String> result2 = Splitter.on("|").omitEmptyStrings().splitToList("hello|world|||");
        Assert.assertNotNull(result2);
        Assert.assertEquals(2, result2.size());
    }

    @Test
    public void testSplitOnSplitOmitEmptyAndTrim() {
        List<String> result = Splitter.on("|").omitEmptyStrings().trimResults().splitToList(" hello | world | | |");
        Assert.assertEquals(2, result.size());
        Assert.assertEquals("hello", result.get(0));
        Assert.assertEquals("world", result.get(1));
    }

    @Test
    public void testSplitFixLength() {
        List<String> result = Splitter.fixedLength(4).splitToList("aaaabbbbccccdddd");
        Assert.assertEquals(4, result.size());
        Assert.assertEquals("aaaa", result.get(0));
        Assert.assertEquals("bbbb", result.get(1));
    }

    @Test
    public void testSplitLimit() {
        List<String> result = Splitter.on("#").limit(3).splitToList("a#b#c#d#e");
        Assert.assertEquals(3, result.size());
        Assert.assertEquals("a", result.get(0));
        Assert.assertEquals("b", result.get(1));
        Assert.assertEquals("c#d#e", result.get(2));
    }

    @Test
    public void testSplitOnPatternString() {
        List<String> result = Splitter.onPattern("\\|").trimResults().omitEmptyStrings().splitToList("hello | world |||");
        Assert.assertEquals(2, result.size());
        Assert.assertEquals("hello", result.get(0));
        Assert.assertEquals("world", result.get(1));
    }

    @Test
    public void testSplitOnPattern() {
        List<String> result = Splitter.on(Pattern.compile("\\|")).trimResults().omitEmptyStrings().splitToList("hello | world |||");
        Assert.assertEquals(2, result.size());
        Assert.assertEquals("hello", result.get(0));
        Assert.assertEquals("world", result.get(1));
    }

    @Test
    public void testSplitOnSplitToMap() {
        Map<String, String> result = Splitter.on(Pattern.compile("\\|")).trimResults().omitEmptyStrings().withKeyValueSeparator("=").split("hello=HELLO | world=WORLD |||");
        Assert.assertEquals(2, result.size());
        Assert.assertEquals("HELLO", result.get("hello"));
        Assert.assertEquals("WORLD", result.get("world"));
    }

}
