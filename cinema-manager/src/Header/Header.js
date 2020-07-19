import React from "react";
import { withRouter } from "react-router-dom";

const Header = ({ history }) => {
  return (
    <header>
      <div className={"header"}>
        <button className={"btn btn-burgger"}>&#9776;</button>
        <h2
          className="brand-name"
          onClick={() => {
            history.push("/");
          }}
        >
          ELMAJOULI
        </h2>
        <h4><a className="brand-name" href="http://localhost:8080/secured/addMovie">Admministration</a></h4>
      </div>
    </header>
  );
};

export default withRouter(Header);
