package com.gmail.basecv.model;


import com.gmail.basecv.PojoTestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ResumeTest {

    @Test
    public void testAccessors() {
        PojoTestUtils.validateAccessorsWithToString(Resume.class);
    }

    @Test
    public void testEqualsAndHashCode() {
        Resume resume1 = new Resume("1", "test1");
        Resume resume2 = new Resume("1", "test1");
        Resume resume3 = new Resume("2", "test2");

        assertEquals(resume1, resume2);
        assertNotEquals(resume1, resume3);

        assertEquals(resume1.hashCode(), resume2.hashCode());
        assertNotEquals(resume1.hashCode(), resume3.hashCode());
    }

}