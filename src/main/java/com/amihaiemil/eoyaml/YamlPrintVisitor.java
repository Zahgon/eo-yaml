/**
 * Copyright (c) 2016-2024, Mihai Emil Andronache
 * All rights reserved.
 * <p>
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * Neither the name of the copyright holder nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
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

import java.io.StringWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Visitor which prints the YAML in block format.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @checkstyle ExecutableStatementCount (1000 lines)
 * @since 7.2.0
 */
final class YamlPrintVisitor implements YamlVisitor<String> {

    /**
     * How many indentation spaces to use?
     */
    private final int indentation;

    /**
     * Line separator.
     */
    private final String lineSeparator;

    /**
     * Print each node as block-style always.
     */
    private final boolean alwaysBlock;

    /**
     * Ctor.
     * @param lineSeparator Line separator.
     * @param alwaysBlock Print each node as block-style always.
     */
    YamlPrintVisitor(final String lineSeparator, final boolean alwaysBlock) {
        this(2, lineSeparator, alwaysBlock);
    }

    /**
     * Ctor.
     * @param indentation Number of spaces to use for indentation.
     * @param lineSeparator Line separator.
     * @param alwaysBlock Print each node as block-style always.
     */
    YamlPrintVisitor(final int indentation, final String lineSeparator, final boolean alwaysBlock) {
        this.indentation = indentation;
        this.lineSeparator = lineSeparator;
        this.alwaysBlock = alwaysBlock;
    }

    @Override
    public String visitYamlMapping(final YamlMapping node) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String visitYamlSequence(final YamlSequence node) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String visitScalar(final Scalar node) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String visitYamlStream(final YamlStream node) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String visitYamlNode(final YamlNode node) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String defaultResult() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String aggregateResult(final String aggregate, final String nextResult) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Indent a text with a number of spaces.
     * @param print Text to indent.
     * @param numberOfSpaces Number of indentation spaces.
     * @return Indented text.
     */
    private String indent(final String print, final int numberOfSpaces) {
        int spaces = numberOfSpaces;
        final StringBuilder indent = new StringBuilder();
        while (spaces > 0) {
            indent.append(" ");
            spaces--;
        }
        final String[] lines = print.split(this.lineSeparator);
        final StringWriter indented = new StringWriter();
        for (final String line : lines) {
            indented.append(indent.toString()).append(line).append(this.lineSeparator);
        }
        final String str = indented.toString();
        return str.substring(0, str.length() - 1);
    }

    /**
     * Print a comment. Make sure to split the lines if there are more
     * lines separated by NewLine and also add a '# ' in front of each
     * line.
     * @param node Node containing the Comment.
     * @return Printed comment.
     */
    private String printPossibleComment(final YamlNode node) {
        final StringWriter writer = new StringWriter();
        if (node != null && node.comment() != null) {
            final Comment tmpComment;
            if (node.comment() instanceof ScalarComment) {
                tmpComment = ((ScalarComment) node.comment()).above();
            } else {
                tmpComment = node.comment();
            }
            final String com = tmpComment.value();
            if (com.trim().length() != 0) {
                String[] lines = com.split(this.lineSeparator);
                for (final String line : lines) {
                    writer.append("# ").append(line).append(this.lineSeparator);
                }
            }
        }
        return writer.toString();
    }

    /**
     * Write a block mapping to the given StringWriter.
     * @param node Block YamlMapping to print.
     * @param writer String writer.
     */
    private void printBlockMapping(final YamlMapping node, final StringWriter writer) {
        for (final YamlNode key : node.keys()) {
            final YamlNode value = node.value(key);
            writer.append(this.printPossibleComment(value));
            if (key.type().equals(Node.SCALAR)) {
                writer.append(this.visitYamlNode(key));
            } else {
                writer.append("?").append(this.lineSeparator);
                final String printedValue = this.visitYamlNode(key);
                writer.append(this.indent(printedValue, this.indentation));
                writer.append(this.lineSeparator);
            }
            if (value == null || value.type().equals(Node.SCALAR)) {
                writer.append(": ");
                writer.append(this.visitYamlNode(value));
            } else {
                final String printedValue = this.visitYamlNode(value);
                if ("null".equals(printedValue) || printedValue.startsWith("[") || printedValue.startsWith("{")) {
                    writer.append(": ");
                    writer.append(printedValue);
                } else {
                    writer.append(":");
                    writer.append(this.lineSeparator);
                    writer.append(this.indent(printedValue, this.indentation));
                }
            }
            writer.append(this.lineSeparator);
        }
    }

    /**
     * Write a flow mapping to the given StringWriter.
     * @param node Flow YamlMapping to print.
     * @param writer String writer.
     */
    private void printFlowMapping(final YamlMapping node, final StringWriter writer) {
        writer.append("{");
        int i = 0;
        final Set<YamlNode> keys = node.keys();
        for (final YamlNode key : keys) {
            final YamlNode value = node.value(key);
            writer.append(this.visitYamlNode(key));
            writer.append(": ");
            writer.append(this.visitYamlNode(value));
            i++;
            if (i < keys.size()) {
                writer.append(", ");
            }
        }
        writer.append("}");
    }

    /**
     * Write a block sequence to the given StringWriter.
     * @param node Block YamlSequence to print.
     * @param writer String writer.
     */
    private void printBlockSequence(final YamlSequence node, final StringWriter writer) {
        for (final YamlNode value : node.values()) {
            writer.append(this.printPossibleComment(value));
            if (value == null || value.type().equals(Node.SCALAR)) {
                writer.append("- ");
                writer.append(this.visitYamlNode(value));
            } else {
                final String printedValue = this.visitYamlNode(value);
                if ("null".equals(printedValue) || printedValue.startsWith("[") || printedValue.startsWith("{")) {
                    writer.append("- ");
                    writer.append(printedValue);
                } else {
                    writer.append("-");
                    writer.append(this.lineSeparator);
                    writer.append(this.indent(printedValue, this.indentation));
                }
            }
            writer.append(this.lineSeparator);
        }
    }

    /**
     * Write a flow sequence to the given StringWriter.
     * @param node Flow YamlSequence to print.
     * @param writer String writer.
     */
    private void printFlowSequence(final YamlSequence node, final StringWriter writer) {
        writer.append("[");
        int i = 0;
        final Collection<YamlNode> values = node.values();
        for (final YamlNode value : values) {
            writer.append(this.visitYamlNode(value));
            i++;
            if (i < values.size()) {
                writer.append(", ");
            }
        }
        writer.append("]");
    }

    /**
     * A scalar which escapes its value.
     * @author Mihai Andronache (amihaiemil@gmail.com)
     * @version $Id$
     * @since 7.2.0
     * @checkstyle LineLength (100 lines)
     */
    static class Escaped extends BaseScalar {

        /**
         * Original unescaped scalar.
         */
        private final Scalar original;

        /**
         * Ctor.
         * @param original Unescaped scalar.
         */
        Escaped(final Scalar original) {
            this.original = original;
        }

        @Override
        public String value() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Comment comment() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Checks if a value (String scalar) needs escaping or not.
         * @param value Value to check.
         * @return True if it needs to be escaped, false otherwise.
         * @checkstyle ReturnCount (100 lines)
         */
        public boolean needsEscaping(final String value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
