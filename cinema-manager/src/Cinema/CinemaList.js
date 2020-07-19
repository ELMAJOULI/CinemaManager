import React from "react";
import { withRouter } from "react-router-dom";

const CinemaList = (props) => {
  const { selectedCinema, cinemas, onClick } = props;
  return (
    <ul className="cinemaList" onClick={onClick}>
      {cinemas.map((cinema, index) => (
        <li
          value={cinema._links.self.href.split("/")[4]}
          className={
            Number(cinema._links.self.href.split("/")[4]) === selectedCinema
              ? "cinemaSelected"
              : "cinema"
          }
          key={cinema._links.self.href.split("/")[4]}
        >
          {cinema.name}
        </li>
      ))}
    </ul>
  );
};
export default withRouter(CinemaList);
