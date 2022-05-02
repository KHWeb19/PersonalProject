import {
    FETCH_ALBUM_LIST,
    FETCH_ALBUM,

    FETCH_BOARD_LIST,
    FETCH_BOARD,

    // 크롤링
    CRAWL_START,

    //FETCH_SESSION
} from './mutation-types'

export default {
    [FETCH_ALBUM_LIST] (state, albums) {
        state.malbums = albums
    },
    [FETCH_ALBUM] (state, album) {
        state.album = album
    },


    [FETCH_BOARD_LIST] (state, boards) {
        state.boards = boards;
    },
    [FETCH_BOARD] (state, board) {
        state.board = board
    },
    // 크롤링
    [CRAWL_START] (state, payload) {
        state.lists = payload   
    },
    //[FETCH_SESSION] (state) {
    //    state.session = this.$cookies.get(userSession)
    //}
}