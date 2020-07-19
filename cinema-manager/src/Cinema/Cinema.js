import React, { useState } from "react";
import { withRouter, useRouteMatch } from "react-router-dom";
import CinemaList from "./CinemaList";
import { useFetch } from "../Tools/UseFetch";
import { URL } from "../Tools/Constants";
import Spinner from "../Tools/Spinner.svg";
import { MovieList } from "./MoiveList";
const Cinema = (props) => {
  const match = useRouteMatch();
  const dataCinema = useFetch(`${URL}${match.url}`);
  const [selectedCinema, setSelectedCinema] = useState(-1);
  const roomsData = useFetch(
    `${URL}/controller/cinemas/${selectedCinema}/rooms`
  );

  const [SpinnerOrError] = useState(
    <img src={Spinner} alt={"Spinner"} />
  );
 
  console.log(roomsData);
  if (!dataCinema) {
    return <div>{SpinnerOrError}</div>;
  }

  const onClickCinema = (e) => {
    const id = Number(e.target.value);
    setSelectedCinema(id);
  };
  if (roomsData)
    return (
      <div className="cinema-grid">
        <div className="cinema-grid-list">
          <CinemaList
            cinemas={dataCinema.cinemas}
            selectedCinema={selectedCinema}
            onClick={onClickCinema}
          />
        </div>
        <div className="cinema-grid-data">
          <MovieList propRoomsData={roomsData} />
        </div>
      </div>
    );
  return (
    <div className="cinema-grid">
      <div className="cinema-grid-list">
        <CinemaList
          cinemas={dataCinema.cinemas}
          selectedCinema={selectedCinema}
          onClick={onClickCinema}
        />
      </div>
      <div className="cinema-grid-data">
        <h2>Welcome !</h2>
      </div>
    </div>
  );
};
export default withRouter(Cinema);
