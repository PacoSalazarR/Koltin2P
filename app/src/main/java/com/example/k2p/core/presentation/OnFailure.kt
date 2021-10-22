package com.example.k2p.core.presentation

import com.example.k2p.core.exception.Failure

interface OnFailure {
    fun handleFailure(failure: Failure?)
}