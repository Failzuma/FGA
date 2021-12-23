package com.mathewsachin.libautomata.extensions

import com.mathewsachin.libautomata.Location
import com.mathewsachin.libautomata.Match
import com.mathewsachin.libautomata.Pattern
import com.mathewsachin.libautomata.Region
import kotlin.time.Duration

interface IAutomataExtensions {
    /**
     * Gets the image content of this Region.
     *
     * @return an [Pattern] object with the image data
     */
    fun Region.getPattern(): Pattern

    fun <T> useSameSnapIn(block: () -> T): T

    fun <T> useColor(block: () -> T): T

    fun Duration.wait()

    fun Location.click(times: Int = 1)

    fun Region.click(times: Int = 1) = center.click(times)

    operator fun Region.contains(image: Pattern) = exists(image)

    fun Region.find(
        pattern: Pattern,
        similarity: Double? = null
    ): Match? = findAll(pattern, similarity).firstOrNull()

    fun Region.exists(
        image: Pattern,
        timeout: Duration = Duration.ZERO,
        similarity: Double? = null
    ): Boolean

    fun Region.waitVanish(
        image: Pattern,
        timeout: Duration,
        similarity: Double? = null
    ): Boolean

    fun Region.findAll(
        pattern: Pattern,
        similarity: Double? = null
    ): Sequence<Match>
}