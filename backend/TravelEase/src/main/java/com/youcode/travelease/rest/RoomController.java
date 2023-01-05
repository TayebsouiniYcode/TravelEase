package com.youcode.travelease.rest;

import com.youcode.travelease.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room")
public class RoomController {
    @Autowired
    private RoomService roomService;
}
