package com.mooyle.guava.utilities;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.Charset;

/**
 * @Auther marse
 * @Date 2020/1/20 19:33
 */
public class StringsTest {

    @Test
    public void testStringMethod() {
        Assert.assertNull(Strings.emptyToNull(""));
        Assert.assertEquals(Strings.nullToEmpty(null), "");
        Assert.assertEquals(Strings.commonPrefix("Hello", "Hit"), "H");
        Assert.assertEquals(Strings.commonSuffix("Hello", "Echo"), "o");
        Assert.assertEquals(Strings.repeat("mc", 3), "mcmcmc");
        Assert.assertEquals(Strings.isNullOrEmpty(null), true);
        Assert.assertEquals(Strings.isNullOrEmpty(""), true);
        Assert.assertEquals(Strings.padStart("Hello", 3, 'H'), "Hello");
        Assert.assertEquals(Strings.padStart("Hello", 6, 'H'), "HHello");
        Assert.assertEquals(Strings.padEnd("Hello", 6, 'H'), "HelloH");
    }

    @Test
    public void testCharset() {
        Charset charset = Charset.forName("UTF-8");
        Assert.assertEquals(charset, Charsets.UTF_8);
    }

    @Test
    public void testCharMatcher() {
        Assert.assertTrue(CharMatcher.javaDigit().matches('5'));
        Assert.assertFalse(CharMatcher.javaDigit().matches('x'));
        Assert.assertEquals(CharMatcher.is('a').countIn("abca"), 2);
        Assert.assertEquals(CharMatcher.breakingWhitespace().collapseFrom("Hi    Hello   Guava.", ' '), "Hi Hello Guava.");
        Assert.assertEquals(CharMatcher.javaDigit().or(CharMatcher.whitespace()).removeFrom("hello 1234 world"), "helloworld");
        Assert.assertEquals(CharMatcher.javaDigit().or(CharMatcher.whitespace()).retainFrom("hello 1234 world"), " 1234 ");
    }
}
