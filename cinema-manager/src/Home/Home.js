import React, { useState } from "react";
import { useFetch } from "../Tools/UseFetch";
import { URL, GET_CITIES } from "../Tools/Constants";
import Spinner from "../Tools/Spinner.svg";
import { withRouter } from "react-router-dom";

const Home = ({ history }) => {
  const citiesData = useFetch(`${URL}/${GET_CITIES}`);
  const [SpinnerOrError, setSpinnerOrError] = useState(
    <img src={Spinner} alt={"Spinner"} />
  );

  if (!citiesData) {
    return <div>{SpinnerOrError}</div>;
  }
  console.log(citiesData);
  return (
    <ul className="container">
      {citiesData.cities.map((city) => (
        <li
          key={city.name}
          className="contents"
          onClick={() => {
            history.push(
              "/cities/" + city._links.cinema.href.split("/")[4] + "/cinema"
            );
          }}
        >
          <div className="card">
            <img className="bg-image" src={city.image} />
            <h2 className="city-name">{city.name}</h2>
          </div>
        </li>
      ))}
    </ul>
  );
};
export default withRouter(Home);
