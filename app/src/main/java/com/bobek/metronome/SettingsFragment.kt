/*
 * This file is part of Metronome.
 * Copyright (C) 2023 Philipp Bobek <philipp.bobek@mailbox.org>
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

package com.bobek.metronome

import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.Preference.SummaryProvider
import androidx.preference.PreferenceDialogFragmentCompat
import androidx.preference.PreferenceFragmentCompat
import ch.poole.android.numberpickerpreference.NumberPickerPreference
import ch.poole.android.numberpickerpreference.NumberPickerPreferenceFragment
import com.bobek.metronome.preference.PreferenceConstants

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)

        findPreference<Preference>(PreferenceConstants.VERSION)?.summaryProvider =
            SummaryProvider<Preference> { BuildConfig.VERSION_NAME }
    }

    companion object {
        private const val DIALOG_FRAGMENT_TAG = "androidx.preference.PreferenceFragment.DIALOG";
    }

    override fun onDisplayPreferenceDialog(preference: Preference) {
        var f: PreferenceDialogFragmentCompat? = null;

        if (preference is NumberPickerPreference) {
            f = NumberPickerPreferenceFragment.newInstance(preference.getKey())
        }

        if (f != null) {
            f.setTargetFragment(this, 0)
            f.show(getParentFragmentManager(), DIALOG_FRAGMENT_TAG)
        } else {
            super.onDisplayPreferenceDialog(preference);
        }
    }
}
