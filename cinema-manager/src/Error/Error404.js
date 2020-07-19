import React from "react";
import { Link } from "react-router-dom";
import "./Error404.css";

export const Error404 = (prosp) => {
  return (
    <div className="notfoundId">
      <div className="notfound">
        <div className="notfound-404">
          <h1>Oops!</h1>
          <h2>404 - The Page can't be found</h2>
        </div>
        <Link className="link" to={"/"}>
          Go TO Homepage{" "}
        </Link>
      </div>
    </div>
  );
};
