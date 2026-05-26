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

import javax.json.JsonArray;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * A YAML Stream of documents. Documents are separated by 3 dashes (---).<br>
 * This interface also offers integrations with Java 8's Stream API.<br>
 * All the methods have a default implementations based on the YamlNode
 * values Collection.
 *
 * @checkstyle FinalParameters (400 lines)
 * @checkstyle JavadocMethod (400 lines)
 * @checkstyle LineLength (400 lines)
 * @checkstyle ParameterName (400 lines)
 * @checkstyle FinalParameters (400 lines)
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 3.1.1
 */
public interface YamlStream extends YamlNode, Stream<YamlNode> {

    /**
     * Fetch the values from this stream.
     * @return Collection of {@link YamlNode}
     */
    Collection<YamlNode> values();

    @Override
    default List<YamlNode> children() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default Comment comment() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default Iterator<YamlNode> iterator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default Spliterator<YamlNode> spliterator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default boolean isParallel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default Stream<YamlNode> sequential() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default Stream<YamlNode> parallel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default Stream<YamlNode> unordered() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default Stream<YamlNode> onClose(Runnable closeHandler) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default Stream<YamlNode> filter(Predicate<? super YamlNode> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <R> Stream<R> map(Function<? super YamlNode, ? extends R> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default IntStream mapToInt(ToIntFunction<? super YamlNode> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default LongStream mapToLong(ToLongFunction<? super YamlNode> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default DoubleStream mapToDouble(ToDoubleFunction<? super YamlNode> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <R> Stream<R> flatMap(Function<? super YamlNode, ? extends Stream<? extends R>> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default IntStream flatMapToInt(Function<? super YamlNode, ? extends IntStream> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default LongStream flatMapToLong(Function<? super YamlNode, ? extends LongStream> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default DoubleStream flatMapToDouble(Function<? super YamlNode, ? extends DoubleStream> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default Stream<YamlNode> distinct() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default Stream<YamlNode> sorted() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default Stream<YamlNode> sorted(Comparator<? super YamlNode> comparator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default Stream<YamlNode> peek(Consumer<? super YamlNode> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default Stream<YamlNode> limit(long maxSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default Stream<YamlNode> skip(long n) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default void forEach(Consumer<? super YamlNode> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default void forEachOrdered(Consumer<? super YamlNode> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default Object[] toArray() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <A> A[] toArray(IntFunction<A[]> generator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default YamlNode reduce(YamlNode identity, BinaryOperator<YamlNode> accumulator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default Optional<YamlNode> reduce(BinaryOperator<YamlNode> accumulator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <U> U reduce(U identity, BiFunction<U, ? super YamlNode, U> accumulator, BinaryOperator<U> combiner) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super YamlNode> accumulator, BiConsumer<R, R> combiner) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <R, A> R collect(Collector<? super YamlNode, A, R> collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default Optional<YamlNode> min(Comparator<? super YamlNode> comparator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default Optional<YamlNode> max(Comparator<? super YamlNode> comparator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default long count() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default boolean anyMatch(Predicate<? super YamlNode> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default boolean allMatch(Predicate<? super YamlNode> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default boolean noneMatch(Predicate<? super YamlNode> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default Optional<YamlNode> findFirst() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default Optional<YamlNode> findAny() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Turn this YamlSequence to a JsonArray.
     * @return JsonArray.
     */
    default JsonArray toJsonArray() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
