package com.mooyle.guava.utilities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

import java.util.Calendar;

/**
 * @Auther marse
 * @Date 2020/1/17 14:28
 */
public class ObjectTest {

    static class Guava implements Comparable<ObjectTest.Guava> {
        private String factory;
        private String version;
        private Calendar releaseDate;

        public Guava(String factory, String version, Calendar releaseDate) {
            this.factory = factory;
            this.version = version;
            this.releaseDate = releaseDate;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this).omitNullValues()
                    .add("factory", this.factory)
                    .add("version", this.version)
                    .add("releaseDate", this.releaseDate).toString();
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(factory, version, releaseDate);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Guava guava = (Guava) o;
            return Objects.equal(this.factory, guava.factory)
                    && Objects.equal(this.version, guava.version)
                    && Objects.equal(this.releaseDate, guava.releaseDate);
        }

        @Override
        public int compareTo(Guava o) {
            return ComparisonChain.start().compare(this.factory, o.factory)
                    .compare(this.version, o.version).compare(this.releaseDate, o.releaseDate).result();
        }
    }

    public static void main(String[] args) {
        final Guava guava = new ObjectTest.Guava("12", "1.1", Calendar.getInstance());
        System.out.println(guava.toString());
        System.out.println(guava.hashCode());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        final Guava guava2 = new ObjectTest.Guava("12", "1.1", calendar);
        System.out.println(guava.equals(guava2));
    }
}
