
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
import org.carrot2.util.attribute.Input;
import org.carrot2.util.attribute.Label;
import org.carrot2.util.attribute.TestInit;

/**
 *
 */
@Bindable
public class AttributeLabels
{
    @TestInit
    @Input
    @Attribute
    @Label("word")
    public int singleWordLabel;

    @TestInit
    @Input
    @Attribute
    @Label("multi word label")
    public int multiWordLabel;

    @TestInit
    @Input
    @Attribute
    @Label("First label sentence. Second label sentence.")
    public int multiSentenceLabel;

    /**
     * Attribute comment. Second sentence of attribute comment.
     */
    @TestInit
    @Input
    @Attribute
    @Label("word")
    public int labelWithComment;
}
