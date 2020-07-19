package com.elmajouli.moviestore.model;

import com.elmajouli.moviestore.entities.Cinema;
import lombok.*;

@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomModel {
private String name;
private Integer placeNumber;
private Cinema cinema;
}
