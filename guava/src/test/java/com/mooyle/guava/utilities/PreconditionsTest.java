package com.mooyle.guava.utilities;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

/**
 * @Auther marse
 * @Date 2020/1/17 13:31
 */
public class PreconditionsTest {

    @Test(expected = NullPointerException.class)
    public void testCheckNotNull() {
        Preconditions.checkNotNull(null);
    }

    @Test
    public void testCheckNotNullWithMessage() {
        try {
            Preconditions.checkNotNull(null, "This list should not be null");
        } catch (Exception e) {
            Assert.assertEquals("This list should not be null", e.getMessage());
        }
    }

    @Test
    public void testCheckNotNullWithFormatMessage() {
        try {
            Preconditions.checkNotNull(null, "This list should not be null and size must be %s", 2);
        } catch (Exception e) {
            Assert.assertEquals("This list should not be null and size must be 2", e.getMessage());
        }
    }

    @Test
    public void testCheckArguments() {
        final String type = "A";
        try {
            Preconditions.checkArgument(type.equals(1));
        } catch (Exception e) {
            Assert.assertEquals(e.getClass(), IllegalArgumentException.class);
        }
    }

    @Test
    public void testCheckState() {
        try {
            final String state = "A";
            Preconditions.checkState(state.equals("B"), "The state is illegal.");
        } catch (Exception e) {
            Assert.assertEquals(e.getClass(), IllegalStateException.class);
        }
    }

    @Test
    public void testCheckIndex() {
        try {
            List<String> list = ImmutableList.of("");
            Preconditions.checkElementIndex(10, list.size());
        } catch (Exception e) {
            Assert.assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }
    }

    @Test(expected = NullPointerException.class)
    public void testByObjects() {
        Objects.requireNonNull(null);
    }

    @Test(expected = AssertionError.class)
    public void testAssert() {
        assert null != null;
    }

    @Test
    public void testAssertWithMessage() {
        try {
            assert null != null : "This should not be null.";
        }catch (Error e) {
            assert "This should not be null.".equals(e.getMessage());
        }
    }

}
