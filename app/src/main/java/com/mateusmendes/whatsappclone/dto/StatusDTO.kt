package com.mateusmendes.whatsappclone.dto

import com.mateusmendes.whatsappclone.model.Status
import com.mateusmendes.whatsappclone.model.User

class StatusDTO(
    val owner: User
) {
    private val statusList = ArrayList<Status>()
    private var position = 0
    private var visualizedPosition = 0

    fun addStatus(status: Status) {
        statusList.add(status)
    }

    fun getPosition(): Int {
        return position
    }

    fun getVisualizedPosition(): Int {
        return visualizedPosition
    }

    fun getNewStatusCount(): Int {
        return statusList.size - visualizedPosition
    }

    fun hasNewStatus(): Boolean {
        return getNewStatusCount() > 0
    }

    fun getPrevius(): Status {
        position--

        if(position < 0){
            position+= statusList.size
        }

        return statusList[position]
    }

    fun getNext(): Status {
        position++

        if(position >= statusList.size){
            position-= statusList.size
        } else {
            visualizedPosition++
        }

        return statusList[position]
    }

    fun lastStatus(): Status {
        return statusList.last()
    }
}