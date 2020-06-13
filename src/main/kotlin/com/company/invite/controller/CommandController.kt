package com.company.invite.controller

import com.company.invite.view.MessageView
import com.company.invite.view.RequestView

interface CommandController {
    fun execute(requestView: RequestView): MessageView
}