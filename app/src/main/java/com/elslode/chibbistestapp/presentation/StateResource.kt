package com.elslode.chibbistestapp.presentation

class StateResource<out T>(val status: State, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T?): StateResource<T> { return StateResource(State.SUCCESS, data, null)
        }
        fun <T> error(msg:String, data:T?): StateResource<T> {return StateResource(State.ERROR, data, msg)
        }

        fun <T> loading(data:T?): StateResource<T> {return StateResource(State.LOADING, data, null)
        }
    }

}