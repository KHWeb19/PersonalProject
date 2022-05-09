import {
  FETCH_BOARD_LIST,
  FETCH_BOARD,

  //FETCH_SESSION
} from "./mutation-types";

import axios from "axios";

export default {
  fetchBoardList({ commit }) {
    return axios.get("http://localhost:7777/board/list").then((res) => {
      commit(FETCH_BOARD_LIST, res.data);
    });
  },
  fetchBoard({ commit }, boardNo) {
    return axios.get(`http://localhost:7777/board/${boardNo}`).then((res) => {
      commit(FETCH_BOARD, res.data);
    });
  },
};
