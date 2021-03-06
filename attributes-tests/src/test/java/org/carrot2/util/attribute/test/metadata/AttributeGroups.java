
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

package org.carrot2.util.attribute.test.metadata;

import org.carrot2.util.attribute.Attribute;
import org.carrot2.util.attribute.Bindable;
import org.carrot2.util.attribute.Group;
import org.carrot2.util.attribute.Input;
import org.carrot2.util.attribute.TestInit;

/**
 *
 */
@Bindable
public class AttributeGroups
{
    @TestInit
    @Input
    @Attribute
    @Group("Group")
    public int oneWordGroup;

    @TestInit
    @Input
    @Attribute
    @Group("Multi word group")
    public int multiWordGroup;

    /**
     * 
     */
    @TestInit
    @Input
    @Attribute
    public int noGroup;
}
