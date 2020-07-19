import React from "react";
import { FaStar } from "react-icons/fa";
import _ from "lodash";
const Star = (props) => {
  const starNumber = _.range(0, 6);
  const rate = props.rate;
  return (
    <div>
      {starNumber.map((num) => (
        <FaStar key={num} size={25} color={num < rate ? "#e1f715" : "#ccc"} />
      ))}
    </div>
  );
};
export default Star;
