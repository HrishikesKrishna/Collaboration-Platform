package com.hk.AirChatMiddleWare.Controllers;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import com.hk.AirChatBackEnd.Models.Message;
import com.hk.AirChatBackEnd.Models.OutputMessage;

@RestController
public class ChatController {
	@MessageMapping("/chat")
	@SendTo("/topic/message")
	public OutputMessage sendMessage(Message message)
	{
		return new OutputMessage(message,new Date());
	}
}
