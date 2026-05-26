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

import javax.json.JsonObject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 * A Yaml mapping.
 * @checkstyle ExecutableStatementCount (300 lines)
 * @checkstyle ReturnCount (1000 lines)
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 1.0.0
 */
public interface YamlMapping extends YamlNode {

    /**
     * Return the keys' set of this mapping.<br><br>
     * @return Set of YamlNode keys.
     */
    Set<YamlNode> keys();

    /**
     * Get the YamlNode mapped to the specified key.
     * @param key YamlNode key. Could be a simple scalar,
     *  a YamlMapping or a YamlSequence.
     * @return The found YamlNode or null if nothing is found.
     */
    YamlNode value(final YamlNode key);

    /**
     * Fetch the values of this mapping.
     * @return Collection of {@link YamlNode}
     */
    default Collection<YamlNode> values() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get the Yaml mapping associated with the given key.
     * @param key String key
     * @return Yaml mapping or null if the key is missing, or not pointing
     *  to a mapping.
     */
    default YamlMapping yamlMapping(final String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get the Yaml mapping associated with the given key.
     * @param key Yaml node (mapping or sequence) key
     * @return Yaml mapping or null if the key is missing, or not pointing
     *  to a mapping.
     */
    default YamlMapping yamlMapping(final YamlNode key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get the Yaml sequence associated with the given key.
     * @param key String key
     * @return Yaml sequence or null if the key is missing, or not pointing
     *  to a sequence.
     */
    default YamlSequence yamlSequence(final String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get the Yaml sequence associated with the given key.
     * @param key Yaml node (mapping or sequence) key
     * @return Yaml sequence or null if the key is missing, or not pointing
     *  to a sequence
     */
    default YamlSequence yamlSequence(final YamlNode key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get the String associated with the given key.
     * @param key String key
     * @return String or null if the key is missing, or not pointing
     *  to a scalar.
     */
    default String string(final String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get the String associated with the given key.
     * @param key Yaml node key
     * @return String or null if the key is missing, or not pointing
     *  to a scalar.
     */
    default String string(final YamlNode key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get the String folded block scalar associated with the given key.
     * @param key String key
     * @return String or null if the key is missing, or not pointing
     *  to a folded block scalar.
     */
    default String foldedBlockScalar(final String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get the String folded block scalar associated with the given key.
     * @param key Yaml node key.
     * @return String or null if the key is missing, or not pointing
     *  to a folded block scalar.
     */
    default String foldedBlockScalar(final YamlNode key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get the String lines of the literal block scalar associated
     * with the given key.
     * @param key String key
     * @return Collection of String or null if the key is missing,
     *  or not pointing to a literal block scalar.
     */
    default Collection<String> literalBlockScalar(final String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get the String lines of the literal block scalar associated
     * with the given key.
     * @param key String key
     * @return Collection of String or null if the key is missing,
     *  or not pointing to a literal block scalar.
     */
    default Collection<String> literalBlockScalar(final YamlNode key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get the YamlNode mapped to the specified key.
     * @param key String key.
     * @return The found YamlNode or null if nothing is found.
     */
    default YamlNode value(final String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convenience method to directly read an integer value
     * from this map. It is equivalent to:
     * <pre>
     *     YamlMapping map = ...;
     *     int value = Integer.parseInt(map.string(...));
     * </pre>
     * @param key The key of the value.
     * @return Found integer or -1 if there is no value for the key,
     *  or the value is not a Scalar.
     * @throws NumberFormatException - if the Scalar value
     *  is not a parsable integer.
     */
    default int integer(final String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convenience method to directly read an integer value
     * from this map. It is equivalent to:
     * <pre>
     *     YamlMapping map = ...;
     *     int value = Integer.parseInt(map.string(...));
     * </pre>
     * @param key The key of the value.
     * @return Found integer or -1 if there is no value for the key,
     *  or the value is not a Scalar.
     * @throws NumberFormatException - if the Scalar value
     *  is not a parsable integer.
     */
    default int integer(final YamlNode key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convenience method to directly read a float value
     * from this map. It is equivalent to:
     * <pre>
     *     YamlMapping map = ...;
     *     float value = Float.parseFloat(map.string(...));
     * </pre>
     * @param key The key of the value.
     * @return Found float or -1 if there is no value for the key,
     *  or the value is not a Scalar.
     * @throws NumberFormatException - if the Scalar value
     *  is not a parsable float.
     */
    default float floatNumber(final String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convenience method to directly read a float value
     * from this map. It is equivalent to:
     * <pre>
     *     YamlMapping map = ...;
     *     float value = Float.parseFloat(map.string(...));
     * </pre>
     * @param key The key of the value.
     * @return Found float or -1 if there is no value for the key,
     *  or the value is not a Scalar.
     * @throws NumberFormatException - if the Scalar value
     *  is not a parsable float.
     */
    default float floatNumber(final YamlNode key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convenience method to directly read a double value
     * from this map. It is equivalent to:
     * <pre>
     *     YamlMapping map = ...;
     *     double value = Double.parseDouble(map.string(...));
     * </pre>
     * @param key The key of the value.
     * @return Found double or -1.0 if there is no value for the key,
     *  or the value is not a Scalar.
     * @throws NumberFormatException - if the Scalar value
     *  is not a parsable double.
     */
    default double doubleNumber(final String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convenience method to directly read a double value
     * from this map. It is equivalent to:
     * <pre>
     *     YamlMapping map = ...;
     *     double value = Double.parseDouble(map.string(...));
     * </pre>
     * @param key The key of the value.
     * @return Found double or -1.0 if there is no value for the key,
     *  or the value is not a Scalar.
     * @throws NumberFormatException - if the Scalar value
     *  is not a parsable double.
     */
    default double doubleNumber(final YamlNode key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convenience method to directly read a long value
     * from this map. It is equivalent to:
     * <pre>
     *     YamlMapping map = ...;
     *     long value = Long.parseLong(map.string(...));
     * </pre>
     * @param key The key of the value.
     * @return Found long or -1L if there is no value for the key,
     *  or the value is not a Scalar.
     * @throws NumberFormatException - if the Scalar value
     *  is not a parsable long.
     */
    default long longNumber(final String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convenience method to directly read a long value
     * from this map. It is equivalent to:
     * <pre>
     *     YamlMapping map = ...;
     *     long value = Long.parseLong(map.string(...));
     * </pre>
     * @param key The key of the value.
     * @return Found long or -1L if there is no value for the key,
     *  or the value is not a Scalar.
     * @throws NumberFormatException - if the Scalar value
     *  is not a parsable long.
     */
    default long longNumber(final YamlNode key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convenience method to directly read a LocalDate value
     * from this map. It is equivalent to:
     * <pre>
     *     YamlMapping map = ...;
     *     LocalDate date = LocalDate.parse(map.string(...));
     * </pre>
     * @param key The key of the value.
     * @return Found LocalDate or null if there is no value for the key,
     *  or the value is not a Scalar.
     * @throws DateTimeParseException - if the Scalar value cannot be parsed.
     */
    default LocalDate date(final String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convenience method to directly read a LocalDate value
     * from this map. It is equivalent to:
     * <pre>
     *     YamlMapping map = ...;
     *     LocalDate date = LocalDate.parse(map.string(...));
     * </pre>
     * @param key The key of the value.
     * @return Found LocalDate or null if there is no value for the key,
     *  or the value is not a Scalar.
     * @throws DateTimeParseException - if the Scalar value cannot be parsed.
     */
    default LocalDate date(final YamlNode key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convenience method to directly read a LocalDateTime value
     * from this map. It is equivalent to:
     * <pre>
     *     YamlMapping map = ...;
     *     LocalDateTime dateTime = LocalDateTime.parse(map.string(...));
     * </pre>
     * @param key The key of the value.
     * @return Found LocalDateTime or null if there is no value for the key,
     *  or the value is not a Scalar.
     * @throws DateTimeParseException - if the Scalar value cannot be parsed.
     */
    default LocalDateTime dateTime(final String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convenience method to directly read a LocalDateTime value
     * from this map. It is equivalent to:
     * <pre>
     *     YamlMapping map = ...;
     *     LocalDateTime dateTime = LocalDateTime.parse(map.string(...));
     * </pre>
     * @param key The key of the value.
     * @return Found LocalDateTime or null if there is no value for the key,
     *  or the value is not a Scalar.
     * @throws DateTimeParseException - if the Scalar value cannot be parsed.
     */
    default LocalDateTime dateTime(final YamlNode key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convenience method to directly read a boolean value
     * from this map. Returns true if the value is not null and is equal,
     * ignoring case, to the string "true".
     * It is equivalent to:
     * <pre>
     *     YamlMapping map = ...;
     *     boolean value = Boolean.valueOf(map.string(...));
     * </pre>
     * @param key The key of the value.
     * @return Boolean.
     */
    default boolean bool(final String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convenience method to directly read a boolean value
     * from this map. Returns true if the value is not null and is equal,
     * ignoring case, to the string "true".
     * It is equivalent to:
     * <pre>
     *     YamlMapping map = ...;
     *     boolean value = Boolean.parseBoolean(map.string(...));
     * </pre>
     * @param key The key of the value.
     * @return Boolean.
     */
    default boolean bool(final YamlNode key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    default List<YamlNode> children() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Turn this YamlMapping to a JsonObject.
     * @return JsonObject.
     */
    default JsonObject toJsonObject() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Turn this YamlMapping to a given Object type ("loading").
     * @param clazz Class type of the Object into which this YamlMapping should
     *  be loaded.
     * @param <T> Type of the Object,
     * @return Object into which this YamlMapping is loaded.
     * @todo #323:60min Implement this method similarly to toJsonObject(),
     *  using a visitor.
     */
    default <T> T toObject(final Class<T> clazz) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
