/**
 * Copyright (c) 2016-2024, Mihai Emil Andronache
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this
 *  list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright notice,
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 * Neither the name of the copyright holder nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */
package com.amihaiemil.eoyaml;

import java.util.*;

/**
 * Base YamlSequence which all implementations should extend.
 * It implementing toString(), equals, hashcode and compareTo methods.
 * <br><br>
 * These methods should be default methods on the interface,
 * but we are not allowed to have default implementations of java.lang.Object
 * methods.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 4.0.0
 */
public abstract class BaseYamlSequence extends BaseYamlNode implements YamlSequence {

    /**
     * Ctor.
     */
    protected BaseYamlSequence() {
        this(false);
    }

    /**
     * Ctor.
     * @param alwaysPrintBlock Print it as block with disregard to whether it
     *  came from JSON/Flow-Style or not.
     */
    protected BaseYamlSequence(final boolean alwaysPrintBlock) {
        super(alwaysPrintBlock);
    }

    @Override
    public final Node type() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Equals method for YamlSequence. It returns true if the compareTo(...)
     * method returns 0.
     * @param other The YamlSequence to which this is compared.
     * @return True or false
     */
    @Override
    public final boolean equals(final Object other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Compare this Sequence to another node.<br><br>
     *
     * A Sequence is always considered greater than a Scalar and less than
     * a Mapping.<br>
     *
     * If other is a Sequence, their integer lengths are compared - the one with
     * the greater length is considered greater. If the lengths are equal,
     * then the 2 Sequences are equal if all elements are equal. If the
     * elements are not identical, the comparison of the first unequal
     * elements is returned.
     *
     * @param other The other YamlNode.
     * @checkstyle NestedIfDepth (100 lines)
     * @checkstyle LineLength (100 lines)
     * @return
     *   a value &lt; 0 if this &lt; other <br>
     *   0 if this == other or <br>
     *   a value &gt; 0 if this &gt; other
     */
    @Override
    public final int compareTo(final YamlNode other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final boolean isEmpty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
