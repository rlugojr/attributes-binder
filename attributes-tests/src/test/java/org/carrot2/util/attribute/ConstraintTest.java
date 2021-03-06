
/*
 * Carrot2 project.
 *
 * Copyright (C) 2002-2012, Dawid Weiss, Stanisław Osiński.
 * All rights reserved.
 *
 * Refer to the full license file "carrot2.LICENSE"
 * in the root folder of the repository checkout or at:
 * http://www.carrot2.org/carrot2.LICENSE
 */

package org.carrot2.util.attribute;

import java.util.Map;

import org.carrot2.util.attribute.constraint.ImplementingClasses;
import org.junit.Test;

import com.carrotsearch.randomizedtesting.RandomizedTest;
import org.carrot2.shaded.guava.common.collect.Maps;

/**
 * Test cases for constraints.
 */
public class ConstraintTest extends RandomizedTest
{
    @Bindable
    static class WithStrictImplementingClasses
    {
        @Input
        @Attribute
        @ImplementingClasses(classes =
        {
            String.class, Integer.class, Boolean.class
        })
        public Object object = "";
    }

    @Bindable
    static class WithNonStrictImplementingClasses
    {
        @Input
        @Attribute
        @ImplementingClasses(classes =
        {
            String.class
        }, strict = false)
        public Object object = "";
    }

    @Test
    public void testStrictImplementingClasses() throws AttributeBindingException,
        InstantiationException
    {
        final WithStrictImplementingClasses instance = new WithStrictImplementingClasses();

        bindInputValues(instance, "object", "string", 10, Boolean.TRUE);
    }

    @Test(expected = AttributeBindingException.class)
    public void testViolatedStrictImplementingClasses() throws AttributeBindingException,
        InstantiationException
    {
        final WithStrictImplementingClasses instance = new WithStrictImplementingClasses();

        bindInputValues(instance, "object", new Double(0.5));
    }

    @Test
    public void testNonStrictImplementingClasses() throws AttributeBindingException,
        InstantiationException
    {
        final WithNonStrictImplementingClasses instance = new WithNonStrictImplementingClasses();

        bindInputValues(instance, "object", "string", 10, Boolean.TRUE);
    }

    private void bindInputValues(Object instance, String fieldName, Object... values)
        throws AttributeBindingException, InstantiationException
    {
        final Map<String, Object> attributes = Maps.newHashMap();

        for (int i = 0; i < values.length; i++)
        {
            attributes.put(AttributeUtils.getKey(instance.getClass(), fieldName),
                values[i]);
            AttributeBinder.set(instance, attributes, Input.class);
            attributes.clear();
        }
    }
}
