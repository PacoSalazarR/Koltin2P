package com.example.k2p.core.platform

import android.content.Context
import com.example.k2p.core.extension.networkInfo
import javax.inject.Inject

/**
 * Created by Amalip on 9/29/2021.
 */

class NetworkHandler @Inject constructor(private val context: Context) {

    val isConnected get() = context.networkInfo?.isConnectedOrConnecting == true

}