package com.mightyhedgehog.doplanner.app.core

import androidx.lifecycle.ViewModel

abstract class StatefulViewModel<Event : Any> : ViewModel(), EventHandler<Event>
