/*
 * This file is part of Metronome.
 * Copyright (C) 2023 Alexander Hirsch <1zeeky@gmail.com>
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

package com.bobek.metronome.data

import androidx.databinding.InverseMethod

data class TempoTapAmount(val value: Int = DEFAULT) {

    init {
        require(value in MIN..MAX) { "value must be between $MIN and $MAX but was $value" }
    }

    companion object {
        const val MIN = 2
        const val MAX = 8
        const val DEFAULT = 4

        @InverseMethod("floatToTempoTapAmount")
        @JvmStatic
        fun tempoTapAmountToFloat(tempoTapAmount: TempoTapAmount): Float = tempoTapAmount.value.toFloat()

        @JvmStatic
        fun floatToTempoTapAmount(float: Float): TempoTapAmount = TempoTapAmount(float.toInt())
    }
}

