package com.gmail.basecv.model;

import com.gmail.basecv.PojoTestUtils;
import com.gmail.basecv.util.DateUtils;
import org.junit.Test;

import java.time.Month;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class OrganizationTest {

    @Test
    public void testAccessors() {
        PojoTestUtils.validateAccessorsWithToString(Organization.class);
    }

    @Test
    public void testEqualsAndHashCode() {
        Organization organization1 = new Organization("test_o1", null, DateUtils.of(2020, Month.JANUARY), DateUtils.of(2020, Month.DECEMBER), "test_title", "test_description");
        Organization organization2 = new Organization("test_o1", null, DateUtils.of(2020, Month.JANUARY), DateUtils.of(2020, Month.DECEMBER), "test_title", "test_description");
        Organization organization3 = new Organization("test_o3", null, DateUtils.of(2020, Month.JANUARY), DateUtils.of(2020, Month.DECEMBER), "test_title", "test_description");

        assertEquals(organization1, organization2);
        assertNotEquals(organization1, organization3);

        assertEquals(organization1.hashCode(), organization2.hashCode());
        assertNotEquals(organization1.hashCode(), organization3.hashCode());
    }

}