/*
 * Copyright (c) 2022-2022 Balázs Püspök-Kiss (Illyan)
 * Jay is a driver behaviour analytics app.
 * This file is part of Jay.
 * Jay is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * Jay is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with Jay. If not, see <https://www.gnu.org/licenses/>.
 */

package illyan.jay.ui.toggle.service

import illyan.jay.domain.interactor.ServiceInteractor
import javax.inject.Inject

class ServiceTogglePresenter @Inject constructor(
    private val serviceInteractor: ServiceInteractor
) {
    fun startService() = serviceInteractor.startJayService()
    fun stopService() = serviceInteractor.stopJayService()
    fun isJayServiceRunning() = serviceInteractor.isJayServiceRunning()
    fun addJayServiceStateListener(listener: (isRunning: Boolean, name: String) -> Unit) =
        serviceInteractor.addServiceStateListener(listener)
}