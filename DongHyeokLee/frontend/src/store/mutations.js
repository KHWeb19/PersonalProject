import {
    //자유게시판
    FETCH_FREE_BOARD_LIST,
    FETCH_FREE_BOARD,
    FETCH_FREE_BOARD_COMMENTS_LIST,
    //사진게시판
    FETCH_PHOTO_BOARD_LIST,
    FETCH_PHOTO_BOARD
    
} from './mutation-types'

export default {
    //자유게시판
    [FETCH_FREE_BOARD_LIST] (state, freeBoards) {
        state.freeBoards = freeBoards
    },
    [FETCH_FREE_BOARD] (state, freeBoard) {
        state.freeBoard = freeBoard
    },
    [FETCH_FREE_BOARD_COMMENTS_LIST] (state, freeBoardComments) {
        state.freeBoardComments = freeBoardComments
    },
    //사진게시판
    [FETCH_PHOTO_BOARD_LIST] (state, photoBoards) {
        state.photoBoards = photoBoards
    },
    [FETCH_PHOTO_BOARD] (state, photoBoard) {
        state.photoBoard = photoBoard
    },
}