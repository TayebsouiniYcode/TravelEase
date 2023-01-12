package com.youcode.travelease.rest;

import com.youcode.travelease.dto.FindRoomForm;
import com.youcode.travelease.entity.Room;
import com.youcode.travelease.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/room")
@CrossOrigin("http://localhost:4051")
@RequiredArgsConstructor
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/{idRoom}")
    public Room getRoomById(@PathVariable Long idRoom) {
        return roomService.getRoomById ( idRoom );
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return this.roomService.getAllRooms();
    }

    @PostMapping("/disponible")
    public List<Room> getDisponibleRooms(@RequestBody FindRoomForm findRoomForm) {
        return roomService.getDisponibleRoom(findRoomForm);
    }

}
