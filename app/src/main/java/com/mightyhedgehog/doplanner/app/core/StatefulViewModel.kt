package com.mightyhedgehog.doplanner.app.core

abstract class StatefulViewModel<Event : Any> : AutoObserverViewModel(), EventHandler<Event>
