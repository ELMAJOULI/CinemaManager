import React, { useState } from "react";
import Star from "./Star";
import _ from "lodash";
import axios from "axios";
import {produce} from "immer";
export const MovieList = ({ propRoomsData }) => {
  const [roomsData,setRoomsData] = useState([...propRoomsData])
  const [requieredInputError, setRequieredInputError] = useState();
  const [projectionIndex,setProjectionIndex] =  useState(0);
  const [selectedSeats, setSelectedSeats] = useState([]);
  const [nameInput,setNameInput] = useState("");
  const [CardCodeInput,setCodeCardInput] = useState("");
  const [roomIndex,setRoomIndex] = useState();
  console.log(roomsData);
  const seanceHandler = e => {
     setProjectionIndex(Number(e.target.value));
     setSelectedSeats([]);
  }
  const ticketHandler = e => {
    const seatNumber = Number(e.target.value);
    const index = _.indexOf(selectedSeats,seatNumber);
    if(index === -1)
    setSelectedSeats(pv => _.concat(pv,seatNumber));
    else setSelectedSeats(pv => _.difference(pv,[seatNumber]))
  }
  const purchaseHandler = e => {
    setRoomIndex(Number(e.target.value));
  }
  const submitHandler  = e => {
    e.preventDefault();
    if(!nameInput || !CardCodeInput){
      setRequieredInputError((<span>* Please fulfil the requiered information!</span>))        
      return;
    }
    console.log(nameInput);
    console.log(CardCodeInput);
    const data = [];
    const roomsDataCopie = produce(roomsData,draft =>{
        selectedSeats.forEach(ticket => {
      draft[roomIndex].movieProjections[projectionIndex].tickets[ticket].clientName = nameInput;
      draft[roomIndex].movieProjections[projectionIndex].tickets[ticket].codePayment = CardCodeInput;
      draft[roomIndex].movieProjections[projectionIndex].tickets[ticket].reserved = true;
      draft[roomIndex].movieProjections[projectionIndex].tickets[ticket].movieProjection = roomsData[roomIndex].movieProjections[projectionIndex];
  });
});

      selectedSeats.forEach(ticket=> {
      data.push(roomsDataCopie[roomIndex].movieProjections[projectionIndex].tickets[ticket]);
      });

    console.log(data);
    axios.post("http://localhost:8080/controller/purchase",data);
    setCodeCardInput("");
    setNameInput("");
    setRequieredInputError("");
    setRoomsData(roomsDataCopie);
  }
 
  return (
    <ul className="movie-data-list">
      {roomsData.map((data,roomIndex) => {
        if (data.movieProjections[0])
          return (
            <li key={data.id}>
              <div className="container-room">
                <h3 className="room-movie">
                  {data.name} : {data.movieProjections[0].movie.title}
                </h3>
                <div className="movie-container">
                 <div className="movie-img-star">
                 <img
                    className="movie-image"
                    src={data.movieProjections[0].movie.poster}
                    alt={data.movieProjections[0].movie.title}
                  />
                   <Star rate={3} />
                 </div>
                  
                  <div className="movie-details-container">
                    <h3 className="movie-title">
                      {data.movieProjections[0].movie.title}
                    </h3>
                    <div className="movie-details-description">
                      {data.movieProjections[0].movie.details}
                    </div>
                    <div className="movie-details-meta-container">
                      <div className="movie-details-meta-left">
                        <div className="movie-genre">
                          <span className="bold">Genre : </span>
                          {data.movieProjections[0].movie.genre.genre}
                        </div>
                        <div className="movie-duration">
                          <span className="bold">Duration : </span>
                          {data.movieProjections[0].movie.duration} min
                        </div>
                      </div>
                      <div className="movie-details-meta-rigth">
                        <div className="movie-genre">
                          <span className="bold">director : </span>
                          {data.movieProjections[0].movie.director}
                        </div>
                        <div className="movie-duration">
                          <span className="bold">released : </span>
                          {data.movieProjections[0].movie.releaseDate}
                        </div>
                      </div>
                    </div>
                   
                  </div>
                </div>
                <div className="seance-container">
                  <ul className="seance" onClick={seanceHandler}>
                    <li className="seance-title">Seance :</li>
                  {
                    data.movieProjections.map((p,index) => {
                      return (
                    <li key={p.seance.scheduled} value={index} className={index === projectionIndex ?"seance-item seance-item-selected" :"seance-item"}>
                      {p.seance.scheduled} Price {p.price}Dh
                    </li>
                      )
                    })
                  }
                  </ul>
                  <div className="seat-container">
                    {
                      data.movieProjections[projectionIndex].tickets.map((ticket,ticketIndex)  => {
                      return(<button key={ticket.id} value={ticketIndex} disabled={ticket.reserved} onClick={ticketHandler} className={ticket.reserved ? "btn btn-seat-reserved" : _.indexOf(selectedSeats,ticketIndex)=== -1 ? "btn btn-seat" : "btn btn-seat btn-seat-selected"}>{ticket.place.number}</button>)
                      })
                    }
                    
                    
                  </div>
                  <form className="ticket-form" onSubmit={submitHandler}>
                    <label className="purchase-label" htmlFor="name" >Name : </label>
                    <input className="purchase-input" type="text" name="name" value={nameInput} onChange={e => setNameInput(e.target.value)} id="name" placeholder="Your Name ..."/>
                    <label className="purchase-label"htmlFor="cardNumber" >Card Number: </label>
                    <input className="purchase-input" type="number" name="cardNumber" value={CardCodeInput} onChange={e  => setCodeCardInput(e.target.value)} id="cardNumber" placeholder="Card Number..."/>
                 <button type="submit" value={roomIndex} disabled={_.isEmpty(selectedSeats)} onClick={purchaseHandler} className="btn btn-purchase">Purchase</button>
                  {requieredInputError}
                  </form>
                 </div>
              </div>
            </li>
          );
      })}
    </ul>
  );
};
