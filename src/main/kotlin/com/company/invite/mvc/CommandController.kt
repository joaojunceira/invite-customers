package com.company.invite.mvc

interface CommandController {
    fun execute(requestModel: RequestModel): MessageView
}