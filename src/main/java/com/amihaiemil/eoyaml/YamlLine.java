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

import com.amihaiemil.eoyaml.exceptions.YamlReadingException;

/**
 * A line of yaml.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 1.0.0
 */
interface YamlLine extends Comparable<YamlLine> {

    /**
     * Indicates we don't know or don't have a line number for the given
     * comment (may not have come from a file).
     */
    int UNKNOWN_LINE_NUMBER = -1;

    /**
     * The line's value, untrimmed, containing comments etc.
     * @return String.
     */
    String value();

    /**
     * The line's trimmed contents with comments, aliases etc removed.
     * @return Trimmed string (leading and trailing spaces) contents.
     * @todo #374:60min There's a missing condition in this method, removed
     *  as a workaround in Pull Request 375. Debug, find the reason and
     *  implement a better solution for ticket 374. This is rather low prio.
     * @checkstyle CyclomaticComplexity (100 lines)
     */
    default String trimmed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The line's contents with spaces, tabs, etc maintained.
     * @param previousIndent How deeply nested is the Yaml line - this is used
     *                       to remove leading spaces.
     * @return String line contents.
     */
    default String contents(final int previousIndent) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Return the comment, if any, from this line.
     * @return Comment of empty string.
     */
    default String comment() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Number of the line (count start from 0).
     * @return Integer.
     */
    int number();

    /**
     * This line's indentation (number of spaces at the beginning of it).>br>
     * Should be a multiple of 2! If not, IllegalStateException is thrown.
     * @return Integer.
     * @throws IllegalStateException if the indentation is not multiple of 2.
     */
    int indentation();

    /**
     * Do the following line(s) require a deeper indentation than this line's?
     * @return True or false
     */
    default boolean requireNestedIndentation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Compare this line to another.
     * @param other Other line to compare.
     * @return Zero if same line object, 1 if other is null, or string
     *  comparison of the trimmed (no spaces or comments) values.
     */
    default int compareTo(final YamlLine other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * YamlLine null object.
     */
    class NullYamlLine implements YamlLine {

        @Override
        public String value() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String trimmed() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String contents(final int previousIndent) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int number() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int indentation() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
