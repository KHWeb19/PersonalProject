import {
  FETCH_ALBUM_LIST,
  FETCH_ALBUM,
  FETCH_BOARD_LIST,
  FETCH_BOARD,
  CRAWL_START,

  //FETCH_SESSION
} from "./mutation-types";

import axios from "axios";

export default {
  fetchAlbumList({ commit }) {
    return axios.get("http://localhost:7777/vuealbum/lists").then((res) => {
      commit(FETCH_ALBUM_LIST, res.data);
    });
  },
  fetchAlbum({ commit }, albumNo) {
    return axios
      .get(`http://localhost:7777/vuealbum/${albumNo}`)
      .then((res) => {
        commit(FETCH_ALBUM, res.data);
      });
  },

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
  // 크롤링
  async crawlFind({ commit }, category) {
    axios
      .get("http://localhost:7777/daumCrawler" + `/${category}`)
      .then(({ data }) => {
        commit(CRAWL_START, data);
      });
  },
  //fetchSession ({ commit }) {
  //    commit(FETCH_SESSION)
  //}
};
