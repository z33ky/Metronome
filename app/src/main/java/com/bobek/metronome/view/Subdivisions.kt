/*
 * This file is part of Metronome.
 * Copyright (C) 2022 Philipp Bobek <philipp.bobek@mailbox.org>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Metronome is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.bobek.metronome.view

import androidx.databinding.InverseMethod

class Subdivisions(value: Int = MIN) {

    val value = if (value in MIN..MAX) value else MIN

    companion object {
        const val MIN = 1
        const val MAX = 8

        @InverseMethod("stringToSubdivisions")
        @JvmStatic
        fun subdivisionsToString(subdivisions: Subdivisions): String = subdivisions.value.toString()

        @JvmStatic
        fun stringToSubdivisions(string: String): Subdivisions {
            return try {
                Subdivisions(string.toInt())
            } catch (exception: NumberFormatException) {
                Subdivisions()
            }
        }

        @InverseMethod("floatToSubdivisions")
        @JvmStatic
        fun subdivisionsToFloat(subdivisions: Subdivisions): Float = subdivisions.value.toFloat()

        @JvmStatic
        fun floatToSubdivisions(float: Float): Subdivisions = Subdivisions(float.toInt())
    }

    override fun toString(): String {
        return "Subdivisions(value=$value)"
    }
}
