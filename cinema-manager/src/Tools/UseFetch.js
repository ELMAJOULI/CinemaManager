import { useEffect, useState } from "react";
import axios from "axios";
export const useFetch = (url) => {
  const [data, setData] = useState(null);
  const fetch = async () => {
    try {
      const { data: resp } = await axios.get(url);
      if ("_embedded" in resp) setData(resp._embedded);
      else setData(resp);
    } catch (err) {
      // setData(err.message);
    }
  };

  useEffect(() => {
    fetch();
  }, [url]);
  return data;
};
